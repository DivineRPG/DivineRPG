package divinerpg.client.renders.entity.vanilla;


import com.mojang.blaze3d.matrix.MatrixStack;
import divinerpg.DivineRPG;
import divinerpg.client.models.vanilla.*;
import divinerpg.entities.vanilla.overworld.EntityWhale;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderWhale extends MobRenderer<EntityWhale, ModelWhale<EntityWhale>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/whale.png");

    public RenderWhale(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelWhale<>(), 0.8F);
    }

    protected void preRenderCallback(EntityWhale entity, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(5, 5, 5);
//        super.preRenderCallback(entity, matrixStackIn, partialTickTime);
    }
    public ResourceLocation getEntityTexture(EntityWhale entity) {
        return TEXTURE;
    }
}