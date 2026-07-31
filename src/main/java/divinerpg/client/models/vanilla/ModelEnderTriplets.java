package divinerpg.client.models.vanilla;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

import static divinerpg.utils.Utils.createLocation;

public class ModelEnderTriplets extends EntityModel<LivingEntityRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("ender_triplets");
    private final ModelPart body;

    public ModelEnderTriplets(ModelPart root) {
        super(root);
        this.body = root.getChild("Body");
    }

    public ModelEnderTriplets(Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(4.0F, -12.0F, -7.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).mirror().addBox(-14.0F, -12.0F, -7.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(52, 0).mirror().addBox(-10.0F, -15.0F, -3.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(52, 0).mirror().addBox(8.0F, -15.0F, -3.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).mirror().addBox(-5.0F, -25.0F, -7.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(52, 0).mirror().addBox(-1.0F, -28.0F, -3.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 23.0F, 2.0F));
        body.addOrReplaceChild("Tentacle32_r1", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -18.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -12.0F, -2.0F, 0.0F, -1.5708F, 0.0F));
        body.addOrReplaceChild("Tentacle12_r1", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(1.0F, 8.0F, -8.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(40, 0).mirror().addBox(-1.0F, 8.0F, -8.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -12.0F, -2.0F, 0.0F, 1.5708F, -3.1416F));
        body.addOrReplaceChild("Tentacle21_r1", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-6.0F, -9.0F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(40, 6).mirror().addBox(-11.0F, -9.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, -29.0F, 3.0F, 0.0F, -1.5708F, -3.1416F));
        body.addOrReplaceChild("Jaw_r1", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(-5.0F, 0.0F, -10.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -15.0F, 3.0F, 0.0873F, 0.0F, 0.0F));
        body.addOrReplaceChild("Connector3_r1", CubeListBuilder.create().texOffs(11, 10).mirror().addBox(10.0F, -1.0F, 7.0F, 3.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, -0.4363F));
        body.addOrReplaceChild("Connector2_r1", CubeListBuilder.create().texOffs(11, 10).mirror().addBox(-10.4F, 1.0F, -5.0F, 3.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 1.0F, -2.0F, 1.5708F, 0.0F, 1.5708F));
        body.addOrReplaceChild("Connector1_r1", CubeListBuilder.create().texOffs(11, 10).mirror().addBox(-13.0F, -1.0F, 7.0F, 3.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.4363F));
        body.addOrReplaceChild("Tentacle323_r1", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -18.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.0F, 1.0F, -2.0F, 0.0F, -1.5708F, 0.0F));
        body.addOrReplaceChild("Tentacle123_r1", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(1.0F, 8.0F, -8.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(40, 0).mirror().addBox(-1.0F, 8.0F, -8.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.0F, 1.0F, -2.0F, 0.0F, 1.5708F, -3.1416F));
        body.addOrReplaceChild("Tentacle213_r1", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-6.0F, -9.0F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(40, 6).mirror().addBox(-11.0F, -9.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, -16.0F, 3.0F, 0.0F, -1.5708F, -3.1416F));
        body.addOrReplaceChild("Jaw3_r1", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(-5.0F, 0.0F, -10.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 20).mirror().addBox(-23.0F, 0.0F, -10.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.0F, -2.0F, 3.0F, 0.0873F, 0.0F, 0.0F));
        body.addOrReplaceChild("Tentacle322_r1", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -18.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, 1.0F, -2.0F, 0.0F, -1.5708F, 0.0F));
        body.addOrReplaceChild("Tentacle122_r1", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(1.0F, 8.0F, -8.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(40, 0).mirror().addBox(-1.0F, 8.0F, -8.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, 1.0F, -2.0F, 0.0F, 1.5708F, -3.1416F));
        body.addOrReplaceChild("Tentacle212_r1", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-6.0F, -9.0F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(40, 6).mirror().addBox(-11.0F, -9.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-16.0F, -16.0F, 3.0F, 0.0F, -1.5708F, -3.1416F));
        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(LivingEntityRenderState state) {
        super.setupAnim(state);
    }
}