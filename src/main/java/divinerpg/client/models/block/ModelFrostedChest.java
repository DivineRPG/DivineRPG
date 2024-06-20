package divinerpg.client.models.block;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelFrostedChest<T extends Entity> extends Model {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("frosted_chest");
	private final ModelPart storage;
	public final ModelPart lid;
	public final ModelPart handle;

	public ModelFrostedChest(ModelPart root) {
		super(RenderType::entityCutout);
		this.storage = root.getChild("storage");
		this.lid = root.getChild("lid");
		this.handle = root.getChild("handle");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("storage", CubeListBuilder.create().texOffs(0, 19).addBox(0.0F, 0.0F, 0.0F, 14.0F, 10.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 6.0F, 1.0F));

		partdefinition.addOrReplaceChild("lid", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -5.0F, -14.0F, 14.0F, 5.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 7.0F, 15.0F));

		partdefinition.addOrReplaceChild("handle", CubeListBuilder.create().texOffs(0, 0).addBox(-1F, -2F, -14.9F, 2F, 4F, 1F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 7.0F, 15.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		storage.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		lid.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		handle.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}