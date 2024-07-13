package divinerpg.client.models.twilight;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.mortum.EntityDemonOfDarkness;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;


public class ModelDemonOfDarkness extends EntityModel<EntityDemonOfDarkness> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("demon_of_darkness");
	private final ModelPart Main_Body;
	private final ModelPart Lower_Body;
	private final ModelPart Legbottom1;
	private final ModelPart Legbottom2;
	private final ModelPart Legbottom3;
	private final ModelPart Legbottom4;
	private final ModelPart Legbottom5;
	private final ModelPart Legbottom6;
	private final ModelPart Legbottom7;
	private final ModelPart Legbottom8;
	private final ModelPart Legbottom9;
	private final ModelPart Legbottom10;
	private final ModelPart Legbottom11;
	private final ModelPart Legbottom12;
	private final ModelPart Legbottom13;
	private final ModelPart Legbottom14;
	private final ModelPart Legbottom15;
	private final ModelPart Legbottom16;
	private final ModelPart Legbottom17;
	private final ModelPart Legbottom18;
	private final ModelPart Legbottom19;
	private final ModelPart Legbottom20;
	private final ModelPart Legbottom21;
	private final ModelPart Legbottom22;
	private final ModelPart Legbottom23;
	private final ModelPart Legbottom24;
	private final ModelPart Legbottom25;

	public ModelDemonOfDarkness(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Main_Body = root.getChild("Main_Body");
		this.Lower_Body = root.getChild("Lower_Body");
		this.Legbottom1 = root.getChild("Legbottom1");
		this.Legbottom2 = root.getChild("Legbottom2");
		this.Legbottom3 = root.getChild("Legbottom3");
		this.Legbottom4 = root.getChild("Legbottom4");
		this.Legbottom5 = root.getChild("Legbottom5");
		this.Legbottom6 = root.getChild("Legbottom6");
		this.Legbottom7 = root.getChild("Legbottom7");
		this.Legbottom8 = root.getChild("Legbottom8");
		this.Legbottom9 = root.getChild("Legbottom9");
		this.Legbottom10 = root.getChild("Legbottom10");
		this.Legbottom11 = root.getChild("Legbottom11");
		this.Legbottom12 = root.getChild("Legbottom12");
		this.Legbottom13 = root.getChild("Legbottom13");
		this.Legbottom14 = root.getChild("Legbottom14");
		this.Legbottom15 = root.getChild("Legbottom15");
		this.Legbottom16 = root.getChild("Legbottom16");
		this.Legbottom17 = root.getChild("Legbottom17");
		this.Legbottom18 = root.getChild("Legbottom18");
		this.Legbottom19 = root.getChild("Legbottom19");
		this.Legbottom20 = root.getChild("Legbottom20");
		this.Legbottom21 = root.getChild("Legbottom21");
		this.Legbottom22 = root.getChild("Legbottom22");
		this.Legbottom23 = root.getChild("Legbottom23");
		this.Legbottom24 = root.getChild("Legbottom24");
		this.Legbottom25 = root.getChild("Legbottom25");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("Main_Body", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 10.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.0F, 6.0F, 2.0F, 0.0F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("Lower_Body", CubeListBuilder.create().texOffs(39, 20).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 9.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("Legbottom1", CubeListBuilder.create().texOffs(14, 5).mirror().addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 8.0F, 0.0F));

		partdefinition.addOrReplaceChild("Legbottom2", CubeListBuilder.create().texOffs(14, 5).mirror().addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 8.0F, -7.0F));

		partdefinition.addOrReplaceChild("Legbottom3", CubeListBuilder.create().texOffs(14, 18).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 1.0F, -5.0F, -1.5708F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("Legbottom4", CubeListBuilder.create().texOffs(14, 18).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 1.0F, 2.0F, -1.5708F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("Legbottom5", CubeListBuilder.create().texOffs(14, 18).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 15.0F, -4.0F, -1.5708F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("Legbottom6", CubeListBuilder.create().texOffs(14, 18).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 15.0F, -4.0F, -1.5708F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("Legbottom7", CubeListBuilder.create().texOffs(14, 18).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 15.0F, 0.0F, -1.5708F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("Legbottom8", CubeListBuilder.create().texOffs(14, 18).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 15.0F, 0.0F, -1.5708F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("Legbottom9", CubeListBuilder.create().texOffs(14, 18).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 1.0F, 2.0F, -1.5708F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("Legbottom10", CubeListBuilder.create().texOffs(14, 18).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 1.0F, -5.0F, -1.5708F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("Legbottom11", CubeListBuilder.create().texOffs(14, 18).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 1.0F, -2.0F, -1.5708F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("Legbottom12", CubeListBuilder.create().texOffs(14, 18).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 1.0F, -2.0F, -1.5708F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("Legbottom13", CubeListBuilder.create().texOffs(14, 5).mirror().addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 8.0F, -4.0F));

		partdefinition.addOrReplaceChild("Legbottom14", CubeListBuilder.create().texOffs(14, 18).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 1.0F, -5.0F, -1.5708F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("Legbottom15", CubeListBuilder.create().texOffs(14, 18).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 1.0F, -2.0F, -1.5708F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("Legbottom16", CubeListBuilder.create().texOffs(14, 18).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 1.0F, 2.0F, -1.5708F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("Legbottom17", CubeListBuilder.create().texOffs(14, 5).mirror().addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 5.0F, -7.0F));

		partdefinition.addOrReplaceChild("Legbottom18", CubeListBuilder.create().texOffs(14, 5).mirror().addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 5.0F, -4.0F));

		partdefinition.addOrReplaceChild("Legbottom19", CubeListBuilder.create().texOffs(14, 5).mirror().addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 5.0F, 0.0F));

		partdefinition.addOrReplaceChild("Legbottom20", CubeListBuilder.create().texOffs(14, 5).mirror().addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, 5.0F, -7.0F));

		partdefinition.addOrReplaceChild("Legbottom21", CubeListBuilder.create().texOffs(14, 5).mirror().addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, 5.0F, -4.0F));

		partdefinition.addOrReplaceChild("Legbottom22", CubeListBuilder.create().texOffs(14, 5).mirror().addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, 5.0F, 0.0F));

		partdefinition.addOrReplaceChild("Legbottom23", CubeListBuilder.create().texOffs(14, 5).mirror().addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, 8.0F, 0.0F));

		partdefinition.addOrReplaceChild("Legbottom24", CubeListBuilder.create().texOffs(14, 5).mirror().addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, 8.0F, -4.0F));

		partdefinition.addOrReplaceChild("Legbottom25", CubeListBuilder.create().texOffs(14, 5).mirror().addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, 8.0F, -7.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(EntityDemonOfDarkness entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Legbottom1.xRot = 0.2F * Mth.sin(ageInTicks * 0.3F) + 0.4F;
		this.Legbottom2.xRot = 0.2F * Mth.sin(ageInTicks * 0.3F) + 0.4F;
		this.Legbottom3.xRot = 0.2F * Mth.sin(ageInTicks * 0.3F) + 0.4F;
		this.Legbottom4.xRot = 0.2F * Mth.sin(ageInTicks * 0.3F) + 0.4F;
		this.Legbottom5.xRot = 0.2F * Mth.sin(ageInTicks * 0.3F) + 0.4F;
		this.Legbottom6.xRot = 0.2F * Mth.sin(ageInTicks * 0.3F) + 0.4F;
		this.Legbottom7.xRot = 0.2F * Mth.sin(ageInTicks * 0.3F) + 0.4F;
		this.Legbottom8.xRot = 0.2F * Mth.sin(ageInTicks * 0.3F) + 0.4F;
		this.Legbottom9.xRot = 0.2F * Mth.sin(ageInTicks * 0.3F) + 0.4F;
		this.Legbottom10.xRot = 0.2F * Mth.sin(ageInTicks * 0.3F) + 0.4F;
		this.Legbottom11.xRot = 0.2F * Mth.sin(ageInTicks * 0.3F) + 0.4F;
		this.Legbottom12.xRot = 0.2F * Mth.sin(ageInTicks * 0.3F) + 0.4F;
		this.Legbottom13.xRot = 0.2F * Mth.sin(ageInTicks * 0.3F) + 0.4F;
		this.Legbottom14.xRot = 0.2F * Mth.sin(ageInTicks * 0.3F) + 0.4F;
		this.Legbottom15.xRot = 0.2F * Mth.sin(ageInTicks * 0.3F) + 0.4F;
		this.Legbottom16.xRot = 0.2F * Mth.sin(ageInTicks * 0.3F) + 0.4F;
		this.Legbottom17.xRot = 0.2F * Mth.sin(ageInTicks * 0.3F) + 0.4F;
		this.Legbottom18.xRot = 0.2F * Mth.sin(ageInTicks * 0.3F) + 0.4F;
		this.Legbottom19.xRot = 0.2F * Mth.sin(ageInTicks * 0.3F) + 0.4F;
		this.Legbottom20.xRot = 0.2F * Mth.sin(ageInTicks * 0.3F) + 0.4F;
		this.Legbottom21.xRot = 0.2F * Mth.sin(ageInTicks * 0.3F) + 0.4F;
		this.Legbottom22.xRot = 0.2F * Mth.sin(ageInTicks * 0.3F) + 0.4F;
		this.Legbottom23.xRot = 0.2F * Mth.sin(ageInTicks * 0.3F) + 0.4F;
		this.Legbottom24.xRot = 0.2F * Mth.sin(ageInTicks * 0.3F) + 0.4F;
		this.Legbottom25.xRot = 0.2F * Mth.sin(ageInTicks * 0.3F) + 0.4F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		Main_Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Lower_Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Legbottom1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Legbottom2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Legbottom3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Legbottom4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Legbottom5.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Legbottom6.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Legbottom7.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Legbottom8.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Legbottom9.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Legbottom10.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Legbottom11.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Legbottom12.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Legbottom13.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Legbottom14.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Legbottom15.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Legbottom16.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Legbottom17.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Legbottom18.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Legbottom19.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Legbottom20.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Legbottom21.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Legbottom22.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Legbottom23.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Legbottom24.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Legbottom25.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}