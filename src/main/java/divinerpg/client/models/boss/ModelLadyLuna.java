package divinerpg.client.models.boss;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.boss.EntityLadyLuna;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelLadyLuna extends EntityModel<EntityLadyLuna> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("lady_luna");
	private final ModelPart rightleg;
	private final ModelPart leftleg;
	private final ModelPart leftarm;
	private final ModelPart rightarm;
	private final ModelPart body1;
	private final ModelPart body;
	private final ModelPart head;

	public ModelLadyLuna(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.rightleg = root.getChild("rightleg");
		this.leftleg = root.getChild("leftleg");
		this.leftarm = root.getChild("leftarm");
		this.rightarm = root.getChild("rightarm");
		this.body1 = root.getChild("body1");
		this.body = root.getChild("body");
		this.head = root.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubedef = new CubeDeformation(0.0F);

		PartDefinition rightleg = partdefinition.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(132, 22).mirror().addBox(1.0F, 18.0F, -7.0F, 2.0F, 2.0F, 8.0F, cubedef).mirror(false)
		.texOffs(132, 22).mirror().addBox(-3.0F, 18.0F, -7.0F, 2.0F, 2.0F, 8.0F, cubedef).mirror(false), PartPose.offset(-4.0F, 4.0F, 1.0F));

		rightleg.addOrReplaceChild("rightleg8_r1", CubeListBuilder.create().texOffs(143, 8).mirror().addBox(-5.0F, -18.0F, -6.4F, 2.0F, 8.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(4.0F, 20.0F, -1.0F, -0.3054F, 0.0F, 0.0F));

		rightleg.addOrReplaceChild("rightleg6_r1", CubeListBuilder.create().texOffs(155, 19).mirror().addBox(-5.0F, -11.8F, -1.1F, 2.0F, 11.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(4.0F, 20.0F, -1.0F, 0.1745F, 0.0F, 0.0F));

		rightleg.addOrReplaceChild("rightleg5_r1", CubeListBuilder.create().texOffs(133, 9).mirror().addBox(-4.6F, -9.0F, -10.0F, 1.0F, 8.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(4.0F, 20.0F, -1.0F, -0.5066F, 0.4204F, 0.0174F));

		rightleg.addOrReplaceChild("rightleg4_r1", CubeListBuilder.create().texOffs(156, 10).mirror().addBox(-6.0F, -12.7F, -6.7F, 4.0F, 4.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(4.0F, 20.0F, -1.0F, -0.2618F, 0.0F, 0.0F));

		rightleg.addOrReplaceChild("rightleg3_r1", CubeListBuilder.create().texOffs(172, 1).mirror().addBox(-5.7F, -21.5F, -7.0F, 4.0F, 4.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(4.0F, 20.0F, -1.0F, -0.2621F, 0.0869F, -0.0076F));

		rightleg.addOrReplaceChild("rightleg2_r1", CubeListBuilder.create().texOffs(133, 9).mirror().addBox(-3.5F, -11.0F, -6.8F, 1.0F, 8.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(4.0F, 20.0F, -1.0F, -0.4171F, -0.4077F, -0.0556F));

		PartDefinition leftleg = partdefinition.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(172, 1).mirror().addBox(-2.0F, -2.0681F, -2.4824F, 4.0F, 4.0F, 4.0F, cubedef).mirror(false)
		.texOffs(156, 10).mirror().addBox(-2.0F, 6.9319F, -2.4824F, 4.0F, 4.0F, 4.0F, cubedef).mirror(false)
		.texOffs(143, 8).mirror().addBox(-1.0F, 1.9319F, -1.4824F, 2.0F, 8.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(4.0F, 4.0F, 1.0F, -0.2618F, 0.0F, 0.0F));

		leftleg.addOrReplaceChild("leftleg7_r1", CubeListBuilder.create().texOffs(132, 22).mirror().addBox(1.0F, -1.0F, -1.3F, 2.0F, 2.0F, 8.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-4.0F, 19.9319F, -0.4824F, 0.2618F, 0.0F, 0.0F));

		leftleg.addOrReplaceChild("leftleg6_r1", CubeListBuilder.create().texOffs(155, 19).mirror().addBox(3.0F, -10.0F, 3.3F, 2.0F, 11.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-4.0F, 19.9319F, -0.4824F, 0.4363F, 0.0F, 0.0F));

		leftleg.addOrReplaceChild("leftleg5_r1", CubeListBuilder.create().texOffs(133, 9).mirror().addBox(1.0F, -11.5F, -3.0F, 1.0F, 8.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-4.0F, 19.9319F, -0.4824F, -0.2405F, 0.45F, 0.1113F));

		leftleg.addOrReplaceChild("leftleg2_r1", CubeListBuilder.create().texOffs(133, 9).mirror().addBox(1.0F, -10.8F, -4.0F, 1.0F, 8.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(1.0F, 19.9319F, -0.4824F, -0.2256F, -0.2555F, -0.1166F));

		leftleg.addOrReplaceChild("leftleg1_r1", CubeListBuilder.create().texOffs(132, 22).mirror().addBox(-1.0F, 13.4F, -5.2F, 2.0F, 2.0F, 8.0F, cubedef).mirror(false), PartPose.offsetAndRotation(2.0F, 4.9319F, -0.4824F, 0.2618F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(111, 3).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, cubedef).mirror(false)
		.texOffs(236, 3).mirror().addBox(0.0F, 2.0F, -1.0F, 2.0F, 8.0F, 2.0F, cubedef).mirror(false)
		.texOffs(236, 9).mirror().addBox(0.0F, 10.0F, -1.0F, 2.0F, 8.0F, 2.0F, cubedef).mirror(false)
		.texOffs(237, 23).mirror().addBox(-1.0F, 17.0F, -2.0F, 4.0F, 4.0F, 4.0F, cubedef).mirror(false)
		.texOffs(174, 17).mirror().addBox(0.0F, 19.0F, -9.0F, 2.0F, 3.0F, 12.0F, cubedef).mirror(false)
		.texOffs(193, 1).mirror().addBox(0.5F, 19.5F, -18.0F, 1.0F, 2.0F, 9.0F, cubedef).mirror(false)
		.texOffs(152, 1).mirror().addBox(-1.0F, 19.0F, 3.0F, 4.0F, 3.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(5.0F, -14.25F, -3.0F, 0.0F, 0.0F, -0.1745F));

		partdefinition.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(236, 9).mirror().addBox(-1.0F, 10.0F, -1.0F, 2.0F, 8.0F, 2.0F, cubedef).mirror(false)
		.texOffs(236, 3).mirror().addBox(-1.0F, 2.0F, -1.0F, 2.0F, 8.0F, 2.0F, cubedef).mirror(false)
		.texOffs(111, 3).mirror().addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, cubedef).mirror(false)
		.texOffs(203, 24).mirror().addBox(1.0F, 20.0F, -14.0F, 1.0F, 1.0F, 6.0F, cubedef).mirror(false)
		.texOffs(212, 13).mirror().addBox(-2.0F, 17.0F, -2.0F, 4.0F, 4.0F, 4.0F, cubedef).mirror(false)
		.texOffs(137, 1).mirror().addBox(-1.0F, 18.0F, -5.0F, 2.0F, 2.0F, 4.0F, cubedef).mirror(false)
		.texOffs(219, 23).mirror().addBox(-2.0F, 17.0F, -8.0F, 4.0F, 4.0F, 3.0F, cubedef).mirror(false)
		.texOffs(203, 24).mirror().addBox(1.0F, 17.0F, -14.0F, 1.0F, 1.0F, 6.0F, cubedef).mirror(false)
		.texOffs(203, 24).mirror().addBox(-2.0F, 20.0F, -14.0F, 1.0F, 1.0F, 6.0F, cubedef).mirror(false)
		.texOffs(203, 24).mirror().addBox(-2.0F, 17.0F, -14.0F, 1.0F, 1.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-6.0F, -14.5F, -3.0F, 0.1047F, 0.0F, 0.1745F));

		PartDefinition body1 = partdefinition.addOrReplaceChild("body1", CubeListBuilder.create().texOffs(116, 13).mirror().addBox(-5.0F, 3.0F, 7.0F, 1.0F, 9.0F, 4.0F, cubedef).mirror(false)
		.texOffs(116, 13).mirror().addBox(4.0F, 3.0F, 7.0F, 1.0F, 9.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, -5.0F, 0.0F, 2.1817F, 0.0F, 0.0F));

		body1.addOrReplaceChild("part5_r1", CubeListBuilder.create().texOffs(116, 13).mirror().addBox(-4.0F, 14.0F, 3.0F, 1.0F, 9.0F, 4.0F, cubedef).mirror(false)
		.texOffs(116, 13).mirror().addBox(3.0F, 14.0F, 3.0F, 1.0F, 9.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, -13.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		body1.addOrReplaceChild("part8_r1", CubeListBuilder.create().texOffs(116, 13).mirror().addBox(-5.0F, 13.0F, -4.0F, 1.0F, 9.0F, 4.0F, cubedef).mirror(false)
		.texOffs(116, 13).mirror().addBox(4.0F, 13.0F, -4.0F, 1.0F, 9.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, -13.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(100, 12).mirror().addBox(-2.0F, -4.0F, -1.0F, 6.0F, 9.0F, 2.0F, cubedef).mirror(false)
		.texOffs(89, 23).mirror().addBox(-3.0F, -8.0F, -2.0F, 8.0F, 5.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-1.0F, -9.0F, -1.0F, 0.3491F, 0.0F, 0.0F));

		body.addOrReplaceChild("part4_r1", CubeListBuilder.create().texOffs(62, 19).mirror().addBox(-4.0F, -29.0F, -4.5F, 8.0F, 9.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(1.0F, 33.0F, 1.0F, -0.0436F, 0.0F, 0.0F));

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(3, 8).mirror().addBox(-2.0F, -3.9136F, -1.8389F, 4.0F, 5.0F, 2.0F, cubedef).mirror(false)
		.texOffs(0, 0).mirror().addBox(-3.0F, -6.9136F, -3.8389F, 6.0F, 4.0F, 4.0F, cubedef).mirror(false)
		.texOffs(81, 7).mirror().addBox(-3.0F, -13.9136F, -7.8389F, 1.0F, 1.0F, 8.0F, cubedef).mirror(false)
		.texOffs(53, 1).mirror().addBox(-3.0F, -12.9136F, -1.8389F, 1.0F, 3.0F, 1.0F, cubedef).mirror(false)
		.texOffs(81, 7).mirror().addBox(2.0F, -13.9136F, -7.8389F, 1.0F, 1.0F, 8.0F, cubedef).mirror(false)
		.texOffs(53, 1).mirror().addBox(2.0F, -12.9136F, -1.8389F, 1.0F, 3.0F, 1.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, -17.0F, -3.0F, 0.3491F, 0.0F, 0.0F));

		head.addOrReplaceChild("part26_r1", CubeListBuilder.create().texOffs(45, 6).mirror().addBox(-5.0F, -46.25F, -3.0F, 1.0F, 1.0F, 2.0F, cubedef).mirror(false)
		.texOffs(53, 0).mirror().addBox(3.0F, -53.25F, -4.0F, 2.0F, 3.0F, 7.0F, cubedef).mirror(false)
		.texOffs(73, 0).mirror().addBox(-5.0F, -50.25F, -4.0F, 1.0F, 4.0F, 7.0F, cubedef).mirror(false)
		.texOffs(53, 0).mirror().addBox(-5.0F, -53.25F, -4.0F, 2.0F, 3.0F, 7.0F, cubedef).mirror(false)
		.texOffs(25, 5).mirror().addBox(-3.0F, -51.25F, 2.0F, 6.0F, 1.0F, 1.0F, cubedef).mirror(false)
		.texOffs(57, 11).mirror().addBox(-3.0F, -52.25F, -4.0F, 6.0F, 1.0F, 7.0F, cubedef).mirror(false)
		.texOffs(26, 9).mirror().addBox(-4.0F, -50.25F, 2.0F, 8.0F, 4.0F, 1.0F, cubedef).mirror(false)
		.texOffs(73, 0).mirror().addBox(4.0F, -50.25F, -4.0F, 1.0F, 4.0F, 7.0F, cubedef).mirror(false)
		.texOffs(83, 0).mirror().addBox(-5.0F, -46.25F, -1.0F, 10.0F, 1.0F, 4.0F, cubedef).mirror(false)
		.texOffs(45, 6).mirror().addBox(4.0F, -46.25F, -3.0F, 1.0F, 1.0F, 2.0F, cubedef).mirror(false)
		.texOffs(23, 0).mirror().addBox(-5.0F, -46.25F, -6.0F, 10.0F, 1.0F, 3.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 42.0864F, 2.1611F, 0.0436F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 32);
	}

	@Override
	public void setupAnim(EntityLadyLuna entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.leftleg.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        this.rightleg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
        this.rightarm.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 2.0F * limbSwingAmount * 0.5F);
        this.leftarm.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F + 0.1047198F);
        this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
        this.head.xRot = headPitch / (180F / (float) Math.PI);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		rightleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}