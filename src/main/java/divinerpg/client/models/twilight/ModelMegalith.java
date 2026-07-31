package divinerpg.client.models.twilight;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.util.Mth;

import static divinerpg.utils.Utils.createLocation;

public class ModelMegalith<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("megalith");
    private final ModelPart torso;
    private final ModelPart body;
    private final ModelPart rightArm;
    private final ModelPart rightHand;
    private final ModelPart leftArm;
    private final ModelPart leftHand;
    private final ModelPart rightLeg;
    private final ModelPart leftLeg;
    private final ModelPart upperBody;
    private final ModelPart head;

    public ModelMegalith(ModelPart root) {
        super(root);
        this.torso = root.getChild("torso");
        this.body = root.getChild("body");
        this.rightArm = root.getChild("rightArm");
        this.rightHand = root.getChild("rightHand");
        this.leftArm = root.getChild("leftArm");
        this.leftHand = root.getChild("leftHand");
        this.rightLeg = root.getChild("rightLeg");
        this.leftLeg = root.getChild("leftLeg");
        this.upperBody = root.getChild("upperBody");
        this.head = root.getChild("head");
    }

    public ModelMegalith(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(64, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-8.0F, -8.0F, -4.0F));

        partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 20.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-10.0F, -20.0F, -6.0F));

        partdefinition.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(30, 42).mirror().addBox(-3.0F, 3.0F, -3.0F, 6.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-13.0F, -32.0F, 0.0F, 0.0F, 0.0F, 0.0873F));

        partdefinition.addOrReplaceChild("rightHand", CubeListBuilder.create().texOffs(0, 24).mirror().addBox(-4.5F, 19.0F, -4.5F, 9.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-13.0F, -32.0F, 0.0F, 0.0F, 0.0F, 0.0873F));

        partdefinition.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(30, 42).mirror().addBox(-3.0F, 3.0F, -3.0F, 6.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(13.0F, -32.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

        partdefinition.addOrReplaceChild("leftHand", CubeListBuilder.create().texOffs(0, 24).mirror().addBox(-4.5F, 19.0F, -4.5F, 9.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(13.0F, -32.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

        partdefinition.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(54, 38).mirror().addBox(-4.0F, 0.0F, -5.0F, 8.0F, 16.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.0F, 8.0F, 0.0F));

        partdefinition.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(54, 38).mirror().addBox(-4.0F, 0.0F, -5.0F, 8.0F, 16.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(6.0F, 8.0F, 0.0F));

        partdefinition.addOrReplaceChild("upperBody", CubeListBuilder.create().texOffs(112, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 22.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-11.0F, -32.0F, -7.0F));

        partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 49).mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -41.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 256, 64);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;
        float netHeadYaw = state.yRot;

        this.head.yRot = netHeadYaw * Mth.DEG_TO_RAD;
        this.leftLeg.xRot = this.rightHand.xRot = this.rightArm.xRot = Mth.cos(limbSwing) * limbSwingAmount;
        this.rightLeg.xRot = this.leftHand.xRot = this.leftArm.xRot = Mth.cos(limbSwing + (float) Math.PI) * limbSwingAmount * 0.7f;
    }
}