package me.ionar.salhack.module.fun;

import java.util.TimerTask;
import me.ionar.salhack.module.Module;
import me.ionar.salhack.module.Value;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Timer;
import java.util.Random;


	
//sorry for the monkey code but i couldnt get it to work with thread.sleep()
public class PartyModule extends Module {
	public final Value<Boolean> Announce = new Value<Boolean>("Announce", new String[] {"EE"}, "Announces that you are partying!", false);
	public final Value<Boolean> Rotation = new Value<Boolean>("Rotate", new String[] {"EE"}, "Equips your elytra when enabled if you're not already wearing one", false);
	public final Value<Float> RotationSpeed = new Value<Float>("Rotation Speed", new String[]
		    { "RtSpd" }, "Speed to rotate at, requires for Rotate to be on", 1.82f, -100f, 100f, 0.1f); 
	public Value<Float> Delay = new Value<Float>("Delay", new String[]
            { "ChatDelay, Wait" }, "Delay for each tick",100f, 0f, 20000f, 0f);
	boolean Rotate=true;
    private Timer timer = new Timer();
    private Timer timerRotate = new Timer();
	int chatMsg = 1;
    float chatDelay=Delay.getValue();
    long chatDelayLong = (long) chatDelay;

    public PartyModule()
	{
        super("Party", new String[]
        		{ "Party" }, "Party like its the annual Chicken Lord party!", "NONE",
        		0xDB2485, Module.ModuleType.FUN);
        
    }
    
	@Override
	public void onEnable()
	{  
		super.onEnable();
		timer = new Timer();
		timerRotate = new Timer();
		if (Announce.getValue()) {

    	timer.scheduleAtFixedRate(new TimerTask()
    	{
        	@Override
        	public void run()
        	{	
        		float chatDelay=Delay.getValue();
        		if (chatMsg==1) {
        			mc.player.sendChatMessage("Im partying! Care to join?");
        		}
        		if (chatMsg==2) {
        			mc.player.sendChatMessage("cope");
        		}
        		
        		if (chatMsg==3) {
        			chatMsg=0;
        			mc.player.sendChatMessage("larp");
        		}
    			chatMsg++;
        	}
    	}, 0, chatDelayLong*10);
	}
	
		if (Rotation.getValue()) {

    	timerRotate.scheduleAtFixedRate(new TimerTask()
    	{
        	@Override
        	public void run()
        	{        		
        		mc.player.cameraYaw=mc.player.cameraYaw-(RotationSpeed.getValue()*2);
        		mc.player.rotationYaw=mc.player.prevRotationYaw+RotationSpeed.getValue();
        	}
    	}, 0, 100);
	}
    }
	
	@Override
	   public void onDisable()
	   {
		super.onDisable();

        if (timer != null)
            timer.cancel();
        	timerRotate.cancel();
	   }
}
    
    

