package divinerpg.client.models.boss;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.boss.EntityKingOfScorchers;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelKingOfScorchers extends EntityModel<EntityKingOfScorchers> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("king_of_scorchers");
	private final ModelPart part1;
	private final ModelPart part2;
	private final ModelPart part3;
	private final ModelPart part4;
	private final ModelPart part5;
	private final ModelPart part6;
	private final ModelPart part7;
	private final ModelPart part8;
	private final ModelPart part9;
	private final ModelPart part10;
	private final ModelPart part11;
	private final ModelPart part12;
	private final ModelPart part13;
	private final ModelPart part14;
	private final ModelPart part15;
	private final ModelPart part16;
	private final ModelPart part17;
	private final ModelPart part18;
	private final ModelPart part19;
	private final ModelPart part20;
	private final ModelPart part21;
	private final ModelPart part22;
	private final ModelPart part23;
	private final ModelPart part24;
	private final ModelPart part25;
	private final ModelPart part26;
	private final ModelPart part27;
	private final ModelPart part28;
	private final ModelPart part29;
	private final ModelPart part30;
	private final ModelPart part31;
	private final ModelPart part32;
	private final ModelPart part33;
	private final ModelPart part34;
	private final ModelPart part35;
	private final ModelPart part36;
	private final ModelPart part37;
	private final ModelPart part38;
	private final ModelPart part39;
	private final ModelPart part40;

	public ModelKingOfScorchers(ModelPart root) {
		this.part1 = root.getChild("part1");
		this.part2 = root.getChild("part2");
		this.part3 = root.getChild("part3");
		this.part4 = root.getChild("part4");
		this.part5 = root.getChild("part5");
		this.part6 = root.getChild("part6");
		this.part7 = root.getChild("part7");
		this.part8 = root.getChild("part8");
		this.part9 = root.getChild("part9");
		this.part10 = root.getChild("part10");
		this.part11 = root.getChild("part11");
		this.part12 = root.getChild("part12");
		this.part13 = root.getChild("part13");
		this.part14 = root.getChild("part14");
		this.part15 = root.getChild("part15");
		this.part16 = root.getChild("part16");
		this.part17 = root.getChild("part17");
		this.part18 = root.getChild("part18");
		this.part19 = root.getChild("part19");
		this.part20 = root.getChild("part20");
		this.part21 = root.getChild("part21");
		this.part22 = root.getChild("part22");
		this.part23 = root.getChild("part23");
		this.part24 = root.getChild("part24");
		this.part25 = root.getChild("part25");
		this.part26 = root.getChild("part26");
		this.part27 = root.getChild("part27");
		this.part28 = root.getChild("part28");
		this.part29 = root.getChild("part29");
		this.part30 = root.getChild("part30");
		this.part31 = root.getChild("part31");
		this.part32 = root.getChild("part32");
		this.part33 = root.getChild("part33");
		this.part34 = root.getChild("part34");
		this.part35 = root.getChild("part35");
		this.part36 = root.getChild("part36");
		this.part37 = root.getChild("part37");
		this.part38 = root.getChild("part38");
		this.part39 = root.getChild("part39");
		this.part40 = root.getChild("part40");
	}
	public ModelKingOfScorchers(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.part1 = root.getChild("part1");
		this.part2 = root.getChild("part2");
		this.part3 = root.getChild("part3");
		this.part4 = root.getChild("part4");
		this.part5 = root.getChild("part5");
		this.part6 = root.getChild("part6");
		this.part7 = root.getChild("part7");
		this.part8 = root.getChild("part8");
		this.part9 = root.getChild("part9");
		this.part10 = root.getChild("part10");
		this.part11 = root.getChild("part11");
		this.part12 = root.getChild("part12");
		this.part13 = root.getChild("part13");
		this.part14 = root.getChild("part14");
		this.part15 = root.getChild("part15");
		this.part16 = root.getChild("part16");
		this.part17 = root.getChild("part17");
		this.part18 = root.getChild("part18");
		this.part19 = root.getChild("part19");
		this.part20 = root.getChild("part20");
		this.part21 = root.getChild("part21");
		this.part22 = root.getChild("part22");
		this.part23 = root.getChild("part23");
		this.part24 = root.getChild("part24");
		this.part25 = root.getChild("part25");
		this.part26 = root.getChild("part26");
		this.part27 = root.getChild("part27");
		this.part28 = root.getChild("part28");
		this.part29 = root.getChild("part29");
		this.part30 = root.getChild("part30");
		this.part31 = root.getChild("part31");
		this.part32 = root.getChild("part32");
		this.part33 = root.getChild("part33");
		this.part34 = root.getChild("part34");
		this.part35 = root.getChild("part35");
		this.part36 = root.getChild("part36");
		this.part37 = root.getChild("part37");
		this.part38 = root.getChild("part38");
		this.part39 = root.getChild("part39");
		this.part40 = root.getChild("part40");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("part1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, -2.0F, -5.0F));

		partdefinition.addOrReplaceChild("part2", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, -15.0F, -4.0F));

		partdefinition.addOrReplaceChild("part3", CubeListBuilder.create().texOffs(0, 48).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-14.0F, 19.0F, -2.0F));

		partdefinition.addOrReplaceChild("part4", CubeListBuilder.create().texOffs(0, 48).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 3.0F, -2.0F));

		partdefinition.addOrReplaceChild("part5", CubeListBuilder.create().texOffs(0, 48).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-25.0F, 19.0F, -2.0F, 0.0F, 0.0F, -1.5708F));

		partdefinition.addOrReplaceChild("part6", CubeListBuilder.create().texOffs(0, 48).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(23.0F, 19.0F, -2.0F, 0.0F, 0.0F, -1.5708F));

		partdefinition.addOrReplaceChild("part7", CubeListBuilder.create().texOffs(0, 48).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, -7.0F, -1.0F));

		partdefinition.addOrReplaceChild("part8", CubeListBuilder.create().texOffs(0, 48).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.0F, -13.0F, -1.0F, 0.0F, 0.0F, -1.5708F));

		partdefinition.addOrReplaceChild("part9", CubeListBuilder.create().texOffs(0, 48).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-13.0F, 9.0F, -1.0F));

		partdefinition.addOrReplaceChild("part10", CubeListBuilder.create().texOffs(0, 48).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.0F, -13.0F, -1.0F, 0.0F, 0.0F, -1.5708F));

		partdefinition.addOrReplaceChild("part11", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-8.0F, -8.0F, -4.0F));

		partdefinition.addOrReplaceChild("part12", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, -2.0F, -5.0F));

		partdefinition.addOrReplaceChild("part13", CubeListBuilder.create().texOffs(0, 48).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-25.0F, 19.0F, -2.0F));

		partdefinition.addOrReplaceChild("part14", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-20.0F, 14.0F, -5.0F));

		partdefinition.addOrReplaceChild("part15", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-19.0F, 8.0F, -4.0F));

		partdefinition.addOrReplaceChild("part16", CubeListBuilder.create().texOffs(0, 48).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-8.0F, -13.0F, -1.0F));

		partdefinition.addOrReplaceChild("part17", CubeListBuilder.create().texOffs(0, 48).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(19.0F, 19.0F, -2.0F));

		partdefinition.addOrReplaceChild("part18", CubeListBuilder.create().texOffs(0, 48).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -13.0F, -1.0F));

		partdefinition.addOrReplaceChild("part19", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(13.0F, 8.0F, -4.0F));

		partdefinition.addOrReplaceChild("part20", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(12.0F, 14.0F, -5.0F));

		partdefinition.addOrReplaceChild("part21", CubeListBuilder.create().texOffs(0, 48).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(7.0F, 9.0F, -1.0F));

		partdefinition.addOrReplaceChild("part22", CubeListBuilder.create().texOffs(0, 48).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(8.0F, 19.0F, -2.0F));

		partdefinition.addOrReplaceChild("part23", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, 14.0F, -5.0F));

		partdefinition.addOrReplaceChild("part24", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, 14.0F, -5.0F));

		partdefinition.addOrReplaceChild("part25", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-8.0F, 8.0F, -4.0F));

		partdefinition.addOrReplaceChild("part26", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 8.0F, -4.0F));

		partdefinition.addOrReplaceChild("part27", CubeListBuilder.create().texOffs(0, 48).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -7.0F, -1.0F, 0.0F, 0.0F, -1.5708F));

		partdefinition.addOrReplaceChild("part28", CubeListBuilder.create().texOffs(0, 48).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 19.0F, -2.0F));

		partdefinition.addOrReplaceChild("part29", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -8.0F, -4.0F));

		partdefinition.addOrReplaceChild("part30", CubeListBuilder.create().texOffs(0, 48).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 9.0F, -1.0F));

		partdefinition.addOrReplaceChild("part31", CubeListBuilder.create().texOffs(0, 48).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.0F, 9.0F, -1.0F, 0.0F, 0.0F, -1.5708F));

		partdefinition.addOrReplaceChild("part32", CubeListBuilder.create().texOffs(0, 48).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 9.0F, -1.0F, 0.0F, 0.0F, -1.5708F));

		partdefinition.addOrReplaceChild("part33", CubeListBuilder.create().texOffs(0, 48).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-24.0F, 9.0F, -1.0F));

		partdefinition.addOrReplaceChild("part34", CubeListBuilder.create().texOffs(0, 48).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-24.0F, 9.0F, -1.0F, 0.0F, 0.0F, -1.5708F));

		partdefinition.addOrReplaceChild("part35", CubeListBuilder.create().texOffs(0, 48).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-14.0F, -7.0F, -1.0F));

		partdefinition.addOrReplaceChild("part36", CubeListBuilder.create().texOffs(0, 48).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-14.0F, -7.0F, -1.0F, 0.0F, 0.0F, -1.5708F));

		partdefinition.addOrReplaceChild("part37", CubeListBuilder.create().texOffs(0, 48).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(18.0F, 9.0F, -1.0F));

		partdefinition.addOrReplaceChild("part38", CubeListBuilder.create().texOffs(0, 48).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(22.0F, 9.0F, -1.0F, 0.0F, 0.0F, -1.5708F));

		partdefinition.addOrReplaceChild("part39", CubeListBuilder.create().texOffs(0, 48).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(8.0F, -7.0F, -1.0F));

		partdefinition.addOrReplaceChild("part40", CubeListBuilder.create().texOffs(0, 48).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(12.0F, -7.0F, -1.0F, 0.0F, 0.0F, -1.5708F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(EntityKingOfScorchers entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		part1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part9.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part10.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part11.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part12.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part13.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part14.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part15.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part16.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part17.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part18.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part19.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part20.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part21.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part22.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part23.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part24.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part25.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part26.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part27.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part28.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part29.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part30.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part31.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part32.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part33.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part34.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part35.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part36.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part37.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part38.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part39.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part40.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}