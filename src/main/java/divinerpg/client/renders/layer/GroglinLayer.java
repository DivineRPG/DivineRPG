package divinerpg.client.renders.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import divinerpg.DivineRPG;
import divinerpg.client.models.iceika.ModelGroglin;
import divinerpg.entities.iceika.EntityIceikaNPC;
import divinerpg.entities.iceika.groglin.Groglin;
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
public class GroglinLayer extends RenderLayer<Groglin, ModelGroglin<Groglin>> {
    public GroglinLayer(RenderLayerParent<Groglin, ModelGroglin<Groglin>> parent) {
        super(parent);
    }
    public void render(PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn, Groglin groglin, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        poseStack.pushPose();
        ModelPart modelrenderer = getParentModel().rightArm;
        modelrenderer.translateAndRotate(poseStack);
        String item = EntityIceikaNPC.getItemName(groglin.heldItem());
        if(item != null) {
            poseStack.translate(.0625F, .55F, -.4F);
            poseStack.mulPose(Axis.YP.rotationDegrees(55));
            poseStack.mulPose(Axis.YN.rotationDegrees(-35));
            poseStack.mulPose(Axis.ZN.rotationDegrees(45));
            poseStack.scale(.8F, .8F, .8F);
            Minecraft.getInstance().getItemRenderer().renderStatic(groglin, ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, item)).getDefaultInstance(), ItemDisplayContext.NONE, false, poseStack, bufferIn, groglin.level(), packedLightIn, LivingEntityRenderer.getOverlayCoords(groglin, 0F), 0);
        }
        poseStack.popPose();
    }
}