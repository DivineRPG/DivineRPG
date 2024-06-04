package divinerpg.client.renders.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import divinerpg.client.models.iceika.ModelRobbin;
import divinerpg.entities.iceika.EntityRobbin;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.item.*;

public class RobbinLayer extends RenderLayer<EntityRobbin, ModelRobbin> {
	public RobbinLayer(RenderLayerParent<EntityRobbin, ModelRobbin> parent) {super(parent);}
	@Override public void render(PoseStack stack, MultiBufferSource buffer, int packetLightIn, EntityRobbin robbin, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		int itemID = robbin.getItemID();
		if(itemID != 0) {
			stack.pushPose();
			getParentModel().head.translateAndRotate(stack);
			stack.translate(getParentModel().head.x / 16, getParentModel().head.y / 16, getParentModel().head.z / 16);
			stack.scale(.25F, .25F, .25F);
			stack.mulPose(Axis.YP.rotationDegrees(netHeadYaw));
			stack.mulPose(Axis.XP.rotationDegrees(headPitch));
			stack.mulPose(Axis.XN.rotationDegrees(85));
			Minecraft.getInstance().getItemRenderer().renderStatic(robbin, Item.byId(itemID).getDefaultInstance(), ItemDisplayContext.NONE, false, stack, buffer, robbin.level(), packetLightIn, LivingEntityRenderer.getOverlayCoords(robbin, 0), 0);
			stack.popPose();
		}
	}
}