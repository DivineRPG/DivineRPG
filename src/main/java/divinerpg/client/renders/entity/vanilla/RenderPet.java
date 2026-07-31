package divinerpg.client.renders.entity.vanilla;

import divinerpg.client.renders.base.RenderDivineMob;
import divinerpg.entities.base.EntityDivineTameable;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

public class RenderPet<T extends EntityDivineTameable, S extends LivingEntityRenderState, M extends EntityModel<S>> extends RenderDivineMob<T, S, M> {
    @SuppressWarnings("unchecked")
    public RenderPet(Context context, String name, M model, float shadowSize) {
        super(context, name, model, shadowSize);
        //TODO - pet collar layer
//        this.addLayer(new PetCollarLayer<>(this));
    }
}