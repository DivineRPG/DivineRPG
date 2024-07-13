package divinerpg.client.models.boss;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.entities.boss.EntityDramix;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelDramix<E extends EntityDivineMonster> extends EntityModel<EntityDramix> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("dramix");
	private final ModelPart Leg_Right;
	private final ModelPart Leg_Left;
	private final ModelPart Arm_Right;
	private final ModelPart Arm_Left;
	private final ModelPart Head;
	private final ModelPart Chest;

	public ModelDramix(ModelPart root) {
		this.Leg_Right = root.getChild("Leg_Right");
		this.Leg_Left = root.getChild("Leg_Left");
		this.Arm_Right = root.getChild("Arm_Right");
		this.Arm_Left = root.getChild("Arm_Left");
		this.Head = root.getChild("Head");
		this.Chest = root.getChild("Chest");
	}

	public ModelDramix(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Leg_Right = root.getChild("Leg_Right");
		this.Leg_Left = root.getChild("Leg_Left");
		this.Arm_Right = root.getChild("Arm_Right");
		this.Arm_Left = root.getChild("Arm_Left");
		this.Head = root.getChild("Head");
		this.Chest = root.getChild("Chest");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubedef = new CubeDeformation(0.0F);

		partdefinition.addOrReplaceChild("Leg_Right", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, -2.0F, -3.0F, 5.0F, 15.0F, 6.0F, cubedef).mirror(false), PartPose.offset(-4.0F, 11.0F, 1.0F));

		partdefinition.addOrReplaceChild("Leg_Left", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-3.0F, -2.0F, -3.0F, 5.0F, 15.0F, 6.0F, cubedef).mirror(false), PartPose.offset(4.0F, 11.0F, 1.0F));

		partdefinition.addOrReplaceChild("Arm_Right", CubeListBuilder.create().texOffs(22, 22).mirror().addBox(-2.0F, -2.0F, -3.0F, 4.0F, 16.0F, 6.0F, cubedef).mirror(false), PartPose.offset(-8.0F, -5.0F, 1.0F));

		partdefinition.addOrReplaceChild("Arm_Left", CubeListBuilder.create().texOffs(22, 22).mirror().addBox(-2.0F, -2.0F, -3.0F, 4.0F, 16.0F, 6.0F, cubedef).mirror(false), PartPose.offset(8.0F, -5.0F, 1.0F));

		partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(36, 0).mirror().addBox(-3.0F, -5.0F, -3.0F, 6.0F, 10.0F, 6.0F, cubedef).mirror(false), PartPose.offset(0.0F, -12.0F, 1.0F));

		partdefinition.addOrReplaceChild("Chest", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-6.0F, -7.0F, -2.0F, 12.0F, 16.0F, 6.0F, cubedef).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(EntityDramix entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Arm_Right.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 2.0F * limbSwingAmount * 0.5F);
        this.Arm_Left.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F);
        this.Arm_Right.zRot = 0.0F;
        this.Leg_Left.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        this.Leg_Right.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
        this.Leg_Left.yRot = 0.0F;
        this.Leg_Right.yRot = 0.0F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
		Leg_Right.render(poseStack, buffer, packedLight, packedOverlay, color);
		Leg_Left.render(poseStack, buffer, packedLight, packedOverlay, color);
		Arm_Right.render(poseStack, buffer, packedLight, packedOverlay, color);
		Arm_Left.render(poseStack, buffer, packedLight, packedOverlay, color);
		Head.render(poseStack, buffer, packedLight, packedOverlay, color);
		Chest.render(poseStack, buffer, packedLight, packedOverlay, color);
	}
}