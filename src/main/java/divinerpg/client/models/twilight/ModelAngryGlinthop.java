package divinerpg.client.models.twilight;

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

public class ModelAngryGlinthop<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("angry_glinthop");
    public final ModelPart spine;
    public final ModelPart body;
    public final ModelPart skull;
    public final ModelPart rightWhisker;
    public final ModelPart leftWhisker;
    public final ModelPart rightEar;
    public final ModelPart leftEar;
    public final ModelPart tail;
    public final ModelPart backRightLeg;
    public final ModelPart backLeftLeg;
    public final ModelPart frontRightLeg;
    public final ModelPart frontLeftLeg;

    public ModelAngryGlinthop(ModelPart root) {
        super(root);
        ModelPart rootPart = root.getChild("root");
        this.spine = rootPart.getChild("Spine");
        this.body = this.spine.getChild("Body");
        this.skull = this.body.getChild("Skull");
        this.rightWhisker = this.skull.getChild("RightWhisker");
        this.leftWhisker = this.skull.getChild("LeftWhisker");
        this.rightEar = this.skull.getChild("RightEar");
        this.leftEar = this.skull.getChild("LeftEar");
        this.tail = this.body.getChild("Tail");
        this.backRightLeg = rootPart.getChild("BackRightLeg");
        this.backLeftLeg = rootPart.getChild("BackLeftLeg");
        this.frontRightLeg = rootPart.getChild("FrontRightLeg");
        this.frontLeftLeg = rootPart.getChild("FrontLeftLeg");
    }

    public ModelAngryGlinthop(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.ZERO);
        CubeDeformation cubeDef = CubeDeformation.NONE;

        PartDefinition Spine = root.addOrReplaceChild("Spine", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition Body = Spine.addOrReplaceChild("Body", CubeListBuilder.create()
                .texOffs(46, 28).addBox(-11.0F, -29.0F, -5.0F, 22.0F, 21.0F, 0.0F, cubeDef)
                .texOffs(0, 0).addBox(-5.0F, -23.0F, -8.0F, 10.0F, 11.0F, 17.0F, cubeDef)
                .texOffs(0, 28).addBox(-7.0F, -25.0F, -12.0F, 14.0F, 15.0F, 9.0F, cubeDef), PartPose.ZERO);

        PartDefinition Skull = Body.addOrReplaceChild("Skull", CubeListBuilder.create()
                .texOffs(0, 33).addBox(-1.0F, -2.0F, -9.0F, 2.0F, 2.0F, 2.0F, cubeDef)
                .texOffs(38, 49).addBox(-5.0F, -8.0F, -8.0F, 10.0F, 12.0F, 8.0F, cubeDef), PartPose.offset(0.0F, -18.0F, -11.99F));

        Skull.addOrReplaceChild("RightWhisker", CubeListBuilder.create().texOffs(54, 18).addBox(-8.5F, -4.5F, 0.0F, 9.0F, 9.0F, 0.0F, cubeDef), PartPose.offset(-5.5F, -0.5F, -7.0F));
        Skull.addOrReplaceChild("LeftWhisker", CubeListBuilder.create().texOffs(71, 0).addBox(-0.5F, -4.5F, 0.0F, 9.0F, 9.0F, 0.0F, cubeDef), PartPose.offset(5.5F, -0.5F, -7.0F));

        Skull.addOrReplaceChild("RightEar", CubeListBuilder.create()
                .texOffs(24, 52).addBox(-2.5F, -5.5F, -0.5F, 4.0F, 5.0F, 2.0F, cubeDef)
                .texOffs(0, 28).addBox(-3.5F, -7.5F, 1.5F, 4.0F, 5.0F, 0.0F, cubeDef), PartPose.offset(-2.5F, -7.5F, -1.51F));

        Skull.addOrReplaceChild("LeftEar", CubeListBuilder.create()
                .texOffs(37, 28).addBox(-0.5F, -7.5F, 1.5F, 4.0F, 5.0F, 0.0F, cubeDef)
                .texOffs(66, 49).addBox(-1.5F, -5.5F, -0.5F, 4.0F, 5.0F, 2.0F, cubeDef), PartPose.offset(2.5F, -7.5F, -1.51F));

        Body.addOrReplaceChild("Tail", CubeListBuilder.create()
                .texOffs(68, 63).addBox(-3.0F, -9.75F, 0.5F, 6.0F, 10.0F, 6.0F, cubeDef)
                .texOffs(0, 40).addBox(0.0F, -12.75F, -1.5F, 0.0F, 15.0F, 12.0F, cubeDef), PartPose.offset(0.0F, -19.25F, 8.49F));

        root.addOrReplaceChild("BackRightLeg", CubeListBuilder.create()
                .texOffs(41, 69).addBox(-3.0F, 5.0F, 0.0F, 4.0F, 9.0F, 4.0F, cubeDef)
                .texOffs(54, 0).addBox(-3.0F, -4.0F, -5.0F, 4.0F, 9.0F, 9.0F, cubeDef), PartPose.offset(-3.0F, 10.0F, 6.0F));

        root.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create()
                .texOffs(0, 74).addBox(-1.0F, 5.0F, 0.0F, 4.0F, 9.0F, 4.0F, cubeDef)
                .texOffs(15, 60).addBox(-1.0F, -4.0F, -5.0F, 4.0F, 9.0F, 9.0F, cubeDef), PartPose.offset(3.0F, 10.0F, 6.0F));

        root.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, cubeDef), PartPose.offset(-4.9F, 13.99F, -8.7F));
        root.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(37, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, cubeDef), PartPose.offset(4.9F, 13.99F, -8.7F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        this.skull.yRot = state.yRot * Mth.DEG_TO_RAD;
        this.skull.xRot = state.xRot * Mth.DEG_TO_RAD;

        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;
        float ageInTicks = state.ageInTicks;

        float f = (float) Math.PI * 2.0F + Mth.cos(ageInTicks * 0.05F + limbSwing * 0.1F) * 0.05F + limbSwingAmount * 0.3F;
        this.leftWhisker.yRot = -f;
        this.rightEar.zRot = -f;
        this.rightWhisker.yRot = f;
        this.leftEar.zRot = f;

        float f1 = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        float f2 = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;

        this.body.zRot = f1 * 0.05F;
        this.backRightLeg.xRot = f1;
        this.frontLeftLeg.xRot = f1;
        this.backLeftLeg.xRot = f2;
        this.frontRightLeg.xRot = f2;
        this.tail.yRot = f1 * 0.2F;
    }
}