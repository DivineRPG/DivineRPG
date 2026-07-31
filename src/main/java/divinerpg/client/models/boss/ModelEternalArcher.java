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

public class ModelEternalArcher<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("eternal_archer");
    public final ModelPart head;
    public final ModelPart shoulder6;
    public final ModelPart rightleg;
    public final ModelPart leftleg;
    public final ModelPart body;
    public final ModelPart shoulder1;
    public final ModelPart shoulder4;
    public final ModelPart shoulder3;
    public final ModelPart shoulder2;
    public final ModelPart shoulder5;
    public final ModelPart armRight1;
    public final ModelPart armRight2;
    public final ModelPart armRight3;
    public final ModelPart armLeft1;
    public final ModelPart armLeft2;
    public final ModelPart armLeft3;

    public ModelEternalArcher(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public ModelEternalArcher(ModelPart root) {
        super(root);
        ModelPart rootPart = root.getChild("root");
        this.head = rootPart.getChild("head");
        this.shoulder6 = rootPart.getChild("shoulder6");
        this.rightleg = rootPart.getChild("rightleg");
        this.leftleg = rootPart.getChild("leftleg");
        this.body = rootPart.getChild("body");
        this.shoulder1 = rootPart.getChild("shoulder1");
        this.shoulder4 = rootPart.getChild("shoulder4");
        this.shoulder3 = rootPart.getChild("shoulder3");
        this.shoulder2 = rootPart.getChild("shoulder2");
        this.shoulder5 = rootPart.getChild("shoulder5");
        this.armLeft1 = rootPart.getChild("armLeft1");
        this.armLeft2 = rootPart.getChild("armLeft2");
        this.armLeft3 = rootPart.getChild("armLeft3");
        this.armRight1 = rootPart.getChild("armRight1");
        this.armRight2 = rootPart.getChild("armRight2");
        this.armRight3 = rootPart.getChild("armRight3");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.ZERO);
        CubeDeformation cubedef = new CubeDeformation(0.0F);

        root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, cubedef).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        root.addOrReplaceChild("shoulder6", CubeListBuilder.create().texOffs(41, 1).mirror().addBox(-4.0F, 0.0F, -2.0F, 10.0F, 3.0F, 4.0F, cubedef).mirror(false), PartPose.offset(18.0F, -6.0F, 0.0F));

        root.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, cubedef).mirror(false), PartPose.offset(-3.0F, 12.0F, 0.0F));

        root.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, cubedef).mirror(false), PartPose.offset(3.0F, 12.0F, 0.0F));

        root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(46, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, cubedef).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        root.addOrReplaceChild("shoulder1", CubeListBuilder.create().texOffs(41, 1).mirror().addBox(-4.0F, 0.0F, -2.0F, 10.0F, 3.0F, 4.0F, cubedef).mirror(false), PartPose.offset(-20.0F, -6.0F, 0.0F));

        root.addOrReplaceChild("shoulder4", CubeListBuilder.create().texOffs(19, 24).mirror().addBox(-4.0F, 0.0F, -2.0F, 6.0F, 3.0F, 4.0F, cubedef).mirror(false), PartPose.offset(8.0F, 0.0F, 0.0F));

        root.addOrReplaceChild("shoulder3", CubeListBuilder.create().texOffs(19, 24).mirror().addBox(-4.0F, 0.0F, -2.0F, 6.0F, 3.0F, 4.0F, cubedef).mirror(false), PartPose.offset(-6.0F, 0.0F, 0.0F));

        root.addOrReplaceChild("shoulder2", CubeListBuilder.create().texOffs(17, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 10.0F, 3.0F, 4.0F, cubedef).mirror(false), PartPose.offset(-13.0F, -3.0F, 0.0F));

        root.addOrReplaceChild("shoulder5", CubeListBuilder.create().texOffs(17, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 10.0F, 3.0F, 4.0F, cubedef).mirror(false), PartPose.offset(11.0F, -3.0F, 0.0F));

        root.addOrReplaceChild("armLeft1", CubeListBuilder.create().texOffs(110, 16).mirror().addBox(-10.0F, -21.0F, -2.0F, 4.0F, 12.0F, 4.0F, cubedef).mirror(false), PartPose.offset(0.0F, 24.0F, 0.0F));
        root.addOrReplaceChild("armLeft2", CubeListBuilder.create().texOffs(71, 16).addBox(-17.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, cubedef).mirror(false), PartPose.offset(0.0F, 24.0F, 0.0F));
        root.addOrReplaceChild("armLeft3", CubeListBuilder.create().texOffs(91, 16).addBox(-24.0F, -27.0F, -2.0F, 4.0F, 12.0F, 4.0F, cubedef).mirror(false), PartPose.offset(0.0F, 24.0F, 0.0F));

        root.addOrReplaceChild("armRight1", CubeListBuilder.create().texOffs(110, 16).addBox(6.0F, -21.0F, -2.0F, 4.0F, 12.0F, 4.0F, cubedef).mirror(false), PartPose.offset(0.0F, 24.0F, 0.0F));
        root.addOrReplaceChild("armRight2", CubeListBuilder.create().texOffs(71, 16).addBox(13.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, cubedef).mirror(false), PartPose.offset(0.0F, 24.0F, 0.0F));
        root.addOrReplaceChild("armRight3", CubeListBuilder.create().texOffs(91, 16).addBox(20.0F, -27.0F, -2.0F, 4.0F, 12.0F, 4.0F, cubedef).mirror(false), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 32);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);
        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;

        this.rightleg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leftleg.xRot = Mth.cos(limbSwing * 0.6662F + Mth.PI) * 1.4F * limbSwingAmount;
        this.armRight1.xRot = 0.0F;
        this.armRight2.xRot = 0.0F;
        this.armRight3.xRot = 0.0F;

        this.armLeft1.xRot = 0.0F;
        this.armLeft2.xRot = 0.0F;
        this.armLeft3.xRot = 0.0F;
    }
}