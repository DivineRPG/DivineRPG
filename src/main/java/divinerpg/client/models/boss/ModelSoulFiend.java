package divinerpg.client.models.boss;

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

public class ModelSoulFiend<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("soul_fiend");
    private final ModelPart body;
    private final ModelPart rightleg;
    private final ModelPart leftleg;
    private final ModelPart head;
    private final ModelPart leftarm;
    private final ModelPart rightarm;
    private final ModelPart back;

    public ModelSoulFiend(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public ModelSoulFiend(ModelPart root) {
        super(root);
        ModelPart rootPart = root.getChild("root");
        this.body = rootPart.getChild("body");
        this.rightleg = rootPart.getChild("rightleg");
        this.leftleg = rootPart.getChild("leftleg");
        this.head = rootPart.getChild("head");
        this.leftarm = rootPart.getChild("leftarm");
        this.rightarm = rootPart.getChild("rightarm");
        this.back = rootPart.getChild("back");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.ZERO);
        CubeDeformation cubedef = new CubeDeformation(0.0F);

        root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(4.0F, -2.0F, -2.0F, 8.0F, 12.0F, 4.0F, cubedef).mirror(false)
                .texOffs(40, 16).mirror().addBox(12.0F, -2.0F, -2.0F, 3.0F, 3.0F, 4.0F, cubedef).mirror(false)
                .texOffs(40, 16).mirror().addBox(1.0F, -2.0F, -2.0F, 3.0F, 3.0F, 4.0F, cubedef).mirror(false), PartPose.offset(-8.0F, 2.0F, 0.0F));

        root.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-3.0F, 9.0F, -3.0F, 6.0F, 3.0F, 6.0F, cubedef).mirror(false)
                .texOffs(0, 16).mirror().addBox(-2.0F, -0.1F, -2.0F, 4.0F, 12.0F, 4.0F, cubedef).mirror(false)
                .texOffs(0, 16).mirror().addBox(-3.0F, -4.0F, -3.0F, 6.0F, 5.0F, 6.0F, cubedef).mirror(false), PartPose.offset(-4.0F, 12.0F, 0.0F));

        root.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-3.0F, 9.0F, -3.0F, 6.0F, 3.0F, 6.0F, cubedef).mirror(false)
                .texOffs(0, 16).mirror().addBox(-2.0F, -0.2F, -2.0F, 4.0F, 12.0F, 4.0F, cubedef).mirror(false)
                .texOffs(0, 16).mirror().addBox(-3.0F, -4.0F, -3.0F, 6.0F, 5.0F, 6.0F, cubedef).mirror(false), PartPose.offset(4.0F, 12.0F, 0.0F));

        root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(-8.0F, -3.0F, -9.0F, 2.0F, 2.0F, 5.0F, cubedef).mirror(false)
                .texOffs(9, 0).mirror().addBox(-8.0F, -6.0F, -4.0F, 4.0F, 2.0F, 2.0F, cubedef).mirror(false)
                .texOffs(9, 0).mirror().addBox(-8.0F, -3.0F, -4.0F, 4.0F, 2.0F, 2.0F, cubedef).mirror(false)
                .texOffs(8, 0).mirror().addBox(-8.0F, -6.0F, -9.0F, 2.0F, 2.0F, 5.0F, cubedef).mirror(false)
                .texOffs(0, 0).mirror().addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, cubedef).mirror(false)
                .texOffs(8, 0).mirror().addBox(-4.0F, -8.0F, -9.0F, 2.0F, 2.0F, 5.0F, cubedef).mirror(false)
                .texOffs(8, 0).mirror().addBox(2.0F, -8.0F, -9.0F, 2.0F, 2.0F, 5.0F, cubedef).mirror(false)
                .texOffs(9, 0).mirror().addBox(4.0F, -3.0F, -4.0F, 4.0F, 2.0F, 2.0F, cubedef).mirror(false)
                .texOffs(9, 0).mirror().addBox(4.0F, -6.0F, -4.0F, 4.0F, 2.0F, 2.0F, cubedef).mirror(false)
                .texOffs(8, 0).mirror().addBox(6.0F, -6.0F, -9.0F, 2.0F, 2.0F, 5.0F, cubedef).mirror(false)
                .texOffs(8, 0).mirror().addBox(6.0F, -3.0F, -9.0F, 2.0F, 2.0F, 5.0F, cubedef).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        root.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(40, 3).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 20.0F, 4.0F, cubedef).mirror(false), PartPose.offset(8.0F, 2.0F, 0.0F));

        root.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(40, 3).mirror().addBox(-3.0F, -2.0F, -2.0F, 4.0F, 20.0F, 4.0F, cubedef).mirror(false), PartPose.offset(-8.0F, 2.0F, 0.0F));

        PartDefinition back = root.addOrReplaceChild("back", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(-5.0F, 0.0F, 3.0F, 5.0F, 2.0F, 2.0F, cubedef).mirror(false)
                .texOffs(8, 0).mirror().addBox(4.0F, 0.0F, 3.0F, 5.0F, 2.0F, 2.0F, cubedef).mirror(false)
                .texOffs(42, 5).mirror().addBox(4.0F, 4.0F, 3.0F, 8.0F, 2.0F, 2.0F, cubedef).mirror(false)
                .texOffs(42, 5).mirror().addBox(-8.0F, 4.0F, 3.0F, 8.0F, 2.0F, 2.0F, cubedef).mirror(false)
                .texOffs(4, 0).mirror().addBox(0.0F, 4.0F, 0.0F, 4.0F, 4.0F, 5.0F, cubedef).mirror(false)
                .texOffs(4, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 4.0F, 5.0F, cubedef).mirror(false), PartPose.offset(-2.0F, 0.0F, 2.0F));

        back.addOrReplaceChild("back12_r1", CubeListBuilder.create().texOffs(34, 26).mirror().addBox(-10.1F, -15.1F, 4.0F, 12.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(2.0F, 24.0F, -2.0F, 0.0F, 0.0F, 0.6981F));

        back.addOrReplaceChild("back2_r1", CubeListBuilder.create().texOffs(34, 26).mirror().addBox(-2.0F, -15.1F, 4.0F, 12.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(2.0F, 24.0F, -2.0F, 0.0F, 0.0F, -0.6981F));

        back.addOrReplaceChild("back4_r1", CubeListBuilder.create().texOffs(15, 25).mirror().addBox(20.0F, -10.0F, 5.0F, 9.0F, 2.0F, 2.0F, cubedef).mirror(false)
                .texOffs(15, 25).mirror().addBox(20.0F, 8.0F, 5.0F, 9.0F, 2.0F, 2.0F, cubedef).mirror(false)
                .texOffs(15, 25).mirror().addBox(24.0F, 5.0F, 5.0F, 9.0F, 2.0F, 2.0F, cubedef).mirror(false)
                .texOffs(15, 25).mirror().addBox(24.0F, -7.0F, 5.0F, 9.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(2.0F, 24.0F, -2.0F, 0.0F, 0.0F, -1.5708F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        this.head.yRot = state.yRot * Mth.DEG_TO_RAD;
        this.head.xRot = state.xRot * Mth.DEG_TO_RAD;

        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;

        this.rightarm.xRot = Mth.cos(limbSwing * 0.6662F + Mth.PI) * 2.0F * limbSwingAmount * 0.5F;
        this.leftarm.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
        this.rightarm.zRot = 0.0F;
        this.leftarm.zRot = 0.0F;

        this.rightleg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leftleg.xRot = Mth.cos(limbSwing * 0.6662F + Mth.PI) * 1.4F * limbSwingAmount;
        this.rightleg.yRot = 0.0F;
        this.leftleg.yRot = 0.0F;
    }
}