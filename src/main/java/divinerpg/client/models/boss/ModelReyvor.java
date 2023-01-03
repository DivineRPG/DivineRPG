package divinerpg.client.models.boss;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.boss.EntityReyvor;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelReyvor<E extends EntityReyvor> extends EntityModel<EntityReyvor> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("reyvor");
    private final ModelPart body;
    public final ModelPart rightarm;
    private final ModelPart leftarm;
    private final ModelPart rightleg;
    private final ModelPart leftleg;
    private final ModelPart head;

    public ModelReyvor(Context context) {
        ModelPart root = context.bakeLayer(LAYER_LOCATION);
        this.body = root.getChild("body");
        this.rightarm = root.getChild("rightarm");
        this.leftarm = root.getChild("leftarm");
        this.rightleg = root.getChild("rightleg");
        this.leftleg = root.getChild("leftleg");
        this.head = root.getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        CubeDeformation cubedef = new CubeDeformation(0.0F);

        partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, cubedef).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(40, 4).mirror().addBox(-3.0F, -2.0F, -2.0F, 4.0F, 18.0F, 4.0F, cubedef).mirror(false), PartPose.offset(-5.0F, 2.0F, 0.0F));

        partdefinition.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(40, 1).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 18.0F, 4.0F, cubedef).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));

        partdefinition.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, cubedef).mirror(false), PartPose.offset(-2.0F, 12.0F, 0.0F));

        partdefinition.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, cubedef).mirror(false), PartPose.offset(2.0F, 12.0F, 0.0F));

        partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-9.4667F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, cubedef).mirror(false)
                .texOffs(0, 0).mirror().addBox(2.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, cubedef).mirror(false)
                .texOffs(0, 0).mirror().addBox(6.5333F, -16.0F, -3.0F, 8.0F, 8.0F, 8.0F, cubedef).mirror(false)
                .texOffs(0, 0).mirror().addBox(-14.4667F, -16.0F, -3.0F, 8.0F, 8.0F, 8.0F, cubedef).mirror(false)
                .texOffs(0, 0).mirror().addBox(-3.4667F, -16.0F, -3.0F, 8.0F, 8.0F, 8.0F, cubedef).mirror(false), PartPose.offset(-0.5333F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(EntityReyvor entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.yRot = netHeadYaw / (180F / (float)Math.PI);
        this.head.xRot = headPitch / (180F / (float)Math.PI);
        this.rightarm.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 2.0F * limbSwingAmount * 0.5F);
        this.leftarm.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F);
        this.rightarm.zRot = 0.0F;
        this.leftarm.zRot = 0.0F;
        this.rightleg.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        this.leftleg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
        this.rightleg.yRot = 0.0F;
        this.leftleg.yRot = 0.0F;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        body.render(poseStack, buffer, packedLight, packedOverlay);
        rightarm.render(poseStack, buffer, packedLight, packedOverlay);
        leftarm.render(poseStack, buffer, packedLight, packedOverlay);
        rightleg.render(poseStack, buffer, packedLight, packedOverlay);
        leftleg.render(poseStack, buffer, packedLight, packedOverlay);
        head.render(poseStack, buffer, packedLight, packedOverlay);
    }
}