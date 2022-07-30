package me.ionar.salhack.module.chat;

import me.ionar.salhack.module.Module;
import java.util.Random;
import java.util.Random;

public class BokBokSexDupeModule extends Module {

    public BokBokSexDupeModule()
    {
        super("BokBokSexDupe", new String[]
                        { "BokBokSexDupe" }, "do the bokbok and get kits :flushed:", "NONE",
                0xDB2485, Module.ModuleType.CHAT);
    }

    @Override
    public void onEnable() {
        if(mc.player != null)
            mc.player.sendChatMessage("I just did the BokBok Sex Dupe and got " +  (new Random().nextInt(2147483647) + 1) + " shulkers!");
        toggle();
    }
}
