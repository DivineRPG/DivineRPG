package divinerpg.client.models.iceika;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelFrozenFlesh<T extends Entity> extends EntityModel<T> {

	public static final ModelLayerLocation LAYER_LOCATION = createLocation("frozen_flesh");
	private final ModelPart Head, Torso, Base;

	public ModelFrozenFlesh(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Head = root.getChild("Head");
		this.Torso = root.getChild("Torso");
		this.Base = root.getChild("Base");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 20).addBox(-4.5F, -8.0F, -4.5F, 9.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.5F));

		PartDefinition Torso = partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(29, 30).addBox(-4.0F, -9.0F, -3.0F, 8.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, 0.0F));

		Torso.addOrReplaceChild("leftshoulder_r1", CubeListBuilder.create().texOffs(12, 37).addBox(0.0F, -3.0F, -2.0F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -6.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		Torso.addOrReplaceChild("rightshoulder_r1", CubeListBuilder.create().texOffs(0, 37).addBox(-1.0F, -3.0F, -2.0F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -6.0F, 0.0F, 0.0F, 0.0F, -0.5236F));

		PartDefinition LeftArm = Torso.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offset(4.0F, -7.0F, 0.0F));

		LeftArm.addOrReplaceChild("leftarm_r1", CubeListBuilder.create().texOffs(27, 20).addBox(0.0F, -1.5F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition RightArm = Torso.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offset(-4.0F, -7.0F, 0.0F));

		RightArm.addOrReplaceChild("rightarm_r1", CubeListBuilder.create().texOffs(27, 24).addBox(-8.0F, -1.5F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 1.0F, 0.0F, 0.0F, 0.0F, -0.4363F));

		partdefinition.addOrReplaceChild("Base", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, 0.0F, -4.5F, 10.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, 0.5F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch / (180F / (float) Math.PI);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Base.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}