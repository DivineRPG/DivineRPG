package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.*;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;

public class EntityLivingStatue extends EntityDivineMonster implements RangedAttackMob {
    public EntityLivingStatue(EntityType<? extends EntityLivingStatue> type, Level worldIn) {
        super(type, worldIn);
    }
    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, 0, true, false, null));
        this.goalSelector.addGoal(1, new RangedAttackGoal(this, 0.27D, 10, 60));
    }
    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        if(isAlive() && getTarget() != null) {
            ItemStack weapon = getItemInHand(ProjectileUtil.getWeaponHoldingHand(this, (item) -> item instanceof BowItem));
            ItemStack itemstack1 = getProjectile(weapon);
            AbstractArrow abstractarrow = ProjectileUtil.getMobArrow(this, itemstack1.isEmpty() ? Items.ARROW.getDefaultInstance() : itemstack1, distanceFactor, weapon.isEmpty() ? Items.BOW.getDefaultInstance() : weapon);
            abstractarrow.setBaseDamage(6);
            Item var7 = weapon.getItem();
            if(var7 instanceof ProjectileWeaponItem weaponItem) abstractarrow = weaponItem.customArrow(abstractarrow, itemstack1, weapon);
            double d0 = target.getX() - getX(), d1 = target.getY(0.3333333333333333) - abstractarrow.getY(), d2 = target.getZ() - getZ(), d3 = Math.sqrt(d0 * d0 + d2 * d2);
            abstractarrow.shoot(d0, d1 + d3 * 0.2, d2, 1.6F, 14F - (level().getDifficulty().getId() << 2));
            playSound(SoundEvents.SKELETON_SHOOT, 1F, 1F / (getRandom().nextFloat() * .4F + .8F));
            level().addFreshEntity(abstractarrow);
        }
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.HIGH_HIT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.HIGH_HIT.get();
    }

}