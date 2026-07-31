package divinerpg.client.renders.entity.iceika;

import divinerpg.DivineRPG;
import divinerpg.client.models.iceika.ModelRobbin;
import divinerpg.entities.iceika.EntityRobbin;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;

public class RenderRobbin<T extends EntityRobbin, S extends LivingEntityRenderState, M extends ModelRobbin<S>> extends MobRenderer<T, S, M> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/robbin.png");

    @SuppressWarnings("unchecked")
    public RenderRobbin(EntityRendererProvider.Context context) {
        super(context, (M) new ModelRobbin(context), 0.2F);
        //TODO - Layer
//        this.addLayer(new RobbinLayer<>(this));
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