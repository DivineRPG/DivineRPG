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

public class ModelFyracryx extends EntityModel<LivingEntityRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("fyracryx");
    private final ModelPart root, head, leg0, leg1, leg2, leg3;

    public ModelFyracryx(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public ModelFyracryx(ModelPart root) {
        super(root);
        this.root = root.getChild("root");
        this.head = this.root.getChild("head");
        this.leg0 = this.root.getChild("leg0");
        this.leg1 = this.root.getChild("leg1");
        this.leg2 = this.root.getChild("leg2");
        this.leg3 = this.root.getChild("leg3");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0F, 24F, -1F));

        root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 13).addBox(-4.5F, -4F, -4F, 9F, 7F, 4F, CubeDeformation.NONE)
                .texOffs(0, 36).addBox(-3F, -3F, -6F, 6F, 6F, 2F, CubeDeformation.NONE)
                .texOffs(26, 17).addBox(-4.5F, -7F, -5F, 3F, 3F, 4F, CubeDeformation.NONE)
                .texOffs(26, 17).mirror().addBox(1.5F, -7F, -5F, 3F, 3F, 4F, CubeDeformation.NONE).mirror(false)
                .texOffs(0, 0).addBox(-3.5F, -1F, -6.5F, 1F, 3F, 1F, CubeDeformation.NONE)
                .texOffs(0, 0).mirror().addBox(2.5F, -1F, -6.5F, 1F, 3F, 1F, CubeDeformation.NONE).mirror(false), PartPose.offset(0F, -9F, -5F));

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -8F, 2F, -0.2618F, 0F, 0F));

        body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(42, 0).mirror().addBox(0F, 0F, -2F, 3F, 6F, 2F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(0F, 0F, 8F, 1.5708F, 0.3927F, 0F));

        body.addOrReplaceChild("body_r2", CubeListBuilder.create().texOffs(40, 17).mirror().addBox(0F, -5F, -3F, 1F, 3F, 3F, CubeDeformation.NONE).mirror(false)
                .texOffs(40, 17).addBox(-5F, -5F, -3F, 1F, 3F, 3F, CubeDeformation.NONE), PartPose.offsetAndRotation(2F, -4.5F, 9F, 1.5708F, 0F, 0F));

        body.addOrReplaceChild("body_r3", CubeListBuilder.create().texOffs(40, 36).mirror().addBox(0F, -5F, -3F, 1F, 3F, 5F, CubeDeformation.NONE).mirror(false)
                .texOffs(40, 36).addBox(-5F, -5F, -3F, 1F, 3F, 5F, CubeDeformation.NONE), PartPose.offsetAndRotation(2F, -5F, 1F, 1.5708F, 0F, 0F));

        body.addOrReplaceChild("body_r4", CubeListBuilder.create().texOffs(42, 0).addBox(-3F, 0F, -2F, 3F, 6F, 2F, CubeDeformation.NONE), PartPose.offsetAndRotation(0F, 0F, 8F, 1.5708F, -0.3927F, 0F));

        body.addOrReplaceChild("body_r5", CubeListBuilder.create().texOffs(26, 10).addBox(-2F, 1F, -2F, 4F, 2F, 5F, CubeDeformation.NONE)
                .texOffs(0, 24).addBox(-3.5F, -7F, -3F, 7F, 8F, 4F, CubeDeformation.NONE), PartPose.offsetAndRotation(0F, -0.5F, 7F, 1.5708F, 0F, 0F));

        body.addOrReplaceChild("body_r6", CubeListBuilder.create().texOffs(26, 0).addBox(-1F, -5F, -3F, 2F, 4F, 6F, CubeDeformation.NONE), PartPose.offsetAndRotation(0F, -4.5F, 6F, 1.5708F, 0F, 0F));

        body.addOrReplaceChild("body_r7", CubeListBuilder.create().texOffs(22, 24).addBox(-1F, -5F, -3F, 2F, 4F, 8F, CubeDeformation.NONE), PartPose.offsetAndRotation(0F, -5F, -2F, 1.5708F, 0F, 0F));

        body.addOrReplaceChild("body_r8", CubeListBuilder.create().texOffs(0, 0).addBox(-4F, -7F, -3F, 8F, 8F, 5F, CubeDeformation.NONE), PartPose.offsetAndRotation(0F, 0F, -1F, 1.5708F, 0F, 0F));

        root.addOrReplaceChild("leg0", CubeListBuilder.create().texOffs(16, 36).addBox(-1.5F, -1F, -1.5F, 3F, 8F, 3F, CubeDeformation.NONE), PartPose.offset(-3F, -7F, 5.5F));

        root.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(16, 36).mirror().addBox(-1.5F, -1F, -1.5F, 3F, 8F, 3F, CubeDeformation.NONE).mirror(false), PartPose.offset(3F, -7F, 5.5F));

        root.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(0, 44).addBox(-1.5F, -1F, -2F, 4F, 8F, 4F, CubeDeformation.NONE), PartPose.offset(-4F, -7F, -3F));

        root.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(0, 44).mirror().addBox(-2.5F, -1F, -2F, 4F, 8F, 4F, CubeDeformation.NONE).mirror(false), PartPose.offset(4F, -7F, -3F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(LivingEntityRenderState state) {
        super.setupAnim(state);
        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;

        this.head.xRot = state.xRot * Mth.DEG_TO_RAD;
        this.head.yRot = state.yRot * Mth.DEG_TO_RAD;
        this.leg0.xRot = this.leg3.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leg1.xRot = this.leg2.xRot = -this.leg0.xRot;
    }
}