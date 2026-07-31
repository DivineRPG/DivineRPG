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

public class ModelDensos<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("densos");
    private final ModelPart body;
    public final ModelPart rightarm;
    private final ModelPart leftarm;
    private final ModelPart rightleg;
    private final ModelPart leftleg;
    private final ModelPart head;

    public ModelDensos(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public ModelDensos(ModelPart root) {
        super(root);
        ModelPart rootPart = root.getChild("root");
        this.body = rootPart.getChild("body");
        this.rightarm = rootPart.getChild("rightarm");
        this.leftarm = rootPart.getChild("leftarm");
        this.rightleg = rootPart.getChild("rightleg");
        this.leftleg = rootPart.getChild("leftleg");
        this.head = rootPart.getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.ZERO);
        CubeDeformation cubedef = new CubeDeformation(0.0F);

        root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, cubedef).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        root.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(40, 4).mirror().addBox(-3.0F, -2.0F, -2.0F, 4.0F, 18.0F, 4.0F, cubedef).mirror(false), PartPose.offset(-5.0F, 2.0F, 0.0F));

        root.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(40, 1).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 18.0F, 4.0F, cubedef).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));

        root.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, cubedef).mirror(false), PartPose.offset(-2.0F, 12.0F, 0.0F));

        root.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, cubedef).mirror(false), PartPose.offset(2.0F, 12.0F, 0.0F));

        root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-9.4667F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, cubedef).mirror(false)
                .texOffs(0, 0).mirror().addBox(2.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, cubedef).mirror(false)
                .texOffs(0, 0).mirror().addBox(6.5333F, -16.0F, -3.0F, 8.0F, 8.0F, 8.0F, cubedef).mirror(false)
                .texOffs(0, 0).mirror().addBox(-14.4667F, -16.0F, -3.0F, 8.0F, 8.0F, 8.0F, cubedef).mirror(false)
                .texOffs(0, 0).mirror().addBox(-3.4667F, -16.0F, -3.0F, 8.0F, 8.0F, 8.0F, cubedef).mirror(false), PartPose.offset(-0.5333F, 0.0F, 0.0F));

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