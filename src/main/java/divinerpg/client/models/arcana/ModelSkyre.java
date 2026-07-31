package divinerpg.client.models.arcana;

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

public class ModelSkyre<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("skyre");
    private final ModelPart skull;
    private final ModelPart leftArm;
    private final ModelPart rightArm;
    private final ModelPart body;
    private final ModelPart leftLeg;
    private final ModelPart rightLeg;

    public ModelSkyre(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public ModelSkyre(ModelPart root) {
        super(root);
        ModelPart rootPart = root.getChild("root");
        this.skull = rootPart.getChild("Skull");
        this.leftArm = rootPart.getChild("LeftArm");
        this.rightArm = rootPart.getChild("RightArm");
        this.body = rootPart.getChild("Body");
        this.leftLeg = rootPart.getChild("LeftLeg");
        this.rightLeg = rootPart.getChild("RightLeg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.ZERO);

        root.addOrReplaceChild("Skull", CubeListBuilder.create().texOffs(0, 23).addBox(-3.0F, -3.0F, -6.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(30, 6).addBox(-3.0F, -6.0F, -6.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, -4.0F));

        root.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(36, 34).addBox(0.0F, -2.0F, -2.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(24, 28).addBox(1.0F, 1.0F, -8.0F, 0.0F, 11.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(48, 28).addBox(1.01F, 1.0F, -8.0F, 0.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 12.0F, -1.0F));

        root.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(10, 35).addBox(-2.0F, -2.0F, -2.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 47).addBox(-1.0F, 1.0F, -8.0F, 0.0F, 11.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(24, 47).addBox(-1.01F, 1.0F, -8.0F, 0.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 12.0F, -1.0F));

        root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 12).addBox(-4.0F, -9.0F, -4.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-5.0F, -6.0F, -4.0F, 10.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(24, 23).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, 0.0F));

        root.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(32, 15).addBox(-2.0F, -1.0F, -2.0F, 3.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 19.0F, 0.0F));

        root.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(42, 15).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 19.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);
        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;

        this.skull.yRot = state.yRot * Mth.DEG_TO_RAD;
        this.skull.xRot = state.xRot * Mth.DEG_TO_RAD;
        this.rightArm.xRot = Mth.cos(limbSwing * 0.6662F + Mth.PI) * 2.0F * limbSwingAmount * 0.5F;
        this.leftArm.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
        this.rightLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leftLeg.xRot = Mth.cos(limbSwing * 0.6662F + Mth.PI) * 1.4F * limbSwingAmount;
    }
}