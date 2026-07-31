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

public class ModelEnchantedArcher<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("enchanted_archer");
    private final ModelPart head;
    private final ModelPart body1;
    private final ModelPart rightarmext;
    private final ModelPart leftfoot;
    private final ModelPart bodymain;
    private final ModelPart body2;
    private final ModelPart body3;
    private final ModelPart body4;
    private final ModelPart body6;
    private final ModelPart body5;
    public final ModelPart rightarm;
    private final ModelPart rightarmcap;
    public final ModelPart leftarm;
    private final ModelPart leftarmext;
    private final ModelPart leftarmcap;
    private final ModelPart leftleg;
    private final ModelPart leftlegcap;
    private final ModelPart rightfoot;
    private final ModelPart rightleg;
    private final ModelPart rightlegcap;
    private final ModelPart shape1;
    private final ModelPart shape2;
    private final ModelPart shape3;
    private final ModelPart shape4;
    private final ModelPart shape5;
    private final ModelPart shape6;
    private final ModelPart shape7;
    private final ModelPart shape8;
    private final ModelPart shape9;
    private final ModelPart shape10;
    private final ModelPart shape11;
    private final ModelPart shape12;
    private final ModelPart shape13;
    private final ModelPart shape14;
    private final ModelPart shape15;
    private final ModelPart shape16;
    private final ModelPart shape17;
    private final ModelPart shape18;
    private final ModelPart shape19;
    private final ModelPart shape20;

    public ModelEnchantedArcher(ModelPart root) {
        super(root);
        this.head = root.getChild("head");
        this.body1 = root.getChild("body1");
        this.rightarmext = root.getChild("rightarmext");
        this.leftfoot = root.getChild("leftfoot");
        this.bodymain = root.getChild("bodymain");
        this.body2 = root.getChild("body2");
        this.body3 = root.getChild("body3");
        this.body4 = root.getChild("body4");
        this.body6 = root.getChild("body6");
        this.body5 = root.getChild("body5");
        this.rightarm = root.getChild("rightarm");
        this.rightarmcap = root.getChild("rightarmcap");
        this.leftarm = root.getChild("leftarm");
        this.leftarmext = root.getChild("leftarmext");
        this.leftarmcap = root.getChild("leftarmcap");
        this.leftleg = root.getChild("leftleg");
        this.leftlegcap = root.getChild("leftlegcap");
        this.rightfoot = root.getChild("rightfoot");
        this.rightleg = root.getChild("rightleg");
        this.rightlegcap = root.getChild("rightlegcap");
        this.shape1 = root.getChild("shape1");
        this.shape2 = root.getChild("shape2");
        this.shape3 = root.getChild("shape3");
        this.shape4 = root.getChild("shape4");
        this.shape5 = root.getChild("shape5");
        this.shape6 = root.getChild("shape6");
        this.shape7 = root.getChild("shape7");
        this.shape8 = root.getChild("shape8");
        this.shape9 = root.getChild("shape9");
        this.shape10 = root.getChild("shape10");
        this.shape11 = root.getChild("shape11");
        this.shape12 = root.getChild("shape12");
        this.shape13 = root.getChild("shape13");
        this.shape14 = root.getChild("shape14");
        this.shape15 = root.getChild("shape15");
        this.shape16 = root.getChild("shape16");
        this.shape17 = root.getChild("shape17");
        this.shape18 = root.getChild("shape18");
        this.shape19 = root.getChild("shape19");
        this.shape20 = root.getChild("shape20");
    }

    public ModelEnchantedArcher(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -16.0F, -19.0F));

        partdefinition.addOrReplaceChild("body1", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -12.0F, -2.0F, 0.2618F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("rightarmext", CubeListBuilder.create().texOffs(40, 10).mirror().addBox(-7.0F, -2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, -16.0F, -6.0F));

        partdefinition.addOrReplaceChild("leftfoot", CubeListBuilder.create().texOffs(28, 15).mirror().addBox(-3.0F, 17.0F, -9.0F, 6.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(10.0F, 2.0F, 0.0F));

        partdefinition.addOrReplaceChild("bodymain", CubeListBuilder.create().texOffs(28, 10).mirror().addBox(-4.0F, 0.0F, -2.0F, 14.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, -6.0F, 0.0F));

        partdefinition.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -21.0F, -14.0F, 1.309F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("body3", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, -21.0F, -16.0F, 1.5708F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("body4", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-4.0F, 0.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, -14.0F, -3.0F, 0.5236F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("body6", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -18.0F, -7.0F, 0.7854F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("body5", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-4.0F, 0.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, -19.0F, -9.0F, 1.0472F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(40, 10).mirror().addBox(-11.0F, -2.0F, -2.0F, 4.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, -16.0F, -6.0F));

        partdefinition.addOrReplaceChild("rightarmcap", CubeListBuilder.create().texOffs(40, 10).mirror().addBox(-12.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, -16.0F, -6.0F));

        partdefinition.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(40, 10).mirror().addBox(7.0F, -2.0F, -2.0F, 4.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, -16.0F, -6.0F));

        partdefinition.addOrReplaceChild("leftarmext", CubeListBuilder.create().texOffs(40, 10).mirror().addBox(-1.0F, -2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, -16.0F, -6.0F));

        partdefinition.addOrReplaceChild("leftarmcap", CubeListBuilder.create().texOffs(40, 10).mirror().addBox(6.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, -16.0F, -6.0F));

        partdefinition.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(37, 6).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 22.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(10.0F, 2.0F, 0.0F));

        partdefinition.addOrReplaceChild("leftlegcap", CubeListBuilder.create().texOffs(37, 6).mirror().addBox(-3.0F, -2.0F, -3.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(10.0F, 2.0F, 0.0F));

        partdefinition.addOrReplaceChild("rightfoot", CubeListBuilder.create().texOffs(28, 15).mirror().addBox(-3.0F, 17.0F, -9.0F, 6.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-10.0F, 2.0F, 0.0F));

        partdefinition.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(37, 6).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 22.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-10.0F, 2.0F, 0.0F));

        partdefinition.addOrReplaceChild("rightlegcap", CubeListBuilder.create().texOffs(37, 6).mirror().addBox(-3.0F, -2.0F, -3.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-10.0F, 2.0F, 0.0F));

        partdefinition.addOrReplaceChild("shape1", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -31.0F, -13.0F));

        partdefinition.addOrReplaceChild("shape2", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -29.0F, -11.0F));

        partdefinition.addOrReplaceChild("shape3", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -27.0F, -9.0F));

        partdefinition.addOrReplaceChild("shape4", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -8.0F, 8.0F, -1.0472F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("shape5", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -5.0F, 10.0F, -1.309F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("shape6", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -24.0F, -2.0F, -0.2618F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("shape7", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -25.0F, -4.0F, -0.2618F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("shape8", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(1.0F, 0.0F, 0.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -20.0F, 3.0F, -0.5236F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("shape9", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -12.0F, 7.0F, -0.7854F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("shape10", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -15.0F, 6.0F, -0.7854F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("shape11", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -18.0F, 5.0F, -0.7854F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("shape12", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 10.0F, 10.0F, -1.5708F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("shape13", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 8.0F, 10.0F, -1.5708F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("shape14", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 6.0F, 10.0F, -1.5708F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("shape15", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 4.0F, 10.0F, -1.5708F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("shape16", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 2.0F, 10.0F, -1.5708F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("shape17", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 0.0F, 10.0F, -1.5708F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("shape18", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -2.0F, 10.0F, -1.5708F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("shape19", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(1.0F, 0.0F, 0.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -26.0F, -6.0F, -0.2618F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("shape20", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(1.0F, 0.0F, 0.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -22.0F, 1.0F, -0.5236F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;
        float ageInTicks = state.ageInTicks;
        float netHeadYaw = state.yRot;
        float headPitch = state.xRot;

        this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = headPitch * ((float)Math.PI / 180F);

        this.rightarm.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
        this.rightarmcap.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
        this.rightarmext.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;

        this.leftarm.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
        this.leftarmcap.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
        this.leftarmext.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;

        this.rightarm.zRot = 0.0F;
        this.rightarmcap.zRot = 0.0F;
        this.rightarmext.zRot = 0.0F;

        this.leftarm.zRot = 0.0F;
        this.leftarmcap.zRot = 0.0F;
        this.leftarmext.zRot = 0.0F;

        this.rightleg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.rightlegcap.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.rightfoot.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

        this.leftleg.xRot = Mth.cos((float) (limbSwing * 0.6662F + Math.PI)) * 1.4F * limbSwingAmount;
        this.leftlegcap.xRot = Mth.cos((float) (limbSwing * 0.6662F + Math.PI)) * 1.4F * limbSwingAmount;
        this.leftfoot.xRot = Mth.cos((float) (limbSwing * 0.6662F + Math.PI)) * 1.4F * limbSwingAmount;

        this.rightleg.yRot = 0.0F;
        this.rightlegcap.yRot = 0.0F;
        this.rightfoot.yRot = 0.0F;

        this.leftleg.yRot = 0.0F;
        this.leftlegcap.yRot = 0.0F;
        this.leftfoot.yRot = 0.0F;

        this.rightarm.yRot = 0.0F;
        this.rightarmcap.yRot = 0.0F;
        this.rightarmext.yRot = 0.0F;

        this.leftarm.yRot = 0.0F;
        this.leftarmcap.yRot = 0.0F;
        this.leftarmext.yRot = 0.0F;

        this.rightarm.zRot += Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.rightarmcap.zRot += Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.rightarmext.zRot += Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;

        this.leftarm.zRot -= Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.leftarmcap.zRot -= Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.leftarmext.zRot -= Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;

        this.rightarm.xRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
        this.rightarmcap.xRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
        this.rightarmext.xRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;

        this.leftarm.xRot -= Mth.sin(ageInTicks * 0.067F) * 0.05F;
        this.leftarmcap.xRot -= Mth.sin(ageInTicks * 0.067F) * 0.05F;
        this.leftarmext.xRot -= Mth.sin(ageInTicks * 0.067F) * 0.05F;
    }
}