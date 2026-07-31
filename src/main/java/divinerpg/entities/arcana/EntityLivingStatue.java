package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

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
    public void performRangedAttack(LivingEntity target, float distance) {
        if(isAlive() && getTarget() != null) {
            ItemStack weapon = getItemInHand(ProjectileUtil.getWeaponHoldingHand(this, (item) -> item instanceof BowItem));
            ItemStack stack = getProjectile(weapon);
            AbstractArrow arrow = ProjectileUtil.getMobArrow(this, stack.isEmpty() ? Items.ARROW.getDefaultInstance() : stack, distance, weapon.isEmpty() ? Items.BOW.getDefaultInstance() : weapon);
            arrow.setBaseDamage(6);
            Item item = weapon.getItem();
            if(item instanceof ProjectileWeaponItem weaponItem) arrow = weaponItem.customArrow(arrow, stack, weapon);
            double d0 = target.getX() - getX(), d1 = target.getY(0.3333333333333333) - arrow.getY(), d2 = target.getZ() - getZ(), d3 = Math.sqrt(d0 * d0 + d2 * d2);
            arrow.shoot(d0, d1 + d3 * 0.2, d2, 1.6F, 14F - (level().getDifficulty().getId() << 2));
            playSound(SoundEvents.SKELETON_SHOOT, 1F, 1F / (getRandom().nextFloat() * .4F + .8F));
            level().addFreshEntity(arrow);
        }
    }

    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.HIGH_HIT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.HIGH_HIT.get();}
}