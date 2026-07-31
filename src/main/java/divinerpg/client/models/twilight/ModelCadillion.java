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

public class ModelCadillion<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("cadillion");
    public final ModelPart body;
    public final ModelPart head;
    public final ModelPart hornR1;
    public final ModelPart rightEar;
    public final ModelPart leftEar;
    public final ModelPart mouth;
    public final ModelPart frontRightLeg;
    public final ModelPart frontLeftLeg;
    public final ModelPart backRightLeg;
    public final ModelPart backLeftLeg;

    public ModelCadillion(ModelPart root) {
        super(root);
        ModelPart rootPart = root.getChild("root");
        this.body = rootPart.getChild("Body");
        this.head = this.body.getChild("Head");
        this.hornR1 = this.head.getChild("Horn_r1");
        this.rightEar = this.head.getChild("RightEar");
        this.leftEar = this.head.getChild("LeftEar");
        this.mouth = this.head.getChild("Mouth");
        this.frontRightLeg = rootPart.getChild("FrontRightLeg");
        this.frontLeftLeg = rootPart.getChild("FrontLeftLeg");
        this.backRightLeg = rootPart.getChild("BackRightLeg");
        this.backLeftLeg = rootPart.getChild("BackLeftLeg");
    }

    public ModelCadillion(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.ZERO);
        CubeDeformation cubeDef = CubeDeformation.NONE;

        PartDefinition Body = root.addOrReplaceChild("Body", CubeListBuilder.create()
                .texOffs(0, 31).addBox(-4.0F, -4.5F, -8.75F, 8.0F, 8.0F, 17.0F, cubeDef)
                .texOffs(0, 0).addBox(-5.5F, -5.5F, -9.25F, 11.0F, 12.0F, 19.0F, cubeDef), PartPose.offset(0.0F, 9.5F, 0.75F));

        PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create()
                .texOffs(33, 33).addBox(-4.0F, -5.8F, -5.7F, 8.0F, 8.0F, 6.0F, cubeDef)
                .texOffs(54, 12).addBox(-3.0F, -2.8F, -8.7F, 6.0F, 4.0F, 3.0F, cubeDef), PartPose.offset(0.0F, -3.7F, -9.04F));

        Head.addOrReplaceChild("Horn_r1", CubeListBuilder.create()
                .texOffs(14, 56).addBox(-1.0F, -7.5F, -1.0F, 2.0F, 7.0F, 2.0F, cubeDef), PartPose.offsetAndRotation(0.0F, -3.7528F, -4.4743F, 0.3927F, 0.0F, 0.0F));

        Head.addOrReplaceChild("RightEar", CubeListBuilder.create()
                .texOffs(55, 31).addBox(-5.5F, -6.47F, 1.0F, 6.0F, 7.0F, 0.0F, cubeDef)
                .texOffs(38, 56).addBox(-5.5F, -6.47F, 0.99F, 6.0F, 7.0F, 0.0F, cubeDef), PartPose.offsetAndRotation(-2.5F, -2.8F, -1.7F, 0.0F, 0.0F, -0.1309F));

        Head.addOrReplaceChild("LeftEar", CubeListBuilder.create()
                .texOffs(1, 56).addBox(-0.5F, -7.0F, 1.0F, 6.0F, 7.0F, 0.0F, cubeDef)
                .texOffs(22, 56).addBox(-0.5F, -7.0F, 0.99F, 6.0F, 7.0F, 0.0F, cubeDef), PartPose.offsetAndRotation(2.5F, -2.8F, -1.7F, 0.0F, 0.0F, 0.1309F));

        Head.addOrReplaceChild("Mouth", CubeListBuilder.create()
                .texOffs(0, 15).addBox(-3.0F, -0.5F, -1.5F, 6.0F, 1.0F, 3.0F, cubeDef), PartPose.offset(0.0F, 1.7F, -7.2F));

        root.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create()
                .texOffs(50, 50).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, cubeDef), PartPose.offset(-3.0F, 12.99F, -6.01F));

        root.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create()
                .texOffs(41, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, cubeDef), PartPose.offset(3.0F, 12.99F, -6.01F));

        root.addOrReplaceChild("BackRightLeg", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, cubeDef), PartPose.offset(-3.0F, 12.99F, 8.0F));

        root.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create()
                .texOffs(0, 31).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, cubeDef), PartPose.offset(3.0F, 12.99F, 8.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        this.head.yRot = state.yRot * Mth.DEG_TO_RAD;
        this.head.xRot = state.xRot * Mth.DEG_TO_RAD;
        this.backRightLeg.y = 12.99F;
        this.backLeftLeg.y = 12.99F;
        this.frontRightLeg.y = 12.99F;
        this.frontLeftLeg.y = 12.99F;

        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;
        float ageInTicks = state.ageInTicks;

        float f = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        float f1 = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        float f2 = (float) Math.PI / 16.0F + Mth.cos(ageInTicks * 0.06F + limbSwing * 0.05F) * 0.08F + limbSwingAmount * 0.2F;

        this.body.zRot = f * 0.05F;
        this.rightEar.yRot = -f2;
        this.leftEar.yRot = f2;
        this.backRightLeg.xRot = f;
        this.frontLeftLeg.xRot = f;
        this.backLeftLeg.xRot = f1;
        this.frontRightLeg.xRot = f1;
    }
}