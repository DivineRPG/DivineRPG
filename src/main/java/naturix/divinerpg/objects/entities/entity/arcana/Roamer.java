package naturix.divinerpg.objects.entities.entity.arcana;

import naturix.divinerpg.objects.entities.entity.EntityDivineRPGMob;
import naturix.divinerpg.objects.entities.entity.EntityStats;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.registry.ModSounds;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class Roamer extends EntityDivineRPGMob {
	
    public Roamer(World var1) {
        super(var1);
        addAttackingAI();
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityStats.roamerHealth);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(EntityStats.roamerDamage);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityStats.roamerSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityStats.roamerFollowRange);
    }

    @Override
	protected void dropFewItems(boolean var1, int var2) {
		this.dropItem(ModItems.collector, 1);
	}

    @Override
	protected float getSoundVolume() {
		return 0.3F;
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
	    return ModSounds.ROAMER;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource s) {
	    return ModSounds.ROAMER_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
	    return ModSounds.ROAMER_HURT;
	}

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 40.0D && this.world.checkNoEntityCollision(this.getEntityBoundingBox()) && this.world.getCollisionBoxes(this, this.getEntityBoundingBox()).isEmpty() && !this.world.containsAnyLiquid(this.getEntityBoundingBox());
    }

}