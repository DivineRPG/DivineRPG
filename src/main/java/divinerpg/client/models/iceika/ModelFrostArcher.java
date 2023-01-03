package divinerpg.client.models.iceika;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.entities.iceika.EntityFrostArcher;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelFrostArcher<E extends EntityDivineMonster> extends HumanoidModel<EntityFrostArcher> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("frost_archer");

    public ModelFrostArcher(EntityRendererProvider.Context context) {
        super(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        return LayerDefinition.create(HumanoidModel.createMesh(CubeDeformation.NONE, 0.0f), 64, 32);
    }
}