package divinerpg.client.renders.entity.vanilla;

import divinerpg.DivineRPG;
import divinerpg.client.models.state.TwinsRenderState;
import divinerpg.client.models.vethea.ModelTwins;
import divinerpg.entities.vethea.EntityTwins;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class RenderTwins<T extends EntityTwins, S extends TwinsRenderState, M extends ModelTwins<S>> extends MobRenderer<T, S, M> {
    private static final Identifier
            texture = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/twins.png");


    @SuppressWarnings("unchecked")
    public RenderTwins(Context context) {
        super(context, (M) new ModelTwins<>(context), 0.7F);
    }

    @Override
    public S createRenderState() {
        return (S) new TwinsRenderState();
    }

    @Override
    public void extractRenderState(T entity, S state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.abilityCoolDown = entity.abilityCoolDown;
        state.isFast = entity.isFast;
    }

    @Override
    public Identifier getTextureLocation(S state) {
        return texture;
    }
}