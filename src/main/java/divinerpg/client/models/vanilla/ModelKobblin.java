package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.vanilla.overworld.EntityKobblin;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Pose;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelKobblin extends EntityModel<EntityKobblin> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("kobblin");
	private final ModelPart Body, LeftArm, RightArm, RightLeg, LeftLeg, Head, LeftEar, RightEar, Tongue, GrassOverlay;

	public ModelKobblin(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		Body = root.getChild("Body");
		LeftArm = Body.getChild("LeftArm");
		RightArm = Body.getChild("RightArm");
		RightLeg = Body.getChild("RightLeg");
		LeftLeg = Body.getChild("LeftLeg");
		Head = root.getChild("Head");
		LeftEar = Head.getChild("LeftEar");
		RightEar = Head.getChild("RightEar");
		Tongue = Head.getChild("Tongue");
		GrassOverlay = root.getChild("GrassOverlay");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation zero = new CubeDeformation(0F);

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(22, 18).addBox(-3.5F, -7F, -1F, 7F, 4F, 4F, zero)
				.texOffs(22, 26).addBox(-3F, -4F, -2F, 6F, 4F, 4F, zero), PartPose.offset(0F, 22F, 1F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offset(3.5F, -6F, 1F));

		LeftArm.addOrReplaceChild("leftarm_r1", CubeListBuilder.create().texOffs(0, 27).addBox(0F, -1F, -2F, 2F, 7F, 3F, zero), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0F, -0.1309F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offset(-3.5F, -6F, 1F));

		RightArm.addOrReplaceChild("rightarm_r1", CubeListBuilder.create().texOffs(10, 27).addBox(-2F, -1F, -2F, 2F, 7F, 3F, zero), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0F, 0.1309F));

		Body.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(34, 34).addBox(-1F, 0F, -1F, 2F, 2F, 2F, zero), PartPose.offset(-2F, 0F, 0F));

		Body.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 37).addBox(-1F, 0F, -1F, 2F, 2F, 2F, zero), PartPose.offset(2F, 0F, 0F));

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 18).addBox(-3F, -4F, -3F, 6F, 4F, 5F, zero)
				.texOffs(0, 0).addBox(-7F, -6F, -8F, 14F, 2F, 14F, zero), PartPose.offset(0F, 15F, 1F));

		PartDefinition LeftEar = Head.addOrReplaceChild("LeftEar", CubeListBuilder.create(), PartPose.offset(3F, -4F, 0F));

		LeftEar.addOrReplaceChild("leftear_r1", CubeListBuilder.create().texOffs(14, 37).addBox(0F, 0F, -1F, 1F, 3F, 2F, zero), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0F, -0.2182F));

		PartDefinition RightEar = Head.addOrReplaceChild("RightEar", CubeListBuilder.create(), PartPose.offset(-3F, -4F, 0F));

		RightEar.addOrReplaceChild("rightear_r1", CubeListBuilder.create().texOffs(8, 37).addBox(-1F, 0F, -1F, 1F, 3F, 2F, zero), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0F, 0.2182F));

		PartDefinition Tongue = Head.addOrReplaceChild("Tongue", CubeListBuilder.create(), PartPose.offset(0F, -2F, -3F));

		Tongue.addOrReplaceChild("tongue_r1", CubeListBuilder.create().texOffs(20, 37).addBox(-1F, 0F, 0F, 2F, 3F, 0F, zero), PartPose.offsetAndRotation(0F, 0F, 0F, -0.0873F, 0F, 0F));

		partdefinition.addOrReplaceChild("GrassOverlay", CubeListBuilder.create().texOffs(0, 43).addBox(-8F, -6.5F, -9F, 16F, 4F, 16F, zero), PartPose.offset(0F, 15F, 1F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	@Override
	public void setupAnim(EntityKobblin entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if(entity.hasPose(Pose.EMERGING)) {
			float f = Mth.sin(ageInTicks * Mth.PI / 20F);
			Head.xRot = GrassOverlay.xRot = Body.xRot = f;
			LeftLeg.xRot = RightLeg.xRot = LeftArm.xRot = RightArm.xRot = -f;
		} else if(entity.hasPose(Pose.SHOOTING)) {
			float f = Mth.sin((ageInTicks) * Mth.PI / 10F) * 0.2F;
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
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		GrassOverlay.render(poseStack, vertexConsumer, packedLight, packedOverlay, tempBiomeColor);
	}
	int tempBiomeColor = 0xFF00;
	@Override
	public void prepareMobModel(EntityKobblin entity, float limbSwing, float limbSwingAmount, float partialTick) {
		if((entity.tickCount & 0xF) == 1) entity.clientBiomeColor = entity.level().getBiome(entity.blockPosition()).value().getGrassColor(entity.getX(), entity.getZ());
		tempBiomeColor = entity.clientBiomeColor;
	}
}