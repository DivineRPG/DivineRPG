package divinerpg.client.renders.entity.boss;

import divinerpg.*;
import divinerpg.client.models.boss.*;
import divinerpg.client.renders.base.RenderDivineMob;
import divinerpg.entities.boss.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;


public class RenderLadyLuna<T extends EntityLadyLuna, S extends LivingEntityRenderState, M extends ModelLadyLuna<S>> extends RenderDivineMob<T, S, M> {
    private final Identifier arcanic = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/lady_luna_arcanic.png"), ranged = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/lady_luna_ranged.png");
    int variant;
    @SuppressWarnings("unchecked")
    public RenderLadyLuna(Context context) {
        super(context, "lady_luna", (M) new ModelLadyLuna<>(context), 0.8F);
    }

    @Override
    public void extractRenderState(T entity, S state, float partialTick) {
        super.extractRenderState(entity, state, partialTick);
    variant = entity.getProtection();
    }
    @Override
    public S createRenderState() {
        return (S) new LivingEntityRenderState();
    }
    @Override
    public Identifier getTextureLocation(S state) {
        return switch(variant) {
            case 0 -> arcanic;
            case 1 -> ranged;
            default -> TEXTURE;
        };
    }
}