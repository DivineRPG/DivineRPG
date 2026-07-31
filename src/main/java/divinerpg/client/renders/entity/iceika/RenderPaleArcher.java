package divinerpg.client.renders.entity.iceika;

import divinerpg.DivineRPG;
import divinerpg.client.models.iceika.ModelPaleArcher;
import divinerpg.entities.iceika.EntityPaleArcher;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.resources.Identifier;

public class RenderPaleArcher<T extends EntityPaleArcher, S extends HumanoidRenderState, M extends ModelPaleArcher<S>> extends HumanoidMobRenderer<T, S, M> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/pale_archer.png");

    @SuppressWarnings("unchecked")
    public RenderPaleArcher(EntityRendererProvider.Context context) {
        super(context, (M) new ModelPaleArcher(context.bakeLayer(ModelPaleArcher.LAYER_LOCATION)), 0.5F);
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