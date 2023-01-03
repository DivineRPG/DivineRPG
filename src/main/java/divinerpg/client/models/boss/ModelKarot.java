package divinerpg.client.models.boss;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.boss.EntityKarot;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelKarot extends EntityModel<EntityKarot> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("karot");
	private final ModelPart Head;
	private final ModelPart Body;
	private final ModelPart Leg1;
	private final ModelPart Leg2;
	private final ModelPart Leg3;
	private final ModelPart Leg4;
	private final ModelPart Tail;
	private final ModelPart Shape1;
	private final ModelPart Shape2;
	private final ModelPart Shape3;
	private final ModelPart Shape4;

	public ModelKarot(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Body = root.getChild("Body");
		this.Leg1 = root.getChild("Leg1");
		this.Leg2 = root.getChild("Leg2");
		this.Leg3 = root.getChild("Leg3");
		this.Leg4 = root.getChild("Leg4");
		this.Tail = root.getChild("Tail");
		this.Shape1 = root.getChild("Shape1");
		this.Shape2 = root.getChild("Shape2");
		this.Shape3 = root.getChild("Shape3");
		this.Shape4 = root.getChild("Shape4");
	}
	public ModelKarot(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Head = root.getChild("Head");
		this.Body = root.getChild("Body");
		this.Leg1 = root.getChild("Leg1");
		this.Leg2 = root.getChild("Leg2");
		this.Leg3 = root.getChild("Leg3");
		this.Leg4 = root.getChild("Leg4");
		this.Tail = root.getChild("Tail");
		this.Shape1 = root.getChild("Shape1");
		this.Shape2 = root.getChild("Shape2");
		this.Shape3 = root.getChild("Shape3");
		this.Shape4 = root.getChild("Shape4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubedef = new CubeDeformation(0.0F);

		partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.0F, -3.0F, -2.0F, 6.0F, 6.0F, 4.0F, cubedef).mirror(false)
		.texOffs(16, 10).mirror().addBox(-5.0F, -2.5F, -6.0F, 2.0F, 2.0F, 6.0F, cubedef).mirror(false)
		.texOffs(16, 10).mirror().addBox(3.0F, -2.5F, -6.0F, 2.0F, 2.0F, 6.0F, cubedef).mirror(false)
		.texOffs(16, 14).mirror().addBox(-3.0F, -5.0F, 0.0F, 2.0F, 2.0F, 1.0F, cubedef).mirror(false)
		.texOffs(16, 14).mirror().addBox(1.0F, -5.0F, 0.0F, 2.0F, 2.0F, 1.0F, cubedef).mirror(false), PartPose.offset(-1.0F, 13.5F, -7.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 14.0F, -3.0F));

		Body.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(-4.0F, -5.0F, -5.0F, 6.0F, 9.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, -2.0F, 3.0F, 1.5708F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Leg1", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-1.0F, 0.0F, -0.9F, 2.0F, 8.0F, 2.0F, cubedef).mirror(false), PartPose.offset(-2.5F, 16.0F, 3.0F));

		partdefinition.addOrReplaceChild("Leg2", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-1.0F, 0.0F, -0.9F, 2.0F, 8.0F, 2.0F, cubedef).mirror(false), PartPose.offset(0.5F, 16.0F, 3.0F));

		partdefinition.addOrReplaceChild("Leg3", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-1.0F, 0.0F, -1.1F, 2.0F, 8.0F, 2.0F, cubedef).mirror(false), PartPose.offset(-2.5F, 16.0F, -4.0F));

		partdefinition.addOrReplaceChild("Leg4", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-1.0F, 0.0F, -1.1F, 2.0F, 8.0F, 2.0F, cubedef).mirror(false), PartPose.offset(0.5F, 16.0F, -4.0F));

		partdefinition.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(6, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 1.0F, cubedef).mirror(false), PartPose.offset(-2.0F, 13.0F, 4.0F));

		partdefinition.addOrReplaceChild("Shape1", CubeListBuilder.create().texOffs(50, 18).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offset(0.0F, 9.0F, 0.0F));

		partdefinition.addOrReplaceChild("Shape2", CubeListBuilder.create().texOffs(50, 18).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offset(-4.0F, 9.0F, 0.0F));

		partdefinition.addOrReplaceChild("Shape3", CubeListBuilder.create().texOffs(50, 18).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offset(0.0F, 9.0F, -4.0F));

		partdefinition.addOrReplaceChild("Shape4", CubeListBuilder.create().texOffs(50, 18).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offset(-4.0F, 9.0F, -4.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(EntityKarot entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
        this.Head.xRot = headPitch / (180F / (float) Math.PI);
		this.Body.xRot = ((float)Math.PI / 2F);
        this.Leg1.xRot = (float) (Math.cos(limbSwing * 0.6662) * 1.4 * limbSwingAmount);
        this.Leg2.xRot = (float) (Math.cos(limbSwing * 0.6662 + Math.PI) * 1.4 * limbSwingAmount);
        this.Leg3.xRot = (float) (Math.cos(limbSwing * 0.6662 + Math.PI) * 1.4 * limbSwingAmount);
        this.Leg4.xRot = (float) (Math.cos(limbSwing * 0.6662) * 1.4 * limbSwingAmount);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}