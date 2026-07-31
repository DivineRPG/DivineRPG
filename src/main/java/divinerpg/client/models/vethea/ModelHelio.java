package divinerpg.client.models.vethea;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.util.Mth;

import static divinerpg.utils.Utils.createLocation;

public class ModelHelio<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("helio");
    private final ModelPart head;
    private final ModelPart body1;
    private final ModelPart leftarmp1;
    private final ModelPart rightlegt;
    private final ModelPart leftlegt;
    private final ModelPart body2;
    private final ModelPart body3;
    private final ModelPart body4;
    private final ModelPart body5;
    private final ModelPart body6;
    private final ModelPart leftlegm;
    private final ModelPart rightlegm;
    private final ModelPart leftleg;
    private final ModelPart rightleg;
    private final ModelPart leftarmp2;
    private final ModelPart leftarmp3;
    private final ModelPart leftarmp4;
    private final ModelPart leftarmp5;
    private final ModelPart leftarmp6;

    public ModelHelio(ModelPart root) {
        super(root);
        this.head = root.getChild("head");
        this.body1 = root.getChild("body1");
        this.leftarmp1 = root.getChild("leftarmp1");
        this.rightlegt = root.getChild("rightlegt");
        this.leftlegt = root.getChild("leftlegt");
        this.body2 = root.getChild("body2");
        this.body3 = root.getChild("body3");
        this.body4 = root.getChild("body4");
        this.body5 = root.getChild("body5");
        this.body6 = root.getChild("body6");
        this.leftlegm = root.getChild("leftlegm");
        this.rightlegm = root.getChild("rightlegm");
        this.leftleg = root.getChild("leftleg");
        this.rightleg = root.getChild("rightleg");
        this.leftarmp2 = root.getChild("leftarmp2");
        this.leftarmp3 = root.getChild("leftarmp3");
        this.leftarmp4 = root.getChild("leftarmp4");
        this.leftarmp5 = root.getChild("leftarmp5");
        this.leftarmp6 = root.getChild("leftarmp6");
    }

    public ModelHelio(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("body1", CubeListBuilder.create().texOffs(76, 0).mirror().addBox(-4.0F, 0.0F, -2.0F, 6.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(7.0F, 0.0F, -1.0F));

        partdefinition.addOrReplaceChild("leftarmp1", CubeListBuilder.create().texOffs(226, 6).mirror().addBox(-1.0F, -3.0F, -3.0F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(10.0F, 2.0F, 0.0F));

        partdefinition.addOrReplaceChild("rightlegt", CubeListBuilder.create().texOffs(199, 17).mirror().addBox(-3.0F, -2.0F, -3.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.0F, 12.0F, 0.0F));

        partdefinition.addOrReplaceChild("leftlegt", CubeListBuilder.create().texOffs(199, 17).mirror().addBox(-3.0F, -2.0F, -3.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(6.0F, 12.0F, 0.0F));

        partdefinition.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(76, 0).mirror().addBox(-4.0F, 0.0F, -2.0F, 6.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(7.0F, 0.0F, 2.0F));

        partdefinition.addOrReplaceChild("body3", CubeListBuilder.create().texOffs(58, 0).mirror().addBox(-4.0F, 0.0F, -2.0F, 6.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, -2.0F, -1.0F));

        partdefinition.addOrReplaceChild("body4", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 6.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, -2.0F, 2.0F));

        partdefinition.addOrReplaceChild("body5", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-4.0F, 0.0F, -2.0F, 6.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, 0.0F, -1.0F));

        partdefinition.addOrReplaceChild("body6", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-4.0F, 0.0F, -2.0F, 6.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, 0.0F, 2.0F));

        partdefinition.addOrReplaceChild("leftlegm", CubeListBuilder.create().texOffs(97, 0).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(6.0F, 12.0F, 0.0F));

        partdefinition.addOrReplaceChild("rightlegm", CubeListBuilder.create().texOffs(97, 0).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.0F, 12.0F, 0.0F));

        partdefinition.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(97, 20).mirror().addBox(-3.0F, 7.0F, -3.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(6.0F, 12.0F, 0.0F));

        partdefinition.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(97, 20).mirror().addBox(-3.0F, 7.0F, -3.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.0F, 12.0F, 0.0F));

        partdefinition.addOrReplaceChild("leftarmp2", CubeListBuilder.create().texOffs(140, 11).mirror().addBox(3.0F, 10.0F, 10.0F, 12.0F, 9.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(10.0F, 2.0F, 0.0F, -1.5708F, 0.6109F, 0.0F));

        partdefinition.addOrReplaceChild("leftarmp3", CubeListBuilder.create().texOffs(36, 16).mirror().addBox(1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(10.0F, 2.0F, 0.0F));

        partdefinition.addOrReplaceChild("leftarmp4", CubeListBuilder.create().texOffs(69, 17).mirror().addBox(0.0F, 6.0F, 0.0F, 6.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(10.0F, 2.0F, 0.0F, -0.5236F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("leftarmp5", CubeListBuilder.create().texOffs(116, 1).mirror().addBox(1.0F, 9.0F, 3.0F, 8.0F, 9.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(10.0F, 2.0F, 0.0F, -0.8727F, 0.2974F, 0.0F));

        partdefinition.addOrReplaceChild("leftarmp6", CubeListBuilder.create().texOffs(193, 10).mirror().addBox(0.0F, 9.0F, 9.0F, 10.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(10.0F, 2.0F, 0.0F, -1.3963F, 0.2974F, 0.0F));

        return LayerDefinition.create(meshdefinition, 256, 32);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;

        this.leftleg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.rightleg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leftlegm.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.rightlegm.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leftlegt.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.rightlegt.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    }
}