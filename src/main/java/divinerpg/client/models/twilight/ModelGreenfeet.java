package divinerpg.client.models.twilight;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.eden.EntityGreenfeet;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelGreenfeet extends EntityModel<EntityGreenfeet> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("greenfeet");
	public final ModelPart Body, Head, RightArm, LeftArm, RightLeg, LeftLeg;
	public ModelGreenfeet(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		Body = root.getChild("Body");
		Head = Body.getChild("Head");
		RightArm = Body.getChild("RightArm");
		LeftArm = Body.getChild("LeftArm");
		RightLeg = root.getChild("RightLeg");
		LeftLeg = root.getChild("LeftLeg");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubeDef = CubeDeformation.NONE;
		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0, 12, .5F));
		Body.addOrReplaceChild("Chest_r1", CubeListBuilder.create().texOffs(0, 30).addBox(-4.5F, -12, -1.5F, 9, 14, 5, cubeDef), PartPose.offsetAndRotation(0, -1, 0, .3927F, 0, 0));
		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offset(0, -12, -3.5F));
		Head.addOrReplaceChild("skull_r1", CubeListBuilder.create().texOffs(28, 30).addBox(-2.5F, -10, -3, 5, 12, 4, cubeDef), PartPose.offsetAndRotation(0, 3, -3, -.3927F, 0, 0));
		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(28, 0).addBox(-2, -1, -2, 2, 8, 3, cubeDef), PartPose.offset(-4.5F, -11, -2.5F));
		RightArm.addOrReplaceChild("RightBlade", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -1, -7, 2, 2, 10, cubeDef)
		.texOffs(0, 0).addBox(-1, 0, -13, 0, 6, 18, cubeDef), PartPose.offset(-.5F, 8, -1));
		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(25, 46).addBox(0, -1, -2, 2, 8, 3, cubeDef), PartPose.offset(4.5F, -11, -2.5F));
		LeftArm.addOrReplaceChild("LeftBlade", CubeListBuilder.create().texOffs(14, 2).addBox(-1.5F, 0, -7, 2, 2, 10, cubeDef)
		.texOffs(0, 6).addBox(0, 1, -13, 0, 6, 18, cubeDef), PartPose.offset(1.5F, 7, -1));
		partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(42, 42).addBox(-2, 0, -2, 4, 12, 4, cubeDef), PartPose.offset(-3, 12, 1));
		partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(36, 10).addBox(-2, 0, -2, 4, 12, 4, cubeDef), PartPose.offset(3, 12, 1));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	@Override public void setupAnim(EntityGreenfeet entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		Head.yRot = netHeadYaw * Mth.DEG_TO_RAD;
		Head.xRot = headPitch * Mth.DEG_TO_RAD - .5672F;
		float f = Mth.cos(limbSwing * .6662F) * limbSwingAmount;
		float f1 = Mth.cos(limbSwing * .6662F + Mth.PI) * limbSwingAmount;
		Body.zRot = f * .05F;
		RightLeg.xRot = f * 1.4F;
		LeftLeg.xRot = f1 * 1.4F;
		RightArm.xRot = f1;
		LeftArm.xRot = f;
		RightArm.yRot = LeftArm.yRot = RightArm.zRot = LeftArm.zRot = 0;
		AnimationUtils.bobModelPart(RightArm, ageInTicks, 1);
		AnimationUtils.bobModelPart(LeftArm, ageInTicks, -1);
		setupAttackAnimation(entity, ageInTicks);
	}
	protected ModelPart getArm(HumanoidArm humanoidarm) {return RightArm;}
	private HumanoidArm getAttackArm(EntityGreenfeet p_102857_) {return p_102857_.getMainArm();}
	protected void setupAttackAnimation(EntityGreenfeet p_102858_, float p_102859_) {
		if(!(attackTime <= 0)) {
			HumanoidArm humanoidarm = getAttackArm(p_102858_);
			ModelPart modelpart = getArm(humanoidarm);
			float f = attackTime;
			Body.yRot = Mth.sin(Mth.sqrt(f) * Mth.PI * 2) * .2F;
			RightArm.yRot += Body.yRot;
			f = 1 - attackTime;
			f *= f;
			f *= f;
			f = 1 - f;
			float f1 = Mth.sin(f * Mth.PI);
			float f2 = Mth.sin(attackTime * Mth.PI) * -(Head.xRot - .7F) * .75F;
			modelpart.xRot -= f1 * 1.2F + f2;
			modelpart.yRot += Body.yRot * 2;
			modelpart.zRot += Mth.sin(attackTime * Mth.PI) * -.4F;
		}
	}
	@Override public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}