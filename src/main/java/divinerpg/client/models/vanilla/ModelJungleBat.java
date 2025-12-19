package divinerpg.client.models.vanilla;

import net.minecraft.client.animation.definitions.BatAnimation;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.ambient.Bat;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelJungleBat extends HierarchicalModel<Bat> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("jungle_bat");
    private final ModelPart root, head;
    public ModelJungleBat(EntityRendererProvider.Context context) {
        root = context.bakeLayer(LAYER_LOCATION);
        head = root.getChild("head");
    }
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 7).addBox(-2F, -3F, -1F, 4F, 3F, 2F, CubeDeformation.NONE)
                .texOffs(8, 21).addBox(-0.5F, -4F, -1.4284F, 1F, 2F, 2F, CubeDeformation.NONE)
                .texOffs(0, 25).addBox(-2.5F, -4F, -1.5F, 1F, 2F, 1F, CubeDeformation.NONE)
                .texOffs(0, 25).mirror().addBox(1.5F, -4F, -1.5F, 1F, 2F, 1F, CubeDeformation.NONE).mirror(false), PartPose.offset(0F, 17F, 0F));

        PartDefinition rightEar = head.addOrReplaceChild("right_ear", CubeListBuilder.create(), PartPose.offset(-1.5F, -2F, 0F));

        rightEar.addOrReplaceChild("right_ear_r1", CubeListBuilder.create().texOffs(1, 15).addBox(-3F, -4F, 0F, 3F, 5F, 0F, CubeDeformation.NONE), PartPose.offsetAndRotation(0.5F, -1F, 0.5F, 0F, 0F, -0.7854F));

        PartDefinition leftEar = head.addOrReplaceChild("left_ear", CubeListBuilder.create(), PartPose.offset(1.1F, -2F, 0F));

        leftEar.addOrReplaceChild("left_ear_r1", CubeListBuilder.create().texOffs(8, 15).addBox(0F, -4F, 0F, 3F, 5F, 0F, CubeDeformation.NONE), PartPose.offsetAndRotation(-0.1F, -1F, 0.5F, 0F, 0F, 0.7854F));

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, 0F, -1F, 3F, 5F, 2F, CubeDeformation.NONE)
                .texOffs(8, 25).addBox(-0.5F, 0.5F, 1F, 1F, 1F, 1F, CubeDeformation.NONE), PartPose.offset(0F, 17F, 0F));

        body.addOrReplaceChild("feet", CubeListBuilder.create().texOffs(16, 16).addBox(-1.5F, 0F, 0F, 3F, 2F, 0F, CubeDeformation.NONE), PartPose.offset(0F, 5F, 0F));

        PartDefinition rightWing = body.addOrReplaceChild("right_wing", CubeListBuilder.create().texOffs(12, 0).addBox(-2F, -2F, 0F, 2F, 7F, 0F, CubeDeformation.NONE), PartPose.offset(-1.5F, 0F, 0F));

        rightWing.addOrReplaceChild("right_wing_tip", CubeListBuilder.create().texOffs(16, 0).addBox(-6F, -2F, 0F, 6F, 8F, 0F, CubeDeformation.NONE), PartPose.offset(-2F, 0F, 0F));

        PartDefinition leftWing = body.addOrReplaceChild("left_wing", CubeListBuilder.create().texOffs(12, 7).addBox(0F, -2F, 0F, 2F, 7F, 0F, CubeDeformation.NONE), PartPose.offset(1.5F, 0F, 0F));

        leftWing.addOrReplaceChild("left_wing_tip", CubeListBuilder.create().texOffs(16, 8).addBox(0F, -2F, 0F, 6F, 8F, 0F, CubeDeformation.NONE), PartPose.offset(2F, 0F, 0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }
    @Override public ModelPart root() {return root;}
    @Override public void setupAnim(Bat entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netheadYaw, float headPitch) {
        root().getAllParts().forEach(ModelPart::resetPose);
        if(entity.isResting()) head.yRot = netheadYaw * Mth.DEG_TO_RAD;
        animate(entity.flyAnimationState, BatAnimation.BAT_FLYING, ageInTicks, 1F);
        animate(entity.restAnimationState, BatAnimation.BAT_RESTING, ageInTicks, 1F);
    }
}