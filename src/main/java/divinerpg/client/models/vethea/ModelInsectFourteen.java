package divinerpg.client.models.vethea;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.vethea.EntityInsectFourteen;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelInsectFourteen extends EntityModel<EntityInsectFourteen> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("insect_fourteen");
    private final ModelPart LegPair2;
    private final ModelPart LegPair1;
    private final ModelPart Head;
    private final ModelPart LeftArm;
    private final ModelPart RightArm;
    private final ModelPart Body;
    public ModelInsectFourteen(EntityRendererProvider.Context context) {
        ModelPart root = context.bakeLayer(LAYER_LOCATION);
        LegPair2 = root.getChild("LegPair2");
        LegPair1 = root.getChild("LegPair1");
        Head = root.getChild("Head");
        LeftArm = root.getChild("LeftArm");
        RightArm = root.getChild("RightArm");
        Body = root.getChild("Body");
    }
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        CubeDeformation zero = new CubeDeformation(0F);
        partdefinition.addOrReplaceChild("LegPair2", CubeListBuilder.create().texOffs(34, 25).addBox(0.5F, 0F, -2F, 4F, 9F, 4F, zero)
                .texOffs(34, 25).addBox(-9.25F, 0F, -2F, 4F, 9F, 4F, zero), PartPose.offset(0F, 15F, 0F));
        partdefinition.addOrReplaceChild("LegPair1", CubeListBuilder.create().texOffs(34, 25).addBox(5.5F, 0F, -3F, 4F, 9F, 4F, zero)
                .texOffs(34, 25).addBox(-4.5F, 0F, -3F, 4F, 9F, 4F, zero), PartPose.offset(0F, 15F, 1.0F));
        partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-6.5F, -12.5F, -6F, 13F, 13F, 12F, zero)
                .texOffs(0, 25).addBox(-8.5F, -13.5F, -1.0F, 17.0F, 2F, 2F, zero)
                .texOffs(0, 0).addBox(-8.5F, -19.5F, -1.0F, 2F, 6F, 2F, zero)
                .texOffs(0, 0).addBox(-5.5F, -19.5F, -1.0F, 2F, 6F, 2F, zero)
                .texOffs(0, 0).addBox(0.5F, -19.5F, -1.0F, 2F, 6F, 2F, zero)
                .texOffs(0, 0).addBox(6.5F, -19.5F, -1.0F, 2F, 6F, 2F, zero)
                .texOffs(0, 0).addBox(3.5F, -19.5F, -1.0F, 2F, 6F, 2F, zero)
                .texOffs(0, 0).addBox(-2.5F, -19.5F, -1.0F, 2F, 6F, 2F, zero), PartPose.offset(0F, 9.5F, 0F));
        partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(38, 0).addBox(-2F, -9F, -1.5F, 3F, 9F, 3F, zero), PartPose.offset(9.75F, 11F, 0F));
        partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(38, 0).addBox(-1.0F, -9F, -1.5F, 3F, 9F, 3F, zero), PartPose.offset(-9.75F, 11F, 0F));
        partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 29).addBox(-10F, -15F, -3F, 20F, 6F, 6F, zero), PartPose.offset(0F, 24F, 0F));
        return LayerDefinition.create(meshdefinition, 52, 41);
    }
    @Override
    public void setupAnim(EntityInsectFourteen entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        Head.yRot = netHeadYaw * Mth.DEG_TO_RAD;
        Head.xRot = headPitch * Mth.DEG_TO_RAD;
        LegPair1.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        LegPair2.xRot = -Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        if(entity.isAggressive()) RightArm.xRot = LeftArm.xRot = 0F;
        else {
            RightArm.xRot = -Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
            LeftArm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
        }
    }
    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        LegPair2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        LegPair1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }
}