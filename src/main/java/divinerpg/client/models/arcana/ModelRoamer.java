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

public class ModelRoamer<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("roamer");
    private final ModelPart body, rightleg, leftleg;

    public ModelRoamer(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public ModelRoamer(ModelPart root) {
        super(root);
        ModelPart rootPart = root.getChild("root");
        this.body = rootPart.getChild("body");
        this.rightleg = rootPart.getChild("rightleg");
        this.leftleg = rootPart.getChild("leftleg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.ZERO);

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(14, 25).mirror().addBox(-10.0F, 12.0F, -5.0F, 2.0F, 2.0F, 5.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(0, 25).mirror().addBox(-8.0F, 10.0F, -5.0F, 2.0F, 2.0F, 5.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(0, 18).mirror().addBox(0.0F, 10.0F, -5.0F, 2.0F, 2.0F, 5.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(39, 20).mirror().addBox(-6.0F, 12.0F, -6.0F, 6.0F, 6.0F, 6.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(39, 20).mirror().addBox(-6.0F, 18.0F, -6.0F, 6.0F, 6.0F, 6.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(39, 20).mirror().addBox(-6.0F, 6.0F, -6.0F, 6.0F, 6.0F, 6.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(14, 18).mirror().addBox(2.0F, 12.0F, -5.0F, 2.0F, 2.0F, 5.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(2.0F, -5.0F, 2.0F));

        body.addOrReplaceChild("Main_Body1_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(1.0F, -28.0F, -11.0F, 10.0F, 6.0F, 10.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(0, 0).mirror().addBox(1.0F, -28.0F, 2.0F, 10.0F, 6.0F, 10.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-2.0F, 29.0F, -10.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition rightleg = root.addOrReplaceChild("rightleg", CubeListBuilder.create(), PartPose.offset(-4.0F, 15.0F, -1.0F));

        rightleg.addOrReplaceChild("Legbottom1_r1", CubeListBuilder.create().texOffs(14, 25).mirror().addBox(-6.0F, 0.0F, -3.0F, 2.0F, 2.0F, 5.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(0, 25).mirror().addBox(-6.0F, 0.0F, -8.0F, 2.0F, 2.0F, 5.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(4.0F, 7.0F, 1.0F, -1.5708F, 0.0F, 0.0F));

        PartDefinition leftleg = root.addOrReplaceChild("leftleg", CubeListBuilder.create(), PartPose.offset(2.0F, 15.0F, -1.0F));

        leftleg.addOrReplaceChild("Legtop2_r1", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(2.0F, 0.0F, -7.0F, 2.0F, 2.0F, 5.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(14, 18).mirror().addBox(2.0F, 0.0F, -2.0F, 2.0F, 2.0F, 5.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-2.0F, 6.0F, 1.0F, -1.5708F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);
        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;

        this.rightleg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leftleg.xRot = Mth.cos(limbSwing * 0.6662F + Mth.PI) * 1.4F * limbSwingAmount;
    }
}