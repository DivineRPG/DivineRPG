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

public class ModelAyeraco<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("ayeraco");
    private final ModelPart head;
    private final ModelPart tail;
    private final ModelPart wingLB;
    private final ModelPart tail2;
    private final ModelPart tail3;
    private final ModelPart wingRB;
    private final ModelPart wingRF;
    private final ModelPart wingLF;
    private final ModelPart wingRM;
    private final ModelPart wingLM;
    private final ModelPart head2;
    private final ModelPart body;
    private final ModelPart shape2;
    private final ModelPart shape3;
    private final ModelPart shape5;
    private final ModelPart shape7;
    private final ModelPart shape9;
    private final ModelPart shape11;
    private final ModelPart shape13;

    public ModelAyeraco(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public ModelAyeraco(ModelPart root) {
        super(root);
        ModelPart rootPart = root.getChild("root");
        this.head = rootPart.getChild("Head");
        this.tail = rootPart.getChild("Tail");
        this.wingLB = rootPart.getChild("WingLB");
        this.tail2 = rootPart.getChild("Tail2");
        this.tail3 = rootPart.getChild("Tail3");
        this.wingRB = rootPart.getChild("WingRB");
        this.wingRF = rootPart.getChild("WingRF");
        this.wingLF = rootPart.getChild("WingLF");
        this.wingRM = rootPart.getChild("WingRM");
        this.wingLM = rootPart.getChild("WingLM");
        this.head2 = rootPart.getChild("Head2");
        this.body = rootPart.getChild("Body");
        this.shape2 = rootPart.getChild("Shape2");
        this.shape3 = rootPart.getChild("Shape3");
        this.shape5 = rootPart.getChild("Shape5");
        this.shape7 = rootPart.getChild("Shape7");
        this.shape9 = rootPart.getChild("Shape9");
        this.shape11 = rootPart.getChild("Shape11");
        this.shape13 = rootPart.getChild("Shape13");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.ZERO);
        CubeDeformation cubedef = new CubeDeformation(0.0F);

        PartDefinition head = root.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(0.0F, -1.0F, 0.0F, 6.0F, 6.0F, 7.0F, cubedef).mirror(false), PartPose.offset(3.0F, 12.0F, -17.0F));

        head.addOrReplaceChild("Mouth1_r1", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(-3.0F, 0.0F, -7.0F, 6.0F, 1.0F, 7.0F, cubedef).mirror(false), PartPose.offsetAndRotation(3.0F, 5.0F, 7.0F, 0.0873F, 0.0F, 0.0F));

        root.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 10.0F, cubedef).mirror(false), PartPose.offset(3.0F, 14.0F, 14.0F));

        root.addOrReplaceChild("WingLB", CubeListBuilder.create().texOffs(28, 27).mirror().addBox(0.0F, 0.0F, 2.0F, 8.0F, 1.0F, 4.0F, cubedef).mirror(false)
                .texOffs(28, 27).mirror().addBox(8.0F, 0.0F, 3.0F, 8.0F, 1.0F, 2.0F, cubedef).mirror(false), PartPose.offset(5.0F, 13.0F, 1.0F));

        root.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 10.0F, cubedef).mirror(false), PartPose.offset(0.0F, 14.0F, 14.0F));

        root.addOrReplaceChild("Tail3", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 10.0F, cubedef).mirror(false), PartPose.offset(-3.0F, 14.0F, 14.0F));

        root.addOrReplaceChild("WingRB", CubeListBuilder.create().texOffs(28, 27).mirror().addBox(-7.0F, 0.0F, 2.0F, 8.0F, 1.0F, 4.0F, cubedef).mirror(false)
                .texOffs(28, 27).mirror().addBox(-15.0F, 0.0F, 3.0F, 8.0F, 1.0F, 2.0F, cubedef).mirror(false), PartPose.offset(-6.0F, 13.0F, 1.0F));

        root.addOrReplaceChild("WingRF", CubeListBuilder.create().texOffs(28, 27).mirror().addBox(-7.0F, 0.0F, -2.0F, 8.0F, 1.0F, 4.0F, cubedef).mirror(false)
                .texOffs(28, 27).mirror().addBox(-15.0F, 0.0F, -1.0F, 8.0F, 1.0F, 2.0F, cubedef).mirror(false), PartPose.offset(-6.0F, 13.0F, -3.0F));

        root.addOrReplaceChild("WingLF", CubeListBuilder.create().texOffs(28, 27).mirror().addBox(0.0F, 0.0F, -2.0F, 8.0F, 1.0F, 4.0F, cubedef).mirror(false)
                .texOffs(28, 27).mirror().addBox(8.0F, 0.0F, -1.0F, 8.0F, 1.0F, 2.0F, cubedef).mirror(false), PartPose.offset(5.0F, 13.0F, -3.0F));

        root.addOrReplaceChild("WingRM", CubeListBuilder.create().texOffs(28, 27).mirror().addBox(-7.0F, 0.0F, 2.0F, 8.0F, 1.0F, 4.0F, cubedef).mirror(false)
                .texOffs(28, 27).mirror().addBox(-15.0F, 0.0F, 3.0F, 8.0F, 1.0F, 2.0F, cubedef).mirror(false), PartPose.offset(-6.0F, 13.0F, -3.0F));

        root.addOrReplaceChild("WingLM", CubeListBuilder.create().texOffs(28, 27).mirror().addBox(0.0F, 0.0F, 2.0F, 8.0F, 1.0F, 4.0F, cubedef).mirror(false)
                .texOffs(28, 27).mirror().addBox(8.0F, 0.0F, 3.0F, 8.0F, 1.0F, 2.0F, cubedef).mirror(false), PartPose.offset(5.0F, 13.0F, -3.0F));

        PartDefinition head2 = root.addOrReplaceChild("Head2", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(0.0F, -1.0F, 0.0F, 6.0F, 6.0F, 7.0F, cubedef).mirror(false), PartPose.offset(-9.0F, 12.0F, -17.0F));

        head2.addOrReplaceChild("Mouth2_r1", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(-3.0F, 0.0F, -7.0F, 6.0F, 1.0F, 7.0F, cubedef).mirror(false), PartPose.offsetAndRotation(3.0F, 5.0F, 7.0F, 0.0873F, 0.0F, 0.0F));

        root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, -1.0F, 0.0F, 10.0F, 6.0F, 16.0F, cubedef).mirror(false)
                .texOffs(0, 0).mirror().addBox(0.0F, 5.0F, 2.0F, 10.0F, 1.0F, 12.0F, cubedef).mirror(false)
                .texOffs(13, 16).mirror().addBox(-1.0F, 0.0F, -2.0F, 12.0F, 4.0F, 2.0F, cubedef).mirror(false)
                .texOffs(10, 12).mirror().addBox(0.0F, 0.0F, 16.0F, 10.0F, 4.0F, 6.0F, cubedef).mirror(false), PartPose.offset(-5.0F, 12.0F, -8.0F));

        PartDefinition shape2 = root.addOrReplaceChild("Shape2", CubeListBuilder.create().texOffs(44, 20).mirror().addBox(0.0F, -1.0F, 0.0F, 4.0F, 1.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-2.0F, 13.0F, 10.0F, 0.7808F, 0.0F, 0.0F));

        shape2.addOrReplaceChild("Shape1_r1", CubeListBuilder.create().texOffs(44, 20).mirror().addBox(-2.0F, -7.0F, 5.0F, 4.0F, 1.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(2.0F, 4.0F, -1.0F, -0.3491F, 0.0F, 0.0F));

        PartDefinition shape3 = root.addOrReplaceChild("Shape3", CubeListBuilder.create().texOffs(46, 20).mirror().addBox(0.0F, -1.0F, 0.0F, 2.0F, 1.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(5.0F, 12.0F, -16.0F, 0.7808F, 0.0F, 0.0F));

        shape3.addOrReplaceChild("Shape4_r1", CubeListBuilder.create().texOffs(46, 20).mirror().addBox(5.0F, -5.0F, -1.0F, 2.0F, 1.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-5.0F, 4.0F, 5.0F, -0.3927F, 0.0F, 0.0F));

        PartDefinition shape5 = root.addOrReplaceChild("Shape5", CubeListBuilder.create().texOffs(44, 20).mirror().addBox(0.0F, -1.0F, 0.0F, 4.0F, 1.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-2.0F, 12.0F, -2.0F, 0.7808F, 0.0F, 0.0F));

        shape5.addOrReplaceChild("Shape6_r1", CubeListBuilder.create().texOffs(44, 20).mirror().addBox(-2.0F, -5.0F, 2.5F, 4.0F, 1.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(2.0F, 3.0F, 2.0F, -0.3054F, 0.0F, 0.0F));

        PartDefinition shape7 = root.addOrReplaceChild("Shape7", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.0F, 12.0F, 3.0F, 0.7808F, 0.0F, 0.0F));

        shape7.addOrReplaceChild("Shape8_r1", CubeListBuilder.create().texOffs(44, 20).mirror().addBox(-2.0F, -15.3F, 4.0F, 4.0F, 1.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(2.0F, 12.0F, -3.0F, -0.3054F, 0.0F, 0.0F));

        shape7.addOrReplaceChild("Shape7_r1", CubeListBuilder.create().texOffs(44, 20).mirror().addBox(-2.0F, -13.0F, 3.0F, 4.0F, 1.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(2.0F, 12.0F, -3.0F, 0.0436F, 0.0F, 0.0F));

        PartDefinition shape9 = root.addOrReplaceChild("Shape9", CubeListBuilder.create().texOffs(44, 20).mirror().addBox(0.0F, -1.0F, 0.0F, 4.0F, 1.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-2.0F, 12.0F, 7.0F, 0.7808F, 0.0F, 0.0F));

        shape9.addOrReplaceChild("Shape10_r1", CubeListBuilder.create().texOffs(44, 20).mirror().addBox(-2.0F, -9.3F, 6.4F, 4.0F, 1.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(2.0F, 6.0F, -3.0F, -0.3054F, 0.0F, 0.0F));

        PartDefinition shape11 = root.addOrReplaceChild("Shape11", CubeListBuilder.create().texOffs(44, 20).mirror().addBox(0.0F, -1.0F, 0.0F, 4.0F, 1.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-2.0F, 12.0F, -7.0F, 0.7808F, 0.0F, 0.0F));

        shape11.addOrReplaceChild("Shape12_r1", CubeListBuilder.create().texOffs(44, 20).mirror().addBox(-2.0F, -7.0F, -1.0F, 4.0F, 1.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(2.0F, 6.0F, 5.0F, -0.2618F, 0.0F, 0.0F));

        PartDefinition shape13 = root.addOrReplaceChild("Shape13", CubeListBuilder.create().texOffs(46, 20).mirror().addBox(0.0F, -1.0F, 0.0F, 2.0F, 1.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-7.0F, 12.0F, -16.0F, 0.7808F, 0.0F, 0.0F));

        shape13.addOrReplaceChild("Shape14_r1", CubeListBuilder.create().texOffs(46, 20).mirror().addBox(-7.0F, -8.2F, -14.1F, 2.0F, 1.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(7.0F, 12.0F, 16.0F, -0.3927F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);
        float ageInTicks = state.ageInTicks;

        this.wingRF.zRot = this.wingRM.zRot = this.wingRB.zRot = Mth.cos(ageInTicks * 0.1F) * Mth.PI * 0.15F;

        this.wingLF.zRot = -this.wingRF.zRot;
        this.wingLM.zRot = -this.wingRF.zRot;
        this.wingLB.zRot = -this.wingRF.zRot;

        this.tail.xRot = this.tail3.xRot = -Mth.cos(ageInTicks * 0.1F) * Mth.PI * 0.15F;
        this.tail2.xRot = Mth.sin(ageInTicks * 0.1F) * Mth.PI * 0.15F;

        this.shape2.yRot = Mth.cos(ageInTicks * 0.1F) * Mth.PI * 0.05F;
        this.shape5.yRot = this.shape2.yRot;
        this.shape7.yRot = this.shape2.yRot;
        this.shape9.yRot = this.shape2.yRot;
        this.shape11.yRot = this.shape2.yRot;
        this.shape3.yRot = this.head.yRot + this.shape2.yRot;
        this.shape3.xRot = this.head.xRot;
        this.shape13.xRot = this.head.xRot;
        this.shape13.yRot = this.head.yRot + this.shape2.yRot;
    }
}