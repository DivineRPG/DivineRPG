package divinerpg.client.models.vanilla;

import divinerpg.entities.vanilla.end.EntityEnderSpider;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelEnderSpider extends HierarchicalModel<EntityEnderSpider> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("ender_spider");
	public final ModelPart head, rightMandible, leftMandible, body, thorax, rightFrontLeg, leftFrontLeg, rightMiddleFrontLeg, leftMiddleFrontLeg, rightMiddleHindLeg, leftMiddleHindLeg, rightHindLeg, leftHindLeg;
	public ModelEnderSpider(EntityRendererProvider.Context context) {
		body = context.bakeLayer(LAYER_LOCATION).getChild("body");
		head = body.getChild("head");
		rightMandible = head.getChild("right_mandible");
		leftMandible = head.getChild("left_mandible");
		thorax = body.getChild("thorax");
		rightFrontLeg = body.getChild("right_front_leg");
		leftFrontLeg = body.getChild("left_front_leg");
		rightMiddleFrontLeg = body.getChild("right_middle_front_leg");
		leftMiddleFrontLeg = body.getChild("left_middle_front_leg");
		rightMiddleHindLeg = body.getChild("right_middle_hind_leg");
		leftMiddleHindLeg = body.getChild("left_middle_hind_leg");
		rightHindLeg = body.getChild("right_hind_leg");
		leftHindLeg = body.getChild("left_hind_leg");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubeDef = CubeDeformation.NONE;
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3, -3, -3, 6, 6, 6, new CubeDeformation(.01F)), PartPose.offset(0, 15, 0));
		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(32, 4).addBox(-4, -4, -8, 8, 8, 8, cubeDef), PartPose.offset(0, 0, -3));
		head.addOrReplaceChild("right_mandible", CubeListBuilder.create().texOffs(24, 7).addBox(-1, -1, 0, 2, 4, 1, cubeDef), PartPose.offset(-2, 3, -9));
		head.addOrReplaceChild("left_mandible", CubeListBuilder.create().texOffs(24, 7).mirror().addBox(-1, -1, -1, 2, 4, 1, cubeDef), PartPose.offset(2, 3, -8));
		body.addOrReplaceChild("thorax", CubeListBuilder.create().texOffs(0, 12).addBox(-5, -4, 0, 10, 8, 12, cubeDef)
		.texOffs(8, 40).addBox(-4, -7, 2, 8, 3, 8, cubeDef), PartPose.offset(0, 0, 3));
		PartDefinition rightFrontLeg = body.addOrReplaceChild("right_front_leg", CubeListBuilder.create(), PartPose.offset(-4, 0, -1));
		PartDefinition rightFrontLegRot = rightFrontLeg.addOrReplaceChild("right_front_leg_rot", CubeListBuilder.create().texOffs(16, 36).addBox(-13, -1, -1, 14, 2, 2, cubeDef), PartPose.rotation(-.6155F, -Mth.PI / 6, .1699F));
		rightFrontLegRot.addOrReplaceChild("right_front_lower_leg", CubeListBuilder.create().texOffs(8, 32).addBox(-2, 0, -1, 2, 14, 2, new CubeDeformation(.01F)), PartPose.offsetAndRotation(-13, -1, 0, 0, 0, -Mth.PI / 8));
		PartDefinition leftFrontLeg = body.addOrReplaceChild("left_front_leg", CubeListBuilder.create(), PartPose.offset(4, 0, -1));
		PartDefinition leftFrontLegRot = leftFrontLeg.addOrReplaceChild("left_front_leg_rot", CubeListBuilder.create().texOffs(16, 36).mirror().addBox(-1, -1, -1, 14, 2, 2, cubeDef), PartPose.rotation(-.6155F, Mth.PI / 6, -.1699F));
		leftFrontLegRot.addOrReplaceChild("left_front_lower_leg", CubeListBuilder.create().texOffs(8, 32).mirror().addBox(0, 0, -1, 2, 14, 2, new CubeDeformation(.01F)), PartPose.offsetAndRotation(13, -1, 0, 0, 0, Mth.PI / 8));
		PartDefinition rightMiddleFrontLeg = body.addOrReplaceChild("right_middle_front_leg", CubeListBuilder.create(), PartPose.offset(-4, 0, 0));
		rightMiddleFrontLeg.addOrReplaceChild("right_middle_front_leg_rot", CubeListBuilder.create().texOffs(18, 0).addBox(-15, -1, -1, 16, 2, 2, new CubeDeformation(.1F)), PartPose.rotation(0, -Mth.PI / 12, -.6109F));
		PartDefinition leftMiddleFrontLeg = body.addOrReplaceChild("left_middle_front_leg", CubeListBuilder.create(), PartPose.offset(4, 0, 0));
		leftMiddleFrontLeg.addOrReplaceChild("left_middle_front_leg_rot", CubeListBuilder.create().texOffs(18, 0).addBox(-1, -1, -1, 16, 2, 2, new CubeDeformation(.1F)), PartPose.rotation(0, Mth.PI / 12, .6109F));
		PartDefinition rightMiddleHindLeg = body.addOrReplaceChild("right_middle_hind_leg", CubeListBuilder.create(), PartPose.offset(-4, 0, 1));
		rightMiddleHindLeg.addOrReplaceChild("right_middle_hind_leg_rot", CubeListBuilder.create().texOffs(18, 0).addBox(-15, -1, -1, 16, 2, 2, cubeDef), PartPose.rotation(0, Mth.PI / 12, -.6109F));
		PartDefinition leftMiddleHindLeg = body.addOrReplaceChild("left_middle_hind_leg", CubeListBuilder.create(), PartPose.offset(4, 0, 1));
		leftMiddleHindLeg.addOrReplaceChild("left_middle_hind_leg_rot", CubeListBuilder.create().texOffs(18, 0).addBox(-1, -1, -1, 16, 2, 2, cubeDef), PartPose.rotation(0, -Mth.PI / 12, .6109F));
		PartDefinition rightHindLeg = body.addOrReplaceChild("right_hind_leg", CubeListBuilder.create(), PartPose.offset(-4, 0, 2));
		rightHindLeg.addOrReplaceChild("right_hind_upper_leg", CubeListBuilder.create().texOffs(16, 32).addBox(-10, -1, -1, 10, 2, 2, cubeDef), PartPose.offsetAndRotation(1, 0, 0, 0, 0, Mth.HALF_PI));
		rightHindLeg.addOrReplaceChild("right_hind_lower_leg", CubeListBuilder.create().texOffs(0, 32).addBox(-2, 0, -1, 2, 25, 2, new CubeDeformation(.01F)), PartPose.offsetAndRotation(2, -10, 0, 0, 0, 1.1781F));
		PartDefinition leftHindLeg = body.addOrReplaceChild("left_hind_leg", CubeListBuilder.create(), PartPose.offset(4, 0, 2));
		leftHindLeg.addOrReplaceChild("left_hind_upper_leg", CubeListBuilder.create().texOffs(16, 32).mirror().addBox(0, -1, -1, 10, 2, 2, cubeDef), PartPose.offsetAndRotation(-1, 0, 0, 0, 0, -Mth.HALF_PI));
		leftHindLeg.addOrReplaceChild("left_hind_lower_leg", CubeListBuilder.create().texOffs(0, 32).mirror().addBox(0, 0, -1, 2, 25, 2, new CubeDeformation(.01F)), PartPose.offsetAndRotation(-2, -10, 0, 0, 0, -1.1781F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	@Override public ModelPart root() {return body;}
	@Override public void setupAnim(EntityEnderSpider entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		head.yRot = netHeadYaw * Mth.DEG_TO_RAD;
		head.xRot = headPitch * Mth.DEG_TO_RAD;
		float f = limbSwing * .6662F;
		float f1 = -Mth.cos(f * 2) * .4F * limbSwingAmount;
		float f2 = Mth.sin(f * 2) * .4F * limbSwingAmount;
		float f3 = Math.abs(Mth.sin(f) * .4F) * limbSwingAmount;
		float f4 = Math.abs(Mth.cos(f) * .4F) * limbSwingAmount;
		thorax.xRot = Mth.cos(limbSwing * .6662F) * .25F * limbSwingAmount;
		//Front legs
		leftFrontLeg.yRot = f2;
		rightFrontLeg.yRot = -leftFrontLeg.yRot;
		rightFrontLeg.zRot = f4;
		leftFrontLeg.zRot = -rightFrontLeg.zRot;
		//Middle front legs
		rightMiddleFrontLeg.yRot = f2;
		leftMiddleFrontLeg.yRot = -rightMiddleFrontLeg.yRot;
		rightMiddleFrontLeg.zRot = f4;
		leftMiddleFrontLeg.zRot = -rightMiddleFrontLeg.zRot;
		//Middle hind legs
		leftMiddleHindLeg.yRot = f1;
		rightMiddleHindLeg.yRot = -leftMiddleHindLeg.yRot;
		rightMiddleHindLeg.zRot = f3;
		leftMiddleHindLeg.zRot = -rightMiddleHindLeg.zRot;
		//Hind legs
		rightHindLeg.yRot = f1 + Mth.PI / 4;
		leftHindLeg.yRot = -rightHindLeg.yRot;
		rightHindLeg.zRot = f3 - Mth.PI / 4;
		leftHindLeg.zRot = -rightHindLeg.zRot;
	}
}