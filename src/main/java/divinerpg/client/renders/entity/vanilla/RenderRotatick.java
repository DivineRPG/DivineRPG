package divinerpg.client.renders.entity.vanilla;

import divinerpg.DivineRPG;
import divinerpg.client.models.vanilla.ModelRotatick;
import divinerpg.entities.vanilla.overworld.EntityRotatick;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;

public class RenderRotatick<T extends EntityRotatick, S extends LivingEntityRenderState, M extends ModelRotatick<S>> extends MobRenderer<T, S, M> {
    private static final Identifier
            TEXTURE = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/rotatick.png"),
            TEXTURE_ALT = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/rotatick_alt.png");
    public RenderRotatick(EntityRendererProvider.Context context) {
        super(context, (M) new ModelRotatick(context), .6F);
    }

    @Override
    public S createRenderState() {
        return (S) new LivingEntityRenderState();
    }
    boolean isSpecialAlt;

    @Override
    public void extractRenderState(T entity, S state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
    isSpecialAlt = entity.isSpecialAlt();
    }

    @Override
    public Identifier getTextureLocation(LivingEntityRenderState livingEntityRenderState) {
        if(isSpecialAlt) return TEXTURE_ALT;
        else return TEXTURE;
    }
}