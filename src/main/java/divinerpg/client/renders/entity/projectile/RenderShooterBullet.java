package divinerpg.client.renders.entity.projectile;

import divinerpg.entities.projectile.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;

public class RenderShooterBullet extends RenderDivineProjectile<EntityShooterBullet> {

    public RenderShooterBullet(EntityRendererManager renderManager) {
        super(renderManager, new ResourceLocation("minecraft:textures/projectiles/arrow.png"));
    }

    @Override
    public ResourceLocation getTextureLocation(EntityShooterBullet entity) {
        return entity.getTexture();
    }
}