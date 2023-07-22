package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.vanilla.overworld.EntityDesertCrawler;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelDesertCrawler extends EntityModel<EntityDesertCrawler> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("desert_crawler");
	private final ModelPart spine, rightLeg, leftLeg, bb_main, rightArm, leftArm, skull;

	public ModelDesertCrawler(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.spine = root.getChild("spine");
		this.rightLeg = root.getChild("rightfullleg");
		this.leftLeg = root.getChild("leftfullleg");
		this.bb_main = root.getChild("bb_main");
		this.rightArm = root.getChild("rightfullarm");
		this.leftArm = root.getChild("leftfullarm");
		this.skull = root.getChild("skull");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition spine = partdefinition.addOrReplaceChild("spine", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -4.0F, -4.0F, 8.0F, 6.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.0F, -0.5F));

		PartDefinition skull = partdefinition.addOrReplaceChild("skull", CubeListBuilder.create().texOffs(0, 23).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(24, 18).addBox(-4.0F, -8.0F, -1.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(30, 18).addBox(-4.01F, -8.0F, -1.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(44, 46).addBox(4.0F, 1.0F, -6.0F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(42, 37).addBox(-5.0F, 1.0F, -6.0F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(24, 22).addBox(4.0F, -8.0F, -1.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(30, 22).addBox(4.01F, -8.0F, -1.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 6.0F, -8.0F));

		PartDefinition leftfullarm = partdefinition.addOrReplaceChild("leftfullarm", CubeListBuilder.create().texOffs(0, 39).addBox(0.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 16.0F, -5.5F));

		PartDefinition rightfullarm = partdefinition.addOrReplaceChild("rightfullarm", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 16.0F, -5.5F));

		PartDefinition rightfullleg = partdefinition.addOrReplaceChild("rightfullleg", CubeListBuilder.create().texOffs(24, 31).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(16, 43).addBox(-5.0F, 2.0F, 3.0F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 15.0F, 3.0F));

		PartDefinition leftfullleg = partdefinition.addOrReplaceChild("leftfullleg", CubeListBuilder.create().texOffs(33, 0).addBox(0.0F, -2.0F, -2.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(30, 43).addBox(1.0F, 2.0F, 3.0F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 15.0F, 3.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(40, 23).addBox(-4.0F, -14.0F, -11.0F, 8.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 2.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void prepareMobModel(EntityDesertCrawler entity, float limbSwing, float limbSwingAmount, float p_102617_) {
		super.prepareMobModel(entity, limbSwing, limbSwingAmount, p_102617_);
		if(!entity.hasSeen()){
			this.spine.setPos(-1.0F, 14.0F, -4.0F);
			this.spine.xRot = ((float)Math.PI * 1.785398F);
			this.rightLeg.setPos(-2.5F, 18.0F, 4.0F);
			this.rightLeg.xRot = ((float)Math.PI * 1.5F);
			this.leftLeg.setPos(2.5F, 18.0F, 4.0F);
			this.leftLeg.xRot = ((float)Math.PI * 1.5F);
			this.rightArm.xRot = 5.811947F;
			this.rightArm.setPos(-4.0F, 14.0F, -4.0F);
			this.leftArm.xRot = 5.811947F;
			this.leftArm.setPos(4.0F, 14.0F, -4.0F);
		} else {
			this.rightLeg.setPos(-2.5F, 15.0F, 5.0F);
			this.leftLeg.setPos(2.5F, 15.0F, 5.0F);
			this.rightArm.setPos(-4.0F, 14.0F, -4.0F);
			this.leftArm.setPos(4.0F, 14.0F, -4.0F);
			this.spine.setPos(-1.0F, 14.0F, -3.0F);
			this.spine.xRot = ((float)Math.PI / 0.125F);
			this.leftArm.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
			this.leftLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
			this.rightArm.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
			this.rightLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
		}
	}

	@Override
	public void setupAnim(EntityDesertCrawler entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.skull.yRot = netHeadYaw / (180F / (float)Math.PI);
		this.skull.xRot = headPitch / (180F / (float)Math.PI);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		spine.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		skull.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}