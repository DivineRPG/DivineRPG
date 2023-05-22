package divinerpg.client.models.block;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelDemonFurnace<T extends Entity> extends Model{
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("demon_furnace");
	private final ModelPart Box, Arm1, Arm2, Arm3, Arm4, Arm5, Arm6;
	public ModelDemonFurnace(ModelPart root) {
		super(RenderType::entityCutout);
		this.Box = root.getChild("Box");
		this.Arm1 = root.getChild("Arm1");
		this.Arm2 = root.getChild("Arm2");
		this.Arm3 = root.getChild("Arm3");
		this.Arm4 = root.getChild("Arm4");
		this.Arm5 = root.getChild("Arm5");
		this.Arm6 = root.getChild("Arm6");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("Box", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.0F, 8.0F, -8.0F, 0.0F, 0.0F, 3.1416F));

		partdefinition.addOrReplaceChild("Arm1", CubeListBuilder.create().texOffs(0, 32).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 19.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, -8.0F, 3.0F, 0.0F, 0.0F, 1.2566F));

		partdefinition.addOrReplaceChild("Arm2", CubeListBuilder.create().texOffs(0, 32).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 24.0F, 3.0F, 0.0F, 0.0F, 3.1416F));

		partdefinition.addOrReplaceChild("Arm3", CubeListBuilder.create().texOffs(0, 32).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.0F, 24.0F, 3.0F, 0.0F, 0.0F, 3.1416F));

		partdefinition.addOrReplaceChild("Arm4", CubeListBuilder.create().texOffs(0, 32).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 19.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.0F, -3.0F, 3.0F, 0.0F, 0.0F, 0.6632F));

		partdefinition.addOrReplaceChild("Arm5", CubeListBuilder.create().texOffs(0, 32).mirror().addBox(-4.0F, 0.0F, 0.0F, 4.0F, 19.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F,  -8.0F, 3.0F, 0.0F, 0.0F, -1.2566F));

		partdefinition.addOrReplaceChild("Arm6", CubeListBuilder.create().texOffs(0, 32).mirror().addBox(-4.0F, 0.0F, 0.0F, 4.0F, 19.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.0F, -3.0F, 3.0F, 0.0F, 0.0F, -0.6632F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Box.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Arm1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Arm2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Arm3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Arm4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Arm5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Arm6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}