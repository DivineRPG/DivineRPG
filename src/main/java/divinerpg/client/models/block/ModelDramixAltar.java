package divinerpg.client.models.block;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelDramixAltar<T extends Entity> extends Model {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("dramix_altar");
	private final ModelPart Base;
	private final ModelPart P1;
	private final ModelPart P2;
	private final ModelPart P3;
	private final ModelPart P4;
	private final ModelPart S1;
	private final ModelPart S2;
	private final ModelPart S3;
	private final ModelPart S4;

	public ModelDramixAltar(ModelPart root) {
		super(RenderType::entityCutout);
		this.Base = root.getChild("Base");
		this.P1 = root.getChild("P1");
		this.P2 = root.getChild("P2");
		this.P3 = root.getChild("P3");
		this.P4 = root.getChild("P4");
		this.S1 = root.getChild("S1");
		this.S2 = root.getChild("S2");
		this.S3 = root.getChild("S3");
		this.S4 = root.getChild("S4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("Base", CubeListBuilder.create().texOffs(0, 15).mirror().addBox(0.0F, 0.0F, 0.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-8.0F, 10.0F, -8.0F));

		partdefinition.addOrReplaceChild("P1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-8.0F, 11.0F, -8.0F));

		partdefinition.addOrReplaceChild("P2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(6.0F, 11.0F, -8.0F));

		partdefinition.addOrReplaceChild("P3", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(6.0F, 11.0F, 6.0F));

		partdefinition.addOrReplaceChild("P4", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-8.0F, 11.0F, 6.0F));

		partdefinition.addOrReplaceChild("S1", CubeListBuilder.create().texOffs(22, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 20.0F, 4.0F));

		partdefinition.addOrReplaceChild("S2", CubeListBuilder.create().texOffs(22, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-8.0F, 20.0F, 4.0F));

		partdefinition.addOrReplaceChild("S3", CubeListBuilder.create().texOffs(22, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-8.0F, 20.0F, -8.0F));

		partdefinition.addOrReplaceChild("S4", CubeListBuilder.create().texOffs(22, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 20.0F, -8.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}


	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		Base.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		P1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		P2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		P3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		P4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		S1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		S2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		S3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		S4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}