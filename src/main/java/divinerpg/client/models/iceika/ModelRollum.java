package divinerpg.client.models.iceika;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelRollum<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("rollum");
	private final ModelPart Head;
	private final ModelPart Torso;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;

	public ModelRollum(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Head = root.getChild("Head");
		this.Torso = root.getChild("Torso");
		this.RightArm = root.getChild("RightArm");
		this.LeftArm = root.getChild("LeftArm");
		this.RightLeg = root.getChild("RightLeg");
		this.LeftLeg = root.getChild("LeftLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Torso = partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create(), PartPose.offset(0.0F, 7F, 0.0F));

		Torso.addOrReplaceChild("Torso_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -14.0F, -2.8033F, 16.0F, 14.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0F, -0.1972F, 0.48F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(38, 35).addBox(-5.0F, -4.0F, -9.0F, 10.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.3696F, -4.6972F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(47, 17).addBox(0.0F, -4.0F, -5.0F, 7.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(7.9F, -2.6696F, -0.6972F));

		LeftArm.addOrReplaceChild("LeftLowerArm", CubeListBuilder.create().texOffs(28, 50).addBox(-4.0F, -1.0F, -4.0F, 5.0F, 13.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 4.0F, -1.0F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(56, 0).addBox(-7.0F, -4.0F, -7.0F, 7.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.9F, -2.6696F, 1.3028F));

		RightArm.addOrReplaceChild("RightLowerArm", CubeListBuilder.create().texOffs(0, 43).addBox(-1.0F, -1.0F, -4.0F, 5.0F, 13.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 4.0F, -3.0F));

		Torso.addOrReplaceChild("Hip", CubeListBuilder.create().texOffs(0, 26).addBox(-7.0F, 0.0F, -5.0F, 14.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 2.0F));

		partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(56, 50).addBox(-2.0F, 0.0F, -4.0F, 6.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 14.0F, 1.0F));

		partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 65).addBox(-4.0F, 0.0F, -4.0F, 6.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 14.0F, 1.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Head.yRot = netHeadYaw / (180F / (float)Math.PI);
		this.Head.xRot = headPitch / (180F / (float)Math.PI);
		this.RightArm.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.LeftArm.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.RightLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.LeftLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
