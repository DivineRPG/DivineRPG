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

public class ModelRotatick<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("rotatick");
    public final ModelPart Body, Head, FrontRightLeg, FrontLeftLeg, MiddleRightLeg, MiddleLeftLeg, BackRightLeg, BackLeftLeg;

    public ModelRotatick(ModelPart root) {
        super(root);
        Body = root.getChild("Body");
        Head = Body.getChild("Head");
        FrontRightLeg = Body.getChild("FrontRightLeg");
        FrontLeftLeg = Body.getChild("FrontLeftLeg");
        MiddleRightLeg = Body.getChild("MiddleRightLeg");
        MiddleLeftLeg = Body.getChild("MiddleLeftLeg");
        BackRightLeg = Body.getChild("BackRightLeg");
        BackLeftLeg = Body.getChild("BackLeftLeg");
    }

    public ModelRotatick(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        CubeDeformation cubeDef = CubeDeformation.NONE;
        PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-7, -4, -7, 14, 4, 14, cubeDef)
                .texOffs(0, 18).addBox(-6, 0, -7, 12, 4, 14, cubeDef), PartPose.offset(0, 16, 2));
        PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(38, 38).addBox(-5, -2, -6, 10, 5, 6, cubeDef)
                .texOffs(0, 36).addBox(-6, -5, -7, 12, 4, 7, cubeDef)
                .texOffs(38, 25).addBox(-3, -1, -7, 6, 4, 1, cubeDef), PartPose.offset(0, 0, -6.99F));
        Head.addOrReplaceChild("RightMandible", CubeListBuilder.create().texOffs(42, 7).addBox(-.5F, -1.5F, -3, 1, 3, 4, cubeDef), PartPose.offset(-5.5F, 2.5F, -5));
        Head.addOrReplaceChild("LeftMandible", CubeListBuilder.create().texOffs(42, 0).addBox(-1, -1, -3, 1, 3, 4, cubeDef), PartPose.offset(6, 2, -5));
        Body.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, 0, -1.5F, 3, 4, 3, cubeDef), PartPose.offset(-5.5F, 3.99F, -3.5F));
        Body.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(38, 18).addBox(-1.5F, 0, -1.5F, 3, 4, 3, cubeDef), PartPose.offset(5.5F, 3.99F, -3.5F));
        Body.addOrReplaceChild("MiddleRightLeg", CubeListBuilder.create().texOffs(0, 7).addBox(-1.5F, 0, -1.5F, 3, 4, 3, cubeDef), PartPose.offset(-5.5F, 3.99F, .5F));
        Body.addOrReplaceChild("MiddleLeftLeg", CubeListBuilder.create().texOffs(31, 36).addBox(-1.5F, 0, -1.5F, 3, 4, 3, cubeDef), PartPose.offset(5.5F, 3.99F, .5F));
        Body.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(0, 18).addBox(-1.5F, 0, -1.5F, 3, 4, 3, cubeDef), PartPose.offset(-5.5F, 3.99F, 4.5F));
        Body.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(0, 25).addBox(-1.5F, 0, -1.5F, 3, 4, 3, cubeDef), PartPose.offset(5.5F, 3.99F, 4.5F));
        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;
        float headPitch = state.xRot * ((float) Math.PI / 180F);
        float netHeadYaw = state.yRot * ((float) Math.PI / 180F);

        Head.yRot = netHeadYaw / 2;
        Head.xRot = headPitch / 2;

        float f = Mth.cos(limbSwing * .6662F) * 1.4F * limbSwingAmount;
        float f1 = Mth.cos(limbSwing * .6662F + Mth.PI) * 1.4F * limbSwingAmount;

        Body.zRot = f * .03F;
        FrontLeftLeg.xRot = MiddleRightLeg.xRot = BackRightLeg.xRot = f;
        FrontRightLeg.xRot = BackLeftLeg.xRot = MiddleLeftLeg.xRot = f1;

        BackRightLeg.yRot = .3F;
        MiddleRightLeg.yRot = .2F;
        FrontRightLeg.yRot = .1F;
        BackLeftLeg.yRot = -.3F;
        MiddleLeftLeg.yRot = -.2F;
        FrontLeftLeg.yRot = -.1F;
    }
}