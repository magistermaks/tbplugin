package net.darktree.tbplugin.mixin;

import net.darktree.tbplugin.Entry;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.WorldGenerationProgressListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public class MinecraftServerMixin {

    @Inject(method="prepareStartRegion(Lnet/minecraft/server/WorldGenerationProgressListener;)V", at=@At("HEAD"), cancellable=true)
    private void prepareStartRegion(WorldGenerationProgressListener worldGenerationProgressListener, CallbackInfo ci) {
        if( !Entry.loadSpawn ) {
            Entry.LOGGER.warn( "Loading of spawn region skipped!" );
            ci.cancel();
        }
    }

}
