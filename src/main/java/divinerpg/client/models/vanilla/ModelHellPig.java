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

public class ModelHellPig<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("hell_pig");
    public final ModelPart Body;
    public final ModelPart Head;
    public final ModelPart LeftEar;
    public final ModelPart RightEar;
    public final ModelPart BackRightLeg;
    public final ModelPart BackLeftLeg;
    public final ModelPart FrontRightLeg;
    public final ModelPart FrontLeftLeg;

    public ModelHellPig(ModelPart root) {
        super(root);
        Body = root.getChild("Body");
        Head = Body.getChild("Head");
        LeftEar = Head.getChild("LeftEar");
        RightEar = Head.getChild("RightEar");
        BackRightLeg = root.getChild("BackRightLeg");
        BackLeftLeg = root.getChild("BackLeftLeg");
        FrontRightLeg = root.getChild("FrontRightLeg");
        FrontLeftLeg = root.getChild("FrontLeftLeg");
    }

    public ModelHellPig(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        CubeDeformation cubeDef = CubeDeformation.NONE;

        PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 50).addBox(-8, -3, 1.99F, 10, 8, 0, cubeDef) //Collar
                .texOffs(0, 0).addBox(-8, -3, 2, 10, 9, 14, cubeDef), PartPose.offset(3, 9, -9));

        PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 23).addBox(-4, -5, -6, 8, 8, 6, cubeDef)
                .texOffs(12, 37).addBox(-2.5F, -1, -6.99F, 5, 3, 1, cubeDef) //Snout
                .texOffs(-1, 52).addBox(0, -10, -7, 0, 5, 7, cubeDef), PartPose.offset(-3, .5F, 2.01F)); //Crest

        Head.addOrReplaceChild("RightEar", CubeListBuilder.create().texOffs(0, 0).addBox(-1, 0, -2, 1, 7, 4, cubeDef), PartPose.offset(-4, -3, -3));
        Head.addOrReplaceChild("LeftEar", CubeListBuilder.create().texOffs(40, 32).addBox(0, 0, -2, 1, 7, 4, cubeDef), PartPose.offset(4, -3, -3));

        partdefinition.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(28, 23).addBox(-2, 0, -2, 4, 9, 4, cubeDef), PartPose.offset(-2.99F, 14.99F, 4.99F));
        partdefinition.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(34, 0).addBox(-2, 0, -2, 4, 9, 4, cubeDef), PartPose.offset(2.99F, 14.99F, 4.99F));
        partdefinition.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(0, 37).addBox(-2, 0, -2, 4, 9, 4, cubeDef), PartPose.offset(-2.99F, 14.99F, -4.99F));
        partdefinition.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(24, 36).addBox(-2, 0, -2, 4, 9, 4, cubeDef), PartPose.offset(2.99F, 14.99F, -4.99F));

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

        Head.xRot = headPitch;
        Head.yRot = netHeadYaw;

        float f1 = ageInTicks * .1F + limbSwing * .5F;
        float f2 = .08F + limbSwingAmount * .4F;
        RightEar.zRot = (float) Math.PI / 12.0F + Mth.cos(f1) * f2;
        LeftEar.zRot = -(float) Math.PI / 12.0F - Mth.cos(f1 * 1.2F) * f2;

        float f3 = Mth.cos(limbSwing * .6662F) * 1.4F * limbSwingAmount;
        float f4 = Mth.cos(limbSwing * .6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        Body.zRot = f3 * .04F;
        BackRightLeg.xRot = FrontLeftLeg.xRot = f3;
        BackLeftLeg.xRot = FrontRightLeg.xRot = f4;
    }
}