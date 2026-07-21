package net.divinerpg.mixin;

import net.divinerpg.client.render.AvatarStateAccessor;
import net.minecraft.client.renderer.entity.player.AvatarRenderer;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AvatarRenderer.class)
public class AvatarRendererMixin {

    @Inject(method = "extractRenderState(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/client/renderer/entity/state/AvatarRenderState;F)V", at = @At("TAIL"))
    public void onExtractRenderState(Player player, AvatarRenderState state, float partialTick, CallbackInfo ci) {
        if (player != null && state != null) {
            ((AvatarStateAccessor) state).divinerpg$setUuid(player.getUUID());
        }
    }
}