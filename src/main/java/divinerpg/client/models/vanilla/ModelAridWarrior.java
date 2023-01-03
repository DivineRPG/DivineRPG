package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.vanilla.overworld.EntityAridWarrior;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelAridWarrior<T extends EntityAridWarrior> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("arid_warrior");
	private final ModelPart body, leftarm2, leftarm1, rightarm1, head, rightleg, leftleg;
	public final ModelPart rightarm2;

	public ModelAridWarrior(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.body = root.getChild("body");
		this.leftarm2 = root.getChild("leftarm2");
		this.leftarm1 = root.getChild("leftarm1");
		this.rightarm1 = root.getChild("rightarm1");
		this.rightarm2 = root.getChild("rightarm2");
		this.head = root.getChild("head");
		this.rightleg = root.getChild("rightleg");
		this.leftleg = root.getChild("leftleg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(7.0F, -2.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(16, 16).mirror().addBox(-4.0F, -2.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(16, 16).mirror().addBox(-4.0F, -8.0F, -2.0F, 14.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(16, 16).mirror().addBox(-4.0F, 6.0F, -2.0F, 14.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarm2", CubeListBuilder.create().texOffs(28, 16).mirror().addBox(0.0F, -2.0F, -2.0F, 7.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(40, 16).mirror().addBox(3.0F, 1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(7.0F, 5.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarm1", CubeListBuilder.create().texOffs(28, 16).mirror().addBox(0.0F, -2.0F, -2.0F, 7.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(40, 16).mirror().addBox(3.0F, 1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(7.0F, -6.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarm1", CubeListBuilder.create().texOffs(28, 16).mirror().addBox(-7.0F, -2.0F, -2.0F, 7.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(40, 16).mirror().addBox(-7.0F, 1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, -6.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarm2", CubeListBuilder.create().texOffs(28, 16).mirror().addBox(-6.0F, -2.0F, -2.0F, 7.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(40, 16).mirror().addBox(-6.0F, 1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-8.0F, 5.0F, 0.0F));

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(34, 0).mirror().addBox(4.0F, -7.0863F, -10.3376F, 2.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(34, 0).mirror().addBox(-6.0F, -7.0863F, -10.3376F, 2.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -8.0F, 0.0F, -0.8179F, 0.0F, 0.0F));

		head.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -5.5F, -7.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.9137F, -1.3376F, -0.7418F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 16).mirror().addBox(-3.0F, 1.0F, -3.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 16).mirror().addBox(-3.0F, 5.0F, -3.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 16).mirror().addBox(-4.0F, 9.1F, -4.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 16).mirror().addBox(-3.0F, 1.0F, -3.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 16).mirror().addBox(-3.0F, 5.0F, -3.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 16).mirror().addBox(-4.0F, 9.0F, -4.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, 12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
        this.head.xRot = headPitch / (180F / (float) Math.PI);

        this.rightarm2.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 2.0F * limbSwingAmount * 0.5F);
        this.rightarm1.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 2.0F * limbSwingAmount * 0.5F);

        this.leftarm1.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F);
        this.leftarm2.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F);

        this.rightleg.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);

        this.leftleg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);

        this.rightleg.yRot = 0.0F;

        this.leftleg.yRot = 0.0F;

        this.rightarm1.yRot = 0.0F;
        this.rightarm2.yRot = 0.0F;

        this.leftarm1.yRot = 0.0F;
        this.leftarm2.yRot = 0.0F;

        this.rightarm1.zRot = (float) (Math.cos(ageInTicks * 0.09F) * 0.05F + 0.05F);
        this.rightarm2.zRot = (float) (Math.cos(ageInTicks * 0.09F) * 0.05F + 0.05F);

        this.leftarm1.zRot = -(float) (Math.cos(ageInTicks * 0.09F) * 0.05F + 0.05F);
        this.leftarm2.zRot = -(float) (Math.cos(ageInTicks * 0.09F) * 0.05F + 0.05F);

        this.rightarm1.xRot += Math.sin(ageInTicks * 0.067F) * 0.05F;
        this.rightarm2.xRot += Math.sin(ageInTicks * 0.067F) * 0.05F;

        this.leftarm1.xRot -= Math.sin(ageInTicks * 0.067F) * 0.05F;
        this.leftarm2.xRot -= Math.sin(ageInTicks * 0.067F) * 0.05F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}