package divinerpg.client.renders.entity.twilight;

import divinerpg.*;
import divinerpg.client.models.twilight.*;
import divinerpg.entities.mortum.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;

public class RenderTwilightArcher<T extends EntityTwilightArcher, S extends LivingEntityRenderState, M extends ModelTwilightArcher<S>> extends MobRenderer<T, S, M> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/twilight_archer.png");

    @SuppressWarnings("unchecked")
    public RenderTwilightArcher(final EntityRendererProvider.Context context) {
        super(context, (M) new ModelTwilightArcher<>(context), 1.0F);
        //TODO - layer
//        this.addLayer(new TwilightArcherLayer<>(this));
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