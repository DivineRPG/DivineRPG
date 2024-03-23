package divinerpg.client.models.twilight;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.eden.EntityWeakCori;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelWeakCori extends EntityModel<EntityWeakCori> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("weak_cori");
	public final ModelPart Head, Tendrils, FrontRightTendril, FrontMiddleTendril, FrontLeftTendril, BackRightTendril, BackMiddleTendril, BackLeftTendril, RightTendril, LeftTendril;
	public ModelWeakCori(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		Head = root.getChild("Head");
		Tendrils = root.getChild("Tendrils");
		FrontRightTendril = Tendrils.getChild("FrontRightTendril");
		FrontMiddleTendril = Tendrils.getChild("FrontMiddleTendril");
		FrontLeftTendril = Tendrils.getChild("FrontLeftTendril");
		BackRightTendril = Tendrils.getChild("BackRightTendril");
		BackMiddleTendril = Tendrils.getChild("BackMiddleTendril");
		BackLeftTendril = Tendrils.getChild("BackLeftTendril");
		RightTendril = Tendrils.getChild("RightTendril");
		LeftTendril = Tendrils.getChild("LeftTendril");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubeDef = CubeDeformation.NONE;
		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(40, 55).addBox(-4, -6, -1, 8, 8, 1, cubeDef)
		.texOffs(13, 54).addBox(-5, -7, -.5F, 10, 10, 0, cubeDef), PartPose.offset(0, 12, 1));
		Head.addOrReplaceChild("Skull", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -6, -8, 7, 5, 8, cubeDef)
		.texOffs(0, 22).addBox(-3.5F, -1, -8, 7, 1, 8, cubeDef), PartPose.offset(0, 0, -1));
		Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(0, 13).addBox(-3.5F, -1, -9, 7, 1, 8, cubeDef)
		.texOffs(22, 5).addBox(-3.5F, 0, -9, 7, 1, 8, cubeDef), PartPose.offset(0, 1, 0));
		PartDefinition Tendrils = partdefinition.addOrReplaceChild("Tendrils", CubeListBuilder.create().texOffs(24, 16).addBox(-2.5F, 1.5F, -1.5F, 5, 3, 6, cubeDef), PartPose.offset(0, 12.49F, -1.5F));
		Tendrils.addOrReplaceChild("FrontRightTendril", CubeListBuilder.create().texOffs(0, 43).addBox(-2.5F,.5F, -3, 3, 9, 3, cubeDef), PartPose.offset(-2, 4, -.5F));
		Tendrils.addOrReplaceChild("FrontMiddleTendril", CubeListBuilder.create().texOffs(44, 0).addBox(-1.5F,.5F, -3, 3, 9, 3, cubeDef), PartPose.offset(0, 4, -.5F));
		Tendrils.addOrReplaceChild("FrontLeftTendril", CubeListBuilder.create().texOffs(21, 40).addBox(0,.5F, -3, 3, 9, 3, cubeDef), PartPose.offset(1.5F, 4, -.5F));
		Tendrils.addOrReplaceChild("BackRightTendril", CubeListBuilder.create().texOffs(36, 37).addBox(-3,.5F, 0, 3, 9, 3, cubeDef), PartPose.offset(-1.5F, 4, 3.5F));
		Tendrils.addOrReplaceChild("BackMiddleTendril", CubeListBuilder.create().texOffs(12, 31).addBox(-1.5F,.5F, 0, 3, 9, 3, cubeDef), PartPose.offset(0, 4, 3.5F));
		Tendrils.addOrReplaceChild("BackLeftTendril", CubeListBuilder.create().texOffs(39, 25).addBox(0,.5F, 0, 3, 9, 3, cubeDef), PartPose.offset(1.5F, 4, 3.5F));
		Tendrils.addOrReplaceChild("RightTendril", CubeListBuilder.create().texOffs(27, 28).addBox(-3,.5F, -1.5F, 3, 9, 3, cubeDef), PartPose.offset(-1.5F, 4, 1.5F));
		Tendrils.addOrReplaceChild("LeftTendril", CubeListBuilder.create().texOffs(0, 31).addBox(0,.5F, -1.5F, 3, 9, 3, cubeDef), PartPose.offset(1.5F, 4, 1.5F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	@Override public void setupAnim(EntityWeakCori entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		Head.yRot = netHeadYaw * Mth.DEG_TO_RAD;
		Head.xRot = headPitch * Mth.DEG_TO_RAD;
		float f = Mth.cos(ageInTicks * 15F * Mth.DEG_TO_RAD) * Mth.HALF_PI * .25F;
		BackMiddleTendril.xRot = RightTendril.zRot = f + .5672F;
		FrontMiddleTendril.xRot = LeftTendril.zRot = -f - .5672F;
		FrontRightTendril.xRot = FrontLeftTendril.zRot = FrontLeftTendril.xRot = BackLeftTendril.zRot = f - .3491F;
		FrontRightTendril.zRot = BackLeftTendril.xRot = BackRightTendril.xRot = BackRightTendril.zRot = -f + .3491F;
	}
	@Override public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tendrils.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}