package divinerpg.client.models.vethea;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.util.Mth;

import static divinerpg.utils.Utils.createLocation;

public class ModelHiveSoldier<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("hive_soldier");
    private final ModelPart head;
    private final ModelPart body1;
    private final ModelPart rightarm;
    private final ModelPart leftarm;
    private final ModelPart rightleg;
    private final ModelPart leftleg;
    private final ModelPart body2;
    private final ModelPart body3;
    private final ModelPart body4;
    private final ModelPart body5;
    private final ModelPart body6;
    private final ModelPart body7;

    public ModelHiveSoldier(ModelPart root) {
        super(root);
        this.head = root.getChild("head");
        this.body1 = root.getChild("body1");
        this.rightarm = root.getChild("rightarm");
        this.leftarm = root.getChild("leftarm");
        this.rightleg = root.getChild("rightleg");
        this.leftleg = root.getChild("leftleg");
        this.body2 = root.getChild("body2");
        this.body3 = root.getChild("body3");
        this.body4 = root.getChild("body4");
        this.body5 = root.getChild("body5");
        this.body6 = root.getChild("body6");
        this.body7 = root.getChild("body7");
    }

    public ModelHiveSoldier(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -8.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 1.0F, 0.0F));

        partdefinition.addOrReplaceChild("body1", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(0.0F, 10.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 0.0F, 1.0F));

        partdefinition.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-3.0F, -2.0F, -2.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 2.0F, 1.0F));

        partdefinition.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(6.0F, 2.0F, 1.0F));

        partdefinition.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 12.0F, 1.0F));

        partdefinition.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 12.0F, 1.0F));

        partdefinition.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 4.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 0.0F, 1.0F));

        partdefinition.addOrReplaceChild("body3", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-7.0F, 2.0F, -2.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(9.0F, 3.0F, 1.0F));

        partdefinition.addOrReplaceChild("body4", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-6.0F, 10.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 0.0F, 1.0F));

        partdefinition.addOrReplaceChild("body5", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-7.0F, 2.0F, -2.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 3.0F, 1.0F));

        partdefinition.addOrReplaceChild("body6", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-7.0F, 2.0F, -2.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(9.0F, -1.0F, 1.0F));

        partdefinition.addOrReplaceChild("body7", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-7.0F, 2.0F, -2.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -1.0F, 1.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;

        this.leftleg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.rightleg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.rightarm.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
        this.leftarm.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
    }
}