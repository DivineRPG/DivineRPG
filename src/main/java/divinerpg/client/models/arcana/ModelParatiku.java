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

public class ModelParatiku<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("paratiku");
    private final ModelPart body, rightWing, rightWingTip, leftWing, leftWingTip;

    public ModelParatiku(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public ModelParatiku(ModelPart root) {
        super(root);
        ModelPart rootPart = root.getChild("root");
        this.body = rootPart.getChild("body");
        this.rightWing = this.body.getChild("rightWing");
        this.rightWingTip = this.rightWing.getChild("rightWingTip");
        this.leftWing = this.body.getChild("leftWing");
        this.leftWingTip = this.leftWing.getChild("leftWingTip");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.ZERO);

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0F, 17F, 0F));

        body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-7F, -11F, -5.5F, 14F, 14F, 10F, CubeDeformation.NONE)
                .texOffs(0, 36).addBox(-4F, -9F, -7.5F, 8F, 8F, 8F, CubeDeformation.NONE)
                .texOffs(0, 0).mirror().addBox(2.5F, 0F, -6.5F, 2F, 6F, 2F, CubeDeformation.NONE).mirror(false)
                .texOffs(0, 0).addBox(-4.5F, 0F, -6.5F, 2F, 6F, 2F, CubeDeformation.NONE), PartPose.offset(0F, 0F, 0F));

        body.addOrReplaceChild("feet", CubeListBuilder.create().texOffs(24, 36).addBox(-4.5F, -2F, -0.5F, 3F, 4F, 0F, CubeDeformation.NONE)
                .texOffs(30, 36).addBox(1.5F, -2F, -0.5F, 3F, 4F, 0F, CubeDeformation.NONE), PartPose.offset(0F, 5F, 0F));

        PartDefinition rightWing = body.addOrReplaceChild("rightWing", CubeListBuilder.create(), PartPose.offset(-1.5F, 0F, 0F));

        rightWing.addOrReplaceChild("rightWing_r1", CubeListBuilder.create().texOffs(24, 24).addBox(-8F, -6F, 0F, 8F, 10F, 0F, CubeDeformation.NONE), PartPose.offsetAndRotation(-2.5F, -2F, 4.5F, 0F, 0.3927F, 0F));

        PartDefinition rightWingTip = rightWing.addOrReplaceChild("rightWingTip", CubeListBuilder.create(), PartPose.offset(-10F, -6F, 7.5F));

        rightWingTip.addOrReplaceChild("rightWingTip_r1", CubeListBuilder.create().texOffs(0, 24).addBox(-17.6568F, -6F, 5.6569F, 12F, 12F, 0F, CubeDeformation.NONE), PartPose.offsetAndRotation(7.5F, 4F, -3F, 0F, -0.3927F, 0F));

        PartDefinition leftWing = body.addOrReplaceChild("leftWing", CubeListBuilder.create(), PartPose.offset(1.5F, 0F, 0F));

        leftWing.addOrReplaceChild("leftWing_r1", CubeListBuilder.create().texOffs(24, 24).mirror().addBox(0F, -6F, 0F, 8F, 10F, 0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(2.5F, -2F, 4.5F, 0F, -0.3927F, 0F));

        PartDefinition leftWingTip = leftWing.addOrReplaceChild("leftWingTip", CubeListBuilder.create(), PartPose.offset(10F, -6F, 7.5F));

        leftWingTip.addOrReplaceChild("leftWingTip_r1", CubeListBuilder.create().texOffs(0, 24).mirror().addBox(5.6569F, -6F, 5.6569F, 12F, 12F, 0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-7.5F, 4F, -3F, 0F, 0.3927F, 0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);
        body.xRot = state.xRot * Mth.DEG_TO_RAD;
        leftWing.yRot = Mth.cos(state.ageInTicks) * Mth.PI * 0.1F;
        leftWingTip.yRot = leftWing.yRot * 0.5F;
        rightWing.yRot = -leftWing.yRot;
        rightWingTip.yRot = -leftWingTip.yRot;
    }
}