package net.divinerpg.entities.vanilla.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityFrostShot extends EntityFireball{

	public EntityFrostShot(World w) {
		super(w);
		setSize(0.3125F, 0.3125F);
	}
	
	public EntityFrostShot(World w, EntityLivingBase shooter, double i, double j, double k) {
		this(w);
        this.setLocationAndAngles(shooter.posX, shooter.posY, shooter.posZ, shooter.rotationYaw, shooter.rotationPitch);
		this.setPosition(shooter.posX, shooter.posY, shooter.posZ);
		double d = (double)MathHelper.sqrt_double(i * i + j * j + k * k);
        this.accelerationX = i / d * 0.1D;
        this.accelerationY = j / d * 0.1D;
        this.accelerationZ = k / d * 0.1D;
        this.shootingEntity = shooter;
	}

	@Override
	protected void onImpact(MovingObjectPosition pos) {
		if (!this.worldObj.isRemote){
			if(pos.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK){
				int var2 = pos.blockX;
				int var3 = pos.blockY;
				int var4 = pos.blockZ;
			
				switch (pos.sideHit)
				{
				case 0:
					var3--;
				break;
				case 1:
				var3++;
				break;
				case 2:
				var4--;
				break;
				case 3:
				var4++;
				break;
				case 4:
				var2--;
				break;
				case 5:
				var2++;
				}
			
				if (this.worldObj.isAirBlock(var2, var3, var4))
				{
					this.worldObj.setBlock(var2, var3, var4, Blocks.fire);
				}
		}else if(pos.typeOfHit == MovingObjectPosition.MovingObjectType.ENTITY){
			pos.entityHit.attackEntityFrom(DamageSource.causeFireballDamage(this, this.shootingEntity), 6.0F);
		}
			
			setDead();
		}
	}
	
	
}
