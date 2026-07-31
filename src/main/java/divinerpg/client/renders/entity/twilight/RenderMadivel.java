package divinerpg.client.renders.entity.twilight;

import divinerpg.DivineRPG;
import divinerpg.client.models.state.MadivelRenderState;
import divinerpg.client.models.twilight.ModelMadivel;
import divinerpg.entities.eden.EntityMadivel;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.Identifier;

public class RenderMadivel<T extends EntityMadivel, S extends MadivelRenderState, M extends ModelMadivel<S>> extends MobRenderer<T, S, M> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/madivel.png");
    @SuppressWarnings("unchecked")
    public RenderMadivel(EntityRendererProvider.Context context) {
        super(context, (M) new ModelMadivel(context), 0.3F);
    }

    @Override
    public S createRenderState() {
        return (S) new MadivelRenderState();
    }

    @Override
    public Identifier getTextureLocation(S state) {return TEXTURE;
    }
}