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


public class ModelSnowSkipper<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("snow_skipper");
    public final ModelPart head;
    public final ModelPart rightWhisker;
    public final ModelPart leftWhisker;
    public final ModelPart body;
    public final ModelPart rightSail;
    public final ModelPart leftSail;
    public final ModelPart tail;
    public final ModelPart rightFrontLeg;
    public final ModelPart rightMiddleLeg;
    public final ModelPart rightHindLeg;
    public final ModelPart leftFrontLeg;
    public final ModelPart leftMiddleLeg;
    public final ModelPart leftHindLeg;

    public ModelSnowSkipper(ModelPart root) {
        super(root);
        ModelPart rootPart = root.getChild("root");
        this.head = rootPart.getChild("head");
        this.rightWhisker = this.head.getChild("right_whisker");
        this.leftWhisker = this.head.getChild("left_whisker");
        this.body = rootPart.getChild("body");
        this.rightSail = this.body.getChild("right_sail");
        this.leftSail = this.body.getChild("left_sail");
        this.tail = this.body.getChild("tail");
        this.rightFrontLeg = this.body.getChild("right_front_leg");
        this.rightMiddleLeg = this.body.getChild("right_middle_leg");
        this.rightHindLeg = this.body.getChild("right_hind_leg");
        this.leftFrontLeg = this.body.getChild("left_front_leg");
        this.leftMiddleLeg = this.body.getChild("left_middle_leg");
        this.leftHindLeg = this.body.getChild("left_hind_leg");
    }

    public ModelSnowSkipper(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.ZERO);
        CubeDeformation cubeDef = CubeDeformation.NONE;

        PartDefinition Head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(12, 9).addBox(-1.0F, -1.5F, -4.0F, 2.0F, 3.0F, 4.0F, cubeDef), PartPose.offset(0.0F, 19.0F, -2.0F));
        Head.addOrReplaceChild("left_whisker", CubeListBuilder.create().texOffs(0, 4).addBox(0.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, cubeDef), PartPose.offsetAndRotation(1.0F, -1.0F, -4.0F, 0.0F, 0.0F, -0.2182F));
        Head.addOrReplaceChild("right_whisker", CubeListBuilder.create().texOffs(0, 3).addBox(-2.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, cubeDef), PartPose.offsetAndRotation(-1.0F, -1.0F, -4.0F, 0.0F, 0.0F, 0.2182F));

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 4.0F, 5.0F, cubeDef)
                .texOffs(13, 0).addBox(0.0F, -3.0F, 3.3F, 0.0F, 2.0F, 3.0F, cubeDef), PartPose.offset(0.0F, 19.0F, -3.0F));

        body.addOrReplaceChild("left_sail", CubeListBuilder.create().texOffs(8, 6).addBox(0.0F, -3.5F, -0.5F, 0.0F, 3.0F, 3.0F, cubeDef), PartPose.offsetAndRotation(1.5F, -0.5F, 0.8F, 0.0F, 0.0F, 0.3054F));
        body.addOrReplaceChild("right_sail", CubeListBuilder.create().texOffs(8, 6).addBox(0.0F, -3.5F, -0.5F, 0.0F, 3.0F, 3.0F, cubeDef), PartPose.offsetAndRotation(-1.5F, -0.5F, 0.8F, 0.0F, 0.0F, -0.3054F));
        body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 9).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 4.0F, cubeDef), PartPose.offset(0.0F, 1.0F, 5.0F));
        body.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(13, 0).addBox(-1.0F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, cubeDef), PartPose.offset(-1.0F, 3.0F, 0.5F));
        body.addOrReplaceChild("right_middle_leg", CubeListBuilder.create().texOffs(0, 9).addBox(-1.0F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, cubeDef), PartPose.offset(-1.0F, 3.0F, 2.5F));
        body.addOrReplaceChild("right_hind_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, cubeDef), PartPose.offset(-1.0F, 3.0F, 4.5F));
        body.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(0, 17).addBox(0.0F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, cubeDef), PartPose.offset(1.0F, 3.0F, 0.5F));
        body.addOrReplaceChild("left_middle_leg", CubeListBuilder.create().texOffs(11, 16).addBox(0.0F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, cubeDef), PartPose.offset(1.0F, 3.0F, 2.5F));
        body.addOrReplaceChild("left_hind_leg", CubeListBuilder.create().texOffs(15, 16).addBox(0.0F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, cubeDef), PartPose.offset(1.0F, 3.0F, 4.5F));

        return LayerDefinition.create(meshdefinition, 24, 24);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        this.head.xRot = state.xRot * Mth.DEG_TO_RAD / 2.0F;
        this.head.yRot = state.yRot * Mth.DEG_TO_RAD / 2.0F;

        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;
        float ageInTicks = state.ageInTicks;

        float f = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        float f1 = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        float f2 = (float) Math.PI / 16.0F + Mth.cos(ageInTicks * 0.05F + limbSwing * 0.2F) * 0.08F + limbSwingAmount * 0.2F;

        this.rightWhisker.yRot = f2 + 0.6981F;
        this.leftWhisker.yRot = -f2 - 0.6981F;
        this.body.zRot = f * 0.02F;
        this.rightSail.yRot = -f2;
        this.leftSail.yRot = f2;
        this.tail.yRot = f * 0.2F;

        this.rightFrontLeg.xRot = f1;
        this.leftMiddleLeg.xRot = f1;
        this.leftHindLeg.xRot = f1;
        this.leftFrontLeg.xRot = f;
        this.rightMiddleLeg.xRot = f;
        this.rightHindLeg.xRot = f;
    }
}