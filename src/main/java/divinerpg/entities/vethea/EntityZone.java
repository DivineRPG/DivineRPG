package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.entities.projectile.arrows.KarosArrow;
import divinerpg.registries.*;
import net.minecraft.sounds.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EntityZone extends EntityDivineMonster implements RangedAttackMob {
    public EntityZone(EntityType<? extends EntityZone> type, Level worldIn) {
		super(type, worldIn);
		setHealth(getMaxHealth());
    }
    @Override protected void registerGoals() {
        goalSelector.addGoal(1, new RangedAttackGoal(this, .25F, 15, 40));
        super.registerGoals();
    }
    @Override public void performRangedAttack(LivingEntity target, float distanceFactor) {
        if(isAlive() && getTarget() != null) {
            KarosArrow abstractarrow = new KarosArrow(level(), this, new ItemStack(ItemRegistry.karos_arrow.get()), new ItemStack(ItemRegistry.karos_bow.get()));
            abstractarrow.powerMultiplier = 2.5F;
            double d0 = target.getX() - getX(), d1 = target.getY(.3333333333333333) - abstractarrow.getY(), d2 = target.getZ() - getZ(), d3 = Math.sqrt(d0 * d0 + d2 * d2);
            abstractarrow.shoot(d0, d1 + d3 * .2, d2, 1.6F, 14 - (level().getDifficulty().getId() << 2));
            playSound(SoundEvents.SKELETON_SHOOT, 1, 1 / (getRandom().nextFloat() * .4F + .8F));
            level().addFreshEntity(abstractarrow);
        }
    }
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.ZONE.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.ZONE_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.ZONE_HURT.get();}
}