package divinerpg.client.models.arcana;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelRejuvGolem<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("rejuv_golem");
	private final ModelPart head;
	private final ModelPart rightshoulder;
	private final ModelPart leftshoulder;
	private final ModelPart middle;
	private final ModelPart body;
	private final ModelPart rightarm;
	private final ModelPart leftarm;

	public ModelRejuvGolem(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.head = root.getChild("head");
		this.rightshoulder = root.getChild("rightshoulder");
		this.leftshoulder = root.getChild("leftshoulder");
		this.middle = root.getChild("middle");
		this.body = root.getChild("body");
		this.rightarm = root.getChild("rightarm");
		this.leftarm = root.getChild("leftarm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -8.0F, -4.0F, 4.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 7.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightshoulder", CubeListBuilder.create().texOffs(73, 3).mirror().addBox(-4.0F, -6.0F, -3.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.0F, 11.0F, 0.0F, -0.6981F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftshoulder", CubeListBuilder.create().texOffs(73, 3).mirror().addBox(-2.0F, -6.0F, -3.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.0F, 11.0F, 0.0F, -0.6981F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("middle", CubeListBuilder.create().texOffs(68, 18).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 7.0F, -2.0F));

		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(25, 10).mirror().addBox(-4.0F, 0.0F, -2.0F, 10.0F, 12.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 12.0F, -3.0F));

		partdefinition.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.0F, 11.0F, 0.0F, -0.6981F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.0F, 11.0F, 0.0F, -0.6981F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.rightarm.xRot = this.rightshoulder.xRot = Mth.cos(limbSwing)*limbSwingAmount*0.75f - 0.6981317F;
		this.leftarm.xRot = this.leftshoulder.xRot = Mth.cos(limbSwing + (float)Math.PI)*limbSwingAmount*0.75f - 0.6981317F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightshoulder.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftshoulder.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		middle.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}