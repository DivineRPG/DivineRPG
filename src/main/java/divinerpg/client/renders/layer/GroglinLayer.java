package divinerpg.client.renders.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import divinerpg.DivineRPG;
import divinerpg.client.models.iceika.ModelGroglin;
import divinerpg.entities.iceika.EntityGroglin;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.registries.ForgeRegistries;

@OnlyIn(Dist.CLIENT)
public class GroglinLayer extends RenderLayer<EntityGroglin, ModelGroglin<EntityGroglin>> {

    public GroglinLayer(RenderLayerParent<EntityGroglin, ModelGroglin<EntityGroglin>> parent) {
        super(parent);
    }

    public void render(PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn, EntityGroglin groglin, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {

        poseStack.pushPose();
        ModelPart modelrenderer = this.getParentModel().rightArm;
        modelrenderer.translateAndRotate(poseStack);
        if(groglin.getItemNum() == 1) {
            poseStack.translate(0.0625F, 0.55F, -0.4F);
            poseStack.mulPose(Axis.YP.rotationDegrees(55));
            poseStack.mulPose(Axis.YN.rotationDegrees(-35));
            poseStack.mulPose(Axis.ZN.rotationDegrees(45));
            poseStack.scale(0.8F, 0.8F, 0.8F);
            Minecraft.getInstance().getItemRenderer().renderStatic(groglin, ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "icine_sword")).getDefaultInstance(), ItemTransforms.TransformType.NONE, false, poseStack, bufferIn, groglin.level, packedLightIn, LivingEntityRenderer.getOverlayCoords(groglin, 0.0F), 0);
        }
        if(groglin.getItemNum() == 2) {
            poseStack.translate(0.0625F, 0.50F, -0.0F);
            poseStack.mulPose(Axis.YP.rotationDegrees(55));
            poseStack.mulPose(Axis.YN.rotationDegrees(-35));
            poseStack.mulPose(Axis.ZN.rotationDegrees(45));
            poseStack.scale(0.8F, 0.8F, 0.8F);
            Minecraft.getInstance().getItemRenderer().renderStatic(groglin, ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "icicle_bow")).getDefaultInstance(), ItemTransforms.TransformType.NONE, false, poseStack, bufferIn, groglin.level, packedLightIn, LivingEntityRenderer.getOverlayCoords(groglin, 0.0F), 0);
        }
        poseStack.popPose();
    }
}