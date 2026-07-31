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

import static divinerpg.utils.Utils.createLocation;

public class ModelFrostbite<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("frostbite");
    private final ModelPart spine;

    public ModelFrostbite(ModelPart root) {
        super(root);
        ModelPart rootPart = root.getChild("root");
        this.spine = rootPart.getChild("Spine");
    }

    public ModelFrostbite(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.ZERO);

        PartDefinition Spine = root.addOrReplaceChild("Spine", CubeListBuilder.create(), PartPose.offset(0.0F, 12.0F, 0.0F));

        PartDefinition Head = Spine.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(32, 25).addBox(-3.0F, -5.0F, -4.0F, 6.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(16, 36).addBox(-1.5F, -2.0F, -7.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -7.0F));

        Head.addOrReplaceChild("RightEar", CubeListBuilder.create().texOffs(8, 3).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -5.0F, -2.0F));

        Head.addOrReplaceChild("LeftEar", CubeListBuilder.create().texOffs(8, 0).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -5.0F, -2.0F));

        PartDefinition Body = Spine.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(24, 9).addBox(0.0F, -7.0F, -7.0F, 0.0F, 5.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-3.0F, -3.0F, -7.0F, 6.0F, 6.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        Body.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(0, 20).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -4.0F));

        Body.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(8, 36).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 3.0F, -5.0F));

        Body.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(30, 35).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 3.0F, 5.0F));

        Body.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 3.0F, 5.0F));

        Body.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(0, 36).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 3.0F, -5.0F));

        Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(26, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 7.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);
    }
}