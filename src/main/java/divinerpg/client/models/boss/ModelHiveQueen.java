package divinerpg.client.models.boss;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.boss.EntityHiveQueen;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelHiveQueen extends EntityModel<EntityHiveQueen> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("hive_queen");
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
	private final ModelPart Shape30;
	private final ModelPart Shape31;
	private final ModelPart Shape32;
	private final ModelPart Shape33;

	public ModelHiveQueen(Context context) {
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
		this.Shape30 = root.getChild("Shape30");
		this.Shape31 = root.getChild("Shape31");
		this.Shape32 = root.getChild("Shape32");
		this.Shape33 = root.getChild("Shape33");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubedef = new CubeDeformation(0.0F);

		partdefinition.addOrReplaceChild("Shape1", CubeListBuilder.create().texOffs(24, 12).mirror().addBox(0.0F, 0.0F, 0.0F, 10.0F, 10.0F, 10.0F, cubedef).mirror(false), PartPose.offset(-5.0F, 14.0F, -5.0F));

		partdefinition.addOrReplaceChild("Shape2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 6.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(5.0F, 19.0F, -2.0F, 0.0F, 0.0F, -2.2689F));

		partdefinition.addOrReplaceChild("Shape3", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.0F, 19.0F, 1.0F, 4.0F, 6.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-11.0F, 19.0F, -2.0F, 0.0F, 0.0F, -1.9199F));

		partdefinition.addOrReplaceChild("Shape4", CubeListBuilder.create().texOffs(29, 0).mirror().addBox(6.0F, 22.0F, 2.0F, 2.0F, 6.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-11.0F, 17.0F, -2.0F, 0.0F, 0.0F, -1.5708F));

		partdefinition.addOrReplaceChild("Shape5", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(1.0F, -4.0F, 1.0F, 4.0F, 6.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-11.0F, 14.0F, -2.0F, 0.0F, 0.0F, -1.1345F));

		partdefinition.addOrReplaceChild("Shape6", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 6.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-11.0F, 14.0F, -2.0F, 0.0F, 0.0F, -0.7854F));

		partdefinition.addOrReplaceChild("Shape7", CubeListBuilder.create().texOffs(29, 0).mirror().addBox(3.0F, -8.0F, 2.0F, 2.0F, 6.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-11.0F, 14.0F, -2.0F, 0.0F, 0.0F, -1.4835F));

		partdefinition.addOrReplaceChild("Shape8", CubeListBuilder.create().texOffs(29, 0).mirror().addBox(3.0F, -8.0F, 2.0F, 2.0F, 6.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(2.0F, 21.0F, 10.0F, 0.0F, 2.0944F, -2.2689F));

		partdefinition.addOrReplaceChild("Shape9", CubeListBuilder.create().texOffs(29, 0).mirror().addBox(1.0F, -4.0F, 1.0F, 2.0F, 6.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(6.0F, 21.0F, -1.0F, 0.0F, -2.618F, -2.618F));

		partdefinition.addOrReplaceChild("Shape10", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 4.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(6.0F, 21.0F, -1.0F, 0.0F, -2.618F, -2.2689F));

		partdefinition.addOrReplaceChild("Shape11", CubeListBuilder.create().texOffs(29, 0).mirror().addBox(16.0F, 16.0F, 2.0F, 2.0F, 6.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-11.0F, 21.0F, -3.0F, 0.0F, 0.0F, -0.8727F));

		partdefinition.addOrReplaceChild("Shape12", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(8.0F, 17.0F, 1.0F, 4.0F, 6.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-11.0F, 21.0F, -3.0F, 0.0F, 0.0F, -1.2217F));

		partdefinition.addOrReplaceChild("Shape13", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 6.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(5.0F, 21.0F, -3.0F, 0.0F, 0.0F, -1.5708F));

		partdefinition.addOrReplaceChild("Shape14", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 6.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(2.0F, 21.0F, 10.0F, 0.0F, 2.0944F, -1.5708F));

		partdefinition.addOrReplaceChild("Shape15", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(1.0F, -4.0F, 1.0F, 4.0F, 6.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(2.0F, 21.0F, 10.0F, 0.0F, 2.0944F, -1.9199F));

		partdefinition.addOrReplaceChild("Shape16", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 4.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-4.0F, 21.0F, -4.0F, 0.0F, -0.5236F, -2.2689F));

		partdefinition.addOrReplaceChild("Shape17", CubeListBuilder.create().texOffs(29, 0).mirror().addBox(1.0F, -4.0F, 1.0F, 2.0F, 6.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-4.0F, 21.0F, -4.0F, 0.0F, -0.5236F, -2.618F));

		partdefinition.addOrReplaceChild("Shape18", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 6.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-11.0F, 21.0F, -3.0F, 0.0F, 0.0F, -1.5708F));

		partdefinition.addOrReplaceChild("Shape19", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(1.0F, -4.0F, 1.0F, 4.0F, 6.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-11.0F, 21.0F, -3.0F, 0.0F, 0.0F, -1.9199F));

		partdefinition.addOrReplaceChild("Shape30", CubeListBuilder.create().texOffs(29, 0).mirror().addBox(3.0F, -8.0F, 2.0F, 2.0F, 6.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-11.0F, 21.0F, -3.0F, 0.0F, 0.0F, -2.2689F));

		partdefinition.addOrReplaceChild("Shape31", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 6.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-9.0F, 21.0F, 7.0F, 0.0F, 1.0472F, -1.5708F));

		partdefinition.addOrReplaceChild("Shape32", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(1.0F, -4.0F, 1.0F, 4.0F, 6.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-9.0F, 21.0F, 7.0F, 0.0F, 1.0472F, -1.9199F));

		partdefinition.addOrReplaceChild("Shape33", CubeListBuilder.create().texOffs(29, 0).mirror().addBox(3.0F, -8.0F, 2.0F, 2.0F, 6.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-9.0F, 21.0F, 7.0F, 0.0F, 1.0472F, -2.2689F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(EntityHiveQueen entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

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
		Shape30.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape31.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape32.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape33.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}