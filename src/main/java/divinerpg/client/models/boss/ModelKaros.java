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

public class ModelKaros<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("karos");

    private final ModelPart head1;
    private final ModelPart body1;
    private final ModelPart rightarm1;
    private final ModelPart leftarm1;
    private final ModelPart head2;
    private final ModelPart rightarm2;
    private final ModelPart leftarm2;
    private final ModelPart body2;
    private final ModelPart body3;
    private final ModelPart body4;
    private final ModelPart body5;
    private final ModelPart body6;
    private final ModelPart body7;
    private final ModelPart body8;
    private final ModelPart body9;
    private final ModelPart body10;
    private final ModelPart body11;
    private final ModelPart body12;
    private final ModelPart body13;
    private final ModelPart body14;
    private final ModelPart body15;
    private final ModelPart body16;
    private final ModelPart body17;
    private final ModelPart body18;
    private final ModelPart body19;
    private final ModelPart body20;
    private final ModelPart body21;
    private final ModelPart body22;
    private final ModelPart body23;

    public ModelKaros(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public ModelKaros(ModelPart root) {
        super(root);
        ModelPart rootPart = root.getChild("root");
        this.head1 = rootPart.getChild("head1");
        this.body1 = rootPart.getChild("body1");
        this.rightarm1 = rootPart.getChild("rightarm1");
        this.leftarm1 = rootPart.getChild("leftarm1");
        this.head2 = rootPart.getChild("head2");
        this.rightarm2 = rootPart.getChild("rightarm2");
        this.leftarm2 = rootPart.getChild("leftarm2");
        this.body2 = rootPart.getChild("body2");
        this.body3 = rootPart.getChild("body3");
        this.body4 = rootPart.getChild("body4");
        this.body5 = rootPart.getChild("body5");
        this.body6 = rootPart.getChild("body6");
        this.body7 = rootPart.getChild("body7");
        this.body8 = rootPart.getChild("body8");
        this.body9 = rootPart.getChild("body9");
        this.body10 = rootPart.getChild("body10");
        this.body11 = rootPart.getChild("body11");
        this.body12 = rootPart.getChild("body12");
        this.body13 = rootPart.getChild("body13");
        this.body14 = rootPart.getChild("body14");
        this.body15 = rootPart.getChild("body15");
        this.body16 = rootPart.getChild("body16");
        this.body17 = rootPart.getChild("body17");
        this.body18 = rootPart.getChild("body18");
        this.body19 = rootPart.getChild("body19");
        this.body20 = rootPart.getChild("body20");
        this.body21 = rootPart.getChild("body21");
        this.body22 = rootPart.getChild("body22");
        this.body23 = rootPart.getChild("body23");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.ZERO);
        CubeDeformation cubedef = new CubeDeformation(0.0F);

        root.addOrReplaceChild("head1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, cubedef).mirror(false), PartPose.offset(8.0F, -11.0F, 0.0F));

        root.addOrReplaceChild("body1", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, cubedef).mirror(false), PartPose.offset(4.0F, -1.0F, 2.0F));

        root.addOrReplaceChild("rightarm1", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-4.0F, -4.0F, -3.0F, 6.0F, 4.0F, 6.0F, cubedef).mirror(false), PartPose.offset(-10.0F, 2.0F, 0.0F));

        root.addOrReplaceChild("leftarm1", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-2.0F, -4.0F, -3.0F, 6.0F, 4.0F, 6.0F, cubedef).mirror(false), PartPose.offset(10.0F, 2.0F, 0.0F));

        root.addOrReplaceChild("head2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, cubedef).mirror(false), PartPose.offset(-8.0F, -11.0F, 0.0F));

        root.addOrReplaceChild("rightarm2", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, cubedef).mirror(false), PartPose.offset(-10.0F, 2.0F, 0.0F));

        root.addOrReplaceChild("leftarm2", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, cubedef).mirror(false), PartPose.offset(10.0F, 2.0F, 0.0F));

        root.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, cubedef).mirror(false), PartPose.offset(0.0F, -7.0F, 2.0F));

        root.addOrReplaceChild("body3", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, cubedef).mirror(false), PartPose.offset(-4.0F, -1.0F, 2.0F));

        root.addOrReplaceChild("body4", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, cubedef).mirror(false), PartPose.offset(-4.0F, -1.0F, -2.0F));

        root.addOrReplaceChild("body5", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, cubedef).mirror(false), PartPose.offset(4.0F, -1.0F, -2.0F));

        root.addOrReplaceChild("body6", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(1.0F, -2.0F, -3.0F, 4.0F, 4.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(6.0F, -6.0F, 1.0F, 0.0F, 0.0F, -0.6109F));

        root.addOrReplaceChild("body7", CubeListBuilder.create().texOffs(27, 0).mirror().addBox(-4.0F, 0.0F, -2.0F, 1.0F, 6.0F, 1.0F, cubedef).mirror(false), PartPose.offset(7.0F, 11.0F, 5.0F));

        root.addOrReplaceChild("body8", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, cubedef).mirror(false), PartPose.offset(0.0F, 5.0F, 2.0F));

        root.addOrReplaceChild("body9", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, cubedef).mirror(false), PartPose.offset(0.0F, 5.0F, -2.0F));

        root.addOrReplaceChild("body10", CubeListBuilder.create().texOffs(27, 0).mirror().addBox(-4.0F, 0.0F, -2.0F, 1.0F, 6.0F, 1.0F, cubedef).mirror(false), PartPose.offset(0.0F, 11.0F, -2.0F));

        root.addOrReplaceChild("body11", CubeListBuilder.create().texOffs(27, 0).mirror().addBox(-4.0F, 0.0F, -2.0F, 1.0F, 6.0F, 1.0F, cubedef).mirror(false), PartPose.offset(2.0F, 11.0F, 3.0F));

        root.addOrReplaceChild("body12", CubeListBuilder.create().texOffs(27, 0).mirror().addBox(-4.0F, 0.0F, -2.0F, 1.0F, 6.0F, 1.0F, cubedef).mirror(false), PartPose.offset(1.0F, 11.0F, 5.0F));

        root.addOrReplaceChild("body13", CubeListBuilder.create().texOffs(27, 0).mirror().addBox(-4.0F, 0.0F, -2.0F, 1.0F, 6.0F, 1.0F, cubedef).mirror(false), PartPose.offset(5.0F, 11.0F, 4.0F));

        root.addOrReplaceChild("body14", CubeListBuilder.create().texOffs(27, 0).mirror().addBox(-4.0F, 0.0F, -2.0F, 1.0F, 6.0F, 1.0F, cubedef).mirror(false), PartPose.offset(6.0F, 11.0F, 0.0F));

        root.addOrReplaceChild("body15", CubeListBuilder.create().texOffs(27, 0).mirror().addBox(-4.0F, 0.0F, -2.0F, 1.0F, 6.0F, 1.0F, cubedef).mirror(false), PartPose.offset(4.0F, 11.0F, 1.0F));

        root.addOrReplaceChild("body16", CubeListBuilder.create().texOffs(27, 0).mirror().addBox(-4.0F, 0.0F, -2.0F, 1.0F, 6.0F, 1.0F, cubedef).mirror(false), PartPose.offset(7.0F, 11.0F, -2.0F));

        root.addOrReplaceChild("body17", CubeListBuilder.create().texOffs(27, 0).mirror().addBox(-4.0F, 0.0F, -2.0F, 1.0F, 6.0F, 1.0F, cubedef).mirror(false), PartPose.offset(3.0F, 11.0F, -1.0F));

        root.addOrReplaceChild("body18", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, cubedef).mirror(false), PartPose.offset(0.0F, -7.0F, -2.0F));

        root.addOrReplaceChild("body19", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-5.0F, -2.0F, -3.0F, 4.0F, 4.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-5.0F, -6.0F, 1.0F, 0.0F, 0.0F, 0.6109F));

        root.addOrReplaceChild("body20", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, -1.0F, -2.0F, 7.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(6.0F, -6.0F, 1.0F, 0.0F, 0.0F, -0.6109F));

        root.addOrReplaceChild("body21", CubeListBuilder.create().texOffs(32, 11).mirror().addBox(-4.0F, -1.0F, -2.0F, 5.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(9.0F, -11.0F, 1.0F, 0.0F, 0.0F, -1.5708F));

        root.addOrReplaceChild("body22", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, -1.0F, -2.0F, 7.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-5.0F, -6.0F, 1.0F, 0.0F, 0.0F, 0.6109F));

        root.addOrReplaceChild("body23", CubeListBuilder.create().texOffs(32, 11).mirror().addBox(-4.0F, -1.0F, -2.0F, 5.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-8.0F, -11.0F, 1.0F, 0.0F, 0.0F, -1.5708F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);
        float armSwing = Mth.cos(state.walkAnimationPos * 0.6662F + (float) Math.PI) * 2.0F * state.walkAnimationSpeed * 0.5F;
        float armSwingReverse = Mth.cos(state.walkAnimationPos * 0.6662F) * 2.0F * state.walkAnimationSpeed * 0.5F;

        this.rightarm1.xRot = armSwing;
        this.rightarm2.xRot = armSwing;

        this.leftarm1.xRot = armSwingReverse;
        this.leftarm2.xRot = armSwingReverse;
    }
}