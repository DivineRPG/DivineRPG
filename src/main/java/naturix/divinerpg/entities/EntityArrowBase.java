package naturix.divinerpg.entities;

import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityArrowBase extends EntityArrow {

	public EntityArrowBase(World worldIn, double damage) {
		super(worldIn);
		this.setDamage(damage);
	}

	@Override
	protected ItemStack getArrowStack() {

		return null;
	}

		}