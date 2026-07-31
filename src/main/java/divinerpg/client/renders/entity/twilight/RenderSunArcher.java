package divinerpg.client.renders.entity.twilight;

import divinerpg.client.models.twilight.ModelSunArcher;
import divinerpg.entities.eden.EntitySunArcher;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.resources.Identifier;

import static divinerpg.DivineRPG.MODID;

public class RenderSunArcher<T extends EntitySunArcher, S extends HumanoidRenderState, M extends ModelSunArcher<S>> extends HumanoidMobRenderer<T, S, M> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(MODID, "textures/entity/sun_archer.png");

    @SuppressWarnings("unchecked")
    public RenderSunArcher(EntityRendererProvider.Context context) {
        super(context, (M) new ModelSunArcher(context.bakeLayer(ModelSunArcher.LAYER_LOCATION)), 0.57F);
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