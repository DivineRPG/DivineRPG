package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.vanilla.nether.EntityScorcher;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelScorcher extends EntityModel<EntityScorcher> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("scorcher");
	public final ModelPart Body, Rods, BackRod, FrontRod, RightRod, LeftRod;
	public ModelScorcher(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		Body = root.getChild("Body");
		Rods = root.getChild("Rods");
		BackRod = Rods.getChild("BackRod");
		FrontRod = Rods.getChild("FrontRod");
		RightRod = Rods.getChild("RightRod");
		LeftRod = Rods.getChild("LeftRod");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubeDef = CubeDeformation.NONE;
		PartPose zPose = PartPose.ZERO;
		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-5, -10, -5, 10, 10, 10, cubeDef), PartPose.rotation(0, 3.1416F, 0));
		Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 20).addBox(-4, -8, -4, 8, 8, 8, cubeDef)
		.texOffs(30, 0).addBox(-8, -7, -1, 4, 2, 2, cubeDef)
		.texOffs(0, 20).addBox(-8, -13, -1, 2, 6, 2, cubeDef)
		.texOffs(30, 4).addBox(4, -7, -1, 4, 2, 2, cubeDef)
		.texOffs(0, 0).addBox(6, -13, -1, 2, 6, 2, cubeDef), PartPose.offset(0, -10, 0));
		PartDefinition Rods = partdefinition.addOrReplaceChild("Rods", CubeListBuilder.create(), zPose);
		Rods.addOrReplaceChild("BackRod", CubeListBuilder.create().texOffs(8, 36).addBox(-1, -6, -1, 2, 12, 2, cubeDef), zPose);
		Rods.addOrReplaceChild("FrontRod", CubeListBuilder.create().texOffs(32, 20).addBox(-1, -6, -1, 2, 12, 2, cubeDef), zPose);
		Rods.addOrReplaceChild("RightRod", CubeListBuilder.create().texOffs(0, 36).addBox(-1, -6, -1, 2, 12, 2, cubeDef), zPose);
		Rods.addOrReplaceChild("LeftRod", CubeListBuilder.create().texOffs(30, 34).addBox(-1, -6, -1, 2, 12, 2, cubeDef), zPose);
		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	@Override public void setupAnim(EntityScorcher entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = ageInTicks * Mth.PI * -.1F;
		float f1 = f + Mth.HALF_PI;
		for(int i = 0; i < 4; ++i) {
			float f2 = i * 2 + ageInTicks;
			Body.y = -Mth.cos(f2 * .25F) + 21;
			BackRod.y = Mth.cos(f2 * .25F) + 16;
			BackRod.x = -Mth.sin(f) * 9;
			BackRod.z = -Mth.cos(f) * 9;
			FrontRod.y = Mth.cos(f2 * .15F) + 16;
			FrontRod.x = Mth.sin(f) * 9;
			FrontRod.z = Mth.cos(f) * 9;
			LeftRod.y = Mth.cos(f2 * .2F) + 16;
			LeftRod.x = Mth.sin(f1) * 9;
			LeftRod.z = Mth.cos(f1) * 9;
			RightRod.y = Mth.cos(f2 * .1F) + 16;
			RightRod.x = -Mth.sin(f1) * 9;
			RightRod.z = -Mth.cos(f1) * 9;
		}
	}
	@Override public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Rods.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}