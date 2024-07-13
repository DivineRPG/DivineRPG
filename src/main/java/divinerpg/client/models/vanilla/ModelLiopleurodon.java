package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.vanilla.overworld.EntityLiopleurodon;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelLiopleurodon extends EntityModel<EntityLiopleurodon> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("liopleurodon");
	private final ModelPart body, fin3B, fin4B, fin1A, fin2A;

	public ModelLiopleurodon(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.body = root.getChild("body");
		this.fin3B = root.getChild("fin3B");
		this.fin4B = root.getChild("fin4B");
		this.fin1A = root.getChild("fin1A");
		this.fin2A = root.getChild("fin2A");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(5, 6).mirror().addBox(-7.0F, -17.0F, -12.0F, 16.0F, 28.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 11.0F, 3.0F, 1.5708F, 0.0F, 0.0F));

		body.addOrReplaceChild("tooth3_r1", CubeListBuilder.create().texOffs(0, 77).mirror().addBox(3.0F, 1.6F, 39.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 77).mirror().addBox(3.0F, 1.6F, 36.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 77).mirror().addBox(3.0F, 1.6F, 33.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 77).mirror().addBox(-4.0F, 1.6F, 33.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 77).mirror().addBox(-4.0F, 1.6F, 39.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 77).mirror().addBox(-4.0F, 1.6F, 36.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 0).mirror().addBox(-5.0F, 2.6F, 29.0F, 10.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 0).mirror().addBox(-5.0F, -1.4F, 29.2667F, 10.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(8, 39).mirror().addBox(-6.0F, -3.4F, 18.0F, 12.0F, 9.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(21, 7).mirror().addBox(-5.0F, -2.4F, 8.0F, 10.0F, 7.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(6, 22).mirror().addBox(-6.0F, -3.4F, -2.0F, 12.0F, 10.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(8, 30).mirror().addBox(-2.0F, 0.0F, -65.0F, 4.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(31, 9).mirror().addBox(-4.0F, -2.0F, -51.0F, 8.0F, 8.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(17, 14).mirror().addBox(-6.0F, -4.0F, -44.0F, 12.0F, 11.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(5, 33).mirror().addBox(-3.0F, -1.0F, -59.0F, 6.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 13.0F, -3.0F, -1.5708F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("fin3B", CubeListBuilder.create().texOffs(5, 6).mirror().addBox(-18.0F, -5.0F, -1.0F, 18.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(5, 6).mirror().addBox(-22.0F, -4.0F, -1.0F, 8.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 18.0F, 11.0F, 1.5708F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("fin4B", CubeListBuilder.create().texOffs(5, 6).mirror().addBox(-18.0F, -5.0F, -1.0F, 18.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(5, 6).mirror().addBox(-22.0F, -4.0F, -1.0F, 8.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 18.0F, -10.0F, 1.5708F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("fin1A", CubeListBuilder.create().texOffs(5, 6).mirror().addBox(14.0F, -4.0F, -1.0F, 8.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(5, 6).mirror().addBox(0.0F, -5.0F, -1.0F, 18.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0F, 18.0F, 11.0F, 1.5708F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("fin2A", CubeListBuilder.create().texOffs(5, 6).mirror().addBox(14.0F, -4.0F, -1.0F, 8.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(5, 6).mirror().addBox(0.0F, -5.0F, -1.0F, 18.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0F, 18.0F, -10.0F, 1.5708F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 80, 80);
	}

	@Override
	public void setupAnim(EntityLiopleurodon entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.fin1A.zRot = this.fin4B.zRot = (float) (Math.sin((10 * ageInTicks / (180f / Math.PI))) * 0.3f);
        this.fin2A.zRot = this.fin3B.zRot = (float) (-Math.sin((10 * ageInTicks / (180f / Math.PI))) * 0.3f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		fin3B.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		fin4B.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		fin1A.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		fin2A.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}