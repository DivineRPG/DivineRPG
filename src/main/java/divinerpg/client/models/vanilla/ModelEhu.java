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

public class ModelEhu<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("ehu");
    public final ModelPart body;
    public final ModelPart head;
    public final ModelPart BackRightLeg;
    public final ModelPart BackLeftLeg;
    public final ModelPart FrontRightLeg;
    public final ModelPart FrontLeftLeg;

    public ModelEhu(ModelPart root) {
        super(root);
        body = root.getChild("body");
        head = body.getChild("head");
        BackRightLeg = root.getChild("BackRightLeg");
        BackLeftLeg = root.getChild("BackLeftLeg");
        FrontRightLeg = root.getChild("FrontRightLeg");
        FrontLeftLeg = root.getChild("FrontLeftLeg");
    }

    public ModelEhu(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        CubeDeformation cubeDef = CubeDeformation.NONE;

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 46).addBox(-5, -4, -6.01F, 10, 8, 0, cubeDef)
                .texOffs(0, 25).addBox(0, -7, -6, 0, 3, 9, cubeDef)
                .texOffs(0, 0).addBox(-5, -4, -6, 10, 8, 10, cubeDef), PartPose.ZERO);

        body.addOrReplaceChild("lowerbody", CubeListBuilder.create().texOffs(0, 18).addBox(-5.5F, -5.5F, 0, 11, 9, 7, cubeDef), PartPose.offset(0, 1, 0));
        body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(30, 0).addBox(-4, -3, -3, 8, 6, 4, cubeDef)
                .texOffs(0, 0).addBox(-1, -1, -3.5F, 2, 2, 1, cubeDef), PartPose.offset(0, 0, -5.99F));

        partdefinition.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(31, 29).addBox(-2, 0, -2, 4, 7, 5, cubeDef), PartPose.offset(-4, 0, 3));
        partdefinition.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(13, 34).addBox(-2, 0, -2, 4, 7, 5, cubeDef), PartPose.offset(4, 0, 3));
        partdefinition.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(36, 14).addBox(-2.5F, 0, -2, 4, 6, 4, cubeDef), PartPose.offset(-3, 0, -3));
        partdefinition.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(31, 41).addBox(-1.5F, 0, -2, 4, 6, 4, cubeDef), PartPose.offset(3, 0, -3));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;
        float ageInTicks = state.ageInTicks;
        float headPitch = state.xRot * ((float) Math.PI / 180F);
        float netHeadYaw = state.yRot * ((float) Math.PI / 180F);

        head.xRot = headPitch / 2;
        head.yRot = netHeadYaw / 2;

        float f = Mth.cos(limbSwing * .6662F) * 1.4F * limbSwingAmount;
        float f1 = Mth.cos(limbSwing * .6662F + Mth.PI) * 1.4F * limbSwingAmount;

        boolean isSitting = false;

        if (isSitting) {
            body.y = 19.5F;
            body.zRot = 0;
            FrontLeftLeg.y = FrontRightLeg.y = 22.5F;
            BackLeftLeg.y = BackRightLeg.y = 21.99F;
            FrontLeftLeg.xRot = FrontRightLeg.xRot = BackLeftLeg.xRot = BackRightLeg.xRot = 0;
            BackRightLeg.zRot = FrontRightLeg.zRot = Mth.HALF_PI;
            BackLeftLeg.zRot = FrontLeftLeg.zRot = -Mth.HALF_PI;
        } else {
            body.y = 16;
            body.zRot = f * .05F;
            FrontLeftLeg.y = FrontRightLeg.y = BackLeftLeg.y = BackRightLeg.y = 18;
            BackRightLeg.zRot = BackLeftLeg.zRot = FrontRightLeg.zRot = FrontLeftLeg.zRot = 0;
            FrontRightLeg.xRot = BackLeftLeg.xRot = f1;
            FrontLeftLeg.xRot = BackRightLeg.xRot = f;
        }
    }
}