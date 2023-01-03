package divinerpg.client.renders.entity.projectile;

import divinerpg.entities.projectile.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.*;

public class RenderFrostCloud extends EntityRenderer<EntityFrostCloud> {
    public RenderFrostCloud(Context manager) {
        super(manager);
    }
    @Override
    public ResourceLocation getTextureLocation(EntityFrostCloud cloud) {
        return null;
    }
}
