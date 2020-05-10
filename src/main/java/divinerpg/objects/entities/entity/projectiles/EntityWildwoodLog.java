package divinerpg.objects.entities.entity.projectiles;

import divinerpg.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityWildwoodLog extends EntityThrowable {

	public EntityWildwoodLog(World worldIn) {
		super(worldIn);
		this.setSize(1f, 1f);
	}
	public EntityWildwoodLog(World worldIn, EntityLivingBase entity) {
	    super(worldIn, entity);
	}
	@Override
	protected void onImpact(RayTraceResult result) {
		if(!world.isRemote) {
			world.spawnEntity(new EntityItem(world, this.posX, this.posY, this.posZ, new ItemStack(getBlock())));
		}
		if (result.entityHit != null) {
	        result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 8.0F);
	    }
	    if (!this.world.isRemote) {
	        this.setDead();
	    }
	}
	
	public static Block getBlock() {
		return ModBlocks.wildwoodLog;
	}
}