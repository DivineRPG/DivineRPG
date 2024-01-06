package divinerpg.client.models.iceika;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.iceika.EntityBlubbertusk;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelBlubbertusk extends EntityModel<EntityBlubbertusk> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("blubbertusk");
	private final ModelPart head, body, neck, leftFin, leftFinR1, rightFin, tail, tailEnd;

	public ModelBlubbertusk(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		body = root.getChild("Body");
		leftFin = body.getChild("LeftFin");
		rightFin = body.getChild("RightFin");
		neck = body.getChild("Neck");
		head = neck.getChild("Head");
		tail = body.getChild("Tail");
		tailEnd = tail.getChild("TailEnd");
		leftFinR1 = tailEnd.getChild("leftFin_r1");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -11.0F, -9.0F, 12.0F, 11.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 26).addBox(-5.5F, -7.0F, -4.3265F, 11.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, -8.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, -1.0F));

		PartDefinition Skull = Head.addOrReplaceChild("Skull", CubeListBuilder.create().texOffs(48, 43).addBox(-3.0F, -4.0F, -8.0F, 6.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(39, 0).addBox(-4.0F, -5.0F, -6.0F, 8.0F, 7.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-2.5F, -2.0F, -7.5F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 0).addBox(1.5F, -2.0F, -7.5F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.ZERO);

		Skull.addOrReplaceChild("RightWhisker", CubeListBuilder.create().texOffs(8, 0).addBox(-2.0F, -1.5F, 0.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -1.5F, -7.0F));

		Skull.addOrReplaceChild("LeftWhisker", CubeListBuilder.create().texOffs(0, 8).addBox(0.0F, -1.5F, 0.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -1.5F, -7.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(36, 26).addBox(-4.5F, -6.0F, 0.0F, 9.0F, 9.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 4.0F));

		PartDefinition TailEnd = Tail.addOrReplaceChild("TailEnd", CubeListBuilder.create().texOffs(29, 43).addBox(-3.0F, -3.5F, -2.0F, 6.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 9.0F));

		TailEnd.addOrReplaceChild("leftFin_r1", CubeListBuilder.create().texOffs(0, 52).addBox(-0.5F, -2.5F, -1.0F, 6.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 44).addBox(-7.5F, -2.5F, -1.0F, 6.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 3.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition LeftFin = Body.addOrReplaceChild("LeftFin", CubeListBuilder.create(), PartPose.offset(6.0F, -4.0F, -6.0F));

		LeftFin.addOrReplaceChild("leftFin_r2", CubeListBuilder.create().texOffs(15, 53).addBox(10.0F, -3.0F, -1.66F, 2.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, 2.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition RightFin = Body.addOrReplaceChild("RightFin", CubeListBuilder.create(), PartPose.offset(-6.0F, -4.0F, -6.0F));

		RightFin.addOrReplaceChild("rightFin_r1", CubeListBuilder.create().texOffs(48, 50).addBox(-12.0F, -3.0F, -1.66F, 2.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0F, 2.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(EntityBlubbertusk entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.xRot = headPitch * ((float)Math.PI / 360F) - 0.6109F;
		this.head.yRot = netHeadYaw * ((float)Math.PI / 360F);
		if(!entity.onGround() || entity.isInWater()) {
			float t = (float) (Math.cos(limbSwing * 0.6662F) * limbSwingAmount / 2);
			this.neck.xRot = t + 0.6109F;
			this.tail.xRot = t;
			this.tailEnd.xRot = t * 2;
			this.tail.yRot = t;
			this.tailEnd.yRot = t * 2;
			this.tailEnd.y = -1.5F;
			this.body.xRot = headPitch * ((float)Math.PI / 180F);
			this.body.yRot = netHeadYaw * ((float)Math.PI / 180F);

			this.leftFinR1.y = 0.5F;
			this.rightFin.zRot = t * 2 + 1.5708F;
			this.leftFin.zRot = -t * 2 - 1.5708F;
		} else {
			float t1 = (float) (Math.cos(limbSwing * 1.5F) * limbSwingAmount / 2);
			this.neck.xRot = t1 + 0.6109F;
			this.tail.xRot = 0;
			this.tailEnd.xRot = 0;
			this.tail.yRot = t1 / 2;
			this.tailEnd.yRot = t1;
			this.tailEnd.y = 0;
			this.body.xRot = 0;
			this.body.yRot = 0;

			this.leftFinR1.y = 3.0F;
			this.rightFin.zRot = 0.0F;
			this.leftFin.zRot = 0.0F;
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}