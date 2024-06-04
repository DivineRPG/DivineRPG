package divinerpg.client.models.iceika;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.iceika.EntityPaleArcher;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.item.*;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelPaleArcher extends HumanoidModel<EntityPaleArcher> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("pale_archer");
    public ModelPaleArcher(ModelPart part) {super(part);}
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = HumanoidModel.createMesh(CubeDeformation.NONE, 0);
        PartDefinition partdefinition = meshdefinition.getRoot();
        CubeDeformation cubeDef = CubeDeformation.NONE;
        partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(24, 8).addBox(-4, -12, -4, 8, 4, 8, cubeDef)
        .texOffs(0, 0).addBox(-4, -8, -4, 8, 8, 8, cubeDef), PartPose.offsetAndRotation(0, 0, 1, .0692F, 0, 0));
        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(28, 20).addBox(-4, -12, -2, 8, 12, 4, cubeDef)
        .texOffs(0, 16).addBox(-4.5F, -12.3F, -2.5F, 9, 12, 5, cubeDef), PartPose.offset(0, 0, 3));
        partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(24, 36).addBox(-1, 0, -1, 2, 12, 2, cubeDef), PartPose.offset(0, 3, 0));
        partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(32, 36).addBox(-1, 0, -1, 2, 12, 2, cubeDef), PartPose.offset(0, 3, 0));
        body.addOrReplaceChild("trail", CubeListBuilder.create().texOffs(0, 33).addBox(-4, 2, 1, 8, 7, 4, cubeDef), PartPose.offsetAndRotation(.01F, -1, -3, .2618F, 0, 0));
        return LayerDefinition.create(meshdefinition, 64, 64);
    }
    @Override public void prepareMobModel(EntityPaleArcher entity, float limbSwing, float limbSwingAmount, float ageInTicks) {
        rightArmPose = leftArmPose = HumanoidModel.ArmPose.EMPTY;
        if(entity.getMainHandItem().getItem() instanceof BowItem && entity.isAggressive()) {
            if(entity.getMainArm() == HumanoidArm.RIGHT) rightArmPose = HumanoidModel.ArmPose.BOW_AND_ARROW;
            else leftArmPose = HumanoidModel.ArmPose.BOW_AND_ARROW;
        } super.prepareMobModel(entity, limbSwing, limbSwingAmount, ageInTicks);
    }
    @Override public void setupAnim(EntityPaleArcher entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        if(!entity.isAggressive()) rightArm.xRot = leftArm.xRot = Mth.sqrt((float)Math.atan(200 * limbSwing)) * limbSwingAmount + .1565F;
        body.xRot = .1565F;
        rightArm.zRot = .2182F;
        leftArm.zRot = -.2182F;
        rightArm.z = leftArm.z = 0;
        head.y = hat.y = 2;
        body.y = 14;
        ItemStack itemstack = entity.getMainHandItem();
        if(entity.isAggressive() && (itemstack.isEmpty() || !(itemstack.getItem() instanceof BowItem))) {
            float f1 = Mth.sin(attackTime * Mth.PI);
            float f2 = Mth.sin((1 - (1 - attackTime) * (1 - attackTime)) * Mth.PI);
            rightArm.yRot = f1 * .6F - .1F;
            leftArm.yRot = .1F - f1 * .6F;
            rightArm.xRot = leftArm.xRot = -Mth.HALF_PI;
            rightArm.xRot -= f1 * 1.2F - f2 * .4F;
            leftArm.xRot -= f1 * 1.2F - f2 * .4F;
            AnimationUtils.bobArms(rightArm, leftArm, ageInTicks);
        }
    }
    @Override public void translateToHand(HumanoidArm arm, PoseStack stack) {
        float f = arm == HumanoidArm.RIGHT ? 1 : -1;
        ModelPart modelpart = getArm(arm);
        modelpart.x += f;
        modelpart.translateAndRotate(stack);
        modelpart.x -= f;
    }
    @Override public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        rightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        leftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}