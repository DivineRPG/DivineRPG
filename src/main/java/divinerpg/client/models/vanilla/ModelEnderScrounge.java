package divinerpg.client.models.vanilla;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.util.Mth;

import static divinerpg.utils.Utils.createLocation;

public class ModelEnderScrounge extends EntityModel<LivingEntityRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("ender_scrounge");

    private final ModelPart body;
    private final ModelPart tail;
    private final ModelPart head;
    private final ModelPart frontleft;
    private final ModelPart frontright;
    private final ModelPart backleft;
    private final ModelPart backright;

    public ModelEnderScrounge(ModelPart root) {
        super(root);
        this.body = root.getChild("body");
        this.tail = this.body.getChild("tail");
        this.head = root.getChild("head");
        this.frontleft = root.getChild("frontleft");
        this.frontright = root.getChild("frontright");
        this.backleft = root.getChild("backleft");
        this.backright = root.getChild("backright");
    }

    public ModelEnderScrounge(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -3.0F, -3.0F, 4.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, -1.0F));

        body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(22, -4).addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 4.0F));

        partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 10).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(22, 3).addBox(1.0F, -4.0F, -2.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 3).addBox(-4.0F, -4.0F, -2.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(24, 12).addBox(-1.0F, -0.1F, -5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(12, 11).addBox(-0.5F, -0.3F, -5.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 21.0F, -4.0F));

        partdefinition.addOrReplaceChild("frontleft", CubeListBuilder.create().texOffs(12, 11).addBox(0.0F, 1.0F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(0.0F, -1.0F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 22.0F, -3.0F));

        partdefinition.addOrReplaceChild("frontright", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(12, 11).addBox(-1.0F, 1.0F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 22.0F, -3.0F));

        partdefinition.addOrReplaceChild("backleft", CubeListBuilder.create().texOffs(14, 10).addBox(0.0F, -1.0F, -2.0F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(12, 11).addBox(0.0F, 2.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 21.0F, 2.0F));

        partdefinition.addOrReplaceChild("backright", CubeListBuilder.create().texOffs(12, 11).addBox(-1.0F, 2.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(14, 10).addBox(-1.0F, -1.0F, -2.0F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 21.0F, 2.0F));

        return LayerDefinition.create(meshdefinition, 32, 16);
    }

    @Override
    public void setupAnim(LivingEntityRenderState state) {
        super.setupAnim(state);

        this.head.yRot = state.yRot * Mth.DEG_TO_RAD;
        this.head.xRot = state.xRot * Mth.DEG_TO_RAD;

        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;

        this.frontleft.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.backright.xRot = this.frontleft.xRot;

        this.frontright.xRot = Mth.cos(limbSwing * 0.6662F + Mth.PI) * 1.4F * limbSwingAmount;
        this.backleft.xRot = this.frontright.xRot;

        this.tail.zRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
    }
}