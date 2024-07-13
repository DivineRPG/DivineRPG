package divinerpg.client.models.arcana;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelLeorna<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("leorna");
	private final ModelPart head, body, rightarm, leftarm, rightleg, leftleg, a, Bar1, Bar2, Bar3, Bar4, Box;

	public ModelLeorna(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.rightarm = root.getChild("rightarm");
		this.leftarm = root.getChild("leftarm");
		this.rightleg = root.getChild("rightleg");
		this.leftleg = root.getChild("leftleg");
		this.a = root.getChild("a");
		this.Bar1 = root.getChild("Bar1");
		this.Bar2 = root.getChild("Bar2");
		this.Bar3 = root.getChild("Bar3");
		this.Bar4 = root.getChild("Bar4");
		this.Box = root.getChild("Box");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(0.0F, 0.0F, -2.0F));

		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 13).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(40, 13).mirror().addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-5.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(40, 13).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(0, 13).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-2.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(0, 13).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(2.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("a", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Bar1", CubeListBuilder.create().texOffs(0, 29).mirror().addBox(0.0F, 0.0F, 0.0F, 24.0F, 2.0F, 1.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-12.0F, 9.0F, 3.0F));

		partdefinition.addOrReplaceChild("Bar2", CubeListBuilder.create().texOffs(0, 29).mirror().addBox(0.0F, 0.0F, 0.0F, 24.0F, 2.0F, 1.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-12.0F, 0.0F, 3.0F));

		partdefinition.addOrReplaceChild("Bar3", CubeListBuilder.create().texOffs(0, 29).mirror().addBox(0.0F, 0.0F, 0.0F, 24.0F, 2.0F, 1.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-12.0F, 3.0F, 3.0F));

		partdefinition.addOrReplaceChild("Bar4", CubeListBuilder.create().texOffs(0, 29).mirror().addBox(0.0F, 0.0F, 0.0F, 24.0F, 2.0F, 1.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-12.0F, 6.0F, 3.0F));

		partdefinition.addOrReplaceChild("Box", CubeListBuilder.create().texOffs(33, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 12.0F, 3.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-2.0F, -1.0F, 2.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float)Math.PI);
		this.head.xRot = headPitch / (180F / (float)Math.PI);
		this.rightarm.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 2.0F * limbSwingAmount * 0.5F);
        this.leftarm.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F);
        this.rightleg.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        this.leftleg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		a.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Bar1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Bar2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Bar3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Bar4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Box.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}