package divinerpg.entities.vanilla.nether;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.entities.projectile.arrows.InfernoArrow;
import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;

public class EntityWildfire extends EntityDivineMonster implements RangedAttackMob {
    public EntityWildfire(EntityType<? extends EntityWildfire> type, Level worldIn) {super(type, worldIn);}
    @Override protected void registerGoals() {
        goalSelector.addGoal(1, new RangedAttackGoal(this, this.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue(), 3, (float)getAttribute(Attributes.FOLLOW_RANGE).getBaseValue()));
        targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, 0, true, false, null));
        super.registerGoals();
    }
    @Override public void performRangedAttack(LivingEntity target, float distanceFactor) {
        if(isAlive() && getTarget() != null) {
            InfernoArrow abstractarrow = new InfernoArrow(level(), this, new ItemStack(ItemRegistry.inferno_arrow.get()), new ItemStack(ItemRegistry.inferno_bow.get()));
            abstractarrow.powerMultiplier = 2.5F;
            double d0 = target.getX() - getX(), d1 = target.getY(.3333333333333333) - abstractarrow.getY(), d2 = target.getZ() - getZ(), d3 = Math.sqrt(d0 * d0 + d2 * d2);
            abstractarrow.shoot(d0, d1 + d3 * .2, d2, 1.6F, 14 - (level().getDifficulty().getId() << 2));
            playSound(SoundEvents.SKELETON_SHOOT, 1, 1 / (getRandom().nextFloat() * .4F + .8F));
            level().addFreshEntity(abstractarrow);
        }
    }
    @Override public boolean fireImmune() {return true;}
    @Override public float getWalkTargetValue(BlockPos pos, LevelReader world) {return 0;}
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.WILDFIRE.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.WILDFIRE_HURT.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.WILDFIRE_HURT.get();}
}