package divinerpg.client.models.boss;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelTermasect<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("termasect");
	private final ModelPart base1;
	private final ModelPart base2;
	private final ModelPart base3;
	private final ModelPart body;
	private final ModelPart headR;
	private final ModelPart headL;
	private final ModelPart neck;
	private final ModelPart headMid;
	private final ModelPart slab1;
	private final ModelPart slab2;
	private final ModelPart slab3;
	private final ModelPart slab4;
	private final ModelPart armRa;
	private final ModelPart armLa;
	private final ModelPart armRb;
	private final ModelPart armLb;
	private final ModelPart armRc;
	private final ModelPart armRc2;

	public ModelTermasect(ModelPart root) {
		this.base1 = root.getChild("base1");
		this.base2 = root.getChild("base2");
		this.base3 = root.getChild("base3");
		this.body = root.getChild("body");
		this.headR = root.getChild("headR");
		this.headL = root.getChild("headL");
		this.neck = root.getChild("neck");
		this.headMid = root.getChild("headMid");
		this.slab1 = root.getChild("slab1");
		this.slab2 = root.getChild("slab2");
		this.slab3 = root.getChild("slab3");
		this.slab4 = root.getChild("slab4");
		this.armRa = root.getChild("armRa");
		this.armLa = root.getChild("armLa");
		this.armRb = root.getChild("armRb");
		this.armLb = root.getChild("armLb");
		this.armRc = root.getChild("armRc");
		this.armRc2 = root.getChild("armRc2");
	}

	public ModelTermasect(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.base1 = root.getChild("base1");
		this.base2 = root.getChild("base2");
		this.base3 = root.getChild("base3");
		this.body = root.getChild("body");
		this.headR = root.getChild("headR");
		this.headL = root.getChild("headL");
		this.neck = root.getChild("neck");
		this.headMid = root.getChild("headMid");
		this.slab1 = root.getChild("slab1");
		this.slab2 = root.getChild("slab2");
		this.slab3 = root.getChild("slab3");
		this.slab4 = root.getChild("slab4");
		this.armRa = root.getChild("armRa");
		this.armLa = root.getChild("armLa");
		this.armRb = root.getChild("armRb");
		this.armLb = root.getChild("armLb");
		this.armRc = root.getChild("armRc");
		this.armRc2 = root.getChild("armRc2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("base1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 20.0F, 0.0F));

		partdefinition.addOrReplaceChild("base2", CubeListBuilder.create().texOffs(0, 7).mirror().addBox(-5.0F, 0.0F, -5.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 16.0F, 0.0F));

		partdefinition.addOrReplaceChild("base3", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-7.0F, 0.0F, -7.0F, 14.0F, 1.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(56, 0).mirror().addBox(-6.0F, 0.0F, -6.0F, 12.0F, 24.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -15.0F, 0.0F));

		partdefinition.addOrReplaceChild("headR", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-3.0F, -6.0F, -5.0F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, -12.0F, -3.0F));

		partdefinition.addOrReplaceChild("headL", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-3.0F, -6.0F, -5.0F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, -12.0F, -3.0F));

		partdefinition.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 44).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -21.0F, 0.0F));

		partdefinition.addOrReplaceChild("headMid", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-3.0F, -6.0F, -5.0F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -19.0F, 0.0F));

		partdefinition.addOrReplaceChild("slab1", CubeListBuilder.create().texOffs(0, 52).mirror().addBox(-8.0F, 0.0F, -8.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 5.0F, 0.0F));

		partdefinition.addOrReplaceChild("slab2", CubeListBuilder.create().texOffs(0, 52).mirror().addBox(-8.0F, 0.0F, -8.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 1.0F, 0.0F));

		partdefinition.addOrReplaceChild("slab3", CubeListBuilder.create().texOffs(0, 52).mirror().addBox(-8.0F, 0.0F, -8.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -3.0F, 0.0F));

		partdefinition.addOrReplaceChild("slab4", CubeListBuilder.create().texOffs(0, 52).mirror().addBox(-8.0F, 0.0F, -8.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -7.0F, 0.0F));

		partdefinition.addOrReplaceChild("armRa", CubeListBuilder.create().texOffs(0, 70).mirror().addBox(-2.0F, -0.5F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, -13.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		partdefinition.addOrReplaceChild("armLa", CubeListBuilder.create().texOffs(0, 70).mirror().addBox(-2.0F, -0.5F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0F, -13.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		partdefinition.addOrReplaceChild("armRb", CubeListBuilder.create().texOffs(16, 70).mirror().addBox(-2.0F, 9.5F, -10.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, -13.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		partdefinition.addOrReplaceChild("armLb", CubeListBuilder.create().texOffs(16, 70).mirror().addBox(-2.0F, 9.5F, -10.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0F, -13.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		partdefinition.addOrReplaceChild("armRc", CubeListBuilder.create().texOffs(40, 70).mirror().addBox(-1.0F, 10.5F, -16.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, -13.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		partdefinition.addOrReplaceChild("armRc2", CubeListBuilder.create().texOffs(40, 70).mirror().addBox(-1.0F, 10.5F, -16.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0F, -13.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		base1.yRot = limbSwing % 1F;
		base2.yRot = limbSwing % 2F;
		base3.yRot = limbSwing % 3F;
		headL.yRot = netHeadYaw / (180F / (float) Math.PI);
		headL.xRot = headPitch / (180F / (float) Math.PI);
		headMid.yRot = netHeadYaw / (180F / (float) Math.PI);
		headMid.xRot = headPitch / (180F / (float) Math.PI);
		headR.yRot = netHeadYaw / (180F / (float) Math.PI);
		headR.xRot = headPitch / (180F / (float) Math.PI);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		base1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		base2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		base3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		headR.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		headL.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		neck.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		headMid.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		slab1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		slab2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		slab3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		slab4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		armRa.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		armLa.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		armRb.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		armLb.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		armRc.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		armRc2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}