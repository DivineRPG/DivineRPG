package divinerpg.client.models.iceika;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.util.Mth;

import static divinerpg.utils.Utils.createLocation;

public class ModelMamoth<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("mamoth");
    public final ModelPart head;
    public final ModelPart body;
    public final ModelPart frontLeftLeg;
    public final ModelPart frontRightLeg;
    public final ModelPart backLeftLeg;
    public final ModelPart backRightLeg;
    public final ModelPart rightEar;
    public final ModelPart leftEar;

    public ModelMamoth(ModelPart root) {
        super(root);
        ModelPart rootPart = root.getChild("root");
        this.head = rootPart.getChild("Head");
        this.rightEar = this.head.getChild("RightEar");
        this.leftEar = this.head.getChild("LeftEar");
        this.body = rootPart.getChild("Body");
        this.frontRightLeg = this.body.getChild("FrontRightLeg");
        this.frontLeftLeg = this.body.getChild("FrontLeftLeg");
        ModelPart hip = this.body.getChild("Hip");
        this.backRightLeg = hip.getChild("BackRightLeg");
        this.backLeftLeg = hip.getChild("BackLeftLeg");
    }

    public ModelMamoth(Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.ZERO);

        PartDefinition Head = root.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 58).addBox(-4.0F, -3.0F, -10.0F, 8.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, -14.0F));

        PartDefinition LeftEar = Head.addOrReplaceChild("LeftEar", CubeListBuilder.create(), PartPose.offset(3.0F, -2.0F, -4.0F));

        LeftEar.addOrReplaceChild("BottomLeftEar", CubeListBuilder.create().texOffs(82, 69).addBox(-0.5F, 0.0F, 0.0F, 13.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -1.0F, 0.0F, -0.0349F, -0.1222F, 0.2618F));

        LeftEar.addOrReplaceChild("TopLeftEar", CubeListBuilder.create().texOffs(72, 43).addBox(0.0F, -12.5F, 0.0F, 16.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, -1.0F, -0.0438F, -0.1745F, 0.0038F));

        PartDefinition RightEar = Head.addOrReplaceChild("RightEar", CubeListBuilder.create(), PartPose.offset(-3.0F, -2.0F, -4.0F));

        RightEar.addOrReplaceChild("BottomRightEar", CubeListBuilder.create().texOffs(80, 19).addBox(-11.5F, 0.0F, 0.0F, 13.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -1.0F, 0.0F, -0.0349F, 0.1222F, -0.2618F));

        RightEar.addOrReplaceChild("TopRightEar", CubeListBuilder.create().texOffs(81, 56).addBox(-16.0F, -12.5F, 0.0F, 16.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, -1.0F, 0.0F, 0.1745F, 0.0F));

        Head.addOrReplaceChild("Trunk", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, -9.0F));

        Head.addOrReplaceChild("LeftMandible", CubeListBuilder.create().texOffs(91, 79).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 3.0F, -9.0F, -0.2618F, 0.0F, -0.3927F));

        Head.addOrReplaceChild("RightMandible", CubeListBuilder.create().texOffs(89, 29).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 3.0F, -9.0F, -0.2618F, 0.0F, 0.3927F));

        PartDefinition Body = root.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 8.0F, -12.0F));

        Body.addOrReplaceChild("chest_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -10.0F, -8.5F, 16.0F, 14.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 6.5F, 0.3491F, 0.0F, 0.0F));

        Body.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(45, 49).addBox(-5.0F, -1.0F, -5.0F, 9.0F, 14.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.3054F));

        Body.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(53, 20).addBox(-4.0F, 0.0F, -5.0F, 9.0F, 14.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 3.0F, 3.0F, 0.0F, 0.0F, -0.3054F));

        PartDefinition Hip = Body.addOrReplaceChild("Hip", CubeListBuilder.create().texOffs(0, 29).addBox(-6.0F, -6.0F, -1.5F, 12.0F, 14.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 9.5F, 0.0F, 0.0F, 0.0F));

        Hip.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(27, 72).addBox(-5.0F, 0.0F, -4.5F, 7.0F, 14.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 7.0F, 6.0F, 0.0F, 0.0F, 0.3927F));

        Hip.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(59, 72).addBox(-2.0F, 0.0F, -4.5F, 7.0F, 14.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 7.0F, 6.0F, 0.0F, 0.0F, -0.3927F));

        Hip.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(62, 0).addBox(-3.5F, -7.0F, 0.0F, 7.0F, 10.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(0, 78).addBox(-2.5F, -6.0F, 6.0F, 5.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 12.5F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        this.head.yRot = state.yRot * Mth.DEG_TO_RAD;
        this.head.xRot = state.xRot * Mth.DEG_TO_RAD;

        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;
        float ageInTicks = state.ageInTicks;

        // If your entity has a custom flying check in state or flags, adapt accordingly.
        // For standard walking/ground animation:
        this.frontLeftLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.3F * limbSwingAmount;
        this.backLeftLeg.xRot = -Mth.cos(limbSwing * 0.6662F) * 1.3F * limbSwingAmount;
        this.frontRightLeg.xRot = -Mth.cos(limbSwing * 0.6662F) * 1.3F * limbSwingAmount;
        this.backRightLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.3F * limbSwingAmount;
        this.body.zRot = Mth.sin(limbSwing * 0.3331F) * 0.2F * limbSwingAmount;
        this.rightEar.xRot = 0.0F;
        this.leftEar.xRot = 0.0F;
        this.body.xRot = 0.0F;
        this.leftEar.zRot = 0.0F;
        this.rightEar.zRot = 0.0F;
    }
}