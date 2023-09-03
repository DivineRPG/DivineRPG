package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;

import divinerpg.entities.vanilla.nether.EntityScorcher;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelScorcher extends EntityModel<EntityScorcher> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("scorcher");
	private final ModelPart Body, Rods, BackRod, FrontRod, RightRod, LeftRod;

	public ModelScorcher(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Body = root.getChild("Body");
		this.Rods = root.getChild("Rods");
		this.BackRod = this.Rods.getChild("BackRod");
		this.FrontRod = this.Rods.getChild("FrontRod");
		this.RightRod = this.Rods.getChild("RightRod");
		this.LeftRod = this.Rods.getChild("LeftRod");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.rotation(0.0F, 3.1416F, 0.0F));

		Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 20).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
			.texOffs(30, 0).addBox(-8.0F, -7.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
			.texOffs(0, 20).addBox(-8.0F, -13.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
			.texOffs(30, 4).addBox(4.0F, -7.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
			.texOffs(0, 0).addBox(6.0F, -13.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.0F, 0.0F));

		PartDefinition Rods = partdefinition.addOrReplaceChild("Rods", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		Rods.addOrReplaceChild("BackRod", CubeListBuilder.create().texOffs(8, 36).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.ZERO);

		Rods.addOrReplaceChild("FrontRod", CubeListBuilder.create().texOffs(32, 20).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.ZERO);

		Rods.addOrReplaceChild("RightRod", CubeListBuilder.create().texOffs(0, 36).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.ZERO);

		Rods.addOrReplaceChild("LeftRod", CubeListBuilder.create().texOffs(30, 34).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.ZERO);

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(EntityScorcher entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = ageInTicks * (float)Math.PI * -0.1F;
		for(int i = 0; i < 4; ++i) {
			this.Body.y = -Mth.cos(((float) (i * 2) + ageInTicks) * 0.25F) + 21.0F;
			this.BackRod.y = Mth.cos(((float) (i * 2) + ageInTicks) * 0.25F) + 16.0F;
			this.BackRod.x = -Mth.sin(f) * 9.0F;
			this.BackRod.z = -Mth.cos(f) * 9.0F;
			this.FrontRod.y = Mth.cos(((float) (i * 2) + ageInTicks) * 0.15F) + 16.0F;
			this.FrontRod.x = Mth.sin(f) * 9.0F;
			this.FrontRod.z = Mth.cos(f) * 9.0F;
			this.LeftRod.y = Mth.cos(((float) (i * 2) + ageInTicks) * 0.2F) + 16.0F;
			this.LeftRod.x = Mth.sin(f + (float)Math.PI / 2) * 9.0F;
			this.LeftRod.z = Mth.cos(f + (float)Math.PI / 2) * 9.0F;
			this.RightRod.y = Mth.cos(((float) (i * 2) + ageInTicks) * 0.1F) + 16.0F;
			this.RightRod.x = -Mth.sin(f + (float)Math.PI / 2) * 9.0F;
			this.RightRod.z = -Mth.cos(f + (float)Math.PI / 2) * 9.0F;
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Rods.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}