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
	private final ModelPart P2;
	private final ModelPart S1;
	private final ModelPart S2;
	private final ModelPart S3;
	private final ModelPart S4;
	private final ModelPart r1;
	private final ModelPart r2;
	private final ModelPart r3;
	private final ModelPart r4;
	private final ModelPart r5;
	private final ModelPart r6;
	private final ModelPart r7;
	private final ModelPart r8;
	private final ModelPart r9;
	private final ModelPart r10;
	private final ModelPart S7;
	private final ModelPart S6;
	private final ModelPart S5;
	private final ModelPart S8;
	private final ModelPart P4;
	private final ModelPart P3;

	public ModelArcaniumExtractor(ModelPart root) {
		super(RenderType::entityCutoutNoCull);
		this.P2 = root.getChild("P2");
		this.S1 = root.getChild("S1");
		this.S2 = root.getChild("S2");
		this.S3 = root.getChild("S3");
		this.S4 = root.getChild("S4");
		this.r1 = root.getChild("r1");
		this.r2 = root.getChild("r2");
		this.r3 = root.getChild("r3");
		this.r4 = root.getChild("r4");
		this.r5 = root.getChild("r5");
		this.r6 = root.getChild("r6");
		this.r7 = root.getChild("r7");
		this.r8 = root.getChild("r8");
		this.r9 = root.getChild("r9");
		this.r10 = root.getChild("r10");
		this.S7 = root.getChild("S7");
		this.S6 = root.getChild("S6");
		this.S5 = root.getChild("S5");
		this.S8 = root.getChild("S8");
		this.P4 = root.getChild("P4");
		this.P3 = root.getChild("P3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("P2", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(0.0F, 0.0F, 0.0F, 14.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, 8.0F, -7.0F));

		partdefinition.addOrReplaceChild("S1", CubeListBuilder.create().texOffs(12, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, 10.0F, -5.0F));

		partdefinition.addOrReplaceChild("S2", CubeListBuilder.create().texOffs(12, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, 10.0F, 3.0F));

		partdefinition.addOrReplaceChild("S3", CubeListBuilder.create().texOffs(12, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, 10.0F, 3.0F));

		partdefinition.addOrReplaceChild("S4", CubeListBuilder.create().texOffs(12, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, 10.0F, -5.0F));

		partdefinition.addOrReplaceChild("r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, 20.0F, 0.0F));

		partdefinition.addOrReplaceChild("r2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 20.0F, 4.0F));

		partdefinition.addOrReplaceChild("r3", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 20.0F, -6.0F));

		partdefinition.addOrReplaceChild("r4", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, 20.0F, -4.0F));

		partdefinition.addOrReplaceChild("r5", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 20.0F, -1.0F));

		partdefinition.addOrReplaceChild("r6", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, 20.0F, 2.0F));

		partdefinition.addOrReplaceChild("r7", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 20.0F, -5.0F));

		partdefinition.addOrReplaceChild("r8", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, 20.0F, 5.0F));

		partdefinition.addOrReplaceChild("r9", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 20.0F, 3.0F));

		partdefinition.addOrReplaceChild("r10", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 20.0F, -2.0F));

		partdefinition.addOrReplaceChild("S7", CubeListBuilder.create().texOffs(12, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 0.0F, 2.0F));

		partdefinition.addOrReplaceChild("S6", CubeListBuilder.create().texOffs(12, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 0.0F, 2.0F));

		partdefinition.addOrReplaceChild("S5", CubeListBuilder.create().texOffs(12, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 0.0F, -4.0F));

		partdefinition.addOrReplaceChild("S8", CubeListBuilder.create().texOffs(12, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 0.0F, -4.0F));

		partdefinition.addOrReplaceChild("P4", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(0.0F, 0.0F, 0.0F, 14.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, 18.0F, -7.0F));

		partdefinition.addOrReplaceChild("P3", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(0.0F, 0.0F, 0.0F, 14.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, -1.0F, -7.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}



	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		P2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		S1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		S2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		S3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		S4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
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
		S7.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		S6.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		S5.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		S8.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		P4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		P3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}