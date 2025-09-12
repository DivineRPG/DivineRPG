package divinerpg.client.models.boss;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.boss.EntityKitra;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelKitra extends EntityModel<EntityKitra> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("kitra");
	public final ModelPart body, head, rightFin, leftFin, hip, tailBase;
	public ModelKitra(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		body = root.getChild("body");
		head = body.getChild("head");
		rightFin = body.getChild("right_fin");
		leftFin = body.getChild("left_fin");
		hip = body.getChild("hip");
		tailBase = hip.getChild("tail_base");
	}
	//Statue
	public ModelKitra(ModelPart root) {
		body = root.getChild("body");
		head = body.getChild("head");
		rightFin = body.getChild("right_fin");
		leftFin = body.getChild("left_fin");
		hip = body.getChild("hip");
		tailBase = hip.getChild("tail_base");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubeDef = CubeDeformation.NONE;
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create()
		.texOffs(0, 72).addBox(-21, -10, -1, 42, 23, 42, cubeDef)
		.texOffs(0, 189).addBox(-2, -15, -1, 4, 8, 41, cubeDef), PartPose.offset(0, 2, -17));
		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0, 4, -2));
		head.addOrReplaceChild("head_rot", CubeListBuilder.create().texOffs(0, 0).addBox(-19, -7, -47, 38, 24, 48, cubeDef), PartPose.offsetAndRotation(0, -7, -1, Mth.PI / 24, 0, 0));
		PartDefinition rightFin = body.addOrReplaceChild("right_fin", CubeListBuilder.create(), PartPose.offset(-24, 8, 17));
		rightFin.addOrReplaceChild("right_fin_rot", CubeListBuilder.create().texOffs(0, 137).addBox(-6, -5, 1, 8, 34, 18, cubeDef), PartPose.offsetAndRotation(5, 4, -9, 0, 0, Mth.PI / 18));
		PartDefinition leftFin = body.addOrReplaceChild("left_fin", CubeListBuilder.create(), PartPose.offset(24, 8, 17));
		leftFin.addOrReplaceChild("left_fin_rot", CubeListBuilder.create().texOffs(52, 137).addBox(-1, -5, 1, 8, 34, 18, cubeDef), PartPose.offsetAndRotation(-5, 4, -9, 0, 0, -Mth.PI / 18));
		PartDefinition hip = body.addOrReplaceChild("hip", CubeListBuilder.create()
		.texOffs(126, 72).addBox(-16, 1, -1, 32, 19, 16, cubeDef)
		.texOffs(152, 189).addBox(-2, -5, 1, 4, 8, 15, cubeDef), PartPose.offset(0, -10, 39));
		PartDefinition tailBase = hip.addOrReplaceChild("tail_base", CubeListBuilder.create()
		.texOffs(104, 137).addBox(-13, -2, -1.5F, 26, 18, 11, cubeDef)
		.texOffs(172, 0).addBox(-2, -9, -.5F, 4, 8, 9, cubeDef), PartPose.offset(0, 4, 16.5F));
		PartDefinition tailSegment1 = tailBase.addOrReplaceChild("tail_segment_1", CubeListBuilder.create()
		.texOffs(172, 17).addBox(-2, -8.5F, -1.25F, 4, 8, 10, cubeDef)
		.texOffs(103, 166).addBox(-11, -1.5F, -1.25F, 22, 12, 11, cubeDef), PartPose.offset(0, -.5F, 10.75F));
		PartDefinition tailSegment2 = tailSegment1.addOrReplaceChild("tail_segment_2", CubeListBuilder.create()
		.texOffs(103, 166).addBox(-11, -1.5F, -.5F, 22, 12, 11, cubeDef)
		.texOffs(172, 35).addBox(-2, -8.5F, -.5F, 4, 8, 11, cubeDef), PartPose.offset(0, 0, 10.25F));
		PartDefinition tailSegment3 = tailSegment2.addOrReplaceChild("tail_segment_3", CubeListBuilder.create()
		.texOffs(103, 166).addBox(-11, -1.5F, 0, 22, 12, 11, cubeDef)
		.texOffs(172, 35).addBox(-2, -8.5F, 1, 4, 8, 11, cubeDef), PartPose.offset(0, 0, 10.5F));
		tailSegment3.addOrReplaceChild("tail_tip", CubeListBuilder.create().texOffs(90, 189).addBox(0, -4.5F, .5F, 0, 13, 31, cubeDef), PartPose.offset(0, -6, 11.5F));
		return LayerDefinition.create(meshdefinition, 202, 238);
	}
	@Override public void setupAnim(EntityKitra entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		head.xRot = Mth.cos(limbSwing * .2F) * limbSwingAmount / 8;
		if(!entity.onGround() || entity.isInWater()) {
			body.xRot = headPitch * Mth.DEG_TO_RAD / 4;
			body.yRot = netHeadYaw * Mth.DEG_TO_RAD / 4;
		} else body.xRot = body.yRot = 0;
		rightFin.zRot = -Mth.sin(10 * ageInTicks / Mth.RAD_TO_DEG) * .3F;
		leftFin.zRot = -rightFin.zRot;
		hip.xRot = tailBase.xRot = -head.xRot;
	}
	@Override public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}