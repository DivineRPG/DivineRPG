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
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.state.ArmedEntityRenderState;

import static divinerpg.utils.Utils.createLocation;

public class ModelDungeonConstructor extends EntityModel<ArmedEntityRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("dungeon_constructor");
    private final ModelPart Leg_Right;
    private final ModelPart Leg_Left;
    private final ModelPart Arm_Right;
    private final ModelPart Arm_Left;
    private final ModelPart Head;
    private final ModelPart Chest;

    public ModelDungeonConstructor(Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public ModelDungeonConstructor(ModelPart root) {
        super(root);
        this.Leg_Right = root.getChild("Leg_Right");
        this.Leg_Left = root.getChild("Leg_Left");
        this.Arm_Right = root.getChild("Arm_Right");
        this.Arm_Left = root.getChild("Arm_Left");
        this.Head = root.getChild("Head");
        this.Chest = root.getChild("Chest");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        CubeDeformation cubedef = new CubeDeformation(0.0F);

        partdefinition.addOrReplaceChild("Leg_Right", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, -2.0F, -3.0F, 5.0F, 15.0F, 6.0F, cubedef).mirror(false), PartPose.offset(-4.0F, 11.0F, 1.0F));

        partdefinition.addOrReplaceChild("Leg_Left", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-3.0F, -2.0F, -3.0F, 5.0F, 15.0F, 6.0F, cubedef).mirror(false), PartPose.offset(4.0F, 11.0F, 1.0F));

        partdefinition.addOrReplaceChild("Arm_Right", CubeListBuilder.create().texOffs(22, 22).mirror().addBox(-2.0F, -2.0F, -3.0F, 4.0F, 16.0F, 6.0F, cubedef).mirror(false), PartPose.offset(-8.0F, -5.0F, 1.0F));

        partdefinition.addOrReplaceChild("Arm_Left", CubeListBuilder.create().texOffs(22, 22).mirror().addBox(-2.0F, -2.0F, -3.0F, 4.0F, 16.0F, 6.0F, cubedef).mirror(false), PartPose.offset(8.0F, -5.0F, 1.0F));

        partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(36, 0).mirror().addBox(-3.0F, -5.0F, -3.0F, 6.0F, 10.0F, 6.0F, cubedef).mirror(false), PartPose.offset(0.0F, -12.0F, 1.0F));

        partdefinition.addOrReplaceChild("Chest", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-6.0F, -7.0F, -2.0F, 12.0F, 16.0F, 6.0F, cubedef).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(ArmedEntityRenderState state) {
        super.setupAnim(state);
        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;

        this.Arm_Right.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 2.0F * limbSwingAmount * 0.5F);
        this.Arm_Left.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F);
        this.Arm_Right.zRot = 0.0F;
        this.Leg_Left.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        this.Leg_Right.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
        this.Leg_Left.yRot = 0.0F;
        this.Leg_Right.yRot = 0.0F;
    }
}