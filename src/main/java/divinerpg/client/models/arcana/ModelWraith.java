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

public class ModelWraith<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("wraith");
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart leg3;
    private final ModelPart leg4;

    public ModelWraith(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public ModelWraith(ModelPart root) {
        super(root);
        ModelPart rootPart = root.getChild("root");
        this.head = rootPart.getChild("head");
        this.body = rootPart.getChild("body");
        this.leg3 = rootPart.getChild("leg3");
        this.leg4 = rootPart.getChild("leg4");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.ZERO);

        root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 6.0F, -8.0F));

        root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(19, 0).mirror().addBox(-6.0F, -10.0F, -7.0F, 12.0F, 22.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 11.0F, 2.0F, 0.8644F, 0.0F, 0.0F));

        root.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-3.0F, 0.0F, -3.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 13.0F, -5.0F, -1.309F, 1.1345F, 0.0F));

        root.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-1.0F, 0.0F, -3.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 13.0F, -5.0F, -1.309F, -1.1345F, -0.0744F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);
        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;

        this.head.yRot = state.yRot * Mth.DEG_TO_RAD;
        this.head.xRot = state.xRot * Mth.DEG_TO_RAD;
        this.leg4.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leg3.xRot = Mth.cos(limbSwing * 0.6662F + Mth.PI) * 1.4F * limbSwingAmount;
        this.leg4.yRot = 0.0F;
        this.leg3.yRot = 0.0F;
    }
}