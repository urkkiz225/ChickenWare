package me.ionar.salhack.module.ui;

import me.ionar.salhack.events.player.EventPlayerUpdate;
import me.ionar.salhack.module.Module;
import me.zero.alpine.fork.listener.EventHandler;
import me.zero.alpine.fork.listener.Listener;
import net.minecraft.client.gui.inventory.GuiScreenHorseInventory;

public class DupeModule extends Module {

    public DupeModule() {
        super("Dupe", new String[]{"Dupe"}, "Display dupe button when riding entities.", "NONE", 0xDBB024, ModuleType.UI);
        setEnabled(true);
    }

    public boolean validGui;

    @EventHandler
    private Listener<EventPlayerUpdate> packetEventListener = new Listener<>(event -> {
        if(mc.currentScreen instanceof GuiScreenHorseInventory) {
            validGui = true;
        } else {
            validGui = false;
        }
    });
    
}
