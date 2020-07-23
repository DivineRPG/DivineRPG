package divinerpg.objects.entities.assets.render.projectiles;

import divinerpg.objects.entities.assets.render.RenderDivineProjectile;
import divinerpg.objects.entities.entity.projectiles.EntityDisk;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;

public class RenderDisk extends RenderDivineProjectile<EntityDisk> {

    public RenderDisk(RenderManager manager) {
        super(manager, 1F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityDisk entity) {
        return entity.getTexture();
    }
}