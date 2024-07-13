package divinerpg.client.models.boss;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.boss.EntityWreck;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelWreckRanged extends EntityModel<EntityWreck> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("wreck_ranged");
	private final ModelPart rightleg, leftleg, body, head, leftarm, cannon, rightarm;
	public ModelWreckRanged(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.rightleg = root.getChild("rightleg");
		this.leftleg = root.getChild("leftleg");
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.leftarm = root.getChild("leftarm");
		this.cannon = root.getChild("cannon");
		this.rightarm = root.getChild("rightarm");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubedef = new CubeDeformation(0.0F);

		PartDefinition rightleg = partdefinition.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-3.0F, -3.0F, 0.0F, 2.0F, 8.0F, 4.0F, cubedef).mirror(false)
		.texOffs(0, 18).mirror().addBox(-4.0F, -4.0F, -1.0F, 4.0F, 2.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-2.0F, 12.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		rightleg.addOrReplaceChild("rightleg2_r1", CubeListBuilder.create().texOffs(4, 21).mirror().addBox(-2.0F, -7.0F, -1.5F, 1.0F, 8.0F, 2.0F, cubedef).mirror(false)
		.texOffs(4, 21).mirror().addBox(-7.0F, -7.0F, -1.5F, 1.0F, 8.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(2.0F, 12.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		rightleg.addOrReplaceChild("rightleg8_r1", CubeListBuilder.create().texOffs(0, 24).mirror().addBox(-8.0F, -7.3F, 2.1F, 2.0F, 2.0F, 2.0F, cubedef).mirror(false)
		.texOffs(0, 24).mirror().addBox(-2.0F, -7.3F, 2.1F, 2.0F, 2.0F, 2.0F, cubedef).mirror(false)
		.texOffs(0, 19).mirror().addBox(-6.0F, -7.3F, 2.1F, 4.0F, 8.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(2.0F, 12.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition leftleg = partdefinition.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(0, 17).mirror().addBox(1.0F, -3.0F, 0.0F, 2.0F, 8.0F, 4.0F, cubedef).mirror(false)
		.texOffs(0, 19).mirror().addBox(0.0F, -4.0F, -1.0F, 4.0F, 2.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(2.0F, 12.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		leftleg.addOrReplaceChild("leftleg5_r1", CubeListBuilder.create().texOffs(4, 21).mirror().addBox(6.0F, -7.0F, -1.5F, 1.0F, 8.0F, 2.0F, cubedef).mirror(false)
		.texOffs(4, 21).mirror().addBox(1.0F, -7.0F, -1.5F, 1.0F, 8.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-2.0F, 12.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		leftleg.addOrReplaceChild("leftleg3_r1", CubeListBuilder.create().texOffs(0, 25).mirror().addBox(6.0F, -7.3F, 2.1F, 2.0F, 2.0F, 2.0F, cubedef).mirror(false)
		.texOffs(0, 25).mirror().addBox(0.0F, -7.3F, 2.1F, 2.0F, 2.0F, 2.0F, cubedef).mirror(false)
		.texOffs(0, 20).mirror().addBox(2.0F, -7.3F, 2.1F, 4.0F, 8.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-2.0F, 12.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(19, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 6.0F, 12.0F, 2.0F, cubedef).mirror(false)
		.texOffs(19, 20).mirror().addBox(-5.0F, 9.0F, -3.0F, 8.0F, 2.0F, 4.0F, cubedef).mirror(false)
		.texOffs(19, 20).mirror().addBox(-5.0F, 5.0F, -3.0F, 8.0F, 2.0F, 4.0F, cubedef).mirror(false)
		.texOffs(19, 20).mirror().addBox(-5.0F, 1.0F, -3.0F, 8.0F, 2.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(1.0F, -1.0F, -2.0F, 0.4363F, 0.0F, 0.0F));

		body.addOrReplaceChild("part3_r1", CubeListBuilder.create().texOffs(42, 20).mirror().addBox(-11.8F, -23.9F, -11.5F, 4.0F, 10.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-1.0F, 25.0F, 2.0F, -0.3185F, 0.3035F, 0.7363F));

		body.addOrReplaceChild("part4_r1", CubeListBuilder.create().texOffs(42, 20).mirror().addBox(8.3F, -23.2F, -11.5F, 4.0F, 10.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-1.0F, 25.0F, 2.0F, -0.3185F, -0.3035F, -0.7363F));

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(5, 0).mirror().addBox(1.0F, -7.0F, -4.0F, 3.0F, 8.0F, 8.0F, cubedef).mirror(false)
		.texOffs(16, 9).mirror().addBox(-1.0F, -4.0F, -2.0F, 2.0F, 3.0F, 3.0F, cubedef).mirror(false)
		.texOffs(0, 0).mirror().addBox(-4.0F, -7.0F, -4.0F, 3.0F, 8.0F, 8.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, -1.0F, -3.0F, 0.1396F, 0.0F, 0.0F));

		PartDefinition leftarm = partdefinition.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(4.0F, 3.0F, -1.0F, 2.0F, 7.0F, 2.0F, cubedef).mirror(false)
		.texOffs(40, 16).mirror().addBox(3.0F, 8.0F, -2.0F, 4.0F, 4.0F, 4.0F, cubedef).mirror(false)
		.texOffs(15, 18).mirror().addBox(2.0F, 11.0F, -3.0F, 6.0F, 2.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, -1.1345F, -0.5236F, 0.0F));

		leftarm.addOrReplaceChild("part35_r1", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-3.0F, 3.2082F, -1.0624F, 4.0F, 7.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(6.0F, 0.0F, -8.0F, 1.0314F, 0.1848F, 0.2978F));

		PartDefinition cannon = partdefinition.addOrReplaceChild("cannon", CubeListBuilder.create().texOffs(19, 0).mirror().addBox(2.0F, -8.0F, 4.0F, 16.0F, 1.0F, 1.0F, cubedef).mirror(false)
		.texOffs(19, 0).mirror().addBox(5.0F, -7.0F, 4.0F, 2.0F, 1.0F, 1.0F, cubedef).mirror(false)
		.texOffs(19, 0).mirror().addBox(2.0F, -6.0F, 4.0F, 16.0F, 1.0F, 1.0F, cubedef).mirror(false)
		.texOffs(19, 0).mirror().addBox(13.0F, -7.0F, 4.0F, 2.0F, 1.0F, 1.0F, cubedef).mirror(false)
		.texOffs(19, 0).mirror().addBox(13.0F, -5.0F, 4.0F, 2.0F, 3.0F, 1.0F, cubedef).mirror(false)
		.texOffs(19, 0).mirror().addBox(5.0F, -5.0F, 4.0F, 2.0F, 3.0F, 1.0F, cubedef).mirror(false)
		.texOffs(19, 0).mirror().addBox(4.0F, -2.0F, 4.0F, 12.0F, 2.0F, 1.0F, cubedef).mirror(false)
		.texOffs(38, 5).mirror().addBox(0.0F, -2.0F, -1.0F, 4.0F, 2.0F, 9.0F, cubedef).mirror(false)
		.texOffs(38, 5).mirror().addBox(8.0F, -2.0F, -1.0F, 4.0F, 2.0F, 9.0F, cubedef).mirror(false)
		.texOffs(38, 5).mirror().addBox(16.0F, -2.0F, -1.0F, 4.0F, 2.0F, 9.0F, cubedef).mirror(false)
		.texOffs(58, 18).mirror().addBox(16.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F, cubedef).mirror(false)
		.texOffs(58, 18).mirror().addBox(19.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F, cubedef).mirror(false)
		.texOffs(58, 18).mirror().addBox(11.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F, cubedef).mirror(false)
		.texOffs(58, 18).mirror().addBox(8.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F, cubedef).mirror(false)
		.texOffs(58, 18).mirror().addBox(3.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F, cubedef).mirror(false)
		.texOffs(58, 18).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F, cubedef).mirror(false), PartPose.offset(-10.0F, 12.0F, -11.0F));

		cannon.addOrReplaceChild("Shape17_r1", CubeListBuilder.create().texOffs(1, 25).mirror().addBox(-0.3F, 2.0F, -2.0F, 7.0F, 3.0F, 3.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-4.0F, -9.0F, 5.0F, 0.0F, 0.0F, -0.1745F));

		cannon.addOrReplaceChild("Shape12_r1", CubeListBuilder.create().texOffs(38, 5).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 9.0F, cubedef).mirror(false)
		.texOffs(38, 5).mirror().addBox(15.0F, 0.0F, 0.0F, 2.0F, 2.0F, 9.0F, cubedef).mirror(false)
		.texOffs(38, 5).mirror().addBox(7.0F, 0.0F, 0.0F, 2.0F, 2.0F, 9.0F, cubedef).mirror(false), PartPose.offsetAndRotation(2.0F, 2.0F, -1.0F, 0.4363F, 0.0F, 0.0F));

		cannon.addOrReplaceChild("Shape15_r1", CubeListBuilder.create().texOffs(27, 11).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(2.0F, -2.0F, 0.0F, 0.6196F, 0.0F, 0.0F));

		cannon.addOrReplaceChild("Shape23_r1", CubeListBuilder.create().texOffs(27, 11).mirror().addBox(-2.0F, 0.0F, 0.0F, 2.0F, 1.0F, 4.0F, cubedef).mirror(false)
		.texOffs(27, 11).mirror().addBox(-18.0F, 0.0F, 0.0F, 2.0F, 1.0F, 4.0F, cubedef).mirror(false)
		.texOffs(27, 11).mirror().addBox(-10.0F, 0.0F, 0.0F, 2.0F, 1.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(19.0F, -2.0F, 3.0F, 0.6109F, 0.0F, 0.0F));

		cannon.addOrReplaceChild("Shape22_r1", CubeListBuilder.create().texOffs(27, 11).mirror().addBox(-2.0F, 0.0F, 0.0F, 2.0F, 1.0F, 4.0F, cubedef).mirror(false)
		.texOffs(27, 11).mirror().addBox(-10.0F, 0.0F, 0.0F, 2.0F, 1.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(19.0F, -2.0F, 0.0F, 0.6109F, 0.0F, 0.0F));

		cannon.addOrReplaceChild("Shape3_r1", CubeListBuilder.create().texOffs(1, 25).mirror().addBox(-5.0F, 0.0F, -1.0F, 7.0F, 3.0F, 3.0F, cubedef).mirror(false), PartPose.offsetAndRotation(22.0F, -7.0F, 4.0F, 0.0F, 0.0F, 0.2531F));

		PartDefinition rightarm = partdefinition.addOrReplaceChild("rightarm", CubeListBuilder.create(), PartPose.offsetAndRotation(-12.0F, 1.0F, 0.0F, -1.0883F, 0.0813F, 0.0584F));

		rightarm.addOrReplaceChild("part12_r1", CubeListBuilder.create().texOffs(15, 18).mirror().addBox(-2.6F, 7.1F, -3.0F, 6.0F, 2.0F, 6.0F, cubedef).mirror(false)
		.texOffs(40, 16).mirror().addBox(-1.6F, 4.1F, -2.0F, 4.0F, 4.0F, 4.0F, cubedef).mirror(false)
		.texOffs(40, 16).mirror().addBox(-0.6F, -0.9F, -1.0F, 2.0F, 7.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-0.7942F, 1.9216F, 1.9018F, 0.0F, 0.0F, 0.1745F));

		rightarm.addOrReplaceChild("part36_r1", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(0.0F, 4.2082F, -1.0624F, 4.0F, 7.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-1.7942F, -4.0784F, -6.0982F, 1.0105F, 0.0934F, 0.1476F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}
	@Override
	public void setupAnim(EntityWreck entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.leftleg.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        this.rightleg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
        this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
        this.head.xRot = headPitch / (180F / (float) Math.PI);
	}
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		rightleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		cannon.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}