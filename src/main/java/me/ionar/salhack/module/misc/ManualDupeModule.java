package me.ionar.salhack.module.misc;

import me.ionar.salhack.module.Module;
import net.minecraft.client.gui.inventory.GuiScreenHorseInventory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.AbstractChestHorse;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.util.EnumHand;

import java.util.Comparator;

public class ManualDupeModule extends Module {

    public ManualDupeModule() {
        super("ManualDupe", new String[] {""}, "For dupe button, disregard.", "NONE", -1, ModuleType.MISC);
    }

    private boolean noBypass;

    @Override
    public void onEnable() {

        super.onEnable();

        Entity l_Entity = mc.world.loadedEntityList.stream()
                .filter(p_Entity -> isValidEntity(p_Entity))
                .min(Comparator.comparing(p_Entity -> mc.player.getDistance(p_Entity)))
                .orElse(null);

        if(mc.currentScreen instanceof GuiScreenHorseInventory && l_Entity instanceof AbstractChestHorse && mc.player.getRidingEntity() != null) {
            AbstractChestHorse abstractChestHorse = (AbstractChestHorse) l_Entity;

            if(abstractChestHorse.hasChest()) {
                noBypass = true;
                mc.player.connection.sendPacket(new CPacketUseEntity(l_Entity, EnumHand.MAIN_HAND, l_Entity.getPositionVector()));
                noBypass = false;
                toggle();
            }

        }

    }

    private boolean isValidEntity(Entity entity)
    {
        if (entity instanceof AbstractChestHorse) {
            AbstractChestHorse l_AbstractChestHorse = (AbstractChestHorse) entity;

            if (!l_AbstractChestHorse.isChild() && l_AbstractChestHorse.isTame())
                return true;
        }
        return false;
    }

    public boolean ignoreMountBypass() { //tell mount bypass when to disable
        return noBypass;
    }

}
