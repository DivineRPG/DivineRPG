package divinerpg.client.models.twilight;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;


public class ModelMystic<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation( "mystic");
	private final ModelPart body;
	private final ModelPart rightarm;
	private final ModelPart staffProng2;
	private final ModelPart rightleg;
	private final ModelPart leftleg;
	private final ModelPart leftarm;
	private final ModelPart staffPole;
	private final ModelPart staffCap;
	private final ModelPart staffProng1;
	private final ModelPart staffProng3;
	private final ModelPart staffProng4;
	private final ModelPart head;
	private final ModelPart ray2;
	private final ModelPart ray8;
	private final ModelPart ray6;
	private final ModelPart ray4;
	private final ModelPart ray1;
	private final ModelPart ray7;
	private final ModelPart ray5;
	private final ModelPart ray3;

	public ModelMystic(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.body = root.getChild("body");
		this.rightarm = root.getChild("rightarm");
		this.staffProng2 = root.getChild("staffProng2");
		this.rightleg = root.getChild("rightleg");
		this.leftleg = root.getChild("leftleg");
		this.leftarm = root.getChild("leftarm");
		this.staffPole = root.getChild("staffPole");
		this.staffCap = root.getChild("staffCap");
		this.staffProng1 = root.getChild("staffProng1");
		this.staffProng3 = root.getChild("staffProng3");
		this.staffProng4 = root.getChild("staffProng4");
		this.head = root.getChild("head");
		this.ray2 = root.getChild("ray2");
		this.ray8 = root.getChild("ray8");
		this.ray6 = root.getChild("ray6");
		this.ray4 = root.getChild("ray4");
		this.ray1 = root.getChild("ray1");
		this.ray7 = root.getChild("ray7");
		this.ray5 = root.getChild("ray5");
		this.ray3 = root.getChild("ray3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(10, 23).mirror().addBox(-6.0F, 4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 2.0F, -2.0F));

		partdefinition.addOrReplaceChild("staffProng2", CubeListBuilder.create().texOffs(40, 20).mirror().addBox(4.0F, -7.0F, -3.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(0, 12).mirror().addBox(-2.0F, 10.0F, -6.0F, 4.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(0, 12).mirror().addBox(-2.0F, 10.0F, -6.0F, 4.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(10, 23).mirror().addBox(1.0F, 4.0F, -4.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("staffPole", CubeListBuilder.create().texOffs(53, 0).mirror().addBox(2.0F, -4.0F, -5.0F, 2.0F, 22.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("staffCap", CubeListBuilder.create().texOffs(40, 25).mirror().addBox(1.0F, -5.0F, -6.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("staffProng1", CubeListBuilder.create().texOffs(40, 20).mirror().addBox(1.0F, -7.0F, -3.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("staffProng3", CubeListBuilder.create().texOffs(40, 20).mirror().addBox(4.0F, -7.0F, -6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("staffProng4", CubeListBuilder.create().texOffs(40, 20).mirror().addBox(1.0F, -7.0F, -6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -5.0F, -1.0F));

		partdefinition.addOrReplaceChild("ray2", CubeListBuilder.create().texOffs(0, 23).mirror().addBox(-7.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -9.0F, -1.0F, 0.0F, 0.0F, -0.7854F));

		partdefinition.addOrReplaceChild("ray8", CubeListBuilder.create().texOffs(0, 23).mirror().addBox(-1.0F, 6.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -9.0F, -1.0F, 0.0F, 0.0F, -0.7854F));

		partdefinition.addOrReplaceChild("ray6", CubeListBuilder.create().texOffs(0, 23).mirror().addBox(5.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -9.0F, -1.0F, 0.0F, 0.0F, -0.7854F));

		partdefinition.addOrReplaceChild("ray4", CubeListBuilder.create().texOffs(0, 23).mirror().addBox(-1.0F, -7.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -9.0F, -1.0F, 0.0F, 0.0F, -0.7854F));

		partdefinition.addOrReplaceChild("ray1", CubeListBuilder.create().texOffs(0, 23).mirror().addBox(-1.0F, 6.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -9.0F, -1.0F));

		partdefinition.addOrReplaceChild("ray7", CubeListBuilder.create().texOffs(0, 23).mirror().addBox(5.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -9.0F, -1.0F));

		partdefinition.addOrReplaceChild("ray5", CubeListBuilder.create().texOffs(0, 23).mirror().addBox(-1.0F, -7.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -9.0F, -1.0F));

		partdefinition.addOrReplaceChild("ray3", CubeListBuilder.create().texOffs(0, 23).mirror().addBox(-7.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -9.0F, -1.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.ray1.zRot  = this.ray3.zRot = this.ray5.zRot = this.ray7.zRot = ageInTicks/10;
		this.ray2.zRot = this.ray4.zRot = this.ray6.zRot = this.ray8.zRot = ageInTicks/10 - 0.7853982F;
		this.leftleg.xRot = this.rightarm.xRot = Mth.cos(limbSwing)*limbSwingAmount*1.2f;
		this.rightleg.xRot = this.leftarm.xRot = this.staffPole.xRot = this.staffCap.xRot = this.staffProng1.xRot = this.staffProng2.xRot = this.staffProng3.xRot = this.staffProng4.xRot = Mth.cos(limbSwing+(float)Math.PI)*limbSwingAmount*1.2f;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		staffProng2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		staffPole.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		staffCap.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		staffProng1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		staffProng3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		staffProng4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		ray2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		ray8.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		ray6.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		ray4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		ray1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		ray7.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		ray5.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		ray3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}