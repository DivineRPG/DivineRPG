package divinerpg.client.models.arcana;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelDeathcryx<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("deathcryx");
	private final ModelPart WolfHead;
	private final ModelPart Body;
	private final ModelPart Mane;
	private final ModelPart Leg1;
	private final ModelPart Leg2;
	private final ModelPart Leg3;
	private final ModelPart Leg4;
	private final ModelPart Tail;
	private final ModelPart Ear1;
	private final ModelPart Ear2;
	private final ModelPart Nose;
	private final ModelPart Shape1;
	private final ModelPart Shape2;
	private final ModelPart Shape3;
	private final ModelPart Shape4;
	private final ModelPart Shape5;
	private final ModelPart Shape6;
	private final ModelPart Shape7;
	private final ModelPart Shape8;
	private final ModelPart Shape9;
	private final ModelPart Shape10;
	private final ModelPart Shape11;
	private final ModelPart Shape12;
	private final ModelPart Leg5;
	private final ModelPart Leg6;
	private final ModelPart Leg7;
	private final ModelPart Leg8;
	private final ModelPart Tail2;

	public ModelDeathcryx(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.WolfHead = root.getChild("WolfHead");
		this.Body = root.getChild("Body");
		this.Mane = root.getChild("Mane");
		this.Leg1 = root.getChild("Leg1");
		this.Leg2 = root.getChild("Leg2");
		this.Leg3 = root.getChild("Leg3");
		this.Leg4 = root.getChild("Leg4");
		this.Tail = root.getChild("Tail");
		this.Ear1 = root.getChild("Ear1");
		this.Ear2 = root.getChild("Ear2");
		this.Nose = root.getChild("Nose");
		this.Shape1 = root.getChild("Shape1");
		this.Shape2 = root.getChild("Shape2");
		this.Shape3 = root.getChild("Shape3");
		this.Shape4 = root.getChild("Shape4");
		this.Shape5 = root.getChild("Shape5");
		this.Shape6 = root.getChild("Shape6");
		this.Shape7 = root.getChild("Shape7");
		this.Shape8 = root.getChild("Shape8");
		this.Shape9 = root.getChild("Shape9");
		this.Shape10 = root.getChild("Shape10");
		this.Shape11 = root.getChild("Shape11");
		this.Shape12 = root.getChild("Shape12");
		this.Leg5 = root.getChild("Leg5");
		this.Leg6 = root.getChild("Leg6");
		this.Leg7 = root.getChild("Leg7");
		this.Leg8 = root.getChild("Leg8");
		this.Tail2 = root.getChild("Tail2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("WolfHead", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.0F, -3.0F, -2.0F, 10.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 11.5F, -7.0F));

		partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(-4.0F, -2.0F, -3.0F, 6.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 14.0F, 2.0F));

		partdefinition.addOrReplaceChild("Mane", CubeListBuilder.create().texOffs(21, 0).mirror().addBox(-4.0F, -3.0F, -3.0F, 8.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 14.0F, -2.0F));

		partdefinition.addOrReplaceChild("Leg1", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-1.0F, 0.0F, -1.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.5F, 16.0F, 4.0F));

		partdefinition.addOrReplaceChild("Leg2", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-1.0F, 0.0F, -1.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.5F, 16.0F, 4.0F));

		partdefinition.addOrReplaceChild("Leg3", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-1.0F, 0.0F, -1.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.5F, 16.0F, -7.0F));

		partdefinition.addOrReplaceChild("Leg4", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-1.0F, 0.0F, -1.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.5F, 16.0F, -7.0F));

		partdefinition.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(22, 13).mirror().addBox(-1.0F, 0.0F, -1.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 15.0F, 7.0F, 1.1301F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Ear1", CubeListBuilder.create().texOffs(16, 14).mirror().addBox(-3.0F, -5.0F, 0.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 9.9F, -7.0F, 0.3491F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Ear2", CubeListBuilder.create().texOffs(16, 14).mirror().addBox(1.0F, -5.0F, 0.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 9.9F, -7.0F, 0.3491F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Nose", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(-2.0F, 0.0F, -5.0F, 6.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 11.5F, -8.0F));

		partdefinition.addOrReplaceChild("Shape1", CubeListBuilder.create().texOffs(52, 15).mirror().addBox(-3.0F, -10.0F, 0.0F, 1.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 11.0F, 4.0F, -1.0038F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Shape2", CubeListBuilder.create().texOffs(52, 15).mirror().addBox(-2.0F, 0.0F, 0.0F, 1.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 0.0F, 7.0F, -0.632F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Shape3", CubeListBuilder.create().texOffs(52, 15).mirror().addBox(-2.0F, 0.0F, 0.0F, 1.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -2.0F, -5.4667F, 0.1115F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Shape4", CubeListBuilder.create().texOffs(52, 15).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.0F, -2.0F, -5.4667F, 0.1115F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Shape5", CubeListBuilder.create().texOffs(52, 15).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.0F, 0.0F, 7.0F, -0.632F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Shape6", CubeListBuilder.create().texOffs(52, 15).mirror().addBox(-1.0F, -10.0F, 0.0F, 2.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 11.0F, 4.0F, -1.0038F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Shape7", CubeListBuilder.create().texOffs(52, 15).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, -2.0F, -5.4667F, 0.1115F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Shape8", CubeListBuilder.create().texOffs(52, 15).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 0.0F, 7.0F, -0.632F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Shape9", CubeListBuilder.create().texOffs(52, 15).mirror().addBox(-1.0F, -10.0F, 0.0F, 2.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 11.0F, 4.0F, -1.0038F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Shape10", CubeListBuilder.create().texOffs(52, 15).mirror().addBox(1.0F, 0.0F, 0.0F, 1.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -2.0F, -5.4667F, 0.1115F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Shape11", CubeListBuilder.create().texOffs(52, 15).mirror().addBox(1.0F, 0.0F, 0.0F, 1.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 0.0F, 7.0F, -0.632F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Shape12", CubeListBuilder.create().texOffs(52, 15).mirror().addBox(0.0F, -10.0F, 0.0F, 1.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 11.0F, 4.0F, -1.0038F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Leg5", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-1.0F, 0.0F, -1.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.5F, 16.0F, -2.0F));

		partdefinition.addOrReplaceChild("Leg6", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-1.0F, 0.0F, -1.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.5F, 16.0F, 9.0F));

		partdefinition.addOrReplaceChild("Leg7", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-1.0F, 0.0F, -1.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.5F, 16.0F, 9.0F));

		partdefinition.addOrReplaceChild("Leg8", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-1.0F, 0.0F, -1.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.5F, 16.0F, -2.0F));

		partdefinition.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(22, 13).mirror().addBox(-1.0F, 0.0F, -1.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 15.0F, 7.0F, 1.1301F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Leg1.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.Leg2.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.Leg3.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.Leg4.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.Leg5.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.Leg6.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.Leg7.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.Leg8.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
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
		Tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Ear1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Ear2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Nose.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape9.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape10.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape11.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape12.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tail2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}