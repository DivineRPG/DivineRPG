package divinerpg.client.models.twilight;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;


public class ModelTermid<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("termid");
	private final ModelPart legR;
	private final ModelPart legL;
	private final ModelPart body;
	private final ModelPart ridge1;
	private final ModelPart ridge2;
	private final ModelPart ridge3;
	private final ModelPart ridge4;
	private final ModelPart ridge5;
	private final ModelPart ridge6;
	private final ModelPart ridge7;
	private final ModelPart neck;
	private final ModelPart head;
	private final ModelPart jawL;
	private final ModelPart jawR;

	public ModelTermid(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.legR = root.getChild("legR");
		this.legL = root.getChild("legL");
		this.body = root.getChild("body");
		this.ridge1 = root.getChild("ridge1");
		this.ridge2 = root.getChild("ridge2");
		this.ridge3 = root.getChild("ridge3");
		this.ridge4 = root.getChild("ridge4");
		this.ridge5 = root.getChild("ridge5");
		this.ridge6 = root.getChild("ridge6");
		this.ridge7 = root.getChild("ridge7");
		this.neck = root.getChild("neck");
		this.head = root.getChild("head");
		this.jawL = root.getChild("jawL");
		this.jawR = root.getChild("jawR");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("legR", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.5F, 20.0F, 0.0F));

		partdefinition.addOrReplaceChild("legL", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.5F, 20.0F, 0.0F));

		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 5.0F, -2.0F));

		partdefinition.addOrReplaceChild("ridge1", CubeListBuilder.create().texOffs(20, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 8.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 18.0F, -3.0F));

		partdefinition.addOrReplaceChild("ridge2", CubeListBuilder.create().texOffs(20, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 8.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 16.0F, -3.0F));

		partdefinition.addOrReplaceChild("ridge3", CubeListBuilder.create().texOffs(20, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 8.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 14.0F, -3.0F));

		partdefinition.addOrReplaceChild("ridge4", CubeListBuilder.create().texOffs(20, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 8.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 12.0F, -3.0F));

		partdefinition.addOrReplaceChild("ridge5", CubeListBuilder.create().texOffs(20, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 8.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 10.0F, -3.0F));

		partdefinition.addOrReplaceChild("ridge6", CubeListBuilder.create().texOffs(20, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 8.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 8.0F, -3.0F));

		partdefinition.addOrReplaceChild("ridge7", CubeListBuilder.create().texOffs(20, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 8.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 6.0F, -3.0F));

		partdefinition.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(22, 25).mirror().addBox(-1.5F, -6.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 6.0F, 1.0F, 0.7854F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 25).mirror().addBox(-3.0F, -6.0F, -2.5F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 3.0F, -3.0F));

		partdefinition.addOrReplaceChild("jawL", CubeListBuilder.create().texOffs(0, 36).mirror().addBox(2.0F, -1.0F, -5.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 3.0F, -3.0F));

		partdefinition.addOrReplaceChild("jawR", CubeListBuilder.create().texOffs(0, 36).mirror().addBox(-3.0F, -1.0F, -5.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 3.0F, -3.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.legL.xRot = (Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
		this.legR.xRot = (Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		legR.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		legL.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		ridge1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		ridge2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		ridge3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		ridge4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		ridge5.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		ridge6.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		ridge7.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		neck.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		jawL.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		jawR.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}