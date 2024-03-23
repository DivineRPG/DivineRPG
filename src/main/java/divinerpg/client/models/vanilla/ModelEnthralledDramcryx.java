package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.vanilla.overworld.EntityEnthralledDramcryx;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelEnthralledDramcryx extends EntityModel<EntityEnthralledDramcryx> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("enthralled_dramcryx");
	public final ModelPart Body, Tail, Head, BackRightLeg, FrontLeftLeg, FrontRightLeg, BackLeftLeg;
	public ModelEnthralledDramcryx(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		Body = root.getChild("Body");
		Tail = Body.getChild("Tail");
		Head = Body.getChild("Head");
		BackRightLeg = root.getChild("BackRightLeg");
		FrontLeftLeg = root.getChild("FrontLeftLeg");
		FrontRightLeg = root.getChild("FrontRightLeg");
		BackLeftLeg = root.getChild("BackLeftLeg");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubeDef = CubeDeformation.NONE;
		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0, 15, 2));
		Body.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-7, -7, -19, 14, 8, 20, cubeDef), PartPose.offsetAndRotation(0, 2, 8, -.2618F, 0, 0));
		PartDefinition Spines = Body.addOrReplaceChild("Spines", CubeListBuilder.create().texOffs(40, 28).addBox(-1, -17, -6.5F, 5, 16, 6, cubeDef), PartPose.offset(-1.5F, -4, .5F));
		Spines.addOrReplaceChild("BackSpine_r1", CubeListBuilder.create().texOffs(66, 43).addBox(-1, -18.03F, -6.94F, 3, 10, 3, cubeDef), PartPose.offsetAndRotation(1, 7, -3.5F, -1.0908F, 0, 0));
		Spines.addOrReplaceChild("MiddleSpine_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-2.01F, -22.54F, -2.29F, 5, 14, 4, cubeDef), PartPose.offsetAndRotation(1, 7, -3.5F, -.3927F, 0, 0));
		Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(62, 28).addBox(-4, -8, -2.5F, 8, 10, 5, cubeDef), PartPose.offsetAndRotation(0, 1, 11.5F, -.3491F, 0, 0));
		Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(4, 28).addBox(4.99F, -1, -10.5F, 1, 5, 1, cubeDef)
		.texOffs(0, 28).addBox(-5.99F, -1, -10.5F, 1, 5, 1, cubeDef)
		.texOffs(0, 28).addBox(-6, -5, -8, 12, 10, 8, cubeDef)
		.texOffs(0, 65).addBox(-5, -2, -10, 10, 7, 2, cubeDef)
		.texOffs(32, 28).addBox(1, -8F, -4.2F, 4, 3, 3, cubeDef)
		.texOffs(66, 0).addBox(-5, -8F, -4.2F, 4, 3, 3, cubeDef), PartPose.offset(0, -6, -9));
		partdefinition.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(0, 46).addBox(-4, -3, -3, 6, 13, 6, cubeDef), PartPose.offset(-5, 14, 7));
		partdefinition.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(48, 50).addBox(-2, -3, -3, 6, 13, 6, cubeDef), PartPose.offset(4, 14, -5));
		partdefinition.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(24, 50).addBox(-4, -3, -3, 6, 13, 6, cubeDef), PartPose.offset(-4, 14, -5));
		partdefinition.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(48, 0).addBox(-2, -3, -3, 6, 13, 6, cubeDef), PartPose.offset(5, 14, 7));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	@Override public void setupAnim(EntityEnthralledDramcryx entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		Head.yRot = netHeadYaw * Mth.DEG_TO_RAD;
		Head.xRot = headPitch * Mth.DEG_TO_RAD;
		float f = Mth.cos(limbSwing * .6662F) * 1.4F * limbSwingAmount;
		float f1 = Mth.cos(limbSwing * .6662F + Mth.PI) * 1.4F * limbSwingAmount;
		Body.zRot = f * .05F;
		Tail.yRot = f * .25F;
		FrontRightLeg.xRot = BackLeftLeg.xRot = f1;
		FrontLeftLeg.xRot = BackRightLeg.xRot = f;
	}
	@Override public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}