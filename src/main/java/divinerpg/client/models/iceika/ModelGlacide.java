package divinerpg.client.models.iceika;

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

public class ModelGlacide<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("glacide");
    public final ModelPart spine;
    public final ModelPart rightSail;
    public final ModelPart leftSail;
    public final ModelPart head;
    public final ModelPart frontLeftLeg;
    public final ModelPart frontLeftLowerLeg;
    public final ModelPart backLeftLeg;
    public final ModelPart backLeftLowerLeg;
    public final ModelPart frontRightLeg;
    public final ModelPart frontRightLowerLeg;
    public final ModelPart backRightLeg;
    public final ModelPart backRightLowerLeg;

    public ModelGlacide(ModelPart root) {
        super(root);
        ModelPart rootPart = root.getChild("root");
        this.spine = rootPart.getChild("Spine");
        this.rightSail = this.spine.getChild("RightSail");
        this.leftSail = this.spine.getChild("LeftSail");
        this.head = this.spine.getChild("Head");
        this.frontLeftLeg = rootPart.getChild("FrontLeftLeg");
        this.frontLeftLowerLeg = this.frontLeftLeg.getChild("FrontLeftLowerLeg");
        this.backLeftLeg = rootPart.getChild("BackLeftLeg");
        this.backLeftLowerLeg = this.backLeftLeg.getChild("BackLeftLowerLeg");
        this.frontRightLeg = rootPart.getChild("FrontRightLeg");
        this.frontRightLowerLeg = this.frontRightLeg.getChild("FrontRightLowerLeg");
        this.backRightLeg = rootPart.getChild("BackRightLeg");
        this.backRightLowerLeg = this.backRightLeg.getChild("BackRightLowerLeg");
    }

    public ModelGlacide(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.ZERO);
        CubeDeformation cubeDef = CubeDeformation.NONE;

        PartDefinition Spine = root.addOrReplaceChild("Spine", CubeListBuilder.create().texOffs(46, 35).addBox(-6.0F, -6.0F, -15.0F, 12.0F, 13.0F, 10.0F, cubeDef)
                .texOffs(48, 0).addBox(-6.0F, -2.0F, -5.0F, 12.0F, 11.0F, 9.0F, cubeDef)
                .texOffs(0, 0).addBox(-6.0F, -6.0F, 4.0F, 12.0F, 11.0F, 24.0F, cubeDef)
                .texOffs(90, 0).addBox(-8.0F, 4.0F, -4.0F, 3.0F, 9.0F, 6.0F, cubeDef)
                .texOffs(93, 61).addBox(5.0F, 4.0F, -3.0F, 3.0F, 9.0F, 5.0F, cubeDef), PartPose.offset(0.0F, -1.0F, 0.0F));

        Spine.addOrReplaceChild("RightSail", CubeListBuilder.create().texOffs(0, 30).addBox(0.0F, -18.0F, -2.0F, 0.0F, 18.0F, 23.0F, cubeDef), PartPose.offset(-5.0F, -6.0F, -7.0F));

        Spine.addOrReplaceChild("LeftSail", CubeListBuilder.create().texOffs(0, 12).addBox(0.0F, -18.0F, -2.0F, 0.0F, 18.0F, 23.0F, cubeDef), PartPose.offset(5.0F, -6.0F, -7.0F));

        PartDefinition FrontLeftLeg = root.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(90, 40).addBox(0.0F, -5.0F, -3.0F, 3.0F, 16.0F, 5.0F, cubeDef), PartPose.offset(5.0F, 3.0F, -11.0F));

        FrontLeftLeg.addOrReplaceChild("FrontLeftLowerLeg", CubeListBuilder.create().texOffs(66, 79).addBox(-1.0F, 0.0F, -5.0F, 5.0F, 15.0F, 5.0F, cubeDef), PartPose.offset(0.0F, 5.99F, -0.99F));

        PartDefinition BackLeftLeg = root.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(71, 58).addBox(0.0F, -4.0F, -3.0F, 5.0F, 15.0F, 6.0F, cubeDef), PartPose.offset(3.0F, 3.0F, 9.0F));

        BackLeftLeg.addOrReplaceChild("BackLeftLowerLeg", CubeListBuilder.create().texOffs(46, 79).addBox(2.0F, 0.0F, 0.0F, 4.0F, 16.0F, 6.0F, cubeDef), PartPose.offset(0.01F, 4.99F, 0.99F));

        PartDefinition FrontRightLeg = root.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(86, 79).addBox(-3.0F, -5.0F, -3.0F, 3.0F, 16.0F, 5.0F, cubeDef), PartPose.offset(-5.0F, 3.0F, -11.0F));

        FrontRightLeg.addOrReplaceChild("FrontRightLowerLeg", CubeListBuilder.create().texOffs(80, 20).addBox(-4.0F, 0.0F, -5.0F, 5.0F, 15.0F, 5.0F, cubeDef), PartPose.offset(0.0F, 5.99F, -0.99F));

        PartDefinition BackRightLeg = root.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -4.0F, -3.0F, 5.0F, 15.0F, 6.0F, cubeDef), PartPose.offset(-3.0F, 3.0F, 9.0F));

        BackRightLeg.addOrReplaceChild("BackRightLowerLeg", CubeListBuilder.create().texOffs(26, 79).addBox(-6.0F, 0.0F, 0.0F, 4.0F, 16.0F, 6.0F, cubeDef), PartPose.offset(0.01F, 4.99F, 0.99F));

        Spine.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 71).addBox(-4.0F, -19.0F, -5.0F, 8.0F, 23.0F, 5.0F, cubeDef), PartPose.offset(0.0F, 4.0F, -14.0F));

        Spine.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -4.0F, -12.0F, 2.0F, 3.0F, 0.0F, cubeDef)
                .texOffs(0, 107).addBox(3.0F, -4.0F, -12.0F, 2.0F, 3.0F, 0.0F, cubeDef)
                .texOffs(33, 58).addBox(-3.0F, -4.0F, -12.0F, 6.0F, 8.0F, 13.0F, cubeDef)
                .texOffs(106, 110).addBox(3.0F, -11.0F, -2.0F, 0.0F, 7.0F, 11.0F, cubeDef)
                .texOffs(106, 110).addBox(-3.0F, -11.0F, -2.0F, 0.0F, 7.0F, 11.0F, cubeDef), PartPose.offset(0.0F, -15.0F, -18.0F));

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

        float f = Mth.cos(limbSwing * 0.6F) * 0.9F * limbSwingAmount;
        float f1 = Mth.cos(limbSwing * 0.6F + (float) Math.PI) * 0.9F * limbSwingAmount;
        float f2 = (float) Math.PI / 16.0F + Mth.cos(ageInTicks * 0.05F + limbSwing * 0.2F) * 0.08F + limbSwingAmount * 0.2F;

        this.spine.zRot = f * 0.02F;
        this.rightSail.yRot = -f2;
        this.leftSail.yRot = f2;

        this.frontRightLeg.xRot = this.backLeftLeg.xRot = f1;
        this.backRightLeg.xRot = this.frontLeftLeg.xRot = f;

        float lowLegMov = Mth.abs(Mth.cos(limbSwing * 0.5F)) * 0.7F * limbSwingAmount;
        float lowLegMov1 = Mth.abs(Mth.cos(limbSwing * 0.5F + (float) Math.PI)) * 0.7F * limbSwingAmount;

        this.frontRightLowerLeg.xRot = this.backLeftLowerLeg.xRot = lowLegMov;
        this.backRightLowerLeg.xRot = this.frontLeftLowerLeg.xRot = lowLegMov1;
    }
}