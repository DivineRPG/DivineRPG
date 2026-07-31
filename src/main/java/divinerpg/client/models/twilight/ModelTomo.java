package divinerpg.client.models.twilight;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.util.Mth;

import static divinerpg.utils.Utils.createLocation;

public class ModelTomo<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("apalachia_tomo");
    public final ModelPart body, rightAntenna, leftAntenna, rightArm, leftArm, rightLeg, leftLeg;

    public ModelTomo(ModelPart root) {
        super(root);
        body = root.getChild("body");
        rightAntenna = body.getChild("right_antenna");
        leftAntenna = body.getChild("left_antenna");
        rightArm = body.getChild("right_arm");
        leftArm = body.getChild("left_arm");
        rightLeg = root.getChild("right_leg");
        leftLeg = root.getChild("left_leg");
    }

    public ModelTomo(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        CubeDeformation cubeDef = CubeDeformation.NONE;
        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-6, -7, -4, 12, 8, 9, cubeDef)
                .texOffs(0, 17).addBox(-6, -7, -5, 12, 8, 1, cubeDef), PartPose.offset(0, 20, 0));
        PartDefinition rightAntenna = body.addOrReplaceChild("right_antenna", CubeListBuilder.create(), PartPose.offset(-2.5F, -6, 0));
        rightAntenna.addOrReplaceChild("right_antenna_rot", CubeListBuilder.create()
                .texOffs(37, 37).addBox(-1.5F, -6.5F, -3, 3, 3, 3, cubeDef)
                .texOffs(28, 32).addBox(-1.5F, -5, -1.5F, 3, 5, 3, cubeDef)
                .texOffs(38, 20).addBox(-2, -7, -2.5F, 4, 4, 2, cubeDef), PartPose.rotation(Mth.PI / 36, Mth.PI / 18, -Mth.PI / 16));
        PartDefinition leftAntenna = body.addOrReplaceChild("left_antenna", CubeListBuilder.create(), PartPose.offset(2.5F, -6, 0));
        leftAntenna.addOrReplaceChild("left_antenna_rot", CubeListBuilder.create()
                .texOffs(37, 29).addBox(-1.5F, -6.5F, -3, 3, 3, 3, cubeDef)
                .texOffs(16, 32).addBox(-1.5F, -5, -1.5F, 3, 5, 3, cubeDef)
                .texOffs(0, 36).addBox(-2, -7, -2.5F, 4, 4, 2, cubeDef), PartPose.rotation(Mth.PI / 36, -Mth.PI / 18, Mth.PI / 16));
        PartDefinition rightArm = body.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-6, -5, -.5F));
        rightArm.addOrReplaceChild("right_arm_rot", CubeListBuilder.create().texOffs(33, 0).addBox(-4, -1, -1.5F, 4, 2, 3, cubeDef), PartPose.rotation(0, 0, Mth.PI / 6 - .5F));
        PartDefinition leftArm = body.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(6, -5, -.5F));
        leftArm.addOrReplaceChild("left_arm_rot", CubeListBuilder.create().texOffs(26, 17).addBox(0, -1, -1.5F, 4, 2, 3, cubeDef), PartPose.rotation(0, 0, .5F - Mth.PI / 6));
        partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(22, 22).addBox(-2, 0, -1, 4, 6, 4, cubeDef), PartPose.offset(-3, 18, -1));
        partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 26).addBox(-2, 0, -1, 4, 6, 4, cubeDef), PartPose.offset(3, 18, -1));
        return LayerDefinition.create(meshdefinition, 64, 48);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;
        float ageInTicks = state.ageInTicks;

        float g = ageInTicks * .1F + limbSwing * .5F;
        float g2 = .08F + limbSwingAmount * .4F;
        float f = -Mth.cos(g * 1.2F) * g2;
        float f1 = Mth.cos(g) * g2;
        float f2 = Mth.cos(limbSwing * .6662F) * limbSwingAmount;
        body.zRot = f2 * .8F;
        rightAntenna.zRot = leftArm.zRot = f;
        leftAntenna.zRot = rightArm.zRot = f1;
        rightLeg.xRot = f2 * .7F;
        leftLeg.xRot = -rightLeg.xRot;
    }

}