package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vanilla.ModelAncientEntity;
import divinerpg.objects.entities.entity.vanilla.EntityAncientEntity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nullable;

public class RenderAncientEntity extends RenderLiving<EntityAncientEntity> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/ancient_entity.png");

    public RenderAncientEntity(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelAncientEntity(), 0);
    }

    @Override
    protected void preRenderCallback(EntityAncientEntity entitylivingbaseIn, float partialTickTime) {
        super.preRenderCallback(entitylivingbaseIn, partialTickTime);

        GL11.glScaled(5, 5, 5);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityAncientEntity entity) {
        return texture;
    }
}