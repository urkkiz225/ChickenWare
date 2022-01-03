package me.ionar.salhack.module.misc;

import me.ionar.salhack.main.Wrapper;
import me.ionar.salhack.managers.DiscordManager;
import me.ionar.salhack.module.Module;
import me.ionar.salhack.module.Value;
import me.ionar.salhack.util.entity.PlayerUtil;
import akka.actor.dsl.Inbox.Get;
import me.ionar.salhack.events.minecraft.GuiScreenEvent;
import net.minecraft.client.gui.ServerSelectionList;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiControls;
import net.minecraft.client.gui.GuiGameOver;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMemoryErrorScreen;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenServerList;
import net.minecraft.client.gui.GuiScreenWorking;
import net.minecraft.client.gui.GuiWorldSelection;
import net.minecraft.world.GameType;

public class DiscordRPCModule extends Module
{
    public final Value<Boolean> Username = new Value<Boolean>("Username", new String[] {"U"}, "Displays your username in the rich presence", true);
    public final Value<Boolean> ServerIP = new Value<Boolean>("ServerIP", new String[] {"S"}, "Displays your current playing server in the rich presence", true);
    public final Value<String> DetailsAddon = new Value<String>("DetailsAddon", new String[] {"D"}, "Displays a custom message after the previous", "Gaming");
    public final Value<Boolean> urkkiz = new Value<Boolean>("urkkiz", new String[] {"U"}, "Displays a message about ionar", true);
    public final Value<Boolean> Speed = new Value<Boolean>("Speed", new String[] {"U"}, "Displays your speed in the rich presence", true);
    public final Value<Boolean> Movement = new Value<Boolean>("Movement", new String[] {"U"}, "Displays if you're flying/onground in the rich presence", true);
    public final Value<Boolean> Crystalling = new Value<Boolean>("Crystalling", new String[] {"U"}, "Displays the current target from autocrystal", true);
    public final Value<Boolean> Health = new Value<Boolean>("Health", new String[] {"U"}, "Displays your Health in the rich presence", true);
    public final Value<Boolean> GitHub = new Value<Boolean>("GitHub", new String[] {"U"}, "Shows the GitHub link for ChickenWare", true);
    public final Value<Boolean> Gamemode = new Value<Boolean>("Gamemode", new String[] {"U"}, "Shows your current gamemode", true);
    public final Value<Boolean> Coords = new Value<Boolean>("Coords", new String[] {"U"}, "Shows your current coordinates, enable coordsConfirm to enable", true);
    public final Value<Boolean> CoordsConfirm = new Value<Boolean>("CoordsConfirm", new String[] {"U"}, "Shows your coordinates on discord, are you sure you want to enable this?", true);
    public final Value<Boolean> PlayerInfo = new Value<Boolean>("PlayerInfo", new String[] {"U"}, "Displays if you are in main menu, playing single/multiplayer... etc", true);
    public final Value<Boolean> ExploitersOnTop = new Value<Boolean>("Exploiters On Top!", new String[] {"U"}, "Exploiters On Top!", true);
    
    public DiscordRPCModule()
    {
        super("DiscordRPC", new String[] {"RPC"}, "Shows discord rich presence for this mod", "NONE", -1, ModuleType.MISC);
        setEnabled(true);
    }

    @Override
    public void init()
    {

        if (isEnabled())
            DiscordManager.Get().enable();
    }

    @Override
    public void onEnable()
    {
        super.onEnable();

        DiscordManager.Get().enable();
    }

    @Override
    public void onDisable()
    {
        super.onDisable();

        try
        {
            DiscordManager.Get().disable();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public String generateDetails()
    {
        String result = DetailsAddon.getValue();
       

        if (result == null)
            result = "";
        
        if (ServerIP.getValue())
            result = (Wrapper.GetMC().getCurrentServerData() != null ? Wrapper.GetMC().getCurrentServerData().serverIP : "") + " | " + result;

        if (Username.getValue())
            result = Wrapper.GetMC().session.getUsername() + " | "+ result;
        
        
        
        

        return result;
    }
    public String generateState()
    {
        if (mc.player == null)
            return "Main Menu";
        
        if (mc.player.isDead) {
        	return "dead (lol)";
        }
      

        if (urkkiz.getValue())
        {
            return "Thank you urkkiz for ChickenWare!";
        }
        
        if (ExploitersOnTop.getValue())
        {
            return "Exploiters On Top! https://discord.gg/MGxSyT3zCD";
        }

        if (GitHub.getValue())
        {
            return "ChickenWare is hosted at https://github.com/urkkiz225/ChickenWare";
        }
        
        if (PlayerInfo.getValue())
        {
        	if (mc.isIntegratedServerRunning()) {
        	
        	return "Singleplayer";
        	}
        	
        	if (mc.isConnectedToRealms()) {
            	
            	return "Realms";
        	}
        	if (mc.isGamePaused()) {
            	
            	return "Paused";
        	}
        	if (mc.getCurrentServerData().isOnLAN()) {
            	
            	return "LAN";
        	}
        	if (mc.isDemo()) {
            	
            	return "playing... demo version???";
        	}
        	
        	if ((Wrapper.GetMC().getCurrentServerData().serverIP!=null)) {
            	
            	return "Multiplayer";
        	}     	
        }
        
        if (Gamemode.getValue())
        {
        	if (this.mc.playerController.getCurrentGameType() == GameType.CREATIVE) {
        		return "Creative Mode";
        	}
        	
        	if (this.mc.playerController.getCurrentGameType() == GameType.SPECTATOR) {
        		return "Spectator Mode";
        	}
        	
        	if (this.mc.playerController.getCurrentGameType() == GameType.SURVIVAL) {
        		return "Survival Mode";
        	}
        	
        	if (this.mc.playerController.getCurrentGameType() == GameType.ADVENTURE) {
        		return "Adventure Mode";
        	}
        }
        
        if (PlayerInfo.getValue())
        {
        	if (mc.isIntegratedServerRunning()) {
        	
        	return "Singleplayer";
        	}
        	
        	if (mc.isConnectedToRealms()) {
            	
            	return "Realms";
        	}
        	if (mc.isGamePaused()) {
            	
            	return "Paused";
        	}
        	if (mc.getCurrentServerData().isOnLAN()) {
            	
            	return "LAN";
        	}
        	if (mc.isDemo()) {
            	
            	return "playing... demo version???";
        	}
        	
        	if ((Wrapper.GetMC().getCurrentServerData().serverIP!=null)) {
            	
            	return "Multiplayer";
        	}     	
        }
        


        String result = "";

        

        if (Movement.getValue())
        {
            result = mc.player.onGround ? "On the ground" : "Airborne";

            if (mc.player.isElytraFlying())
                result = "Zooming";
        }

        if (Speed.getValue())
        {
            float speed = PlayerUtil.getSpeedInKM();

            if (result.isEmpty())
                result = "Moving " + speed + " km/h";
            else
            {
                if (result.equals("Zooming"))
                    result += " at " + speed + " km/h";
                else
                    result += " going " + speed + " km/h";
            }
        }

        if (Health.getValue())
        {
            if (!result.isEmpty())
                result += " ";

            result += Math.floor(mc.player.getHealth() + mc.player.getAbsorptionAmount()) + " health";
        }

        return result;
    }
    
}
        

        

        





