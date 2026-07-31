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

public class ModelTwilightGolem<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("twilight_golem");

    public final ModelPart torso;
    public final ModelPart body;
    public final ModelPart headLeft;
    public final ModelPart headRight;
    public final ModelPart rightShoulder;
    public final ModelPart rightArm;
    public final ModelPart rightHand;
    public final ModelPart leftShoulder;
    public final ModelPart leftArm;
    public final ModelPart leftHand;
    public final ModelPart rightLeg;
    public final ModelPart leftLeg;

    public ModelTwilightGolem(ModelPart root) {
        super(root);
        this.torso = root.getChild("torso");
        this.body = root.getChild("body");
        this.headLeft = root.getChild("headLeft");
        this.headRight = root.getChild("headRight");
        this.rightShoulder = root.getChild("rightShoulder");
        this.rightArm = root.getChild("rightArm");
        this.rightHand = root.getChild("rightHand");
        this.leftShoulder = root.getChild("leftShoulder");
        this.leftArm = root.getChild("leftArm");
        this.leftHand = root.getChild("leftHand");
        this.rightLeg = root.getChild("rightLeg");
        this.leftLeg = root.getChild("leftLeg");
    }

    public ModelTwilightGolem(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(64, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 8.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-8.0F, -8.0F, -4.0F));

        partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 20.0F, 12.0F, 12.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-10.0F, -20.0F, -6.0F));

        partdefinition.addOrReplaceChild("headLeft", CubeListBuilder.create().texOffs(0, 44).mirror().addBox(-4.0F, -5.0F, -8.0F, 7.0F, 12.0F, 8.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(5.0F, -20.0F, -2.0F));

        partdefinition.addOrReplaceChild("headRight", CubeListBuilder.create().texOffs(0, 44).mirror().addBox(-4.0F, -5.0F, -8.0F, 7.0F, 12.0F, 8.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-4.0F, -20.0F, -2.0F));

        partdefinition.addOrReplaceChild("rightShoulder", CubeListBuilder.create().texOffs(0, 32).mirror().addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-12.0F, -20.0F, 0.0F));

        partdefinition.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(30, 44).mirror().addBox(-2.0F, 3.0F, -2.0F, 4.0F, 16.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-12.0F, -20.0F, 0.0F));

        partdefinition.addOrReplaceChild("rightHand", CubeListBuilder.create().texOffs(0, 32).mirror().addBox(-3.0F, 19.0F, -3.0F, 6.0F, 6.0F, 6.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-12.0F, -20.0F, 0.0F));

        partdefinition.addOrReplaceChild("leftShoulder", CubeListBuilder.create().texOffs(0, 32).mirror().addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(12.0F, -20.0F, 0.0F));

        partdefinition.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(30, 44).mirror().addBox(-2.0F, 3.0F, -2.0F, 4.0F, 16.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(12.0F, -20.0F, 0.0F));

        partdefinition.addOrReplaceChild("leftHand", CubeListBuilder.create().texOffs(0, 32).mirror().addBox(-3.0F, 19.0F, -3.0F, 6.0F, 6.0F, 6.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(12.0F, -20.0F, 0.0F));

        partdefinition.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(46, 40).mirror().addBox(-4.0F, 0.0F, -4.0F, 8.0F, 16.0F, 8.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-6.0F, 8.0F, 0.0F));

        partdefinition.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(46, 40).mirror().addBox(-4.0F, 0.0F, -4.0F, 8.0F, 16.0F, 8.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(6.0F, 8.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;

        float headPitch = state.xRot * ((float) Math.PI / 180F);
        float netHeadYaw = state.yRot * ((float) Math.PI / 180F);

        this.headLeft.xRot = headPitch;
        this.headRight.xRot = headPitch;
        this.headLeft.yRot = netHeadYaw;
        this.headRight.yRot = netHeadYaw;

        float rightArmAngle = Mth.cos(limbSwing) * limbSwingAmount;
        float leftArmAngle = Mth.cos(limbSwing + (float) Math.PI) * limbSwingAmount * 0.7f;

        this.rightLeg.xRot = rightArmAngle;
        this.rightHand.xRot = rightArmAngle;
        this.rightArm.xRot = rightArmAngle;
        this.rightShoulder.xRot = rightArmAngle;

        this.leftLeg.xRot = leftArmAngle;
        this.leftHand.xRot = leftArmAngle;
        this.leftArm.xRot = leftArmAngle;
        this.leftShoulder.xRot = leftArmAngle;
    }
}