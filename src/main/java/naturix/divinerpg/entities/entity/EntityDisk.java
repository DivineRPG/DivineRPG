package naturix.divinerpg.entities.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityDisk extends EntityThrowable {

	public EntityDisk(World var1) {
		super(var1);
	}

	public EntityDisk(World var1, EntityLivingBase var3) {
		super(var1, var3);
	}

	@Override
	protected void onImpact(RayTraceResult var1) {
	}
}