package divinerpg.client.models.iceika;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelRollum<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("rollum");
	private final ModelPart Torso;
	private final ModelPart Hip;

	public ModelRollum(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Torso = root.getChild("Torso");
		this.Hip = root.getChild("Hip");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Torso = partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create(), PartPose.offset(0.0F, 7.7F, -2.0F));

		PartDefinition Torso_r1 = Torso.addOrReplaceChild("Torso_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -14.1272F, -2.8033F, 16.0F, 14.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.1696F, -0.1972F, 0.48F, 0.0F, 0.0F));

		PartDefinition Head = Torso.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(38, 35).addBox(-5.0F, -4.0F, -9.0F, 10.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.6696F, -4.6972F));

		PartDefinition LeftArm = Torso.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(47, 17).addBox(0.0F, -4.0F, -5.0F, 7.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, -10.6696F, -0.6972F));

		PartDefinition LeftLowerArm = LeftArm.addOrReplaceChild("LeftLowerArm", CubeListBuilder.create().texOffs(28, 50).addBox(-4.0F, -1.0F, -4.0F, 5.0F, 13.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 4.0F, -1.0F));

		PartDefinition RightArm = Torso.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(56, 0).addBox(-7.0F, -4.0F, -7.0F, 7.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, -10.6696F, 1.3028F));

		PartDefinition RightLowerArm = RightArm.addOrReplaceChild("RightLowerArm", CubeListBuilder.create().texOffs(0, 43).addBox(-1.0F, -1.0F, -4.0F, 5.0F, 13.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 4.0F, -3.0F));

		PartDefinition Hip = partdefinition.addOrReplaceChild("Hip", CubeListBuilder.create().texOffs(0, 26).addBox(-7.0F, 0.0F, -5.0F, 14.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition LeftLeg = Hip.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(56, 50).addBox(-2.0F, 0.0F, -4.0F, 6.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 8.0F, -1.0F));

		PartDefinition RightLeg = Hip.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 65).addBox(-4.0F, 0.0F, -4.0F, 6.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 8.0F, -1.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
//		this.head.yRot = netHeadYaw / (180F / (float)Math.PI);
//		this.head.xRot = headPitch / (180F / (float)Math.PI);
//		this.rightarmtop.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
//		this.leftarmtop.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
//		this.rightarmtop.zRot = 0.0F;
//		this.leftarmtop.zRot = 0.0F;
//		this.rightlegbottom.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
//		this.leftlegbottom.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
//		this.rightlegbottom.yRot = 0.0F;
//		this.leftlegbottom.yRot = 0.0F;
//		this.rightarm.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
//		this.leftarm.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
//		this.rightarm.zRot = 0.0F;
//		this.leftarm.zRot = 0.0F;
//		this.rightleg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
//		this.leftleg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
//		this.rightleg.yRot = 0.0F;
//		this.leftleg.yRot = 0.0F;
//
//		this.rightarmext.xRot = Mth.cos(-(limbSwing * 0.6662F + (float)Math.PI)) * 2.0F * limbSwingAmount * 0.5F;
//		this.leftarmext.xRot = Mth.cos(-(limbSwing * 0.6662F)) * 2.0F * limbSwingAmount * 0.5F;
//		this.rightarmext.zRot = 0.0F;
//		this.leftarmext.zRot = 0.0F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Hip.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}