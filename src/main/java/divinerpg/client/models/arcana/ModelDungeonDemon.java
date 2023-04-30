package divinerpg.client.models.arcana;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelDungeonDemon<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("dungeon_demon");
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart rightarm;
	private final ModelPart leftarm;
	private final ModelPart rightleg;
	private final ModelPart leftleg;
	private final ModelPart Shape1;
	private final ModelPart Shape2;
	private final ModelPart Shape3;
	private final ModelPart Shape4;
	private final ModelPart Shape5;
	private final ModelPart Shape6;
	private final ModelPart Shape7;
	private final ModelPart Shape8;
	private final ModelPart backplate;
	private final ModelPart restplate;
	private final ModelPart connector;
	private final ModelPart shape9;
	private final ModelPart shape10;
	private final ModelPart Shape11;
	private final ModelPart Shape12;
	private final ModelPart Shape13;
	private final ModelPart Shape14;
	private final ModelPart Shape15;
	private final ModelPart Shape16;

	public ModelDungeonDemon(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.rightarm = root.getChild("rightarm");
		this.leftarm = root.getChild("leftarm");
		this.rightleg = root.getChild("rightleg");
		this.leftleg = root.getChild("leftleg");
		this.Shape1 = root.getChild("Shape1");
		this.Shape2 = root.getChild("Shape2");
		this.Shape3 = root.getChild("Shape3");
		this.Shape4 = root.getChild("Shape4");
		this.Shape5 = root.getChild("Shape5");
		this.Shape6 = root.getChild("Shape6");
		this.Shape7 = root.getChild("Shape7");
		this.Shape8 = root.getChild("Shape8");
		this.backplate = root.getChild("backplate");
		this.restplate = root.getChild("restplate");
		this.connector = root.getChild("connector");
		this.shape9 = root.getChild("shape9");
		this.shape10 = root.getChild("shape10");
		this.Shape11 = root.getChild("Shape11");
		this.Shape12 = root.getChild("Shape12");
		this.Shape13 = root.getChild("Shape13");
		this.Shape14 = root.getChild("Shape14");
		this.Shape15 = root.getChild("Shape15");
		this.Shape16 = root.getChild("Shape16");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(-4.0F, -14.0F, -4.0F, 8.0F, 10.0F, 8.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(0.0F, 4.0F, 0.0F));

		head.addOrReplaceChild("headtop", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-5.0F, 14.0F, -4.0F, 10.0F, 5.0F, 8.0F, CubeDeformation.NONE).mirror(false), PartPose.rotation(3.1416F, 0.0F, 0.0F));

		head.addOrReplaceChild("headbottom", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-5.0F, -4.0F, -4.0F, 10.0F, 5.0F, 8.0F, CubeDeformation.NONE).mirror(false), PartPose.rotation(0.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 9.0F, 2.0F));

		partdefinition.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, 7.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, 7.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 17.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 17.0F, 0.0F));

		partdefinition.addOrReplaceChild("Shape1", CubeListBuilder.create().texOffs(46, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 17.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 4.0F, 5.0F, 0.0F, 0.0F, 1.5708F));

		partdefinition.addOrReplaceChild("Shape2", CubeListBuilder.create().texOffs(46, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 17.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -2.0F, 5.0F, 0.0F, 0.0F, 1.5708F));

		partdefinition.addOrReplaceChild("Shape3", CubeListBuilder.create().texOffs(46, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 17.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 0.0F, 5.0F, 0.0F, 0.0F, 1.5708F));

		partdefinition.addOrReplaceChild("Shape4", CubeListBuilder.create().texOffs(46, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 17.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 2.0F, 5.0F, 0.0F, 0.0F, 1.5708F));

		partdefinition.addOrReplaceChild("Shape5", CubeListBuilder.create().texOffs(46, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 17.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 10.0F, 5.0F, 0.0F, 0.0F, 1.5708F));

		partdefinition.addOrReplaceChild("Shape6", CubeListBuilder.create().texOffs(46, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 17.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 12.0F, 5.0F, 0.0F, 0.0F, 1.5708F));

		partdefinition.addOrReplaceChild("Shape7", CubeListBuilder.create().texOffs(46, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 17.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 8.0F, 5.0F, 0.0F, 0.0F, 1.5708F));

		partdefinition.addOrReplaceChild("Shape8", CubeListBuilder.create().texOffs(46, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 17.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 6.0F, 5.0F, 0.0F, 0.0F, 1.5708F));

		partdefinition.addOrReplaceChild("backplate", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 5.0F, 0.0F));

		partdefinition.addOrReplaceChild("restplate", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -3.0F, 6.0F));

		partdefinition.addOrReplaceChild("connector", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 9.0F, 6.0F));

		partdefinition.addOrReplaceChild("shape9", CubeListBuilder.create().texOffs(46, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 17.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, -1.0F, 5.0F, 0.0F, 0.0F, -1.5708F));

		partdefinition.addOrReplaceChild("shape10", CubeListBuilder.create().texOffs(46, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 17.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 1.0F, 5.0F, 0.0F, 0.0F, -1.5708F));

		partdefinition.addOrReplaceChild("Shape11", CubeListBuilder.create().texOffs(46, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 17.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 3.0F, 5.0F, 0.0F, 0.0F, -1.5708F));

		partdefinition.addOrReplaceChild("Shape12", CubeListBuilder.create().texOffs(46, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 17.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 5.0F, 5.0F, 0.0F, 0.0F, -1.5708F));

		partdefinition.addOrReplaceChild("Shape13", CubeListBuilder.create().texOffs(46, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 17.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 7.0F, 5.0F, 0.0F, 0.0F, -1.5708F));

		partdefinition.addOrReplaceChild("Shape14", CubeListBuilder.create().texOffs(46, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 17.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 9.0F, 5.0F, 0.0F, 0.0F, -1.5708F));

		partdefinition.addOrReplaceChild("Shape15", CubeListBuilder.create().texOffs(46, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 17.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 11.0F, 5.0F, 0.0F, 0.0F, -1.5708F));

		partdefinition.addOrReplaceChild("Shape16", CubeListBuilder.create().texOffs(46, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 17.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 13.0F, 5.0F, 0.0F, 0.0F, -1.5708F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float)Math.PI);
		this.head.xRot = headPitch / (180F / (float)Math.PI);
		this.rightarm.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.leftarm.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.rightarm.zRot = 0.0F;
		this.leftarm.zRot = 0.0F;
		this.rightleg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leftleg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.rightleg.yRot = 0.0F;
		this.leftleg.yRot = 0.0F;
		this.rightarm.yRot = 0.0F;
		this.leftarm.yRot = 0.0F;
		this.rightarm.yRot += Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.leftarm.yRot -= Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.rightarm.xRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
		this.leftarm.xRot -= Mth.sin(ageInTicks * 0.067F) * 0.05F;
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
		Shape2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		backplate.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		restplate.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		connector.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		shape9.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		shape10.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape11.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape12.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape13.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape14.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape15.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape16.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}