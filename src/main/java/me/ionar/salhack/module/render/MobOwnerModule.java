package me.ionar.salhack.module.render;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import me.ionar.salhack.events.entity.EventEntityAdded;
import me.ionar.salhack.events.player.EventPlayerMotionUpdate;
import me.ionar.salhack.events.player.EventPlayerUpdate;
import me.ionar.salhack.events.render.EventRenderChunk;
import me.ionar.salhack.managers.NotificationManager;
import me.ionar.salhack.module.Module;
import me.zero.alpine.fork.listener.EventHandler;
import me.zero.alpine.fork.listener.Listener;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraftforge.fml.common.Mod;

import java.io.InputStream;
import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class MobOwnerModule extends Module {

    public MobOwnerModule()
    {
        super("MobOwnerModule", new String[]
                { "MobOwner" }, "Shows the username of a mob owner.", "NONE", 0xD5DB24, ModuleType.RENDER);
    }

    private List<AbstractHorse> mobs = new ArrayList<AbstractHorse>();
    private Map<String, String> uuidToName = new HashMap<String, String>();

    @Override
    public void onEnable() {
        resetCache();
        if (mc.world == null) {
            return;
        }

        for (Entity p_Entity : mc.world.loadedEntityList) {
            if (p_Entity instanceof EntityTameable) {
                final EntityTameable entityTameable = (EntityTameable) p_Entity;
                if (entityTameable.isTamed() && entityTameable.getOwner() != null) {
                    entityTameable.setAlwaysRenderNameTag(true);
                    entityTameable.setCustomNameTag("Owner: " + entityTameable.getOwner().getDisplayName().getFormattedText());
                }
            }
            AbstractHorse horse;
            if (!(p_Entity instanceof AbstractHorse) || mobs.contains(horse = (AbstractHorse) ((Object) p_Entity)))
                continue;
            mobs.add(horse);
            UUID uuid = horse.getOwnerUniqueId();
            if (uuid == null) {
                horse.setCustomNameTag("Not tamed");
                continue;
            }
            String uuidString = uuid.toString().replace("-", "");
            String name = "";
            if (uuidToName.get(name) != null) {
                name = uuidToName.get(name);
            } else {
                try {
                    String s = requestName(uuidString);
                    assert s != null;
                    JsonElement element = new JsonParser().parse(s);
                    JsonArray array = element.getAsJsonArray();
                    if (array.size() == 0) {
                        NotificationManager.Get().AddNotification("MobOwner", "Couldn't find player name. (1)");
                    }
                    name = array.get(array.size() - 1).getAsJsonObject().get("name").getAsString();
                    uuidToName.put(uuidString, name);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    NotificationManager.Get().AddNotification("MobOwner", "Couldn't find player name. (2)");
                }
            }
            horse.setCustomNameTag("Owner: " + name);
        }
    }

    @Override
    public void onDisable() {
        uuidToName.clear();
        for (final Entity p_Entity : mc.world.loadedEntityList) {
            if (!(p_Entity instanceof EntityTameable)) {
                if (!(p_Entity instanceof AbstractHorse)) {
                    continue;
                }
            }
            try {
                p_Entity.setAlwaysRenderNameTag(false);
                System.out.println("remove");
            }
            catch (Exception ignored) {}
        }
    }

    private static String requestName(String uuid) {
        try {
            String query = "https://api.mojang.com/user/profiles/" + uuid + "/names";
            URL url = new URL(query);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("GET");
            BufferedInputStream in = new BufferedInputStream(conn.getInputStream());
            String res = convertStreamToString(in);
            ((InputStream) in).close();
            conn.disconnect();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String convertStreamToString(InputStream is) {
        Scanner s = new Scanner(is).useDelimiter("\\A");
        String r = s.hasNext() ? s.next() : "/";
        return r;
    }

    /* Periodically try to re-request invalid UUIDs */
    private static long startTime = 0;
    private void resetCache() {
        if (startTime == 0) startTime = System.currentTimeMillis();
        if (startTime + (10 * 1000) <= System.currentTimeMillis()) { // 1 requestTime = 1 second = 1000 ms
            startTime = System.currentTimeMillis();
            for (Map.Entry<String, String> entries : uuidToName.entrySet()) {
                if (entries.getKey().equalsIgnoreCase("Offline or invalid UUID!")) {
                    uuidToName.clear();
                    return;
                }
            }
        }
    }
}
