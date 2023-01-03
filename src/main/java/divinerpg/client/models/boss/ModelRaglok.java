package divinerpg.client.models.boss;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.boss.EntityRaglok;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class
ModelRaglok extends EntityModel<EntityRaglok> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("raglok");
	private final ModelPart head;
	private final ModelPart leftarm;
	private final ModelPart rightleg;
	private final ModelPart leftleg;
	private final ModelPart body;
	private final ModelPart leftwing;
	private final ModelPart rightwing;
	private final ModelPart rightarm;

	public ModelRaglok(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.head = root.getChild("head");
		this.leftarm = root.getChild("leftarm");
		this.rightleg = root.getChild("rightleg");
		this.leftleg = root.getChild("leftleg");
		this.body = root.getChild("body");
		this.leftwing = root.getChild("leftwing");
		this.rightwing = root.getChild("rightwing");
		this.rightarm = root.getChild("rightarm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubedef = new CubeDeformation(0.0F);

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(270, 0).mirror().addBox(-10.0F, -16.0F, -6.0F, 20.0F, 16.0F, 16.0F, cubedef).mirror(false)
		.texOffs(341, 19).mirror().addBox(-22.0F, -13.0F, -3.0F, 12.0F, 4.0F, 8.0F, cubedef).mirror(false)
		.texOffs(337, 0).mirror().addBox(-22.0F, -21.0F, -3.0F, 4.0F, 8.0F, 8.0F, cubedef).mirror(false)
		.texOffs(341, 19).mirror().addBox(10.0F, -13.0F, -3.0F, 12.0F, 4.0F, 8.0F, cubedef).mirror(false)
		.texOffs(337, 0).mirror().addBox(18.0F, -21.0F, -3.0F, 4.0F, 8.0F, 8.0F, cubedef).mirror(false), PartPose.offset(0.0F, -44.0F, -15.0F));

		PartDefinition leftarm = partdefinition.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(381, 0).mirror().addBox(5.7615F, 35.25F, -1.4689F, 7.0F, 17.0F, 9.0F, cubedef).mirror(false), PartPose.offsetAndRotation(23.0F, -38.0F, -11.0F, -0.2618F, 0.0F, 0.2618F));

		leftarm.addOrReplaceChild("leftarm4_r1", CubeListBuilder.create().texOffs(126, 2).mirror().addBox(31.5F, -41.0F, -11.0F, 9.0F, 17.0F, 11.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-23.2385F, 64.25F, 8.5311F, 0.0F, 0.0F, -0.0873F));

		leftarm.addOrReplaceChild("leftarm3_r1", CubeListBuilder.create().texOffs(120, 2).mirror().addBox(32.5F, -54.0F, -12.0F, 11.0F, 17.0F, 13.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-23.2385F, 64.25F, 8.5311F, 0.0F, 0.0F, -0.1309F));

		leftarm.addOrReplaceChild("leftarm2_r1", CubeListBuilder.create().texOffs(118, 0).mirror().addBox(35.5F, -61.0F, -13.0F, 13.0F, 17.0F, 15.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-23.2385F, 64.25F, 8.5311F, 0.0F, 0.0F, -0.2182F));

		partdefinition.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(413, 9).mirror().addBox(-10.6667F, 21.0F, -8.0F, 13.0F, 8.0F, 14.0F, cubedef).mirror(false)
		.texOffs(416, 11).mirror().addBox(-10.0F, 13.0F, -7.0F, 11.0F, 8.0F, 12.0F, cubedef).mirror(false)
		.texOffs(416, 11).mirror().addBox(-9.0F, 5.0F, -6.0F, 9.0F, 8.0F, 10.0F, cubedef).mirror(false)
		.texOffs(468, 3).mirror().addBox(-10.0F, -3.0F, -7.0F, 10.0F, 8.0F, 12.0F, cubedef).mirror(false), PartPose.offset(-10.0F, -5.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(413, 9).mirror().addBox(-2.0F, 21.0F, -8.0F, 13.0F, 8.0F, 14.0F, cubedef).mirror(false)
		.texOffs(416, 11).mirror().addBox(-1.0F, 13.0F, -7.0F, 11.0F, 8.0F, 12.0F, cubedef).mirror(false)
		.texOffs(416, 11).mirror().addBox(0.0F, 5.0F, -6.0F, 9.0F, 8.0F, 10.0F, cubedef).mirror(false)
		.texOffs(468, 3).mirror().addBox(0.0F, -3.0F, -7.0F, 10.0F, 8.0F, 12.0F, cubedef).mirror(false), PartPose.offset(10.0F, -5.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(18.0F, -13.0F, -1.0F, 23.0F, 18.0F, 14.0F, cubedef).mirror(false)
		.texOffs(0, 0).mirror().addBox(-4.0F, -13.0F, -1.0F, 22.0F, 18.0F, 14.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-18.0F, -34.0F, -9.0F, 0.5236F, 0.0F, 0.0F));

		body.addOrReplaceChild("part4_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, -54.0F, -24.0F, 14.0F, 18.0F, 14.0F, cubedef).mirror(false), PartPose.offsetAndRotation(18.0F, 58.0F, 9.0F, -0.2443F, 0.0F, 0.0F));

		body.addOrReplaceChild("part3_r1", CubeListBuilder.create().texOffs(1, 0).mirror().addBox(-10.0F, -35.0F, -32.0F, 20.0F, 18.0F, 14.0F, cubedef).mirror(false), PartPose.offsetAndRotation(18.0F, 58.0F, 9.0F, -0.4363F, 0.0F, 0.0F));

		body.addOrReplaceChild("part5_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-14.0F, -54.2F, -23.6F, 14.0F, 18.0F, 14.0F, cubedef).mirror(false), PartPose.offsetAndRotation(18.0F, 58.0F, 9.0F, -0.2356F, 0.0F, 0.0F));

		PartDefinition leftwing = partdefinition.addOrReplaceChild("leftwing", CubeListBuilder.create().texOffs(181, 0).mirror().addBox(-24.0F, 2.0F, -7.0F, 5.0F, 5.0F, 5.0F, cubedef).mirror(false)
		.texOffs(178, 11).mirror().addBox(-24.0F, -14.0F, -6.0F, 3.0F, 18.0F, 3.0F, cubedef).mirror(false)
		.texOffs(181, 0).mirror().addBox(-25.0F, -18.0F, -7.0F, 5.0F, 5.0F, 5.0F, cubedef).mirror(false)
		.texOffs(195, 25).mirror().addBox(-47.0F, -17.0F, -6.0F, 24.0F, 3.0F, 3.0F, cubedef).mirror(false)
		.texOffs(206, 0).mirror().addBox(-45.0F, -14.0F, -4.0F, 23.0F, 18.0F, 0.0F, cubedef).mirror(false)
		.texOffs(195, 25).mirror().addBox(-47.0F, 3.0F, -6.0F, 24.0F, 3.0F, 3.0F, cubedef).mirror(false)
		.texOffs(178, 11).mirror().addBox(-47.0F, -14.0F, -6.0F, 3.0F, 17.0F, 3.0F, cubedef).mirror(false), PartPose.offsetAndRotation(9.0F, -31.0F, 3.0F, -0.5236F, 2.5307F, 0.4363F));

		leftwing.addOrReplaceChild("part20_r1", CubeListBuilder.create().texOffs(16, 0).mirror().addBox(-12.0F, -51.5F, 0.0F, 24.0F, 3.0F, 3.0F, cubedef).mirror(false)
		.texOffs(206, 0).mirror().addBox(-12.1F, -69.5F, 0.0F, 23.0F, 18.0F, 0.0F, cubedef).mirror(false)
		.texOffs(16, 0).mirror().addBox(-12.0F, -72.5F, -1.0F, 24.0F, 3.0F, 3.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-9.0F, 55.0F, -3.0F, 0.0F, -0.2182F, 0.0F));

		PartDefinition rightwing = partdefinition.addOrReplaceChild("rightwing", CubeListBuilder.create().texOffs(195, 25).mirror().addBox(-24.0F, 1.0F, -1.0F, 24.0F, 3.0F, 3.0F, cubedef).mirror(false)
		.texOffs(206, 0).mirror().addBox(-22.0F, -17.0F, 0.0F, 23.0F, 18.0F, 0.0F, cubedef).mirror(false)
		.texOffs(195, 25).mirror().addBox(-24.0F, -20.0F, -1.0F, 24.0F, 3.0F, 3.0F, cubedef).mirror(false)
		.texOffs(181, 0).mirror().addBox(-25.0F, -21.0F, -2.0F, 5.0F, 5.0F, 5.0F, cubedef).mirror(false)
		.texOffs(178, 11).mirror().addBox(-24.0F, -17.0F, -1.0F, 3.0F, 18.0F, 3.0F, cubedef).mirror(false)
		.texOffs(181, 0).mirror().addBox(-25.0F, 0.0F, -2.0F, 5.0F, 5.0F, 5.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-7.0F, -31.0F, 3.0F, 0.3491F, 0.6109F, 0.4363F));

		rightwing.addOrReplaceChild("part26_r1", CubeListBuilder.create().texOffs(206, 0).mirror().addBox(-47.5F, -71.6F, 19.0F, 23.0F, 18.0F, 0.0F, cubedef).mirror(false)
		.texOffs(178, 11).mirror().addBox(-49.5F, -71.6F, 17.0F, 3.0F, 17.0F, 3.0F, cubedef).mirror(false)
		.texOffs(195, 25).mirror().addBox(-49.5F, -74.6F, 17.0F, 24.0F, 3.0F, 3.0F, cubedef).mirror(false)
		.texOffs(195, 25).mirror().addBox(-49.5F, -54.6F, 17.0F, 24.0F, 3.0F, 3.0F, cubedef).mirror(false), PartPose.offsetAndRotation(7.0F, 55.0F, -3.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition rightarm = partdefinition.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(381, 0).mirror().addBox(7.6536F, 34.6019F, -1.6029F, 7.0F, 17.0F, 9.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-21.0F, -37.6F, -6.0F, -2.9136F, 0.1298F, 2.8947F));

		rightarm.addOrReplaceChild("rightarm3_r1", CubeListBuilder.create().texOffs(126, 2).mirror().addBox(31.5F, -41.0F, -11.0F, 9.0F, 17.0F, 11.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-21.3464F, 63.6019F, 8.3971F, 0.0F, 0.0F, -0.0873F));

		rightarm.addOrReplaceChild("rightarm2_r1", CubeListBuilder.create().texOffs(120, 2).mirror().addBox(32.5F, -54.0F, -12.0F, 11.0F, 17.0F, 13.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-21.3464F, 63.6019F, 8.3971F, 0.0F, 0.0F, -0.1309F));

		rightarm.addOrReplaceChild("rightarm1_r1", CubeListBuilder.create().texOffs(118, 0).mirror().addBox(35.5F, -61.0F, -13.0F, 13.0F, 17.0F, 15.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-21.3464F, 63.6019F, 8.3971F, 0.0F, 0.0F, -0.2182F));

		return LayerDefinition.create(meshdefinition, 512, 32);
	}

	@Override
	public void setupAnim(EntityRaglok entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.leftleg.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        this.rightleg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
        this.rightarm.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 2.0F * limbSwingAmount * 0.5F - 0.2617994F);
        this.leftarm.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F + -0.2617994F);
        this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
        this.head.xRot = headPitch / (180F / (float) Math.PI);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftwing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightwing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}