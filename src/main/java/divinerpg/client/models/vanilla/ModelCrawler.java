package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.vanilla.overworld.EntityCrawler;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelCrawler extends EntityModel<EntityCrawler> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("crawler");
	private final ModelPart
		head,
		leftLeg,
		rightLeg,
		body,
		bb_main;

	public ModelCrawler(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.head = root.getChild("head");
		this.leftLeg = root.getChild("leftLeg");
		this.rightLeg = root.getChild("rightLeg");
		this.body = root.getChild("body");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubeDef = new CubeDeformation(0.0F);

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 6.0F, cubeDef).mirror(false)
		.texOffs(5, 1).addBox(-3.0F, 4.0F, -6.0F, 6.0F, 1.0F, 5.0F, cubeDef)
		.texOffs(33, 12).addBox(-3.0F, -2.0F, 0.0F, 6.0F, 5.0F, 1.0F, cubeDef), PartPose.offset(0.0F, 6.0F, -8.0F));

		head.addOrReplaceChild("leftEar", CubeListBuilder.create().texOffs(54, 1).mirror().addBox(0.0F, -2.0F, -1.0F, 0.0F, 4.0F, 5.0F, cubeDef).mirror(false), PartPose.offsetAndRotation(3.0F, -4.0F, -2.0F, 0.0F, 0.4363F, 0.0F));

		head.addOrReplaceChild("rightEar", CubeListBuilder.create().texOffs(54, -4).mirror().addBox(0.0F, -2.0F, -1.0F, 0.0F, 4.0F, 5.0F, cubeDef).mirror(false), PartPose.offsetAndRotation(-3.0F, -4.0F, -2.0F, 0.0F, -0.4363F, 0.0F));

		PartDefinition rightFang = head.addOrReplaceChild("rightFang", CubeListBuilder.create().texOffs(31, 17).addBox(-4.0F, 0.0F, -5.0F, 1.0F, 4.0F, 2.0F, cubeDef), PartPose.offset(-1.0F, -1.0F, 0.0F));

		rightFang.addOrReplaceChild("rightFangLower", CubeListBuilder.create().texOffs(20, 5).mirror().addBox(-1.0F, -1.0F, -3.0F, 1.0F, 2.0F, 4.0F, cubeDef).mirror(false)
		.texOffs(21, 6).addBox(-1.0F, -2.0F, -4.0F, 1.0F, 2.0F, 1.0F, cubeDef), PartPose.offset(-3.0F, 4.0F, -5.0F));

		rightFang.addOrReplaceChild("rightFangHigher", CubeListBuilder.create().texOffs(18, 11).addBox(-1.0F, -2.0F, -2.0F, 1.0F, 2.0F, 2.0F, cubeDef)
		.texOffs(0, 12).addBox(-1.0F, -2.0F, -3.0F, 1.0F, 1.0F, 1.0F, cubeDef), PartPose.offset(-3.0F, 1.0F, -4.0F));

		PartDefinition leftFang = head.addOrReplaceChild("leftFang", CubeListBuilder.create().texOffs(15, 9).addBox(0.0F, -2.0F, -1.0F, 1.0F, 4.0F, 2.0F, cubeDef), PartPose.offset(4.0F, 1.0F, -4.0F));

		leftFang.addOrReplaceChild("leftFangLower", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(-1.0F, -1.0F, -3.0F, 1.0F, 2.0F, 4.0F, cubeDef).mirror(false)
		.texOffs(33, 5).addBox(-1.0F, -2.0F, -4.0F, 1.0F, 2.0F, 1.0F, cubeDef), PartPose.offset(1.0F, 2.0F, -1.0F));

		leftFang.addOrReplaceChild("leftFangHigher", CubeListBuilder.create().texOffs(14, 11).addBox(-1.0F, -2.0F, -2.0F, 1.0F, 2.0F, 2.0F, cubeDef)
		.texOffs(31, 15).addBox(-1.0F, -2.0F, -3.0F, 1.0F, 1.0F, 1.0F, cubeDef), PartPose.offset(1.0F, -1.0F, 0.0F));

		PartDefinition leftLeg = partdefinition.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-1.0F, 0.0F, -3.0F, 4.0F, 9.0F, 4.0F, cubeDef).mirror(false), PartPose.offset(3.0F, 13.0F, -5.0F));

		PartDefinition leftFoot = leftLeg.addOrReplaceChild("leftFoot", CubeListBuilder.create().texOffs(28, 16).mirror().addBox(-2.0F, 0.0F, -4.0F, 4.0F, 2.0F, 5.0F, cubeDef).mirror(false), PartPose.offset(1.0F, 9.0F, 0.0F));

		leftFoot.addOrReplaceChild("claw3_r1", CubeListBuilder.create().texOffs(8, 26).addBox(-1.0F, -0.2F, 1.0F, 2.0F, 2.0F, 3.0F, cubeDef), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		leftFoot.addOrReplaceChild("claw2_r1", CubeListBuilder.create().texOffs(3, 26).addBox(-2.0F, -0.0868F, -4.0687F, 2.0F, 2.0F, 3.0F, cubeDef), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.0511F, 0.2603F, 0.0267F));

		leftFoot.addOrReplaceChild("claw1_r1", CubeListBuilder.create().texOffs(3, 26).addBox(-0.4485F, 0.0F, -1.8489F, 2.0F, 2.0F, 3.0F, cubeDef), PartPose.offsetAndRotation(1.0F, 0.0F, -4.0F, 0.0291F, -0.3493F, 0.0221F));

		PartDefinition rightLeg = partdefinition.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-3.0F, 0.0F, -3.0F, 4.0F, 9.0F, 4.0F, cubeDef).mirror(false), PartPose.offset(-3.0F, 13.0F, -5.0F));

		PartDefinition rightFoot = rightLeg.addOrReplaceChild("rightFoot", CubeListBuilder.create().texOffs(28, 16).mirror().addBox(-2.0F, 0.0F, -4.0F, 4.0F, 2.0F, 5.0F, cubeDef).mirror(false), PartPose.offset(-1.0F, 9.0F, 0.0F));

		rightFoot.addOrReplaceChild("claw3_r2", CubeListBuilder.create().texOffs(8, 26).addBox(-1.0F, -0.2F, 1.0F, 2.0F, 2.0F, 3.0F, cubeDef), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		rightFoot.addOrReplaceChild("claw2_r2", CubeListBuilder.create().texOffs(6, 26).addBox(-2.0F, -0.0868F, -4.0687F, 2.0F, 2.0F, 3.0F, cubeDef), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.0511F, 0.2603F, 0.0267F));

		rightFoot.addOrReplaceChild("claw1_r2", CubeListBuilder.create().texOffs(3, 26).addBox(-0.4485F, 0.0F, -1.8489F, 2.0F, 2.0F, 3.0F, cubeDef), PartPose.offsetAndRotation(1.0F, 0.0F, -4.0F, 0.0291F, -0.3493F, 0.0221F));

		partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offsetAndRotation(7.0F, 15.0F, -6.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		bb_main.addOrReplaceChild("middleHigher_r1", CubeListBuilder.create().texOffs(19, 11).mirror().addBox(-6.0F, -4.1063F, -2.7845F, 12.0F, 5.0F, 7.0F, cubeDef).mirror(false), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		bb_main.addOrReplaceChild("middleLower_r1", CubeListBuilder.create().texOffs(21, 20).mirror().addBox(-5.0F, -3.4892F, -2.2319F, 10.0F, 5.0F, 4.0F, cubeDef).mirror(false), PartPose.offsetAndRotation(0.0F, -3.0F, 4.0F, -1.1345F, 0.0F, 0.0F));

		bb_main.addOrReplaceChild("body4_r1", CubeListBuilder.create().texOffs(19, 19).mirror().addBox(-6.0F, -1.0F, -2.0F, 12.0F, 5.0F, 2.0F, cubeDef).mirror(false), PartPose.offsetAndRotation(0.0F, -2.0F, 4.0F, 1.5708F, 0.0F, 0.0F));

		bb_main.addOrReplaceChild("main_r1", CubeListBuilder.create().texOffs(16, 17).mirror().addBox(-7.0F, -4.0F, -6.0F, 14.0F, 5.0F, 10.0F, cubeDef).mirror(false), PartPose.offsetAndRotation(0.0F, -10.0F, -4.0F, -0.3491F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(EntityCrawler entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
        this.head.xRot = headPitch / (180F / (float) Math.PI);

        this.rightLeg.xRot = (float)Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

        this.leftLeg.xRot = (float)Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount;

        this.rightLeg.yRot = 0.0F;

        this.leftLeg.yRot = 0.0F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, buffer, packedLight, packedOverlay);
		leftLeg.render(poseStack, buffer, packedLight, packedOverlay);
		rightLeg.render(poseStack, buffer, packedLight, packedOverlay);
		body.render(poseStack, buffer, packedLight, packedOverlay);
		bb_main.render(poseStack, buffer, packedLight, packedOverlay);
	}
}