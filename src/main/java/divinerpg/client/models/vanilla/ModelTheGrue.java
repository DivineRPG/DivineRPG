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

public class ModelTheGrue<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("the_grue");
    public final ModelPart Body, Tail, Head, RightJaw, LeftJaw, RightLeg, LeftLeg;

    public ModelTheGrue(ModelPart root) {
        super(root);
        Body = root.getChild("Body");
        Tail = Body.getChild("Tail");
        Head = Body.getChild("Head");
        LeftJaw = Head.getChild("LeftJaw");
        RightJaw = Head.getChild("RightJaw");
        RightLeg = root.getChild("RightLeg");
        LeftLeg = root.getChild("LeftLeg");
    }

    public ModelTheGrue(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        CubeDeformation cubeDef = CubeDeformation.NONE;
        PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-5, -3, 0, 10, 14, 15, cubeDef), PartPose.offset(0, 2, -3));
        PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create(), PartPose.offset(0, 1, 15));
        PartDefinition UpperTail = Tail.addOrReplaceChild("UpperTail", CubeListBuilder.create().texOffs(64, 63).addBox(-3, -4, 0, 6, 6, 6, cubeDef), PartPose.ZERO);
        PartDefinition MiddleTail = UpperTail.addOrReplaceChild("MiddleTail", CubeListBuilder.create().texOffs(40, 63).addBox(-3, -4, 0, 6, 6, 6, cubeDef), PartPose.offset(0, 0, 6));
        MiddleTail.addOrReplaceChild("LowerTail", CubeListBuilder.create().texOffs(16, 63).addBox(-3, -4, 0, 6, 6, 6, cubeDef), PartPose.offset(0, 0, 6));
        PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(32, 29).addBox(-4, -7, -16, 8, 6, 8, cubeDef)
                .texOffs(0, 29).addBox(-4, -7, -8, 8, 11, 8, cubeDef), PartPose.offset(0, 1, .01F));
        Head.addOrReplaceChild("RightJaw", CubeListBuilder.create().texOffs(62, 35).addBox(-4, -.5F, -8, 4, 5, 8, cubeDef), PartPose.offset(0, -.5F, -8));
        Head.addOrReplaceChild("LeftJaw", CubeListBuilder.create().texOffs(56, 17).addBox(0, -.5F, -8, 4, 5, 8, cubeDef), PartPose.offset(0, -.5F, -8));
        PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(23, 43).addBox(-5, -6, -5, 3, 11, 9, cubeDef), PartPose.offset(-2.99F, 7.99F, 7));
        RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(50, 0).addBox(-1.5F, 0, -3, 5, 11, 6, cubeDef), PartPose.offset(-3, 5, -2));
        PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(47, 43).addBox(5, -6, -5, 3, 11, 9, cubeDef), PartPose.offset(-.01F, 7.99F, 7));
        LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(0, 48).addBox(-3.5F, 0, -3, 5, 11, 6, cubeDef), PartPose.offset(6, 5, -2));
        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;
        float headPitch = state.xRot * ((float) Math.PI / 180F);
        float netHeadYaw = state.yRot * ((float) Math.PI / 180F);

        Head.yRot = netHeadYaw;
        Head.xRot = headPitch;

        LeftJaw.xRot = RightJaw.xRot = RightJaw.yRot = Mth.sqrt((float)Math.atan(200 * limbSwing) / 3) * limbSwingAmount + .1309F;
        LeftJaw.yRot = -LeftJaw.xRot;

        float f = Mth.cos(limbSwing * .6662F) * limbSwingAmount;
        float f1 = Mth.cos(limbSwing * .6662F + Mth.PI) * 1.4F * limbSwingAmount;
        Body.zRot = f1 * .05F;
        Tail.yRot = f * .4F;
        Tail.xRot = f * .1F;
        RightLeg.xRot = f * 1.4F;
        LeftLeg.xRot = f1;
    }
}