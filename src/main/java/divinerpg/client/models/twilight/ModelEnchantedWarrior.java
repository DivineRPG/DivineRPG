package divinerpg.client.models.twilight;

import divinerpg.entities.apalachia.EntityEnchantedWarrior;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelEnchantedWarrior extends HumanoidModel<EntityEnchantedWarrior> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("enchanted_warrior");
	public ModelEnchantedWarrior(ModelPart part) {super(part);}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = HumanoidModel.createMesh(CubeDeformation.NONE, 0);
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubeDef = CubeDeformation.NONE;
		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(24, 16).addBox(-7, -13, 2, 14, 12, 0, cubeDef)
		.texOffs(24, 0).addBox(-7, -7, -1, 14, 2, 2, cubeDef)
		.texOffs(0, 0).addBox(-4, -8, -4, 8, 8, 8, cubeDef), PartPose.ZERO);
		partdefinition.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(32, 46).addBox(-4, -8, -4, 8, 8, 8, new CubeDeformation(.5F)), PartPose.ZERO);
		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 16).addBox(-4, -7, -2, 8, 14, 4, cubeDef), PartPose.ZERO);
		partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(24, 28).addBox(-3, -2, -2, 4, 14, 4, cubeDef), PartPose.ZERO);
		partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 34).addBox(-1, -2, -2, 4, 14, 4, cubeDef), PartPose.ZERO);
		partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(16, 46).addBox(-2, 0, -2, 4, 14, 4, cubeDef), PartPose.offset(-2, 0, 0));
		partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(40, 28).addBox(-2, 0, -2, 4, 14, 4, cubeDef), PartPose.offset(2, 0, 0));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	@Override public void setupAnim(EntityEnchantedWarrior entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		rightArm.y = leftArm.y = -2;
		rightLeg.y = leftLeg.y = 10;
		head.y = hat.y = -4;
		body.y = 3;
	}
}