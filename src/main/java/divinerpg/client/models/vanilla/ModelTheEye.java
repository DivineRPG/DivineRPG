package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.vanilla.overworld.EntityTheEye;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelTheEye extends EntityModel<EntityTheEye> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("the_eye");
	private final ModelPart head, body, rightfrontleg, rightbackleg, leftfrontleg, leftbackleg;

	public ModelTheEye(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.rightfrontleg = root.getChild("rightfrontleg");
		this.rightbackleg = root.getChild("rightbackleg");
		this.leftfrontleg = root.getChild("leftfrontleg");
		this.leftbackleg = root.getChild("leftbackleg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubedef = new CubeDeformation(0F);

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -9.0F, -4.0F, 8.0F, 8.0F, 8.0F, cubedef).mirror(false), PartPose.offset(0.0F, 1.0F, 0.0F));

		head.addOrReplaceChild("ear1_r1", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(4.0F, -3.0F, 4.0F, 1.0F, 2.0F, 7.0F, cubedef).mirror(false)
		.texOffs(0, 22).mirror().addBox(-5.0F, -3.0F, 4.0F, 1.0F, 2.0F, 7.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

		head.addOrReplaceChild("ear4_r1", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-5.0F, -6.0F, 5.0F, 1.0F, 2.0F, 7.0F, cubedef).mirror(false)
		.texOffs(0, 22).mirror().addBox(4.0F, -6.0F, 5.0F, 1.0F, 2.0F, 7.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.6981F, 0.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(32, 12).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 8.0F, cubedef).mirror(false)
		.texOffs(32, 12).mirror().addBox(-4.0F, 0.0F, 6.0F, 8.0F, 12.0F, 8.0F, cubedef).mirror(false)
		.texOffs(32, 12).mirror().addBox(4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 8.0F, cubedef).mirror(false)
		.texOffs(32, 12).mirror().addBox(4.0F, 0.0F, 6.0F, 8.0F, 12.0F, 8.0F, cubedef).mirror(false)
		.texOffs(48, 0).mirror().addBox(11.0F, 8.5F, 12.0F, 4.0F, 4.0F, 4.0F, cubedef).mirror(false)
		.texOffs(48, 0).mirror().addBox(11.0F, 8.5F, -4.0F, 4.0F, 4.0F, 4.0F, cubedef).mirror(false)
		.texOffs(48, 0).mirror().addBox(-6.0F, 8.5F, 12.0F, 4.0F, 4.0F, 4.0F, cubedef).mirror(false)
		.texOffs(48, 0).mirror().addBox(-6.0F, 8.5F, -4.0F, 4.0F, 4.0F, 4.0F, cubedef).mirror(false), PartPose.offset(-4.0F, 0.0F, -6.0F));

		body.addOrReplaceChild("ext4_r1", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-2.0F, -1.0F, -5.0F, 4.0F, 2.0F, 8.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-6.0F, 11.0F, -4.0F, 0.0F, 0.7854F, 0.0F));

		body.addOrReplaceChild("ext3_r1", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-2.0F, -1.0F, -5.0F, 4.0F, 2.0F, 8.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-7.0F, 11.0F, 17.0F, 0.0F, -0.7854F, 0.0F));

		body.addOrReplaceChild("ext2_r1", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-2.0F, -1.0F, -5.0F, 4.0F, 2.0F, 8.0F, cubedef).mirror(false), PartPose.offsetAndRotation(15.0F, 11.0F, -4.0F, 0.0F, -0.7854F, 0.0F));

		body.addOrReplaceChild("ext1_r1", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-2.0F, 0.0F, -5.0F, 4.0F, 2.0F, 8.0F, cubedef).mirror(false), PartPose.offsetAndRotation(16.0F, 10.0F, 17.0F, 0.0F, 0.7854F, 0.0F));

		partdefinition.addOrReplaceChild("rightfrontleg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, cubedef).mirror(false)
		.texOffs(48, 0).mirror().addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, cubedef).mirror(false)
		.texOffs(0, 24).mirror().addBox(-3.0F, 10.0F, -3.0F, 6.0F, 2.0F, 6.0F, cubedef).mirror(false), PartPose.offset(-13.0F, 12.0F, -13.0F));

		partdefinition.addOrReplaceChild("rightbackleg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, cubedef).mirror(false)
		.texOffs(48, 0).mirror().addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, cubedef).mirror(false)
		.texOffs(0, 24).mirror().addBox(-3.0F, 10.0F, -3.0F, 6.0F, 2.0F, 6.0F, cubedef).mirror(false), PartPose.offset(-13.0F, 12.0F, 13.0F));

		partdefinition.addOrReplaceChild("leftfrontleg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, cubedef).mirror(false)
		.texOffs(48, 0).mirror().addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, cubedef).mirror(false)
		.texOffs(0, 24).mirror().addBox(-3.0F, 10.0F, -3.0F, 6.0F, 2.0F, 6.0F, cubedef).mirror(false), PartPose.offset(14.0F, 12.0F, -13.0F));

		partdefinition.addOrReplaceChild("leftbackleg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, cubedef).mirror(false)
		.texOffs(48, 0).mirror().addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, cubedef).mirror(false)
		.texOffs(0, 24).mirror().addBox(-3.0F, 10.0F, -3.0F, 6.0F, 2.0F, 6.0F, cubedef).mirror(false), PartPose.offset(14.0F, 12.0F, 13.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(EntityTheEye entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
        this.head.xRot = headPitch / (180F / (float) Math.PI);

        this.rightfrontleg.xRot = (float) Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leftbackleg.xRot = (float) Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

        this.leftfrontleg.xRot = (float) Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount;
        this.rightbackleg.xRot = (float) Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount;

        this.rightfrontleg.yRot = 0.0F;
        this.rightbackleg.yRot = 0.0F;

        this.leftfrontleg.yRot = 0.0F;
        this.leftbackleg.yRot = 0.0F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, buffer, packedLight, packedOverlay);
		body.render(poseStack, buffer, packedLight, packedOverlay);
		rightfrontleg.render(poseStack, buffer, packedLight, packedOverlay);
		rightbackleg.render(poseStack, buffer, packedLight, packedOverlay);
		leftfrontleg.render(poseStack, buffer, packedLight, packedOverlay);
		leftbackleg.render(poseStack, buffer, packedLight, packedOverlay);
	}
}