package divinerpg.client.renders.entity.projectile;

import divinerpg.DivineRPG;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.projectile.ThrowableProjectile;

public class RenderItemProjectile<T extends ThrowableProjectile> extends RenderDivineProjectile<T> {
	public RenderItemProjectile(Context context,  String name) {
		super(context, new ResourceLocation(DivineRPG.MODID, "textures/item/" + name + ".png"));
	}
}