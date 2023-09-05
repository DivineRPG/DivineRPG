package divinerpg.client.models.twilight;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.eden.EntityGreenfeet;
import net.minecraft.client.model.AnimationUtils;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelGreenfeet extends EntityModel<EntityGreenfeet> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("greenfeet");
	private final ModelPart RightLeg, LeftLeg, Body, Head, RightArm, LeftArm;

	public ModelGreenfeet(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.RightLeg = root.getChild("RightLeg");
		this.LeftLeg = root.getChild("LeftLeg");
		this.Body = root.getChild("Body");
		this.Head = root.getChild("Head");
		this.RightArm = root.getChild("RightArm");
		this.LeftArm = root.getChild("LeftArm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(42, 42).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 12.0F, 1.0F));

		partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(36, 10).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 12.0F, 1.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 12.0F, 0.5F));

		Body.addOrReplaceChild("Chest_r1", CubeListBuilder.create().texOffs(0, 30).addBox(-4.5F, -12.0F, -1.5F, 9.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -3.0F));

		Head.addOrReplaceChild("skull_r1", CubeListBuilder.create().texOffs(28, 30).addBox(-2.5F, -10.0F, -3.0F, 5.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, -3.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(25, 46).addBox(0.0F, -1.0F, -2.0F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5F, 1.0F, -2.0F));

		LeftArm.addOrReplaceChild("LeftBlade", CubeListBuilder.create().texOffs(14, 2).addBox(-1.5F, 0.0F, -7.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
			.texOffs(0, 6).addBox(0.0F, 1.0F, -13.0F, 0.0F, 6.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 7.0F, -1.0F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(28, 0).addBox(-2.0F, -1.0F, -2.0F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.5F, 1.0F, -2.0F));

		RightArm.addOrReplaceChild("RightBlade", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -1.0F, -7.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
			.texOffs(0, 0).addBox(-1.0F, 0.0F, -13.0F, 0.0F, 6.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 8.0F, -1.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(EntityGreenfeet entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Head.yRot = netHeadYaw / (180F / (float)Math.PI);
		this.Head.xRot = headPitch / (180F / (float)Math.PI) - 0.5672F;
		this.RightArm.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 2.0F * limbSwingAmount * 0.5F);
		this.LeftArm.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F);
		this.RightArm.yRot = 0.0F;
		this.LeftArm.yRot = 0.0F;
		this.RightArm.zRot = 0.0F;
		this.LeftArm.zRot = 0.0F;
		AnimationUtils.bobModelPart(this.RightArm, ageInTicks, 1.0F);
		AnimationUtils.bobModelPart(this.LeftArm, ageInTicks, -1.0F);
		this.RightLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
		this.LeftLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
		this.setupAttackAnimation(entity, ageInTicks);
	}

	protected ModelPart getArm(HumanoidArm humanoidarm) {
		return this.RightArm;
	}

	private HumanoidArm getAttackArm(EntityGreenfeet p_102857_) {
		return p_102857_.getMainArm();
	}

	protected void setupAttackAnimation(EntityGreenfeet p_102858_, float p_102859_) {
		if (!(this.attackTime <= 0.0F)) {
			HumanoidArm humanoidarm = this.getAttackArm(p_102858_);
			ModelPart modelpart = this.getArm(humanoidarm);
			float f = this.attackTime;
			this.Body.yRot = Mth.sin(Mth.sqrt(f) * ((float)Math.PI * 2F)) * 0.2F;

			this.RightArm.yRot += this.Body.yRot;
			f = 1.0F - this.attackTime;
			f *= f;
			f *= f;
			f = 1.0F - f;
			float f1 = Mth.sin(f * (float)Math.PI);
			float f2 = Mth.sin(this.attackTime * (float)Math.PI) * -(this.Head.xRot - 0.7F) * 0.75F;
			modelpart.xRot -= f1 * 1.2F + f2;
			modelpart.yRot += this.Body.yRot * 2.0F;
			modelpart.zRot += Mth.sin(this.attackTime * (float)Math.PI) * -0.4F;
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}