package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelHellPig<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("hell_pig");
	private final ModelPart Head;
	private final ModelPart LeftEar;
	private final ModelPart RightEar;
	private final ModelPart BackRightLeg;
	private final ModelPart FrontLeftLeg;
	private final ModelPart FrontRightLeg;
	private final ModelPart BackLeftLeg;
	private final ModelPart Body;

	public ModelHellPig(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Head = root.getChild("Head");
		this.LeftEar = this.Head.getChild("LeftEar");
		this.RightEar = this.Head.getChild("RightEar");
		this.BackRightLeg = root.getChild("BackRightLeg");
		this.FrontLeftLeg = root.getChild("FrontLeftLeg");
		this.FrontRightLeg = root.getChild("FrontRightLeg");
		this.BackLeftLeg = root.getChild("BackLeftLeg");
		this.Body = root.getChild("Body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -3.0F, 2.0F, 10.0F, 9.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 9.0F, -9.0F));

		partdefinition.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(0, 37).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 15.0F, -5.0F));

		partdefinition.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(28, 23).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 15.0F, 5.0F));

		partdefinition.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(34, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 15.0F, 5.0F));

		partdefinition.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(24, 36).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 15.0F, -5.0F));

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 23).addBox(-4.0F, -5.0F, -6.0F, 8.0F, 8.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(12, 37).addBox(-2.5F, -1.0F, -7.0F, 5.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-1, 52).addBox(0.0F, -10.0F, -7.0F, 0.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.5F, -7.0F));

		PartDefinition RightEar = Head.addOrReplaceChild("RightEar", CubeListBuilder.create(), PartPose.offset(-3.9526F, -2.5952F, -3.0F));

		RightEar.addOrReplaceChild("RightEar_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -2.0F, 1.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.0474F, -0.4048F, 0.0F));

		PartDefinition LeftEar = Head.addOrReplaceChild("LeftEar", CubeListBuilder.create(), PartPose.offset(3.9526F, -2.5952F, -3.0F));

		LeftEar.addOrReplaceChild("LeftEar_r1", CubeListBuilder.create().texOffs(40, 32).addBox(0.0F, 0.0F, -2.0F, 1.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0474F, -0.4048F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Head.xRot = headPitch * ((float)Math.PI / 180F);
		this.Head.yRot = netHeadYaw * ((float)Math.PI / 180F);

		float f1 = ageInTicks * 0.1F + limbSwing * 0.5F;
		float f2 = 0.08F + limbSwingAmount * 0.4F;
		this.LeftEar.zRot = (-(float)Math.PI / 12F) - Mth.cos(f1 * 1.2F) * f2;
		this.RightEar.zRot = ((float)Math.PI / 12F) + Mth.cos(f1) * f2;

		this.BackRightLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.BackLeftLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.FrontRightLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.FrontLeftLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}