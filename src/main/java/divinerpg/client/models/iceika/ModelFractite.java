package divinerpg.client.models.iceika;

import com.mojang.blaze3d.vertex.*;

import divinerpg.entities.iceika.EntityFractite;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelFractite extends EntityModel<EntityFractite> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("fractite");
	private final ModelPart frostBody;
	private final ModelPart shard1;
	private final ModelPart shard2;
	private final ModelPart shard7;
	private final ModelPart shard8;
	private final ModelPart shard4;
	private final ModelPart shard3;
	private final ModelPart shard5;
	private final ModelPart shard6;

	public ModelFractite(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.frostBody = root.getChild("frostBody");
		this.shard1 = root.getChild("shard1");
		this.shard2 = root.getChild("shard2");
		this.shard7 = root.getChild("shard7");
		this.shard8 = root.getChild("shard8");
		this.shard4 = root.getChild("shard4");
		this.shard3 = root.getChild("shard3");
		this.shard5 = root.getChild("shard5");
		this.shard6 = root.getChild("shard6");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("frostBody", CubeListBuilder.create().texOffs(0, 11).mirror().addBox(0.0F, 0.0F, 0.0F, 8.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 5.0F, -4.0F));

		partdefinition.addOrReplaceChild("shard1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(8.0F, 0.0F, 0.0F, 9.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 8.0F, -2.0F, 0.0F, 0.0F, -0.7854F));

		partdefinition.addOrReplaceChild("shard2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-19.0F, 0.0F, 0.0F, 9.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 9.0F, -2.0F, 0.0F, 0.0F, -0.7854F));

		partdefinition.addOrReplaceChild("shard7", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(10.0F, 0.0F, 0.0F, 10.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 9.0F, -2.0F, 0.0F, 0.0F, 0.7854F));

		partdefinition.addOrReplaceChild("shard8", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-19.0F, 0.0F, 0.0F, 10.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 9.0F, -2.0F, 0.0F, 0.0F, 0.7854F));

		partdefinition.addOrReplaceChild("shard4", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-6.0F, -8.0F, 0.0F, 15.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 8.0F, -2.0F, 0.0F, 0.0F, 1.5708F));

		partdefinition.addOrReplaceChild("shard3", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-7.0F, 7.0F, 0.0F, 15.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 9.0F, -2.0F, 0.0F, 0.0F, 1.5708F));

		partdefinition.addOrReplaceChild("shard5", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-8.0F, -7.0F, 0.0F, 14.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, 9.0F, -2.0F));

		partdefinition.addOrReplaceChild("shard6", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-7.0F, 7.0F, 0.0F, 14.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 9.0F, -2.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(EntityFractite entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.shard1.xRot = Mth.cos(ageInTicks * 0.1F) * (float)Math.PI;
		this.shard2.xRot = Mth.cos(ageInTicks * 0.1F) * (float)Math.PI;
		this.shard3.xRot = Mth.cos(ageInTicks * 0.1F) * (float)Math.PI;
		this.shard4.xRot = Mth.cos(ageInTicks * 0.1F) * (float)Math.PI;
		this.shard5.xRot = Mth.cos(ageInTicks * 0.1F) * (float)Math.PI;
		this.shard6.xRot = Mth.cos(ageInTicks * 0.1F) * (float)Math.PI;
		this.shard7.xRot = Mth.cos(ageInTicks * 0.1F) * (float)Math.PI;
		this.shard8.xRot = Mth.cos(ageInTicks * 0.1F) * (float)Math.PI;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		frostBody.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		shard1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		shard2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		shard7.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		shard8.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		shard4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		shard3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		shard5.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		shard6.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}