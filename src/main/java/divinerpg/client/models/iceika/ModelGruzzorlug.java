package divinerpg.client.models.iceika;

import com.mojang.blaze3d.vertex.PoseStack;
import divinerpg.entities.iceika.gruzzorlug.Gruzzorlug;
import divinerpg.items.base.ItemModRanged;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.item.BowItem;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelGruzzorlug extends HumanoidModel<Gruzzorlug> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("gruzzorlug");
	public final ModelPart eyebrow = head.getChild("eyebrow");
	public ModelGruzzorlug(ModelPart part) {super(part);}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = HumanoidModel.createMesh(CubeDeformation.NONE, 0);
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubeDef = CubeDeformation.NONE;
		PartDefinition Head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(24, 0).addBox(-3, -7, -3, 6, 7, 6, cubeDef)
		.texOffs(20, 0).addBox(-1, -4, -4, 2, 3, 1, cubeDef)
		.texOffs(0, 0).addBox(-4, -2, -4.99F, 8, 8, 2, cubeDef)
		.texOffs(0, 0).addBox(0, -14, -3, 0, 12, 12, cubeDef), PartPose.ZERO);
		Head.addOrReplaceChild("eyebrow", CubeListBuilder.create().texOffs(42, 0).addBox(-4, -1, -1, 8, 2, 2, cubeDef), PartPose.offset(0, 0, -3.99F));
		Head.addOrReplaceChild("moustache", CubeListBuilder.create().texOffs(44, 19).addBox(-5, -2.5F, -1.25F, 10, 3, 2, cubeDef), PartPose.offset(0, .18F, -4));
		partdefinition.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(24, 47).addBox(-3, -7, -3, 6, 7, 6, new CubeDeformation(.5F)), PartPose.ZERO);
		PartDefinition Body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(19, 19).addBox(-5, -10, -3, 10, 11, 5, cubeDef), PartPose.offset(0, 0, .5F));
		Body.addOrReplaceChild("belly", CubeListBuilder.create().texOffs(8, 35).addBox(-5.5F, 7, -4, 11, 4, 3, cubeDef), PartPose.offset(0, -10.5F, -1.01F));
		partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 24).addBox(-2, 0, -2.5F, 4, 6, 5, cubeDef), PartPose.offset(-3, 0, -1.5F));
		partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(43, 8).addBox(-2, 0, -2.5F, 4, 6, 5, cubeDef), PartPose.offset(3, 0, -1.5F));
		partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(44, 30).addBox(-1.5F, -1, -2.5F, 3, 12, 5, cubeDef), PartPose.offset(0, 0, -.5F));
		partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(8, 42).addBox(-1.5F, -1, -2.5F, 3, 12, 5, cubeDef), PartPose.offset(0, 0, -.5F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	@Override public void prepareMobModel(Gruzzorlug entity, float limbSwing, float limbSwingAmount, float ageInTicks) {
		rightArmPose = leftArmPose = HumanoidModel.ArmPose.EMPTY;
		if((entity.getMainHandItem().getItem() instanceof BowItem || entity.getMainHandItem().getItem() instanceof ItemModRanged) && entity.isAggressive()) {
			if(entity.getMainArm() == HumanoidArm.RIGHT) rightArmPose = HumanoidModel.ArmPose.BOW_AND_ARROW;
			else leftArmPose = HumanoidModel.ArmPose.BOW_AND_ARROW;
		} super.prepareMobModel(entity, limbSwing, limbSwingAmount, ageInTicks);
	}
	@Override public void setupAnim(Gruzzorlug entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		rightArm.y = leftArm.y = 8;
		rightArm.x = -6.5F;
		leftArm.x = 6.5F;
		rightLeg.y = leftLeg.y = 18;
		if(entity.isAggressive()) eyebrow.y = -5;
		else eyebrow.y = -4;
		head.y = hat.y = 7.01F;
		body.y = 17;
	}
	@Override public void translateToHand(HumanoidArm arm, PoseStack stack) {
		float f = arm == HumanoidArm.RIGHT ? 1 : -1;
		ModelPart modelpart = getArm(arm);
		modelpart.x += f;
		modelpart.translateAndRotate(stack);
		modelpart.x -= f;
	}
}