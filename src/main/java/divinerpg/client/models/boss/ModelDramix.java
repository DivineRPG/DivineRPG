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
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.util.Mth;

import static divinerpg.utils.Utils.createLocation;


public class ModelDramix<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("dramix");
    private final ModelPart legRight;
    private final ModelPart legLeft;
    private final ModelPart armRight;
    private final ModelPart armLeft;
    private final ModelPart head;
    private final ModelPart chest;

    public ModelDramix(Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public ModelDramix(ModelPart root) {
        super(root);
        ModelPart rootPart = root.getChild("root");
        this.legRight = rootPart.getChild("Leg_Right");
        this.legLeft = rootPart.getChild("Leg_Left");
        this.armRight = rootPart.getChild("Arm_Right");
        this.armLeft = rootPart.getChild("Arm_Left");
        this.head = rootPart.getChild("Head");
        this.chest = rootPart.getChild("Chest");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.ZERO);
        CubeDeformation cubedef = new CubeDeformation(0.0F);

        root.addOrReplaceChild("Leg_Right", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, -2.0F, -3.0F, 5.0F, 15.0F, 6.0F, cubedef).mirror(false), PartPose.offset(-4.0F, 11.0F, 1.0F));

        root.addOrReplaceChild("Leg_Left", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-3.0F, -2.0F, -3.0F, 5.0F, 15.0F, 6.0F, cubedef).mirror(false), PartPose.offset(4.0F, 11.0F, 1.0F));

        root.addOrReplaceChild("Arm_Right", CubeListBuilder.create().texOffs(22, 22).mirror().addBox(-2.0F, -2.0F, -3.0F, 4.0F, 16.0F, 6.0F, cubedef).mirror(false), PartPose.offset(-8.0F, -5.0F, 1.0F));

        root.addOrReplaceChild("Arm_Left", CubeListBuilder.create().texOffs(22, 22).mirror().addBox(-2.0F, -2.0F, -3.0F, 4.0F, 16.0F, 6.0F, cubedef).mirror(false), PartPose.offset(8.0F, -5.0F, 1.0F));

        root.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(36, 0).mirror().addBox(-3.0F, -5.0F, -3.0F, 6.0F, 10.0F, 6.0F, cubedef).mirror(false), PartPose.offset(0.0F, -12.0F, 1.0F));

        root.addOrReplaceChild("Chest", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-6.0F, -7.0F, -2.0F, 12.0F, 16.0F, 6.0F, cubedef).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);
        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;

        this.armRight.xRot = Mth.cos(limbSwing * 0.6662F + Mth.PI) * 2.0F * limbSwingAmount * 0.5F;
        this.armLeft.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
        this.armRight.zRot = 0.0F;

        this.legLeft.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.legRight.xRot = Mth.cos(limbSwing * 0.6662F + Mth.PI) * 1.4F * limbSwingAmount;
        this.legLeft.yRot = 0.0F;
        this.legRight.yRot = 0.0F;
    }
}