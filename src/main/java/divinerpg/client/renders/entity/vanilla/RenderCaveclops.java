package divinerpg.client.renders.entity.vanilla;


import com.mojang.blaze3d.matrix.MatrixStack;
import divinerpg.DivineRPG;
import divinerpg.client.models.vanilla.*;
import divinerpg.entities.vanilla.overworld.EntityCaveclops;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderCaveclops extends MobRenderer<EntityCaveclops, ModelCyclops<EntityCaveclops>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/caveclops.png");

    public RenderCaveclops(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelCyclops<EntityCaveclops>(1), 0.8F);
    }
    protected void preRenderCallback(EntityCaveclops entity, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(2, 2, 2);
    }
    public ResourceLocation getTextureLocation(EntityCaveclops entity) {
        return TEXTURE;
    }
}