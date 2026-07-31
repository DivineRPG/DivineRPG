package divinerpg.client.models.iceika;

import com.google.common.collect.ImmutableList;
import divinerpg.client.models.state.DolossalRenderState;
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
import net.minecraft.util.Mth;

import static divinerpg.utils.Utils.createLocation;

public class ModelDolossal<S extends DolossalRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("dolossal");
    private final ModelPart body;
    private final ModelPart neck;
    private final ModelPart head;
    private final ModelPart rightLeg;
    private final ModelPart leftLeg;
    private final ModelPart leftWing;
    private final ModelPart rightWing;
    private final ModelPart[] saddleParts;
    private final ModelPart[] ridingParts;

    public ModelDolossal(ModelPart root) {
        super(root);
        ModelPart rootPart = root.getChild("root");
        this.body = rootPart.getChild("Body");
        this.neck = rootPart.getChild("Neck");
        this.head = this.neck.getChild("Head");
        this.rightLeg = this.body.getChild("RightLeg");
        this.leftLeg = this.body.getChild("LeftLeg");
        this.rightWing = this.body.getChild("RightWing");
        this.leftWing = this.body.getChild("LeftWing");
        this.saddleParts = new ModelPart[]{
                this.body.getChild("saddle"),
                this.head.getChild("left_saddle_mouth"),
                this.head.getChild("right_saddle_mouth"),
                this.head.getChild("head_saddle"),
                this.head.getChild("mouth_saddle_wrap")
        };
        this.ridingParts = new ModelPart[]{
                this.neck.getChild("left_saddle_line"),
                this.neck.getChild("right_saddle_line")
        };
    }

    public ModelDolossal(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.ZERO);
        CubeDeformation cubedef = new CubeDeformation(0F);

        PartDefinition Body = root.addOrReplaceChild(
                "Body", CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-7.3028F, -7.0F, -4.0304F, 16.0F, 14.0F, 21.0F, cubedef),
                PartPose.offset(0.0F, 5.0F, -5.0F));

        Body.addOrReplaceChild(
                "RightLeg", CubeListBuilder.create()
                        .texOffs(0, 57)
                        .addBox(-6.0F, -3.0F, -4.0F, 8.0F, 7.0F, 8.0F, cubedef)
                        .texOffs(59, 75)
                        .addBox(-4.0F, 1.0F, -2.0F, 5.0F, 13.0F, 5.0F, cubedef), PartPose
                        .offset(-3.3028F, 5.0F, 8.9696F));

        Body.addOrReplaceChild(
                "LeftLeg", CubeListBuilder.create()
                        .texOffs(32, 61)
                        .addBox(-2.0F, -3.0F, -4.0F, 8.0F, 7.0F, 8.0F, cubedef)
                        .texOffs(0, 72)
                        .addBox(-1.0F, 1.0F, -2.0F, 5.0F, 13.0F, 5.0F, cubedef), PartPose
                        .offset(4.6972F, 5.0F, 8.9696F));

        Body.addOrReplaceChild(
                "Tail", CubeListBuilder.create()
                        .texOffs(68, 26)
                        .addBox(-3.0F, -1.0F, 0.5F, 6.0F, 2.0F, 9.0F, cubedef), PartPose
                        .offsetAndRotation(0.6972F, -6.0F, 16.4696F, -0.9163F, 0.0F, 0.0F));

        Body.addOrReplaceChild("RightWing", CubeListBuilder.create().texOffs(20, 72).addBox(-3.0F, -1.5F, -1.0F, 2.0F, 7.0F, 8.0F, cubedef), PartPose.offset(-6.3028F, -5.5F, -1.0304F));

        Body.addOrReplaceChild("LeftWing", CubeListBuilder.create().texOffs(76, 37).addBox(1.0F, -1.5F, -1.0F, 2.0F, 7.0F, 8.0F, cubedef), PartPose.offsetAndRotation(7.6972F, -5.5F, -1.0304F, 0.0F, 0.0F, 0.0F));

        Body.addOrReplaceChild(
                "saddle", CubeListBuilder.create()
                        .texOffs(48, 101).addBox(-5.0F, -8.0F, -9.0F, 10.0F, 9.0F, 9.0F, new CubeDeformation(0.5F)), PartPose.ZERO);

        PartDefinition Neck = root.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(40, 35).addBox(-5.0F, -17.0F, -8.0F, 10.0F, 18.0F, 8.0F, cubedef), PartPose.offset(0.0F, 6.0F, -5.0F));

        Neck.addOrReplaceChild(
                "left_saddle_line", CubeListBuilder.create()
                        .texOffs(54, 103).addBox(3.1F, -6.0F, -8.0F, 0.0F, 3.0F, 16.0F), PartPose.rotation((-(float)Math.PI / 6F), 0.0F, 0.0F));

        Neck.addOrReplaceChild(
                "right_saddle_line", CubeListBuilder.create()
                        .texOffs(54, 103).addBox(-3.1F, -6.0F, -8.0F, 0.0F, 3.0F, 16.0F), PartPose.rotation((-(float)Math.PI / 6F), 0.0F, 0.0F));

        PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 35).addBox(-4.0F, -9.0F, -11.0F, 8.0F, 10.0F, 12.0F, cubedef)
                .texOffs(0, 0).addBox(0.0F, -15.0F, 0.0F, 0.0F, 8.0F, 10.0F, cubedef), PartPose.offset(0.0F, -13.0F, -3.0F));

        Head.addOrReplaceChild(
                "left_saddle_mouth", CubeListBuilder.create()
                        .texOffs(51, 106).addBox(2.0F, -9.0F, -6.0F, 1.0F, 2.0F, 2.0F, cubedef), PartPose.ZERO);

        Head.addOrReplaceChild(
                "right_saddle_mouth", CubeListBuilder.create()
                        .texOffs(51, 106).addBox(-3.0F, -9.0F, -6.0F, 1.0F, 2.0F, 2.0F, cubedef), PartPose.ZERO);

        Head.addOrReplaceChild("head_saddle", CubeListBuilder.create()
                .texOffs(23, 102).addBox(-3.0F, -11.0F, -1.9F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.22F)), PartPose.ZERO);

        Head.addOrReplaceChild(
                "mouth_saddle_wrap", CubeListBuilder.create()
                        .texOffs(41, 101).addBox(-2.0F, -11.0F, -4.0F, 4.0F, 5.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.ZERO);

        Head.addOrReplaceChild("UpperJaw", CubeListBuilder.create().texOffs(0, 97).addBox(-2.0F, -3.75F, -13.0F, 4.0F, 10.0F, 2.0F, cubedef)
                .texOffs(53, 0).addBox(-3.0F, -3.75F, -11.0F, 6.0F, 5.0F, 10.0F, cubedef), PartPose.offset(0.0F, -5.25F, -10.0F));

        Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(64, 61).addBox(-3.0F, -1.0F, -11.0F, 6.0F, 4.0F, 10.0F, cubedef), PartPose.offset(0.0F, -3.0F, -10.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        boolean saddled = state.isSaddled;
        boolean vehicle = state.isVehicle;

        for (ModelPart modelpart : saddleParts) {
            modelpart.visible = saddled;
        }
        for (ModelPart modelpart1 : ridingParts) {
            modelpart1.visible = saddled && vehicle;
        }

        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;
        float ageInTicks = state.ageInTicks;

        this.rightLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leftLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.neck.xRot = Mth.sin(limbSwing * 0.6662F) * 0.2F * limbSwingAmount;
        this.head.xRot = -this.neck.xRot;
        this.rightWing.zRot = Mth.abs(!state.onGround ? (float) Math.PI / 2 + Mth.sin(ageInTicks * 0.2F) * 0.5F : Mth.cos(limbSwing * 0.5F) * 0.3F * limbSwingAmount);
        this.leftWing.zRot = -this.rightWing.zRot;
    }

}