package divinerpg.client.models.boss;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelEternalArcher<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("eternal_archer");
	public final ModelPart head, shoulder6, rightleg, leftleg, body, shoulder1, shoulder4, shoulder3, shoulder2, shoulder5, armRight1, armRight2, armRight3, armLeft1, armLeft2, armLeft3;

	public ModelEternalArcher(ModelPart root) {
		this.head = root.getChild("head");
		this.shoulder6 = root.getChild("shoulder6");
		this.rightleg = root.getChild("rightleg");
		this.leftleg = root.getChild("leftleg");
		this.body = root.getChild("body");
		this.shoulder1 = root.getChild("shoulder1");
		this.shoulder4 = root.getChild("shoulder4");
		this.shoulder3 = root.getChild("shoulder3");
		this.shoulder2 = root.getChild("shoulder2");
		this.shoulder5 = root.getChild("shoulder5");
		this.armLeft1 = root.getChild("armLeft1");
		this.armLeft2 = root.getChild("armLeft2");
		this.armLeft3 = root.getChild("armLeft3");
		this.armRight1 = root.getChild("armRight1");
		this.armRight2 = root.getChild("armRight2");
		this.armRight3 = root.getChild("armRight3");
	}

	public ModelEternalArcher(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.head = root.getChild("head");
		this.shoulder6 = root.getChild("shoulder6");
		this.rightleg = root.getChild("rightleg");
		this.leftleg = root.getChild("leftleg");
		this.body = root.getChild("body");
		this.shoulder1 = root.getChild("shoulder1");
		this.shoulder4 = root.getChild("shoulder4");
		this.shoulder3 = root.getChild("shoulder3");
		this.shoulder2 = root.getChild("shoulder2");
		this.shoulder5 = root.getChild("shoulder5");
		this.armLeft1 = root.getChild("armLeft1");
		this.armLeft2 = root.getChild("armLeft2");
		this.armLeft3 = root.getChild("armLeft3");
		this.armRight1 = root.getChild("armRight1");
		this.armRight2 = root.getChild("armRight2");
		this.armRight3 = root.getChild("armRight3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("shoulder6", CubeListBuilder.create().texOffs(41, 1).mirror().addBox(-4.0F, 0.0F, -2.0F, 10.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(18.0F, -6.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(46, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("shoulder1", CubeListBuilder.create().texOffs(41, 1).mirror().addBox(-4.0F, 0.0F, -2.0F, 10.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-20.0F, -6.0F, 0.0F));

		partdefinition.addOrReplaceChild("shoulder4", CubeListBuilder.create().texOffs(19, 24).mirror().addBox(-4.0F, 0.0F, -2.0F, 6.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(8.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("shoulder3", CubeListBuilder.create().texOffs(19, 24).mirror().addBox(-4.0F, 0.0F, -2.0F, 6.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("shoulder2", CubeListBuilder.create().texOffs(17, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 10.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-13.0F, -3.0F, 0.0F));

		partdefinition.addOrReplaceChild("shoulder5", CubeListBuilder.create().texOffs(17, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 10.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(11.0F, -3.0F, 0.0F));

		partdefinition.addOrReplaceChild("armLeft1", CubeListBuilder.create().texOffs(110, 16).mirror().addBox(-10.0F, -21.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 24.0F, 0.0F));
		partdefinition.addOrReplaceChild("armLeft2", CubeListBuilder.create().texOffs(71, 16).addBox(-17.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 24.0F, 0.0F));
		partdefinition.addOrReplaceChild("armLeft3", CubeListBuilder.create().texOffs(91, 16).addBox(-24.0F, -27.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 24.0F, 0.0F));

		partdefinition.addOrReplaceChild("armRight1", CubeListBuilder.create().texOffs(110, 16).addBox(6.0F, -21.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 24.0F, 0.0F));
		partdefinition.addOrReplaceChild("armRight2", CubeListBuilder.create().texOffs(71, 16).addBox(13.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 24.0F, 0.0F));
		partdefinition.addOrReplaceChild("armRight3", CubeListBuilder.create().texOffs(91, 16).addBox(20.0F, -27.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 24.0F, 0.0F));


		return LayerDefinition.create(meshdefinition, 128, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.rightleg.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
		this.leftleg.xRot = (float) (Math.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount);
		armRight1.xRot = 0;
		armRight2.xRot = 0;
		armRight3.xRot = 0;

		armLeft1.xRot = 0;
		armLeft2.xRot = 0;
		armLeft3.xRot = 0;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		shoulder6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		shoulder1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		shoulder4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		shoulder3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		shoulder2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		shoulder5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		armLeft1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		armLeft2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		armLeft3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		armRight1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		armRight2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		armRight3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}