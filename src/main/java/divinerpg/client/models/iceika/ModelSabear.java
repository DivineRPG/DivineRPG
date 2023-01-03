package divinerpg.client.models.iceika;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelSabear<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("sabear");
	private final ModelPart bb_main;

	public ModelSabear(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create()
		.texOffs(22, 49).addBox(2.0F, -11.0F, -8.0F, 5.0F, 11.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 49).addBox(-7.0F, -11.0F, -8.0F, 5.0F, 11.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 26).addBox(-7.0F, -22.0F, -8.0F, 14.0F, 11.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-7.0F, -23.0F, 4.0F, 14.0F, 12.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(48, 18).addBox(2.0F, -11.0F, 8.0F, 5.0F, 11.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(44, 41).addBox(-7.0F, -11.0F, 8.0F, 5.0F, 11.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(42, 0).addBox(-5.0F, -20.0F, -14.0F, 10.0F, 8.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(6, 9).addBox(4.0F, -21.0F, -12.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 9).addBox(-6.0F, -21.0F, -12.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(44, 60).addBox(-3.0F, -17.0F, -18.0F, 6.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 67).addBox(-3.0F, -12.0F, -18.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 67).addBox(2.0F, -12.0F, -18.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}