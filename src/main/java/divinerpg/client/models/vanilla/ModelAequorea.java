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
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.util.Mth;

import static divinerpg.utils.Utils.createLocation;

public class ModelAequorea<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("aequorea");
    public final ModelPart body;
    public final ModelPart tentaclesRightX;
    public final ModelPart tentaclesRightZ;
    public final ModelPart tentaclesLeftX;
    public final ModelPart tentaclesLeftZ;

    public ModelAequorea(ModelPart root) {
        super(root);
        body = root.getChild("body");
        tentaclesRightX = body.getChild("tentacles_right_x");
        tentaclesRightZ = body.getChild("tentacles_right_z");
        tentaclesLeftX = body.getChild("tentacles_left_x");
        tentaclesLeftZ = body.getChild("tentacles_left_z");
    }

    public ModelAequorea(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        CubeDeformation cubeDef = CubeDeformation.NONE;
        PartPose zPose = PartPose.ZERO;

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4, -1, -4, 8, 2, 8, cubeDef)
                .texOffs(0, 10).addBox(-3, -4, -3, 6, 3, 6, cubeDef), PartPose.offset(0, 15, 0));

        body.addOrReplaceChild("tentacles_right_x", CubeListBuilder.create()
                .texOffs(0, 10).addBox(1, 0, 3, 1, 6, 0, cubeDef)
                .texOffs(2, 0).addBox(-3, 0, 1, 1, 6, 0, cubeDef)
                .texOffs(0, 19).addBox(-2, 0, 2, 1, 8, 0, cubeDef), zPose);

        body.addOrReplaceChild("tentacles_right_z", CubeListBuilder.create()
                .texOffs(4, 0).addBox(-2, 0, -2, 0, 7, 1, cubeDef), zPose);

        body.addOrReplaceChild("tentacles_left_x", CubeListBuilder.create()
                .texOffs(6, 0).addBox(-1, 0, -3, 1, 6, 0, cubeDef)
                .texOffs(4, 19).addBox(-1, 0, -1, 1, 9, 0, cubeDef), zPose);

        body.addOrReplaceChild("tentacles_left_z", CubeListBuilder.create()
                .texOffs(0, 0).addBox(1, 0, -3, 0, 7, 1, cubeDef)
                .texOffs(2, 19).addBox(3, 0, -2, 0, 8, 1, cubeDef)
                .texOffs(6, 19).addBox(2, 0, 0, 0, 8, 1, cubeDef), zPose);

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        float ageInTicks = state.ageInTicks;
        tentaclesLeftX.xRot = tentaclesLeftZ.zRot = Mth.sin(10 * ageInTicks / Mth.RAD_TO_DEG) * .15F;
        tentaclesRightX.xRot = tentaclesRightZ.zRot = -tentaclesLeftX.xRot;
    }
}