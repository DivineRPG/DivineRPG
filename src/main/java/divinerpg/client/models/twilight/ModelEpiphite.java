package divinerpg.client.models.twilight;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;

import static divinerpg.util.ClientUtils.createLocation;


public class ModelEpiphite<T extends LivingEntity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("epiphite");
	private final ModelPart Head, Body, LeftFin, RightFin, SpineFin, Tail, TailFin, BackLeftFoot, BackRightFoot, FrontRightFoot, FrontLeftFoot;

	public ModelEpiphite(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		Head = root.getChild("Head");
		Body = root.getChild("Body");
		LeftFin = Body.getChild("LeftFin");
		RightFin = Body.getChild("RightFin");
		SpineFin = Body.getChild("SpineFin");
		Tail = Body.getChild("Tail");
		TailFin = Tail.getChild("TailFin");
		BackLeftFoot = Body.getChild("BackLeftFoot");
		BackRightFoot = Body.getChild("BackRightFoot");
		FrontRightFoot = Body.getChild("FrontRightFoot");
		FrontLeftFoot = Body.getChild("FrontLeftFoot");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 21).addBox(-2F, -2F, -4F, 4F, 4F, 4F, CubeDeformation.NONE)
				.texOffs(30, 28).addBox(1F, -3F, -2F, 1F, 1F, 2F, CubeDeformation.NONE)
				.texOffs(30, 31).addBox(-2F, -3F, -2F, 1F, 1F, 2F, CubeDeformation.NONE)
				.texOffs(24, 28).addBox(2F, -1F, -2F, 1F, 3F, 2F, CubeDeformation.NONE)
				.texOffs(0, 29).addBox(-3F, -1F, -2F, 1F, 3F, 2F, CubeDeformation.NONE)
				.texOffs(6, 32).addBox(-2F, 2F, -4F, 1F, 2F, 1F, CubeDeformation.NONE)
				.texOffs(10, 32).addBox(1F, 2F, -4F, 1F, 2F, 1F, CubeDeformation.NONE), PartPose.offset(0F, 17F, -4F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-2F, -2F, 0F, 4F, 4F, 10F, CubeDeformation.NONE), PartPose.offset(0F, 18F, -4F));

		PartDefinition LeftFin = Body.addOrReplaceChild("LeftFin", CubeListBuilder.create(), PartPose.offset(2F, 0F, 1F));

		LeftFin.addOrReplaceChild("leftfin_r1", CubeListBuilder.create().texOffs(6, 29).addBox(0F, -2F, 0F, 4F, 3F, 0F, CubeDeformation.NONE), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, -1.3526F, 0F));

		PartDefinition RightFin = Body.addOrReplaceChild("RightFin", CubeListBuilder.create(), PartPose.offset(-2F, 0F, 1F));

		RightFin.addOrReplaceChild("rightfin_r1", CubeListBuilder.create().texOffs(28, 11).addBox(-4F, -2F, 0F, 4F, 3F, 0F, CubeDeformation.NONE), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 1.3526F, 0F));

		PartDefinition SpineFin = Body.addOrReplaceChild("SpineFin", CubeListBuilder.create(), PartPose.offset(0F, -2F, 1F));

		SpineFin.addOrReplaceChild("spinefin_r1", CubeListBuilder.create().texOffs(16, 28).addBox(-2F, -4F, 0F, 4F, 4F, 0F, CubeDeformation.NONE), PartPose.offsetAndRotation(0F, 0F, 0F, -1.3526F, 0F, 0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(36, 0).addBox(-1F, 0F, -1F, 2F, 2F, 3F, CubeDeformation.NONE), PartPose.offset(0F, -1F, 10F));

		Tail.addOrReplaceChild("TailFin", CubeListBuilder.create().texOffs(0, 14).addBox(-3F, 0F, 0F, 6F, 0F, 7F, CubeDeformation.NONE), PartPose.offset(0F, 1F, 2F));

		Body.addOrReplaceChild("BackLeftFoot", CubeListBuilder.create().texOffs(28, 0).addBox(0F, 0F, -1F, 2F, 5F, 2F, CubeDeformation.NONE), PartPose.offset(1F, 1F, 9.5F));

		Body.addOrReplaceChild("BackRightFoot", CubeListBuilder.create().texOffs(26, 14).addBox(-2F, 0F, -1F, 2F, 5F, 2F, CubeDeformation.NONE), PartPose.offset(-1F, 1F, 9.5F));

		Body.addOrReplaceChild("FrontRightFoot", CubeListBuilder.create().texOffs(24, 21).addBox(-2F, 0F, -1F, 2F, 5F, 2F, CubeDeformation.NONE), PartPose.offset(-1F, 1F, 2F));

		Body.addOrReplaceChild("FrontLeftFoot", CubeListBuilder.create().texOffs(16, 21).addBox(0F, 0F, -1F, 2F, 5F, 2F, CubeDeformation.NONE), PartPose.offset(1F, 1F, 2F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		Head.xRot = headPitch * Mth.DEG_TO_RAD;
		Head.yRot = netHeadYaw * Mth.DEG_TO_RAD;
		BackRightFoot.xRot = FrontLeftFoot.xRot = Mth.cos(limbSwing * .6662F) * 1.4F * limbSwingAmount;
		FrontRightFoot.xRot = BackLeftFoot.xRot = -FrontLeftFoot.xRot;
		Tail.yRot = FrontLeftFoot.xRot * 0.5F;
		if(entity.swinging) {
			LeftFin.yRot = SpineFin.xRot = Mth.sin((entity.swingTime + ageInTicks - Mth.floor(ageInTicks)) * Mth.PI / entity.getCurrentSwingDuration()) * (80F + Mth.cos(ageInTicks * 4F) * 15F) * Mth.DEG_TO_RAD;
			RightFin.yRot = -SpineFin.xRot;
			TailFin.xRot = Tail.xRot = SpineFin.xRot * 0.5F;
		} else LeftFin.yRot = SpineFin.xRot = RightFin.yRot = TailFin.xRot = Tail.xRot = 0F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}