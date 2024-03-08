package divinerpg.client.renders.entity.vanilla;

import divinerpg.client.renders.base.RenderDivineMob;
import divinerpg.client.renders.layer.PetCollarLayer;
import divinerpg.entities.base.EntityDivineTameable;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

public class RenderPet extends RenderDivineMob<EntityDivineTameable> {
	public RenderPet(Context context, String name, EntityModel<EntityDivineTameable> model, float shadowSize) {
		super(context, name, model, shadowSize);
		addLayer(new PetCollarLayer(this));
	}
}