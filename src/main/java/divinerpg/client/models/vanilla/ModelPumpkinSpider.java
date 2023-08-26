package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.vanilla.overworld.EntityPumpkinSpider;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelPumpkinSpider<T extends EntityPumpkinSpider> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("pumpkin_spider");
	private final ModelPart Head;
	private final ModelPart LeftLeg4;
	private final ModelPart LeftLeg3;
	private final ModelPart LeftLeg2;
	private final ModelPart LeftLeg1;
	private final ModelPart RightLeg4;
	private final ModelPart RightLeg3;
	private final ModelPart RightLeg2;
	private final ModelPart RightLeg1;
	private final ModelPart Body;
	private final ModelPart Thorax;

	public ModelPumpkinSpider(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Head = root.getChild("Head");
		this.LeftLeg4 = root.getChild("LeftLeg4");
		this.LeftLeg3 = root.getChild("LeftLeg3");
		this.LeftLeg2 = root.getChild("LeftLeg2");
		this.LeftLeg1 = root.getChild("LeftLeg1");
		this.RightLeg4 = root.getChild("RightLeg4");
		this.RightLeg3 = root.getChild("RightLeg3");
		this.RightLeg2 = root.getChild("RightLeg2");
		this.RightLeg1 = root.getChild("RightLeg1");
		this.Body = root.getChild("Body");
		this.Thorax = root.getChild("Thorax");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(38, 32).addBox(-5.0F, -4.0F, -8.0F, 10.0F, 9.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, -7.0F));

		PartDefinition LeftLeg4 = partdefinition.addOrReplaceChild("LeftLeg4", CubeListBuilder.create(), PartPose.offset(4.0F, 17.0F, 2.0F));

		LeftLeg4.addOrReplaceChild("leftleg4_r1", CubeListBuilder.create().texOffs(0, 49).addBox(1.0F, -1.0F, -1.0F, 14.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -1.0F, -1.0F));

		PartDefinition LeftLeg3 = partdefinition.addOrReplaceChild("LeftLeg3", CubeListBuilder.create(), PartPose.offset(4.0F, 17.0F, -1.0F));

		LeftLeg3.addOrReplaceChild("leftleg3_r1", CubeListBuilder.create().texOffs(32, 49).addBox(1.0F, -1.0F, -1.0F, 14.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -1.0F, 0.0F));

		PartDefinition LeftLeg2 = partdefinition.addOrReplaceChild("LeftLeg2", CubeListBuilder.create(), PartPose.offset(4.0F, 17.0F, -3.0F));

		LeftLeg2.addOrReplaceChild("leftleg2_r1", CubeListBuilder.create().texOffs(0, 53).addBox(1.0F, -1.0F, -1.0F, 14.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -1.0F, 0.0F));

		PartDefinition LeftLeg1 = partdefinition.addOrReplaceChild("LeftLeg1", CubeListBuilder.create(), PartPose.offset(4.0F, 17.0F, -5.0F));

		LeftLeg1.addOrReplaceChild("leftleg1_r1", CubeListBuilder.create().texOffs(32, 53).addBox(1.0F, -1.0F, -1.0F, 14.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -1.0F, 0.0F));

		PartDefinition RightLeg4 = partdefinition.addOrReplaceChild("RightLeg4", CubeListBuilder.create(), PartPose.offset(-4.0F, 17.0F, 2.0F));

		RightLeg4.addOrReplaceChild("rightleg4_r1", CubeListBuilder.create().texOffs(48, 12).addBox(-15.0F, -1.0F, -1.0F, 14.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -1.0F, -1.0F));

		PartDefinition RightLeg3 = partdefinition.addOrReplaceChild("RightLeg3", CubeListBuilder.create(), PartPose.offset(-4.0F, 17.0F, -1.0F));

		RightLeg3.addOrReplaceChild("rightleg3_r1", CubeListBuilder.create().texOffs(48, 8).addBox(-15.0F, -1.0F, -1.0F, 14.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -1.0F, 0.0F));

		PartDefinition RightLeg2 = partdefinition.addOrReplaceChild("RightLeg2", CubeListBuilder.create(), PartPose.offset(-4.0F, 17.0F, -3.0F));

		RightLeg2.addOrReplaceChild("rightleg2_r1", CubeListBuilder.create().texOffs(48, 4).addBox(-15.0F, -1.0F, -1.0F, 14.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -1.0F, 0.0F));

		PartDefinition RightLeg1 = partdefinition.addOrReplaceChild("RightLeg1", CubeListBuilder.create(), PartPose.offset(-4.0F, 17.0F, -5.0F));

		RightLeg1.addOrReplaceChild("rightleg1_r1", CubeListBuilder.create().texOffs(48, 0).addBox(-15.0F, -1.0F, -1.0F, 14.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -1.0F, 0.0F));

		partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 32).addBox(-4.0F, -12.0F, -7.0F, 8.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Thorax = partdefinition.addOrReplaceChild("Thorax", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		Thorax.addOrReplaceChild("thorax_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -11.0F, 2.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.2618F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public void prepareMobModel(EntityPumpkinSpider entityIn, float p_102615_, float p_102616_, float p_102617_) {
		this.Body.visible = this.Head.visible = this.RightLeg1.visible = this.RightLeg2.visible =
		this.RightLeg3.visible = this.RightLeg4.visible = this.LeftLeg1.visible = this.LeftLeg2.visible =
		this.LeftLeg3.visible = this.LeftLeg4.visible = entityIn.getProvoked();
	}

	@Override
	public void setupAnim(EntityPumpkinSpider entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Head.yRot = netHeadYaw * ((float)Math.PI / 180F);
		this.Head.xRot = headPitch * ((float)Math.PI / 180F);
		this.Thorax.xRot = Mth.cos(limbSwing * 0.6662F) * 0.25F * limbSwingAmount;
		if (!entity.getProvoked()) {
			this.Thorax.xRot = 5F * (float)Math.PI / 12F;
			this.Thorax.y = 24F;
			this.Thorax.z = 3.5F;
		} else {
			this.Thorax.y = 14F;
			this.Thorax.z = 2F;
		}
		float f = ((float)Math.PI / 6F);
		this.RightLeg4.zRot = -f;
		this.LeftLeg4.zRot = f;
		this.RightLeg3.zRot = -f;
		this.LeftLeg3.zRot = f;
		this.RightLeg2.zRot = -f;
		this.LeftLeg2.zRot = f;
		this.RightLeg1.zRot = -f;
		this.LeftLeg1.zRot = f;
		float f1 = f/2;
		float f2 = f/6;
		this.RightLeg4.yRot = f1;
		this.LeftLeg4.yRot = -f1;
		this.RightLeg3.yRot = f2;
		this.LeftLeg3.yRot = -f2;
		this.RightLeg2.yRot = -f2;
		this.LeftLeg2.yRot = f2;
		this.RightLeg1.yRot = -f1;
		this.LeftLeg1.yRot = f1;
		float g = 0.8662F;
		float h = 0.2F;
		float f3 = -(Mth.cos(limbSwing * g * 2.0F) * h) * limbSwingAmount;
		float f4 = -(Mth.cos(limbSwing * g * 2.0F + (float)Math.PI) * h) * limbSwingAmount;
		float f5 = -(Mth.cos(limbSwing * g * 2.0F + ((float)Math.PI / 2F)) * h) * limbSwingAmount;
		float f6 = -(Mth.cos(limbSwing * g * 2.0F + ((float)Math.PI * 1.5F)) * h) * limbSwingAmount;
		float f7 = Math.abs(Mth.sin(limbSwing * g) * h) * limbSwingAmount;
		float f8 = Math.abs(Mth.sin(limbSwing * g + (float)Math.PI) * h) * limbSwingAmount;
		float f9 = Math.abs(Mth.sin(limbSwing * g + ((float)Math.PI / 2F)) * h) * limbSwingAmount;
		float f10 = Math.abs(Mth.sin(limbSwing * g + ((float)Math.PI * 1.5F)) * h) * limbSwingAmount;
		this.RightLeg4.yRot += f3;
		this.LeftLeg4.yRot -= f3;
		this.RightLeg3.yRot += f4;
		this.LeftLeg3.yRot -= f4;
		this.RightLeg2.yRot += f5;
		this.LeftLeg2.yRot -= f5;
		this.RightLeg1.yRot += f6;
		this.LeftLeg1.yRot -= f6;
		this.RightLeg4.zRot += f7;
		this.LeftLeg4.zRot -= f7;
		this.RightLeg3.zRot += f8;
		this.LeftLeg3.zRot -= f8;
		this.RightLeg2.zRot += f9;
		this.LeftLeg2.zRot -= f9;
		this.RightLeg1.zRot += f10;
		this.LeftLeg1.zRot -= f10;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Thorax.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}