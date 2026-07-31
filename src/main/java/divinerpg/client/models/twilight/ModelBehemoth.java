package divinerpg.client.models.twilight;

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


public class ModelBehemoth<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("behemoth");
    public final ModelPart body;
    public final ModelPart part5R1;
    public final ModelPart part8R1;
    public final ModelPart tail;
    public final ModelPart legL1;
    public final ModelPart legL1R1;
    public final ModelPart legL2;
    public final ModelPart legL2R1;
    public final ModelPart legL3;
    public final ModelPart legL3R1;
    public final ModelPart legL4;
    public final ModelPart legL4R1;
    public final ModelPart legR1;
    public final ModelPart legR1R1;
    public final ModelPart legR2;
    public final ModelPart legR2R1;
    public final ModelPart legR3;
    public final ModelPart legR3R1;
    public final ModelPart legR4;
    public final ModelPart legR4R1;

    public ModelBehemoth(ModelPart root) {
        super(root);
        ModelPart rootPart = root.getChild("root");
        this.body = rootPart.getChild("body");
        this.part5R1 = this.body.getChild("Part5_r1");
        this.part8R1 = this.body.getChild("Part8_r1");
        this.tail = rootPart.getChild("tail");
        this.legL1 = rootPart.getChild("LegL1");
        this.legL1R1 = this.legL1.getChild("LegLlimbSwingAmount_r1");
        this.legL2 = rootPart.getChild("LegL2");
        this.legL2R1 = this.legL2.getChild("LegLF2_r1");
        this.legL3 = rootPart.getChild("LegL3");
        this.legL3R1 = this.legL3.getChild("LegL5_r1");
        this.legL4 = rootPart.getChild("LegL4");
        this.legL4R1 = this.legL4.getChild("LegL6_r1");
        this.legR1 = rootPart.getChild("LegR1");
        this.legR1R1 = this.legR1.getChild("LegRlimbSwingAmount0_r1");
        this.legR2 = rootPart.getChild("LegR2");
        this.legR2R1 = this.legR2.getChild("LegRF9_r1");
        this.legR3 = rootPart.getChild("LegR3");
        this.legR3R1 = this.legR3.getChild("LegR10_r1");
        this.legR4 = rootPart.getChild("LegR4");
        this.legR4R1 = this.legR4.getChild("LegR9_r1");
    }

    public ModelBehemoth(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.ZERO);

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).mirror().addBox(-3.0F, -3.0F, -2.0F, 14.0F, 14.0F, 8.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(46, 17).mirror().addBox(-2.5F, 0.0F, 24.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(46, 17).mirror().addBox(6.5F, 0.0F, 24.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-4.0F, 9.0F, -7.0F));

        body.addOrReplaceChild("Part5_r1", CubeListBuilder.create()
                .texOffs(0, 0).mirror().addBox(-1.0F, -12.0F, -11.0F, 2.0F, 6.0F, 2.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(0, 0).mirror().addBox(-1.0F, -24.0F, -11.0F, 2.0F, 6.0F, 2.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(0, 0).mirror().addBox(-1.0F, -27.0F, -6.0F, 2.0F, 6.0F, 2.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(0, 0).mirror().addBox(-1.0F, -18.0F, -11.0F, 2.0F, 6.0F, 2.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(0, 0).mirror().addBox(-1.0F, -21.0F, -6.0F, 2.0F, 6.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(4.0F, 15.0F, 7.0F, -0.7854F, 0.0F, 0.0F));

        body.addOrReplaceChild("Part8_r1", CubeListBuilder.create()
                .texOffs(44, 0).mirror().addBox(-6.0F, -8.0F, -17.0F, 5.0F, 9.0F, 5.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(44, 0).mirror().addBox(1.0F, -17.0F, -17.0F, 5.0F, 9.0F, 5.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(44, 0).mirror().addBox(1.0F, -17.0F, -10.0F, 5.0F, 9.0F, 5.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(44, 0).mirror().addBox(1.0F, -8.0F, -10.0F, 5.0F, 9.0F, 5.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(44, 0).mirror().addBox(1.0F, -8.0F, -17.0F, 5.0F, 9.0F, 5.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(20, 22).mirror().addBox(-2.5F, -21.0F, -14.0F, 5.0F, 4.0F, 6.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(44, 0).mirror().addBox(-6.0F, -8.0F, -10.0F, 5.0F, 9.0F, 5.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(44, 0).mirror().addBox(-6.0F, -17.0F, -10.0F, 5.0F, 9.0F, 5.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(44, 0).mirror().addBox(-6.0F, -17.0F, -17.0F, 5.0F, 9.0F, 5.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(4.0F, 15.0F, 7.0F, -1.5708F, 0.0F, 0.0F));

        PartDefinition tail = root.addOrReplaceChild("tail", CubeListBuilder.create()
                .texOffs(46, 18).mirror().addBox(-1.0F, 5.0F, -1.5F, 3.0F, 11.0F, 3.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(9, 22).mirror().addBox(-0.5F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-0.5F, 12.0F, 20.0F, 1.1301F, 0.0F, 0.0F));

        PartDefinition LegL1 = root.addOrReplaceChild("LegL1", CubeListBuilder.create()
                .texOffs(0, 22).mirror().addBox(-8.0F, 3.0F, -1.0F, 2.0F, 8.0F, 2.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(46, 17).mirror().addBox(-9.0F, 5.0F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(0, 2).mirror().addBox(-8.0F, 11.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(50, 15).mirror().addBox(-8.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(5.0F, 11.0F, 1.0F, 0.0F, -3.1416F, 0.0F));

        LegL1.addOrReplaceChild("LegLlimbSwingAmount_r1", CubeListBuilder.create()
                .texOffs(0, 20).mirror().addBox(-6.4F, -14.0F, 10.0F, 2.0F, 10.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-5.0F, 13.0F, -11.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition LegL2 = root.addOrReplaceChild("LegL2", CubeListBuilder.create()
                .texOffs(46, 17).mirror().addBox(-9.0F, 5.0F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(0, 22).mirror().addBox(-8.0F, 3.0F, -1.0F, 2.0F, 8.0F, 2.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(0, 2).mirror().addBox(-8.0F, 11.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(50, 15).mirror().addBox(-8.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(5.0F, 11.0F, 6.0F, 0.0F, -3.1416F, 0.0F));

        LegL2.addOrReplaceChild("LegLF2_r1", CubeListBuilder.create()
                .texOffs(0, 20).mirror().addBox(-6.4F, -14.0F, 5.0F, 2.0F, 10.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-5.0F, 13.0F, -6.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition LegL3 = root.addOrReplaceChild("LegL3", CubeListBuilder.create()
                .texOffs(0, 22).mirror().addBox(-8.0F, 3.0F, -1.0F, 2.0F, 8.0F, 2.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(0, 2).mirror().addBox(-8.0F, 11.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(46, 17).mirror().addBox(-9.0F, 5.0F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(50, 15).mirror().addBox(-8.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(5.0F, 11.0F, 14.0F, 0.0F, -3.1416F, 0.0F));

        LegL3.addOrReplaceChild("LegL5_r1", CubeListBuilder.create()
                .texOffs(0, 20).mirror().addBox(-6.4F, -14.0F, 23.0F, 2.0F, 10.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-5.0F, 13.0F, -24.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition LegL4 = root.addOrReplaceChild("LegL4", CubeListBuilder.create()
                .texOffs(0, 22).mirror().addBox(-8.0F, 3.0F, -1.0F, 2.0F, 8.0F, 2.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(46, 17).mirror().addBox(-9.0F, 5.0F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(50, 15).mirror().addBox(-8.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(0, 2).mirror().addBox(-8.0F, 11.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(5.0F, 11.0F, 19.0F, 0.0F, -3.1416F, 0.0F));

        LegL4.addOrReplaceChild("LegL6_r1", CubeListBuilder.create()
                .texOffs(0, 20).mirror().addBox(-6.4F, -14.0F, 18.0F, 2.0F, 10.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-5.0F, 13.0F, -19.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition LegR1 = root.addOrReplaceChild("LegR1", CubeListBuilder.create()
                .texOffs(46, 17).mirror().addBox(-9.0F, 5.0F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(0, 22).mirror().addBox(-8.0F, 3.0F, -1.0F, 2.0F, 8.0F, 2.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(0, 2).mirror().addBox(-8.0F, 11.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(50, 15).mirror().addBox(-8.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-6.0F, 11.0F, 1.0F));

        LegR1.addOrReplaceChild("LegRlimbSwingAmount0_r1", CubeListBuilder.create()
                .texOffs(0, 20).mirror().addBox(-14.2F, -6.0F, 0.0F, 2.0F, 10.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(6.0F, 13.0F, -1.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition LegR2 = root.addOrReplaceChild("LegR2", CubeListBuilder.create()
                .texOffs(46, 17).mirror().addBox(-9.0F, 5.0F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(0, 22).mirror().addBox(-8.0F, 3.0F, -1.0F, 2.0F, 8.0F, 2.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(0, 2).mirror().addBox(-8.0F, 11.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(50, 15).mirror().addBox(-8.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-6.0F, 11.0F, 6.0F));

        LegR2.addOrReplaceChild("LegRF9_r1", CubeListBuilder.create()
                .texOffs(0, 20).mirror().addBox(-14.2F, -6.0F, 5.0F, 2.0F, 10.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(6.0F, 13.0F, -6.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition LegR3 = root.addOrReplaceChild("LegR3", CubeListBuilder.create()
                .texOffs(46, 17).mirror().addBox(-9.0F, 5.0F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(0, 22).mirror().addBox(-8.0F, 3.0F, -1.0F, 2.0F, 8.0F, 2.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(50, 15).mirror().addBox(-8.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(0, 2).mirror().addBox(-8.0F, 11.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-6.0F, 11.0F, 14.0F));

        LegR3.addOrReplaceChild("LegR10_r1", CubeListBuilder.create()
                .texOffs(0, 20).mirror().addBox(-14.2F, -6.0F, 13.0F, 2.0F, 10.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(6.0F, 13.0F, -14.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition LegR4 = root.addOrReplaceChild("LegR4", CubeListBuilder.create()
                .texOffs(46, 17).mirror().addBox(-9.0F, 5.0F, 3.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(0, 22).mirror().addBox(-8.0F, 3.0F, 4.0F, 2.0F, 8.0F, 2.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(0, 2).mirror().addBox(-8.0F, 11.0F, 4.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(50, 15).mirror().addBox(-8.0F, 1.0F, 4.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-6.0F, 11.0F, 14.0F));

        LegR4.addOrReplaceChild("LegR9_r1", CubeListBuilder.create()
                .texOffs(0, 20).mirror().addBox(-14.2F, -6.0F, 18.0F, 2.0F, 10.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(6.0F, 13.0F, -14.0F, 0.0F, 0.0F, 0.7854F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;
        float ageInTicks = state.ageInTicks;

        this.tail.xRot = Mth.cos(ageInTicks * 0.1F) * (float) Math.PI * 0.05F + 1.092891F;

        float f = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

        this.legL3.xRot = f;
        this.legL4.xRot = f;
        this.legR1.xRot = f;
        this.legR2.xRot = f;

        float inverseF = -this.legR2.xRot;
        this.legL1.xRot = inverseF;
        this.legL2.xRot = inverseF;
        this.legR3.xRot = inverseF;
        this.legR4.xRot = inverseF;
    }
}