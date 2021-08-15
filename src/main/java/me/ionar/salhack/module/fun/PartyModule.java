package me.ionar.salhack.module.fun;

import me.ionar.salhack.module.Module;
import me.ionar.salhack.module.Value;
import me.ionar.salhack.util.Timer;



	

public class PartyModule extends Module {
	public final Value<Boolean> Announce = new Value<Boolean>("Announce", new String[] {"EE"}, "Announces that you are partying!", false);
	public final Value<Boolean> Rotation = new Value<Boolean>("Rotate", new String[] {"EE"}, "Equips your elytra when enabled if you're not already wearing one", false);
	public final Value<Float> RotationSpeed = new Value<Float>("Rotation Speed", new String[]
		    { "RtSpd" }, "Speed to rotate at, requires for Rotate to be on", 1.82f, 0.0f, 10.0f, 0.1f); 
	private boolean start = false;
	private boolean finished = true; //when finished doing rotation 1-2<
	private final Timer timer = new Timer();
	public Value<Float> Delay = new Value<Float>("Delay", new String[]
            { "Delay, Wait" }, "Delay for each tick", 1f, 0f, 10f, 1f);
	boolean Rotate=true;
	
	@Override
	public void onEnable()
	{ 
		super.onEnable();
		   start=false;
	        if (!timer.passed(Delay.getValue() * 100f))
	            return;
	        timer.reset(); 
		   
	        if(finished) {
	            finished = false;
	            start = true; 
	            return;
		   }
		   
		   if (Rotation.getValue())  
		   {
			   if(mc.player != null) {
				   if (start=true) {
						   Rotate();
					   }
				   }
			   }
		   	}  
	   
	   
	   @Override
	   public void onDisable()
	   {
		   super.onDisable();
		   timer.reset();
	   }
	   
	   public void Rotate()
	   {
		   mc.player.rotationPitch=mc.player.prevRotationPitch+5;
		   try {
			    Thread.sleep(1 * 1000);
			} catch (InterruptedException ie) {
			    Thread.currentThread().interrupt();
			}
		   Rotate();
	   }
    
	
	public PartyModule()
	{
        super("Party", new String[]
        		{ "Party" }, "Party like its the annual Chicken Lord party!", "NONE",
        		0xDB2485, Module.ModuleType.FUN);
        
    }
	
}
    
    

