package divinerpg.client.models.iceika;

import static divinerpg.util.ClientUtils.createLocation;

import com.mojang.blaze3d.vertex.*;

import divinerpg.entities.iceika.EntityCauldronFish;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

public class ModelCauldronFish extends EntityModel<EntityCauldronFish> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("cauldron_fish");
	final ModelPart body, rightFin, leftFin;
	public ModelCauldronFish(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		body = root.getChild("Body");
		leftFin = root.getChild("LeftFin");
		rightFin = root.getChild("RightFin");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation zero = new CubeDeformation(0F);
		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -13.0F, -4.5F, 9.0F, 6.0F, 9.0F,zero)
		.texOffs(0, 15).addBox(-3.5F, -7.0F, -3.5F, 7.0F, 2.0F, 7.0F,zero), PartPose.offset(0.0F, 24.0F, 0.0F));
		Body.addOrReplaceChild("Tendrils", CubeListBuilder.create().texOffs(21, 15).addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 0.0F,zero)
		.texOffs(0, 17).addBox(0.0F, 0.0F, -3.5F, 0.0F, 5.0F, 7.0F,zero), PartPose.offset(0.0F, -5.0F, 0.0F));
		partdefinition.addOrReplaceChild("LeftFin", CubeListBuilder.create().texOffs(0, 4).addBox(-0.5F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F,zero), PartPose.offset(4.5F, 14.0F, 0.0F));
		partdefinition.addOrReplaceChild("RightFin", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F,zero), PartPose.offset(-4.5F, 14.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	@Override
	public void setupAnim(EntityCauldronFish entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if(entity.isInWater()) {
			body.xRot = leftFin.xRot = rightFin.xRot = 0F;
			leftFin.yRot = (float) Math.sin(ageInTicks);
			rightFin.yRot = -leftFin.yRot;
			leftFin.zRot = rightFin.zRot = 0F;
			leftFin.y = rightFin.y = 14F;
			body.z = 0F;
		} else {
			body.xRot = leftFin.xRot = rightFin.xRot = (float)Math.PI / 2F;
			leftFin.zRot = (float) Math.sin(ageInTicks);
			rightFin.zRot = -leftFin.zRot;
			leftFin.yRot = rightFin.yRot = 0F;
			leftFin.y = rightFin.y = 24F;
			body.z = 10F;
		}
	}
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftFin.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightFin.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}