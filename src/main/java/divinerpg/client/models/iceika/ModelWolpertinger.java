package divinerpg.client.models.iceika;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.iceika.EntityWolpertinger;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelWolpertinger extends EntityModel<EntityWolpertinger> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("wolpertinger");
	private final ModelPart Head, Body, BackRightFoot, BackLeftFoot, LeftLeg, RightLeg;
	private float jumpRotation;

	public ModelWolpertinger(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Head = root.getChild("Head");
		this.Body = root.getChild("Body");
		this.BackRightFoot = root.getChild("BackRightFoot");
		this.BackLeftFoot = root.getChild("BackLeftFoot");
		this.LeftLeg = root.getChild("LeftLeg");
		this.RightLeg = root.getChild("RightLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(20, 47).addBox(-2.5F, -4.0F, -5.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(8, 0).addBox(-0.5F, -1.5F, -5.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(26, 21).addBox(-3.0F, -4.5F, -5.5F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(104, 35).addBox(-8.0F, -10.3333F, -8.8333F, 7.0F, 9.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(104, 19).addBox(1.0F, -10.3333F, -8.8333F, 7.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.0F, -4.0F));

		Head.addOrReplaceChild("LeftEar", CubeListBuilder.create().texOffs(44, 47).addBox(-0.5F, -1.5F, -1.0F, 1.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -1.5F, -3.0F));

		Head.addOrReplaceChild("RightEar", CubeListBuilder.create().texOffs(38, 47).addBox(-0.5F, -1.5F, -1.0F, 1.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -1.5F, -3.0F));

		partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(32, 34).addBox(1.0F, -1.6667F, -3.1667F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(29, 0).addBox(-4.0F, -1.6667F, -3.1667F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 21).addBox(-3.0F, -4.6667F, -10.1667F, 6.0F, 6.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-3.5F, -5.1667F, -10.6667F, 7.0F, 6.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(0, 56).addBox(-2.0F, -4.0F, 3.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 18.6667F, 4.1667F, -0.2618F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("BackRightFoot", CubeListBuilder.create().texOffs(0, 41).addBox(-1.5F, -0.5F, -8.5F, 3.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 23.5F, 7.5F));

		partdefinition.addOrReplaceChild("BackLeftFoot", CubeListBuilder.create().texOffs(42, 4).addBox(-1.5F, -0.5F, -8.5F, 3.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 23.5F, 7.5F));

		partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 0).addBox(1.0F, 0.0F, -1.0F, 3.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 17.0F, -5.0F));

		partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 21).addBox(-4.0F, 0.0F, -1.0F, 3.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 17.0F, -5.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(EntityWolpertinger entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = ageInTicks - (float)entity.tickCount;
		this.Head.yRot = netHeadYaw * ((float)Math.PI / 180F);
		this.jumpRotation = Mth.sin(entity.getJumpCompletion(f) * (float)Math.PI);
		this.BackLeftFoot.xRot = this.jumpRotation * 50.0F * ((float)Math.PI / 180F);
		this.BackRightFoot.xRot = this.jumpRotation * 50.0F * ((float)Math.PI / 180F);
		this.LeftLeg.xRot = (this.jumpRotation * -40.0F - 11.0F) * ((float)Math.PI / 180F);
		this.RightLeg.xRot = (this.jumpRotation * -40.0F - 11.0F) * ((float)Math.PI / 180F);
	}

	public void prepareMobModel(EntityWolpertinger entity, float p_103544_, float p_103545_, float age) {
		super.prepareMobModel(entity, p_103544_, p_103545_, age);
		this.jumpRotation = Mth.sin(entity.getJumpCompletion(age) * (float)Math.PI);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackRightFoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackLeftFoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}