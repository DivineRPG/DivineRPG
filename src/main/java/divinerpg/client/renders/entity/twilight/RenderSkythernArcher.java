package divinerpg.client.renders.entity.twilight;

import divinerpg.*;
import divinerpg.client.models.twilight.*;

import divinerpg.entities.skythern.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;

public class RenderSkythernArcher<T extends EntitySkythernArcher, S extends LivingEntityRenderState, M extends ModelTwilightArcher<S>> extends MobRenderer<T, S, M> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/skythern_archer.png");

    @SuppressWarnings("unchecked")
    public RenderSkythernArcher(EntityRendererProvider.Context context) {
        super(context, (M) new ModelTwilightArcher<>(context), 0.8F);
        //TODO - layer
        //        this.addLayer(new SkythernArcherLayer<>(this));
    }

    @Override
    public S createRenderState() {
        return (S) new LivingEntityRenderState();
    }

    @Override
    public Identifier getTextureLocation(S state) {
        return TEXTURE;
    }
}