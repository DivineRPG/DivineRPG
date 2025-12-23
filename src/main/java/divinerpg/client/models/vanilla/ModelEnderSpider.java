package divinerpg.client.models.vanilla;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import divinerpg.entities.vanilla.end.EntityEnderSpider;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class ModelEnderSpider<T extends EntityEnderSpider> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("divinerpg", "ender_spider"), "main");
	private final ModelPart head;
	private final ModelPart fang_1;
	private final ModelPart fang_2;
	private final ModelPart body0;
	private final ModelPart body1;
	private final ModelPart leg0;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart leg4;
	private final ModelPart leg5;
	private final ModelPart leg6;
	private final ModelPart leg7;

	private final ModelPart leg0_r1;
	private final ModelPart leg1_r1;
	private final ModelPart leg6_r1;
	private final ModelPart leg7_r1;

	public ModelEnderSpider(ModelPart root) {
		this.head = root.getChild("head");
		this.fang_1 = head.getChild("fang_1");
		this.fang_2 = head.getChild("fang_2");
		this.body0 = root.getChild("body0");
		this.body1 = root.getChild("body1");

		this.leg0 = root.getChild("leg0");
		this.leg1 = root.getChild("leg1");
		this.leg2 = root.getChild("leg2");
		this.leg3 = root.getChild("leg3");
		this.leg4 = root.getChild("leg4");
		this.leg5 = root.getChild("leg5");
		this.leg6 = root.getChild("leg6");
		this.leg7 = root.getChild("leg7");

		// Child leg references
		this.leg0_r1 = leg0.getChild("leg0_r1");
		this.leg1_r1 = leg1.getChild("leg1_r1");
		this.leg6_r1 = leg6.getChild("leg7_r1");
		this.leg7_r1 = leg7.getChild("leg8_r1");
	}

	public ModelEnderSpider(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.head = root.getChild("head");
		this.fang_1 = head.getChild("fang_1");
		this.fang_2 = head.getChild("fang_2");
		this.body0 = root.getChild("body0");
		this.body1 = root.getChild("body1");

		this.leg0 = root.getChild("leg0");
		this.leg1 = root.getChild("leg1");
		this.leg2 = root.getChild("leg2");
		this.leg3 = root.getChild("leg3");
		this.leg4 = root.getChild("leg4");
		this.leg5 = root.getChild("leg5");
		this.leg6 = root.getChild("leg6");
		this.leg7 = root.getChild("leg7");

		// Child leg references
		this.leg0_r1 = leg0.getChild("leg0_r1");
		this.leg1_r1 = leg1.getChild("leg1_r1");
		this.leg6_r1 = leg6.getChild("leg7_r1");
		this.leg7_r1 = leg7.getChild("leg8_r1");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		// HEAD
		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(32, 4).addBox(-4, -4, -8, 8, 8, 8),
				PartPose.offset(0, 15, -3));
		head.addOrReplaceChild("fang_1",
				CubeListBuilder.create().texOffs(24, 7).addBox(-1, -1, 0, 2, 4, 1),
				PartPose.offset(-2, 3, -9));
		head.addOrReplaceChild("fang_2",
				CubeListBuilder.create().texOffs(24, 7).mirror().addBox(-1, -1, -1, 2, 4, 1).mirror(false),
				PartPose.offset(2, 3, -8));

		// BODY
		partdefinition.addOrReplaceChild("body0",
				CubeListBuilder.create().texOffs(0, 0).addBox(-3, -3, -3, 6, 6, 6),
				PartPose.offset(0, 15, 0));
		partdefinition.addOrReplaceChild("body1",
				CubeListBuilder.create()
						.texOffs(0, 12).addBox(-5, -4, -6, 10, 8, 12)
						.texOffs(8, 40).addBox(-4, -7, -4, 8, 3, 8),
				PartPose.offset(0, 15, 9));

		// FRONT LEGS
		PartDefinition leg0 = partdefinition.addOrReplaceChild("leg0",
				CubeListBuilder.create(), PartPose.offsetAndRotation(-4, 15, -2, 0, 0.7854F, -0.7854F));
		leg0.addOrReplaceChild("leg0_r1",
				CubeListBuilder.create()
						.texOffs(16, 32)
						.mirror() // mirror the box so it’s correctly oriented
						.addBox(-10, -1, -1, 10, 2, 2)
						.mirror(false),
				PartPose.offsetAndRotation(1, 0, 0, 0, 0, 1.5708F));


		PartDefinition leg1 = partdefinition.addOrReplaceChild("leg1",
				CubeListBuilder.create(), PartPose.offsetAndRotation(4, 15, -2, 0, -0.7854F, 0.7854F));
		leg1.addOrReplaceChild("leg1_r1",
				CubeListBuilder.create()
						.texOffs(16, 32)
						.addBox(0, -1, -1, 10, 2, 2),
				PartPose.offsetAndRotation(-1, 0, 0, 0, 0, -1.5708F));

		// MIDDLE LEGS
		partdefinition.addOrReplaceChild("leg2",
				CubeListBuilder.create().texOffs(18, 0).addBox(-15, -1, -1, 16, 2, 2),
				PartPose.offsetAndRotation(-4, 15, 0, 0, 0.2618F, -0.6109F));
		partdefinition.addOrReplaceChild("leg3",
				CubeListBuilder.create().texOffs(18, 0).addBox(-1, -1, -1, 16, 2, 2),
				PartPose.offsetAndRotation(4, 15, 0, 0, -0.2618F, 0.6109F));
		partdefinition.addOrReplaceChild("leg4",
				CubeListBuilder.create().texOffs(18, 0).addBox(-15, -1, -1, 16, 2, 2),
				PartPose.offsetAndRotation(-4, 15, 2, 0, -0.2618F, -0.6109F));
		partdefinition.addOrReplaceChild("leg5",
				CubeListBuilder.create().texOffs(18, 0).addBox(-1, -1, -1, 16, 2, 2),
				PartPose.offsetAndRotation(4, 15, 2, 0, 0.2618F, 0.6109F));

		// REAR LEGS
		PartDefinition leg6 = partdefinition.addOrReplaceChild("leg6",
				CubeListBuilder.create().texOffs(16, 36).addBox(-13, -1, -1, 14, 2, 2),
				PartPose.offsetAndRotation(-4, 15, 12, -0.8F, -0.5236F, 0.1699F)); // moved Z from 4 → 12
		leg6.addOrReplaceChild("leg7_r1",
				CubeListBuilder.create().texOffs(8, 32).addBox(-2, 0, -1, 2, 14, 2),
				PartPose.offsetAndRotation(-13, -1, 0, 0, 0, -0.3927F));

		PartDefinition leg7 = partdefinition.addOrReplaceChild("leg7",
				CubeListBuilder.create().texOffs(16, 36).mirror().addBox(-1, -1, -1, 14, 2, 2).mirror(false),
				PartPose.offsetAndRotation(4, 15, 12, -0.8F, 0.5236F, -0.1699F));
		leg7.addOrReplaceChild("leg8_r1",
				CubeListBuilder.create().texOffs(8, 32).mirror().addBox(0, 0, -1, 2, 14, 2).mirror(false),
				PartPose.offsetAndRotation(13, -1, 0, 0, 0, 0.3927F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(EntityEnderSpider entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		// Head rotation
		head.yRot = netHeadYaw * ((float)Math.PI / 180F);
		head.xRot = headPitch * ((float)Math.PI / 180F);

		//TODO - Animate

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int red, int green, int blue) {
		head.render(poseStack, vertexConsumer, red, green, blue);
		body0.render(poseStack, vertexConsumer, red, green, blue);
		body1.render(poseStack, vertexConsumer, red, green, blue);
		leg0.render(poseStack, vertexConsumer, red, green, blue);
		leg1.render(poseStack, vertexConsumer, red, green, blue);
		leg2.render(poseStack, vertexConsumer, red, green, blue);
		leg3.render(poseStack, vertexConsumer, red, green, blue);
		leg4.render(poseStack, vertexConsumer, red, green, blue);
		leg5.render(poseStack, vertexConsumer, red, green, blue);
		leg6.render(poseStack, vertexConsumer, red, green, blue);
		leg7.render(poseStack, vertexConsumer, red, green, blue);
	}
}