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

public class ModelCaveCrawler<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("cave_crawler");
    public final ModelPart body;
    public final ModelPart rightArm;
    public final ModelPart leftArm;

    public ModelCaveCrawler(ModelPart root) {
        super(root);
        body = root.getChild("body");
        rightArm = body.getChild("right_arm");
        leftArm = body.getChild("left_arm");
    }

    public ModelCaveCrawler(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        CubeDeformation cubeDef = CubeDeformation.NONE;

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 16).addBox(-4, -12, -2, 8, 12, 4, cubeDef), PartPose.offsetAndRotation(0, 24, 6, .829F, 0, 0));

        body.addOrReplaceChild("trail", CubeListBuilder.create().texOffs(20, 54).addBox(-3.5F, -1, -2, 9, 6, 4, cubeDef), PartPose.offsetAndRotation(-1, 0, .5F, .2618F, 0, 0));

        body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4, -8, -5, 8, 8, 8, cubeDef)
                .texOffs(32, 3).addBox(-3.99F, -12, -2, 0, 4, 5, cubeDef)
                .texOffs(32, 7).addBox(-4, -12, -2, 0, 4, 5, cubeDef)
                .texOffs(37, 3).addBox(3.99F, -12, -2, 0, 4, 5, cubeDef)
                .texOffs(37, 7).addBox(4, -12, -2, 0, 4, 5, cubeDef), PartPose.offsetAndRotation(0, -12, 1, -.829F, 0, 0));

        body.addOrReplaceChild("jug", CubeListBuilder.create().texOffs(0, 40).addBox(-3, -9, 0, 6, 7, 6, cubeDef)
                .texOffs(24, 47).addBox(-2, -10, 1, 4, 1, 4, cubeDef)
                .texOffs(24, 40).addBox(-3, -11, 0, 6, 1, 6, cubeDef), PartPose.offset(0, 0, 2));

        body.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(24, 0).addBox(-4, -2, -2, 4, 4, 4, cubeDef)
                .texOffs(24, 16).addBox(-4, -2, -6, 4, 8, 4, cubeDef), PartPose.offset(-3.99F, -10, 0));

        body.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(20, 28).addBox(0, -2, -6, 4, 8, 4, cubeDef)
                .texOffs(0, 32).addBox(0, -2, -2, 4, 4, 4, cubeDef), PartPose.offset(3.99F, -10, 0));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;

        float f = Mth.cos(limbSwing * .6662F) * 1.4F * limbSwingAmount;
        float f1 = Mth.cos(limbSwing * .6662F + Mth.PI) * 1.4F * limbSwingAmount;
        body.zRot = f * .05F;
        rightArm.xRot = f1 - .6327F;
        leftArm.xRot = f - .6327F;
    }
}