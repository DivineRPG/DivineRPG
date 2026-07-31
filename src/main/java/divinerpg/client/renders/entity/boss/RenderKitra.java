package divinerpg.client.renders.entity.boss;

import divinerpg.DivineRPG;
import divinerpg.client.models.boss.ModelKitra;
import divinerpg.entities.boss.EntityKitra;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;

public class RenderKitra<T extends EntityKitra, S extends LivingEntityRenderState, M extends ModelKitra<S>> extends MobRenderer<T, S, M> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/kitra.png");

    @SuppressWarnings("unchecked")
    public RenderKitra(EntityRendererProvider.Context context) {
        super(context, (M) new ModelKitra<>(context), 0.0F);
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