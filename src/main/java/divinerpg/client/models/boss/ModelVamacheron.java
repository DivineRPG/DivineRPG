package divinerpg.client.models.boss;

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

public class ModelVamacheron<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("vamacheron");
    public final ModelPart Head;
    public final ModelPart Body;
    public final ModelPart FrontRightLeg;
    public final ModelPart FrontLeftLeg;
    public final ModelPart BackRightLeg;
    public final ModelPart BackLeftLeg;
    public final ModelPart Head2;

    public ModelVamacheron(ModelPart root) {
        super(root);
        Head = root.getChild("Head");
        Body = root.getChild("Body");
        FrontRightLeg = root.getChild("FrontRightLeg");
        FrontLeftLeg = root.getChild("FrontLeftLeg");
        BackRightLeg = root.getChild("BackRightLeg");
        BackLeftLeg = root.getChild("BackLeftLeg");
        Head2 = root.getChild("Head2");
    }

    public ModelVamacheron(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        CubeDeformation cubeDef = CubeDeformation.NONE;

        PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(33, 33).addBox(-4, -5.8F, -5.7F, 8, 8, 6, cubeDef)
                .texOffs(54, 12).addBox(-3, -2.8F, -8.7F, 6, 4, 3, cubeDef), PartPose.offsetAndRotation(7, 5.8F, -8.3F, .1745F, 0, 0));
        Head.addOrReplaceChild("Horn_r1", CubeListBuilder.create().texOffs(14, 56).addBox(-1, -7.5F, -1, 2, 7, 2, cubeDef), PartPose.offsetAndRotation(0, -3.7528F, -4.4743F, .3927F, 0, 0));
        Head.addOrReplaceChild("RightEar_r1", CubeListBuilder.create().texOffs(55, 31).addBox(-4.9572F, -7.1226F, 1, 6, 7, 0, cubeDef)
                .texOffs(38, 56).addBox(-4.9572F, -7.1226F, .99F, 6, 7, 0, cubeDef), PartPose.offsetAndRotation(-3, -2.8F, -1.7F, 0, -.0436F, -.1309F));
        Head.addOrReplaceChild("LeftEar_r1", CubeListBuilder.create().texOffs(1, 56).addBox(-1, -7, 1, 6, 7, 0, cubeDef)
                .texOffs(22, 56).addBox(-1, -7, .99F, 6, 7, 0, cubeDef), PartPose.offsetAndRotation(3, -2.8F, -1.7F, 0, 0, .1309F));
        Head.addOrReplaceChild("Mouth", CubeListBuilder.create().texOffs(0, 15).addBox(-3, -.5F, -1.5F, 6, 1, 3, cubeDef), PartPose.offset(0, 1.7F, -7.2F));

        partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 31).addBox(-4, -4.5F, -8.75F, 8, 8, 17, cubeDef)
                .texOffs(0, 0).addBox(-5.5F, -5.5F, -9.25F, 11, 12, 19, cubeDef)
                .texOffs(4, 5).addBox(-9.5F, -5.3F, -9.15F, 11, 8, 15, cubeDef)
                .texOffs(4, 5).addBox(-1.5F, -5.3F, -9.15F, 11, 8, 15, cubeDef), PartPose.offset(0, 9.5F, .75F));

        partdefinition.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(50, 50).addBox(-2, 0, -2, 4, 11, 4, cubeDef), PartPose.offset(-3, 13, -6));
        partdefinition.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(41, 0).addBox(-2, 0, -2, 4, 11, 4, cubeDef), PartPose.offset(3, 13, -6));
        partdefinition.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-2, 0, -2, 4, 11, 4, cubeDef), PartPose.offset(-3, 13, 8));
        partdefinition.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(0, 31).addBox(-2, 0, -2, 4, 11, 4, cubeDef), PartPose.offset(3, 13, 8));

        PartDefinition Head2 = partdefinition.addOrReplaceChild("Head2", CubeListBuilder.create().texOffs(33, 33).addBox(-4, -5.8F, -5.7F, 8, 8, 6, cubeDef)
                .texOffs(54, 12).addBox(-3, -2.8F, -8.7F, 6, 4, 3, cubeDef), PartPose.offsetAndRotation(-7, 5.8F, -8.3F, .1745F, 0, 0));
        Head2.addOrReplaceChild("Horn_r2", CubeListBuilder.create().texOffs(14, 56).addBox(-1, -7.5F, -1, 2, 7, 2, cubeDef), PartPose.offsetAndRotation(0, -3.7528F, -4.4743F, .3927F, 0, 0));
        Head2.addOrReplaceChild("RightEar_r2", CubeListBuilder.create().texOffs(55, 31).addBox(0, -6.47F, 1, 6, 7, 0, cubeDef)
                .texOffs(38, 56).addBox(0, -6.47F, .99F, 6, 7, 0, cubeDef), PartPose.offsetAndRotation(-8, -2.8F, -1.7F, 0, 0, -.1309F));
        Head2.addOrReplaceChild("LeftEar_r2", CubeListBuilder.create().texOffs(1, 56).addBox(-1, -7, 1, 6, 7, 0, cubeDef)
                .texOffs(22, 56).addBox(-1, -7, .99F, 6, 7, 0, cubeDef), PartPose.offsetAndRotation(3, -2.8F, -1.7F, 0, 0, .1309F));
        Head2.addOrReplaceChild("Mouth2", CubeListBuilder.create().texOffs(0, 15).addBox(-3, -.5F, -1.5F, 6, 1, 3, cubeDef), PartPose.offset(0, 1.7F, -7.2F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        this.Head.yRot = state.yRot * Mth.DEG_TO_RAD;
        this.Head.xRot = state.xRot * Mth.DEG_TO_RAD;
        this.Head2.yRot = state.yRot * Mth.DEG_TO_RAD;
        this.Head2.xRot = state.xRot * Mth.DEG_TO_RAD;

        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;

        float f = Mth.cos(limbSwing * .6662F) * 1.4F * limbSwingAmount;
        float f1 = Mth.cos(limbSwing * .6662F + Mth.PI) * 1.4F * limbSwingAmount;
        this.BackRightLeg.xRot = this.FrontLeftLeg.xRot = f;
        this.BackLeftLeg.xRot = this.FrontRightLeg.xRot = f1;
    }
}