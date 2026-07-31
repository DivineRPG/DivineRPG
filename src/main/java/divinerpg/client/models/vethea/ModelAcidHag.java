package divinerpg.client.models.vethea;

import divinerpg.client.models.state.AcidHagRenderState;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

import static divinerpg.utils.Utils.createLocation;

public class ModelAcidHag extends EntityModel<AcidHagRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("acid_hag");
    private final ModelPart Body, AcidTrail, Hip, Abs, UpperBody, NecklaceBottom, RightArmEnd, LeftArmEnd, Neck, Head, Hair, Jaw;

    public ModelAcidHag(ModelPart root) {
        super(root);
        Body = root.getChild("Body");
        AcidTrail = Body.getChild("AcidTrail");
        Hip = Body.getChild("Hip");
        Abs = Hip.getChild("Abs");
        UpperBody = Abs.getChild("UpperBody");
        ModelPart Necklace = UpperBody.getChild("Necklace");
        NecklaceBottom = Necklace.getChild("NecklaceBottom");
        ModelPart LeftArm = UpperBody.getChild("LeftArm");
        LeftArmEnd = LeftArm.getChild("LeftArmEnd");
        ModelPart RightArm = UpperBody.getChild("RightArm");
        RightArmEnd = RightArm.getChild("RightArmEnd");
        Neck = UpperBody.getChild("Neck");
        Head = Neck.getChild("Head");
        Hair = Head.getChild("Hair");
        Jaw = Head.getChild("Jaw");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 18).addBox(-5F, -7.1756F, -3.9731F, 10F, 7F, 10F, CubeDeformation.NONE), PartPose.offset(0F, 24.1756F, -1.0269F));

        Body.addOrReplaceChild("AcidTrail", CubeListBuilder.create().texOffs(0, 0).addBox(-7F, 0F, -5F, 14F, 0F, 18F, CubeDeformation.NONE), PartPose.offset(0F, -0.2006F, 2.0269F));

        PartDefinition Hip = Body.addOrReplaceChild("Hip", CubeListBuilder.create(), PartPose.offset(0F, -6.1756F, 4.0269F));

        Hip.addOrReplaceChild("hip_r1", CubeListBuilder.create().texOffs(38, 35).addBox(-4F, -8F, -4F, 8F, 10F, 8F, CubeDeformation.NONE), PartPose.offsetAndRotation(0F, 0F, -3F, 0.3491F, 0F, 0F));

        PartDefinition Abs = Hip.addOrReplaceChild("Abs", CubeListBuilder.create(), PartPose.offset(0F, -6.9205F, -4.6021F));

        Abs.addOrReplaceChild("abs_r1", CubeListBuilder.create().texOffs(40, 18).addBox(-3F, -8F, -3F, 6F, 10F, 6F, CubeDeformation.NONE), PartPose.offsetAndRotation(0F, 0F, -1F, 0.5236F, 0F, 0F));

        PartDefinition UpperBody = Abs.addOrReplaceChild("UpperBody", CubeListBuilder.create(), PartPose.offset(0F, -5.0795F, -4.3979F));

        UpperBody.addOrReplaceChild("chest_r1", CubeListBuilder.create().texOffs(0, 35).addBox(-6F, -4F, -3F, 12F, 6F, 7F, CubeDeformation.NONE), PartPose.offsetAndRotation(0F, 0F, 0F, 0.4363F, 0F, 0F));

        PartDefinition Necklace = UpperBody.addOrReplaceChild("Necklace", CubeListBuilder.create(), PartPose.offset(0F, -4F, 0F));

        Necklace.addOrReplaceChild("necklacetop_r1", CubeListBuilder.create().texOffs(20, 48).addBox(-4F, -5F, 0F, 8F, 5F, 0F, CubeDeformation.NONE), PartPose.offsetAndRotation(0F, 1.5F, -4.5F, -1.1345F, 0F, 0F));

        Necklace.addOrReplaceChild("NecklaceBottom", CubeListBuilder.create().texOffs(76, 47).addBox(-4F, 0F, 0F, 8F, 8F, 0F, CubeDeformation.NONE)
                .texOffs(76, 55).addBox(-1F, 7F, -1F, 2F, 2F, 2F, CubeDeformation.NONE), PartPose.offset(0F, 1.5F, -4.5F));

        PartDefinition LeftArm = UpperBody.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(40, 53).addBox(-0.25F, -0.939F, -1.8578F, 5F, 9F, 4F, CubeDeformation.NONE), PartPose.offset(6.25F, -3.061F, -0.1422F));

        LeftArm.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(52, 66).addBox(-1F, -2F, -2F, 3F, 9F, 4F, CubeDeformation.NONE), PartPose.offsetAndRotation(1.75F, 15.9712F, 4.7634F, 0.8727F, 0F, 0F));

        LeftArm.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(64, 0).addBox(-1.5F, -2F, -2F, 4F, 9F, 4F, CubeDeformation.NONE), PartPose.offsetAndRotation(1.75F, 9.0284F, 0.8001F, 0.4363F, 0F, 0F));

        PartDefinition LeftArmEnd = LeftArm.addOrReplaceChild("LeftArmEnd", CubeListBuilder.create(), PartPose.offset(1.75F, 20F, 10.84F));

        LeftArmEnd.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(64, 13).addBox(-1.5F, -2F, -2F, 4F, 9F, 4F, CubeDeformation.NONE), PartPose.offsetAndRotation(0F, 0F, 0F, 1.5708F, 0F, 0F));

        LeftArmEnd.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(70, 39).addBox(-0.5F, -2F, -2F, 4F, 4F, 4F, CubeDeformation.NONE), PartPose.offsetAndRotation(-1F, 0F, 9F, 1.5708F, 0F, 0F));

        PartDefinition RightArm = UpperBody.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(58, 53).addBox(-4.75F, -0.939F, -1.8578F, 5F, 9F, 4F, CubeDeformation.NONE), PartPose.offset(-6.25F, -3.061F, -0.1422F));

        RightArm.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(20, 65).addBox(-1.5F, -2F, -2F, 4F, 9F, 4F, CubeDeformation.NONE), PartPose.offsetAndRotation(-2.75F, 9.0284F, 0.8001F, 0.4363F, 0F, 0F));

        RightArm.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(66, 66).addBox(-1F, -2F, -2F, 3F, 9F, 4F, CubeDeformation.NONE), PartPose.offsetAndRotation(-2.75F, 15.9712F, 4.7634F, 0.8727F, 0F, 0F));

        PartDefinition RightArmEnd = RightArm.addOrReplaceChild("RightArmEnd", CubeListBuilder.create(), PartPose.offset(-2.75F, 20F, 10.84F));

        RightArmEnd.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 73).addBox(-2.5F, 0F, -2F, 4F, 4F, 4F, CubeDeformation.NONE), PartPose.offsetAndRotation(1F, 0F, 7F, 1.5708F, 0F, 0F));

        RightArmEnd.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(36, 66).addBox(-1.5F, -2F, -2F, 4F, 9F, 4F, CubeDeformation.NONE), PartPose.offsetAndRotation(0F, 0F, 0F, 1.5708F, 0F, 0F));

        PartDefinition Neck = UpperBody.addOrReplaceChild("Neck", CubeListBuilder.create(), PartPose.offset(0F, -1F, -2F));

        Neck.addOrReplaceChild("neck_r1", CubeListBuilder.create().texOffs(70, 26).addBox(-1F, -8F, -2F, 3F, 10F, 3F, CubeDeformation.NONE), PartPose.offsetAndRotation(-0.5F, -2F, -1F, 0.6981F, 0F, 0F));

        PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(20, 53).addBox(-2.5F, -2.75F, -4.5F, 5F, 5F, 5F, CubeDeformation.NONE), PartPose.offsetAndRotation(0F, -6.25F, -5.5F, 0.0436F, 0F, 0F));

        Head.addOrReplaceChild("Hair", CubeListBuilder.create().texOffs(0, 48).addBox(-2.5F, -2.5F, -2.5F, 5F, 20F, 5F, new CubeDeformation(0.3F)), PartPose.offset(0F, -0.75F, -2F));

        PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create(), PartPose.offset(0F, 1F, 0F));

        Jaw.addOrReplaceChild("jaw_r1", CubeListBuilder.create().texOffs(81, 0).addBox(-2F, -1.342F, -3.9397F, 4F, 3F, 4F, CubeDeformation.NONE), PartPose.offsetAndRotation(0F, 1F, 0F, 0.3491F, 0F, 0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(AcidHagRenderState state) {
        super.setupAnim(state);
        float limbSwing = state.limbSwing;
        float limbSwingAmount = state.limbSwingAmount;
        float ageInTicks = state.ageInTicks;
        float netHeadYaw = state.headYaw;
        float headPitch = state.headPitch;

        float rot = (Mth.cos(limbSwing * .6662F) - 1F) * limbSwingAmount * 0.25F;
        Head.yRot = netHeadYaw * 0.6F * Mth.DEG_TO_RAD;
        Neck.yRot = netHeadYaw * 0.4F * Mth.DEG_TO_RAD;
        Head.xRot = headPitch * 0.6F * Mth.DEG_TO_RAD;
        Neck.xRot = rot * 0.25F;
        UpperBody.xRot = Abs.xRot = Hip.xRot = -Neck.xRot;
        Neck.xRot += headPitch * 0.4F * Mth.DEG_TO_RAD;
        LeftArmEnd.xRot = RightArmEnd.xRot = Hair.xRot = rot * 0.9F;
        NecklaceBottom.xRot = rot * 0.75F + Mth.sin(limbSwing * .6662F) * Mth.cos(limbSwing * 4F * .6662F) * limbSwingAmount * 0.5F;
        Jaw.xRot = Mth.cos(ageInTicks) * 0.1F;
        AcidTrail.zScale = 1F - rot;
    }
}