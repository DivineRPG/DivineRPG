package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.vanilla.overworld.EntityTheGrue;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelTheGrue extends EntityModel<EntityTheGrue> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("the_grue");
	private final ModelPart legRight, legLeft, thighRight, thighLeft, torso, body, Shape6, tail1, tail3, tail2, mouth, head;

	public ModelTheGrue(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.legRight = root.getChild("legRight");
		this.legLeft = root.getChild("legLeft");
		this.thighRight = root.getChild("thighRight");
		this.thighLeft = root.getChild("thighLeft");
		this.torso = root.getChild("torso");
		this.body = root.getChild("body");
		this.Shape6 = root.getChild("Shape6");
		this.tail1 = root.getChild("tail1");
		this.tail3 = root.getChild("tail3");
		this.tail2 = root.getChild("tail2");
		this.mouth = root.getChild("mouth");
		this.head = root.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubedef = new CubeDeformation(0F);

		PartDefinition legRight = partdefinition.addOrReplaceChild("legRight", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(4.0F, 4.0F, 6.0F, 3.0F, 10.0F, 3.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-5.0F, 2.0F, 4.0F, -0.3718F, 0.0F, 0.2231F));

		legRight.addOrReplaceChild("toeRightIn", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(11.0F, 3.0F, 12.0F, 2.0F, 11.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-5.0F, 2.0F, 4.0F, -1.1525F, -0.0744F, 0.0F));

		legRight.addOrReplaceChild("toeRightOut", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(3.0F, -6.0F, 15.0F, 2.0F, 11.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-5.0F, 2.0F, 4.0F, -1.1525F, 0.8923F, 0.0F));

		PartDefinition legLeft = partdefinition.addOrReplaceChild("legLeft", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-6.0F, 4.0F, 7.0F, 3.0F, 10.0F, 3.0F, cubedef).mirror(false), PartPose.offsetAndRotation(8.0F, 2.0F, 4.0F, -0.409F, 0.0F, -0.2231F));

		legLeft.addOrReplaceChild("toeLeftIn", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-14.0F, 3.0F, 11.0F, 2.0F, 11.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(8.0F, 2.0F, 4.0F, -1.1525F, 0.1487F, 0.0F));

		legLeft.addOrReplaceChild("toeLeftOut", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-6.0F, -6.0F, 15.0F, 2.0F, 11.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(8.0F, 2.0F, 4.0F, -1.1525F, -0.8179F, 0.0F));

		partdefinition.addOrReplaceChild("thighRight", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-5.0F, 2.0F, 4.0F, 0.6146F, 0.0F, -0.409F));

		partdefinition.addOrReplaceChild("thighLeft", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(8.0F, 2.0F, 4.0F, 0.6146F, 0.0F, 0.409F));

		partdefinition.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 12.0F, 6.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-5.0F, -3.0F, 3.0F, -0.2231F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 8.0F, 9.0F, 10.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3333F, 0.0F, -0.0744F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Shape6", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 8.0F, 8.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-2.0F, -6.0F, -7.0F, 0.3718F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 6.0F, 7.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-2.0F, -2.0F, 7.0F, 1.2269F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("tail3", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, -3.0F, 17.0F, 0.7808F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 4.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-1.0F, -3.0F, 13.0F, 1.041F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 8.0F, 2.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-3.0F, 4.0F, -9.4667F, 0.6692F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 8.0F, 7.0F, 11.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-3.0F, -3.0F, -17.0F, 0.3346F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 27);
	}

	@Override
	public void setupAnim(EntityTheGrue entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.legLeft.xRot = -0.4089647F + (float) Math.cos(limbSwing * 0.6662F + Math.PI) * 1.3f * limbSwingAmount;
        this.thighLeft.xRot = 0.6145831F + (float) Math.cos(limbSwing * 0.6662F + Math.PI) * 1.3f * limbSwingAmount;
        this.legRight.xRot = -0.4089647F + (float) Math.cos(limbSwing * 0.6662F) * 1.3f * limbSwingAmount;
        this.thighRight.xRot = 0.6145831F + (float) Math.cos(limbSwing * 0.6662F) * 1.3f * limbSwingAmount;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		legRight.render(poseStack, buffer, packedLight, packedOverlay);
		legLeft.render(poseStack, buffer, packedLight, packedOverlay);
		thighRight.render(poseStack, buffer, packedLight, packedOverlay);
		thighLeft.render(poseStack, buffer, packedLight, packedOverlay);
		torso.render(poseStack, buffer, packedLight, packedOverlay);
		body.render(poseStack, buffer, packedLight, packedOverlay);
		Shape6.render(poseStack, buffer, packedLight, packedOverlay);
		tail1.render(poseStack, buffer, packedLight, packedOverlay);
		tail3.render(poseStack, buffer, packedLight, packedOverlay);
		tail2.render(poseStack, buffer, packedLight, packedOverlay);
		mouth.render(poseStack, buffer, packedLight, packedOverlay);
		head.render(poseStack, buffer, packedLight, packedOverlay);
	}
}