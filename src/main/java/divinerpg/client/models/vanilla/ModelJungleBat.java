package divinerpg.client.models.vanilla;

import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.animation.definitions.BatAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.state.BatRenderState;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.util.Mth;

import static divinerpg.utils.Utils.createLocation;

public class ModelJungleBat<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("jungle_bat");
    private final ModelPart root;
    private final ModelPart head;
    private final KeyframeAnimation flyingAnimation;
    private final KeyframeAnimation restingAnimation;

    public ModelJungleBat(ModelPart root) {
        super(root);
        this.root = root;
        this.head = root.getChild("head");
        this.flyingAnimation = BatAnimation.BAT_FLYING.bake(root);
        this.restingAnimation = BatAnimation.BAT_RESTING.bake(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 7).addBox(-2F, -3F, -1F, 4F, 3F, 2F, CubeDeformation.NONE)
                .texOffs(8, 21).addBox(-0.5F, -4F, -1.4284F, 1F, 2F, 2F, CubeDeformation.NONE)
                .texOffs(0, 25).addBox(-2.5F, -4F, -1.5F, 1F, 2F, 1F, CubeDeformation.NONE)
                .texOffs(0, 25).mirror().addBox(1.5F, -4F, -1.5F, 1F, 2F, 1F, CubeDeformation.NONE).mirror(false), PartPose.offset(0F, 17F, 0F));

        PartDefinition rightEar = head.addOrReplaceChild("right_ear", CubeListBuilder.create(), PartPose.offset(-1.5F, -2F, 0F));

        rightEar.addOrReplaceChild("right_ear_r1", CubeListBuilder.create().texOffs(1, 20).addBox(-3F, -4F, 0.001F, 3F, 5F, 0F, CubeDeformation.NONE)
                .texOffs(1, 15).addBox(-3F, -4F, 0F, 3F, 5F, 0F, CubeDeformation.NONE), PartPose.offsetAndRotation(0.5F, -1F, 0.5F, 0F, 0F, -0.7854F));

        PartDefinition leftEar = head.addOrReplaceChild("left_ear", CubeListBuilder.create(), PartPose.offset(1.1F, -2F, 0F));

        leftEar.addOrReplaceChild("left_ear_r1", CubeListBuilder.create().texOffs(8, 27).addBox(0F, -4F, 0.001F, 3F, 5F, 0F, CubeDeformation.NONE)
                .texOffs(8, 15).addBox(0F, -4F, 0F, 3F, 5F, 0F, CubeDeformation.NONE), PartPose.offsetAndRotation(-0.1F, -1F, 0.5F, 0F, 0F, 0.7854F));

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, 0F, -1F, 3F, 5F, 2F, CubeDeformation.NONE)
                .texOffs(8, 25).addBox(-0.5F, 0.5F, 1F, 1F, 1F, 1F, CubeDeformation.NONE), PartPose.offset(0F, 17F, 0F));

        body.addOrReplaceChild("feet", CubeListBuilder.create().texOffs(16, 16).addBox(-1.5F, 0F, 0F, 3F, 2F, 0F, CubeDeformation.NONE), PartPose.offset(0F, 5F, 0F));

        PartDefinition rightWing = body.addOrReplaceChild("right_wing", CubeListBuilder.create().texOffs(12, 0).addBox(-2F, -2F, 0F, 2F, 7F, 0F, CubeDeformation.NONE), PartPose.offset(-1.5F, 0F, 0F));

        rightWing.addOrReplaceChild("right_wing_tip", CubeListBuilder.create().texOffs(16, 0).addBox(-6F, -2F, 0F, 6F, 8F, 0F, CubeDeformation.NONE), PartPose.offset(-2F, 0F, 0F));

        PartDefinition leftWing = body.addOrReplaceChild("left_wing", CubeListBuilder.create().texOffs(12, 7).addBox(0F, -2F, 0F, 2F, 7F, 0F, CubeDeformation.NONE), PartPose.offset(1.5F, 0F, 0F));

        leftWing.addOrReplaceChild("left_wing_tip", CubeListBuilder.create().texOffs(16, 8).addBox(0F, -2F, 0F, 6F, 8F, 0F, CubeDeformation.NONE), PartPose.offset(2F, 0F, 0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        if (state instanceof BatRenderState batState) {
            if (batState.isResting) {
                this.head.yRot = batState.yRot * Mth.DEG_TO_RAD;
            }

            this.flyingAnimation.apply(batState.flyAnimationState, batState.ageInTicks);
            this.restingAnimation.apply(batState.restAnimationState, batState.ageInTicks);
        }
    }
}