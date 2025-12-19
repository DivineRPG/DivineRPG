package divinerpg.client.models.arcana;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.arcana.EntityFyracryx;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelFyracryx extends EntityModel<EntityFyracryx> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("fyracryx");
    private final ModelPart root, head, leg0, leg1, leg2, leg3;

    public ModelFyracryx(EntityRendererProvider.Context context) {
        ModelPart r = context.bakeLayer(LAYER_LOCATION);
        root = r.getChild("root");
        head = root.getChild("head");
        leg0 = root.getChild("leg0");
        leg1 = root.getChild("leg1");
        leg2 = root.getChild("leg2");
        leg3 = root.getChild("leg3");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0F, 24F, -1F));

        root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 13).addBox(-4.5F, 7F, -1F, 9F, 7F, 4F, CubeDeformation.NONE)
                .texOffs(0, 36).addBox(-3F, 8F, -3F, 6F, 6F, 2F, CubeDeformation.NONE)
                .texOffs(26, 17).addBox(-4.5F, 4F, -2F, 3F, 3F, 4F, CubeDeformation.NONE)
                .texOffs(26, 17).mirror().addBox(1.5F, 4F, -2F, 3F, 3F, 4F, CubeDeformation.NONE).mirror(false)
                .texOffs(0, 0).addBox(-3.5F, 10F, -3.5F, 1F, 3F, 1F, CubeDeformation.NONE)
                .texOffs(0, 0).mirror().addBox(2.5F, 10F, -3.5F, 1F, 3F, 1F, CubeDeformation.NONE).mirror(false), PartPose.offset(0F, -20F, -8F));

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -8F, 2F, -0.2618F, 0F, 0F));

        body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(42, 0).mirror().addBox(0F, 0F, -2F, 3F, 6F, 2F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(0F, 0F, 8F, 1.5708F, 0.3927F, 0F));

        body.addOrReplaceChild("body_r2", CubeListBuilder.create().texOffs(40, 17).mirror().addBox(0F, -5F, -3F, 1F, 3F, 3F, CubeDeformation.NONE).mirror(false)
                .texOffs(40, 17).addBox(-5F, -5F, -3F, 1F, 3F, 3F, CubeDeformation.NONE), PartPose.offsetAndRotation(2F, -4.5F, 9F, 1.5708F, 0F, 0F));

        body.addOrReplaceChild("body_r3", CubeListBuilder.create().texOffs(40, 36).mirror().addBox(0F, -5F, -3F, 1F, 3F, 5F, CubeDeformation.NONE).mirror(false)
                .texOffs(40, 36).addBox(-5F, -5F, -3F, 1F, 3F, 5F, CubeDeformation.NONE), PartPose.offsetAndRotation(2F, -5F, 1F, 1.5708F, 0F, 0F));

        body.addOrReplaceChild("body_r4", CubeListBuilder.create().texOffs(42, 0).addBox(-3F, 0F, -2F, 3F, 6F, 2F, CubeDeformation.NONE), PartPose.offsetAndRotation(0F, 0F, 8F, 1.5708F, -0.3927F, 0F));

        body.addOrReplaceChild("body_r5", CubeListBuilder.create().texOffs(26, 10).addBox(-2F, 1F, -2F, 4F, 2F, 5F, CubeDeformation.NONE)
                .texOffs(0, 24).addBox(-3.5F, -7F, -3F, 7F, 8F, 4F, CubeDeformation.NONE), PartPose.offsetAndRotation(0F, -0.5F, 7F, 1.5708F, 0F, 0F));

        body.addOrReplaceChild("body_r6", CubeListBuilder.create().texOffs(26, 0).addBox(-1F, -5F, -3F, 2F, 4F, 6F, CubeDeformation.NONE), PartPose.offsetAndRotation(0F, -4.5F, 6F, 1.5708F, 0F, 0F));

        body.addOrReplaceChild("body_r7", CubeListBuilder.create().texOffs(22, 24).addBox(-1F, -5F, -3F, 2F, 4F, 8F, CubeDeformation.NONE), PartPose.offsetAndRotation(0F, -5F, -2F, 1.5708F, 0F, 0F));

        body.addOrReplaceChild("body_r8", CubeListBuilder.create().texOffs(0, 0).addBox(-4F, -7F, -3F, 8F, 8F, 5F, CubeDeformation.NONE), PartPose.offsetAndRotation(0F, 0F, -1F, 1.5708F, 0F, 0F));

        root.addOrReplaceChild("leg0", CubeListBuilder.create().texOffs(16, 36).addBox(-0.5F, 4F, -3F, 3F, 8F, 3F, CubeDeformation.NONE), PartPose.offset(-4F, -12F, 7F));

        root.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(16, 36).mirror().addBox(-2.5F, 4F, -3F, 3F, 8F, 3F, CubeDeformation.NONE).mirror(false), PartPose.offset(4F, -12F, 7F));

        root.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(0, 44).addBox(-1.5F, 4F, 1F, 4F, 8F, 4F, CubeDeformation.NONE), PartPose.offset(-4F, -12F, -6F));

        root.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(0, 44).mirror().addBox(-2.5F, 4F, 1F, 4F, 8F, 4F, CubeDeformation.NONE).mirror(false), PartPose.offset(4F, -12F, -6F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(EntityFyracryx entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        head.xRot = headPitch * Mth.DEG_TO_RAD;
        head.yRot = netHeadYaw * Mth.DEG_TO_RAD;
        leg0.xRot = leg3.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        leg1.xRot = leg2.xRot = -leg0.xRot;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        root.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }
}