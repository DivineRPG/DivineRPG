package divinerpg.client.models.arcana;

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

public class ModelRazorback<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("razorback");
    public final ModelPart spine, body, head, tail, rightFrontLeg, rightHindLeg, leftFrontLeg, leftHindLeg;

    public ModelRazorback(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public ModelRazorback(ModelPart root) {
        super(root);
        ModelPart rootPart = root.getChild("root");
        this.spine = rootPart.getChild("spine");
        this.body = this.spine.getChild("body");
        this.head = this.spine.getChild("head");
        this.tail = this.spine.getChild("tail");
        this.rightFrontLeg = this.spine.getChild("right_front_leg");
        this.rightHindLeg = this.spine.getChild("right_hind_leg");
        this.leftFrontLeg = this.spine.getChild("left_front_leg");
        this.leftHindLeg = this.spine.getChild("left_hind_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.ZERO);
        CubeDeformation cubeDef = CubeDeformation.NONE;

        PartDefinition spine = root.addOrReplaceChild("spine", CubeListBuilder.create(), PartPose.offset(0, 21, 1));

        spine.addOrReplaceChild("head", CubeListBuilder.create().texOffs(13, 23).addBox(-3, -2, -3, 6, 4, 3, cubeDef)
                .texOffs(24, 13).addBox(-3, -4, -3, 6, 2, 3, cubeDef), PartPose.offset(0, -2.99F, -3.99F));

        spine.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(26, 6).addBox(-4, 0, 0, 8, 0, 6, cubeDef)
                .texOffs(26, 0).addBox(-4, -.01F, 0, 8, 0, 6, cubeDef), PartPose.offset(0, -2, 4));

        spine.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4, -5, -3, 8, 5, 8, cubeDef)
                .texOffs(24, 18).addBox(-4, -7, 1, 8, 3, 0, cubeDef)
                .texOffs(0, 13).addBox(-4, -7, -3, 8, 2, 8, cubeDef)
                .texOffs(8, 26).addBox(0, -11, 0, 1, 6, 1, cubeDef)
                .texOffs(24, 30).addBox(2, -8, -2, 1, 3, 1, cubeDef)
                .texOffs(20, 30).addBox(-3, -8, 2, 1, 3, 1, cubeDef)
                .texOffs(12, 30).addBox(2, -9, 2, 1, 4, 1, cubeDef)
                .texOffs(16, 30).addBox(-3, -9, -2, 1, 4, 1, cubeDef)
                .texOffs(0, 15).addBox(0, -8, -4, 0, 3, 8, cubeDef)
                .texOffs(28, 15).addBox(.01F, -8, -4, 0, 3, 8, cubeDef), PartPose.offset(0, 0, -1));

        spine.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(0, 13).addBox(-2, -1, -1, 2, 4, 2, cubeDef), PartPose.offset(-4, 0, -2));
        spine.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(29, 29).addBox(0, -1, -1, 2, 4, 2, cubeDef), PartPose.offset(4, 0, -2));
        spine.addOrReplaceChild("right_hind_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-10, -1, -1, 2, 4, 2, cubeDef), PartPose.offset(4, 0, 3));
        spine.addOrReplaceChild("left_hind_leg", CubeListBuilder.create().texOffs(0, 26).addBox(8, -1, -1, 2, 4, 2, cubeDef), PartPose.offset(-4, 0, 3));

        return LayerDefinition.create(meshdefinition, 48, 48);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);
        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;

        this.head.xRot = state.xRot * Mth.DEG_TO_RAD / 2;
        this.head.yRot = state.yRot * Mth.DEG_TO_RAD / 4;

        float f1 = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        float f2 = Mth.cos(limbSwing * 0.6662F + Mth.PI) * 1.4F * limbSwingAmount;

        this.body.zRot = f1 * 0.03F;
        this.rightHindLeg.xRot = this.leftFrontLeg.xRot = f1;
        this.leftHindLeg.xRot = this.rightFrontLeg.xRot = f2;
        this.tail.yRot = f1 * 0.2F;
    }
}