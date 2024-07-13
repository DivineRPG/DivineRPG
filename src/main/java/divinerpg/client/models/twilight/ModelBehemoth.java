package divinerpg.client.models.twilight;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.wildwood.EntityBehemoth;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelBehemoth extends EntityModel<EntityBehemoth> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("behemoth");
	private final ModelPart body, tail, LegL1, LegL2, LegL3, LegL4, LegR1, LegR2, LegR3, LegR4;

	public ModelBehemoth(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.body = root.getChild("body");
		this.tail = root.getChild("tail");
		this.LegL1 = root.getChild("LegL1");
		this.LegL2 = root.getChild("LegL2");
		this.LegL3 = root.getChild("LegL3");
		this.LegL4 = root.getChild("LegL4");
		this.LegR1 = root.getChild("LegR1");
		this.LegR2 = root.getChild("LegR2");
		this.LegR3 = root.getChild("LegR3");
		this.LegR4 = root.getChild("LegR4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.0F, -3.0F, -2.0F, 14.0F, 14.0F, 8.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(46, 17).mirror().addBox(-2.5F, 0.0F, 24.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(46, 17).mirror().addBox(6.5F, 0.0F, 24.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-4.0F, 9.0F, -7.0F));

		body.addOrReplaceChild("Part5_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.0F, -12.0F, -11.0F, 2.0F, 6.0F, 2.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(0, 0).mirror().addBox(-1.0F, -24.0F, -11.0F, 2.0F, 6.0F, 2.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(0, 0).mirror().addBox(-1.0F, -27.0F, -6.0F, 2.0F, 6.0F, 2.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(0, 0).mirror().addBox(-1.0F, -18.0F, -11.0F, 2.0F, 6.0F, 2.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(0, 0).mirror().addBox(-1.0F, -21.0F, -6.0F, 2.0F, 6.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(4.0F, 15.0F, 7.0F, -0.7854F, 0.0F, 0.0F));

		body.addOrReplaceChild("Part8_r1", CubeListBuilder.create().texOffs(44, 0).mirror().addBox(-6.0F, -8.0F, -17.0F, 5.0F, 9.0F, 5.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(44, 0).mirror().addBox(1.0F, -17.0F, -17.0F, 5.0F, 9.0F, 5.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(44, 0).mirror().addBox(1.0F, -17.0F, -10.0F, 5.0F, 9.0F, 5.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(44, 0).mirror().addBox(1.0F, -8.0F, -10.0F, 5.0F, 9.0F, 5.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(44, 0).mirror().addBox(1.0F, -8.0F, -17.0F, 5.0F, 9.0F, 5.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(20, 22).mirror().addBox(-2.5F, -21.0F, -14.0F, 5.0F, 4.0F, 6.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(44, 0).mirror().addBox(-6.0F, -8.0F, -10.0F, 5.0F, 9.0F, 5.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(44, 0).mirror().addBox(-6.0F, -17.0F, -10.0F, 5.0F, 9.0F, 5.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(44, 0).mirror().addBox(-6.0F, -17.0F, -17.0F, 5.0F, 9.0F, 5.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(4.0F, 15.0F, 7.0F, -1.5708F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(46, 18).mirror().addBox(-1.0F, 5.0F, -1.5F, 3.0F, 11.0F, 3.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(9, 22).mirror().addBox(-0.5F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-0.5F, 12.0F, 20.0F, 1.1301F, 0.0F, 0.0F));

		PartDefinition LegL1 = partdefinition.addOrReplaceChild("LegL1", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-8.0F, 3.0F, -1.0F, 2.0F, 8.0F, 2.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(46, 17).mirror().addBox(-9.0F, 5.0F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(0, 2).mirror().addBox(-8.0F, 11.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(50, 15).mirror().addBox(-8.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(5.0F, 11.0F, 1.0F, 0.0F, -3.1416F, 0.0F));

		LegL1.addOrReplaceChild("LegLlimbSwingAmount_r1", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(-6.4F, -14.0F, 10.0F, 2.0F, 10.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-5.0F, 13.0F, -11.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition LegL2 = partdefinition.addOrReplaceChild("LegL2", CubeListBuilder.create().texOffs(46, 17).mirror().addBox(-9.0F, 5.0F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(0, 22).mirror().addBox(-8.0F, 3.0F, -1.0F, 2.0F, 8.0F, 2.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(0, 2).mirror().addBox(-8.0F, 11.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(50, 15).mirror().addBox(-8.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(5.0F, 11.0F, 6.0F, 0.0F, -3.1416F, 0.0F));

		LegL2.addOrReplaceChild("LegLF2_r1", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(-6.4F, -14.0F, 5.0F, 2.0F, 10.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-5.0F, 13.0F, -6.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition LegL3 = partdefinition.addOrReplaceChild("LegL3", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-8.0F, 3.0F, -1.0F, 2.0F, 8.0F, 2.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(0, 2).mirror().addBox(-8.0F, 11.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(46, 17).mirror().addBox(-9.0F, 5.0F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(50, 15).mirror().addBox(-8.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(5.0F, 11.0F, 14.0F, 0.0F, -3.1416F, 0.0F));

		LegL3.addOrReplaceChild("LegL5_r1", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(-6.4F, -14.0F, 23.0F, 2.0F, 10.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-5.0F, 13.0F, -24.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition LegL4 = partdefinition.addOrReplaceChild("LegL4", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-8.0F, 3.0F, -1.0F, 2.0F, 8.0F, 2.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(46, 17).mirror().addBox(-9.0F, 5.0F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(50, 15).mirror().addBox(-8.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(0, 2).mirror().addBox(-8.0F, 11.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(5.0F, 11.0F, 19.0F, 0.0F, -3.1416F, 0.0F));

		LegL4.addOrReplaceChild("LegL6_r1", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(-6.4F, -14.0F, 18.0F, 2.0F, 10.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-5.0F, 13.0F, -19.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition LegR1 = partdefinition.addOrReplaceChild("LegR1", CubeListBuilder.create().texOffs(46, 17).mirror().addBox(-9.0F, 5.0F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(0, 22).mirror().addBox(-8.0F, 3.0F, -1.0F, 2.0F, 8.0F, 2.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(0, 2).mirror().addBox(-8.0F, 11.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(50, 15).mirror().addBox(-8.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-6.0F, 11.0F, 1.0F));

		LegR1.addOrReplaceChild("LegRlimbSwingAmount0_r1", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(-14.2F, -6.0F, 0.0F, 2.0F, 10.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(6.0F, 13.0F, -1.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition LegR2 = partdefinition.addOrReplaceChild("LegR2", CubeListBuilder.create().texOffs(46, 17).mirror().addBox(-9.0F, 5.0F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(0, 22).mirror().addBox(-8.0F, 3.0F, -1.0F, 2.0F, 8.0F, 2.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(0, 2).mirror().addBox(-8.0F, 11.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(50, 15).mirror().addBox(-8.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-6.0F, 11.0F, 6.0F));

		LegR2.addOrReplaceChild("LegRF9_r1", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(-14.2F, -6.0F, 5.0F, 2.0F, 10.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(6.0F, 13.0F, -6.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition LegR3 = partdefinition.addOrReplaceChild("LegR3", CubeListBuilder.create().texOffs(46, 17).mirror().addBox(-9.0F, 5.0F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(0, 22).mirror().addBox(-8.0F, 3.0F, -1.0F, 2.0F, 8.0F, 2.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(50, 15).mirror().addBox(-8.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(0, 2).mirror().addBox(-8.0F, 11.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-6.0F, 11.0F, 14.0F));

		LegR3.addOrReplaceChild("LegR10_r1", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(-14.2F, -6.0F, 13.0F, 2.0F, 10.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(6.0F, 13.0F, -14.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition LegR4 = partdefinition.addOrReplaceChild("LegR4", CubeListBuilder.create().texOffs(46, 17).mirror().addBox(-9.0F, 5.0F, 3.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(0, 22).mirror().addBox(-8.0F, 3.0F, 4.0F, 2.0F, 8.0F, 2.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(0, 2).mirror().addBox(-8.0F, 11.0F, 4.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(50, 15).mirror().addBox(-8.0F, 1.0F, 4.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-6.0F, 11.0F, 14.0F));

		LegR4.addOrReplaceChild("LegR9_r1", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(-14.2F, -6.0F, 18.0F, 2.0F, 10.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(6.0F, 13.0F, -14.0F, 0.0F, 0.0F, 0.7854F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(EntityBehemoth entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.tail.xRot = (float) (Math.cos(ageInTicks * 0.1F) * Math.PI * 0.05F + 1.092891F);

        this.LegL1.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
        this.LegL2.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
        this.LegL3.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        this.LegL4.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);

        this.LegR1.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        this.LegR2.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        this.LegR3.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
        this.LegR4.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		LegL1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		LegL2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		LegL3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		LegL4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		LegR1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		LegR2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		LegR3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		LegR4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}