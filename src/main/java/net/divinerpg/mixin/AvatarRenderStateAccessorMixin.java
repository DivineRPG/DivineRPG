package net.divinerpg.mixin;

import net.divinerpg.client.render.AvatarStateAccessor;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import java.util.UUID;

@Mixin(AvatarRenderState.class)
public class AvatarRenderStateAccessorMixin implements AvatarStateAccessor {
    @Unique
    private UUID divinerpg$uuid;

    @Override
    public UUID divinerpg$getUuid() {
        return this.divinerpg$uuid;
    }

    @Override
    public void divinerpg$setUuid(UUID uuid) {
        this.divinerpg$uuid = uuid;
    }
}