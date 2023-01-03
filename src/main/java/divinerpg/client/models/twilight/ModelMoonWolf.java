package divinerpg.client.models.twilight;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.wildwood.EntityMoonWolf;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelMoonWolf extends EntityModel<EntityMoonWolf> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("moon_wolf");
	private final ModelPart WolfHead, Body, Mane, Leg1, Leg2, Leg3, Leg4;

	public ModelMoonWolf(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.WolfHead = root.getChild("WolfHead");
		this.Body = root.getChild("Body");
		this.Mane = root.getChild("Mane");
		this.Leg1 = root.getChild("Leg1");
		this.Leg2 = root.getChild("Leg2");
		this.Leg3 = root.getChild("Leg3");
		this.Leg4 = root.getChild("Leg4");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("WolfHead", CubeListBuilder.create().texOffs(16, 14).mirror().addBox(1.0F, -5.0F, 0.0F, 2.0F, 2.0F, 1.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(4, 0).mirror().addBox(-4.0F, -2.5F, -5.0F, 1.0F, 1.0F, 4.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(4, 0).mirror().addBox(3.0F, -2.5F, -5.0F, 1.0F, 1.0F, 4.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(16, 14).mirror().addBox(-3.0F, -5.0F, 0.0F, 2.0F, 2.0F, 1.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(0, 10).mirror().addBox(-1.5F, -0.1F, -5.0F, 3.0F, 3.0F, 4.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(0, 0).mirror().addBox(-3.0F, -3.0F, -2.0F, 6.0F, 6.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-1.0F, 13.5F, -7.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(-4.0F, -3.0F, -2.9F, 6.0F, 9.0F, 6.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(0.0F, 14.0F, 2.0F, 1.5708F, 0.0F, 0.0F));

		Body.addOrReplaceChild("spike3_r1", CubeListBuilder.create().texOffs(37, 0).mirror().addBox(-2.0F, -5.5F, 0.0F, 2.0F, 6.0F, 1.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(2.0F, 2.0F, 0.5F, -0.7854F, 0.0F, 1.5708F));

		Body.addOrReplaceChild("spike4_r1", CubeListBuilder.create().texOffs(37, 0).mirror().addBox(-2.0F, -0.5F, 0.0F, 2.0F, 6.0F, 1.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-4.0F, 2.0F, 0.5F, 0.7854F, 0.0F, 1.5708F));

		PartDefinition Mane = partdefinition.addOrReplaceChild("Mane", CubeListBuilder.create().texOffs(21, 0).mirror().addBox(-4.0F, -3.0F, -3.0F, 8.0F, 6.0F, 7.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-1.0F, 14.0F, -3.0F, 1.5708F, 0.0F, 0.0F));

		Mane.addOrReplaceChild("Ear3_r1", CubeListBuilder.create().texOffs(16, 14).mirror().addBox(-4.0F, -3.0F, -12.0F, 2.0F, 2.0F, 1.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(16, 14).mirror().addBox(0.0F, -3.0F, -12.0F, 2.0F, 2.0F, 1.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(1.0F, 10.0F, 3.0F, -1.5708F, 0.0F, 0.0F));

		Mane.addOrReplaceChild("spike2_r1", CubeListBuilder.create().texOffs(37, 0).mirror().addBox(-5.0F, -2.0F, -4.0F, 2.0F, 6.0F, 1.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-4.0F, -4.0F, 6.0F, -0.7854F, 0.0F, -1.5708F));

		Mane.addOrReplaceChild("spike1_r1", CubeListBuilder.create().texOffs(37, 0).mirror().addBox(-5.0F, -4.0F, -4.0F, 2.0F, 6.0F, 1.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(4.0F, -4.0F, 6.0F, 0.7854F, 0.0F, -1.5708F));

		partdefinition.addOrReplaceChild("Leg1", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-1.0F, 0.0F, -1.1F, 2.0F, 8.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-2.5F, 16.0F, 7.0F));

		partdefinition.addOrReplaceChild("Leg2", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-1.0F, 0.0F, -1.1F, 2.0F, 8.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(0.5F, 16.0F, 7.0F));

		partdefinition.addOrReplaceChild("Leg3", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-2.5F, 16.0F, -4.0F));

		partdefinition.addOrReplaceChild("Leg4", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(0.5F, 16.0F, -4.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}
	@Override
	public void prepareMobModel(EntityMoonWolf entity, float limbSwing, float limbSwingAmount, float p_102617_) {
		if (entity.isInSittingPose()) {
            this.Mane.setPos(-1.0F, 16.0F, -3.0F);
            this.Mane.xRot = ((float) Math.PI * 2F / 5F);
            this.Mane.yRot = 0.0F;
            this.Body.setPos(0.0F, 18.0F, 0.0F);
            this.Body.xRot = ((float) Math.PI / 4F);
            this.Leg1.setPos(-2.5F, 22.0F, 2.0F);
            this.Leg1.xRot = ((float) Math.PI * 3F / 2F);
            this.Leg2.setPos(0.5F, 22.0F, 2.0F);
            this.Leg2.xRot = ((float) Math.PI * 3F / 2F);
            this.Leg3.xRot = 5.811947F;
            this.Leg3.setPos(-2.49F, 17.0F, -4.0F);
            this.Leg4.xRot = 5.811947F;
            this.Leg4.setPos(0.51F, 17.0F, -4.0F);
        } else {
            this.Body.setPos(0.0F, 14.0F, 2.0F);
            this.Body.xRot = ((float) Math.PI / 2F);
            this.Mane.setPos(-1.0F, 14.0F, -3.0F);
            this.Mane.xRot = this.Body.xRot;
            this.Leg1.setPos(-2.5F, 16.0F, 7.0F);
            this.Leg2.setPos(0.5F, 16.0F, 7.0F);
            this.Leg3.setPos(-2.5F, 16.0F, -4.0F);
            this.Leg4.setPos(0.5F, 16.0F, -4.0F);
            this.Leg1.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
            this.Leg2.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
            this.Leg3.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
            this.Leg4.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        }
	}
	@Override
	public void setupAnim(EntityMoonWolf entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.WolfHead.xRot = headPitch / (180F / (float) Math.PI);
        this.WolfHead.yRot = netHeadYaw / (180F / (float) Math.PI);
	}
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		WolfHead.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Mane.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}