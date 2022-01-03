package me.ionar.salhack.module.ui;

import me.ionar.salhack.events.player.EventPlayerUpdate;
import me.ionar.salhack.module.Module;
import me.zero.alpine.fork.listener.EventHandler;
import me.zero.alpine.fork.listener.Listener;
import net.minecraft.client.gui.inventory.GuiChest;

public class ChestModule extends Module {

    public ChestModule()
    {
        super("Chest", new String[]{"Chest"}, "Display chest stealer button in chests.", "NONE", 0xDBB024, ModuleType.UI);
        setEnabled(true);
    }

    public boolean validGui;

    @EventHandler
    private Listener<EventPlayerUpdate> packetEventListener = new Listener<>(event -> {
        if(mc.currentScreen instanceof GuiChest) {
            validGui = true;
        } else {
            validGui = false;
        }

    });

}
