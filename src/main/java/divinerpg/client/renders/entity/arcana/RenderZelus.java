package divinerpg.client.renders.entity.arcana;

import com.mojang.blaze3d.matrix.MatrixStack;
import divinerpg.DivineRPG;
import divinerpg.client.models.vanilla.*;
import divinerpg.entities.arcana.EntityZelus;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderZelus extends MobRenderer<EntityZelus, ModelCyclops<EntityZelus>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/zelus.png");

    public RenderZelus(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelCyclops<EntityZelus>(1), 0.8F);
    }
    protected void preRenderCallback(EntityZelus entity, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1, 1, 1);
    }
    public ResourceLocation getEntityTexture(EntityZelus entity) {
        return TEXTURE;
    }
}
