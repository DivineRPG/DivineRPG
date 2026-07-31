package divinerpg.client.renders.entity.vanilla;

import divinerpg.DivineRPG;
import divinerpg.client.models.vanilla.ModelTheEye;
import divinerpg.entities.vanilla.overworld.EntityTheEye;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;

public class RenderTheEye<T extends EntityTheEye, S extends LivingEntityRenderState, M extends ModelTheEye<S>> extends MobRenderer<T, S, M> {
    private static final Identifier
            texture = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/the_eye.png"),
            madTexture = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/the_eye_angry.png");

    boolean isAggressive;

    @SuppressWarnings("unchecked")
    public RenderTheEye(Context context) {
        super(context, (M) new ModelTheEye(context), 0.7F);
    }

    @Override
    public S createRenderState() {
        return (S) new LivingEntityRenderState();
    }

    @Override
    public void extractRenderState(T entity, S state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        this.isAggressive = entity.isAggressive();
    }

    @Override
    public Identifier getTextureLocation(S state) {
        return isAggressive ? madTexture : texture;
    }
}