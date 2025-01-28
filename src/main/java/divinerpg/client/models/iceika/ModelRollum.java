package divinerpg.client.models.iceika;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.iceika.EntityRollum;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelRollum extends EntityModel<EntityRollum> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("rollum");
	public final ModelPart Torso, Head, RightArm, LeftArm, RightLeg, LeftLeg;
	public ModelRollum(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		Torso = root.getChild("Torso");
		Head = Torso.getChild("Head");
		RightArm = Torso.getChild("RightArm");
		LeftArm = Torso.getChild("LeftArm");
		RightLeg = root.getChild("RightLeg");
		LeftLeg = root.getChild("LeftLeg");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubeDef = CubeDeformation.NONE;
		PartDefinition Torso = partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create(), PartPose.offset(0, 7, 0));
		Torso.addOrReplaceChild("Torso_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-8, -14, -2.8F, 16, 14, 12, cubeDef), PartPose.offsetAndRotation(0, 0, -.2F, .48F, 0, 0));
		Torso.addOrReplaceChild("Hip", CubeListBuilder.create().texOffs(0, 26).addBox(-7, 0, -5, 14, 8, 9, cubeDef), PartPose.offset(0, -1, 2));
		Torso.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(38, 35).addBox(-5, -4, -9, 10, 7, 8, cubeDef), PartPose.offset(0, -8.37F, -4.7F));
		PartDefinition RightArm = Torso.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(56, 0).addBox(-7, -4, -7, 7, 7, 9, cubeDef), PartPose.offset(-7.9F, -9.67F, 1.3F));
		RightArm.addOrReplaceChild("RightLowerArm", CubeListBuilder.create().texOffs(0, 43).addBox(-1, -1, -4, 5, 13, 9, cubeDef), PartPose.offset(-6, 4, -3));
		PartDefinition LeftArm = Torso.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(47, 17).addBox(0, -4, -5, 7, 7, 9, cubeDef), PartPose.offset(7.9F, -9.67F, -.7F));
		LeftArm.addOrReplaceChild("LeftLowerArm", CubeListBuilder.create().texOffs(28, 50).addBox(-4, -1, -4, 5, 13, 9, cubeDef), PartPose.offset(6, 4, -1));
		partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 65).addBox(-4, 0, -4, 6, 10, 8, cubeDef), PartPose.offset(-3, 14, 1));
		partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(56, 50).addBox(-2, 0, -4, 6, 10, 8, cubeDef), PartPose.offset(3, 14, 1));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	@Override public void setupAnim(EntityRollum entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		Head.yRot = netHeadYaw * Mth.DEG_TO_RAD;
		Head.xRot = headPitch * Mth.DEG_TO_RAD;
		float f = Mth.cos(limbSwing * .6662F) * limbSwingAmount;
		float f1 = Mth.cos(limbSwing * .6662F + Mth.PI) * limbSwingAmount;
		Torso.zRot = f * .05F;
		RightArm.xRot = f1;
		LeftArm.xRot = f;
		RightArm.yRot = LeftArm.yRot = RightArm.zRot = LeftArm.zRot = 0;
		AnimationUtils.bobModelPart(RightArm, ageInTicks, 1);
		AnimationUtils.bobModelPart(LeftArm, ageInTicks, -1);
		RightLeg.xRot = f * 1.4F;
		LeftLeg.xRot = f1 * 1.4F;
		setupAttackAnimation(entity, ageInTicks);
	}
	protected ModelPart getArm(HumanoidArm humanoidarm) {return RightArm;}
	private HumanoidArm getAttackArm(EntityRollum entity) {return entity.getMainArm();}
	protected void setupAttackAnimation(EntityRollum entity, float ageInTicks) {
		if(!(attackTime <= 0)) {
			HumanoidArm humanoidarm = getAttackArm(entity);
			ModelPart modelpart = getArm(humanoidarm);
			float f = attackTime;
			Torso.yRot = Mth.sin(Mth.sqrt(f) * (Mth.PI * 2)) * .2F;
			RightArm.yRot += Torso.yRot;
			f = 1 - attackTime;
			f *= f;
			f *= f;
			f = 1 - f;
			float f1 = Mth.sin(f * Mth.PI);
			float f2 = Mth.sin(attackTime * Mth.PI) * -(Head.xRot - .7F) * .75F;
			modelpart.xRot -= f1 * 1.2F + f2;
			modelpart.yRot += Torso.yRot * 2;
			modelpart.zRot += Mth.sin(attackTime * Mth.PI) * -.4F;
		}
	}
	@Override public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}