package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.monster.Monster;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelEnderScrounge extends EntityModel<Monster> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("ender_scrounge");
	private final ModelPart body, head, frontleft, frontright, backleft, backright, tail;

	public ModelEnderScrounge(ModelPart root) {
		this.body = root.getChild("body");
		this.tail = body.getChild("tail");
		this.head = root.getChild("head");
		this.frontleft = root.getChild("frontleft");
		this.frontright = root.getChild("frontright");
		this.backleft = root.getChild("backleft");
		this.backright = root.getChild("backright");
	}

	public ModelEnderScrounge(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.body = root.getChild("body");
		this.tail = body.getChild("tail");
		this.head = root.getChild("head");
		this.frontleft = root.getChild("frontleft");
		this.frontright = root.getChild("frontright");
		this.backleft = root.getChild("backleft");
		this.backright = root.getChild("backright");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -3.0F, -3.0F, 4.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, -1.0F));

		body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(22, -4).addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 4.0F));

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 10).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(22, 3).addBox(1.0F, -4.0F, -2.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(22, 3).addBox(-4.0F, -4.0F, -2.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(24, 12).addBox(-1.0F, -0.1F, -5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(12, 11).addBox(-0.5F, -0.3F, -5.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 21.0F, -4.0F));

		partdefinition.addOrReplaceChild("frontleft", CubeListBuilder.create().texOffs(12, 11).addBox(0.0F, 1.0F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(0.0F, -1.0F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 22.0F, -3.0F));

		partdefinition.addOrReplaceChild("frontright", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(12, 11).addBox(-1.0F, 1.0F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 22.0F, -3.0F));

		partdefinition.addOrReplaceChild("backleft", CubeListBuilder.create().texOffs(14, 10).addBox(0.0F, -1.0F, -2.0F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(12, 11).addBox(0.0F, 2.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 21.0F, 2.0F));

		partdefinition.addOrReplaceChild("backright", CubeListBuilder.create().texOffs(12, 11).addBox(-1.0F, 2.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(14, 10).addBox(-1.0F, -1.0F, -2.0F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 21.0F, 2.0F));

		return LayerDefinition.create(meshdefinition, 32, 16);
	}

	@Override
	public void setupAnim(Monster entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
        this.head.xRot = headPitch / (180F / (float) Math.PI);
		
		this.frontleft.xRot = this.backright.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        this.frontright.xRot = this.backleft.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
		
		this.tail.zRot = (float) (Math.cos(limbSwing * 0.6662F) * limbSwingAmount);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		frontleft.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		frontright.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		backleft.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		backright.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}