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

public class ModelHastreus<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("hastreus");
    public final ModelPart body;
    public final ModelPart tail;
    public final ModelPart head;
    public final ModelPart jaw;
    public final ModelPart frontRightLeg;
    public final ModelPart backRightLeg;
    public final ModelPart frontLeftLeg;
    public final ModelPart backLeftLeg;

    public ModelHastreus(ModelPart root) {
        super(root);
        ModelPart rootPart = root.getChild("root");
        this.body = rootPart.getChild("Body");
        this.tail = this.body.getChild("Tail");
        this.head = this.body.getChild("Head");
        this.jaw = this.head.getChild("Jaw");
        this.frontRightLeg = rootPart.getChild("FrontRightLeg");
        this.backRightLeg = rootPart.getChild("BackRightLeg");
        this.frontLeftLeg = rootPart.getChild("FrontLeftLeg");
        this.backLeftLeg = rootPart.getChild("BackLeftLeg");
    }

    public ModelHastreus(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.ZERO);
        CubeDeformation cubeDef = CubeDeformation.NONE;

        PartDefinition Body = root.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 10.0F, -10.0F));

        PartDefinition BackRightSpine = Body.addOrReplaceChild("BackRightSpine", CubeListBuilder.create(), PartPose.offsetAndRotation(-7.5F, -9.0F, 6.0F, -0.5236F, 0.0F, 0.0F));
        BackRightSpine.addOrReplaceChild("backrightspine_r1", CubeListBuilder.create().texOffs(48, 84).addBox(-2.5F, -10.0F, -1.0F, 5.0F, 10.0F, 2.0F, cubeDef), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, -0.2618F, 0.0F, -0.2618F));

        PartDefinition BackLeftSpine = Body.addOrReplaceChild("BackLeftSpine", CubeListBuilder.create(), PartPose.offsetAndRotation(7.5F, -9.0F, 6.0F, -0.5236F, 0.0F, 0.0F));
        BackLeftSpine.addOrReplaceChild("backleftspine_r1", CubeListBuilder.create().texOffs(86, 24).addBox(-2.5F, -10.0F, -1.0F, 5.0F, 10.0F, 2.0F, cubeDef), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, -0.2618F, 0.0F, 0.2618F));

        PartDefinition MiddleRightSpine = Body.addOrReplaceChild("MiddleRightSpine", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0F, -10.0F, 4.0F, -0.48F, 0.0F, 0.0F));
        MiddleRightSpine.addOrReplaceChild("middlerightspine_r1", CubeListBuilder.create().texOffs(65, 83).addBox(-2.0F, -12.0F, -4.5F, 5.0F, 12.0F, 3.0F, cubeDef), PartPose.offsetAndRotation(-0.5F, 0.0F, 2.5F, -0.1309F, 0.0F, -0.1745F));

        PartDefinition MiddleLeftSpine = Body.addOrReplaceChild("MiddleLeftSpine", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, -10.0F, 4.0F, -0.48F, 0.0F, 0.0F));
        MiddleLeftSpine.addOrReplaceChild("middleleftspine_r1", CubeListBuilder.create().texOffs(81, 83).addBox(-3.0F, -12.0F, -4.5F, 5.0F, 12.0F, 3.0F, cubeDef), PartPose.offsetAndRotation(0.5F, 0.0F, 2.5F, -0.1309F, 0.0F, 0.1745F));

        PartDefinition CenterSpine = Body.addOrReplaceChild("CenterSpine", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -10.0F, -1.0F, -0.3927F, 0.0F, 0.0F));
        CenterSpine.addOrReplaceChild("centerspine_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -17.0F, -1.5F, 5.0F, 17.0F, 3.0F, cubeDef), PartPose.offsetAndRotation(-0.5F, 0.0F, 0.5F, -0.1309F, 0.0F, 0.0F));

        PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create(), PartPose.offset(0.0F, -7.0F, 24.0F));
        Tail.addOrReplaceChild("tailtip_r1", CubeListBuilder.create().texOffs(72, 37).addBox(-2.0F, -8.5F, -3.5F, 4.0F, 7.0F, 9.0F, cubeDef), PartPose.offsetAndRotation(0.0F, 1.5F, 9.5F, 0.2182F, 0.0F, 0.0F));
        Tail.addOrReplaceChild("basetail_r1", CubeListBuilder.create().texOffs(0, 55).addBox(-4.0F, -7.5F, -1.0F, 8.0F, 11.0F, 10.0F, cubeDef), PartPose.offsetAndRotation(0.0F, 2.5F, -1.0F, 0.2182F, 0.0F, 0.0F));

        Body.addOrReplaceChild("torso_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-13.5F, -12.0F, -1.0F, 18.0F, 12.0F, 25.0F, cubeDef), PartPose.offsetAndRotation(4.5F, 2.0F, 0.5F, 0.1309F, 0.0F, 0.0F));

        PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(38, 37).addBox(-2.0F, -2.0F, -12.0F, 4.0F, 6.0F, 2.0F, cubeDef)
                .texOffs(0, 37).addBox(-7.0F, -4.0F, -10.0F, 14.0F, 8.0F, 10.0F, cubeDef), PartPose.offset(0.0F, -4.0F, 1.0F));
        Head.addOrReplaceChild("headspike_r1", CubeListBuilder.create().texOffs(32, 84).addBox(-2.0F, -7.0F, -1.5F, 4.0F, 8.0F, 4.0F, cubeDef), PartPose.offsetAndRotation(0.0F, -3.0F, -9.0F, -0.3491F, 0.0F, 0.0F));
        Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(38, 45).addBox(-6.0F, 0.0F, -7.0F, 12.0F, 4.0F, 10.0F, cubeDef), PartPose.offset(0.0F, 4.0F, -3.0F));

        root.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(68, 59).addBox(-8.5F, -2.0F, -3.5F, 8.0F, 16.0F, 8.0F, cubeDef), PartPose.offset(-5.5F, 10.0F, -5.5F));
        root.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(36, 59).addBox(-6.5F, -3.0F, -3.5F, 8.0F, 17.0F, 8.0F, cubeDef), PartPose.offset(-4.5F, 10.0F, 9.5F));
        root.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(0, 76).addBox(0.5F, -2.0F, -3.5F, 8.0F, 16.0F, 8.0F, cubeDef), PartPose.offset(5.5F, 10.0F, -5.5F));
        root.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(61, 0).addBox(-1.5F, -2.0F, -3.5F, 8.0F, 16.0F, 8.0F, cubeDef), PartPose.offset(4.5F, 10.0F, 9.5F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        this.head.yRot = state.yRot * Mth.DEG_TO_RAD;
        this.head.xRot = state.xRot * Mth.DEG_TO_RAD;

        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;

        float f = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        float f1 = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;

        this.tail.yRot = f / 2.0F;
        this.body.zRot = f * 0.05F;

        this.frontRightLeg.xRot = this.backLeftLeg.xRot = f1;
        this.backRightLeg.xRot = this.frontLeftLeg.xRot = f;
    }
}