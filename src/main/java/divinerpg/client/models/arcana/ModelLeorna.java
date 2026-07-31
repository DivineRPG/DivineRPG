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
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.util.Mth;

import static divinerpg.utils.Utils.createLocation;

public class ModelLeorna<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("leorna");
    private final ModelPart head, body, rightarm, leftarm, rightleg, leftleg, a, bar1, bar2, bar3, bar4, box;

    public ModelLeorna(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public ModelLeorna(ModelPart root) {
        super(root);
        ModelPart rootPart = root.getChild("root");
        this.head = rootPart.getChild("head");
        this.body = rootPart.getChild("body");
        this.rightarm = rootPart.getChild("rightarm");
        this.leftarm = rootPart.getChild("leftarm");
        this.rightleg = rootPart.getChild("rightleg");
        this.leftleg = rootPart.getChild("leftleg");
        this.a = rootPart.getChild("a");
        this.bar1 = rootPart.getChild("bar1");
        this.bar2 = rootPart.getChild("bar2");
        this.bar3 = rootPart.getChild("bar3");
        this.bar4 = rootPart.getChild("bar4");
        this.box = rootPart.getChild("box");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.ZERO);

        root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(0.0F, 0.0F, -2.0F));

        root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 13).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        root.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(40, 13).mirror().addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-5.0F, 2.0F, 0.0F));

        root.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(40, 13).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));

        root.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(0, 13).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-2.0F, 12.0F, 0.0F));

        root.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(0, 13).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(2.0F, 12.0F, 0.0F));

        root.addOrReplaceChild("a", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        root.addOrReplaceChild("bar1", CubeListBuilder.create().texOffs(0, 29).mirror().addBox(0.0F, 0.0F, 0.0F, 24.0F, 2.0F, 1.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-12.0F, 9.0F, 3.0F));

        root.addOrReplaceChild("bar2", CubeListBuilder.create().texOffs(0, 29).mirror().addBox(0.0F, 0.0F, 0.0F, 24.0F, 2.0F, 1.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-12.0F, 0.0F, 3.0F));

        root.addOrReplaceChild("bar3", CubeListBuilder.create().texOffs(0, 29).mirror().addBox(0.0F, 0.0F, 0.0F, 24.0F, 2.0F, 1.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-12.0F, 3.0F, 3.0F));

        root.addOrReplaceChild("bar4", CubeListBuilder.create().texOffs(0, 29).mirror().addBox(0.0F, 0.0F, 0.0F, 24.0F, 2.0F, 1.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-12.0F, 6.0F, 3.0F));

        root.addOrReplaceChild("box", CubeListBuilder.create().texOffs(33, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 12.0F, 3.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-2.0F, -1.0F, 2.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);
        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;

        this.head.yRot = state.yRot * Mth.DEG_TO_RAD;
        this.head.xRot = state.xRot * Mth.DEG_TO_RAD;
        this.rightarm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 2.0F * limbSwingAmount * 0.5F;
        this.leftarm.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
        this.rightleg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leftleg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
    }
}