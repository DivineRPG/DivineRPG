package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.vanilla.overworld.EntityPumpkinSpider;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelPumpkinSpider extends EntityModel<EntityPumpkinSpider> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("pumpkin_spider");
	private final ModelPart Head, Body, RearEnd, Leg8, Leg6, Leg4, Leg2, Leg7, Leg5, Leg3, Leg1;

	public ModelPumpkinSpider(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Head = root.getChild("Head");
		this.Body = root.getChild("Body");
		this.RearEnd = root.getChild("RearEnd");
		this.Leg8 = root.getChild("Leg8");
		this.Leg6 = root.getChild("Leg6");
		this.Leg4 = root.getChild("Leg4");
		this.Leg2 = root.getChild("Leg2");
		this.Leg7 = root.getChild("Leg7");
		this.Leg5 = root.getChild("Leg5");
		this.Leg3 = root.getChild("Leg3");
		this.Leg1 = root.getChild("Leg1");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(32, 4).mirror().addBox(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 20.0F, -3.0F));

		partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 20.0F, 0.0F));

		partdefinition.addOrReplaceChild("RearEnd", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(-5.0F, -4.0F, -6.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 12.0F, 8.0F));

		partdefinition.addOrReplaceChild("Leg8", CubeListBuilder.create().texOffs(18, 0).mirror().addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 20.0F, -1.0F, 0.0F, 0.576F, 0.192F));

		partdefinition.addOrReplaceChild("Leg6", CubeListBuilder.create().texOffs(18, 0).mirror().addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 20.0F, 0.0F, 0.0F, 0.2793F, 0.192F));

		partdefinition.addOrReplaceChild("Leg4", CubeListBuilder.create().texOffs(18, 0).mirror().addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 20.0F, 1.0F, 0.0F, -0.2793F, 0.192F));

		partdefinition.addOrReplaceChild("Leg2", CubeListBuilder.create().texOffs(18, 0).mirror().addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 20.0F, 2.0F, 0.0F, -0.576F, 0.192F));

		partdefinition.addOrReplaceChild("Leg7", CubeListBuilder.create().texOffs(18, 0).mirror().addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 20.0F, -1.0F, 0.0F, -0.576F, -0.192F));

		partdefinition.addOrReplaceChild("Leg5", CubeListBuilder.create().texOffs(18, 0).mirror().addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 20.0F, 0.0F, 0.0F, -0.2793F, -0.192F));

		partdefinition.addOrReplaceChild("Leg3", CubeListBuilder.create().texOffs(18, 0).mirror().addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 20.0F, 1.0F, 0.0F, 0.2793F, -0.192F));

		partdefinition.addOrReplaceChild("Leg1", CubeListBuilder.create().texOffs(18, 0).mirror().addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 20.0F, 2.0F, 0.0F, 0.576F, -0.192F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	@Override
	public void prepareMobModel(EntityPumpkinSpider entityIn, float p_102615_, float p_102616_, float p_102617_) {
		this.Body.visible=  this.Head.visible= this.Leg1.visible= this.Leg1.visible=
        this.Leg2.visible= this.Leg3.visible= this.Leg4.visible= this.Leg5.visible=
        this.Leg6.visible= this.Leg7.visible= this.Leg8.visible=entityIn.getProvoked();
	}
	@Override
	public void setupAnim(EntityPumpkinSpider entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float var8 = ((float) Math.PI / 4F);
        this.Leg1.zRot = -var8;
        this.Leg2.zRot = var8;
        this.Leg3.zRot = -var8 * 0.74F;
        this.Leg4.zRot = var8 * 0.74F;
        this.Leg5.zRot = -var8 * 0.74F;
        this.Leg6.zRot = var8 * 0.74F;
        this.Leg7.zRot = -var8;
        this.Leg8.zRot = var8;
        float var9 = -0.0F;
        float var10 = 0.3926991F;
        this.Leg1.yRot = var10 * 2.0F + var9;
        this.Leg2.yRot = -var10 * 2.0F - var9;
        this.Leg3.yRot = var10 * 1.0F + var9;
        this.Leg4.yRot = -var10 * 1.0F - var9;
        this.Leg5.yRot = -var10 * 1.0F + var9;
        this.Leg6.yRot = var10 * 1.0F - var9;
        this.Leg7.yRot = -var10 * 2.0F + var9;
        this.Leg8.yRot = var10 * 2.0F - var9;
        float var11 = (float) (-(Math.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * limbSwingAmount);
        float var12 = (float) (-(Math.cos(limbSwing * 0.6662F * 2.0F + Math.PI) * 0.4F) * limbSwingAmount);
        float var13 = (float) (-(Math.cos(limbSwing * 0.6662F * 2.0F + (Math.PI / 2F)) * 0.4F) * limbSwingAmount);
        float var14 = (float) (-(Math.cos(limbSwing * 0.6662F * 2.0F + (Math.PI * 3F / 2F)) * 0.4F) * limbSwingAmount);
        float var15 = (float) (Math.abs(Math.sin(limbSwing * 0.6662F + 0.0F) * 0.4F) * limbSwingAmount);
        float var16 = (float) (Math.abs(Math.sin(limbSwing * 0.6662F + Math.PI) * 0.4F) * limbSwingAmount);
        float var17 = (float) (Math.abs(Math.sin(limbSwing * 0.6662F + (Math.PI / 2F)) * 0.4F) * limbSwingAmount);
        float var18 = (float) (Math.abs(Math.sin(limbSwing * 0.6662F + (Math.PI * 3F / 2F)) * 0.4F) * limbSwingAmount);
        this.Leg1.yRot += var11;
        this.Leg2.yRot += -var11;
        this.Leg3.yRot += var12;
        this.Leg4.yRot += -var12;
        this.Leg5.yRot += var13;
        this.Leg6.yRot += -var13;
        this.Leg7.yRot += var14;
        this.Leg8.yRot += -var14;
        this.Leg1.zRot += var15;
        this.Leg2.zRot += -var15;
        this.Leg3.zRot += var16;
        this.Leg4.zRot += -var16;
        this.Leg5.zRot += var17;
        this.Leg6.zRot += -var17;
        this.Leg7.zRot += var18;
        this.Leg8.zRot += -var18;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RearEnd.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}