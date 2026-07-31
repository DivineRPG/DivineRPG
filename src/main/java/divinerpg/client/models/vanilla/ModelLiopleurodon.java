package divinerpg.client.models.vanilla;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.util.Mth;

import static divinerpg.utils.Utils.createLocation;

public class ModelLiopleurodon<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("liopleurodon");
    public final ModelPart body, head, upperJaw, lowerJaw, rightFinFront, leftFinFront, rightFinHind, leftFinHind, tailFront, tailHind, tailFin;

    public ModelLiopleurodon(ModelPart root) {
        super(root);
        body = root.getChild("body");
        head = body.getChild("head");
        upperJaw = head.getChild("upper_jaw");
        lowerJaw = head.getChild("lower_jaw");
        rightFinFront = body.getChild("right_fin_front");
        leftFinFront = body.getChild("left_fin_front");
        rightFinHind = body.getChild("right_fin_hind");
        leftFinHind = body.getChild("left_fin_hind");
        tailFront = body.getChild("tail_front");
        tailHind = tailFront.getChild("tail_hind");
        tailFin = tailHind.getChild("tail_fin");
    }

    public ModelLiopleurodon(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        CubeDeformation cubeDef = CubeDeformation.NONE;
        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -4, -8, 9, 9, 20, cubeDef), PartPose.offset(0, 19, -2));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 58).addBox(-4.5F, -4, -7, 9, 7, 7, new CubeDeformation(.01F)), PartPose.offset(0, 1, -8));
        PartDefinition upperJaw = head.addOrReplaceChild("upper_jaw", CubeListBuilder.create().texOffs(25, 50).addBox(-1.5F, -1.5F, -12, 4, 2, 12, new CubeDeformation(.01F)), PartPose.offset(-.5F, .5F, -7));
        upperJaw.addOrReplaceChild("upper_teeth_right", CubeListBuilder.create().texOffs(60, 0).addBox(0, 0, -12, 2, 0, 12, cubeDef), PartPose.offsetAndRotation(-1.5F, -.5F, 0, 0, 0, Mth.PI / 1.6F));
        upperJaw.addOrReplaceChild("upper_teeth_left", CubeListBuilder.create().texOffs(60, 0).mirror().addBox(-2, 0, -12, 2, 0, 12, cubeDef), PartPose.offsetAndRotation(2.5F, -.5F, 0, 0, 0, -Mth.PI / 1.6F));
        PartDefinition lowerJaw = head.addOrReplaceChild("lower_jaw", CubeListBuilder.create().texOffs(0, 29).addBox(-2, -.49F, -14, 4, 2, 19, new CubeDeformation(.01F)), PartPose.offset(0, 1.5F, -5));
        lowerJaw.addOrReplaceChild("lower_teeth_right", CubeListBuilder.create().texOffs(64, 0).addBox(0, 0, -12, 1, 0, 12, cubeDef), PartPose.offsetAndRotation(-2, .5F, -2, 0, 0, -Mth.PI / 1.6F));
        lowerJaw.addOrReplaceChild("lower_teeth_left", CubeListBuilder.create().texOffs(64, 0).mirror().addBox(-1, 0, -12, 1, 0, 12, cubeDef), PartPose.offsetAndRotation(2, .5F, -2, 0, 0, Mth.PI / 1.6F));
        PartDefinition rightFinFront = body.addOrReplaceChild("right_fin_front", CubeListBuilder.create(), PartPose.offset(-3, 3, -4));
        rightFinFront.addOrReplaceChild("right_fin_front_rot", CubeListBuilder.create().texOffs(22, 64).addBox(-1, -3.18F, -1.93F, 2, 6, 10, cubeDef), PartPose.rotation(.9599F, 0, -1.8675F));
        PartDefinition leftFinFront = body.addOrReplaceChild("left_fin_front", CubeListBuilder.create(), PartPose.offset(3, 3, -4));
        leftFinFront.addOrReplaceChild("left_fin_front_rot", CubeListBuilder.create().texOffs(22, 64).mirror().addBox(-1, -3.18F, -1.93F, 2, 6, 10, cubeDef), PartPose.rotation(.9599F, 0, 1.8675F));
        PartDefinition rightFinHind = body.addOrReplaceChild("right_fin_hind", CubeListBuilder.create(), PartPose.offset(-3, 3, 11));
        rightFinHind.addOrReplaceChild("right_fin_hind_rot", CubeListBuilder.create().texOffs(0, 72).mirror().addBox(-.9F, -2.16F, -.95F, 1, 5, 8, cubeDef), PartPose.rotation(.9599F, 0, -1.8675F));
        PartDefinition leftFinHind = body.addOrReplaceChild("left_fin_hind", CubeListBuilder.create(), PartPose.offset(3, 3, 11));
        leftFinHind.addOrReplaceChild("left_fin_hind_rot", CubeListBuilder.create().texOffs(0, 72).addBox(-.1F, -2.16F, -.95F, 1, 5, 8, cubeDef), PartPose.rotation(.9599F, 0, 1.8675F));
        PartDefinition tailFront = body.addOrReplaceChild("tail_front", CubeListBuilder.create().texOffs(38, 0).addBox(-3, -3, -1, 6, 6, 11, cubeDef), PartPose.offset(0, 1, 12));
        PartDefinition tailHind = tailFront.addOrReplaceChild("tail_hind", CubeListBuilder.create().texOffs(27, 29).addBox(-2, -2, 0, 4, 4, 12, new CubeDeformation(.01F)), PartPose.offset(0, 0, 10));
        PartDefinition tailFin = tailHind.addOrReplaceChild("tail_fin", CubeListBuilder.create(), PartPose.offset(0, .5F, 9));
        tailFin.addOrReplaceChild("tail_fin_down", CubeListBuilder.create().texOffs(0, 0).addBox(0, -2, 0, 1, 3, 8, cubeDef), PartPose.offsetAndRotation(-.5F, .35F, 1, -Mth.PI / 8, 0, 0));
        tailFin.addOrReplaceChild("tail_fin_up", CubeListBuilder.create().texOffs(6, 73).addBox(-1, -3, 0, 2, 4, 12, cubeDef), PartPose.offsetAndRotation(0, .35F, 1, Mth.PI / 8, 0, 0));
        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;
        float ageInTicks = state.ageInTicks;
        float headPitch = state.xRot * ((float) Math.PI / 180F);
        float netHeadYaw = state.yRot * ((float) Math.PI / 180F);

        body.xRot = headPitch / 2;
        body.yRot = netHeadYaw;
        rightFinFront.zRot = leftFinHind.zRot = -Mth.sin(10 * ageInTicks / Mth.RAD_TO_DEG) * .3F;
        leftFinFront.zRot = rightFinHind.zRot = -rightFinFront.zRot;

        if (state.walkAnimationSpeed > 0.00001F) { // approximating movement check from horizontalDistanceSqr
            head.xRot = Mth.cos(limbSwing * .2F) * limbSwingAmount / 8;
            body.xRot += -.05F - .05F * Mth.cos(ageInTicks * .3F);
            tailFront.xRot = tailHind.xRot = -.1F * Mth.cos(ageInTicks * .3F);
            tailFin.xRot = -.2F * Mth.cos(ageInTicks * .3F);
        }
    }
}