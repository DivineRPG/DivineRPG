package divinerpg.client.renders.entity.twilight;

import divinerpg.DivineRPG;
import divinerpg.client.models.state.EpiphiteRenderState;
import divinerpg.client.models.twilight.ModelEpiphite;
import divinerpg.entities.wildwood.EntityEpiphite;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.Identifier;

public class RenderEpiphite<T extends EntityEpiphite, S extends EpiphiteRenderState, M extends ModelEpiphite<S>> extends MobRenderer<T, S, M> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/epiphite.png");
    @SuppressWarnings("unchecked")
    public RenderEpiphite(EntityRendererProvider.Context context) {
        super(context, (M) new ModelEpiphite(context), 0.3F);
    }

    @Override
    public S createRenderState() {
        return (S) new EpiphiteRenderState();
    }

    @Override
    public Identifier getTextureLocation(S state) {return TEXTURE;
    }
}