package divinerpg.entities.boss;

import divinerpg.entities.base.*;
import divinerpg.entities.projectile.arrows.FuryArrow;
import divinerpg.registries.*;

import net.minecraft.sounds.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EntityReyvor extends EntityDivineBoss implements RangedAttackMob {


    public EntityReyvor(EntityType<? extends EntityReyvor> type, Level worldIn) {
        super(type, worldIn);
    }
    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, Player.class, 0, true, false, null));
        this.targetSelector.addGoal(7, new RangedAttackGoal(this, 0.25, 40, 64));
    }

    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        if(isAlive() && getTarget() != null) {
            FuryArrow abstractarrow = new FuryArrow(level(), this, new ItemStack(ItemRegistry.fury_arrow.get()), new ItemStack(ItemRegistry.twilight_bow.get()));
            abstractarrow.powerMultiplier = 1.7F;
            double d0 = target.getX() - getX(), d1 = target.getY(0.3333333333333333) - abstractarrow.getY(), d2 = target.getZ() - getZ(), d3 = Math.sqrt(d0 * d0 + d2 * d2);
            abstractarrow.shoot(d0, d1 + d3 * 0.2, d2, 1.6F, 14F - (level().getDifficulty().getId() << 2));
            playSound(SoundEvents.SKELETON_SHOOT, 1F, 1F / (getRandom().nextFloat() * .4F + .8F));
            level().addFreshEntity(abstractarrow);
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.REYVOR.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.REYVOR_HURT.get();
    }

}
