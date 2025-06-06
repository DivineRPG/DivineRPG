package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.vanilla.overworld.EntityKobblin;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Pose;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelKobblin extends EntityModel<EntityKobblin> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("kobblin");
	public final ModelPart Body, Head, RightEar, LeftEar, Tongue, GrassOverlay, RightArm, LeftArm, RightLeg, LeftLeg;
	int tempBiomeColor = 0xFF00;
	public ModelKobblin(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		Body = root.getChild("Body");
		Head = root.getChild("Head");
		RightEar = Head.getChild("RightEar");
		LeftEar = Head.getChild("LeftEar");
		Tongue = Head.getChild("Tongue");
		GrassOverlay = root.getChild("GrassOverlay");
		RightArm = Body.getChild("RightArm");
		LeftArm = Body.getChild("LeftArm");
		RightLeg = Body.getChild("RightLeg");
		LeftLeg = Body.getChild("LeftLeg");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubeDef = CubeDeformation.NONE;
		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(22, 18).addBox(-3.5F, -7, -1, 7, 4, 4, cubeDef)
		.texOffs(22, 26).addBox(-3, -4, -2, 6, 4, 4, cubeDef), PartPose.offset(0, 22, 1));
		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 18).addBox(-3, -4, -3, 6, 4, 5, cubeDef)
		.texOffs(0, 0).addBox(-7, -6, -8, 14, 2, 14, cubeDef), PartPose.offset(0, 15, 1));
		PartDefinition RightEar = Head.addOrReplaceChild("RightEar", CubeListBuilder.create(), PartPose.offset(-3, -4, 0));
		RightEar.addOrReplaceChild("rightear_r1", CubeListBuilder.create().texOffs(8, 37).addBox(-1, 0, -1, 1, 3, 2, cubeDef), PartPose.rotation(0, 0, Mth.PI/14.4F));
		PartDefinition LeftEar = Head.addOrReplaceChild("LeftEar", CubeListBuilder.create(), PartPose.offset(3, -4, 0));
		LeftEar.addOrReplaceChild("leftear_r1", CubeListBuilder.create().texOffs(14, 37).addBox(0, 0, -1, 1, 3, 2, cubeDef), PartPose.rotation(0, 0, -Mth.PI/14.4F));
		PartDefinition Tongue = Head.addOrReplaceChild("Tongue", CubeListBuilder.create(), PartPose.offset(0, -2, -3));
		Tongue.addOrReplaceChild("tongue_r1", CubeListBuilder.create().texOffs(20, 37).addBox(-1, 0, 0, 2, 3, 0, cubeDef), PartPose.rotation(-Mth.PI/36, 0, 0));
		partdefinition.addOrReplaceChild("GrassOverlay", CubeListBuilder.create().texOffs(0, 43).addBox(-8, -6.5F, -9, 16, 4, 16, cubeDef), PartPose.offset(0, 15, 1));
		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offset(-3.5F, -6, .99F));
		RightArm.addOrReplaceChild("rightarm_r1", CubeListBuilder.create().texOffs(10, 27).addBox(-2, -1, -2, 2, 7, 3, cubeDef), PartPose.rotation(0, 0, Mth.PI/24));
		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offset(3.5F, -6, .99F));
		LeftArm.addOrReplaceChild("leftarm_r1", CubeListBuilder.create().texOffs(0, 27).addBox(0, -1, -2, 2, 7, 3, cubeDef), PartPose.rotation(0, 0, -Mth.PI/24));
		Body.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(34, 34).addBox(-1, 0, -1, 2, 2, 2, cubeDef), PartPose.offset(-2, 0, 0));
		Body.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 37).addBox(-1, 0, -1, 2, 2, 2, cubeDef), PartPose.offset(2, 0, 0));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	@Override public void prepareMobModel(EntityKobblin entity, float limbSwing, float limbSwingAmount, float partialTick) {
		tempBiomeColor = entity.clientBiomeColor;
	}
	@Override public void setupAnim(EntityKobblin entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		//TODO: their legs and head gets stuck at certain position (doesn't reset)
		if(entity.hasPose(Pose.EMERGING)) {
			float f = Mth.sin(ageInTicks * Mth.PI / 20);
			Head.xRot = GrassOverlay.xRot = Body.xRot = f;
			LeftLeg.xRot = RightLeg.xRot = LeftArm.xRot = RightArm.xRot = -f;
		} else if(entity.hasPose(Pose.SHOOTING)) {
			float f = Mth.sin(ageInTicks * Mth.PI / 10) * .2F;
			Head.zRot = GrassOverlay.zRot = Body.zRot = f;
			LeftLeg.zRot = RightLeg.zRot = -f;
			RightArm.xRot += Mth.PI;
		} else {
			float f = Mth.cos(limbSwing) * limbSwingAmount, fs = f * .1F;
			float f1 = Mth.sin(limbSwing) * limbSwingAmount, f1s = f1 * .1F;
			GrassOverlay.yRot = Head.yRot = netHeadYaw * Mth.DEG_TO_RAD / 2 + fs;
			GrassOverlay.xRot = Head.xRot = headPitch * Mth.DEG_TO_RAD / 2 + f1s;
			Body.xRot = 0;
			Tongue.xRot = Body.zRot = fs;
			LeftEar.zRot = f1s;
			RightEar.zRot = -f1s;
			LeftArm.xRot = RightLeg.xRot = f;
			RightArm.xRot = -f;
			LeftLeg.xRot = f1;
		}
	}
	@Override public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		GrassOverlay.render(poseStack, vertexConsumer, packedLight, packedOverlay, tempBiomeColor);
	}
}