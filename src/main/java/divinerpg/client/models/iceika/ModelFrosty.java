package divinerpg.client.models.iceika;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.iceika.EntityFrosty;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelFrosty extends EntityModel<EntityFrosty> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("frosty");
	private final ModelPart hatBase;
	private final ModelPart bottom;
	private final ModelPart rightFinger1;
	private final ModelPart middle;
	private final ModelPart rightArm;
	private final ModelPart leftArm;
	private final ModelPart rightFinger3;
	private final ModelPart rightFinger2;
	private final ModelPart leftFinger2;
	private final ModelPart leftFinger3;
	private final ModelPart leftFinger1;
	private final ModelPart hatTop;
	private final ModelPart head;

	public ModelFrosty(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.hatBase = root.getChild("hatBase");
		this.bottom = root.getChild("bottom");
		this.rightFinger1 = root.getChild("rightFinger1");
		this.middle = root.getChild("middle");
		this.rightArm = root.getChild("rightArm");
		this.leftArm = root.getChild("leftArm");
		this.rightFinger3 = root.getChild("rightFinger3");
		this.rightFinger2 = root.getChild("rightFinger2");
		this.leftFinger2 = root.getChild("leftFinger2");
		this.leftFinger3 = root.getChild("leftFinger3");
		this.leftFinger1 = root.getChild("leftFinger1");
		this.hatTop = root.getChild("hatTop");
		this.head = root.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("hatBase", CubeListBuilder.create().texOffs(105, 18).mirror().addBox(0.0F, 0.0F, 0.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.0F, -10.0F, -6.0F));

		partdefinition.addOrReplaceChild("bottom", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 16.0F, 13.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-8.0F, 11.0F, -8.0F));

		partdefinition.addOrReplaceChild("rightFinger1", CubeListBuilder.create().texOffs(51, 0).mirror().addBox(-1.0F, 7.0F, -16.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 2.0F, 3.0F, -0.2093F, 0.6579F, 0.0F));

		partdefinition.addOrReplaceChild("middle", CubeListBuilder.create().texOffs(159, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 12.0F, 13.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.0F, 1.0F, -6.0F));

		partdefinition.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(66, 0).mirror().addBox(0.0F, 0.0F, -12.0F, 2.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.0F, 2.0F, 2.0F, 0.3491F, 0.7854F, 0.0F));

		partdefinition.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(66, 0).mirror().addBox(0.0F, 0.0F, -12.0F, 2.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0F, 2.0F, 2.0F, 0.3491F, -0.7854F, 0.0F));

		partdefinition.addOrReplaceChild("rightFinger3", CubeListBuilder.create().texOffs(51, 0).mirror().addBox(4.0F, -2.0F, -15.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 2.0F, 3.0F, 0.6458F, 1.1784F, 0.0F));

		partdefinition.addOrReplaceChild("rightFinger2", CubeListBuilder.create().texOffs(51, 0).mirror().addBox(-5.0F, -6.0F, -17.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 2.0F, 3.0F, 0.7945F, 0.3232F, 0.0F));

		partdefinition.addOrReplaceChild("leftFinger2", CubeListBuilder.create().texOffs(51, 0).mirror().addBox(-2.0F, -6.0F, -17.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 2.0F, 3.0F, 0.7945F, -1.0296F, 0.0F));

		partdefinition.addOrReplaceChild("leftFinger3", CubeListBuilder.create().texOffs(51, 0).mirror().addBox(7.0F, -2.0F, -15.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 2.0F, 3.0F, 0.6458F, -0.1745F, 0.0F));

		partdefinition.addOrReplaceChild("leftFinger1", CubeListBuilder.create().texOffs(51, 0).mirror().addBox(2.0F, 7.0F, -16.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 2.0F, 3.0F, -0.2093F, -0.695F, 0.0F));

		partdefinition.addOrReplaceChild("hatTop", CubeListBuilder.create().texOffs(65, 17).mirror().addBox(0.0F, 0.0F, 0.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, -17.0F, -4.0F));

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(96, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 8.0F, 9.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, -8.0F, -4.0F));

		return LayerDefinition.create(meshdefinition, 256, 32);
	}

	@Override
	public void setupAnim(EntityFrosty entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		hatBase.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bottom.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightFinger1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		middle.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightFinger3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightFinger2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftFinger2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftFinger3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftFinger1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		hatTop.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}