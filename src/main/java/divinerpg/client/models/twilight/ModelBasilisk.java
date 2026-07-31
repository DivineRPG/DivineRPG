package divinerpg.client.models.twilight;

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


public class ModelBasilisk<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("basilisk");
    public final ModelPart body;
    public final ModelPart bodyR1;
    public final ModelPart leg1;
    public final ModelPart leg2;
    public final ModelPart leg3;
    public final ModelPart leg4;
    public final ModelPart leg5;
    public final ModelPart leg6;

    public ModelBasilisk(ModelPart root) {
        super(root);
        ModelPart rootPart = root.getChild("root");
        this.body = rootPart.getChild("body");
        this.bodyR1 = this.body.getChild("body_r1");
        this.leg1 = rootPart.getChild("leg1");
        this.leg2 = rootPart.getChild("leg2");
        this.leg3 = rootPart.getChild("leg3");
        this.leg4 = rootPart.getChild("leg4");
        this.leg5 = rootPart.getChild("leg5");
        this.leg6 = rootPart.getChild("leg6");
    }

    public ModelBasilisk(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.ZERO);

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(56, 0).mirror().addBox(-1.0F, -1.0F, -9.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(0, 0).mirror().addBox(-5.0F, 1.0F, -17.0F, 10.0F, 6.0F, 7.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(56, 0).mirror().addBox(-1.0F, -1.0F, -6.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(56, 0).mirror().addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(56, 0).mirror().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(56, 0).mirror().addBox(-1.0F, -1.0F, 3.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(0.0F, 11.0F, 3.0F));

        body.addOrReplaceChild("body_r1", CubeListBuilder.create()
                .texOffs(32, 10).mirror().addBox(-5.0F, -9.0F, -12.0F, 10.0F, 16.0F, 6.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(0.0F, 13.0F, -3.0F, -1.5708F, 0.0F, 0.0F));

        root.addOrReplaceChild("leg1", CubeListBuilder.create()
                .texOffs(0, 16).mirror().addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-3.0F, 19.0F, -5.0F));

        root.addOrReplaceChild("leg2", CubeListBuilder.create()
                .texOffs(0, 16).mirror().addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(3.0F, 19.0F, -5.0F));

        root.addOrReplaceChild("leg3", CubeListBuilder.create()
                .texOffs(0, 16).mirror().addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-3.0F, 19.0F, 1.0F));

        root.addOrReplaceChild("leg4", CubeListBuilder.create()
                .texOffs(0, 16).mirror().addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(3.0F, 19.0F, 1.0F));

        root.addOrReplaceChild("leg5", CubeListBuilder.create()
                .texOffs(0, 16).mirror().addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-3.0F, 19.0F, 7.0F));

        root.addOrReplaceChild("leg6", CubeListBuilder.create()
                .texOffs(0, 16).mirror().addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(3.0F, 19.0F, 7.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;

        this.leg1.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leg2.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.leg3.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.leg4.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leg5.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leg6.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
    }
}