package divinerpg.client.models.arcana;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelParatiku<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("paratiku");
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart WingRT;
	private final ModelPart WingRB;
	private final ModelPart WingLB;
	private final ModelPart WingLT;
	private final ModelPart Shape1;
	private final ModelPart Shape2;
	private final ModelPart Shape3;

	public ModelParatiku(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.WingRT = root.getChild("WingRT");
		this.WingRB = root.getChild("WingRB");
		this.WingLB = root.getChild("WingLB");
		this.WingLT = root.getChild("WingLT");
		this.Shape1 = root.getChild("Shape1");
		this.Shape2 = root.getChild("Shape2");
		this.Shape3 = root.getChild("Shape3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 7).mirror().addBox(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 6.0F, -8.0F));

		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(19, 0).mirror().addBox(-6.0F, -10.0F, -7.0F, 12.0F, 22.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 11.0F, 2.0F, 0.8644F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("WingRT", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-14.0F, 0.0F, -5.0F, 14.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.0F, 7.0F, 0.0F, -0.733F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("WingRB", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-14.0F, 0.0F, -5.0F, 14.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.0F, 14.0F, 0.0F, -0.733F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("WingLB", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, -5.0F, 14.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.0F, 14.0F, 0.0F, -0.733F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("WingLT", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, -5.0F, 14.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.0F, 7.0F, 0.0F, -0.733F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Shape1", CubeListBuilder.create().texOffs(13, 21).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 4.0F, 10.0F, -0.2603F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Shape2", CubeListBuilder.create().texOffs(13, 21).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -4.0F, 0.0F, -0.2603F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Shape3", CubeListBuilder.create().texOffs(13, 21).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -1.0F, 5.0F, -0.2603F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.xRot = headPitch / (180F / (float)Math.PI);
		this.head.yRot = netHeadYaw / (180F / (float)Math.PI);
		this.head.zRot = 0.0F;
		this.body.xRot = ((float)Math.PI / 4F) + Mth.cos(ageInTicks * 0.1F) * 0.15F;
		this.body.yRot = 0.0F;
		this.WingRT.yRot = Mth.cos(ageInTicks * 1.3F) * (float)Math.PI * 0.25F;
		this.WingLT.yRot = -this.WingRT.yRot;

		this.WingRB.yRot = Mth.cos(ageInTicks * 1.3F) * (float)Math.PI * 0.25F;
		this.WingLB.yRot = -this.WingRB.yRot;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		WingRT.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		WingRB.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		WingLB.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		WingLT.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Shape1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Shape2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Shape3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}