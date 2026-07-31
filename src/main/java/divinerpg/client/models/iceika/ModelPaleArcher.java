package divinerpg.client.models.iceika;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;

import static divinerpg.utils.Utils.createLocation;

public class ModelPaleArcher<S extends HumanoidRenderState> extends HumanoidModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("pale_archer");
    public final ModelPart trail;

    public ModelPaleArcher(ModelPart root) {
        super(root);
        this.trail = this.body.getChild("trail");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = HumanoidModel.createMesh(CubeDeformation.NONE, 0);
        PartDefinition partdefinition = meshdefinition.getRoot();
        CubeDeformation cubeDef = CubeDeformation.NONE;

        partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(24, 8).addBox(-4.0F, -12.0F, -4.0F, 8.0F, 4.0F, 8.0F, cubeDef)
                .texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, cubeDef), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 0.0692F, 0.0F, 0.0F));

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(28, 20).addBox(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, cubeDef)
                .texOffs(0, 16).addBox(-4.5F, -12.3F, -2.5F, 9.0F, 12.0F, 5.0F, cubeDef), PartPose.offset(0.0F, 0.0F, 3.0F));

        partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(24, 36).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, cubeDef), PartPose.offset(0.0F, 3.0F, 0.0F));

        partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(32, 36).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, cubeDef), PartPose.offset(0.0F, 3.0F, 0.0F));

        body.addOrReplaceChild("trail", CubeListBuilder.create().texOffs(0, 33).addBox(-4.0F, 2.0F, 1.0F, 8.0F, 7.0F, 4.0F, cubeDef), PartPose.offsetAndRotation(0.01F, -1.0F, -3.0F, 0.2618F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;
        float ageInTicks = state.ageInTicks;
        float attackTime = state.attackTime;

        this.body.xRot = 0.1565F;
        this.rightArm.zRot = 0.2182F;
        this.leftArm.zRot = -0.2182F;
        this.rightArm.z = 0.0F;
        this.leftArm.z = 0.0F;
        this.head.y = 2.0F;
        this.hat.y = 2.0F;
        this.body.y = 14.0F;

    }
}