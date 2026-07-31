package divinerpg.client.renders.entity.vanilla;

import divinerpg.client.models.vanilla.ModelWildfire;
import divinerpg.entities.vanilla.nether.EntityWildfire;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.resources.Identifier;

import static divinerpg.DivineRPG.MODID;

public class RenderWildfire<T extends EntityWildfire, S extends HumanoidRenderState, M extends ModelWildfire<S>> extends HumanoidMobRenderer<T, S, M> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(MODID, "textures/entity/wildfire.png");

    @SuppressWarnings("unchecked")
    public RenderWildfire(EntityRendererProvider.Context context) {
        super(context, (M) new ModelWildfire(context.bakeLayer(ModelWildfire.LAYER_LOCATION)), 0.5F);
    }

    @Override
    public S createRenderState() {
        return (S) new HumanoidRenderState();
    }

    @Override
    public Identifier getTextureLocation(S state) {
        return TEXTURE;
    }
}