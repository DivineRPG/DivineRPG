package divinerpg.client.renders.entity.vanilla;

import divinerpg.DivineRPG;
import divinerpg.entities.vanilla.overworld.EntityJackOMan;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.resources.Identifier;

public class RenderJackOMan<T extends EntityJackOMan, S extends HumanoidRenderState, M extends HumanoidModel<S>> extends MobRenderer<T, S, M> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/jack_o_man.png");

    @SuppressWarnings("unchecked")
    public RenderJackOMan(Context context) {
        super(context, (M) new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER)), 0.8F);
        //TODO - layers
//        this.addLayer(new JackOManHeadLayer<>(this));
//        this.addLayer(new JackOManScytheLayer<>(this));
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