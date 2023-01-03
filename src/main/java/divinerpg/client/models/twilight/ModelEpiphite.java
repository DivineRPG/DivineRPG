package divinerpg.client.models.twilight;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;


public class ModelEpiphite<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("epiphite");
	private final ModelPart leg1;
	private final ModelPart foot1;
	private final ModelPart leg2;
	private final ModelPart foot2;
	private final ModelPart foot3;
	private final ModelPart leg3;
	private final ModelPart leg4;
	private final ModelPart foot4;
	private final ModelPart body;
	private final ModelPart neck;
	private final ModelPart spike1;
	private final ModelPart spike2;
	private final ModelPart spike3;
	private final ModelPart spike4;
	private final ModelPart spike5;
	private final ModelPart spike6;
	private final ModelPart spike7;
	private final ModelPart spike8;
	private final ModelPart spike9;
	private final ModelPart spike10;
	private final ModelPart head;
	private final ModelPart spike11;
	private final ModelPart spike12;
	private final ModelPart spike13;
	private final ModelPart spike14;
	private final ModelPart spike15;
	private final ModelPart spike16;
	private final ModelPart spike17;
	private final ModelPart spike18;
	private final ModelPart tooth1;
	private final ModelPart tooth2;
	private final ModelPart tooth3;
	private final ModelPart tooth4;
	private final ModelPart spike19;
	private final ModelPart spike20;
	private final ModelPart spike21;
	private final ModelPart side1;
	private final ModelPart side2;
	private final ModelPart side3;
	private final ModelPart side4;
	private final ModelPart side5;
	private final ModelPart side6;
	private final ModelPart side7;
	private final ModelPart side8;
	private final ModelPart tail1;
	private final ModelPart tail2;

	public ModelEpiphite(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.leg1 = root.getChild("leg1");
		this.foot1 = root.getChild("foot1");
		this.leg2 = root.getChild("leg2");
		this.foot2 = root.getChild("foot2");
		this.foot3 = root.getChild("foot3");
		this.leg3 = root.getChild("leg3");
		this.leg4 = root.getChild("leg4");
		this.foot4 = root.getChild("foot4");
		this.body = root.getChild("body");
		this.neck = root.getChild("neck");
		this.spike1 = root.getChild("spike1");
		this.spike2 = root.getChild("spike2");
		this.spike3 = root.getChild("spike3");
		this.spike4 = root.getChild("spike4");
		this.spike5 = root.getChild("spike5");
		this.spike6 = root.getChild("spike6");
		this.spike7 = root.getChild("spike7");
		this.spike8 = root.getChild("spike8");
		this.spike9 = root.getChild("spike9");
		this.spike10 = root.getChild("spike10");
		this.head = root.getChild("head");
		this.spike11 = root.getChild("spike11");
		this.spike12 = root.getChild("spike12");
		this.spike13 = root.getChild("spike13");
		this.spike14 = root.getChild("spike14");
		this.spike15 = root.getChild("spike15");
		this.spike16 = root.getChild("spike16");
		this.spike17 = root.getChild("spike17");
		this.spike18 = root.getChild("spike18");
		this.tooth1 = root.getChild("tooth1");
		this.tooth2 = root.getChild("tooth2");
		this.tooth3 = root.getChild("tooth3");
		this.tooth4 = root.getChild("tooth4");
		this.spike19 = root.getChild("spike19");
		this.spike20 = root.getChild("spike20");
		this.spike21 = root.getChild("spike21");
		this.side1 = root.getChild("side1");
		this.side2 = root.getChild("side2");
		this.side3 = root.getChild("side3");
		this.side4 = root.getChild("side4");
		this.side5 = root.getChild("side5");
		this.side6 = root.getChild("side6");
		this.side7 = root.getChild("side7");
		this.side8 = root.getChild("side8");
		this.tail1 = root.getChild("tail1");
		this.tail2 = root.getChild("tail2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 20.0F, 5.0F));

		partdefinition.addOrReplaceChild("foot1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.0F, 3.0F, -2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 20.0F, 5.0F));

		partdefinition.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 20.0F, 5.0F));

		partdefinition.addOrReplaceChild("foot2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.0F, 3.0F, -2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 20.0F, 5.0F));

		partdefinition.addOrReplaceChild("foot3", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.0F, 3.0F, -2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 20.0F, -6.0F));

		partdefinition.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 20.0F, -6.0F));

		partdefinition.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 20.0F, -6.0F));

		partdefinition.addOrReplaceChild("foot4", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.0F, 3.0F, -2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 20.0F, -6.0F));

		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 12).mirror().addBox(0.0F, 0.0F, 0.0F, 8.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 16.0F, -8.0F));

		partdefinition.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(-1.0F, -6.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 17.0F, -7.0F, 0.4363F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spike1", CubeListBuilder.create().texOffs(60, 0).mirror().addBox(0.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, 16.0F, -5.0F, -0.8727F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spike2", CubeListBuilder.create().texOffs(60, 0).mirror().addBox(0.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 16.0F, -3.0F, -0.8727F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spike3", CubeListBuilder.create().texOffs(60, 0).mirror().addBox(0.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 16.0F, -5.0F, -0.8727F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spike4", CubeListBuilder.create().texOffs(60, 0).mirror().addBox(0.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.5F, 16.0F, -3.0F, -0.8727F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spike5", CubeListBuilder.create().texOffs(60, 0).mirror().addBox(0.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.5F, 16.0F, -3.0F, -0.8727F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spike6", CubeListBuilder.create().texOffs(60, 0).mirror().addBox(0.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, 16.0F, -1.0F, -0.8727F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spike7", CubeListBuilder.create().texOffs(60, 0).mirror().addBox(0.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.5F, 16.0F, -5.0F, -0.8727F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spike8", CubeListBuilder.create().texOffs(60, 0).mirror().addBox(0.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.5F, 16.0F, -1.0F, -0.8727F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spike9", CubeListBuilder.create().texOffs(60, 0).mirror().addBox(0.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 16.0F, -1.0F, -0.8727F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spike10", CubeListBuilder.create().texOffs(60, 0).mirror().addBox(0.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.5F, 16.0F, -1.0F, -0.8727F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-3.0F, -10.0F, -5.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 17.0F, -7.0F));

		partdefinition.addOrReplaceChild("spike11", CubeListBuilder.create().texOffs(60, 0).mirror().addBox(0.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.5F, 16.0F, -5.0F, -0.8727F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spike12", CubeListBuilder.create().texOffs(60, 0).mirror().addBox(0.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 16.0F, 1.0F, -0.8727F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spike13", CubeListBuilder.create().texOffs(60, 0).mirror().addBox(0.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.5F, 16.0F, 1.0F, -0.8727F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spike14", CubeListBuilder.create().texOffs(60, 0).mirror().addBox(0.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.5F, 16.0F, 1.0F, -0.8727F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spike15", CubeListBuilder.create().texOffs(60, 0).mirror().addBox(0.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, 16.0F, 3.0F, -0.8727F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spike16", CubeListBuilder.create().texOffs(60, 0).mirror().addBox(0.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 16.0F, 3.0F, -0.8727F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spike17", CubeListBuilder.create().texOffs(60, 0).mirror().addBox(0.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.5F, 16.0F, 3.0F, -0.8727F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spike18", CubeListBuilder.create().texOffs(60, 0).mirror().addBox(0.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.5F, 16.0F, 3.0F, -0.8727F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("tooth1", CubeListBuilder.create().texOffs(0, 3).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, 13.0F, -12.0F));

		partdefinition.addOrReplaceChild("tooth2", CubeListBuilder.create().texOffs(0, 3).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 13.0F, -12.0F));

		partdefinition.addOrReplaceChild("tooth3", CubeListBuilder.create().texOffs(0, 3).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 13.0F, -10.0F));

		partdefinition.addOrReplaceChild("tooth4", CubeListBuilder.create().texOffs(0, 3).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 13.0F, -10.0F));

		partdefinition.addOrReplaceChild("spike19", CubeListBuilder.create().texOffs(60, 0).mirror().addBox(0.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 16.0F, 5.0F, -0.8727F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spike20", CubeListBuilder.create().texOffs(60, 0).mirror().addBox(0.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.5F, 16.0F, 5.0F, -0.8727F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spike21", CubeListBuilder.create().texOffs(60, 0).mirror().addBox(0.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.5F, 16.0F, 5.0F, -0.8727F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("side1", CubeListBuilder.create().texOffs(14, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 17.0F, -5.0F, 0.0F, -0.5236F, 0.0F));

		partdefinition.addOrReplaceChild("side2", CubeListBuilder.create().texOffs(14, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 17.0F, -2.0F, 0.0F, -0.5236F, 0.0F));

		partdefinition.addOrReplaceChild("side3", CubeListBuilder.create().texOffs(14, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 17.0F, 1.0F, 0.0F, -0.5236F, 0.0F));

		partdefinition.addOrReplaceChild("side4", CubeListBuilder.create().texOffs(14, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 17.0F, 4.0F, 0.0F, -0.5236F, 0.0F));

		partdefinition.addOrReplaceChild("side5", CubeListBuilder.create().texOffs(14, 0).mirror().addBox(-1.0F, 0.0F, 0.0F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 17.0F, -5.0F, 0.0F, 0.5236F, 0.0F));

		partdefinition.addOrReplaceChild("side6", CubeListBuilder.create().texOffs(14, 0).mirror().addBox(-1.0F, 0.0F, 0.0F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 17.0F, -2.0F, 0.0F, 0.5236F, 0.0F));

		partdefinition.addOrReplaceChild("side7", CubeListBuilder.create().texOffs(14, 0).mirror().addBox(-1.0F, 0.0F, 0.0F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 17.0F, 1.0F, 0.0F, 0.5236F, 0.0F));

		partdefinition.addOrReplaceChild("side8", CubeListBuilder.create().texOffs(14, 0).mirror().addBox(-1.0F, 0.0F, 0.0F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 17.0F, 4.0F, 0.0F, 0.5236F, 0.0F));

		partdefinition.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(14, 0).mirror().addBox(-1.0F, 0.0F, 0.0F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 17.0F, 7.0F, 0.0F, 0.2618F, 0.0F));

		partdefinition.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(14, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 17.0F, 7.0F, 0.0F, -0.2618F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.leg1.xRot = this.leg4.xRot = this.foot1.xRot = this.foot4.xRot = (float) Math.sin(limbSwing/2)*limbSwingAmount*1.3f;
		this.leg2.xRot = this.leg3.xRot = this.foot2.xRot = this.foot3.xRot = (float) Math.cos(limbSwing/2)*limbSwingAmount*1.3f;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		foot1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		foot2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		foot3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		foot4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		neck.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		spike1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		spike2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		spike3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		spike4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		spike5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		spike6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		spike7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		spike8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		spike9.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		spike10.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		spike11.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		spike12.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		spike13.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		spike14.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		spike15.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		spike16.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		spike17.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		spike18.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tooth1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tooth2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tooth3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tooth4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		spike19.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		spike20.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		spike21.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		side1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		side2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		side3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		side4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		side5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		side6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		side7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		side8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tail1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tail2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}