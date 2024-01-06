package divinerpg.client.renders.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import divinerpg.DivineRPG;
import divinerpg.client.models.iceika.ModelGruzzorlug;
import divinerpg.entities.iceika.EntityIceikaNPC;
import divinerpg.entities.iceika.gruzzorlug.Gruzzorlug;
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
public class GruzzorlugLayer extends RenderLayer<Gruzzorlug, ModelGruzzorlug<Gruzzorlug>> {
    public GruzzorlugLayer(RenderLayerParent<Gruzzorlug, ModelGruzzorlug<Gruzzorlug>> parent) {
        super(parent);
    }
    public void render(PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn, Gruzzorlug gruzzorlug, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        poseStack.pushPose();
        ModelPart modelrenderer = getParentModel().RightArm;
        modelrenderer.translateAndRotate(poseStack);
        String item = EntityIceikaNPC.getItemName(gruzzorlug.heldItem());
        if(item != null) {
            poseStack.translate(.0625F, .55F, -.4F);
            poseStack.mulPose(Axis.YP.rotationDegrees(55));
            poseStack.mulPose(Axis.YN.rotationDegrees(-35));
            poseStack.mulPose(Axis.ZN.rotationDegrees(45));
            poseStack.scale(.8F, .8F, .8F);
            Minecraft.getInstance().getItemRenderer().renderStatic(gruzzorlug, ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, item)).getDefaultInstance(), ItemDisplayContext.NONE, false, poseStack, bufferIn, gruzzorlug.level(), packedLightIn, LivingEntityRenderer.getOverlayCoords(gruzzorlug, 0.0F), 0);
        }
        poseStack.popPose();
    }
}