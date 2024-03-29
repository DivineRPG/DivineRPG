package divinerpg.client.models.iceika;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.RangedAttackMob;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelPaleArcher<T extends Mob & RangedAttackMob> extends EntityModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("pale_archer");
    public final ModelPart Head, Torso, LeftArm, RightArm, Trail;

    public ModelPaleArcher(Context context) {
        ModelPart root = context.bakeLayer(LAYER_LOCATION);
        this.Head = root.getChild("Head");
        this.Torso = root.getChild("Torso");
        this.LeftArm = root.getChild("LeftArm");
        this.RightArm = root.getChild("RightArm");
        this.Trail = root.getChild("Trail");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(28, 20).addBox(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 16).addBox(-4.5F, -12.3F, -2.5F, 9.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 14.0F, 3.0F, 0.1565F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(24, 8).addBox(-4.0F, -12.0F, -4.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 1.0F, 0.0692F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(32, 36).addBox(0.0F, 0.0F, -2.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 3.0F, 1.0F));

        partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(24, 36).addBox(-2.0F, 0.0F, -2.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 3.0F, 1.0F));

        partdefinition.addOrReplaceChild("Trail", CubeListBuilder.create().texOffs(0, 33).addBox(-4.0F, 2.0F, 1.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 13.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
        this.Head.xRot = headPitch / (180F / (float) Math.PI);
        float f = (float) Math.sqrt(Math.atan(200F * limbSwing)) * limbSwingAmount + 0.1565F;
        this.RightArm.xRot = f;
        this.LeftArm.xRot = f;
        this.RightArm.yRot = 0.0F;
        this.LeftArm.yRot = 0.0F;
        this.RightArm.zRot = 0.2182F;
        this.LeftArm.zRot = -0.2182F;
        AnimationUtils.bobModelPart(this.RightArm, ageInTicks, 1.0F);
        AnimationUtils.bobModelPart(this.LeftArm, ageInTicks, -1.0F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        Trail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}