package divinerpg.client.models.iceika;

import com.mojang.blaze3d.vertex.PoseStack;
import divinerpg.entities.iceika.groglin.Groglin;
import divinerpg.items.base.ItemModRanged;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.item.BowItem;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelGroglin extends HumanoidModel<Groglin> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("groglin");
	public ModelGroglin(ModelPart part) {super(part);}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = HumanoidModel.createMesh(CubeDeformation.NONE, 0);
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubeDef = CubeDeformation.NONE;
		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(32, 34).addBox(4, -9, 0, 1, 5, 5, cubeDef)
		.texOffs(32, 24).addBox(-5, -9, 0, 1, 5, 5, cubeDef)
		.texOffs(0, 0).addBox(-1, -3, -6, 2, 5, 2, cubeDef)
		.texOffs(0, 0).addBox(-4, -7, -4, 8, 7, 8, cubeDef), PartPose.offset(0, 0, -1));
		partdefinition.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(20, 44).addBox(-4, -7, -4, 8, 7, 8, new CubeDeformation(.5F)), PartPose.ZERO);
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
		body.addOrReplaceChild("spine", CubeListBuilder.create().texOffs(0, 14).addBox(-4, -5, -2, 8, 12, 4, cubeDef), PartPose.offset(0, 1, 0));
		partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(24, 14).addBox(-1, -2, -2, 2, 11, 4, cubeDef)
		.texOffs(48, 16).addBox(-1.5F, 5, -2.5F, 3, 2, 5, cubeDef), PartPose.offset(-5, 0, -1));
		partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(48, 0).addBox(-1.5F, 5, -2.5F, 3, 2, 5, cubeDef)
		.texOffs(20, 29).addBox(-1, -2, -2, 2, 11, 4, cubeDef), PartPose.offset(5, 0, -1));
		partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 42).addBox(-2, 3, -2.5F, 4, 2, 5, cubeDef)
		.texOffs(32, 0).addBox(-1.5F, 0, -2, 3, 8, 4, cubeDef), PartPose.offset(-2.5F, 0, -1));
		partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 42).addBox(-2, 3, -2.5F, 4, 2, 5, cubeDef)
		.texOffs(0, 30).addBox(-1.5F, 0, -2, 3, 8, 4, cubeDef), PartPose.offset(2.5F, 0, -1));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	@Override public void prepareMobModel(Groglin entity, float limbSwing, float limbSwingAmount, float ageInTicks) {
		rightArmPose = leftArmPose = HumanoidModel.ArmPose.EMPTY;
		if((entity.getMainHandItem().getItem() instanceof BowItem || entity.getMainHandItem().getItem() instanceof ItemModRanged) && entity.isAggressive()) {
			if(entity.getMainArm() == HumanoidArm.RIGHT) rightArmPose = HumanoidModel.ArmPose.BOW_AND_ARROW;
			else leftArmPose = HumanoidModel.ArmPose.BOW_AND_ARROW;
		} super.prepareMobModel(entity, limbSwing, limbSwingAmount, ageInTicks);
	}
	@Override public void setupAnim(Groglin entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		rightArm.y = leftArm.y = 6;
		rightLeg.y = leftLeg.y = 16;
		head.y = hat.y = 4;
		body.y = 8;
	}
	@Override public void translateToHand(HumanoidArm arm, PoseStack stack) {
		float f = arm == HumanoidArm.RIGHT ? 1 : -1;
		ModelPart modelpart = getArm(arm);
		modelpart.x += f;
		modelpart.translateAndRotate(stack);
		modelpart.x -= f;
	}
}