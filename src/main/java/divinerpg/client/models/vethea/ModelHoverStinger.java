package divinerpg.client.models.vethea;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelHoverStinger<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("hover_stinger");
	private final ModelPart Shape1;
	private final ModelPart Shape2;
	private final ModelPart Shape3;
	private final ModelPart Shape4;
	private final ModelPart Shape5;
	private final ModelPart Shape6;
	private final ModelPart Shape7;
	private final ModelPart Wing1;
	private final ModelPart Shape8;
	private final ModelPart Shape9;
	private final ModelPart Shape10;
	private final ModelPart Wing2;
	private final ModelPart Wing3;
	private final ModelPart Wing4;

	public ModelHoverStinger(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Shape1 = root.getChild("Shape1");
		this.Shape2 = root.getChild("Shape2");
		this.Shape3 = root.getChild("Shape3");
		this.Shape4 = root.getChild("Shape4");
		this.Shape5 = root.getChild("Shape5");
		this.Shape6 = root.getChild("Shape6");
		this.Shape7 = root.getChild("Shape7");
		this.Wing1 = root.getChild("Wing1");
		this.Shape8 = root.getChild("Shape8");
		this.Shape9 = root.getChild("Shape9");
		this.Shape10 = root.getChild("Shape10");
		this.Wing2 = root.getChild("Wing2");
		this.Wing3 = root.getChild("Wing3");
		this.Wing4 = root.getChild("Wing4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("Shape1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 1.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, -1.0F, -3.0F));

		partdefinition.addOrReplaceChild("Shape2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 8.0F, -1.0F, -0.6109F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Shape3", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(1.0F, 3.0F, 2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 8.0F, -1.0F, -0.7854F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Shape4", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(2.0F, 7.0F, 4.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 8.0F, -1.0F, -0.9599F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Shape5", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 1.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 4.0F, -2.0F, -0.4363F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Shape6", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 1.0F, 10.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, 2.0F, -4.0F));

		partdefinition.addOrReplaceChild("Shape7", CubeListBuilder.create().texOffs(42, 0).mirror().addBox(0.0F, 0.0F, 1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, -15.0F, -8.0F));

		partdefinition.addOrReplaceChild("Wing1", CubeListBuilder.create().texOffs(0, 26).addBox(0.0F, -2.0F, 1.0F, 10.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 4.0F, 4.0F));

		partdefinition.addOrReplaceChild("Shape8", CubeListBuilder.create().texOffs(22, 16).mirror().addBox(0.0F, 0.0F, 1.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, -11.0F, -10.0F));

		partdefinition.addOrReplaceChild("Shape9", CubeListBuilder.create().texOffs(42, 0).mirror().addBox(0.0F, 0.0F, 1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.0F, -15.0F, -8.0F));

		partdefinition.addOrReplaceChild("Shape10", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 1.0F, 10.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, -7.0F, -4.0F));

		partdefinition.addOrReplaceChild("Wing2", CubeListBuilder.create().texOffs(0, 26).addBox(-9.0F, -2.0F, 1.0F, 10.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 4.0F, 4.0F));

		partdefinition.addOrReplaceChild("Wing3", CubeListBuilder.create().texOffs(0, 26).addBox(0.0F, -2.0F, 1.0F, 10.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -5.0F, 2.0F));

		partdefinition.addOrReplaceChild("Wing4", CubeListBuilder.create().texOffs(0, 26).addBox(-9.0F, -2.0F, 1.0F, 10.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -5.0F, 2.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Wing1.yRot = Mth.cos(ageInTicks * 1.3F) * (float)Math.PI * 0.25F;
		this.Wing2.yRot = -this.Wing1.yRot;
		this.Wing3.yRot = Mth.cos(ageInTicks * 1.3F) * (float)Math.PI * 0.25F;
		this.Wing4.yRot = -this.Wing3.yRot;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		Shape1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Shape2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Shape3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Shape4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Shape5.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Shape6.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Shape7.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Wing1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Shape8.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Shape9.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Shape10.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Wing2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Wing3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Wing4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}