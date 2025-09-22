package divinerpg.client.models.vanilla;

import divinerpg.entities.vanilla.overworld.EntityJungleSpider;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelJungleSpider extends HierarchicalModel<EntityJungleSpider> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("jungle_spider");
	public final ModelPart head, rightMandible, leftMandible, body, thorax, rightFrontLeg, leftFrontLeg, rightMiddleFrontLeg, leftMiddleFrontLeg, rightMiddleHindLeg, leftMiddleHindLeg, rightHindLeg, leftHindLeg;
	public ModelJungleSpider(EntityRendererProvider.Context context) {
		body = context.bakeLayer(LAYER_LOCATION).getChild("body");
		head = body.getChild("head");
		leftMandible = head.getChild("left_mandible");
		rightMandible = head.getChild("right_mandible");
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
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(32, 33).addBox(-3, -3, -3, 6, 6, 6, cubeDef), PartPose.offset(0, 15, 0));
		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 19).addBox(-4, -4, -7.99F, 8, 8, 8, cubeDef), PartPose.offset(0, 0, -3));
		head.addOrReplaceChild("right_mandible", CubeListBuilder.create().texOffs(16, 39).mirror().addBox(-1, -1, -1.5F, 2, 4, 2, cubeDef), PartPose.offsetAndRotation(-2, 2, -8, 0, Mth.PI / 8, 0));
		head.addOrReplaceChild("left_mandible", CubeListBuilder.create().texOffs(16, 39).addBox(-1, -1, -1.5F, 2, 4, 2, cubeDef), PartPose.offsetAndRotation(2, 2, -8, 0, -Mth.PI / 8, 0));
		PartDefinition thorax = body.addOrReplaceChild("thorax", CubeListBuilder.create(), PartPose.offset(0, 0, 3));
		thorax.addOrReplaceChild("thorax_front_rot", CubeListBuilder.create().texOffs(32, 19).addBox(-4, -4, -.5F, 8, 8, 6, cubeDef), PartPose.rotation(Mth.PI / 18, 0, 0));
		thorax.addOrReplaceChild("thorax_hind_rot", CubeListBuilder.create().texOffs(38, 0).mirror().addBox(-4, 6.24F, 8.27F, 3, 3, 4, cubeDef)
		.texOffs(24, 39).mirror().addBox(-3.5F, 6.24F, 6.27F, 2, 2, 2, cubeDef)
		.texOffs(24, 39).addBox(1.5F, 6.24F, 6.27F, 2, 2, 2, cubeDef)
		.texOffs(38, 0).addBox(1, 6.24F, 8.27F, 3, 3, 4, cubeDef)
		.texOffs(0, 0).addBox(-5, -3.76F, 4.27F, 10, 10, 9, cubeDef), PartPose.rotation(Mth.PI / 7.2F, 0, 0));
		PartDefinition rightFrontLeg = body.addOrReplaceChild("right_front_leg", CubeListBuilder.create(), PartPose.offset(-4, 0, -2));
		PartDefinition rightFrontLegRot = rightFrontLeg.addOrReplaceChild("right_front_leg_rot", CubeListBuilder.create().texOffs(0, 35).addBox(-11, -1, -1, 12, 2, 2, cubeDef)
		.texOffs(0, 39).addBox(-13, -3, -1, 2, 8, 2, cubeDef), PartPose.rotation(0, -Mth.PI / 4, -Mth.PI / 8));
		rightFrontLegRot.addOrReplaceChild("right_front_leg_down_rot", CubeListBuilder.create().texOffs(8, 39).addBox(-2, -.05F, -1, 2, 8, 2, new CubeDeformation(.01F)), PartPose.offsetAndRotation(-13, .25F, 0, 0, 0, -Mth.PI / 8));
		PartDefinition leftFrontLeg = body.addOrReplaceChild("left_front_leg", CubeListBuilder.create(), PartPose.offset(4, 0, -2));
		PartDefinition leftFrontLegRot = leftFrontLeg.addOrReplaceChild("left_front_leg_rot", CubeListBuilder.create().texOffs(0, 35).mirror().addBox(-1, -1, -1, 12, 2, 2, cubeDef)
		.texOffs(0, 39).mirror().addBox(11, -3, -1, 2, 8, 2, cubeDef), PartPose.rotation(0, Mth.PI / 4, Mth.PI / 8));
		leftFrontLegRot.addOrReplaceChild("left_front_leg_down_rot", CubeListBuilder.create().texOffs(8, 39).mirror().addBox(0, -.05F, -1, 2, 8, 2, new CubeDeformation(.01F)), PartPose.offsetAndRotation(13, .25F, 0, 0, 0, Mth.PI / 8));
		PartDefinition rightMiddleFrontLeg = body.addOrReplaceChild("right_middle_front_leg", CubeListBuilder.create(), PartPose.offset(-4, 0, -1));
		rightMiddleFrontLeg.addOrReplaceChild("right_middle_front_leg_rot", CubeListBuilder.create().texOffs(0, 35).addBox(-11, -1, -1, 12, 2, 2, cubeDef)
		.texOffs(38, 7).addBox(-13, -3, -1, 2, 10, 2, cubeDef), PartPose.rotation(0, -Mth.PI / 12, -.3054F));
		PartDefinition leftMiddleFrontLeg = body.addOrReplaceChild("left_middle_front_leg", CubeListBuilder.create(), PartPose.offset(4, 0, -1));
		leftMiddleFrontLeg.addOrReplaceChild("left_middle_front_leg_rot", CubeListBuilder.create().texOffs(0, 35).mirror().addBox(-1, -1, -1, 12, 2, 2, cubeDef)
		.texOffs(38, 7).mirror().addBox(11, -3, -1, 2, 10, 2, cubeDef), PartPose.rotation(0, Mth.PI / 12, .3054F));
		PartDefinition rightMiddleHindLeg = body.addOrReplaceChild("right_middle_hind_leg", CubeListBuilder.create(), PartPose.offset(-4, 0, 1));
		rightMiddleHindLeg.addOrReplaceChild("right_middle_hind_leg_rot", CubeListBuilder.create().texOffs(0, 35).addBox(-11, -1, -1, 12, 2, 2, cubeDef)
		.texOffs(38, 7).addBox(-13, -3, -1, 2, 10, 2, cubeDef), PartPose.rotation(0, Mth.PI / 12, -.3054F));
		PartDefinition leftMiddleHindLeg = body.addOrReplaceChild("left_middle_hind_leg", CubeListBuilder.create(), PartPose.offset(4, 0, 1));
		leftMiddleHindLeg.addOrReplaceChild("left_middle_hind_leg_rot", CubeListBuilder.create().texOffs(0, 35).mirror().addBox(-1, -1, -1, 12, 2, 2, cubeDef)
		.texOffs(38, 7).mirror().addBox(11, -3, -1, 2, 10, 2, cubeDef), PartPose.rotation(0, -Mth.PI / 12, .3054F));
		PartDefinition rightHindLeg = body.addOrReplaceChild("right_hind_leg", CubeListBuilder.create(), PartPose.offset(-4, 0, 2));
		rightHindLeg.addOrReplaceChild("right_hind_leg_rot", CubeListBuilder.create().texOffs(0, 35).addBox(-11, -1, -1, 12, 2, 2, cubeDef)
		.texOffs(38, 7).addBox(-13, -3, -1, 2, 10, 2, cubeDef), PartPose.rotation(0, Mth.PI / 4, -Mth.PI / 8));
		PartDefinition leftHindLeg = body.addOrReplaceChild("left_hind_leg", CubeListBuilder.create(), PartPose.offset(4, 0, 2));
		leftHindLeg.addOrReplaceChild("left_hind_leg_rot", CubeListBuilder.create().texOffs(0, 35).mirror().addBox(-1, -1, -1, 12, 2, 2, cubeDef)
		.texOffs(38, 7).mirror().addBox(11, -3, -1, 2, 10, 2, cubeDef), PartPose.rotation(0, -Mth.PI / 4, Mth.PI / 8));
		return LayerDefinition.create(meshdefinition, 60, 49);
	}
	@Override public ModelPart root() {return body;}
	@Override public void setupAnim(EntityJungleSpider entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		head.yRot = netHeadYaw * Mth.DEG_TO_RAD;
		head.xRot = headPitch * Mth.DEG_TO_RAD;
		float f = limbSwing * .6662F;
		float f1 = -Mth.cos(f * 2) * .4F * limbSwingAmount;
		float f2 = Mth.sin(f * 2) * .4F * limbSwingAmount;
		float f3 = Math.abs(Mth.sin(f) * .4F) * limbSwingAmount;
		float f4 = Math.abs(Mth.cos(f) * .4F) * limbSwingAmount;
		//TODO: to make a smooth transition for front legs
		if(entity.isAggressive() || (!entity.onGround() && !entity.isClimbing() && !entity.isInWaterOrBubble())) {
			rightMandible.yRot = rightFrontLeg.zRot = Mth.PI / 8;
			leftMandible.yRot = -rightMandible.yRot;
			leftFrontLeg.zRot = -rightFrontLeg.zRot;
			rightFrontLeg.xRot = leftFrontLeg.xRot = -Mth.PI / 3;
		} else {
			rightMandible.yRot = leftMandible.yRot = rightFrontLeg.xRot = leftFrontLeg.xRot = 0;
			rightFrontLeg.zRot = f4;
			leftFrontLeg.zRot = -f4;
		} thorax.xRot = Mth.cos(limbSwing * .6662F) * .25F * limbSwingAmount;
		rightHindLeg.yRot = leftMiddleHindLeg.yRot = f1;
		leftHindLeg.yRot = rightMiddleHindLeg.yRot = -f1;
		rightMiddleFrontLeg.yRot = leftFrontLeg.yRot = f2;
		leftMiddleFrontLeg.yRot = rightFrontLeg.yRot = -f2;
		rightHindLeg.zRot = rightMiddleHindLeg.zRot = f3;
		leftHindLeg.zRot = leftMiddleHindLeg.zRot = -f3;
		rightMiddleFrontLeg.zRot = f4;
		leftMiddleFrontLeg.zRot = -f4;
	}
}