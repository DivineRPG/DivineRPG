package divinerpg.client.models.twilight;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelEdenTomo<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("eden_tomo");
	private final ModelPart Torso;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart RightAntenna;
	private final ModelPart LeftAntenna;
	private final ModelPart LeftFoot;
	private final ModelPart RightFoot;

	public ModelEdenTomo(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Torso = root.getChild("Torso");
		this.RightArm = this.Torso.getChild("RightArm");
		this.LeftArm = this.Torso.getChild("LeftArm");
		this.RightAntenna = this.Torso.getChild("RightAntenna");
		this.LeftAntenna = this.Torso.getChild("LeftAntenna");
		this.LeftFoot = root.getChild("LeftFoot");
		this.RightFoot = root.getChild("RightFoot");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Torso = partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -7.0F, -4.0F, 12.0F, 8.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(0, 17).addBox(-6.0F, -7.0F, -5.0F, 12.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, 0.0F));

		Torso.addOrReplaceChild("RightAntenna", CubeListBuilder.create().texOffs(37, 19).addBox(-1.5F, -6.5F, -3.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(28, 32).addBox(-1.5F, -5.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -6.0F, 0.0F, 0.0873F, 0.1745F, 0.0F));

		Torso.addOrReplaceChild("LeftAntenna", CubeListBuilder.create().texOffs(0, 36).addBox(-1.5F, -6.5F, -3.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(16, 32).addBox(-1.5F, -5.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -6.0F, 0.0F, 0.0873F, -0.1745F, 0.0F));

		PartDefinition RightArm = Torso.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offset(-6.0F, -5.0F, -0.5F));

		RightArm.addOrReplaceChild("RightArm_r1", CubeListBuilder.create().texOffs(33, 0).addBox(-4.0F, -1.0F, -1.5F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.48F));

		PartDefinition LeftArm = Torso.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offset(6.0F, -5.0F, -0.5F));

		LeftArm.addOrReplaceChild("LeftArm_r1", CubeListBuilder.create().texOffs(26, 17).addBox(0.0F, -1.0F, -1.5F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.48F));

		partdefinition.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(0, 26).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 18.0F, -1.0F));

		partdefinition.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(22, 22).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 18.0F, -1.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f1 = ageInTicks * 0.1F + limbSwing * 0.5F;
		float f2 = 0.08F + limbSwingAmount * 0.4F;
		this.LeftArm.zRot = (-(float)Math.PI / 6F) - Mth.cos(f1 * 1.2F) * f2;
		this.RightArm.zRot = ((float)Math.PI / 6F) + Mth.cos(f1) * f2;
		this.LeftAntenna.zRot = ((float)Math.PI / 16F) + Mth.cos(f1) * f2;
		this.RightAntenna.zRot = (-(float)Math.PI / 16F) - Mth.cos(f1 * 1.2F) * f2;

		this.Torso.zRot = Mth.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
		this.RightFoot.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 0.7F * limbSwingAmount);
		this.LeftFoot.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 0.7F * limbSwingAmount);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftFoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightFoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}