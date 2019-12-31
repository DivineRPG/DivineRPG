package divinerpg.objects.entities.entity.vethea;

import divinerpg.objects.entities.entity.EntityDivineRPGFlying;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIFollow;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityVetheaFlyingMob extends EntityDivineRPGFlying {

	public EntityVetheaFlyingMob(World par1World) {
		super(par1World);
	}

	private static final double spawnLayer = 4;
	@Override
    public boolean getCanSpawnHere() {

		return this.posY < 48.0D * spawnLayer  && this.posY > 48.0D * (spawnLayer - 1) && super.getCanSpawnHere();
    }
}
