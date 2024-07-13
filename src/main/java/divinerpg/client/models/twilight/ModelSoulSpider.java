package divinerpg.client.models.twilight;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;


public class ModelSoulSpider<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("soul_spider");
	private final ModelPart body;
	private final ModelPart leg1top;
	private final ModelPart leg1middle;
	private final ModelPart leg1bottom;
	private final ModelPart leg2top;
	private final ModelPart leg2middle;
	private final ModelPart leg2bottom;
	private final ModelPart leg3top;
	private final ModelPart leg4top;
	private final ModelPart leg3middle;
	private final ModelPart leg4middle;
	private final ModelPart leg3bottom;
	private final ModelPart leg4bottom;

	public ModelSoulSpider(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.body = root.getChild("body");
		this.leg1top = root.getChild("leg1top");
		this.leg1middle = root.getChild("leg1middle");
		this.leg1bottom = root.getChild("leg1bottom");
		this.leg2top = root.getChild("leg2top");
		this.leg2middle = root.getChild("leg2middle");
		this.leg2bottom = root.getChild("leg2bottom");
		this.leg3top = root.getChild("leg3top");
		this.leg4top = root.getChild("leg4top");
		this.leg3middle = root.getChild("leg3middle");
		this.leg4middle = root.getChild("leg4middle");
		this.leg3bottom = root.getChild("leg3bottom");
		this.leg4bottom = root.getChild("leg4bottom");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 5.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.5F, 17.0F, -3.0F));

		partdefinition.addOrReplaceChild("leg1top", CubeListBuilder.create().texOffs(0, 10).mirror().addBox(0.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 18.0F, -1.0F, 0.0F, 0.0F, 0.8727F));

		partdefinition.addOrReplaceChild("leg1middle", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-0.5F, 3.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 18.2F, -1.0F, 0.0F, 0.0F, 0.6109F));

		partdefinition.addOrReplaceChild("leg1bottom", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-1.5F, 4.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.75F, 18.3F, -1.0F, 0.0F, 0.0F, 0.3491F));

		partdefinition.addOrReplaceChild("leg2top", CubeListBuilder.create().texOffs(0, 10).mirror().addBox(0.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 18.0F, 2.0F, 0.0F, 0.0F, 0.8727F));

		partdefinition.addOrReplaceChild("leg2middle", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-0.5F, 3.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 18.2F, 2.0F, 0.0F, 0.0F, 0.6109F));

		partdefinition.addOrReplaceChild("leg2bottom", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-1.5F, 4.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.8F, 18.3F, 2.0F, 0.0F, 0.0F, 0.3491F));

		partdefinition.addOrReplaceChild("leg3top", CubeListBuilder.create().texOffs(0, 10).mirror().addBox(-2.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 18.0F, -1.0F, 0.0F, 0.0F, -0.8727F));

		partdefinition.addOrReplaceChild("leg4top", CubeListBuilder.create().texOffs(0, 10).mirror().addBox(-2.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 18.0F, 2.0F, 0.0F, 0.0F, -0.8727F));

		partdefinition.addOrReplaceChild("leg3middle", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-1.5F, 3.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.5F, 17.6F, -1.0F, 0.0F, 0.0F, -0.6109F));

		partdefinition.addOrReplaceChild("leg4middle", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-1.5F, 3.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.5F, 17.6F, 2.0F, 0.0F, 0.0F, -0.6109F));

		partdefinition.addOrReplaceChild("leg3bottom", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-0.5F, 4.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.8F, 18.0F, -1.0F, 0.0F, 0.0F, -0.3491F));

		partdefinition.addOrReplaceChild("leg4bottom", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-0.5F, 4.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.9F, 18.0F, 2.0F, 0.0F, 0.0F, -0.3491F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.leg1top.xRot = this.leg2top.xRot = this.leg1middle.xRot = this.leg2middle.xRot = this.leg1bottom.xRot = this.leg2bottom.xRot = (float) Math.sin(limbSwing/2)*limbSwingAmount*1.3f;
		this.leg3top.xRot = this.leg4top.xRot = this.leg3middle.xRot = this.leg4middle.xRot = this.leg3bottom.xRot = this.leg4bottom.xRot = (float) Math.cos(limbSwing/2)*limbSwingAmount*1.3f;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg1top.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg1middle.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg1bottom.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg2top.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg2middle.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg2bottom.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg3top.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg4top.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg3middle.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg4middle.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg3bottom.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg4bottom.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}