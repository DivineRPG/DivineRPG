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


public class ModelDemonOfDarkness<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("demon_of_darkness");
    public final ModelPart mainBody;
    public final ModelPart lowerBody;
    public final ModelPart legbottom1;
    public final ModelPart legbottom2;
    public final ModelPart legbottom3;
    public final ModelPart legbottom4;
    public final ModelPart legbottom5;
    public final ModelPart legbottom6;
    public final ModelPart legbottom7;
    public final ModelPart legbottom8;
    public final ModelPart legbottom9;
    public final ModelPart legbottom10;
    public final ModelPart legbottom11;
    public final ModelPart legbottom12;
    public final ModelPart legbottom13;
    public final ModelPart legbottom14;
    public final ModelPart legbottom15;
    public final ModelPart legbottom16;
    public final ModelPart legbottom17;
    public final ModelPart legbottom18;
    public final ModelPart legbottom19;
    public final ModelPart legbottom20;
    public final ModelPart legbottom21;
    public final ModelPart legbottom22;
    public final ModelPart legbottom23;
    public final ModelPart legbottom24;
    public final ModelPart legbottom25;

    public ModelDemonOfDarkness(ModelPart root) {
        super(root);
        ModelPart rootPart = root.getChild("root");
        this.mainBody = rootPart.getChild("Main_Body");
        this.lowerBody = rootPart.getChild("Lower_Body");
        this.legbottom1 = rootPart.getChild("Legbottom1");
        this.legbottom2 = rootPart.getChild("Legbottom2");
        this.legbottom3 = rootPart.getChild("Legbottom3");
        this.legbottom4 = rootPart.getChild("Legbottom4");
        this.legbottom5 = rootPart.getChild("Legbottom5");
        this.legbottom6 = rootPart.getChild("Legbottom6");
        this.legbottom7 = rootPart.getChild("Legbottom7");
        this.legbottom8 = rootPart.getChild("Legbottom8");
        this.legbottom9 = rootPart.getChild("Legbottom9");
        this.legbottom10 = rootPart.getChild("Legbottom10");
        this.legbottom11 = rootPart.getChild("Legbottom11");
        this.legbottom12 = rootPart.getChild("Legbottom12");
        this.legbottom13 = rootPart.getChild("Legbottom13");
        this.legbottom14 = rootPart.getChild("Legbottom14");
        this.legbottom15 = rootPart.getChild("Legbottom15");
        this.legbottom16 = rootPart.getChild("Legbottom16");
        this.legbottom17 = rootPart.getChild("Legbottom17");
        this.legbottom18 = rootPart.getChild("Legbottom18");
        this.legbottom19 = rootPart.getChild("Legbottom19");
        this.legbottom20 = rootPart.getChild("Legbottom20");
        this.legbottom21 = rootPart.getChild("Legbottom21");
        this.legbottom22 = rootPart.getChild("Legbottom22");
        this.legbottom23 = rootPart.getChild("Legbottom23");
        this.legbottom24 = rootPart.getChild("Legbottom24");
        this.legbottom25 = rootPart.getChild("Legbottom25");
    }

    public ModelDemonOfDarkness(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.ZERO);

        root.addOrReplaceChild("Main_Body", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 10.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.0F, 6.0F, 2.0F, 0.0F, 1.5708F, 0.0F));

        root.addOrReplaceChild("Lower_Body", CubeListBuilder.create().texOffs(39, 20).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 9.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        root.addOrReplaceChild("Legbottom1", CubeListBuilder.create().texOffs(14, 5).mirror().addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 8.0F, 0.0F));

        root.addOrReplaceChild("Legbottom2", CubeListBuilder.create().texOffs(14, 5).mirror().addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 8.0F, -7.0F));

        root.addOrReplaceChild("Legbottom3", CubeListBuilder.create().texOffs(14, 18).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 1.0F, -5.0F, -1.5708F, 1.5708F, 0.0F));

        root.addOrReplaceChild("Legbottom4", CubeListBuilder.create().texOffs(14, 18).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 1.0F, 2.0F, -1.5708F, 1.5708F, 0.0F));

        root.addOrReplaceChild("Legbottom5", CubeListBuilder.create().texOffs(14, 18).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 15.0F, -4.0F, -1.5708F, 1.5708F, 0.0F));

        root.addOrReplaceChild("Legbottom6", CubeListBuilder.create().texOffs(14, 18).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 15.0F, -4.0F, -1.5708F, 1.5708F, 0.0F));

        root.addOrReplaceChild("Legbottom7", CubeListBuilder.create().texOffs(14, 18).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 15.0F, 0.0F, -1.5708F, 1.5708F, 0.0F));

        root.addOrReplaceChild("Legbottom8", CubeListBuilder.create().texOffs(14, 18).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 15.0F, 0.0F, -1.5708F, 1.5708F, 0.0F));

        root.addOrReplaceChild("Legbottom9", CubeListBuilder.create().texOffs(14, 18).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 1.0F, 2.0F, -1.5708F, 1.5708F, 0.0F));

        root.addOrReplaceChild("Legbottom10", CubeListBuilder.create().texOffs(14, 18).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 1.0F, -5.0F, -1.5708F, 1.5708F, 0.0F));

        root.addOrReplaceChild("Legbottom11", CubeListBuilder.create().texOffs(14, 18).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 1.0F, -2.0F, -1.5708F, 1.5708F, 0.0F));

        root.addOrReplaceChild("Legbottom12", CubeListBuilder.create().texOffs(14, 18).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 1.0F, -2.0F, -1.5708F, 1.5708F, 0.0F));

        root.addOrReplaceChild("Legbottom13", CubeListBuilder.create().texOffs(14, 5).mirror().addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 8.0F, -4.0F));

        root.addOrReplaceChild("Legbottom14", CubeListBuilder.create().texOffs(14, 18).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 1.0F, -5.0F, -1.5708F, 1.5708F, 0.0F));

        root.addOrReplaceChild("Legbottom15", CubeListBuilder.create().texOffs(14, 18).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 1.0F, -2.0F, -1.5708F, 1.5708F, 0.0F));

        root.addOrReplaceChild("Legbottom16", CubeListBuilder.create().texOffs(14, 18).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 1.0F, 2.0F, -1.5708F, 1.5708F, 0.0F));

        root.addOrReplaceChild("Legbottom17", CubeListBuilder.create().texOffs(14, 5).mirror().addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 5.0F, -7.0F));

        root.addOrReplaceChild("Legbottom18", CubeListBuilder.create().texOffs(14, 5).mirror().addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 5.0F, -4.0F));

        root.addOrReplaceChild("Legbottom19", CubeListBuilder.create().texOffs(14, 5).mirror().addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 5.0F, 0.0F));

        root.addOrReplaceChild("Legbottom20", CubeListBuilder.create().texOffs(14, 5).mirror().addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, 5.0F, -7.0F));

        root.addOrReplaceChild("Legbottom21", CubeListBuilder.create().texOffs(14, 5).mirror().addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, 5.0F, -4.0F));

        root.addOrReplaceChild("Legbottom22", CubeListBuilder.create().texOffs(14, 5).mirror().addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, 5.0F, 0.0F));

        root.addOrReplaceChild("Legbottom23", CubeListBuilder.create().texOffs(14, 5).mirror().addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, 8.0F, 0.0F));

        root.addOrReplaceChild("Legbottom24", CubeListBuilder.create().texOffs(14, 5).mirror().addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, 8.0F, -4.0F));

        root.addOrReplaceChild("Legbottom25", CubeListBuilder.create().texOffs(14, 5).mirror().addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, 8.0F, -7.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        float ageInTicks = state.ageInTicks;
        float xRotVal = 0.2F * Mth.sin(ageInTicks * 0.3F) + 0.4F;

        this.legbottom1.xRot = xRotVal;
        this.legbottom2.xRot = xRotVal;
        this.legbottom3.xRot = xRotVal;
        this.legbottom4.xRot = xRotVal;
        this.legbottom5.xRot = xRotVal;
        this.legbottom6.xRot = xRotVal;
        this.legbottom7.xRot = xRotVal;
        this.legbottom8.xRot = xRotVal;
        this.legbottom9.xRot = xRotVal;
        this.legbottom10.xRot = xRotVal;
        this.legbottom11.xRot = xRotVal;
        this.legbottom12.xRot = xRotVal;
        this.legbottom13.xRot = xRotVal;
        this.legbottom14.xRot = xRotVal;
        this.legbottom15.xRot = xRotVal;
        this.legbottom16.xRot = xRotVal;
        this.legbottom17.xRot = xRotVal;
        this.legbottom18.xRot = xRotVal;
        this.legbottom19.xRot = xRotVal;
        this.legbottom20.xRot = xRotVal;
        this.legbottom21.xRot = xRotVal;
        this.legbottom22.xRot = xRotVal;
        this.legbottom23.xRot = xRotVal;
        this.legbottom24.xRot = xRotVal;
        this.legbottom25.xRot = xRotVal;
    }
}