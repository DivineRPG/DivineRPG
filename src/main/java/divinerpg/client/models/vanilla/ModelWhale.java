package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.vanilla.overworld.EntityWhale;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelWhale extends EntityModel<EntityWhale> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("whale");
	private final ModelPart body, flipperL, flipperR, tail;

	public ModelWhale(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.body = root.getChild("body");
		this.flipperL = root.getChild("flipperL");
		this.flipperR = root.getChild("flipperR");
		this.tail = root.getChild("tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 8.0F, 6.0F, 24.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-4.0F, 18.0F, -9.0F));

		partdefinition.addOrReplaceChild("flipperL", CubeListBuilder.create().texOffs(0, 42).mirror().addBox(0.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(3.0F, 21.0F, 0.0F));

		partdefinition.addOrReplaceChild("flipperR", CubeListBuilder.create().texOffs(0, 42).mirror().addBox(-6.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-3.0F, 21.0F, 0.0F));

		partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 58).mirror().addBox(-6.0F, 0.0F, 6.0F, 12.0F, 2.0F, 4.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(0, 42).mirror().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(0.0F, 19.0F, 15.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(EntityWhale entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.flipperR.zRot = (float) (-Math.sin((10 * ageInTicks / (180f / Math.PI))) * 0.3f);
		this.flipperL.zRot = (float) (Math.sin((10 * ageInTicks / (180f / Math.PI))) * 0.3f);
        this.tail.xRot = (float) (Math.cos(limbSwing * 0.6662F) * limbSwingAmount / 4);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		flipperL.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		flipperR.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}