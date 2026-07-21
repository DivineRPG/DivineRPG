package net.divinerpg.mixin;

import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import java.util.UUID;

@Mixin(AvatarRenderState.class)
public class AvatarRenderStateMixin {
    @Unique
    public UUID divinerpg$uuid;
}