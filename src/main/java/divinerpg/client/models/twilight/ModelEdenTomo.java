package divinerpg.client.models.twilight;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.eden.EntityEdenTomo;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelEdenTomo extends EntityModel<EntityEdenTomo> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("eden_tomo");
	public final ModelPart Torso, RightAntenna, LeftAntenna, RightArm, LeftArm, RightFoot, LeftFoot;
	public ModelEdenTomo(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		Torso = root.getChild("Torso");
		RightAntenna = Torso.getChild("RightAntenna");
		LeftAntenna = Torso.getChild("LeftAntenna");
		RightArm = Torso.getChild("RightArm");
		LeftArm = Torso.getChild("LeftArm");
		RightFoot = root.getChild("RightFoot");
		LeftFoot = root.getChild("LeftFoot");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubeDef = CubeDeformation.NONE;
		PartDefinition Torso = partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(0, 0).addBox(-6, -7, -4, 12, 8, 9, cubeDef)
		.texOffs(0, 17).addBox(-6, -7, -5, 12, 8, 1, cubeDef), PartPose.offset(0, 20, 0));
		Torso.addOrReplaceChild("RightAntenna", CubeListBuilder.create().texOffs(37, 19).addBox(-1.5F, -6.5F, -3, 3, 3, 3, cubeDef)
		.texOffs(28, 32).addBox(-1.5F, -5, -1.5F, 3, 5, 3, cubeDef), PartPose.offsetAndRotation(-2.5F, -6, 0, .0873F, .1745F, 0));
		Torso.addOrReplaceChild("LeftAntenna", CubeListBuilder.create().texOffs(0, 36).addBox(-1.5F, -6.5F, -3, 3, 3, 3, cubeDef)
		.texOffs(16, 32).addBox(-1.5F, -5, -1.5F, 3, 5, 3, cubeDef), PartPose.offsetAndRotation(2.5F, -6, 0, .0873F, -.1745F, 0));
		PartDefinition RightArm = Torso.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offset(-6, -5, -.5F));
		RightArm.addOrReplaceChild("RightArm_r1", CubeListBuilder.create().texOffs(33, 0).addBox(-4, -1, -1.5F, 4, 2, 3, cubeDef), PartPose.ZERO);
		PartDefinition LeftArm = Torso.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offset(6, -5, -.5F));
		LeftArm.addOrReplaceChild("LeftArm_r1", CubeListBuilder.create().texOffs(26, 17).addBox(0, -1, -1.5F, 4, 2, 3, cubeDef), PartPose.ZERO);
		partdefinition.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(22, 22).addBox(-2, 0, -1, 4, 6, 4, cubeDef), PartPose.offset(-3, 18, -1));
		partdefinition.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(0, 26).addBox(-2, 0, -1, 4, 6, 4, cubeDef), PartPose.offset(3, 18, -1));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	@Override public void setupAnim(EntityEdenTomo entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = Mth.cos(ageInTicks * .12F + limbSwing * .6F) * (.08F + limbSwingAmount * .4F);
		float f1 = Mth.cos(ageInTicks * .1F + limbSwing * .5F) * (.08F + limbSwingAmount * .4F);
		float f2 = Mth.cos(limbSwing * .6662F) * limbSwingAmount;
		Torso.zRot = f2 * .8F;
		RightAntenna.zRot = -Mth.PI / 16 - f;
		LeftAntenna.zRot = Mth.PI / 16 + f1;
		RightArm.zRot = Mth.PI / 6 + f1 - .5F;
		LeftArm.zRot = -Mth.PI / 6 - f + .5F;
		RightFoot.xRot = f2 * .7F;
		LeftFoot.xRot = Mth.cos(limbSwing * .6662F + Mth.PI) * .7F * limbSwingAmount;
	}
	@Override public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightFoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftFoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}