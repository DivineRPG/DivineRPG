package divinerpg.client.models.arcana;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.arcana.EntityRoamer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelRoamer extends EntityModel<EntityRoamer> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("roamer");
	private final ModelPart body, rightleg, leftleg;

	public ModelRoamer(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.body = root.getChild("body");
		this.rightleg = root.getChild("rightleg");
		this.leftleg = root.getChild("leftleg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(14, 25).mirror().addBox(-10.0F, 12.0F, -5.0F, 2.0F, 2.0F, 5.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(0, 25).mirror().addBox(-8.0F, 10.0F, -5.0F, 2.0F, 2.0F, 5.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(0, 18).mirror().addBox(0.0F, 10.0F, -5.0F, 2.0F, 2.0F, 5.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(39, 20).mirror().addBox(-6.0F, 12.0F, -6.0F, 6.0F, 6.0F, 6.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(39, 20).mirror().addBox(-6.0F, 18.0F, -6.0F, 6.0F, 6.0F, 6.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(39, 20).mirror().addBox(-6.0F, 6.0F, -6.0F, 6.0F, 6.0F, 6.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(14, 18).mirror().addBox(2.0F, 12.0F, -5.0F, 2.0F, 2.0F, 5.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(2.0F, -5.0F, 2.0F));

		body.addOrReplaceChild("Main_Body1_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(1.0F, -28.0F, -11.0F, 10.0F, 6.0F, 10.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(0, 0).mirror().addBox(1.0F, -28.0F, 2.0F, 10.0F, 6.0F, 10.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-2.0F, 29.0F, -10.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition rightleg = partdefinition.addOrReplaceChild("rightleg", CubeListBuilder.create(), PartPose.offset(-4.0F, 15.0F, -1.0F));

		rightleg.addOrReplaceChild("Legbottom1_r1", CubeListBuilder.create().texOffs(14, 25).mirror().addBox(-6.0F, 0.0F, -3.0F, 2.0F, 2.0F, 5.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(0, 25).mirror().addBox(-6.0F, 0.0F, -8.0F, 2.0F, 2.0F, 5.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(4.0F, 7.0F, 1.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition leftleg = partdefinition.addOrReplaceChild("leftleg", CubeListBuilder.create(), PartPose.offset(2.0F, 15.0F, -1.0F));

		leftleg.addOrReplaceChild("Legtop2_r1", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(2.0F, 0.0F, -7.0F, 2.0F, 2.0F, 5.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(14, 18).mirror().addBox(2.0F, 0.0F, -2.0F, 2.0F, 2.0F, 5.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-2.0F, 6.0F, 1.0F, -1.5708F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(EntityRoamer entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}