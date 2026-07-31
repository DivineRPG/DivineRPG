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
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

import static divinerpg.utils.Utils.createLocation;


public class ModelKingCrab<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("king_crab");
    public final ModelPart Body;
    public final ModelPart LeftClaw;
    public final ModelPart RightClaw;
    public final ModelPart FrontRightLeg;
    public final ModelPart BackRightLeg;
    public final ModelPart MiddleRightLeg;
    public final ModelPart MiddleLeftLeg;
    public final ModelPart FrontLeftLeg;
    public final ModelPart BackLeftLeg;

    public ModelKingCrab(ModelPart root) {
        super(root);
        this.Body = root.getChild("Body");
        this.LeftClaw = root.getChild("LeftClaw");
        this.RightClaw = root.getChild("RightClaw");

        FrontRightLeg = Body.getChild("FrontRightLeg");
        BackRightLeg = Body.getChild("BackRightLeg");
        MiddleRightLeg = Body.getChild("MiddleRightLeg");
        MiddleLeftLeg = Body.getChild("MiddleLeftLeg");
        FrontLeftLeg = Body.getChild("FrontLeftLeg");
        BackLeftLeg = Body.getChild("BackLeftLeg");
    }

    public ModelKingCrab(Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 64).addBox(-8.0F, -7.0F, -9.6667F, 16.0F, 2.0F, 20.0F, new CubeDeformation(0.0F))
                .texOffs(0, 36).addBox(-11.0F, -7.0F, -12.6667F, 22.0F, 2.0F, 26.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-11.0F, -5.0F, -12.6667F, 22.0F, 10.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, 4.6667F));

        PartDefinition FrontRightLeg = Body.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create(), PartPose.offset(-12.0F, 1.0F, -4.6667F));

        FrontRightLeg.addOrReplaceChild("FrontRightLeg_r1", CubeListBuilder.create().texOffs(16, 86).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

        PartDefinition FrontLeftLeg = Body.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create(), PartPose.offset(12.0F, 1.0F, -4.6667F));

        FrontLeftLeg.addOrReplaceChild("FrontLeftLeg_r1", CubeListBuilder.create().texOffs(0, 86).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

        PartDefinition MiddleRightLeg = Body.addOrReplaceChild("MiddleRightLeg", CubeListBuilder.create(), PartPose.offset(-12.0F, 1.0F, 2.3333F));

        MiddleRightLeg.addOrReplaceChild("MiddleRightLeg_r1", CubeListBuilder.create().texOffs(16, 86).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

        PartDefinition MiddleLeftLeg = Body.addOrReplaceChild("MiddleLeftLeg", CubeListBuilder.create(), PartPose.offset(12.0F, 1.0F, 2.3333F));

        MiddleLeftLeg.addOrReplaceChild("MiddleLeftLeg_r1", CubeListBuilder.create().texOffs(0, 86).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

        PartDefinition BackLeftLeg = Body.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create(), PartPose.offset(12.0F, 1.0F, 9.3333F));

        BackLeftLeg.addOrReplaceChild("BackLeftLeg_r1", CubeListBuilder.create().texOffs(0, 86).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

        PartDefinition BackRightLeg = Body.addOrReplaceChild("BackRightLeg", CubeListBuilder.create(), PartPose.offset(-12.0F, 1.0F, 9.3333F));

        BackRightLeg.addOrReplaceChild("BackRightLeg_r1", CubeListBuilder.create().texOffs(16, 86).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

        partdefinition.addOrReplaceChild("LeftClaw", CubeListBuilder.create().texOffs(77, 64).addBox(0.0F, -3.25F, -10.0F, 6.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(70, 36).addBox(0.0F, -2.25F, -10.0F, 6.0F, 10.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(11.0F, 8.25F, -6.0F));

        partdefinition.addOrReplaceChild("RightClaw", CubeListBuilder.create().texOffs(52, 64).addBox(-6.0F, -3.75F, -11.5F, 6.0F, 1.0F, 13.0F, new CubeDeformation(0.0F))
                .texOffs(70, 0).addBox(-6.0F, -2.75F, -11.5F, 6.0F, 12.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.0F, 7.75F, -5.5F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;

        this.FrontRightLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        this.BackRightLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.E) * 1.4F * limbSwingAmount);

        this.MiddleRightLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.E) * 1.4F * limbSwingAmount);
        this.MiddleLeftLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);

        this.FrontLeftLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.E) * 1.4F * limbSwingAmount);
        this.BackLeftLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
    }
}