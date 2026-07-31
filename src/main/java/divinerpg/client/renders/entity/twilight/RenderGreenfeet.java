package divinerpg.client.renders.entity.twilight;

import divinerpg.DivineRPG;
import divinerpg.client.models.state.GreenfeetRenderState;
import divinerpg.client.models.twilight.ModelGreenfeet;
import divinerpg.entities.eden.EntityGreenfeet;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.Identifier;

public class RenderGreenfeet<T extends EntityGreenfeet, S extends GreenfeetRenderState, M extends ModelGreenfeet<S>> extends MobRenderer<T, S, M> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/greenfeet.png");
    @SuppressWarnings("unchecked")
    public RenderGreenfeet(EntityRendererProvider.Context context) {
        super(context, (M) new ModelGreenfeet(context), 0.3F);
    }

    @Override
    public S createRenderState() {
        return (S) new GreenfeetRenderState();
    }

    @Override
    public Identifier getTextureLocation(S state) {return TEXTURE;
    }
}