package net.darktree.tbplugin;

import net.darktree.tbplugin.commands.Commands;
import net.darktree.tbplugin.commands.TimeFreeze;
import net.darktree.tbplugin.config.DefaultProvider;
import net.darktree.tbplugin.config.SimpleConfig;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Environment(EnvType.SERVER)
public class Entry implements DedicatedServerModInitializer {

    public static final Logger LOGGER = LogManager.getLogger("TBPlugin");
    private static final SimpleConfig CONFIG = SimpleConfig.of("tbplugin").provider(DefaultProvider::provider).request();

    // disables or enables loading of the spawn area
    public static boolean loadSpawn = CONFIG.getOrDefault("load_spawn", true);

    // disables or enables /tps command, used to query server tps
    public static boolean tpsCommand = CONFIG.getOrDefault("tps_command", false);

    // disables or enables stopping daylight and weather cycle when the server is empty
    public static boolean freezeEmpty = CONFIG.getOrDefault("freeze_empty", false);

    // This mod is a stripped-down port of a Spigot plugin (TBPlugin) I
    // written a long time ago to manage my minecraft servers.
    // It lacks several (obsolete) features, and a backup system.

    @Override
    public void onInitializeServer() {
        LOGGER.info( "TBPlugin configuration: loadSpawn=" + loadSpawn + ", tpsCommand=" + tpsCommand + ", freezeEmpty=" + freezeEmpty );
        Commands.init();
        TimeFreeze.init();
    }

}
