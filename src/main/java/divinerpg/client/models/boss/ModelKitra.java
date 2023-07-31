package divinerpg.client.models.boss;// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.boss.EntityKitra;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelKitra extends EntityModel<EntityKitra> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("kitra");
	private final ModelPart Head;
	private final ModelPart Torso;

	public ModelKitra(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Head = root.getChild("Head");
		this.Torso = root.getChild("Torso");
	}
	public ModelKitra(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Torso = root.getChild("Torso");

	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offset(0.0F, -22.0F, -19.0F));

		Head.addOrReplaceChild("skull_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -7.0F, -47.0F, 38.0F, 24.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, -1.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition Torso = partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(0, 72).addBox(-21.0F, -10.0F, -1.0F, 42.0F, 23.0F, 42.0F, new CubeDeformation(0.0F))
				.texOffs(0, 224).addBox(-2.0F, -15.0F, -1.0F, 4.0F, 8.0F, 41.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -26.0F, -17.0F));

		PartDefinition RightFin = Torso.addOrReplaceChild("RightFin", CubeListBuilder.create(), PartPose.offset(-24.0F, 8.0F, 17.0F));

		RightFin.addOrReplaceChild("rightfin_r1", CubeListBuilder.create().texOffs(0, 137).addBox(-6.0F, -5.0F, 1.0F, 8.0F, 34.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 4.0F, -9.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition LeftFin = Torso.addOrReplaceChild("LeftFin", CubeListBuilder.create(), PartPose.offset(24.0F, 8.0F, 17.0F));

		LeftFin.addOrReplaceChild("leftfin_r1", CubeListBuilder.create().texOffs(52, 137).addBox(-1.0F, -5.0F, 1.0F, 8.0F, 34.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 4.0F, -9.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition Hip = Torso.addOrReplaceChild("Hip", CubeListBuilder.create().texOffs(126, 72).addBox(-16.0F, 1.0F, -1.0F, 32.0F, 19.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(94, 248).addBox(-2.0F, -5.0F, 1.0F, 4.0F, 8.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.0F, 39.0F));

		PartDefinition TailBase = Hip.addOrReplaceChild("TailBase", CubeListBuilder.create().texOffs(104, 137).addBox(-13.0F, -2.0F, -1.5F, 26.0F, 18.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(221, 0).addBox(-2.0F, -9.0F, -0.5F, 4.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 16.5F));

		PartDefinition TailSegment1 = TailBase.addOrReplaceChild("TailSegment1", CubeListBuilder.create().texOffs(291, 0).addBox(-2.0F, -8.5F, -1.25F, 4.0F, 8.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(168, 107).addBox(-11.0F, -1.5F, -1.25F, 22.0F, 12.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 10.75F));

		PartDefinition TailSegment2 = TailSegment1.addOrReplaceChild("TailSegment2", CubeListBuilder.create().texOffs(168, 107).addBox(-11.0F, -1.5F, -0.5F, 22.0F, 12.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(415, 0).addBox(-2.0F, -8.5F, -0.5F, 4.0F, 8.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 10.25F));

		PartDefinition TailSegment3 = TailSegment2.addOrReplaceChild("TailSegment3", CubeListBuilder.create().texOffs(168, 107).addBox(-11.0F, -1.5F, 0.0F, 22.0F, 12.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(415, 0).addBox(-2.0F, -8.5F, 1.0F, 4.0F, 8.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 10.5F));

		TailSegment3.addOrReplaceChild("TailTip", CubeListBuilder.create().texOffs(0, 360).addBox(0.0F, -4.5F, 0.5F, 0.0F, 13.0F, 31.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 11.5F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void setupAnim(EntityKitra entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
//		this.flipperR.zRot = (float) (-Math.sin((10 * ageInTicks / (180f / Math.PI))) * 0.3f);
//		this.flipperL.zRot = (float) (Math.sin((10 * ageInTicks / (180f / Math.PI))) * 0.3f);
//		this.tail.xRot = (float) (Math.cos(limbSwing * 0.6662F) * limbSwingAmount / 4);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}