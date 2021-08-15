package me.ionar.salhack;

import me.ionar.salhack.main.ForgeEventProcessor;
import me.ionar.salhack.main.SalHack;
import me.zero.alpine.fork.bus.EventBus;
import me.zero.alpine.fork.bus.EventManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.Display;

@Mod(modid = "chickenware", name = "chickenware", version = SalHackMod.VERSION)
public final class SalHackMod
{
    public static final String NAME = "ChickenWare";
    public static final String VERSION = "0.1";

    public static final Logger log = LogManager.getLogger("sal");

    public static final EventBus EVENT_BUS = new EventManager();


    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        log.info("init Creepy Salhack v" + VERSION);
        Display.setTitle(NAME + " v" + VERSION);

        SalHack.Init();

        MinecraftForge.EVENT_BUS.register(new ForgeEventProcessor());


    }
}
