package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.IAttackTimer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.world.entity.TamableAnimal;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelStoneGolem<T extends TamableAnimal> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("stone_golem");
	private final ModelPart crystal, rings, head, Body, leftarm, rightarm;

	public ModelStoneGolem(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.crystal = root.getChild("crystal");
		this.rings = root.getChild("rings");
		this.head = root.getChild("head");
		this.Body = root.getChild("Body");
		this.leftarm = root.getChild("leftarm");
		this.rightarm = root.getChild("rightarm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("crystal", CubeListBuilder.create().texOffs(104, 94).mirror().addBox(-2.4216F, -2.3006F, -2.4172F, 5.0F, 5.0F, 5.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(0.0F, 2.0F, -1.0F, 0.7854F, 0.4363F, 0.6109F));

		partdefinition.addOrReplaceChild("rings", CubeListBuilder.create().texOffs(52, 117).mirror().addBox(1.5F, 4.0F, 2.0F, 7.0F, 0.0F, 7.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(52, 94).mirror().addBox(-1.5F, -4.0F, -2.0F, 13.0F, 0.0F, 13.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(52, 107).mirror().addBox(0.0F, 0.0F, 0.0F, 10.0F, 0.0F, 10.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-4.0F, 12.0F, -5.0F));

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(38, 0).mirror().addBox(-4.5F, -2.0F, -5.0F, 11.0F, 4.0F, 11.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(0, 0).mirror().addBox(-4.0F, -6.0F, -3.0F, 10.0F, 4.0F, 9.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(90, 16).mirror().addBox(-4.0F, -11.0F, 2.0F, 10.0F, 3.0F, 4.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(82, 0).mirror().addBox(-4.0F, -4.0F, -4.0F, 10.0F, 6.0F, 1.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(82, 7).mirror().addBox(-4.0F, -6.0F, -4.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(86, 7).mirror().addBox(-1.0F, -6.0F, -4.0F, 4.0F, 2.0F, 1.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(82, 7).mirror().addBox(5.0F, -6.0F, -4.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(0, 40).mirror().addBox(-4.0F, -8.0F, -4.0F, 10.0F, 2.0F, 10.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-1.0F, -22.0F, -1.0F));

		head.addOrReplaceChild("crown1_r1", CubeListBuilder.create().texOffs(56, 16).mirror().addBox(-4.0F, -3.9F, -5.7F, 8.0F, 4.0F, 7.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(1.0F, -7.0F, 3.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(7.5F, -9.2F, -2.0F, 10.0F, 10.0F, 11.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(0, 18).mirror().addBox(-2.0F, 0.0F, -2.0F, 10.0F, 10.0F, 11.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-5.0F, -13.5F, -4.0F, 0.0F, 0.0F, 0.7854F));

		Body.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(0, 68).mirror().addBox(-12.0F, -11.0F, -7.0F, 28.0F, 13.0F, 13.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(5.0F, 0.5F, 4.0F, 0.0F, 0.0F, -0.7854F));

		partdefinition.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(0, 94).mirror().addBox(-6.0F, -6.0F, -7.0F, 12.0F, 12.0F, 14.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(40, 42).mirror().addBox(-3.0F, 5.0F, -4.0F, 8.0F, 13.0F, 8.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(82, 69).mirror().addBox(-3.0F, 18.0F, -5.0F, 9.0F, 13.0F, 10.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(82, 28).mirror().addBox(-3.5F, 30.0F, -5.5F, 10.0F, 3.0F, 11.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(82, 28).mirror().addBox(0.5F, 33.0F, -4.5F, 2.0F, 3.0F, 1.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(82, 28).mirror().addBox(-2.5F, 33.0F, -1.0F, 1.0F, 3.0F, 2.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(82, 28).mirror().addBox(0.5F, 33.0F, 3.5F, 2.0F, 3.0F, 1.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(82, 28).mirror().addBox(4.5F, 33.0F, -1.0F, 1.0F, 3.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(18.0F, -16.0F, -0.5F));

		partdefinition.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(0, 94).mirror().addBox(-6.0F, -6.0F, -7.0F, 12.0F, 12.0F, 14.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(40, 42).mirror().addBox(-5.0F, 5.0F, -4.0F, 8.0F, 13.0F, 8.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(82, 69).mirror().addBox(-6.0F, 18.0F, -5.0F, 9.0F, 13.0F, 10.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(82, 28).mirror().addBox(-6.5F, 30.0F, -5.5F, 10.0F, 3.0F, 11.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(82, 28).mirror().addBox(-5.5F, 33.0F, -1.0F, 1.0F, 3.0F, 2.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(82, 28).mirror().addBox(-2.5F, 33.0F, 3.5F, 2.0F, 3.0F, 1.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(82, 28).mirror().addBox(1.5F, 33.0F, -1.0F, 1.0F, 3.0F, 2.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(82, 28).mirror().addBox(-2.5F, 33.0F, -4.5F, 2.0F, 3.0F, 1.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-18.0F, -16.0F, -0.5F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		crystal.xRot += (float) (Math.cos(ageInTicks * 0.3F) * Math.PI * 0.30F);
		crystal.yRot += (float) (Math.cos(ageInTicks * 0.3F) * Math.PI * 0.30F);
	}
	@Override
    public void prepareMobModel(T e, float par2, float par3, float par4) {
        float r = 0;
        float armR = (float) (Math.cos(par2 * 0.6662F + Math.PI) * par3 * 0.5F);
        float armL = (float) (Math.cos(par2 * 0.6662F) * par3 * 0.5F);
        if (((IAttackTimer) e).getAttackTimer() > 0) {
            r = this.getSwingAngle((float) ((IAttackTimer) e).getAttackTimer() - par4, 10) - 1;
        }
        this.rightarm.xRot = r + armR;
        this.leftarm.xRot = r + armL;
    }

    private float getSwingAngle(float timer, float maxTimer) {
        return (Math.abs(timer - maxTimer / 2) - maxTimer * 0.25F) / (maxTimer * 0.25F);
    }

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		crystal.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rings.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}