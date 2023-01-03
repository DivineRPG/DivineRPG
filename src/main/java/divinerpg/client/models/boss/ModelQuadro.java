package divinerpg.client.models.boss;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.boss.EntityQuadro;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelQuadro extends EntityModel<EntityQuadro> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("quadro");
	private final ModelPart rightleg;
	private final ModelPart leftleg;
	private final ModelPart body1;
	private final ModelPart body2;
	private final ModelPart body3;
	private final ModelPart body4;

	public ModelQuadro(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.rightleg = root.getChild("rightleg");
		this.leftleg = root.getChild("leftleg");
		this.body1 = root.getChild("body1");
		this.body2 = root.getChild("body2");
		this.body3 = root.getChild("body3");
		this.body4 = root.getChild("body4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubedef = new CubeDeformation(0.0F);

		partdefinition.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(101, 16).mirror().addBox(-4.0F, -4.0F, -3.0F, 6.0F, 4.0F, 6.0F, cubedef).mirror(false)
		.texOffs(0, 16).mirror().addBox(-3.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, cubedef).mirror(false)
		.texOffs(19, 17).mirror().addBox(-5.0F, 9.0F, -10.0F, 2.0F, 3.0F, 12.0F, cubedef).mirror(false)
		.texOffs(19, 17).mirror().addBox(1.0F, 9.0F, -10.0F, 2.0F, 3.0F, 12.0F, cubedef).mirror(false), PartPose.offset(-7.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(101, 16).mirror().addBox(-3.0F, -4.0F, -3.0F, 6.0F, 4.0F, 6.0F, cubedef).mirror(false)
		.texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, cubedef).mirror(false)
		.texOffs(19, 17).mirror().addBox(2.0F, 9.0F, -10.0F, 2.0F, 3.0F, 12.0F, cubedef).mirror(false)
		.texOffs(19, 17).mirror().addBox(-4.0F, 9.0F, -10.0F, 2.0F, 3.0F, 12.0F, cubedef).mirror(false), PartPose.offset(8.0F, 12.0F, 0.0F));

		PartDefinition body1 = partdefinition.addOrReplaceChild("body1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		body1.addOrReplaceChild("rotated45_r1", CubeListBuilder.create().texOffs(86, 2).mirror().addBox(-5.0F, -16.0F, -8.0F, 10.0F, 4.0F, 8.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 11.9696F, 0.3473F, 0.1309F, 0.0F, 0.0F));

		body1.addOrReplaceChild("rotated56_r1", CubeListBuilder.create().texOffs(55, 22).mirror().addBox(6.0F, -17.0F, -21.0F, 2.0F, 2.0F, 8.0F, cubedef).mirror(false)
		.texOffs(55, 22).mirror().addBox(-8.0F, -17.0F, -21.0F, 2.0F, 2.0F, 8.0F, cubedef).mirror(false)
		.texOffs(82, 16).mirror().addBox(-9.0F, -27.0F, -13.0F, 4.0F, 12.0F, 4.0F, cubedef).mirror(false)
		.texOffs(82, 16).mirror().addBox(5.0F, -27.0F, -13.0F, 4.0F, 12.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 13.9696F, 0.3473F, 0.0524F, 0.0F, 0.0F));

		body1.addOrReplaceChild("rotated27_r1", CubeListBuilder.create().texOffs(61, 28).mirror().addBox(-25.0F, -19.0F, -5.0F, 6.0F, 2.0F, 2.0F, cubedef).mirror(false)
		.texOffs(61, 28).mirror().addBox(-25.0F, -15.0F, -5.0F, 6.0F, 2.0F, 2.0F, cubedef).mirror(false)
		.texOffs(58, 24).mirror().addBox(-21.0F, -17.0F, -6.0F, 2.0F, 2.0F, 6.0F, cubedef).mirror(false)
		.texOffs(61, 28).mirror().addBox(-25.0F, -19.0F, 4.0F, 6.0F, 2.0F, 2.0F, cubedef).mirror(false)
		.texOffs(61, 28).mirror().addBox(-25.0F, -15.0F, 4.0F, 6.0F, 2.0F, 2.0F, cubedef).mirror(false)
		.texOffs(58, 24).mirror().addBox(-21.0F, -17.0F, 0.0F, 2.0F, 2.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 13.9696F, 0.3473F, 1.5708F, -1.5184F, -1.5708F));

		body1.addOrReplaceChild("rotated48_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -37.0F, -10.0F, 8.0F, 8.0F, 8.0F, cubedef).mirror(false)
		.texOffs(34, 0).mirror().addBox(-3.0F, -30.0F, -7.0F, 6.0F, 12.0F, 4.0F, cubedef).mirror(false)
		.texOffs(56, 1).mirror().addBox(-4.0F, -22.0F, -8.0F, 8.0F, 7.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 10.9696F, 4.3473F, 0.4363F, 0.0F, 0.0F));

		body1.addOrReplaceChild("rotated52_r1", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-7.0F, -26.0F, -10.0F, 4.0F, 2.0F, 2.0F, cubedef).mirror(false)
		.texOffs(40, 16).mirror().addBox(3.0F, -26.0F, -10.0F, 4.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 10.9696F, 4.3473F, 0.288F, 0.0F, 0.0F));

		PartDefinition body2 = partdefinition.addOrReplaceChild("body2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.1745F, -1.5708F, 0.0F));

		body2.addOrReplaceChild("rotated7_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -37.0F, -11.0F, 8.0F, 8.0F, 8.0F, cubedef).mirror(false)
		.texOffs(34, 0).mirror().addBox(-3.0F, -30.0F, -8.0F, 6.0F, 12.0F, 4.0F, cubedef).mirror(false)
		.texOffs(56, 1).mirror().addBox(-4.0F, -22.0F, -9.0F, 8.0F, 7.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, -1.0F, 0.0436F, 0.0F, 0.0F));

		body2.addOrReplaceChild("rotated1_r1", CubeListBuilder.create().texOffs(82, 16).mirror().addBox(5.0F, -23.0F, -18.0F, 4.0F, 12.0F, 4.0F, cubedef).mirror(false)
		.texOffs(55, 22).mirror().addBox(6.0F, -14.0F, -25.0F, 2.0F, 2.0F, 8.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, -1.0F, -0.3491F, 0.0F, 0.0F));

		body2.addOrReplaceChild("rotated53_r1", CubeListBuilder.create().texOffs(55, 22).mirror().addBox(-8.0F, -14.0F, -25.6F, 2.0F, 2.0F, 8.0F, cubedef).mirror(false)
		.texOffs(82, 16).mirror().addBox(-9.0F, -23.0F, -18.6F, 4.0F, 12.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 11.7F, -1.0F, -0.3491F, 0.0F, 0.0F));

		body2.addOrReplaceChild("rotated49_r1", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-7.0F, -25.5F, -11.25F, 4.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 11.7F, -1.0F, -0.096F, 0.0F, 0.0F));

		body2.addOrReplaceChild("rotated50_r1", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(3.0F, -26.0F, -11.0F, 4.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, -1.0F, -0.0785F, 0.0F, 0.0F));

		body2.addOrReplaceChild("rotated14_r1", CubeListBuilder.create().texOffs(86, 2).mirror().addBox(-5.0F, -15.9F, -10.0F, 10.0F, 4.0F, 8.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition body3 = partdefinition.addOrReplaceChild("body3", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-7.0F, -15.0F, -7.7F, 4.0F, 2.0F, 2.0F, cubedef).mirror(false)
		.texOffs(56, 1).mirror().addBox(-4.0F, -10.0F, -9.0F, 8.0F, 7.0F, 6.0F, cubedef).mirror(false)
		.texOffs(34, 0).mirror().addBox(-3.0F, -18.0F, -8.0F, 6.0F, 12.0F, 4.0F, cubedef).mirror(false)
		.texOffs(0, 0).mirror().addBox(-4.0F, -25.0F, -11.0F, 8.0F, 8.0F, 8.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.1745F, -3.1416F, 0.0F));

		body3.addOrReplaceChild("rotated34_r1", CubeListBuilder.create().texOffs(61, 28).mirror().addBox(-29.0F, -13.5F, -2.0F, 6.0F, 2.0F, 2.0F, cubedef).mirror(false)
		.texOffs(61, 28).mirror().addBox(-29.0F, -13.5F, 0.0F, 6.0F, 2.0F, 2.0F, cubedef).mirror(false)
		.texOffs(61, 28).mirror().addBox(-29.0F, -11.5F, 0.0F, 6.0F, 2.0F, 2.0F, cubedef).mirror(false)
		.texOffs(61, 28).mirror().addBox(-29.0F, -11.5F, -2.0F, 6.0F, 2.0F, 2.0F, cubedef).mirror(false)
		.texOffs(61, 28).mirror().addBox(-29.0F, -19.5F, -2.0F, 6.0F, 2.0F, 2.0F, cubedef).mirror(false)
		.texOffs(61, 28).mirror().addBox(-29.0F, -19.5F, 0.0F, 6.0F, 2.0F, 2.0F, cubedef).mirror(false)
		.texOffs(61, 28).mirror().addBox(-29.0F, -17.5F, 0.0F, 6.0F, 2.0F, 2.0F, cubedef).mirror(false)
		.texOffs(61, 28).mirror().addBox(-29.0F, -17.5F, -2.0F, 6.0F, 2.0F, 2.0F, cubedef).mirror(false)
		.texOffs(59, 26).mirror().addBox(-25.0F, -15.5F, -4.0F, 2.0F, 2.0F, 4.0F, cubedef).mirror(false)
		.texOffs(59, 26).mirror().addBox(-25.0F, -15.5F, 0.0F, 2.0F, 2.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, -1.5708F, -1.2305F, 1.5708F));

		body3.addOrReplaceChild("rotated12_r1", CubeListBuilder.create().texOffs(55, 22).mirror().addBox(8.0F, -14.9F, -24.0F, 2.0F, 2.0F, 8.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, -0.3715F, 0.1639F, -0.0602F));

		body3.addOrReplaceChild("rotated19_r1", CubeListBuilder.create().texOffs(55, 22).mirror().addBox(-10.0F, -14.9F, -24.0F, 2.0F, 2.0F, 8.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, -0.3711F, -0.158F, 0.0766F));

		body3.addOrReplaceChild("rotated39_r1", CubeListBuilder.create().texOffs(82, 16).mirror().addBox(5.0F, -24.0F, -17.0F, 4.0F, 12.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		body3.addOrReplaceChild("rotated37_r1", CubeListBuilder.create().texOffs(82, 16).mirror().addBox(-8.8F, -24.0F, -18.0F, 4.0F, 12.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, -0.349F, 0.006F, 0.0164F));

		body3.addOrReplaceChild("rotated42_r1", CubeListBuilder.create().texOffs(86, 2).mirror().addBox(-5.0F, -16.0F, -11.0F, 10.0F, 4.0F, 8.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		body3.addOrReplaceChild("rotated5_r1", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(3.0F, -26.8F, -8.3F, 4.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, -0.0436F, 0.0F, 0.0F));

		PartDefinition body4 = partdefinition.addOrReplaceChild("body4", CubeListBuilder.create().texOffs(82, 16).mirror().addBox(-8.4F, -13.4415F, -15.8112F, 4.0F, 12.0F, 4.0F, cubedef).mirror(false)
		.texOffs(82, 16).mirror().addBox(5.4F, -13.4415F, -15.8112F, 4.0F, 12.0F, 4.0F, cubedef).mirror(false)
		.texOffs(55, 22).mirror().addBox(-7.0F, -4.4415F, -21.8112F, 2.0F, 2.0F, 8.0F, cubedef).mirror(false)
		.texOffs(55, 22).mirror().addBox(-7.0F, -4.4415F, -29.8112F, 2.0F, 2.0F, 8.0F, cubedef).mirror(false)
		.texOffs(55, 22).mirror().addBox(-7.0F, -4.4415F, -37.8112F, 2.0F, 2.0F, 8.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, -0.1745F, 1.5708F, 0.0F));

		body4.addOrReplaceChild("rotated8_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.9F, -36.0F, -9.0F, 8.0F, 8.0F, 8.0F, cubedef).mirror(false)
		.texOffs(34, 0).mirror().addBox(-3.9F, -29.0F, -6.0F, 6.0F, 12.0F, 4.0F, cubedef).mirror(false)
		.texOffs(56, 1).mirror().addBox(-4.9F, -21.0F, -7.0F, 8.0F, 7.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(1.0F, 12.1585F, -0.8112F, 0.3142F, 0.0F, 0.0F));

		body4.addOrReplaceChild("rotated10_r1", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-7.0F, -25.0F, -12.0F, 4.0F, 2.0F, 2.0F, cubedef).mirror(false)
		.texOffs(40, 16).mirror().addBox(2.0F, -25.0F, -12.0F, 4.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(1.0F, 12.1585F, -0.8112F, 0.0524F, 0.0F, 0.0F));

		body4.addOrReplaceChild("rotated18_r1", CubeListBuilder.create().texOffs(86, 2).mirror().addBox(-6.0F, -15.9F, -5.1F, 10.0F, 4.0F, 8.0F, cubedef).mirror(false), PartPose.offsetAndRotation(1.0F, 12.1585F, -0.8112F, 0.1745F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 32);
	}

	@Override
	public void setupAnim(EntityQuadro entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.leftleg.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        this.rightleg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
        int ageInSeconds = (int)limbSwingAmount/20;
        float rotate = 0;
        if(ageInSeconds % 4 == 0) {
        	rotate = 0.05F;
        }
        if(ageInSeconds % 16 == 0) {
        	body1.yRot = 0F;
        	body2.yRot = 0F;
        	body3.yRot = 0F;
        	body4.yRot = 0F;
        }else {
        	body1.yRot += rotate;
        	body2.yRot += rotate;
        	body3.yRot += rotate;
        	body4.yRot += rotate;
        }
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		rightleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}