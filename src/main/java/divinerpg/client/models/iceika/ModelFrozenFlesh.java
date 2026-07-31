package divinerpg.client.models.iceika;

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

public class ModelFrozenFlesh<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("frozen_flesh");
    public final ModelPart head;
    public final ModelPart torso;
    public final ModelPart base;

    public ModelFrozenFlesh(ModelPart root) {
        super(root);
        ModelPart rootPart = root.getChild("root");
        this.head = rootPart.getChild("head");
        this.torso = rootPart.getChild("torso");
        this.base = rootPart.getChild("base");
    }

    public ModelFrozenFlesh(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.ZERO);
        CubeDeformation cubeDef = CubeDeformation.NONE;

        root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 20).addBox(-4.5F, -8.0F, -4.5F, 9.0F, 8.0F, 9.0F, cubeDef), PartPose.offset(0.0F, 2.02F, 0.5F));

        PartDefinition torso = root.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(29, 30).addBox(-4.0F, -9.0F, -3.0F, 8.0F, 11.0F, 7.0F, cubeDef), PartPose.offset(0.0F, 11.01F, 0.0F));

        torso.addOrReplaceChild("right_shoulder", CubeListBuilder.create().texOffs(0, 37).addBox(-1.0F, -3.0F, -2.0F, 1.0F, 5.0F, 5.0F, cubeDef), PartPose.offsetAndRotation(-4.0F, -6.0F, 0.0F, 0.0F, 0.0F, -0.5236F));

        torso.addOrReplaceChild("left_shoulder", CubeListBuilder.create().texOffs(12, 37).addBox(0.0F, -3.0F, -2.0F, 1.0F, 5.0F, 5.0F, cubeDef), PartPose.offsetAndRotation(4.0F, -6.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

        torso.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(27, 24).addBox(-8.0F, -1.5F, -1.0F, 8.0F, 2.0F, 2.0F, cubeDef), PartPose.offsetAndRotation(-3.0F, -6.0F, 0.0F, 0.0F, 0.0F, -0.4363F));

        torso.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(27, 20).addBox(0.0F, -1.5F, -1.0F, 8.0F, 2.0F, 2.0F, cubeDef), PartPose.offsetAndRotation(3.0F, -6.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

        root.addOrReplaceChild("base", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, 0.0F, -4.5F, 10.0F, 11.0F, 9.0F, cubeDef), PartPose.offset(0.0F, 13.0F, 0.5F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        this.head.yRot = state.yRot * Mth.DEG_TO_RAD;
        this.head.xRot = state.xRot * Mth.DEG_TO_RAD;

        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;

        float f = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.torso.yRot = f * 0.15F;
        this.base.yRot = -f * 0.15F;
    }
}