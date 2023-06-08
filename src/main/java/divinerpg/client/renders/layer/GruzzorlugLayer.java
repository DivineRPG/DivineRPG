package divinerpg.client.renders.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import divinerpg.DivineRPG;
import divinerpg.client.models.iceika.ModelGruzzorlug;
import divinerpg.entities.iceika.EntityGruzzorlug;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.registries.ForgeRegistries;

@OnlyIn(Dist.CLIENT)
public class GruzzorlugLayer extends RenderLayer<EntityGruzzorlug, ModelGruzzorlug<EntityGruzzorlug>> {

    public GruzzorlugLayer(RenderLayerParent<EntityGruzzorlug, ModelGruzzorlug<EntityGruzzorlug>> parent) {
        super(parent);
    }

    public void render(PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn, EntityGruzzorlug gruzzorlug, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {

        poseStack.pushPose();
        ModelPart modelrenderer = this.getParentModel().RightArm;
        modelrenderer.translateAndRotate(poseStack);
        if(gruzzorlug.heldItem() == 1) {
            poseStack.translate(0.0625F, 0.55F, -0.4F);
            poseStack.mulPose(Axis.YP.rotationDegrees(55));
            poseStack.mulPose(Axis.YN.rotationDegrees(-35));
            poseStack.mulPose(Axis.ZN.rotationDegrees(45));
            poseStack.scale(0.8F, 0.8F, 0.8F);
            Minecraft.getInstance().getItemRenderer().renderStatic(gruzzorlug, ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "corrupted_pickaxe")).getDefaultInstance(), ItemDisplayContext.NONE, false, poseStack, bufferIn, gruzzorlug.level(), packedLightIn, LivingEntityRenderer.getOverlayCoords(gruzzorlug, 0.0F), 0);
        }
        if(gruzzorlug.heldItem() == 2) {
            poseStack.translate(0.0625F, 0.50F, -0.0F);
            poseStack.mulPose(Axis.YP.rotationDegrees(55));
            poseStack.mulPose(Axis.YN.rotationDegrees(-35));
            poseStack.mulPose(Axis.ZN.rotationDegrees(45));
            poseStack.scale(0.8F, 0.8F, 0.8F);
            Minecraft.getInstance().getItemRenderer().renderStatic(gruzzorlug, ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "corrupted_cannon")).getDefaultInstance(), ItemDisplayContext.NONE, false, poseStack, bufferIn, gruzzorlug.level(), packedLightIn, LivingEntityRenderer.getOverlayCoords(gruzzorlug, 0.0F), 0);
        }
        poseStack.popPose();
    }
}