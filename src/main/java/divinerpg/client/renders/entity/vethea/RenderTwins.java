package divinerpg.client.renders.entity.vethea;

import divinerpg.client.models.state.TwinsRenderState;
import divinerpg.client.models.vethea.ModelTwins;
import divinerpg.entities.vethea.EntityTwins;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

import static divinerpg.DivineRPG.MODID;

public class RenderTwins extends MobRenderer<EntityTwins, TwinsRenderState, ModelTwins<TwinsRenderState>> {

    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(MODID, "textures/entity/twins.png");

    public RenderTwins(EntityRendererProvider.Context context) {
        super(context, new ModelTwins<>(context), 0.5F);
    }

    @Override
    public TwinsRenderState createRenderState() {
        return new TwinsRenderState();
    }

    @Override
    public void extractRenderState(EntityTwins entity, TwinsRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.abilityCoolDown = entity.abilityCoolDown;
        state.isFast = entity.isFast;
    }

    @Override
    public Identifier getTextureLocation(TwinsRenderState state) {
        return TEXTURE;
    }
}