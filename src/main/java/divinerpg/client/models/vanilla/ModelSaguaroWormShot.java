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
import net.minecraft.client.renderer.entity.state.EntityRenderState;

import static divinerpg.utils.Utils.createLocation;


public class ModelSaguaroWormShot extends EntityModel<EntityRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("saguaro_worm_shot");
    public final ModelPart box;

    public ModelSaguaroWormShot(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public ModelSaguaroWormShot(ModelPart root) {
        super(root);
        this.box = root.getChild("box");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot();
        root.addOrReplaceChild("box", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE), PartPose.ZERO);
        return LayerDefinition.create(meshdefinition, 4, 2);
    }

    @Override
    public void setupAnim(EntityRenderState state) {
        super.setupAnim(state);
    }
}