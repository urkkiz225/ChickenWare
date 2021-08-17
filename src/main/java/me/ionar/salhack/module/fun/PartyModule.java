package me.ionar.salhack.module.fun;

import java.util.TimerTask;
import me.ionar.salhack.module.Module;
import me.ionar.salhack.module.Value;
import java.util.Timer;


	
//sorry for the monkey code but i couldnt get it to work with thread.sleep()
public class PartyModule extends Module {
	public final Value<Boolean> Announce = new Value<Boolean>("Announce", new String[] {"EE"}, "Announces that you are partying!", false);
	public final Value<Boolean> Rotation = new Value<Boolean>("Rotate", new String[] {"EE"}, "Equips your elytra when enabled if you're not already wearing one", false);
	public final Value<Float> RotationSpeed = new Value<Float>("Rotation Speed", new String[]
		    { "RtSpd" }, "Speed to rotate at, requires for Rotate to be on", 1.82f, -100f, 100f, 0.1f); 
	public Value<Float> Delay = new Value<Float>("Delay", new String[]
            { "Delay, Wait" }, "Delay for each tick", 1f, 0f, 10f, 1f);
	boolean Rotate=true;
    private Timer timer = new Timer();

    public PartyModule()
	{
        super("Party", new String[]
        		{ "Party" }, "Party like its the annual Chicken Lord party!", "NONE",
        		0xDB2485, Module.ModuleType.FUN);
        
    }
    
	@Override
	public void onEnable()
	{  
		
			if (Announce.getValue()) {
			timer = new Timer();

        	timer.scheduleAtFixedRate(new TimerTask()
        	{
            	@Override
            	public void run()
            	{
            		mc.player.sendChatMessage("Agricultural revolution was not a bad thing!");
            	}
        	}, 0, 1000);
		}
		
			if (Rotation.getValue()) {

        	timer.scheduleAtFixedRate(new TimerTask()
        	{
            	@Override
            	public void run()
            	{
            		mc.player.rotationYaw=mc.player.prevRotationYaw+RotationSpeed.getValue();
            	}
        	}, 0, 400);
		}
    }
	
	@Override
	   public void onDisable()
	   {
		super.onDisable();

        if (timer != null)
            timer.cancel();
	   }
}
    
    

