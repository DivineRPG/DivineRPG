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

public class ModelQuadro<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("quadro");
    private final ModelPart rightleg;
    private final ModelPart leftleg;
    private final ModelPart body1;
    private final ModelPart body2;
    private final ModelPart body3;
    private final ModelPart body4;

    public ModelQuadro(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public ModelQuadro(ModelPart root) {
        super(root);
        ModelPart rootPart = root.getChild("root");
        this.rightleg = rootPart.getChild("rightleg");
        this.leftleg = rootPart.getChild("leftleg");
        this.body1 = rootPart.getChild("body1");
        this.body2 = rootPart.getChild("body2");
        this.body3 = rootPart.getChild("body3");
        this.body4 = rootPart.getChild("body4");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.ZERO);
        CubeDeformation cubedef = new CubeDeformation(0.0F);

        root.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(101, 16).mirror().addBox(-4.0F, -4.0F, -3.0F, 6.0F, 4.0F, 6.0F, cubedef).mirror(false)
                .texOffs(0, 16).mirror().addBox(-3.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, cubedef).mirror(false)
                .texOffs(19, 17).mirror().addBox(-5.0F, 9.0F, -10.0F, 2.0F, 3.0F, 12.0F, cubedef).mirror(false)
                .texOffs(19, 17).mirror().addBox(1.0F, 9.0F, -10.0F, 2.0F, 3.0F, 12.0F, cubedef).mirror(false), PartPose.offset(-7.0F, 12.0F, 0.0F));

        root.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(101, 16).mirror().addBox(-3.0F, -4.0F, -3.0F, 6.0F, 4.0F, 6.0F, cubedef).mirror(false)
                .texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, cubedef).mirror(false)
                .texOffs(19, 17).mirror().addBox(2.0F, 9.0F, -10.0F, 2.0F, 3.0F, 12.0F, cubedef).mirror(false)
                .texOffs(19, 17).mirror().addBox(-4.0F, 9.0F, -10.0F, 2.0F, 3.0F, 12.0F, cubedef).mirror(false), PartPose.offset(8.0F, 12.0F, 0.0F));

        PartDefinition body1 = root.addOrReplaceChild("body1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

        body1.addOrReplaceChild("rotated45_r1", CubeListBuilder.create().texOffs(86, 2).mirror().addBox(-5.0F, -16.0F, -8.0F, 10.0F, 4.0F, 8.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 11.9696F, 0.3473F, 0.1309F, 0.0F, 0.0F));

        body1.addOrReplaceChild("rotated56_r1", CubeListBuilder.create().texOffs(55, 22).mirror().addBox(6.0F, -17.0F, -21.0F, 2.0F, 2.0F, 8.0F, cubedef).mirror(false)
                .texOffs(55, 22).mirror().addBox(-8.0F, -17.0F, -21.0F, 2.0F, 2.0F, 8.0F, cubedef).mirror(false)
                .texOffs(82, 16).mirror().addBox(-9.0F, -27.0F, -13.0F, 4.0F, 12.0F, 4.0F, cubedef).mirror(false)
                .texOffs(82, 16).mirror().addBox(5.0F, -27.0F, -13.0F, 4.0F, 12.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 13.9696F, 0.3473F, 0.0524F, 0.0F, 0.0F));

        body1.addOrReplaceChild("rotated27_r1", CubeListBuilder.create().texOffs(61, 28).mirror().addBox(-25.0F, -19.0F, -5.0F, 6.0F, 2.0F, 2.0F, cubedef).mirror(false)
                .texOffs(61, 28).mirror().addBox(-25.0F, -15.0F, -5.0F, 6.0F, 2.0F, 2.0F, cubedef).mirror(false)
                .texOffs(58, 24).mirror().addBox(-21.0F, -17.0F, -6.0F, 2.0F, 2.0F, 6.0F, cubedef).mirror(false)
                .texOffs(61, 28).mirror().addBox(-25.0F, -19.0F, 4.0F, 6.0F, 2.0F, 2.0F, cubedef).mirror(false)
                .texOffs(61, 28).mirror().addBox(-25.0F, -15.0F, 4.0F, 6.0F, 2.0F, 2.0F, cubedef).mirror(false)
                .texOffs(58, 24).mirror().addBox(-21.0F, -17.0F, 0.0F, 2.0F, 2.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 13.9696F, 0.3473F, 1.5708F, -1.5184F, -1.5708F));

        body1.addOrReplaceChild("rotated48_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -37.0F, -10.0F, 8.0F, 8.0F, 8.0F, cubedef).mirror(false)
                .texOffs(34, 0).mirror().addBox(-3.0F, -30.0F, -7.0F, 6.0F, 12.0F, 4.0F, cubedef).mirror(false)
                .texOffs(56, 1).mirror().addBox(-4.0F, -22.0F, -8.0F, 8.0F, 7.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 10.9696F, 4.3473F, 0.4363F, 0.0F, 0.0F));

        body1.addOrReplaceChild("rotated52_r1", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-7.0F, -26.0F, -10.0F, 4.0F, 2.0F, 2.0F, cubedef).mirror(false)
                .texOffs(40, 16).mirror().addBox(3.0F, -26.0F, -10.0F, 4.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 10.9696F, 4.3473F, 0.288F, 0.0F, 0.0F));

        PartDefinition body2 = root.addOrReplaceChild("body2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

        body2.addOrReplaceChild("rotated7_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -37.0F, -11.0F, 8.0F, 8.0F, 8.0F, cubedef).mirror(false)
                .texOffs(34, 0).mirror().addBox(-3.0F, -30.0F, -8.0F, 6.0F, 12.0F, 4.0F, cubedef).mirror(false)
                .texOffs(56, 1).mirror().addBox(-4.0F, -22.0F, -9.0F, 8.0F, 7.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, -1.0F, 0.0436F, 0.0F, 0.0F));

        body2.addOrReplaceChild("rotated1_r1", CubeListBuilder.create().texOffs(82, 16).mirror().addBox(5.0F, -23.0F, -18.0F, 4.0F, 12.0F, 4.0F, cubedef).mirror(false)
                .texOffs(55, 22).mirror().addBox(6.0F, -14.0F, -25.0F, 2.0F, 2.0F, 8.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, -1.0F, -0.3491F, 0.0F, 0.0F));

        body2.addOrReplaceChild("rotated53_r1", CubeListBuilder.create().texOffs(55, 22).mirror().addBox(-8.0F, -14.0F, -25.6F, 2.0F, 2.0F, 8.0F, cubedef).mirror(false)
                .texOffs(82, 16).mirror().addBox(-9.0F, -23.0F, -18.6F, 4.0F, 12.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 11.7F, -1.0F, -0.3491F, 0.0F, 0.0F));

        body2.addOrReplaceChild("rotated49_r1", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-7.0F, -25.5F, -11.25F, 4.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 11.7F, -1.0F, -0.096F, 0.0F, 0.0F));

        body2.addOrReplaceChild("rotated50_r1", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(3.0F, -26.0F, -11.0F, 4.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, -1.0F, -0.0785F, 0.0F, 0.0F));

        body2.addOrReplaceChild("rotated14_r1", CubeListBuilder.create().texOffs(86, 2).mirror().addBox(-5.0F, -15.9F, -10.0F, 10.0F, 4.0F, 8.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

        PartDefinition body3 = root.addOrReplaceChild("body3", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-7.0F, -15.0F, -7.7F, 4.0F, 2.0F, 2.0F, cubedef).mirror(false)
                .texOffs(56, 1).mirror().addBox(-4.0F, -10.0F, -9.0F, 8.0F, 7.0F, 6.0F, cubedef).mirror(false)
                .texOffs(34, 0).mirror().addBox(-3.0F, -18.0F, -8.0F, 6.0F, 12.0F, 4.0F, cubedef).mirror(false)
                .texOffs(0, 0).mirror().addBox(-4.0F, -25.0F, -11.0F, 8.0F, 8.0F, 8.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

        body3.addOrReplaceChild("rotated34_r1", CubeListBuilder.create().texOffs(61, 28).mirror().addBox(-29.0F, -13.5F, -2.0F, 6.0F, 2.0F, 2.0F, cubedef).mirror(false)
                .texOffs(61, 28).mirror().addBox(-29.0F, -13.5F, 0.0F, 6.0F, 2.0F, 2.0F, cubedef).mirror(false)
                .texOffs(61, 28).mirror().addBox(-29.0F, -11.5F, 0.0F, 6.0F, 2.0F, 2.0F, cubedef).mirror(false)
                .texOffs(61, 28).mirror().addBox(-29.0F, -11.5F, -2.0F, 6.0F, 2.0F, 2.0F, cubedef).mirror(false)
                .texOffs(61, 28).mirror().addBox(-29.0F, -19.5F, -2.0F, 6.0F, 2.0F, 2.0F, cubedef).mirror(false)
                .texOffs(61, 28).mirror().addBox(-29.0F, -19.5F, 0.0F, 6.0F, 2.0F, 2.0F, cubedef).mirror(false)
                .texOffs(61, 28).mirror().addBox(-29.0F, -17.5F, 0.0F, 6.0F, 2.0F, 2.0F, cubedef).mirror(false)
                .texOffs(61, 28).mirror().addBox(-29.0F, -17.5F, -2.0F, 6.0F, 2.0F, 2.0F, cubedef).mirror(false)
                .texOffs(59, 26).mirror().addBox(-25.0F, -15.5F, -4.0F, 2.0F, 2.0F, 4.0F, cubedef).mirror(false)
                .texOffs(59, 26).mirror().addBox(-25.0F, -15.5F, 0.0F, 2.0F, 2.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, -1.5708F, -1.2305F, 1.5708F));

        body3.addOrReplaceChild("rotated12_r1", CubeListBuilder.create().texOffs(55, 22).mirror().addBox(8.0F, -14.9F, -24.0F, 2.0F, 2.0F, 8.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, -0.3715F, 0.1639F, -0.0602F));

        body3.addOrReplaceChild("rotated19_r1", CubeListBuilder.create().texOffs(55, 22).mirror().addBox(-10.0F, -14.9F, -24.0F, 2.0F, 2.0F, 8.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, -0.3711F, -0.158F, 0.0766F));

        body3.addOrReplaceChild("rotated39_r1", CubeListBuilder.create().texOffs(82, 16).mirror().addBox(5.0F, -24.0F, -17.0F, 4.0F, 12.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

        body3.addOrReplaceChild("rotated37_r1", CubeListBuilder.create().texOffs(82, 16).mirror().addBox(-8.8F, -24.0F, -18.0F, 4.0F, 12.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, -0.349F, 0.006F, 0.0164F));

        body3.addOrReplaceChild("rotated42_r1", CubeListBuilder.create().texOffs(86, 2).mirror().addBox(-5.0F, -16.0F, -11.0F, 10.0F, 4.0F, 8.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

        body3.addOrReplaceChild("rotated5_r1", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(3.0F, -26.8F, -8.3F, 4.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, -0.0436F, 0.0F, 0.0F));

        PartDefinition body4 = root.addOrReplaceChild("body4", CubeListBuilder.create().texOffs(82, 16).mirror().addBox(-8.4F, -13.4415F, -15.8112F, 4.0F, 12.0F, 4.0F, cubedef).mirror(false)
                .texOffs(82, 16).mirror().addBox(5.4F, -13.4415F, -15.8112F, 4.0F, 12.0F, 4.0F, cubedef).mirror(false)
                .texOffs(55, 22).mirror().addBox(-7.0F, -4.4415F, -21.8112F, 2.0F, 2.0F, 8.0F, cubedef).mirror(false)
                .texOffs(55, 22).mirror().addBox(-7.0F, -4.4415F, -29.8112F, 2.0F, 2.0F, 8.0F, cubedef).mirror(false)
                .texOffs(55, 22).mirror().addBox(-7.0F, -4.4415F, -37.8112F, 2.0F, 2.0F, 8.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

        body4.addOrReplaceChild("rotated8_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.9F, -36.0F, -9.0F, 8.0F, 8.0F, 8.0F, cubedef).mirror(false)
                .texOffs(34, 0).mirror().addBox(-3.9F, -29.0F, -6.0F, 6.0F, 12.0F, 4.0F, cubedef).mirror(false)
                .texOffs(56, 1).mirror().addBox(-4.9F, -21.0F, -7.0F, 8.0F, 7.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(1.0F, 12.1585F, -0.8112F, 0.3142F, 0.0F, 0.0F));

        body4.addOrReplaceChild("rotated10_r1", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-7.0F, -25.0F, -12.0F, 4.0F, 2.0F, 2.0F, cubedef).mirror(false)
                .texOffs(40, 16).mirror().addBox(2.0F, -25.0F, -12.0F, 4.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(1.0F, 12.1585F, -0.8112F, 0.0524F, 0.0F, 0.0F));

        body4.addOrReplaceChild("rotated18_r1", CubeListBuilder.create().texOffs(86, 2).mirror().addBox(-6.0F, -15.9F, -5.1F, 10.0F, 4.0F, 8.0F, cubedef).mirror(false), PartPose.offsetAndRotation(1.0F, 12.1585F, -0.8112F, 0.1745F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 32);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;

        this.leftleg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.rightleg.xRot = Mth.cos(limbSwing * 0.6662F + Mth.PI) * 1.4F * limbSwingAmount;

        int ageInSeconds = (int) (limbSwingAmount / 20.0F);
        float rotate = 0.0F;

        if (ageInSeconds % 4 == 0) {
            rotate = 0.05F;
        }

        if (ageInSeconds % 16 == 0) {
            this.body1.yRot = 0.0F;
            this.body2.yRot = -1.5708F;
            this.body3.yRot = -3.1416F;
            this.body4.yRot = 1.5708F;
        } else {
            this.body1.yRot += rotate;
            this.body2.yRot += rotate;
            this.body3.yRot += rotate;
            this.body4.yRot += rotate;
        }
    }
}