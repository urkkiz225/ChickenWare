package me.ionar.salhack.module.fun;

import me.ionar.salhack.gui.SalGuiScreen;
import me.ionar.salhack.module.Module;

public class AustraliaModule extends Module {
	
	private double posX, posY, posZ;
    private float pitch, yaw;
	float f1 = 5;
	private int rotation=180;

    public AustraliaModule()
    {
        super("AustraliaModule", new String[]
                        { "Australia" }, "live in australia", "NONE",
                0xDB2485, Module.ModuleType.FUN);
    }

    @Override
    public void onEnable() {
        if(mc.player != null) {
        	SalGuiScreen.UpdateRotationPitch(360);
        }
        	
    }
    
    public void onDisable() {
        if(mc.player != null) {
        }
        	
    }
}
