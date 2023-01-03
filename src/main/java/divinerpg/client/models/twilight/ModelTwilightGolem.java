package divinerpg.client.models.twilight;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;


public class ModelTwilightGolem<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("twilight_golem");
	private final ModelPart torso;
	private final ModelPart body;
	private final ModelPart headLeft;
	private final ModelPart headRight;
	private final ModelPart rightShoulder;
	private final ModelPart rightArm;
	private final ModelPart rightHand;
	private final ModelPart leftShoulder;
	private final ModelPart leftArm;
	private final ModelPart leftHand;
	private final ModelPart rightLeg;
	private final ModelPart leftLeg;

	public ModelTwilightGolem(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.torso = root.getChild("torso");
		this.body = root.getChild("body");
		this.headLeft = root.getChild("headLeft");
		this.headRight = root.getChild("headRight");
		this.rightShoulder = root.getChild("rightShoulder");
		this.rightArm = root.getChild("rightArm");
		this.rightHand = root.getChild("rightHand");
		this.leftShoulder = root.getChild("leftShoulder");
		this.leftArm = root.getChild("leftArm");
		this.leftHand = root.getChild("leftHand");
		this.rightLeg = root.getChild("rightLeg");
		this.leftLeg = root.getChild("leftLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(64, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-8.0F, -8.0F, -4.0F));

		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 20.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-10.0F, -20.0F, -6.0F));

		partdefinition.addOrReplaceChild("headLeft", CubeListBuilder.create().texOffs(0, 44).mirror().addBox(-4.0F, -5.0F, -8.0F, 7.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, -20.0F, -2.0F));

		partdefinition.addOrReplaceChild("headRight", CubeListBuilder.create().texOffs(0, 44).mirror().addBox(-4.0F, -5.0F, -8.0F, 7.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, -20.0F, -2.0F));

		partdefinition.addOrReplaceChild("rightShoulder", CubeListBuilder.create().texOffs(0, 32).mirror().addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-12.0F, -20.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(30, 44).mirror().addBox(-2.0F, 3.0F, -2.0F, 4.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-12.0F, -20.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightHand", CubeListBuilder.create().texOffs(0, 32).mirror().addBox(-3.0F, 19.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-12.0F, -20.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftShoulder", CubeListBuilder.create().texOffs(0, 32).mirror().addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(12.0F, -20.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(30, 44).mirror().addBox(-2.0F, 3.0F, -2.0F, 4.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(12.0F, -20.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftHand", CubeListBuilder.create().texOffs(0, 32).mirror().addBox(-3.0F, 19.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(12.0F, -20.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(46, 40).mirror().addBox(-4.0F, 0.0F, -4.0F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.0F, 8.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(46, 40).mirror().addBox(-4.0F, 0.0F, -4.0F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(6.0F, 8.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.headLeft.xRot = this.headRight.xRot = headPitch / (180F / (float)Math.PI);
		this.headLeft.yRot = this.headRight.yRot = netHeadYaw / (180F / (float)Math.PI);
		this.leftLeg.xRot = this.rightHand.xRot = this.rightArm.xRot = this.rightShoulder.xRot = Mth.cos(limbSwing)*limbSwingAmount;
		this.rightLeg.xRot = this.leftHand.xRot = this.leftArm.xRot = this.leftShoulder.xRot = Mth.cos(limbSwing+(float)Math.PI)*limbSwingAmount*0.7f;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		headLeft.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		headRight.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightShoulder.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightHand.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftShoulder.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftHand.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}