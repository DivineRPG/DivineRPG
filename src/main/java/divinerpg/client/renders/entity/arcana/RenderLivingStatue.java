package divinerpg.client.renders.entity.arcana;

import com.mojang.blaze3d.matrix.MatrixStack;
import divinerpg.DivineRPG;
import divinerpg.client.models.vanilla.*;
import divinerpg.entities.arcana.EntityLivingStatue;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

public class RenderLivingStatue extends MobRenderer<EntityLivingStatue, ModelCyclops<EntityLivingStatue>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/living_statue.png");

    public RenderLivingStatue(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelCyclops<EntityLivingStatue>(1), 0.8F);
    }
    protected void preRenderCallback(EntityLivingStatue entity, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1, 1, 1);
    }
    public ResourceLocation getEntityTexture(EntityLivingStatue entity) {
        return TEXTURE;
    }
}
