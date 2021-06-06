package divinerpg.client.renders.entity.projectile;

import divinerpg.entities.projectile.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;

public class RenderFrostCloud extends EntityRenderer<EntityFrostCloud> {
    public RenderFrostCloud(EntityRendererManager manager) {
        super(manager);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityFrostCloud cloud) {
        return null;
    }
}
