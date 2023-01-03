package divinerpg.client.models.boss;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.boss.EntityParasecta;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelParasecta extends EntityModel<EntityParasecta> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("parasecta");
	private final ModelPart foot6;
	private final ModelPart wing2;
	private final ModelPart wing1;
	private final ModelPart body;
	private final ModelPart leg6;
	private final ModelPart foot4;
	private final ModelPart leg4;
	private final ModelPart foot5;
	private final ModelPart leg5;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart foot1;
	private final ModelPart foot2;
	private final ModelPart foot3;
	private final ModelPart head;

	public ModelParasecta(ModelPart root) {
		this.foot6 = root.getChild("foot6");
		this.wing2 = root.getChild("wing2");
		this.wing1 = root.getChild("wing1");
		this.body = root.getChild("body");
		this.leg6 = root.getChild("leg6");
		this.foot4 = root.getChild("foot4");
		this.leg4 = root.getChild("leg4");
		this.foot5 = root.getChild("foot5");
		this.leg5 = root.getChild("leg5");
		this.leg1 = root.getChild("leg1");
		this.leg2 = root.getChild("leg2");
		this.leg3 = root.getChild("leg3");
		this.foot1 = root.getChild("foot1");
		this.foot2 = root.getChild("foot2");
		this.foot3 = root.getChild("foot3");
		this.head = root.getChild("head");
	}
	public ModelParasecta(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.foot6 = root.getChild("foot6");
		this.wing2 = root.getChild("wing2");
		this.wing1 = root.getChild("wing1");
		this.body = root.getChild("body");
		this.leg6 = root.getChild("leg6");
		this.foot4 = root.getChild("foot4");
		this.leg4 = root.getChild("leg4");
		this.foot5 = root.getChild("foot5");
		this.leg5 = root.getChild("leg5");
		this.leg1 = root.getChild("leg1");
		this.leg2 = root.getChild("leg2");
		this.leg3 = root.getChild("leg3");
		this.foot1 = root.getChild("foot1");
		this.foot2 = root.getChild("foot2");
		this.foot3 = root.getChild("foot3");
		this.head = root.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("foot6", CubeListBuilder.create().texOffs(15, 17).mirror().addBox(-5.0F, -1.0F, -7.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 13.0F, 11.0F, 0.0F, 0.0F, -0.4363F));

		partdefinition.addOrReplaceChild("wing2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-14.0F, 0.0F, -5.0F, 14.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.0F, 0.0F, 0.0F, -0.733F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("wing1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, -5.0F, 14.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(10.0F, 0.0F, 0.0F, -0.733F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(78, 0).mirror().addBox(-6.0F, -10.0F, -7.0F, 20.0F, 22.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, -3.0F, 2.0F, 0.8644F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("leg6", CubeListBuilder.create().texOffs(0, 14).mirror().addBox(-6.0F, -10.0F, -7.0F, 4.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 15.0F, 10.0F));

		partdefinition.addOrReplaceChild("foot4", CubeListBuilder.create().texOffs(15, 17).mirror().addBox(-5.0F, -1.0F, -7.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 6.0F, 1.0F, 0.0F, 0.0F, -0.4363F));

		partdefinition.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(0, 14).mirror().addBox(-6.0F, -10.0F, -7.0F, 4.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 8.0F, 0.0F));

		partdefinition.addOrReplaceChild("foot5", CubeListBuilder.create().texOffs(15, 17).mirror().addBox(-5.0F, -1.0F, -7.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 10.0F, 6.0F, 0.0F, 0.0F, -0.4363F));

		partdefinition.addOrReplaceChild("leg5", CubeListBuilder.create().texOffs(0, 14).mirror().addBox(-6.0F, -10.0F, -7.0F, 4.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 12.0F, 5.0F));

		partdefinition.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(0, 14).mirror().addBox(-6.0F, -10.0F, -7.0F, 4.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(11.0F, 8.0F, 0.0F));

		partdefinition.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(0, 14).mirror().addBox(-6.0F, -10.0F, -7.0F, 4.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(11.0F, 12.0F, 5.0F));

		partdefinition.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(0, 14).mirror().addBox(-6.0F, -10.0F, -7.0F, 4.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(11.0F, 15.0F, 10.0F));

		partdefinition.addOrReplaceChild("foot1", CubeListBuilder.create().texOffs(15, 17).mirror().addBox(-5.0F, -1.0F, -7.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, 9.0F, 1.0F, 0.0F, 0.0F, 0.4363F));

		partdefinition.addOrReplaceChild("foot2", CubeListBuilder.create().texOffs(15, 17).mirror().addBox(-5.0F, -1.0F, -7.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, 13.0F, 6.0F, 0.0F, 0.0F, 0.4363F));

		partdefinition.addOrReplaceChild("foot3", CubeListBuilder.create().texOffs(15, 17).mirror().addBox(-5.0F, -1.0F, -7.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, 16.0F, 11.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(48, 0).mirror().addBox(-4.0F, -4.0F, -5.0F, 8.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -3.0F, -8.0F));

		head.addOrReplaceChild("tusk1_r1", CubeListBuilder.create().texOffs(47, 16).mirror().addBox(-1.0F, -0.4667F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 4.0F, -4.0F, 0.0F, 0.0F, 0.2618F));

		head.addOrReplaceChild("tusk2_r1", CubeListBuilder.create().texOffs(47, 16).mirror().addBox(0.0F, -0.4667F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 4.0F, -4.0F, 0.0F, 0.0F, -0.2618F));

		return LayerDefinition.create(meshdefinition, 128, 32);
	}

	@Override
	public void setupAnim(EntityParasecta entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.wing1.yRot = (float) (Math.cos(ageInTicks * 1.3F) * Math.PI * 0.25F);
        this.wing2.yRot = -this.wing1.yRot;
        this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
        this.head.xRot = headPitch / (180F / (float) Math.PI);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		foot6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		wing2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		wing1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		foot4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		foot5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		foot1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		foot2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		foot3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}