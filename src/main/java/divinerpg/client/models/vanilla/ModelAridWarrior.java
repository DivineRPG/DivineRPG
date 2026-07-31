package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;

import static divinerpg.utils.Utils.createLocation;

public class ModelAridWarrior<S extends HumanoidRenderState> extends HumanoidModel<HumanoidRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("arid_warrior");
    public final ModelPart rightEar;
    public final ModelPart leftEar;
    public final ModelPart cloak;

    public ModelAridWarrior(ModelPart part) {
        super(part);
        this.rightEar = head.getChild("right_ear");
        this.leftEar = head.getChild("left_ear");
        this.cloak = body.getChild("cloak");
    }

    public static LayerDefinition createBodyLayer() {
        CubeDeformation cubeDef = CubeDeformation.NONE;
        MeshDefinition meshdefinition = HumanoidModel.createMesh(cubeDef, 0);
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartPose zPose = PartPose.ZERO;

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4, -8, -4, 8, 8, 8, cubeDef), zPose);

        PartDefinition rightEar = head.addOrReplaceChild("right_ear", CubeListBuilder.create(), PartPose.offset(-4, -7, -1));
        rightEar.addOrReplaceChild("right_ear_rot", CubeListBuilder.create().texOffs(29, 46).addBox(0, -5, 0, 0, 6, 6, cubeDef), PartPose.rotation(0, -Mth.PI / 8, 0));

        PartDefinition leftEar = head.addOrReplaceChild("left_ear", CubeListBuilder.create(), PartPose.offset(4, -7, -1));
        leftEar.addOrReplaceChild("left_ear_rot", CubeListBuilder.create().texOffs(41, 46).addBox(0, -5, 0, 0, 6, 6, cubeDef), PartPose.rotation(0, Mth.PI / 8, 0));

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 16).addBox(-5, -10, -3, 10, 10, 6, cubeDef), zPose);
        body.addOrReplaceChild("hip", CubeListBuilder.create().texOffs(27, 11).addBox(-5, 0, -2, 10, 4, 5, cubeDef), zPose);

        PartDefinition cloak = body.addOrReplaceChild("cloak", CubeListBuilder.create(), PartPose.offset(0, -10, 3));
        cloak.addOrReplaceChild("cloak_rot", CubeListBuilder.create().texOffs(31, 31).addBox(-5, 0, 0, 10, 20, 1, cubeDef), PartPose.rotation(Mth.PI / 18, 0, 0));

        partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(12, 32).addBox(-2, -1, -1.5F, 3, 14, 3, cubeDef), zPose);
        partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 32).addBox(-1, -1, -1.5F, 3, 14, 3, cubeDef), zPose);

        PartDefinition rightLeg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(48, 0).addBox(-2.5F, 0, -2, 4, 5, 4, cubeDef), PartPose.offset(-2, 0, 0));
        rightLeg.addOrReplaceChild("right_foot", CubeListBuilder.create().texOffs(32, 20).addBox(-2, 0, -2, 4, 7, 4, cubeDef), PartPose.offset(-1, 4.99F, 1));

        PartDefinition leftLeg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(48, 20).addBox(-1.5F, 0, -2, 4, 5, 4, cubeDef), PartPose.offset(2, 0, 0));
        leftLeg.addOrReplaceChild("left_foot", CubeListBuilder.create().texOffs(32, 0).addBox(-2, 0, -2, 4, 7, 4, cubeDef), PartPose.offset(1, 4.99F, 1));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(HumanoidRenderState state) {
        super.setupAnim(state);

        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;
        float ageInTicks = state.ageInTicks;

        this.rightEar.yRot = -Mth.cos(ageInTicks * .05F + limbSwing * .5F) * (.08F + limbSwingAmount * .1F);
        this.leftEar.yRot = -this.rightEar.yRot;
        this.cloak.xRot = Mth.sqrt((float) Math.atan(200 * limbSwing)) * limbSwingAmount;

        this.head.y = this.hat.y = -1.99F;
        this.body.y = 8;
        this.rightArm.x = -6;
        this.leftArm.x = -this.rightArm.x;
        this.rightArm.y = this.leftArm.y = -1;
        this.rightArm.z = this.leftArm.z = .5F;
    }

    @Override
    public void translateToHand(HumanoidRenderState state, HumanoidArm arm, PoseStack stack) {
        float f = arm == HumanoidArm.RIGHT ? 1 : -1;
        ModelPart modelpart = this.getArm(arm);
        modelpart.x += f;
        modelpart.translateAndRotate(stack);
        modelpart.x -= f;
        stack.translate(0, .12F, 0);
    }

}