package divinerpg.client.renders.entity.projectile;

import divinerpg.entities.projectile.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;

public class RenderDisk extends RenderDivineProjectile<EntityDisk> {

    public RenderDisk(EntityRendererManager renderManager) {
        super(renderManager, null);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityDisk entity) {
        if(entity.getTexture() != null) {
            return entity.getTexture();
        }else
            return new ResourceLocation("minecraft:textures/projectiles/arrow.png");
    }
}