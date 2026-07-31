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


public class ModelKitra<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("kitra");

    public final ModelPart body;
    public final ModelPart head;
    public final ModelPart rightFin;
    public final ModelPart leftFin;
    public final ModelPart hip;
    public final ModelPart tailBase;

    public ModelKitra(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public ModelKitra(ModelPart root) {
        super(root);
        ModelPart rootPart = root.getChild("root");
        this.body = rootPart.getChild("body");
        this.head = this.body.getChild("head");
        this.rightFin = this.body.getChild("right_fin");
        this.leftFin = this.body.getChild("left_fin");
        this.hip = this.body.getChild("hip");
        this.tailBase = this.hip.getChild("tail_base");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.ZERO);
        CubeDeformation cubeDef = CubeDeformation.NONE;

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 72).addBox(-21.0F, -10.0F, -1.0F, 42.0F, 23.0F, 42.0F, cubeDef)
                .texOffs(0, 189).addBox(-2.0F, -15.0F, -1.0F, 4.0F, 8.0F, 41.0F, cubeDef), PartPose.offset(0.0F, 2.0F, -17.0F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, -2.0F));
        head.addOrReplaceChild("head_rot", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -7.0F, -47.0F, 38.0F, 24.0F, 48.0F, cubeDef), PartPose.offsetAndRotation(0.0F, -7.0F, -1.0F, Mth.PI / 24.0F, 0.0F, 0.0F));

        PartDefinition rightFin = body.addOrReplaceChild("right_fin", CubeListBuilder.create(), PartPose.offset(-24.0F, 8.0F, 17.0F));
        rightFin.addOrReplaceChild("right_fin_rot", CubeListBuilder.create().texOffs(0, 137).addBox(-6.0F, -5.0F, 1.0F, 8.0F, 34.0F, 18.0F, cubeDef), PartPose.offsetAndRotation(5.0F, 4.0F, -9.0F, 0.0F, 0.0F, Mth.PI / 18.0F));

        PartDefinition leftFin = body.addOrReplaceChild("left_fin", CubeListBuilder.create(), PartPose.offset(24.0F, 8.0F, 17.0F));
        leftFin.addOrReplaceChild("left_fin_rot", CubeListBuilder.create().texOffs(52, 137).addBox(-1.0F, -5.0F, 1.0F, 8.0F, 34.0F, 18.0F, cubeDef), PartPose.offsetAndRotation(-5.0F, 4.0F, -9.0F, 0.0F, 0.0F, -Mth.PI / 18.0F));

        PartDefinition hip = body.addOrReplaceChild("hip", CubeListBuilder.create()
                .texOffs(126, 72).addBox(-16.0F, 1.0F, -1.0F, 32.0F, 19.0F, 16.0F, cubeDef)
                .texOffs(152, 189).addBox(-2.0F, -5.0F, 1.0F, 4.0F, 8.0F, 15.0F, cubeDef), PartPose.offset(0.0F, -10.0F, 39.0F));

        PartDefinition tailBase = hip.addOrReplaceChild("tail_base", CubeListBuilder.create()
                .texOffs(104, 137).addBox(-13.0F, -2.0F, -1.5F, 26.0F, 18.0F, 11.0F, cubeDef)
                .texOffs(172, 0).addBox(-2.0F, -9.0F, -0.5F, 4.0F, 8.0F, 9.0F, cubeDef), PartPose.offset(0.0F, 4.0F, 16.5F));

        PartDefinition tailSegment1 = tailBase.addOrReplaceChild("tail_segment_1", CubeListBuilder.create()
                .texOffs(172, 17).addBox(-2.0F, -8.5F, -1.25F, 4.0F, 8.0F, 10.0F, cubeDef)
                .texOffs(103, 166).addBox(-11.0F, -1.5F, -1.25F, 22.0F, 12.0F, 11.0F, cubeDef), PartPose.offset(0.0F, -0.5F, 10.75F));

        PartDefinition tailSegment2 = tailSegment1.addOrReplaceChild("tail_segment_2", CubeListBuilder.create()
                .texOffs(103, 166).addBox(-11.0F, -1.5F, -0.5F, 22.0F, 12.0F, 11.0F, cubeDef)
                .texOffs(172, 35).addBox(-2.0F, -8.5F, -0.5F, 4.0F, 8.0F, 11.0F, cubeDef), PartPose.offset(0.0F, 0.0F, 10.25F));

        PartDefinition tailSegment3 = tailSegment2.addOrReplaceChild("tail_segment_3", CubeListBuilder.create()
                .texOffs(103, 166).addBox(-11.0F, -1.5F, 0.0F, 22.0F, 12.0F, 11.0F, cubeDef)
                .texOffs(172, 35).addBox(-2.0F, -8.5F, 1.0F, 4.0F, 8.0F, 11.0F, cubeDef), PartPose.offset(0.0F, 0.0F, 10.5F));

        tailSegment3.addOrReplaceChild("tail_tip", CubeListBuilder.create().texOffs(90, 189).addBox(0.0F, -4.5F, 0.5F, 0.0F, 13.0F, 31.0F, cubeDef), PartPose.offset(0.0F, -6.0F, 11.5F));

        return LayerDefinition.create(meshdefinition, 256, 256);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);
        this.head.xRot = Mth.cos(state.walkAnimationPos * 0.2F) * state.walkAnimationSpeed / 8.0F;

        if (state.isInWater) {
            this.body.xRot = state.xRot * Mth.DEG_TO_RAD / 4.0F;
            this.body.yRot = state.yRot * Mth.DEG_TO_RAD / 4.0F;
        } else {
            this.body.xRot = 0.0F;
            this.body.yRot = 0.0F;
        }

        this.rightFin.zRot = -Mth.sin(10.0F * state.ageInTicks / Mth.RAD_TO_DEG) * 0.3F;
        this.leftFin.zRot = -this.rightFin.zRot;
        this.hip.xRot = -this.head.xRot;
        this.tailBase.xRot = -this.head.xRot;
    }
}