package divinerpg.client.renders.entity.arcana;

import com.mojang.blaze3d.matrix.MatrixStack;
import divinerpg.DivineRPG;
import divinerpg.client.models.vanilla.*;
import divinerpg.entities.arcana.EntityLordVatticus;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderLordVatticus extends MobRenderer<EntityLordVatticus, ModelCyclops<EntityLordVatticus>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/lord_vatticus.png");

    public RenderLordVatticus(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelCyclops<EntityLordVatticus>(1), 0.8F);
    }
    protected void preRenderCallback(EntityLordVatticus entity, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1, 1, 1);
    }
    public ResourceLocation getEntityTexture(EntityLordVatticus entity) {
        return TEXTURE;
    }
}
