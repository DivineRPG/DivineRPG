package divinerpg.client.models.vanilla;

import divinerpg.entities.vanilla.overworld.EntityDesertCrawler;
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

public class ModelDesertCrawler<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("desert_crawler");
    public final ModelPart body;
    public final ModelPart bb_main;
    public final ModelPart head;
    public final ModelPart rightLeg;
    public final ModelPart leftLeg;
    public final ModelPart rightArm;
    public final ModelPart leftArm;

    public ModelDesertCrawler(ModelPart root) {
        super(root);
        body = root.getChild("body");
        bb_main = root.getChild("bb_main");
        head = root.getChild("head");
        rightLeg = root.getChild("right_leg");
        leftLeg = root.getChild("left_leg");
        rightArm = root.getChild("right_arm");
        leftArm = root.getChild("left_arm");
    }

    public ModelDesertCrawler(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        CubeDeformation cubeDef = CubeDeformation.NONE;

        partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3, -4, -4, 8, 6, 17, cubeDef), PartPose.offset(-1, 14, 0));
        partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(40, 23).addBox(-4, -14, -11, 8, 9, 2, cubeDef), PartPose.offset(.01F, 24, 2.01F));

        partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 23).addBox(-4, -4, -4, 8, 8, 8, cubeDef)
                .texOffs(24, 18).addBox(-4, -8, -1, 0, 4, 5, cubeDef)
                .texOffs(30, 18).addBox(-4.01F, -8, -1, 0, 4, 5, cubeDef)
                .texOffs(44, 46).addBox(4, 1, -6, 1, 3, 6, cubeDef)
                .texOffs(42, 37).addBox(-5, 1, -6, 1, 3, 6, cubeDef)
                .texOffs(24, 22).addBox(4, -8, -1, 0, 4, 5, cubeDef)
                .texOffs(30, 22).addBox(4.01F, -8, -1, 0, 4, 5, cubeDef), PartPose.offset(.01F, 6.01F, -8));

        partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(24, 31).addBox(-4, -2, -2, 4, 4, 8, cubeDef)
                .texOffs(16, 43).addBox(-5, 2, 3, 4, 7, 3, cubeDef), PartPose.offset(-2.5F, 0, 0));

        partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(33, 0).addBox(0, -2, -2, 4, 4, 8, cubeDef)
                .texOffs(30, 43).addBox(1, 2, 3, 4, 7, 3, cubeDef), PartPose.offset(2.5F, 0, 0));

        partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 0).addBox(-4, -2, -2, 4, 12, 4, cubeDef), PartPose.offset(-3.99F, 14, -4));
        partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 39).addBox(0, -2, -2, 4, 12, 4, cubeDef), PartPose.offset(3.99F, 14, -4));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;
        float headPitch = state.xRot * ((float) Math.PI / 180F);
        float netHeadYaw = state.yRot * ((float) Math.PI / 180F);

        head.yRot = netHeadYaw;
        head.xRot = headPitch;
        boolean isAggressive = false;

        if (!isAggressive) {
            body.z = -4;
            body.zRot = 0;
            body.xRot = Mth.PI * 1.7854F;
            rightLeg.y = leftLeg.y = 18;
            rightLeg.z = leftLeg.z = 4;
            rightLeg.xRot = leftLeg.xRot = Mth.PI * 1.5F;
            rightArm.xRot = leftArm.xRot = 5.812F;
        } else {
            float f = Mth.cos(limbSwing * .6662F) * 1.4F * limbSwingAmount;
            float f1 = Mth.cos(limbSwing * .6662F + Mth.PI) * 1.4F * limbSwingAmount;
            body.z = -3;
            body.zRot = f * .05F;
            body.xRot = Mth.PI * 8;
            rightLeg.y = leftLeg.y = 15;
            rightLeg.z = leftLeg.z = 5;
            leftArm.xRot = rightArm.xRot = f;
            leftLeg.xRot = rightLeg.xRot = f1;
        }
    }
}