package divinerpg.client.models.iceika;

import divinerpg.client.models.state.RollumRenderState;
import net.minecraft.client.model.AnimationUtils;
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
import net.minecraft.util.Mth;

import static divinerpg.utils.Utils.createLocation;

public class ModelRollum<S extends RollumRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("rollum");
    public final ModelPart torso;
    public final ModelPart head;
    public final ModelPart rightArm;
    public final ModelPart leftArm;
    public final ModelPart rightLeg;
    public final ModelPart leftLeg;

    public ModelRollum(ModelPart root) {
        super(root);
        this.torso = root.getChild("Torso");
        this.head = this.torso.getChild("Head");
        this.rightArm = this.torso.getChild("RightArm");
        this.leftArm = this.torso.getChild("LeftArm");
        this.rightLeg = root.getChild("RightLeg");
        this.leftLeg = root.getChild("LeftLeg");
    }

    public ModelRollum(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot();
        CubeDeformation cubeDef = CubeDeformation.NONE;

        PartDefinition Torso = root.addOrReplaceChild("Torso", CubeListBuilder.create(), PartPose.offset(0.0F, 7.0F, 0.0F));
        Torso.addOrReplaceChild("Torso_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -14.0F, -2.8F, 16.0F, 14.0F, 12.0F, cubeDef), PartPose.offsetAndRotation(0.0F, 0.0F, -0.2F, 0.48F, 0.0F, 0.0F));
        Torso.addOrReplaceChild("Hip", CubeListBuilder.create().texOffs(0, 26).addBox(-7.0F, 0.0F, -5.0F, 14.0F, 8.0F, 9.0F, cubeDef), PartPose.offset(0.0F, -1.0F, 2.0F));

        PartDefinition Head = Torso.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(38, 35).addBox(-5.0F, -4.0F, -9.0F, 10.0F, 7.0F, 8.0F, cubeDef), PartPose.offset(0.0F, -8.37F, -4.7F));

        PartDefinition RightArm = Torso.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(56, 0).addBox(-7.0F, -4F, -7.0F, 7.0F, 7.0F, 9.0F, cubeDef), PartPose.offset(-7.9F, -9.67F, 1.3F));
        RightArm.addOrReplaceChild("RightLowerArm", CubeListBuilder.create().texOffs(0, 43).addBox(-1.0F, -1.0F, -4.0F, 5.0F, 13.0F, 9.0F, cubeDef), PartPose.offset(-6.0F, 4.0F, -3.0F));

        PartDefinition LeftArm = Torso.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(47, 17).addBox(0.0F, -4.0F, -5.0F, 7.0F, 7.0F, 9.0F, cubeDef), PartPose.offset(7.9F, -9.67F, -0.7F));
        LeftArm.addOrReplaceChild("LeftLowerArm", CubeListBuilder.create().texOffs(28, 50).addBox(-4.0F, -1.0F, -4.0F, 5.0F, 13.0F, 9.0F, cubeDef), PartPose.offset(6.0F, 4.0F, -1.0F));

        root.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 65).addBox(-4.0F, 0.0F, -4.0F, 6.0F, 10.0F, 8.0F, cubeDef), PartPose.offset(-3.0F, 14.0F, 1.0F));
        root.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(56, 50).addBox(-2.0F, 0.0F, -4.0F, 6.0F, 10.0F, 8.0F, cubeDef), PartPose.offset(3.0F, 14.0F, 1.0F));

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

        float f = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
        float f1 = Mth.cos(limbSwing * 0.6662F + Mth.PI) * limbSwingAmount;

        this.torso.zRot = f * 0.05F;
        this.rightArm.xRot = f1;
        this.leftArm.xRot = f;
        this.rightArm.yRot = 0.0F;
        this.leftArm.yRot = 0.0F;
        this.rightArm.zRot = 0.0F;
        this.leftArm.zRot = 0.0F;

        AnimationUtils.bobModelPart(this.rightArm, ageInTicks, 1.0F);
        AnimationUtils.bobModelPart(this.leftArm, ageInTicks, -1.0F);

        this.rightLeg.xRot = f * 1.4F;
        this.leftLeg.xRot = f1 * 1.4F;

        float attackTime = state.attackTime;
        if (attackTime > 0.0F) {
            ModelPart modelpart = this.rightArm;
            float fAnim = attackTime;
            this.torso.yRot = Mth.sin(Mth.sqrt(fAnim) * (Mth.PI * 2.0F)) * 0.2F;
            this.rightArm.yRot += this.torso.yRot;

            fAnim = 1.0F - attackTime;
            fAnim *= fAnim;
            fAnim *= fAnim;
            fAnim = 1.0F - fAnim;

            float f1Anim = Mth.sin(fAnim * Mth.PI);
            float f2Anim = Mth.sin(attackTime * Mth.PI) * -(this.head.xRot - 0.7F) * 0.75F;
            modelpart.xRot -= f1Anim * 1.2F + f2Anim;
            modelpart.yRot += this.torso.yRot * 2.0F;
            modelpart.zRot += Mth.sin(attackTime * Mth.PI) * -0.4F;
        }
    }
}