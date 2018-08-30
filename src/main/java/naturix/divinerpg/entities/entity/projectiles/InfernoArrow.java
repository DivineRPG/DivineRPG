package naturix.divinerpg.entities.entity.projectiles;

import naturix.divinerpg.registry.ModItems;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class InfernoArrow extends EntityArrow{

	public InfernoArrow(World worldIn) {
		super(worldIn);
	}

	@Override
	protected ItemStack getArrowStack() {
		return ModItems.arrowInferno.getDefaultInstance();
	}

}
