package divinerpg.client.renders.entity.twilight;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import divinerpg.client.models.twilight.ModelGemFin;
import divinerpg.entities.eden.EntityGemFin;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.*;

import static divinerpg.DivineRPG.MODID;

@OnlyIn(Dist.CLIENT)
public class RenderGemFin extends MobRenderer<EntityGemFin, ModelGemFin> {
    private static final ResourceLocation RUBY = ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/gem_fin/ruby_gem_fin.png"),
        PATCHY = ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/gem_fin/patchy_gem_fin.png"),
        PRECIOUS = ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/gem_fin/precious_gem_fin.png");
    public RenderGemFin(EntityRendererProvider.Context context) {super(context, new ModelGemFin(context), .32F);}
    @Override protected void setupRotations(EntityGemFin entity, PoseStack poseStack, float bob, float yBodyRot, float partialTick, float scale) {
        super.setupRotations(entity, poseStack, bob, yBodyRot, partialTick, scale);
        float f = 4.3F * Mth.sin(.6F * bob);
        poseStack.mulPose(Axis.YP.rotationDegrees(f));
        if(!entity.isInWater()) {
            poseStack.translate(.2F, .2F, 0);
            poseStack.mulPose(Axis.ZP.rotationDegrees(90));
        }
    }
    @Override public ResourceLocation getTextureLocation(EntityGemFin entity) {
        return switch(entity.getVariant()) {
            case 0 -> PATCHY;
            case 1 -> PRECIOUS;
            default -> RUBY;
        };
    }
}