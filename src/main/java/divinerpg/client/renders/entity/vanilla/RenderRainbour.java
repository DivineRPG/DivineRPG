package divinerpg.client.renders.entity.vanilla;

import divinerpg.client.models.vanilla.ModelRainbour;
import divinerpg.entities.vanilla.overworld.EntityRainbour;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;

import static divinerpg.DivineRPG.MODID;

public class RenderRainbour<T extends EntityRainbour, S extends LivingEntityRenderState, M extends ModelRainbour<S>> extends MobRenderer<T, S, M> {
    private final Identifier
            RAINBOUR = Identifier.fromNamespaceAndPath(MODID, "textures/entity/rainbour.png"),
            RAINBOUR_ANGRY = Identifier.fromNamespaceAndPath(MODID, "textures/entity/rainbour_angry.png");
    boolean isAggressive;
    @SuppressWarnings("unchecked")
    public RenderRainbour(EntityRendererProvider.Context context) {
        super(context, (M) new ModelRainbour(context), 0.5F);
    }

    @Override
    public void extractRenderState(T entity, S state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        isAggressive = entity.isAggressive();
    }

    @Override
    public S createRenderState() {
        return (S) new LivingEntityRenderState();
    }

    @Override
    public Identifier getTextureLocation(S state) {
        return isAggressive ? RAINBOUR_ANGRY : RAINBOUR;
    }
}