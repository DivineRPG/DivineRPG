package divinerpg.client.models.vanilla;

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

import static divinerpg.utils.Utils.createLocation;

public class ModelShark<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("shark");
    private final ModelPart Spine, flipperL, flipperR, tail, Jaw;

    public ModelShark(ModelPart root) {
        super(root);
        this.Jaw = root.getChild("Jaw");
        this.Spine = root.getChild("Spine");
        this.flipperL = root.getChild("LeftFinBone");
        this.flipperR = root.getChild("RightFinBone");
        this.tail = root.getChild("Tail");
    }

    public ModelShark(Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Spine = partdefinition.addOrReplaceChild("Spine", CubeListBuilder.create(), PartPose.offset(0.0F, 17.0F, 4.0F));

        Spine.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(34, 21).addBox(-5.0F, -0.5F, -8.8333F, 10.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-5.0F, -6.5F, -15.8333F, 10.0F, 6.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.5F, -4.1667F));

        partdefinition.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(35, 0).addBox(-5.0F, -1.0F, -7.0F, 10.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 21F, -2F));

        PartDefinition Torso = Spine.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(71, -9).addBox(0.0F, -10.0F, -2.0F, 0.0F, 5.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(0, 21).addBox(-6.0F, -5.0F, -4.0F, 12.0F, 12.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -1.0F));

        partdefinition.addOrReplaceChild("RightFinBone", CubeListBuilder.create().texOffs(47, 63).addBox(-6.5F, -1.0F, -2.5F, 7.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.5F, 18.0F, 1.5F));

        partdefinition.addOrReplaceChild("LeftFinBone", CubeListBuilder.create().texOffs(47, 56).addBox(0.5F, -1.0F, -2.5F, 7.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(5.5F, 18.0F, 1.5F));

        Torso.addOrReplaceChild("Pelvis", CubeListBuilder.create().texOffs(37, 36).addBox(-3.0F, -5.0F, -2.0F, 6.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 6.0F));

        PartDefinition Tail = partdefinition.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(17, 52).addBox(-2.0F, -3.25F, 0.75F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.75F, 10.25F));

        Tail.addOrReplaceChild("TailFin", CubeListBuilder.create().texOffs(0, 69).addBox(0.0F, -9.5F, -2.0F, 0.0F, 17.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 8.75F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;
        float ageInTicks = state.ageInTicks;

        this.flipperL.zRot = (float) (-Math.sin((10 * ageInTicks / (180f / Math.PI))) * 0.3f);
        this.flipperR.zRot = (float) (Math.sin((10 * ageInTicks / (180f / Math.PI))) * 0.3f);
        this.tail.yRot = (float) (Math.cos(limbSwing * 0.6662F) * limbSwingAmount);

    }
}