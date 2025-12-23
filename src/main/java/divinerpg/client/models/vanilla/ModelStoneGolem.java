package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.TamableAnimal;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelStoneGolem<T extends TamableAnimal> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("stone_golem");
	private final ModelPart body, ring, core, ring2, Head, arm0, arm1;

	public ModelStoneGolem(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		body = root.getChild("body");
		ring = body.getChild("ring");
		core = ring.getChild("core");
		ring2 = ring.getChild("ring2");
		Head = body.getChild("Head");
		arm0 = body.getChild("arm0");
		arm1 = body.getChild("arm1");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-9F, 3F, -6F, 18F, 12F, 11F, CubeDeformation.NONE)
				.texOffs(0, 39).addBox(-4.5F, 15F, -3.5F, 9F, 5F, 6F, new CubeDeformation(0.5F))
				.texOffs(54, 35).addBox(-4.5F, 15F, -3.5F, 9F, 5F, 6F, new CubeDeformation(0.6F)), PartPose.offset(0F, -7F, 0F));

		PartDefinition ring = body.addOrReplaceChild("ring", CubeListBuilder.create().texOffs(73, 24).addBox(-5.5F, 1F, -5.5F, 10F, 1F, 10F, CubeDeformation.NONE)
				.texOffs(54, 0).addBox(-8.5F, 1.5F, -8.5F, 16F, 0F, 16F, CubeDeformation.NONE), PartPose.offset(0.5F, 23F, 0.5F));

		ring.addOrReplaceChild("core", CubeListBuilder.create().texOffs(25, 48).addBox(-3F, -3F, -3F, 5F, 5F, 5F, CubeDeformation.NONE), PartPose.offset(0F, 2F, 0F));

		ring.addOrReplaceChild("ring2", CubeListBuilder.create().texOffs(83, 46).addBox(-3F, 1F, -3F, 6F, 1F, 6F, CubeDeformation.NONE)
				.texOffs(90, 0).addBox(-6F, 1.5F, -6F, 12F, 0F, 12F, CubeDeformation.NONE), PartPose.offset(-0.5F, 5F, -0.5F));

		PartDefinition Head = body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 23).addBox(-4F, -6F, -6.5F, 8F, 8F, 8F, CubeDeformation.NONE)
				.texOffs(32, 23).addBox(-4.5F, 2F, -7.5F, 9F, 2F, 9F, CubeDeformation.NONE), PartPose.offset(0F, 0F, -2F));

		Head.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(0, 66).mirror().addBox(0F, -4F, -1.5F, 3F, 5F, 5F, CubeDeformation.NONE).mirror(false)
				.texOffs(16, 66).mirror().addBox(0.1F, -7F, 1.5F, 2F, 7F, 4F, CubeDeformation.NONE).mirror(false)
				.texOffs(16, 66).addBox(-10.1F, -7F, 1.5F, 2F, 7F, 4F, CubeDeformation.NONE)
				.texOffs(0, 66).addBox(-11F, -4F, -1.5F, 3F, 5F, 5F, CubeDeformation.NONE), PartPose.offsetAndRotation(4F, -2F, -2F, 0.3927F, 0F, 0F));

		body.addOrReplaceChild("arm0", CubeListBuilder.create().texOffs(30, 34).addBox(-15F, 2.5F, -3F, 6F, 8F, 6F, CubeDeformation.NONE)
				.texOffs(0, 50).addBox(-16F, 10.5F, -2F, 6F, 10F, 6F, CubeDeformation.NONE)
				.texOffs(58, 8).addBox(-12F, 20.5F, -1F, 2F, 3F, 3F, CubeDeformation.NONE)
				.texOffs(58, 0).addBox(-16F, 20.5F, -1F, 2F, 4F, 4F, CubeDeformation.NONE)
				.texOffs(45, 48).addBox(-12F, 20.5F, -1F, 2F, 3F, 3F, new CubeDeformation(0.1F))
				.texOffs(55, 46).addBox(-16F, 20.5F, -1F, 2F, 4F, 4F, new CubeDeformation(0.1F)), PartPose.offset(0F, 0F, 0F));

		body.addOrReplaceChild("arm1", CubeListBuilder.create().texOffs(30, 34).mirror().addBox(9F, 2.5F, -3F, 6F, 8F, 6F, CubeDeformation.NONE).mirror(false)
				.texOffs(0, 50).mirror().addBox(10F, 10.5F, -2F, 6F, 10F, 6F, CubeDeformation.NONE).mirror(false)
				.texOffs(58, 8).mirror().addBox(10F, 20.5F, -1F, 2F, 3F, 3F, CubeDeformation.NONE).mirror(false)
				.texOffs(45, 48).mirror().addBox(10F, 20.5F, -1F, 2F, 3F, 3F, new CubeDeformation(0.1F)).mirror(false)
				.texOffs(58, 0).mirror().addBox(14F, 20.5F, -1F, 2F, 4F, 4F, CubeDeformation.NONE).mirror(false)
				.texOffs(55, 46).mirror().addBox(14F, 20.5F, -1F, 2F, 4F, 4F, new CubeDeformation(0.1F)).mirror(false), PartPose.offset(0F, 0F, 0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		ring.yRot = (ageInTicks * 0.2F);
		core.yRot = -0.5F * ring.yRot;
		ring2.yRot = -2F * ring.yRot;
		Head.xRot = headPitch * Mth.DEG_TO_RAD;
		Head.yRot = netHeadYaw * Mth.DEG_TO_RAD;
		float f = Mth.sin(ageInTicks * 0.08F);
		arm0.y = arm1.y = 2F + f * 0.3F;
		body.y = -17F + f * 0.2F;
		ring.y = 23F - f * 0.25F;
		if(entity.swinging) {
			arm0.xRot = arm1.xRot = Mth.sin((entity.swingTime + ageInTicks - Mth.floor(ageInTicks)) * Mth.PI / entity.getCurrentSwingDuration()) * -Mth.HALF_PI;
		} else arm0.xRot = arm1.xRot = 0F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}