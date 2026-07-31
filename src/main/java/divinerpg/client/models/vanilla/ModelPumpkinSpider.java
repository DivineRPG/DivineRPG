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

public class ModelPumpkinSpider<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("pumpkin_spider");
    public final ModelPart Head, Body, Thorax, RightLeg4, RightLeg3, RightLeg2, RightLeg1, LeftLeg4, LeftLeg3, LeftLeg2, LeftLeg1;

    public ModelPumpkinSpider(ModelPart root) {
        super(root);
        Head = root.getChild("Head");
        Body = root.getChild("Body");
        Thorax = root.getChild("Thorax");
        RightLeg4 = root.getChild("RightLeg4");
        RightLeg3 = root.getChild("RightLeg3");
        RightLeg2 = root.getChild("RightLeg2");
        RightLeg1 = root.getChild("RightLeg1");
        LeftLeg4 = root.getChild("LeftLeg4");
        LeftLeg3 = root.getChild("LeftLeg3");
        LeftLeg2 = root.getChild("LeftLeg2");
        LeftLeg1 = root.getChild("LeftLeg1");
    }

    public ModelPumpkinSpider(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        CubeDeformation cubeDef = CubeDeformation.NONE;
        partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(38, 32).addBox(-5, -4, -8, 10, 9, 8, cubeDef), PartPose.offset(0, 15, -7));
        partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 32).addBox(-4, -12, -7, 8, 6, 11, cubeDef), PartPose.offset(0, 24, 0));
        partdefinition.addOrReplaceChild("Thorax", CubeListBuilder.create().texOffs(0, 0).addBox(-8, -11, 2, 16, 16, 16, cubeDef), PartPose.ZERO);
        PartDefinition RightLeg4 = partdefinition.addOrReplaceChild("RightLeg4", CubeListBuilder.create(), PartPose.offset(-4, 17, 2));
        RightLeg4.addOrReplaceChild("rightleg4_r1", CubeListBuilder.create().texOffs(48, 12).addBox(-15, -1, -1, 14, 2, 2, cubeDef), PartPose.offset(1, -1, -1));
        PartDefinition RightLeg3 = partdefinition.addOrReplaceChild("RightLeg3", CubeListBuilder.create(), PartPose.offset(-4, 17, -1));
        RightLeg3.addOrReplaceChild("rightleg3_r1", CubeListBuilder.create().texOffs(48, 8).addBox(-15, -1, -1, 14, 2, 2, cubeDef), PartPose.offset(1, -1, 0));
        PartDefinition RightLeg2 = partdefinition.addOrReplaceChild("RightLeg2", CubeListBuilder.create(), PartPose.offset(-4, 17, -3));
        RightLeg2.addOrReplaceChild("rightleg2_r1", CubeListBuilder.create().texOffs(48, 4).addBox(-15, -1, -1, 14, 2, 2, cubeDef), PartPose.offset(1, -1, 0));
        PartDefinition RightLeg1 = partdefinition.addOrReplaceChild("RightLeg1", CubeListBuilder.create(), PartPose.offset(-4, 17, -5));
        RightLeg1.addOrReplaceChild("rightleg1_r1", CubeListBuilder.create().texOffs(48, 0).addBox(-15, -1, -1, 14, 2, 2, cubeDef), PartPose.offset(1, -1, 0));
        PartDefinition LeftLeg4 = partdefinition.addOrReplaceChild("LeftLeg4", CubeListBuilder.create(), PartPose.offset(4, 17, 2));
        LeftLeg4.addOrReplaceChild("leftleg4_r1", CubeListBuilder.create().texOffs(0, 49).addBox(1, -1, -1, 14, 2, 2, cubeDef), PartPose.offset(-1, -1, -1));
        PartDefinition LeftLeg3 = partdefinition.addOrReplaceChild("LeftLeg3", CubeListBuilder.create(), PartPose.offset(4, 17, -1));
        LeftLeg3.addOrReplaceChild("leftleg3_r1", CubeListBuilder.create().texOffs(32, 49).addBox(1, -1, -1, 14, 2, 2, cubeDef), PartPose.offset(-1, -1, 0));
        PartDefinition LeftLeg2 = partdefinition.addOrReplaceChild("LeftLeg2", CubeListBuilder.create(), PartPose.offset(4, 17, -3));
        LeftLeg2.addOrReplaceChild("leftleg2_r1", CubeListBuilder.create().texOffs(0, 53).addBox(1, -1, -1, 14, 2, 2, cubeDef), PartPose.offset(-1, -1, 0));
        PartDefinition LeftLeg1 = partdefinition.addOrReplaceChild("LeftLeg1", CubeListBuilder.create(), PartPose.offset(4, 17, -5));
        LeftLeg1.addOrReplaceChild("leftleg1_r1", CubeListBuilder.create().texOffs(32, 53).addBox(1, -1, -1, 14, 2, 2, cubeDef), PartPose.offset(-1, -1, 0));
        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;
        float ageInTicks = state.ageInTicks;
        float headPitch = state.xRot * ((float) Math.PI / 180F);
        float netHeadYaw = state.yRot * ((float) Math.PI / 180F);

        Head.yRot = netHeadYaw;
        Head.xRot = headPitch;
        Thorax.xRot = Mth.cos(limbSwing * .6662F) * .25F * limbSwingAmount + Mth.PI / 12;
        Thorax.y = 14;
        Thorax.z = -2;

        boolean provoked = true;
        if (!provoked) {
            Thorax.xRot = Mth.HALF_PI;
            Thorax.y = 26;
            Thorax.z = 3;
        }

        float f = Mth.PI / 6;
        RightLeg4.zRot = RightLeg3.zRot = RightLeg2.zRot = RightLeg1.zRot = -f;
        LeftLeg4.zRot = LeftLeg3.zRot = LeftLeg2.zRot = LeftLeg1.zRot = f;
        float f1 = f / 2;
        float f2 = f / 6;
        RightLeg4.yRot = LeftLeg1.yRot = f1;
        LeftLeg4.yRot = RightLeg1.yRot = -f1;
        RightLeg3.yRot = LeftLeg2.yRot = f2;
        LeftLeg3.yRot = RightLeg2.yRot = -f2;
        float g = .8662F;
        float h = .2F;
        float f3 = -(Mth.cos(limbSwing * g * 2) * h) * limbSwingAmount;
        float f4 = -(Mth.cos(limbSwing * g * 2 + Mth.PI) * h) * limbSwingAmount;
        float f5 = -(Mth.cos(limbSwing * g * 2 + Mth.HALF_PI) * h) * limbSwingAmount;
        float f6 = -(Mth.cos(limbSwing * g * 2 + Mth.PI * 1.5F) * h) * limbSwingAmount;
        float f7 = Mth.abs(Mth.sin(limbSwing * g) * h) * limbSwingAmount;
        float f8 = Mth.abs(Mth.sin(limbSwing * g + Mth.PI) * h) * limbSwingAmount;
        float f9 = Mth.abs(Mth.sin(limbSwing * g + Mth.HALF_PI) * h) * limbSwingAmount;
        float f10 = Mth.abs(Mth.sin(limbSwing * g + Mth.PI * 1.5F) * h) * limbSwingAmount;
        RightLeg4.yRot += f3;
        LeftLeg4.yRot -= f3;
        RightLeg3.yRot += f4;
        LeftLeg3.yRot -= f4;
        RightLeg2.yRot += f5;
        LeftLeg2.yRot -= f5;
        RightLeg1.yRot += f6;
        LeftLeg1.yRot -= f6;
        RightLeg4.zRot += f7;
        LeftLeg4.zRot -= f7;
        RightLeg3.zRot += f8;
        LeftLeg3.zRot -= f8;
        RightLeg2.zRot += f9;
        LeftLeg2.zRot -= f9;
        RightLeg1.zRot += f10;
        LeftLeg1.zRot -= f10;
    }
}