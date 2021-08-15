package me.ionar.salhack.module.chat;

import me.ionar.salhack.module.Module;


import java.util.Random;
import java.util.Random;

public class ChickenPrayerModule extends Module {

    public ChickenPrayerModule()
    {
        super("ChickenPrayer", new String[]
                        { "ChickenPrayer" }, "Pray for kits from the Great Chicken Gods", "NONE",
                0xDB2485, Module.ModuleType.CHAT);
    }

    @Override
    public void onEnable() {
        if(mc.player != null)
            mc.player.sendChatMessage("I just prayed items from the Great Chicken Gods and they granted me " +  (new Random().nextInt(30000) + 1) + " shulkers!");
        toggle();
    }
}
