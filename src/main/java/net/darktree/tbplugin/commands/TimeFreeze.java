package net.darktree.tbplugin.commands;

import net.darktree.tbplugin.Entry;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.GameRules;

public class TimeFreeze {

    private static boolean apply = true;

    // This is little messy but it's good enough
    // WARNING: it resets doDayLightCycle & doWeatherCycle game rules when enabled
    public static void init() {
        if( Entry.freezeEmpty ) {

            // enable timeFreeze if the last player is leaving
            ServerPlayConnectionEvents.DISCONNECT.register((handler, server) -> {
                if( server.getCurrentPlayerCount() <= 1 ) {
                    Entry.LOGGER.info("Last player left the game, entering sleep mode...");
                    set(server, false);
                }
            });

            // disable time freeze on player join
            ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> set(server, true));

            // check server status after startup
            ServerTickEvents.START_SERVER_TICK.register(server -> {
                if( apply ) {
                    apply = false;

                    if( server.getCurrentPlayerCount() == 0 ) {
                        Entry.LOGGER.info("No online players, entering sleep mode...");
                        set( server, false );
                    }
                }
            });
        }
    }

    private static void set( MinecraftServer server, boolean flag ) {
        server.getGameRules().get( GameRules.DO_DAYLIGHT_CYCLE ).set( flag, server );
        server.getGameRules().get( GameRules.DO_WEATHER_CYCLE ).set( flag, server );
    }

}
