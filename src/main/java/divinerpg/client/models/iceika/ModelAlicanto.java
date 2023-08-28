package divinerpg.client.models.iceika;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.iceika.EntityAlicanto;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelAlicanto<T extends EntityAlicanto> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("alicanto");
	private final ModelPart Head;
	private final ModelPart Jaw;
	private final ModelPart Body;
	private final ModelPart RightWing;
	private final ModelPart LeftWing;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;

	public ModelAlicanto(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Head = root.getChild("Head");
		this.Jaw = this.Head.getChild("Jaw");
		this.Body = root.getChild("Body");
		this.RightWing = root.getChild("RightWing");
		this.LeftWing = root.getChild("LeftWing");
		this.RightLeg = root.getChild("RightLeg");
		this.LeftLeg = root.getChild("LeftLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(17, 48).addBox(3.0F, 0.0F, -11.0F, 2.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(46, 20).addBox(-5.0F, 0.0F, -11.0F, 2.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(27, 21).addBox(-2.0F, -6.0F, -14.0F, 4.0F, 7.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(0, 60).addBox(3.0F, -7.0F, -2.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 60).addBox(-5.0F, -7.0F, -2.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 41).addBox(-3.0F, -5.0F, -6.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, -4.0F));

		Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(28, 48).addBox(-2.0F, 0.5F, -5.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, -7.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(40, 12).addBox(-2.0F, 1.0F, 10.0F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, -4.0F));

		Body.addOrReplaceChild("tuff_r1", CubeListBuilder.create().texOffs(50, 39).addBox(-4.0F, -7.0F, 1.0F, 8.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, -1.0F, -0.7854F, 0.0F, 0.0F));

		Body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -7.0F, -9.0F, 8.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 7.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition RightWing = partdefinition.addOrReplaceChild("RightWing", CubeListBuilder.create().texOffs(0, 20).addBox(-9.0F, -1.0F, -4.0F, 9.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 0.0F, 0.0F));

		RightWing.addOrReplaceChild("RightWingTip", CubeListBuilder.create().texOffs(0, 32).addBox(-9.5F, -1.0F, -3.5F, 9.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.5F, 0.0F, -0.5F));

		PartDefinition LeftWing = partdefinition.addOrReplaceChild("LeftWing", CubeListBuilder.create().texOffs(28, 0).addBox(0.0F, -1.0F, -4.0F, 9.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 0.0F, 0.0F));

		LeftWing.addOrReplaceChild("LeftWingTip", CubeListBuilder.create().texOffs(25, 39).addBox(0.5F, -1.0F, -3.5F, 9.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(8.5F, 0.0F, -0.5F));

		partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(48, 48).addBox(-2.0F, 0.0F, -3.0F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 17.0F, 2.0F));

		partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -3.0F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 17.0F, 2.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Head.xRot = headPitch * ((float)Math.PI / 180F);
		this.Head.yRot = netHeadYaw * ((float)Math.PI / 180F);

		if (!entity.onGround()) {
			this.RightWing.y = 10.0F;
			this.RightWing.z = 0.0F;
			this.LeftWing.y = this.RightWing.y;
			this.LeftWing.z = this.RightWing.z;
			this.RightWing.yRot = 0;
			this.LeftWing.yRot = 0;
			this.RightWing.zRot = Mth.cos(ageInTicks * 25F * ((float)Math.PI / 180F)) * (float)Math.PI * 0.25F;
			this.LeftWing.zRot = -this.RightWing.zRot;
			this.RightLeg.xRot = 0.3927F;
			this.LeftLeg.xRot = 0.3927F;
		} else {
			this.RightWing.y = 12.0F;
			this.RightWing.z = -3.0F;
			this.LeftWing.y = this.RightWing.y;
			this.LeftWing.z = this.RightWing.z;
			this.RightWing.yRot = 1.5708F;
			this.LeftWing.yRot = -1.5708F;
			this.RightWing.zRot = -this.RightWing.yRot;
			this.LeftWing.zRot = -this.LeftWing.yRot;
			this.RightLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
			this.LeftLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
		}
	}

	@Override
	public void prepareMobModel(T p_103621_, float p_103622_, float p_103623_, float p_103624_) {
		super.prepareMobModel(p_103621_, p_103622_, p_103623_, p_103624_);
		int l = p_103621_.getAttackTick();
		if (l > 0) {
			if (l > 5) {
				this.Jaw.xRot = Mth.sin(((float) (-4 + l) - p_103624_) / 4.0F) * (float) Math.PI * 0.4F;
			} else {
				this.Jaw.xRot = 0.15707964F * Mth.sin((float) Math.PI * ((float) l - p_103624_) / 10.0F);
			}
		} else this.Jaw.xRot = 0F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}