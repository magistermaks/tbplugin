package net.darktree.tbplugin.commands;

import net.darktree.tbplugin.Entry;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.text.LiteralText;
import net.minecraft.util.math.MathHelper;

import static net.minecraft.server.command.CommandManager.literal;

public class Commands {

    public static void init() {

        if( Entry.tpsCommand ) {
            CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
                dispatcher.register(literal("tps").executes(context -> {
                    double time = MathHelper.average(context.getSource().getMinecraftServer().lastTickLengths) * 1.0E-6D;
                    String tps = "TPS: " + (int) Math.min(1000.0f / time, 20) + ", at: " + String.format("%.2f", time) + "ms (max: 50ms)";
                    context.getSource().sendFeedback(new LiteralText(tps), false);
                    return 1;
                }));
            });
        }

    }

}
