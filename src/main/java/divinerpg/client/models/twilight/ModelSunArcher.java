package divinerpg.client.models.twilight;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;


public class ModelSunArcher<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("sun_archer");
	private final ModelPart legRight;
	private final ModelPart legLeft;
	private final ModelPart body;
	private final ModelPart footRight;
	private final ModelPart footLeft;
	private final ModelPart spine1;
	private final ModelPart spine2;
	private final ModelPart spine3;
	private final ModelPart spine4;
	private final ModelPart spine5;
	private final ModelPart head;
	public final ModelPart armRight;
	private final ModelPart armBandRight;
	private final ModelPart armLeft;
	private final ModelPart armBandLeft;

	public ModelSunArcher(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.legRight = root.getChild("legRight");
		this.legLeft = root.getChild("legLeft");
		this.body = root.getChild("body");
		this.footRight = root.getChild("footRight");
		this.footLeft = root.getChild("footLeft");
		this.spine1 = root.getChild("spine1");
		this.spine2 = root.getChild("spine2");
		this.spine3 = root.getChild("spine3");
		this.spine4 = root.getChild("spine4");
		this.spine5 = root.getChild("spine5");
		this.head = root.getChild("head");
		this.armRight = root.getChild("armRight");
		this.armBandRight = root.getChild("armBandRight");
		this.armLeft = root.getChild("armLeft");
		this.armBandLeft = root.getChild("armBandLeft");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("legRight", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 11.0F, 1.0F));

		partdefinition.addOrReplaceChild("legLeft", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 11.0F, 1.0F));

		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 43).mirror().addBox(0.0F, 0.0F, 0.0F, 12.0F, 16.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.0F, -5.0F, -1.5F));

		partdefinition.addOrReplaceChild("footRight", CubeListBuilder.create().texOffs(0, 15).mirror().addBox(-1.5F, 12.0F, -2.5F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 11.0F, 1.0F));

		partdefinition.addOrReplaceChild("footLeft", CubeListBuilder.create().texOffs(0, 15).mirror().addBox(-1.5F, 12.0F, -2.5F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 11.0F, 1.0F));

		partdefinition.addOrReplaceChild("spine1", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(0.0F, -4.0F, 0.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 0.0F, 2.5F, -0.5236F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spine2", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(0.0F, -4.0F, 0.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 3.0F, 2.5F, -0.5236F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spine3", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(0.0F, -4.0F, 0.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 6.0F, 2.5F, -0.5236F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spine4", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(0.0F, -4.0F, 0.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 9.0F, 2.5F, -0.5236F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spine5", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(0.0F, -4.0F, 0.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, -3.0F, 2.5F, -0.5236F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 31).mirror().addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -5.0F, 0.0F));

		partdefinition.addOrReplaceChild("armRight", CubeListBuilder.create().texOffs(16, 0).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, -4.0F, 1.0F, -1.309F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("armBandRight", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-1.5F, 3.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, -4.0F, 1.0F, -1.309F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("armLeft", CubeListBuilder.create().texOffs(16, 0).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.5F, -4.0F, 1.0F, 0.0F, 0.0F, -0.0873F));

		partdefinition.addOrReplaceChild("armBandLeft", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-1.5F, 3.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.5F, -4.0F, 1.0F, 0.0F, 0.0F, -0.0873F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.legLeft.xRot = this.footLeft.xRot = Mth.cos(limbSwing)*limbSwingAmount;
		this.legRight.xRot = this.footRight.xRot = Mth.cos(limbSwing+(float)Math.PI)*limbSwingAmount;

		this.armRight.xRot = this.armBandRight.xRot = -1.308997f + Mth.cos(limbSwing)*limbSwingAmount*0.3f;
		this.armLeft.xRot = this.armBandLeft.xRot = Mth.cos(limbSwing)*limbSwingAmount;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		legRight.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		legLeft.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		footRight.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		footLeft.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		spine1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		spine2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		spine3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		spine4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		spine5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		armRight.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		armBandRight.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		armLeft.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		armBandLeft.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}