package divinerpg.client.models.boss;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.boss.EntityKaros;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelKaros extends EntityModel<EntityKaros> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("karos");
	private final ModelPart head1;
	private final ModelPart body1;
	private final ModelPart rightarm1;
	private final ModelPart leftarm1;
	private final ModelPart head2;
	private final ModelPart rightarm2;
	private final ModelPart leftarm2;
	private final ModelPart body2;
	private final ModelPart body3;
	private final ModelPart body4;
	private final ModelPart body5;
	private final ModelPart body6;
	private final ModelPart body7;
	private final ModelPart body8;
	private final ModelPart body9;
	private final ModelPart body10;
	private final ModelPart body11;
	private final ModelPart body12;
	private final ModelPart body13;
	private final ModelPart body14;
	private final ModelPart body15;
	private final ModelPart body16;
	private final ModelPart body17;
	private final ModelPart body18;
	private final ModelPart body19;
	private final ModelPart body20;
	private final ModelPart body21;
	private final ModelPart body22;
	private final ModelPart body23;

	public ModelKaros(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.head1 = root.getChild("head1");
		this.body1 = root.getChild("body1");
		this.rightarm1 = root.getChild("rightarm1");
		this.leftarm1 = root.getChild("leftarm1");
		this.head2 = root.getChild("head2");
		this.rightarm2 = root.getChild("rightarm2");
		this.leftarm2 = root.getChild("leftarm2");
		this.body2 = root.getChild("body2");
		this.body3 = root.getChild("body3");
		this.body4 = root.getChild("body4");
		this.body5 = root.getChild("body5");
		this.body6 = root.getChild("body6");
		this.body7 = root.getChild("body7");
		this.body8 = root.getChild("body8");
		this.body9 = root.getChild("body9");
		this.body10 = root.getChild("body10");
		this.body11 = root.getChild("body11");
		this.body12 = root.getChild("body12");
		this.body13 = root.getChild("body13");
		this.body14 = root.getChild("body14");
		this.body15 = root.getChild("body15");
		this.body16 = root.getChild("body16");
		this.body17 = root.getChild("body17");
		this.body18 = root.getChild("body18");
		this.body19 = root.getChild("body19");
		this.body20 = root.getChild("body20");
		this.body21 = root.getChild("body21");
		this.body22 = root.getChild("body22");
		this.body23 = root.getChild("body23");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubedef = new CubeDeformation(0.0F);

		partdefinition.addOrReplaceChild("head1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, cubedef).mirror(false), PartPose.offset(8.0F, -11.0F, 0.0F));

		partdefinition.addOrReplaceChild("body1", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, cubedef).mirror(false), PartPose.offset(4.0F, -1.0F, 2.0F));

		partdefinition.addOrReplaceChild("rightarm1", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-4.0F, -4.0F, -3.0F, 6.0F, 4.0F, 6.0F, cubedef).mirror(false), PartPose.offset(-10.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarm1", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-2.0F, -4.0F, -3.0F, 6.0F, 4.0F, 6.0F, cubedef).mirror(false), PartPose.offset(10.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("head2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, cubedef).mirror(false), PartPose.offset(-8.0F, -11.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarm2", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, cubedef).mirror(false), PartPose.offset(-10.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarm2", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, cubedef).mirror(false), PartPose.offset(10.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, cubedef).mirror(false), PartPose.offset(0.0F, -7.0F, 2.0F));

		partdefinition.addOrReplaceChild("body3", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, cubedef).mirror(false), PartPose.offset(-4.0F, -1.0F, 2.0F));

		partdefinition.addOrReplaceChild("body4", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, cubedef).mirror(false), PartPose.offset(-4.0F, -1.0F, -2.0F));

		partdefinition.addOrReplaceChild("body5", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, cubedef).mirror(false), PartPose.offset(4.0F, -1.0F, -2.0F));

		partdefinition.addOrReplaceChild("body6", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(1.0F, -2.0F, -3.0F, 4.0F, 4.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(6.0F, -6.0F, 1.0F, 0.0F, 0.0F, -0.6109F));

		partdefinition.addOrReplaceChild("body7", CubeListBuilder.create().texOffs(27, 0).mirror().addBox(-4.0F, 0.0F, -2.0F, 1.0F, 6.0F, 1.0F, cubedef).mirror(false), PartPose.offset(7.0F, 11.0F, 5.0F));

		partdefinition.addOrReplaceChild("body8", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, cubedef).mirror(false), PartPose.offset(0.0F, 5.0F, 2.0F));

		partdefinition.addOrReplaceChild("body9", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, cubedef).mirror(false), PartPose.offset(0.0F, 5.0F, -2.0F));

		partdefinition.addOrReplaceChild("body10", CubeListBuilder.create().texOffs(27, 0).mirror().addBox(-4.0F, 0.0F, -2.0F, 1.0F, 6.0F, 1.0F, cubedef).mirror(false), PartPose.offset(0.0F, 11.0F, -2.0F));

		partdefinition.addOrReplaceChild("body11", CubeListBuilder.create().texOffs(27, 0).mirror().addBox(-4.0F, 0.0F, -2.0F, 1.0F, 6.0F, 1.0F, cubedef).mirror(false), PartPose.offset(2.0F, 11.0F, 3.0F));

		partdefinition.addOrReplaceChild("body12", CubeListBuilder.create().texOffs(27, 0).mirror().addBox(-4.0F, 0.0F, -2.0F, 1.0F, 6.0F, 1.0F, cubedef).mirror(false), PartPose.offset(1.0F, 11.0F, 5.0F));

		partdefinition.addOrReplaceChild("body13", CubeListBuilder.create().texOffs(27, 0).mirror().addBox(-4.0F, 0.0F, -2.0F, 1.0F, 6.0F, 1.0F, cubedef).mirror(false), PartPose.offset(5.0F, 11.0F, 4.0F));

		partdefinition.addOrReplaceChild("body14", CubeListBuilder.create().texOffs(27, 0).mirror().addBox(-4.0F, 0.0F, -2.0F, 1.0F, 6.0F, 1.0F, cubedef).mirror(false), PartPose.offset(6.0F, 11.0F, 0.0F));

		partdefinition.addOrReplaceChild("body15", CubeListBuilder.create().texOffs(27, 0).mirror().addBox(-4.0F, 0.0F, -2.0F, 1.0F, 6.0F, 1.0F, cubedef).mirror(false), PartPose.offset(4.0F, 11.0F, 1.0F));

		partdefinition.addOrReplaceChild("body16", CubeListBuilder.create().texOffs(27, 0).mirror().addBox(-4.0F, 0.0F, -2.0F, 1.0F, 6.0F, 1.0F, cubedef).mirror(false), PartPose.offset(7.0F, 11.0F, -2.0F));

		partdefinition.addOrReplaceChild("body17", CubeListBuilder.create().texOffs(27, 0).mirror().addBox(-4.0F, 0.0F, -2.0F, 1.0F, 6.0F, 1.0F, cubedef).mirror(false), PartPose.offset(3.0F, 11.0F, -1.0F));

		partdefinition.addOrReplaceChild("body18", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, cubedef).mirror(false), PartPose.offset(0.0F, -7.0F, -2.0F));

		partdefinition.addOrReplaceChild("body19", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-5.0F, -2.0F, -3.0F, 4.0F, 4.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-5.0F, -6.0F, 1.0F, 0.0F, 0.0F, 0.6109F));

		partdefinition.addOrReplaceChild("body20", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, -1.0F, -2.0F, 7.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(6.0F, -6.0F, 1.0F, 0.0F, 0.0F, -0.6109F));

		partdefinition.addOrReplaceChild("body21", CubeListBuilder.create().texOffs(32, 11).mirror().addBox(-4.0F, -1.0F, -2.0F, 5.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(9.0F, -11.0F, 1.0F, 0.0F, 0.0F, -1.5708F));

		partdefinition.addOrReplaceChild("body22", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, -1.0F, -2.0F, 7.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-5.0F, -6.0F, 1.0F, 0.0F, 0.0F, 0.6109F));

		partdefinition.addOrReplaceChild("body23", CubeListBuilder.create().texOffs(32, 11).mirror().addBox(-4.0F, -1.0F, -2.0F, 5.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-8.0F, -11.0F, 1.0F, 0.0F, 0.0F, -1.5708F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(EntityKaros entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.rightarm1.xRot = (float) (Math.cos(limbSwing * 0.6662 + Math.PI) * 2.0 * limbSwingAmount * 0.5);
        this.rightarm2.xRot = (float) (Math.cos(limbSwing * 0.6662 + Math.PI) * 2.0 * limbSwingAmount * 0.5);

        this.leftarm1.xRot = (float) (Math.cos(limbSwing * 0.6662) * 2.0 * limbSwingAmount * 0.5);
        this.leftarm2.xRot = (float) (Math.cos(limbSwing * 0.6662) * 2.0 * limbSwingAmount * 0.5);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body9.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body10.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body11.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body12.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body13.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body14.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body15.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body16.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body17.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body18.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body19.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body20.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body21.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body22.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body23.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}