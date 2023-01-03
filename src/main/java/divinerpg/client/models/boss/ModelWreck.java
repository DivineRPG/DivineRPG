package divinerpg.client.models.boss;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.boss.EntityWreck;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelWreck extends EntityModel<EntityWreck> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("wreck");
	private final ModelPart rightleg, leftleg, leftarm, rightarm, body, head;
	public ModelWreck(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.rightleg = root.getChild("rightleg");
		this.leftleg = root.getChild("leftleg");
		this.leftarm = root.getChild("leftarm");
		this.rightarm = root.getChild("rightarm");
		this.body = root.getChild("body");
		this.head = root.getChild("head");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubedef = new CubeDeformation(0.0F);

		PartDefinition rightleg = partdefinition.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(4, 21).mirror().addBox(1.0F, 8.5031F, -0.8533F, 1.0F, 8.0F, 2.0F, cubedef).mirror(false)
		.texOffs(4, 21).mirror().addBox(-4.0F, 8.5031F, -0.8533F, 1.0F, 8.0F, 2.0F, cubedef).mirror(false)
		.texOffs(0, 16).mirror().addBox(-2.0F, 0.5031F, -0.8533F, 2.0F, 8.0F, 4.0F, cubedef).mirror(false)
		.texOffs(0, 18).mirror().addBox(-3.0F, -0.4969F, -1.8533F, 4.0F, 2.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-3.0F, 9.0F, 2.0F, -0.3491F, 0.0F, 0.0F));

		rightleg.addOrReplaceChild("rightleg8_r1", CubeListBuilder.create().texOffs(0, 24).mirror().addBox(-8.0F, -7.3F, 2.0F, 2.0F, 2.0F, 2.0F, cubedef).mirror(false)
		.texOffs(0, 19).mirror().addBox(-6.0F, -7.3F, 2.0F, 4.0F, 8.0F, 4.0F, cubedef).mirror(false)
		.texOffs(0, 24).mirror().addBox(-2.0F, -7.3F, 2.0F, 2.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(3.0F, 15.5031F, -0.8533F, 0.3491F, 0.0F, 0.0F));

		PartDefinition leftleg = partdefinition.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(4, 21).mirror().addBox(4.0F, 5.0F, 0.0F, 1.0F, 8.0F, 2.0F, cubedef).mirror(false)
		.texOffs(4, 21).mirror().addBox(-1.0F, 5.0F, 0.0F, 1.0F, 8.0F, 2.0F, cubedef).mirror(false)
		.texOffs(0, 17).mirror().addBox(1.0F, -3.0F, 0.0F, 2.0F, 8.0F, 4.0F, cubedef).mirror(false)
		.texOffs(0, 19).mirror().addBox(0.0F, -4.0F, -1.0F, 4.0F, 2.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(2.0F, 12.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		leftleg.addOrReplaceChild("leftleg8_r1", CubeListBuilder.create().texOffs(0, 25).mirror().addBox(0.0F, -7.3F, 2.0F, 2.0F, 2.0F, 2.0F, cubedef).mirror(false)
		.texOffs(0, 20).mirror().addBox(2.0F, -7.3F, 2.0F, 4.0F, 8.0F, 4.0F, cubedef).mirror(false)
		.texOffs(0, 25).mirror().addBox(6.0F, -7.3F, 2.0F, 2.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-2.0F, 12.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition leftarm = partdefinition.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(7.0F, 2.0F, -3.0F, 1.0F, 10.0F, 4.0F, cubedef).mirror(false)
		.texOffs(40, 16).mirror().addBox(2.0F, 2.0F, -3.0F, 1.0F, 10.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.4363F, 0.0F, 0.0F));

		leftarm.addOrReplaceChild("leftarm5_r1", CubeListBuilder.create().texOffs(54, 0).mirror().addBox(12.0F, -15.0F, 7.0F, 1.0F, 10.0F, 4.0F, cubedef).mirror(false)
		.texOffs(54, 0).mirror().addBox(7.0F, -15.0F, 7.0F, 1.0F, 10.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-5.0F, 22.0F, 0.0F, 1.3963F, 0.0F, 0.0F));

		leftarm.addOrReplaceChild("leftarm2_r1", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(8.0F, -10.0F, -13.0F, 4.0F, 7.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-5.0F, 22.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		leftarm.addOrReplaceChild("leftarm3_r1", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(8.0F, -23.0F, -11.0F, 4.0F, 7.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-5.0F, 22.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-7.0F, -3.0F, -2.0F, 4.0F, 7.0F, 4.0F, cubedef).mirror(false)
		.texOffs(40, 18).mirror().addBox(-6.0F, 4.0F, -1.0F, 2.0F, 4.0F, 2.0F, cubedef).mirror(false)
		.texOffs(40, 16).mirror().addBox(-7.0F, 8.0F, -2.0F, 4.0F, 4.0F, 4.0F, cubedef).mirror(false)
		.texOffs(40, 18).mirror().addBox(-6.0F, 11.0F, -1.0F, 2.0F, 4.0F, 2.0F, cubedef).mirror(false)
		.texOffs(40, 16).mirror().addBox(-7.0F, 15.0F, -4.0F, 2.0F, 4.0F, 4.0F, cubedef).mirror(false)
		.texOffs(40, 16).mirror().addBox(-5.0F, 15.0F, -4.0F, 2.0F, 4.0F, 4.0F, cubedef).mirror(false)
		.texOffs(40, 16).mirror().addBox(-7.0F, 15.0F, 0.0F, 2.0F, 4.0F, 4.0F, cubedef).mirror(false)
		.texOffs(40, 16).mirror().addBox(-5.0F, 15.0F, 0.0F, 2.0F, 4.0F, 4.0F, cubedef).mirror(false), PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(19, 0).mirror().addBox(-5.0F, 5.0F, -3.0F, 8.0F, 2.0F, 4.0F, cubedef).mirror(false)
		.texOffs(19, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 6.0F, 12.0F, 2.0F, cubedef).mirror(false)
		.texOffs(19, 0).mirror().addBox(-5.0F, 9.0F, -3.0F, 8.0F, 2.0F, 4.0F, cubedef).mirror(false)
		.texOffs(19, 0).mirror().addBox(-5.0F, 1.0F, -3.0F, 8.0F, 2.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(1.0F, -1.0F, -2.0F, 0.4363F, 0.0F, 0.0F));

		body.addOrReplaceChild("leftarm1_r1", CubeListBuilder.create().texOffs(42, 20).mirror().addBox(-12.8F, -23.0F, -11.5F, 4.0F, 10.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-1.0F, 25.0F, 2.0F, -0.3052F, 0.3169F, 0.7799F));

		body.addOrReplaceChild("rightarm2_r1", CubeListBuilder.create().texOffs(42, 20).mirror().addBox(9.0F, -23.0F, -11.5F, 4.0F, 10.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-1.0F, 25.0F, 2.0F, -0.2997F, -0.3221F, -0.7974F));

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(5, 0).mirror().addBox(1.0F, -7.0F, -4.0F, 3.0F, 8.0F, 8.0F, cubedef).mirror(false)
		.texOffs(16, 9).mirror().addBox(-1.0F, -4.0F, -2.0F, 2.0F, 3.0F, 3.0F, cubedef).mirror(false)
		.texOffs(0, 0).mirror().addBox(-4.0F, -7.0F, -4.0F, 3.0F, 8.0F, 8.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, -1.0F, -3.0F, 0.1396F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}
	@Override
	public void setupAnim(EntityWreck entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.leftleg.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);

        this.rightleg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);

        this.rightarm.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 2.0F * limbSwingAmount * 0.5F);

        this.leftarm.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F);
        this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
        this.head.xRot = headPitch / (180F / (float) Math.PI);
	}
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		rightleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
	public static LayerDefinition createArcanicBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubedef = new CubeDeformation(0.0F);

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -7.0F, -4.0F, 3.0F, 8.0F, 8.0F, cubedef).mirror(false)
		.texOffs(16, 9).mirror().addBox(-1.0F, -4.0F, -2.0F, 2.0F, 3.0F, 3.0F, cubedef).mirror(false)
		.texOffs(5, 0).mirror().addBox(1.0F, -7.0F, -4.0F, 3.0F, 8.0F, 8.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, -1.0F, -3.0F, 0.1396F, 0.0F, 0.0F));

		PartDefinition rightleg = partdefinition.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-3.0F, -3.0F, 0.0F, 2.0F, 8.0F, 4.0F, cubedef).mirror(false)
		.texOffs(0, 18).mirror().addBox(-4.0F, -4.0F, -1.0F, 4.0F, 2.0F, 6.0F, cubedef).mirror(false)
		.texOffs(4, 21).mirror().addBox(-5.0F, 4.6F, -0.6F, 1.0F, 8.0F, 2.0F, cubedef).mirror(false)
		.texOffs(4, 21).mirror().addBox(0.0F, 4.6F, -0.6F, 1.0F, 8.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-2.0F, 12.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		rightleg.addOrReplaceChild("rightleg8_r1", CubeListBuilder.create().texOffs(0, 24).mirror().addBox(-8.0F, -7.3F, 2.0F, 2.0F, 2.0F, 2.0F, cubedef).mirror(false)
		.texOffs(0, 24).mirror().addBox(-2.0F, -7.3F, 2.0F, 2.0F, 2.0F, 2.0F, cubedef).mirror(false)
		.texOffs(0, 19).mirror().addBox(-6.0F, -7.3F, 2.0F, 4.0F, 8.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(2.0F, 12.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(19, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 6.0F, 12.0F, 2.0F, cubedef).mirror(false)
		.texOffs(19, 0).mirror().addBox(-5.0F, 9.0F, -3.0F, 8.0F, 2.0F, 4.0F, cubedef).mirror(false)
		.texOffs(19, 0).mirror().addBox(-5.0F, 5.0F, -3.0F, 8.0F, 2.0F, 4.0F, cubedef).mirror(false)
		.texOffs(19, 0).mirror().addBox(-5.0F, 1.0F, -3.0F, 8.0F, 2.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(1.0F, -1.0F, -2.0F, 0.4363F, 0.0F, 0.0F));

		body.addOrReplaceChild("leftarm1_r1", CubeListBuilder.create().texOffs(42, 20).mirror().addBox(-13.5F, -22.6F, -11.5F, 4.0F, 10.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-1.0F, 25.0F, 2.0F, -0.2912F, 0.3297F, 0.8239F));

		body.addOrReplaceChild("rightarm1_r1", CubeListBuilder.create().texOffs(42, 20).mirror().addBox(9.3F, -22.6F, -11.5F, 4.0F, 10.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-1.0F, 25.0F, 2.0F, -0.2912F, -0.3297F, -0.8239F));

		PartDefinition leftleg = partdefinition.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(0, 25).mirror().addBox(-2.0F, 4.0F, -2.0F, 2.0F, 2.0F, 2.0F, cubedef).mirror(false)
		.texOffs(0, 20).mirror().addBox(0.0F, 4.0F, -2.0F, 4.0F, 8.0F, 4.0F, cubedef).mirror(false)
		.texOffs(0, 25).mirror().addBox(4.0F, 4.0F, -2.0F, 2.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offset(2.0F, 12.0F, 0.0F));

		leftleg.addOrReplaceChild("leftleg4_r1", CubeListBuilder.create().texOffs(4, 21).mirror().addBox(1.0F, -6.3F, -5.2F, 1.0F, 8.0F, 2.0F, cubedef).mirror(false)
		.texOffs(4, 21).mirror().addBox(6.0F, -6.3F, -5.2F, 1.0F, 8.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-2.0F, 12.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

		leftleg.addOrReplaceChild("leftleg1_r1", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(2.0F, -15.3F, -5.1F, 4.0F, 2.0F, 6.0F, cubedef).mirror(false)
		.texOffs(0, 17).mirror().addBox(3.0F, -14.3F, -4.1F, 2.0F, 8.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-2.0F, 12.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition rightarm = partdefinition.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-7.0F, -3.0F, -2.0F, 4.0F, 7.0F, 4.0F, cubedef).mirror(false)
		.texOffs(40, 16).mirror().addBox(-6.0F, 2.0F, -1.0F, 2.0F, 7.0F, 2.0F, cubedef).mirror(false)
		.texOffs(40, 16).mirror().addBox(-7.0F, 7.0F, -2.0F, 4.0F, 5.0F, 4.0F, cubedef).mirror(false), PartPose.offset(-5.0F, 2.0F, 0.0F));

		rightarm.addOrReplaceChild("rightarm13_r1", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(21.0F, 6.0F, -3.0F, 2.0F, 5.0F, 1.0F, cubedef).mirror(false)
		.texOffs(40, 16).mirror().addBox(21.0F, 6.0F, -1.0F, 2.0F, 5.0F, 1.0F, cubedef).mirror(false)
		.texOffs(40, 16).mirror().addBox(21.0F, 6.0F, 0.0F, 2.0F, 5.0F, 1.0F, cubedef).mirror(false)
		.texOffs(40, 16).mirror().addBox(21.0F, 6.0F, 2.0F, 2.0F, 5.0F, 1.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-19.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.6545F));

		rightarm.addOrReplaceChild("rightarm6_r1", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(11.0F, -26.0F, 2.0F, 2.0F, 5.0F, 1.0F, cubedef).mirror(false)
		.texOffs(40, 16).mirror().addBox(11.0F, -26.0F, 0.0F, 2.0F, 5.0F, 1.0F, cubedef).mirror(false)
		.texOffs(40, 16).mirror().addBox(11.0F, -26.0F, -1.0F, 2.0F, 5.0F, 1.0F, cubedef).mirror(false)
		.texOffs(40, 16).mirror().addBox(11.0F, -26.0F, -3.0F, 2.0F, 5.0F, 1.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-19.0F, -8.0F, 0.0F, 0.0F, 0.0F, 2.2253F));

		PartDefinition leftarm = partdefinition.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(3.0F, 8.0F, -2.0F, 4.0F, 4.0F, 4.0F, cubedef).mirror(false)
		.texOffs(40, 16).mirror().addBox(3.0F, 8.0F, -9.0F, 4.0F, 4.0F, 4.0F, cubedef).mirror(false)
		.texOffs(38, 7).mirror().addBox(3.0F, -9.0F, -9.0F, 4.0F, 4.0F, 4.0F, cubedef).mirror(false)
		.texOffs(56, 0).mirror().addBox(4.0F, -7.0F, -8.0F, 2.0F, 30.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, -0.1047F, 0.0F, 0.0F));

		leftarm.addOrReplaceChild("leftarm9_r1", CubeListBuilder.create().texOffs(28, 7).mirror().addBox(16.2F, -31.0F, -8.0F, 3.0F, 6.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-5.0F, 22.0F, 0.0F, 0.0F, 0.0F, -0.3054F));

		leftarm.addOrReplaceChild("leftarm2_r1", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(9.0F, -7.0F, 11.0F, 2.0F, 7.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-5.0F, 22.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		leftarm.addOrReplaceChild("leftarm4_r1", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(9.0F, -19.0F, -1.2F, 2.0F, 7.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-5.0F, 22.0F, 0.0F, -0.0262F, 0.0F, 0.0F));

		leftarm.addOrReplaceChild("leftarm3_r1", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(8.0F, -25.0F, -1.3F, 4.0F, 7.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-5.0F, 22.0F, 0.0F, 0.0349F, 0.0F, 0.0F));

		leftarm.addOrReplaceChild("leftarm6_r1", CubeListBuilder.create().texOffs(28, 7).mirror().addBox(-1.5F, -37.0F, -8.3F, 3.0F, 6.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-5.0F, 22.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}
}