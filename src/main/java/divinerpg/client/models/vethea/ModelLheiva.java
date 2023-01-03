package divinerpg.client.models.vethea;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelLheiva<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("lheiva");
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
	private final ModelPart Shape13;
	private final ModelPart Shape14;
	private final ModelPart Shape15;
	private final ModelPart Shape16;
	private final ModelPart Shape17;
	private final ModelPart Shape18;
	private final ModelPart Shape19;
	private final ModelPart Shape20;
	private final ModelPart Shape21;
	private final ModelPart Shape22;
	private final ModelPart Shape23;
	private final ModelPart Shape24;

	public ModelLheiva(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
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
		this.Shape13 = root.getChild("Shape13");
		this.Shape14 = root.getChild("Shape14");
		this.Shape15 = root.getChild("Shape15");
		this.Shape16 = root.getChild("Shape16");
		this.Shape17 = root.getChild("Shape17");
		this.Shape18 = root.getChild("Shape18");
		this.Shape19 = root.getChild("Shape19");
		this.Shape20 = root.getChild("Shape20");
		this.Shape21 = root.getChild("Shape21");
		this.Shape22 = root.getChild("Shape22");
		this.Shape23 = root.getChild("Shape23");
		this.Shape24 = root.getChild("Shape24");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("Shape1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -1.0F, -4.0F));

		partdefinition.addOrReplaceChild("Shape2", CubeListBuilder.create().texOffs(35, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, 7.0F, -1.0F));

		partdefinition.addOrReplaceChild("Shape3", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 11.0F, -4.0F));

		partdefinition.addOrReplaceChild("Shape4", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-10.0F, 11.0F, -4.0F));

		partdefinition.addOrReplaceChild("Shape5", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-10.0F, -1.0F, -4.0F));

		partdefinition.addOrReplaceChild("Shape6", CubeListBuilder.create().texOffs(50, 0).addBox(0.0F, 0.0F, 0.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-14.0F, 16.0F, 1.0F));

		partdefinition.addOrReplaceChild("Shape7", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 14.0F, -1.0F));

		partdefinition.addOrReplaceChild("Shape8", CubeListBuilder.create().texOffs(35, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, 7.0F, -1.0F));

		partdefinition.addOrReplaceChild("Shape9", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 2.0F, -1.0F));

		partdefinition.addOrReplaceChild("Shape10", CubeListBuilder.create().texOffs(50, 0).addBox(0.0F, 0.0F, 0.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-14.0F, 12.0F, 1.0F));

		partdefinition.addOrReplaceChild("Shape11", CubeListBuilder.create().texOffs(50, 0).addBox(0.0F, 0.0F, 0.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-14.0F, 16.0F, -3.0F));

		partdefinition.addOrReplaceChild("Shape12", CubeListBuilder.create().texOffs(50, 0).addBox(0.0F, 0.0F, 0.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-14.0F, 12.0F, -3.0F));

		partdefinition.addOrReplaceChild("Shape13", CubeListBuilder.create().texOffs(50, 0).addBox(0.0F, 0.0F, 0.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-14.0F, 4.0F, 1.0F));

		partdefinition.addOrReplaceChild("Shape14", CubeListBuilder.create().texOffs(50, 0).addBox(0.0F, 0.0F, 0.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-14.0F, 0.0F, 1.0F));

		partdefinition.addOrReplaceChild("Shape15", CubeListBuilder.create().texOffs(50, 0).addBox(0.0F, 0.0F, 0.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-14.0F, 0.0F, -3.0F));

		partdefinition.addOrReplaceChild("Shape16", CubeListBuilder.create().texOffs(50, 0).addBox(0.0F, 0.0F, 0.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-14.0F, 4.0F, -3.0F));

		partdefinition.addOrReplaceChild("Shape17", CubeListBuilder.create().texOffs(50, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(10.0F, 16.0F, 1.0F));

		partdefinition.addOrReplaceChild("Shape18", CubeListBuilder.create().texOffs(50, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(10.0F, 12.0F, 1.0F));

		partdefinition.addOrReplaceChild("Shape19", CubeListBuilder.create().texOffs(50, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(10.0F, 12.0F, -3.0F));

		partdefinition.addOrReplaceChild("Shape20", CubeListBuilder.create().texOffs(50, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(10.0F, 16.0F, -3.0F));

		partdefinition.addOrReplaceChild("Shape21", CubeListBuilder.create().texOffs(50, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(10.0F, 4.0F, 1.0F));

		partdefinition.addOrReplaceChild("Shape22", CubeListBuilder.create().texOffs(50, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(10.0F, 0.0F, 1.0F));

		partdefinition.addOrReplaceChild("Shape23", CubeListBuilder.create().texOffs(50, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(10.0F, 0.0F, -3.0F));

		partdefinition.addOrReplaceChild("Shape24", CubeListBuilder.create().texOffs(50, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(10.0F, 4.0F, -3.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
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
		Shape13.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape14.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape15.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape16.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape17.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape18.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape19.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape20.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape21.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape22.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape23.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape24.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}