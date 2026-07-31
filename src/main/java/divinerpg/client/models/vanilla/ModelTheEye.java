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


public class ModelTheEye<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("the_eye");
    private final ModelPart TheEye, Body;

    public ModelTheEye(ModelPart root) {
        super(root);
        this.TheEye = root.getChild("TheEye");
        this.Body = root.getChild("Body");
    }

    public ModelTheEye(Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("TheEye", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -6.0F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, -2.0F));

        PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(32, 24).addBox(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, 2.0F, 0.3927F, 0.0F, 0.0F));

        PartDefinition Trail = Body.addOrReplaceChild("Trail", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -1.0F));

        Trail.addOrReplaceChild("trail_r1", CubeListBuilder.create().texOffs(0, 40).addBox(-3.5F, 0.0F, -2.0F, 7.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 0.3927F, 0.0F, 0.0F));

        Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(34, 40).addBox(-3.0F, -14.0F, -2.0F, 3.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -11.0F, 1.0F, -0.4363F, 0.0F, -0.2182F));

        Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(22, 40).addBox(0.0F, -14.0F, -2.0F, 3.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -11.0F, 1.0F, -0.4363F, 0.0F, 0.2182F));

        Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 24).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);
    }
}