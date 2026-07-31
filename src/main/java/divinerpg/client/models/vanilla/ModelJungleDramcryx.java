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

public class ModelJungleDramcryx<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("jungle_dramcryx");
    public final ModelPart Head;
    public final ModelPart FrontRightLeg;
    public final ModelPart FrontLeftLeg;
    public final ModelPart BackLeftLeg;
    public final ModelPart BackRightLeg;
    public final ModelPart Body;

    public ModelJungleDramcryx(ModelPart root) {
        super(root);
        this.Head = root.getChild("Head");
        this.FrontRightLeg = root.getChild("FrontRightLeg");
        this.FrontLeftLeg = root.getChild("FrontLeftLeg");
        this.BackLeftLeg = root.getChild("BackLeftLeg");
        this.BackRightLeg = root.getChild("BackRightLeg");
        this.Body = root.getChild("Body");
    }

    public ModelJungleDramcryx(Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(28, 0).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.51F, 17.0F, -1.5F));

        partdefinition.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(12, 27).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.51F, 17.0F, -1.5F));

        partdefinition.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(0, 27).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, 17.0F, 5.5F));

        partdefinition.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, 17.0F, 5.5F));

        PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 17.0F, 2.5F));

        Body.addOrReplaceChild("Tail_r1", CubeListBuilder.create().texOffs(0, 51).addBox(-2.0F, -6.0F, 0.0F, 4.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 5.0F, -0.3054F, 0.0F, 0.0F));

        Body.addOrReplaceChild("Torso_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -3.0F, -10.0F, 8.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 3.5F, -0.2963F, 0.0F, 0.0F));

        PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(24, 25).addBox(-3.0F, -3.0F, -6.0F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(22, 16).addBox(3.0F, -1.0F, -6.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 16).addBox(-4.0F, -1.0F, -6.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 16).addBox(-4.5F, -4.0F, -4.0F, 9.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, -3.0F));

        Head.addOrReplaceChild("RightEar", CubeListBuilder.create().texOffs(37, 30).addBox(-1.0F, -2.5F, -1.5F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -4.0F, -3.0F));

        Head.addOrReplaceChild("LeftEar", CubeListBuilder.create().texOffs(37, 13).addBox(-1.0F, -2.5F, -1.5F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -4.0F, -3.0F));

        PartDefinition Spines = Body.addOrReplaceChild("Spines", CubeListBuilder.create(), PartPose.offset(0.5F, -1.0F, 2.5F));

        Spines.addOrReplaceChild("BackSpine_r1", CubeListBuilder.create().texOffs(0, 38).addBox(-1.0F, -4.0F, -1.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.1345F, 0.0F, 0.0F));

        Spines.addOrReplaceChild("MiddleSpine_r1", CubeListBuilder.create().texOffs(28, 33).addBox(-1.0F, -6.0F, -1.5F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -1.0F, -2.5F, -0.829F, 0.0F, 0.0F));

        Spines.addOrReplaceChild("FrontSpine_r1", CubeListBuilder.create().texOffs(26, 16).addBox(-1.5F, -5.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -3.0F, -4.5F, -0.3491F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;
        float headPitch = state.xRot * ((float) Math.PI / 180F);
        float netHeadYaw = state.yRot * ((float) Math.PI / 180F);

        this.Head.yRot = netHeadYaw;
        this.Head.xRot = headPitch;

        this.FrontLeftLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        this.FrontRightLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
        this.BackLeftLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
        this.BackRightLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
    }
}