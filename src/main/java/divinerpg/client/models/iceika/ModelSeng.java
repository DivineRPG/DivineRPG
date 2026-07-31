package divinerpg.client.models.iceika;

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

public class ModelSeng<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("seng");
    public final ModelPart seng;
    public final ModelPart tail;
    public final ModelPart head;
    public final ModelPart backRightLeg;
    public final ModelPart frontRightLeg;
    public final ModelPart frontLeftLeg;
    public final ModelPart backLeftLeg;

    public ModelSeng(ModelPart root) {
        super(root);
        ModelPart rootPart = root.getChild("root");
        this.seng = rootPart.getChild("seng");
        this.tail = this.seng.getChild("tail");
        this.head = this.seng.getChild("head");
        this.frontRightLeg = rootPart.getChild("frontRightLeg");
        this.frontLeftLeg = rootPart.getChild("frontLeftLeg");
        this.backRightLeg = rootPart.getChild("backRightLeg");
        this.backLeftLeg = rootPart.getChild("backLeftLeg");
    }

    public ModelSeng(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.ZERO);
        CubeDeformation cubeDef = CubeDeformation.NONE;

        PartDefinition Seng = root.addOrReplaceChild("seng", CubeListBuilder.create(), PartPose.offset(0.0F, 14.0F, 0.0F));

        Seng.addOrReplaceChild("torso", CubeListBuilder.create()
                .texOffs(52, 20).addBox(-4.0F, 1.0F, -4.0F, 2.0F, 2.0F, 4.0F, cubeDef)
                .texOffs(52, 20).addBox(2.0F, 1.0F, -4.0F, 2.0F, 2.0F, 4.0F, cubeDef)
                .texOffs(0, 0).addBox(-4.0F, -7.0F, -10.0F, 8.0F, 8.0F, 18.0F, cubeDef), PartPose.offset(0.0F, 2.0F, 1.0F));

        Seng.addOrReplaceChild("tail", CubeListBuilder.create()
                .texOffs(44, 26).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 3.0F, 4.0F, cubeDef) //Tail Seg 1
                .texOffs(44, 33).addBox(-1.0F, -1.0F, 2.0F, 2.0F, 3.0F, 4.0F, cubeDef) //Tail Seg 2
                .texOffs(46, 0).addBox(-1.0F, 0.0F, 6.0F, 2.0F, 2.0F, 4.0F, cubeDef) //Tail Seg 3
                .texOffs(34, 0).addBox(0.0F, -2.0F, 10.0F, 0.0F, 6.0F, 8.0F, cubeDef)
                .texOffs(26, 0).addBox(-3.0F, 1.0F, 10.0F, 6.0F, 0.0F, 8.0F, cubeDef)
                .texOffs(38, 40).addBox(-1.0F, 0.0F, 10.0F, 2.0F, 2.0F, 6.0F, cubeDef), PartPose.offset(0.0F, -4.0F, 10.0F));

        Seng.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(50, 48).addBox(-3.0F, -1.0F, -6.5F, 6.0F, 3.0F, 1.0F, cubeDef)
                .texOffs(32, 46).addBox(-4.0F, -7.0F, -3.0F, 1.0F, 2.0F, 3.0F, cubeDef) //Right Ear
                .texOffs(47, 11).addBox(3.0F, -7.0F, -3.0F, 1.0F, 2.0F, 3.0F, cubeDef) //Left Ear
                .texOffs(32, 52).addBox(-4.5F, -6.0F, -7.0F, 9.0F, 6.0F, 6.0F, cubeDef) //Mane
                .texOffs(0, 26).addBox(-4.0F, -5.0F, -6.0F, 8.0F, 7.0F, 6.0F, cubeDef)
                .texOffs(0, 59).addBox(-4.0F, 2.0F, -6.0F, 8.0F, 2.0F, 3.0F, cubeDef), PartPose.offset(0.0F, 1.01F, -9.0F));

        root.addOrReplaceChild("frontRightLeg", CubeListBuilder.create().texOffs(0, 39).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 16.0F, 4.0F, cubeDef), PartPose.offset(-3.0F, 11.0F, -5.0F));
        root.addOrReplaceChild("backRightLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, cubeDef), PartPose.offset(-3.0F, 12.0F, 8.0F));
        root.addOrReplaceChild("frontLeftLeg", CubeListBuilder.create().texOffs(28, 26).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 16.0F, 4.0F, cubeDef), PartPose.offset(3.0F, 11.0F, -5.0F));
        root.addOrReplaceChild("backLeftLeg", CubeListBuilder.create().texOffs(16, 42).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, cubeDef), PartPose.offset(3.0F, 12.0F, 8.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        this.head.yRot = state.yRot * Mth.DEG_TO_RAD;
        this.head.xRot = state.xRot * Mth.DEG_TO_RAD;
        this.tail.xRot = (float) (Math.PI / 4.0);

        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;
        float ageInTicks = state.ageInTicks;

        this.tail.yRot = Mth.cos(ageInTicks * 0.6662F) * 1.4F * limbSwingAmount;

        float f = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        float f1 = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;

        this.seng.zRot = f * 0.05F;
        this.frontRightLeg.xRot = f1;
        this.backLeftLeg.xRot = f1;
        this.backRightLeg.xRot = f;
        this.frontLeftLeg.xRot = f;
    }
}