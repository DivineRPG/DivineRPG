package naturix.divinerpg.objects.entities.entity.arcana;

import naturix.divinerpg.objects.entities.entity.EntityDivineRPGMob;
import naturix.divinerpg.objects.entities.entity.EntityStats;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.registry.ModSounds;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class Razorback extends EntityDivineRPGMob {
	
    public Razorback(World var1) {
        super(var1);
        addAttackingAI();
        this.height = 0.5F;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityStats.razorbackHealth);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(EntityStats.razorbackDamage);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityStats.razorbackSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityStats.razorbackFollowRange);
    }


    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.RAZORBACK;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource s) {
        return ModSounds.RAZORBACK_HURT;
    }

    @Override
    protected void dropFewItems(boolean var1, int var2) {
        this.dropItem(ModItems.collector, 1);
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.RAZORBACK_HURT;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 40.0D && this.world.checkNoEntityCollision(this.getEntityBoundingBox()) && this.world.getCollisionBoxes(this, this.getEntityBoundingBox()).isEmpty() && !this.world.containsAnyLiquid(this.getEntityBoundingBox());
    }
}