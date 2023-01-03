package divinerpg.client.models.twilight;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;


public class ModelSoulStealer<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("soul_stealer");
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart rightarm;
	private final ModelPart leftarm;
	private final ModelPart rightleg;
	private final ModelPart leftleg;
	private final ModelPart Shape1;
	private final ModelPart Shape3;
	private final ModelPart Shape2;
	private final ModelPart Shape4;
	private final ModelPart Shape5;
	private final ModelPart Shape6;
	private final ModelPart Shape7;
	private final ModelPart Shape8;
	private final ModelPart Shape9;
	private final ModelPart Shape10;
	private final ModelPart back;
	private final ModelPart back1;
	private final ModelPart back2;
	private final ModelPart back3;
	private final ModelPart back4;

	public ModelSoulStealer(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.rightarm = root.getChild("rightarm");
		this.leftarm = root.getChild("leftarm");
		this.rightleg = root.getChild("rightleg");
		this.leftleg = root.getChild("leftleg");
		this.Shape1 = root.getChild("Shape1");
		this.Shape3 = root.getChild("Shape3");
		this.Shape2 = root.getChild("Shape2");
		this.Shape4 = root.getChild("Shape4");
		this.Shape5 = root.getChild("Shape5");
		this.Shape6 = root.getChild("Shape6");
		this.Shape7 = root.getChild("Shape7");
		this.Shape8 = root.getChild("Shape8");
		this.Shape9 = root.getChild("Shape9");
		this.Shape10 = root.getChild("Shape10");
		this.back = root.getChild("back");
		this.back1 = root.getChild("back1");
		this.back2 = root.getChild("back2");
		this.back3 = root.getChild("back3");
		this.back4 = root.getChild("back4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("Shape1", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -8.0F, -9.0F));

		partdefinition.addOrReplaceChild("Shape3", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, -8.0F, -9.0F));

		partdefinition.addOrReplaceChild("Shape2", CubeListBuilder.create().texOffs(9, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, -6.0F, -4.0F));

		partdefinition.addOrReplaceChild("Shape4", CubeListBuilder.create().texOffs(9, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-8.0F, -6.0F, -4.0F));

		partdefinition.addOrReplaceChild("Shape5", CubeListBuilder.create().texOffs(9, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, -3.0F, -4.0F));

		partdefinition.addOrReplaceChild("Shape6", CubeListBuilder.create().texOffs(9, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-8.0F, -3.0F, -4.0F));

		partdefinition.addOrReplaceChild("Shape7", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(6.0F, -6.0F, -9.0F));

		partdefinition.addOrReplaceChild("Shape8", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(6.0F, -3.0F, -9.0F));

		partdefinition.addOrReplaceChild("Shape9", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-8.0F, -6.0F, -9.0F));

		partdefinition.addOrReplaceChild("Shape10", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-8.0F, -3.0F, -9.0F));

		partdefinition.addOrReplaceChild("back", CubeListBuilder.create().texOffs(4, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 0.0F, 2.0F));

		partdefinition.addOrReplaceChild("back1", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 0.0F, 5.0F));

		partdefinition.addOrReplaceChild("back2", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, 0.0F, 5.0F));

		partdefinition.addOrReplaceChild("back3", CubeListBuilder.create().texOffs(15, 25).mirror().addBox(0.0F, 0.0F, 0.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, 0.0F, 5.0F));

		partdefinition.addOrReplaceChild("back4", CubeListBuilder.create().texOffs(15, 25).mirror().addBox(0.0F, -1.0F, 0.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.0F, 0.0F, 5.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.rightarm.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.leftarm.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.rightarm.zRot = 0.0F;
		this.leftarm.zRot = 0.0F;
		this.rightleg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leftleg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.rightleg.yRot = 0.0F;
		this.leftleg.yRot = 0.0F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape9.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape10.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		back.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		back1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		back2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		back3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		back4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}