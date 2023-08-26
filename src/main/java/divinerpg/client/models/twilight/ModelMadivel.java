package divinerpg.client.models.twilight;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.eden.EntityMadivel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelMadivel extends EntityModel<EntityMadivel> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("madivel");
	private final ModelPart Spine, Sun1, Sun2, EdenSpirit, RightLeg, LeftLeg, RightArm, LeftArm;

	public ModelMadivel(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Spine = root.getChild("Spine");
		this.Sun1 = root.getChild("Sun1");
		this.Sun2 = root.getChild("Sun2");
		this.RightLeg = root.getChild("RightLeg");
		this.LeftLeg = root.getChild("LeftLeg");
		this.RightArm = root.getChild("RightArm");
		this.LeftArm = root.getChild("LeftArm");
		this.EdenSpirit = root.getChild("EdenSpirit");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("Spine", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -20.0F, -8.0F, 18.0F, 19.0F, 18.0F, new CubeDeformation(0.0F))
				.texOffs(54, 0).addBox(-5.5F, -1.0F, -5.0F, 11.0F, 5.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(0, 37).addBox(-9.0F, -27.0F, -6.0F, 18.0F, 7.0F, 14.0F, new CubeDeformation(0.0F))
				.texOffs(72, 17).addBox(-5.0F, -26.0F, -4.0F, 10.0F, 10.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(137, 0).addBox(-5.0F, 1.0F, -3.0F, 4.0F, 21.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(88, 36).addBox(1.0F, 1.0F, -3.0F, 4.0F, 21.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(100, 97).addBox(0.0F, -2.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(26, 88).addBox(1.0F, 6.0F, -3.0F, 6.0F, 20.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(9.0F, -14.0F, 2.0F));

		partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(100, 0).addBox(-8.0F, -2.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(84, 79).addBox(-7.0F, 6.0F, -3.0F, 6.0F, 20.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-9.0F, -14.0F, 2.0F));

		partdefinition.addOrReplaceChild("Sun1", CubeListBuilder.create().texOffs(0, 0).addBox(7.5F, -4.5F, 0.25F, 9.0F, 9.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(101, 16).addBox(9.5F, -2.5F, -2.75F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -32.5F, 1.75F));

		partdefinition.addOrReplaceChild("Sun2", CubeListBuilder.create().texOffs(0, 9).addBox(-17.5F, -4.5F, 0.25F, 9.0F, 9.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(0, 93).addBox(-15.5F, -2.5F, -2.75F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -32.5F, 1.75F));

		PartDefinition EdenSpirit = partdefinition.addOrReplaceChild("EdenSpirit", CubeListBuilder.create().texOffs(54, 0).addBox(-1.5F, -5.0F, -2.25F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 37).addBox(-1.5F, -8.0F, -0.25F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -28.0F, 2.25F));

		EdenSpirit.addOrReplaceChild("EdenSpiritHead", CubeListBuilder.create().texOffs(0, 103).addBox(-2.5F, -5.25F, -4.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(24, 58).addBox(-4.0F, -7.25F, -2.0F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.75F, 0.75F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(EntityMadivel entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.EdenSpirit.yRot = netHeadYaw / (180F / (float)Math.PI);
		this.EdenSpirit.xRot = headPitch / (180F / (float)Math.PI);

		float orbitRadius = 2.0F; // Adjust the orbit radius as needed
		float orbitSpeed = 0.1F; // Adjust the orbit speed as needed

		// Orbit calculation for Sun1
		float sun1OrbitAngle = ageInTicks * orbitSpeed;
		float sun1OffsetX = (float) (Math.cos(sun1OrbitAngle) * orbitRadius);
		float sun1OffsetZ = (float) (Math.sin(sun1OrbitAngle) * orbitRadius);
		this.Sun1.x = this.EdenSpirit.x + sun1OffsetX;
		this.Sun1.z = this.EdenSpirit.z + sun1OffsetZ;

		// Orbit calculation for Sun2
		float sun2OrbitAngle = ageInTicks * orbitSpeed * 0.8F; // Adjust the orbit angle and speed as desired
		float sun2OffsetX = (float) (Math.cos(sun2OrbitAngle) * orbitRadius);
		float sun2OffsetZ = (float) (Math.sin(sun2OrbitAngle) * orbitRadius);
		this.Sun2.x = this.EdenSpirit.x + sun2OffsetX;
		this.Sun2.z = this.EdenSpirit.z + sun2OffsetZ;

		this.RightArm.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 2.0F * limbSwingAmount * 0.5F);
		this.LeftArm.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F);
		this.RightLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
		this.LeftLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);

	}

	@Override
	public void prepareMobModel(EntityMadivel entity, float limbSwing, float limbSwingAmount, float partialTick) {
		float healthFraction = entity.getHealth() / entity.getMaxHealth();
		if (healthFraction < 1.0 / 3.0) {
			this.Sun1.visible = false;
			this.Sun2.visible = false;
		} else if (healthFraction < 2.0 / 3.0) {
			this.Sun1.visible = false;
			this.Sun2.visible = true;
		} else {
			this.Sun1.visible = true;
			this.Sun2.visible = true;
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Spine.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Sun1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Sun2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		EdenSpirit.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}