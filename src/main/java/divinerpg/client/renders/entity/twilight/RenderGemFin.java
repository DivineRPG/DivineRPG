package divinerpg.client.renders.entity.twilight;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import divinerpg.DivineRPG;
import divinerpg.client.models.twilight.ModelGemFin;
import divinerpg.entities.eden.EntityGemFin;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderGemFin extends MobRenderer<EntityGemFin, ModelGemFin> {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/gem_fin/patchy_gem_fin.png");
    private static final ResourceLocation TEXTURE1 = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/gem_fin/precious_gem_fin.png");
    private static final ResourceLocation TEXTURE2 = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/gem_fin/ruby_gem_fin.png");

    public RenderGemFin(EntityRendererProvider.Context context) {
        super(context, new ModelGemFin(context), 0.32F);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityGemFin entity) {
    	return switch(entity.getVariant()) {
    	case 0 -> TEXTURE;
    	case 1 -> TEXTURE1;
    	default -> TEXTURE2;
    	};
    }

    @Override protected void setupRotations(EntityGemFin entity, PoseStack poseStack, float bob, float yBodyRot, float partialTick, float scale) {
        super.setupRotations(entity, poseStack, bob, yBodyRot, partialTick, scale);
        float f = 4.3F * Mth.sin(0.6F * bob);
        poseStack.mulPose(Axis.YP.rotationDegrees(f));
        if (!entity.isInWater()) {
            poseStack.translate(0.2F, 0.2F, 0.0F);
            poseStack.mulPose(Axis.ZP.rotationDegrees(90.0F));
        }
    }
}