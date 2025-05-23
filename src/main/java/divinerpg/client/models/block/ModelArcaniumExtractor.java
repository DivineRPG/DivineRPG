package divinerpg.client.models.block;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelArcaniumExtractor<T extends Entity> extends Model {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("arcanium_extractor");
	public final ModelPart plate_lower, plate_middle, plate_upper, S1, S2, S3, S4, S5, S6, S7, S8, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10;
	public ModelArcaniumExtractor(ModelPart root) {
		super(RenderType::entityCutoutNoCull);
		plate_lower = root.getChild("plate_lower");
		plate_middle = root.getChild("plate_middle");
		plate_upper = root.getChild("plate_upper");
		S1 = root.getChild("S1");
		S2 = root.getChild("S2");
		S3 = root.getChild("S3");
		S4 = root.getChild("S4");
		S5 = root.getChild("S5");
		S6 = root.getChild("S6");
		S7 = root.getChild("S7");
		S8 = root.getChild("S8");
		r1 = root.getChild("r1");
		r2 = root.getChild("r2");
		r3 = root.getChild("r3");
		r4 = root.getChild("r4");
		r5 = root.getChild("r5");
		r6 = root.getChild("r6");
		r7 = root.getChild("r7");
		r8 = root.getChild("r8");
		r9 = root.getChild("r9");
		r10 = root.getChild("r10");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubeDef = CubeDeformation.NONE;
		PartPose zPose = PartPose.ZERO;
		partdefinition.addOrReplaceChild("plate_lower", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-7, 0, -7, 14, 2, 14, cubeDef), zPose);
		partdefinition.addOrReplaceChild("plate_middle", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-7, 10, -7, 14, 2, 14, cubeDef), PartPose.rotation(0, 1.571F, 0));
		partdefinition.addOrReplaceChild("plate_upper", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-7, 20, -7, 14, 2, 14, cubeDef), PartPose.rotation(0, 4.7124F, 0));
		partdefinition.addOrReplaceChild("S1", CubeListBuilder.create().texOffs(12, 0).mirror().addBox(3, 12, 3, 2, 8, 2, cubeDef), zPose);
		partdefinition.addOrReplaceChild("S2", CubeListBuilder.create().texOffs(12, 0).mirror().addBox(3, 12, 3, 2, 8, 2, cubeDef), PartPose.rotation(0, 1.571F, 0));
		partdefinition.addOrReplaceChild("S4", CubeListBuilder.create().texOffs(12, 0).mirror().addBox(3, 12, 3, 2, 8, 2, cubeDef), PartPose.rotation(0, 3.1416F, 0));
		partdefinition.addOrReplaceChild("S3", CubeListBuilder.create().texOffs(12, 0).mirror().addBox(3, 12, 3, 2, 8, 2, cubeDef), PartPose.rotation(0, 4.7124F, 0));
		partdefinition.addOrReplaceChild("S5", CubeListBuilder.create().texOffs(12, 0).mirror().addBox(2, 2, 2, 2, 8, 2, cubeDef), zPose);
		partdefinition.addOrReplaceChild("S6", CubeListBuilder.create().texOffs(12, 0).mirror().addBox(2, 2, 2, 2, 8, 2, cubeDef), PartPose.rotation(0, 1.571F, 0));
		partdefinition.addOrReplaceChild("S7", CubeListBuilder.create().texOffs(12, 0).mirror().addBox(2, 2, 2, 2, 8, 2, cubeDef), PartPose.rotation(0, 3.1416F, 0));
		partdefinition.addOrReplaceChild("S8", CubeListBuilder.create().texOffs(12, 0).mirror().addBox(2, 2, 2, 2, 8, 2, cubeDef), PartPose.rotation(0, 4.7124F, 0));
		partdefinition.addOrReplaceChild("r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(1, 22, 0, 1, 4, 1, cubeDef), zPose);
		partdefinition.addOrReplaceChild("r2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3, 22, 4, 1, 4, 1, cubeDef), zPose);
		partdefinition.addOrReplaceChild("r3", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(4, 22, -6, 1, 4, 1, cubeDef), zPose);
		partdefinition.addOrReplaceChild("r4", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-5, 22, -4, 1, 4, 1, cubeDef), zPose);
		partdefinition.addOrReplaceChild("r5", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(4, 22, -1, 1, 2, 1, cubeDef), zPose);
		partdefinition.addOrReplaceChild("r6", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-5, 22, 2, 1, 2, 1, cubeDef), zPose);
		partdefinition.addOrReplaceChild("r7", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1, 22, -5, 1, 2, 1, cubeDef), zPose);
		partdefinition.addOrReplaceChild("r8", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(5, 22, 5, 1, 2, 1, cubeDef), zPose);
		partdefinition.addOrReplaceChild("r9", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(2, 22, 3, 1, 2, 1, cubeDef), zPose);
		partdefinition.addOrReplaceChild("r10", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3, 22, -2, 1, 2, 1, cubeDef), zPose);
		return LayerDefinition.create(meshdefinition, 64, 32);
	}
	@Override public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		plate_lower.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		plate_middle.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		plate_upper.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		S1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		S2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		S3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		S4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		S5.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		S6.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		S7.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		S8.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		r1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		r2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		r3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		r4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		r5.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		r6.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		r7.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		r8.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		r9.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		r10.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}