package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.vanilla.overworld.EntityKobblin;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelKobblin extends EntityModel<EntityKobblin> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("kobblin");
	private final ModelPart Pad, Neck, Body, Head, Tongue, rightarm, RLeg, leftarm, LLeg;

	public ModelKobblin(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Pad = root.getChild("Pad");
		this.Neck = root.getChild("Neck");
		this.Body = root.getChild("Body");
		this.Head = root.getChild("Head");
		this.Tongue = root.getChild("Tongue");
		this.rightarm = root.getChild("rightarm");
		this.RLeg = root.getChild("RLeg");
		this.leftarm = root.getChild("leftarm");
		this.LLeg = root.getChild("LLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("Pad", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 16.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-8.0F, 5.0F, -8.0F));

		partdefinition.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(40, 23).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 13.0F, -0.5F, 0.5236F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(20, 19).mirror().addBox(0.0F, 0.0F, 0.0F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.5F, 14.0F, 0.5F));

		partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(0.0F, 0.0F, 0.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.5F, 8.0F, -2.5F));

		partdefinition.addOrReplaceChild("Tongue", CubeListBuilder.create().texOffs(40, 19).mirror().addBox(0.0F, 0.0F, 0.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 12.0F, -2.5F, -0.7854F, 0.0F, 0.0F));

		PartDefinition rightarm = partdefinition.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(48, 24).addBox(-1.8F, 1.3F, 2.3F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 14.0F, 2.5F, -1.5708F, -0.3665F, 0.0F));

		rightarm.addOrReplaceChild("RArm1_r1", CubeListBuilder.create().texOffs(48, 19).mirror().addBox(7.2F, -2.0F, 7.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.5F, 10.0F, -2.5F, -0.7496F, 0.2233F, -2.4917F));

		partdefinition.addOrReplaceChild("RLeg", CubeListBuilder.create().texOffs(48, 19).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 20.0F, 2.5F));

		PartDefinition leftarm = partdefinition.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(48, 19).mirror().addBox(1.6F, 1.0F, 2.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.5F, 14.0F, 2.5F, -1.5708F, 0.3665F, 0.0F));

		leftarm.addOrReplaceChild("LArm2_r1", CubeListBuilder.create().texOffs(48, 24).mirror().addBox(6.5F, -1.3F, 9.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.9F, 10.0F, -3.0F, 0.8759F, 0.2568F, -0.5121F));

		partdefinition.addOrReplaceChild("LLeg", CubeListBuilder.create().texOffs(48, 19).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, 20.0F, 2.5F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(EntityKobblin entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.rightarm.xRot = (float) (-0.7853982F + (Math.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount));
        this.leftarm.xRot = (float) (-0.7853982F + (Math.cos(limbSwing * 0.6662F + Math.PI) * 0.8F * limbSwingAmount));

        this.RLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F) * limbSwingAmount);
        this.LLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * limbSwingAmount);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Pad.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Neck.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tongue.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}