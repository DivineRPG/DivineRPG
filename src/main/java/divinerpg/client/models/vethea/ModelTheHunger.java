package divinerpg.client.models.vethea;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelTheHunger<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("the_hunger");
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart rightarmm;
	private final ModelPart leftarmb;
	private final ModelPart rightleg;
	private final ModelPart leftleg;
	private final ModelPart leftarmt;
	private final ModelPart leftarmm;
	private final ModelPart rightarmt;
	private final ModelPart rightarmb;
	private final ModelPart Shape1;
	private final ModelPart Shape2;
	private final ModelPart Shape3;
	private final ModelPart Shape4;
	private final ModelPart Shape5;
	private final ModelPart Shape7;
	private final ModelPart Shape6;
	private final ModelPart Shape8;
	private final ModelPart Shape9;
	private final ModelPart Shape10;
	private final ModelPart Shape11;
	private final ModelPart Shape12;
	private final ModelPart Shape13;
	private final ModelPart Shape14;
	private final ModelPart Shape15;
	private final ModelPart Shape16;
	private final ModelPart Shape17;

	public ModelTheHunger(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.rightarmm = root.getChild("rightarmm");
		this.leftarmb = root.getChild("leftarmb");
		this.rightleg = root.getChild("rightleg");
		this.leftleg = root.getChild("leftleg");
		this.leftarmt = root.getChild("leftarmt");
		this.leftarmm = root.getChild("leftarmm");
		this.rightarmt = root.getChild("rightarmt");
		this.rightarmb = root.getChild("rightarmb");
		this.Shape1 = root.getChild("Shape1");
		this.Shape2 = root.getChild("Shape2");
		this.Shape3 = root.getChild("Shape3");
		this.Shape4 = root.getChild("Shape4");
		this.Shape5 = root.getChild("Shape5");
		this.Shape7 = root.getChild("Shape7");
		this.Shape6 = root.getChild("Shape6");
		this.Shape8 = root.getChild("Shape8");
		this.Shape9 = root.getChild("Shape9");
		this.Shape10 = root.getChild("Shape10");
		this.Shape11 = root.getChild("Shape11");
		this.Shape12 = root.getChild("Shape12");
		this.Shape13 = root.getChild("Shape13");
		this.Shape14 = root.getChild("Shape14");
		this.Shape15 = root.getChild("Shape15");
		this.Shape16 = root.getChild("Shape16");
		this.Shape17 = root.getChild("Shape17");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarmm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 7.0F, 0.5F, 0.1745F, 0.0F, 1.5708F));

		partdefinition.addOrReplaceChild("leftarmb", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 9.0F, 0.5F, 0.1745F, 0.0F, -0.925F));

		partdefinition.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarmt", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0F, 3.0F, 0.5F, 0.1745F, 0.0F, -2.042F));

		partdefinition.addOrReplaceChild("leftarmm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0F, 7.0F, 0.5F, 0.1745F, 0.0F, -1.5708F));

		partdefinition.addOrReplaceChild("rightarmt", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 3.0F, 0.5F, 0.1745F, 0.0F, 2.042F));

		partdefinition.addOrReplaceChild("rightarmb", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 9.0F, 0.5F, 0.1745F, 0.0F, 0.925F));

		partdefinition.addOrReplaceChild("Shape1", CubeListBuilder.create().texOffs(0, 32).mirror().addBox(0.0F, 0.0F, -9.0F, 8.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 2.0F, -1.0F));

		partdefinition.addOrReplaceChild("Shape2", CubeListBuilder.create().texOffs(0, 32).mirror().addBox(0.0F, 0.0F, -7.0F, 6.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 1.0F, -2.0F));

		partdefinition.addOrReplaceChild("Shape3", CubeListBuilder.create().texOffs(0, 32).addBox(0.0F, 0.0F, -9.0F, 8.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 8.0F, -1.0F));

		partdefinition.addOrReplaceChild("Shape4", CubeListBuilder.create().texOffs(0, 32).addBox(0.0F, 0.0F, -7.0F, 6.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 10.0F, -2.0F));

		partdefinition.addOrReplaceChild("Shape5", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 3.4F, -9.0F));

		partdefinition.addOrReplaceChild("Shape7", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.5F, 3.4F, -9.0F));

		partdefinition.addOrReplaceChild("Shape6", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 3.4F, -9.0F));

		partdefinition.addOrReplaceChild("Shape8", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 3.4F, -7.0F));

		partdefinition.addOrReplaceChild("Shape9", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 3.4F, -5.0F));

		partdefinition.addOrReplaceChild("Shape10", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 3.4F, -7.0F));

		partdefinition.addOrReplaceChild("Shape11", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 3.4F, -5.0F));

		partdefinition.addOrReplaceChild("Shape12", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.7F, 7.4F, -9.0F));

		partdefinition.addOrReplaceChild("Shape13", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 7.4F, -6.0F));

		partdefinition.addOrReplaceChild("Shape14", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 7.4F, -6.0F));

		partdefinition.addOrReplaceChild("Shape15", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.7F, 7.4F, -9.0F));

		partdefinition.addOrReplaceChild("Shape16", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 7.4F, -8.0F));

		partdefinition.addOrReplaceChild("Shape17", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 7.4F, -8.0F));

		return LayerDefinition.create(meshdefinition, 56, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarmm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarmb.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarmt.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarmm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarmt.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarmb.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape9.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape10.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape11.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape12.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape13.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape14.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape15.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape16.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape17.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}