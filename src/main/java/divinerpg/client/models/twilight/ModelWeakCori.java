package divinerpg.client.models.twilight;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelWeakCori<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("weak_cori");
	private final ModelPart Tendrils, FrontMiddleTendril, FrontLeftTendril, FrontRightTendril, BackMiddleTendril, BackRightTendril, BackLeftTendril, LeftTendril, RightTendril, Head;

	public ModelWeakCori(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Tendrils = root.getChild("Tendrils");
		this.FrontMiddleTendril = root.getChild("FrontMiddleTendril");
		this.FrontLeftTendril = root.getChild("FrontLeftTendril");
		this.FrontRightTendril = root.getChild("FrontRightTendril");
		this.BackMiddleTendril = root.getChild("BackMiddleTendril");
		this.BackRightTendril = root.getChild("BackRightTendril");
		this.BackLeftTendril = root.getChild("BackLeftTendril");
		this.LeftTendril = root.getChild("LeftTendril");
		this.RightTendril = root.getChild("RightTendril");
		this.Head = root.getChild("Head");

	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("Tendrils", CubeListBuilder.create().texOffs(24, 16).addBox(-2.5F, 1.5F, -1.5F, 5.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.49F, -1.5F));

		partdefinition.addOrReplaceChild("FrontMiddleTendril", CubeListBuilder.create().texOffs(44, 0).addBox(-1.5F, 0.5F, -3.0F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.49F, -2.0F));

		partdefinition.addOrReplaceChild("FrontLeftTendril", CubeListBuilder.create().texOffs(21, 40).addBox(0.0F, 0.5F, -3.0F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 16.49F, -2.0F));

		partdefinition.addOrReplaceChild("FrontRightTendril", CubeListBuilder.create().texOffs(0, 43).addBox(-2.5F, 0.5F, -3.0F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 16.49F, -2.0F));

		partdefinition.addOrReplaceChild("BackMiddleTendril", CubeListBuilder.create().texOffs(12, 31).addBox(-1.5F, 0.5F, 0.0F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.49F, 2.0F));

		partdefinition.addOrReplaceChild("BackRightTendril", CubeListBuilder.create().texOffs(36, 37).addBox(-3.0F, 0.5F, 0.0F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 16.49F, 2.0F));

		partdefinition.addOrReplaceChild("BackLeftTendril", CubeListBuilder.create().texOffs(39, 25).addBox(0.0F, 0.5F, 0.0F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 16.49F, 2.0F));

		partdefinition.addOrReplaceChild("LeftTendril", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.5F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 16.49F, 0.0F));

		partdefinition.addOrReplaceChild("RightTendril", CubeListBuilder.create().texOffs(27, 28).addBox(-3.0F, 0.5F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 16.49F, 0.0F));

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(40, 55).addBox(-4.0F, -6.0F, -1.0F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(13, 54).addBox(-5.0F, -7.0F, -0.5F, 10.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 1.0F));

		Head.addOrReplaceChild("Skull", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -6.0F, -8.0F, 7.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 22).addBox(-3.5F, -1.0F, -8.0F, 7.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -1.0F));

		Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(0, 13).addBox(-3.5F, -1.0F, -9.0F, 7.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(22, 5).addBox(-3.5F, 0.0F, -9.0F, 7.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch / (180F / (float) Math.PI);
		float f = Mth.cos(ageInTicks * 15F * ((float)Math.PI / 180F)) * (float)Math.PI/2 * 0.25F;
		this.FrontMiddleTendril.xRot = -this.BackMiddleTendril.xRot;
		this.BackMiddleTendril.xRot = f + 0.5672F;
		this.FrontLeftTendril.xRot = this.FrontRightTendril.xRot;
		this.FrontRightTendril.xRot = f - 0.3491F;
		this.FrontLeftTendril.zRot = -this.FrontRightTendril.zRot;
		this.FrontRightTendril.zRot = -f + 0.3491F;
		this.BackLeftTendril.xRot = this.BackRightTendril.xRot;
		this.BackRightTendril.xRot = -f + 0.3491F;
		this.BackLeftTendril.zRot = -this.BackRightTendril.zRot;
		this.BackRightTendril.zRot = -f + 0.3491F;
		this.LeftTendril.zRot = -this.RightTendril.zRot;
		this.RightTendril.zRot = f + 0.5672F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Tendrils.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontMiddleTendril.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontLeftTendril.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontRightTendril.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackMiddleTendril.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackRightTendril.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackLeftTendril.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftTendril.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightTendril.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}