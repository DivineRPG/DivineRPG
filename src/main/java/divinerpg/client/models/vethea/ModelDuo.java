package divinerpg.client.models.vethea;

import com.mojang.blaze3d.vertex.*;

import divinerpg.entities.vethea.EntityDuo;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelDuo extends EntityModel<EntityDuo> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("duo");
	private final ModelPart rightleg;
	private final ModelPart leftleg;
	private final ModelPart rotates1;
	private final ModelPart rotates2;
	private final ModelPart rotates3;
	private final ModelPart rotates4;
	private final ModelPart rotates5;
	private final ModelPart rotates6;
	private final ModelPart rotates7;
	private final ModelPart rotates8;
	private final ModelPart rotates9;
	private final ModelPart rotates10;
	private final ModelPart rotates11;
	private final ModelPart rotates12;
	private final ModelPart rotates13;
	private final ModelPart rotates14;
	private final ModelPart rotates15;
	private final ModelPart rotates17;
	private final ModelPart rotates16;
	private final ModelPart rotates18;
	private final ModelPart rotates19;
	private final ModelPart rotates20;
	private final ModelPart rightleg2;
	private final ModelPart leftleg2;
	private final ModelPart leftleg3;
	private final ModelPart rightleg3;
	private final ModelPart leftleg4;
	private final ModelPart rightleg4;

	public ModelDuo(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.rightleg = root.getChild("rightleg");
		this.leftleg = root.getChild("leftleg");
		this.rotates1 = root.getChild("rotates1");
		this.rotates2 = root.getChild("rotates2");
		this.rotates3 = root.getChild("rotates3");
		this.rotates4 = root.getChild("rotates4");
		this.rotates5 = root.getChild("rotates5");
		this.rotates6 = root.getChild("rotates6");
		this.rotates7 = root.getChild("rotates7");
		this.rotates8 = root.getChild("rotates8");
		this.rotates9 = root.getChild("rotates9");
		this.rotates10 = root.getChild("rotates10");
		this.rotates11 = root.getChild("rotates11");
		this.rotates12 = root.getChild("rotates12");
		this.rotates13 = root.getChild("rotates13");
		this.rotates14 = root.getChild("rotates14");
		this.rotates15 = root.getChild("rotates15");
		this.rotates17 = root.getChild("rotates17");
		this.rotates16 = root.getChild("rotates16");
		this.rotates18 = root.getChild("rotates18");
		this.rotates19 = root.getChild("rotates19");
		this.rotates20 = root.getChild("rotates20");
		this.rightleg2 = root.getChild("rightleg2");
		this.leftleg2 = root.getChild("leftleg2");
		this.leftleg3 = root.getChild("leftleg3");
		this.rightleg3 = root.getChild("rightleg3");
		this.leftleg4 = root.getChild("leftleg4");
		this.rightleg4 = root.getChild("rightleg4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(101, 16).mirror().addBox(-4.0F, -4.0F, -3.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(101, 16).mirror().addBox(-3.0F, -4.0F, -3.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(8.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("rotates1", CubeListBuilder.create().texOffs(82, 16).mirror().addBox(4.0F, -16.0F, -12.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 14.0F, 0.0F, -0.1745F, -3.1416F, 0.0F));

		partdefinition.addOrReplaceChild("rotates2", CubeListBuilder.create().texOffs(82, 16).mirror().addBox(-8.0F, -15.0F, -12.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 13.0F, 0.0F, -0.1745F, -3.1416F, 0.0F));

		partdefinition.addOrReplaceChild("rotates3", CubeListBuilder.create().texOffs(54, 20).mirror().addBox(-7.0F, -8.0F, -22.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 13.0F, 0.0F, -0.1745F, -3.1416F, 0.0F));

		partdefinition.addOrReplaceChild("rotates4", CubeListBuilder.create().texOffs(34, 0).mirror().addBox(-3.0F, -18.0F, -6.0F, 6.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.2618F, -3.1416F, 0.0F));

		partdefinition.addOrReplaceChild("rotates5", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-6.0F, -15.0F, -9.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 13.0F, 0.0F, 0.0F, -3.1416F, 0.0F));

		partdefinition.addOrReplaceChild("rotates6", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(2.0F, -16.0F, -9.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 14.0F, 0.0F, 0.0F, -3.1416F, 0.0F));

		partdefinition.addOrReplaceChild("rotates7", CubeListBuilder.create().texOffs(56, 1).mirror().addBox(-4.0F, -10.0F, -7.0F, 8.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.2618F, -3.1416F, 0.0F));

		partdefinition.addOrReplaceChild("rotates8", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -25.0F, -9.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.1745F, -3.1416F, 0.0F));

		partdefinition.addOrReplaceChild("rotates9", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -25.0F, -10.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rotates10", CubeListBuilder.create().texOffs(82, 16).mirror().addBox(4.0F, -16.0F, -13.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 14.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rotates11", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-6.0F, -15.0F, -10.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 13.0F, 0.0F));

		partdefinition.addOrReplaceChild("rotates12", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(2.0F, -16.0F, -10.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, 14.0F, 0.0F));

		partdefinition.addOrReplaceChild("rotates13", CubeListBuilder.create().texOffs(55, 22).mirror().addBox(5.0F, -7.0F, -21.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 14.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rotates14", CubeListBuilder.create().texOffs(55, 22).mirror().addBox(-7.0F, -6.0F, -21.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 13.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rotates15", CubeListBuilder.create().texOffs(86, 2).mirror().addBox(-5.0F, -4.0F, 0.0F, 10.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("rotates17", CubeListBuilder.create().texOffs(82, 16).mirror().addBox(-8.0F, -15.0F, -13.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 13.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rotates16", CubeListBuilder.create().texOffs(34, 0).mirror().addBox(-3.0F, -18.0F, -7.0F, 6.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rotates18", CubeListBuilder.create().texOffs(50, 16).mirror().addBox(-7.0F, -6.0F, -25.0F, 2.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 13.0F, 0.0F, -0.1745F, -3.1416F, 0.0F));

		partdefinition.addOrReplaceChild("rotates19", CubeListBuilder.create().texOffs(56, 1).mirror().addBox(-4.0F, -10.0F, -8.0F, 8.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rotates20", CubeListBuilder.create().texOffs(86, 2).mirror().addBox(-5.0F, -4.0F, -8.0F, 10.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightleg2", CubeListBuilder.create().texOffs(19, 17).mirror().addBox(1.0F, 9.0F, -10.0F, 2.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg2", CubeListBuilder.create().texOffs(19, 17).mirror().addBox(2.0F, 9.0F, -10.0F, 2.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(8.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg3", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(8.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightleg3", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-3.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg4", CubeListBuilder.create().texOffs(19, 17).mirror().addBox(-4.0F, 9.0F, -10.0F, 2.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(8.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightleg4", CubeListBuilder.create().texOffs(19, 17).mirror().addBox(-5.0F, 9.0F, -10.0F, 2.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, 12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 32);
	}

	@Override
	public void setupAnim(EntityDuo entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.leftleg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leftleg2.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leftleg3.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leftleg4.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

		this.rightleg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.rightleg2.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.rightleg3.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.rightleg4.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		
		if(entity.abilityCoolDown < 11) {
			float f = (float)((entity.isFast ? 1 : -1) * (Math.PI / 20.));
			this.rotates1.yRot += f;
			this.rotates2.yRot += f;
			this.rotates3.yRot += f;
			this.rotates4.yRot += f;
			this.rotates5.yRot += f;
			this.rotates6.yRot += f;
			this.rotates7.yRot += f;
			this.rotates8.yRot += f;
			this.rotates9.yRot += f;
			this.rotates10.yRot += f;
			this.rotates11.yRot += f;
			this.rotates12.yRot += f;
			this.rotates13.yRot += f;
			this.rotates14.yRot += f;
			this.rotates15.yRot += f;
			this.rotates16.yRot += f;
			this.rotates17.yRot += f;
			this.rotates18.yRot += f;
			this.rotates19.yRot += f;
			this.rotates20.yRot += f;
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		rightleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rotates1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rotates2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rotates3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rotates4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rotates5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rotates6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rotates7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rotates8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rotates9.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rotates10.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rotates11.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rotates12.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rotates13.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rotates14.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rotates15.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rotates17.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rotates16.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rotates18.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rotates19.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rotates20.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightleg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftleg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftleg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightleg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftleg4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightleg4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}