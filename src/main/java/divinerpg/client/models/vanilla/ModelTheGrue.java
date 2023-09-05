package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.vanilla.overworld.EntityTheGrue;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelTheGrue extends EntityModel<EntityTheGrue> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("the_grue");
	private final ModelPart Head, LeftJaw, RightJaw, Body, Tail, RightLeg, LeftLeg;

	public ModelTheGrue(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Head = root.getChild("Head");
		this.LeftJaw = this.Head.getChild("LeftJaw");
		this.RightJaw = this.Head.getChild("RightJaw");
		this.Body = root.getChild("Body");
		this.Tail = root.getChild("Tail");
		this.RightLeg = root.getChild("RightLeg");
		this.LeftLeg = root.getChild("LeftLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(32, 29).addBox(-4.0F, -7.0F, -16.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 29).addBox(-4.0F, -7.0F, -8.0F, 8.0F, 11.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, -3.0F));

		Head.addOrReplaceChild("LeftJaw", CubeListBuilder.create().texOffs(56, 17).addBox(0.0F, -0.5F, -8.0F, 4.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, -8.0F));

		Head.addOrReplaceChild("RightJaw", CubeListBuilder.create().texOffs(62, 35).addBox(-4.0F, -0.5F, -8.0F, 4.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, -8.0F));

		partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -3.0F, 0.0F, 10.0F, 14.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -3.0F));

		PartDefinition Tail = partdefinition.addOrReplaceChild("Tail", CubeListBuilder.create(), PartPose.offset(0.0F, 3.0F, 12.0F));

		PartDefinition UpperTail = Tail.addOrReplaceChild("UpperTail", CubeListBuilder.create().texOffs(64, 63).addBox(-3.0F, -4.0F, 0.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.ZERO);

		PartDefinition MiddleTail = UpperTail.addOrReplaceChild("MiddleTail", CubeListBuilder.create().texOffs(40, 63).addBox(-3.0F, -4.0F, 0.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 6.0F));

		MiddleTail.addOrReplaceChild("LowerTail", CubeListBuilder.create().texOffs(16, 63).addBox(-3.0F, -4.0F, 0.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 6.0F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(47, 43).addBox(5.0F, -6.0F, -5.0F, 3.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, 7.0F));

		LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(0, 48).addBox(-3.5F, 0.0F, -3.0F, 5.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 5.0F, -2.0F));

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(23, 43).addBox(-5.0F, -6.0F, -5.0F, 3.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 8.0F, 7.0F));

		RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(50, 0).addBox(-1.5F, 0.0F, -3.0F, 5.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 5.0F, -2.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(EntityTheGrue entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Head.yRot = netHeadYaw / (180F / (float)Math.PI);
		this.Head.xRot = headPitch / (180F / (float)Math.PI);
		this.LeftJaw.yRot = -this.LeftJaw.xRot;

		this.Tail.yRot = (float) Math.cos(limbSwing * 0.6662F) * 0.4F * limbSwingAmount;
		this.Tail.xRot = (float) Math.cos(limbSwing * 0.6662F) * 0.1F * limbSwingAmount;
		this.RightLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
		this.LeftLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
	}

	@Override
	public void prepareMobModel(EntityTheGrue p_103621_, float p_103622_, float p_103623_, float p_103624_) {
		super.prepareMobModel(p_103621_, p_103622_, p_103623_, p_103624_);
		float jawMov = (float) Math.sqrt(Math.atan(200F * p_103622_) / 3F) * p_103623_;
		int l = p_103621_.getAttackTick();
		if (l > 0) {
			if (l > 5) {
				float f = Mth.sin(((float) (-4 + l) - p_103624_) / 4.0F) * (float) Math.PI * 0.4F;
				this.LeftJaw.xRot = this.RightJaw.xRot = this.RightJaw.yRot = f + 0.1309F;
			} else {
				this.LeftJaw.xRot = this.RightJaw.xRot = this.RightJaw.yRot = 0.15707964F * Mth.sin((float) Math.PI * ((float) l - p_103624_) / 10.0F);
			}
		} else this.LeftJaw.xRot = this.RightJaw.xRot = this.RightJaw.yRot = jawMov + 0.1309F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}