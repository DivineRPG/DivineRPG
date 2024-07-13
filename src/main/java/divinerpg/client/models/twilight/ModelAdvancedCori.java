package divinerpg.client.models.twilight;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelAdvancedCori<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("advanced_cori");
	private final ModelPart Head;
	private final ModelPart Tentacle1;
	private final ModelPart Tentacle2;
	private final ModelPart Tentacle3;
	private final ModelPart Tentacle4;
	private final ModelPart Tentacle5;
	private final ModelPart Tentacle6;
	private final ModelPart Tentacle7;
	private final ModelPart Tentacle8;
	private final ModelPart Tentacle9;
	private final ModelPart Tentacle10;
	private final ModelPart Tentacle11;
	private final ModelPart Tentacle12;
	private final ModelPart Tentacle13;
	private final ModelPart Tentacle14;
	private final ModelPart Tentacle15;
	private final ModelPart Tentacle16;
	private final ModelPart Tentacle17;
	private final ModelPart Tentacle18;
	private final ModelPart Tentacle19;
	private final ModelPart Tentacle20;

	public ModelAdvancedCori(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Head = root.getChild("Head");
		this.Tentacle1 = root.getChild("Tentacle1");
		this.Tentacle2 = root.getChild("Tentacle2");
		this.Tentacle3 = root.getChild("Tentacle3");
		this.Tentacle4 = root.getChild("Tentacle4");
		this.Tentacle5 = root.getChild("Tentacle5");
		this.Tentacle6 = root.getChild("Tentacle6");
		this.Tentacle7 = root.getChild("Tentacle7");
		this.Tentacle8 = root.getChild("Tentacle8");
		this.Tentacle9 = root.getChild("Tentacle9");
		this.Tentacle10 = root.getChild("Tentacle10");
		this.Tentacle11 = root.getChild("Tentacle11");
		this.Tentacle12 = root.getChild("Tentacle12");
		this.Tentacle13 = root.getChild("Tentacle13");
		this.Tentacle14 = root.getChild("Tentacle14");
		this.Tentacle15 = root.getChild("Tentacle15");
		this.Tentacle16 = root.getChild("Tentacle16");
		this.Tentacle17 = root.getChild("Tentacle17");
		this.Tentacle18 = root.getChild("Tentacle18");
		this.Tentacle19 = root.getChild("Tentacle19");
		this.Tentacle20 = root.getChild("Tentacle20");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 11.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle1", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0F, 2.0F, 5.0F, 0.0F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle2", CubeListBuilder.create().texOffs(52, 0).mirror().addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 19.0F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle3", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 20.0F, -3.0F, 0.0F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle4", CubeListBuilder.create().texOffs(11, 0).mirror().addBox(-1.0F, -3.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(6.0F, 17.0F, 5.0F));

		partdefinition.addOrReplaceChild("Tentacle5", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 2.0F, -3.0F, 0.0F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle6", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, 11.0F, -3.0F, 0.0F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle7", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.0F, 11.0F, -3.0F, 0.0F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle8", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 2.0F, 5.0F, 0.0F, 4.7124F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle9", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.0F, 2.0F, 2.0F, 0.0F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle10", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.0F, 20.0F, 2.0F, 0.0F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle11", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, 20.0F, 2.0F, 0.0F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle12", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, 2.0F, 2.0F, 0.0F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle13", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 11.0F, 0.0F, 0.0F, 4.7124F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle14", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0F, 11.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle15", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 20.0F, 5.0F, 0.0F, 4.7124F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle16", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0F, 20.0F, 5.0F, 0.0F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle17", CubeListBuilder.create().texOffs(52, 0).mirror().addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 6.0F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle18", CubeListBuilder.create().texOffs(11, 0).mirror().addBox(-1.0F, -3.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.0F, 17.0F, 5.0F));

		partdefinition.addOrReplaceChild("Tentacle19", CubeListBuilder.create().texOffs(11, 0).mirror().addBox(-1.0F, -3.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(6.0F, 6.0F, 5.0F));

		partdefinition.addOrReplaceChild("Tentacle20", CubeListBuilder.create().texOffs(11, 0).mirror().addBox(-1.0F, -3.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.0F, 6.0F, 5.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Tentacle1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Tentacle2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Tentacle3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Tentacle4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Tentacle5.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Tentacle6.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Tentacle7.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Tentacle8.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Tentacle9.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Tentacle10.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Tentacle11.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Tentacle12.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Tentacle13.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Tentacle14.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Tentacle15.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Tentacle16.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Tentacle17.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Tentacle18.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Tentacle19.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Tentacle20.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}