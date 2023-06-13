package divinerpg.client.models.twilight;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.wildwood.EntityMoonWolf;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelMoonWolf extends EntityModel<EntityMoonWolf> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("moon_wolf");
	private final ModelPart Body;

	public ModelMoonWolf(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Body = root.getChild("Body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 15.0F, 0.0F));

		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, -5.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition RightEar_r1 = Head.addOrReplaceChild("RightEar_r1", CubeListBuilder.create().texOffs(0, 18).addBox(-2.0F, -5.0F, -1.5F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -3.0F, -1.5F, 0.1745F, 0.5236F, 0.0F));

		PartDefinition LeftEar_r1 = Head.addOrReplaceChild("LeftEar_r1", CubeListBuilder.create().texOffs(13, 18).addBox(0.0F, -5.0F, -1.5F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -3.0F, -1.5F, 0.1745F, -0.5236F, 0.0F));

		PartDefinition HeadBase_r1 = Head.addOrReplaceChild("HeadBase_r1", CubeListBuilder.create().texOffs(0, 18).addBox(-1.5F, -3.0F, -3.5F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -4.5F, 0.3491F, 0.0F, 0.0F));

		PartDefinition Hair_r1 = Head.addOrReplaceChild("Hair_r1", CubeListBuilder.create().texOffs(0, 31).addBox(-2.0F, -20.5F, -1.0F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 14.0F, 5.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition BodyBase = Body.addOrReplaceChild("BodyBase", CubeListBuilder.create().texOffs(0, 44).addBox(-3.0F, -6.0F, -6.2F, 6.0F, 6.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-3.0F, -6.0F, -6.0F, 6.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Legs = Body.addOrReplaceChild("Legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition BackLeftLeg = Legs.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(20, 18).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, 5.0F));

		PartDefinition FrontRightLeg = Legs.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, -5.0F));

		PartDefinition FrontLeftLeg = Legs.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(26, 27).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, -5.0F));

		PartDefinition BackRightLeg = Legs.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, 5.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create(), PartPose.offset(0.0F, -5.0F, 6.0F));

		PartDefinition LeftTail = Tail.addOrReplaceChild("LeftTail", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, 2.0F));

		PartDefinition LeftTail_r1 = LeftTail.addOrReplaceChild("LeftTail_r1", CubeListBuilder.create().texOffs(48, -8).addBox(1.0F, -7.0F, -1.0F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.384F, 0.2007F, 0.1658F));

		PartDefinition RightTail = Tail.addOrReplaceChild("RightTail", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, 2.0F));

		PartDefinition RightTail_r1 = RightTail.addOrReplaceChild("RightTail_r1", CubeListBuilder.create().texOffs(48, 2).addBox(-1.0F, -7.0F, -1.0F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.384F, -0.2007F, -0.1658F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void prepareMobModel(EntityMoonWolf entity, float limbSwing, float limbSwingAmount, float p_102617_) {
//		if (entity.isInSittingPose()) {
//			this.Mane.setPos(-1.0F, 16.0F, -3.0F);
//			this.Mane.xRot = ((float) Math.PI * 2F / 5F);
//			this.Mane.yRot = 0.0F;
//			this.Body.setPos(0.0F, 18.0F, 0.0F);
//			this.Body.xRot = ((float) Math.PI / 4F);
//			this.Leg1.setPos(-2.5F, 22.0F, 2.0F);
//			this.Leg1.xRot = ((float) Math.PI * 3F / 2F);
//			this.Leg2.setPos(0.5F, 22.0F, 2.0F);
//			this.Leg2.xRot = ((float) Math.PI * 3F / 2F);
//			this.Leg3.xRot = 5.811947F;
//			this.Leg3.setPos(-2.49F, 17.0F, -4.0F);
//			this.Leg4.xRot = 5.811947F;
//			this.Leg4.setPos(0.51F, 17.0F, -4.0F);
//		} else {
//			this.Body.setPos(0.0F, 14.0F, 2.0F);
//			this.Body.xRot = ((float) Math.PI / 2F);
//			this.Mane.setPos(-1.0F, 14.0F, -3.0F);
//			this.Mane.xRot = this.Body.xRot;
//			this.Leg1.setPos(-2.5F, 16.0F, 7.0F);
//			this.Leg2.setPos(0.5F, 16.0F, 7.0F);
//			this.Leg3.setPos(-2.5F, 16.0F, -4.0F);
//			this.Leg4.setPos(0.5F, 16.0F, -4.0F);
//			this.Leg1.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
//			this.Leg2.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
//			this.Leg3.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
//			this.Leg4.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
//		}
	}

	@Override
	public void setupAnim(EntityMoonWolf entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
//		this.WolfHead.xRot = headPitch / (180F / (float) Math.PI);
//		this.WolfHead.yRot = netHeadYaw / (180F / (float) Math.PI);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}