package divinerpg.client.models.arcana;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

import static divinerpg.utils.Utils.createLocation;

public class ModelDeathHound extends EntityModel<LivingEntityRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("death_hound");
    private final ModelPart Body, Leg1, Leg2, Leg3, Leg4, Leg5;

    public ModelDeathHound(Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public ModelDeathHound(ModelPart root) {
        super(root);
        this.Body = root.getChild("Body");
        this.Leg1 = root.getChild("Leg1");
        this.Leg2 = root.getChild("Leg2");
        this.Leg3 = root.getChild("Leg3");
        this.Leg4 = root.getChild("Leg4");
        this.Leg5 = root.getChild("Leg5");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(43, 16).mirror().addBox(-4.0F, -7.5F, -9.0F, 2.0F, 4.0F, 1.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(43, 16).mirror().addBox(0.0F, -7.5F, -9.0F, 2.0F, 4.0F, 1.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(0, 0).mirror().addBox(-4.0F, -3.5F, -14.0F, 6.0F, 6.0F, 6.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(0, 19).mirror().addBox(-2.5F, -0.5F, -18.0F, 3.0F, 3.0F, 4.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(21, 0).mirror().addBox(-5.0F, -3.0F, -8.0F, 8.0F, 9.0F, 7.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(1.0F, 14.0F, 2.0F));

        Body.addOrReplaceChild("Tail2_r1", CubeListBuilder.create().texOffs(9, 18).mirror().addBox(-0.1F, 4.1842F, 11.7133F, 2.0F, 8.0F, 2.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(9, 18).mirror().addBox(-3.9F, 4.1842F, 11.7133F, 2.0F, 8.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(0.0F, 10.0F, -2.0F, 1.117F, 0.0F, 0.0F));

        Body.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(-4.0F, -10.0F, -11.0F, 6.0F, 9.0F, 6.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(0.0F, 10.0F, -2.0F, -1.5708F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("Leg1", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-1.5F, 16.0F, -1.0F));

        partdefinition.addOrReplaceChild("Leg2", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(1.5F, 16.0F, -1.0F));

        partdefinition.addOrReplaceChild("Leg3", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-1.0F, 0.0F, -3.0F, 2.0F, 8.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(0.0F, 16.0F, -7.0F));

        partdefinition.addOrReplaceChild("Leg4", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(1.5F, 16.0F, 7.0F));

        partdefinition.addOrReplaceChild("Leg5", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-1.5F, 16.0F, 7.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(LivingEntityRenderState state) {
        super.setupAnim(state);
        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;

        this.Leg1.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        this.Leg2.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
        this.Leg3.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        this.Leg4.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        this.Leg5.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
    }
}