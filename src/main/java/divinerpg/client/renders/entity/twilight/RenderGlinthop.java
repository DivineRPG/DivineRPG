package divinerpg.client.renders.entity.twilight;

import divinerpg.DivineRPG;
import divinerpg.client.models.state.GlinthopRenderState;
import divinerpg.client.models.twilight.ModelGlinthop;
import divinerpg.entities.eden.EntityGlinthop;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.Identifier;

public class RenderGlinthop<T extends EntityGlinthop, S extends GlinthopRenderState, M extends ModelGlinthop<S>> extends MobRenderer<T, S, M> {
    private static final Identifier
            TEXTURE = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/glinthop.png"),
            TEXTURE_ALT = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/glinthop_alt.png");
    boolean isSpecialAlt;
    @SuppressWarnings("unchecked")
    public RenderGlinthop(EntityRendererProvider.Context context) {
        super(context, (M) new ModelGlinthop(context), 0.3F);
        //TODO - layer
        //        this.addLayer(new GlinthopCollarLayer<>(this));
    }

    @Override
    public S createRenderState() {
        return (S) new GlinthopRenderState();
    }

    @Override
    public void extractRenderState(T entity, S state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
    isSpecialAlt = entity.isSpecialAlt();
    }

    @Override
    public Identifier getTextureLocation(S state) {
        if (isSpecialAlt) return TEXTURE_ALT;
        else return TEXTURE;
    }
}