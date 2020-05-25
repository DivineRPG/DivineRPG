package divinerpg.objects.entities.assets.render.projectiles;

import divinerpg.objects.entities.assets.render.RenderDivineProjectile;
import divinerpg.objects.entities.entity.projectiles.EntityShooterBullet;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;

public class RenderShooterBullet extends RenderDivineProjectile<EntityShooterBullet> {

    public RenderShooterBullet(RenderManager manager) {
        super(manager, 1F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityShooterBullet entity) {
        return entity.getTexture();
    }
}
