package divinerpg.entities.base;

import divinerpg.entities.projectile.DivineThrowableProjectile;
import divinerpg.registries.SoundRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.*;

import java.util.function.Supplier;

import static divinerpg.registries.EntityRegistry.SPELLBINDER_SHOT;
import static divinerpg.registries.TagRegistry.MAGE_RESISTANT_TO;
import static net.neoforged.neoforge.common.damagesource.DamageContainer.Reduction.INNATE_RESISTANCE;

public class EntityBaseMage extends EntityDivineMonster {
    private final Supplier<EntityType<? extends DivineThrowableProjectile>> projectileType;
    public EntityBaseMage(EntityType<? extends EntityBaseMage> type, Level worldIn, Supplier<EntityType<? extends DivineThrowableProjectile>> projectileType) {
        super(type, worldIn);
        this.projectileType = projectileType;
    }
    @Override protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, 0, true, false, null));
    }
    @Override public void tick() {
        super.tick();
        if(tickCount % 19 == 0 && isAlive() && getTarget() != null && !level().isClientSide) {
            double tx = getTarget().getX() - getX(), ty = getTarget().getBoundingBox().minY - getY() - 0.1, tz = getTarget().getZ() - getZ();
            ThrowableProjectile e = (projectileType == null ? SPELLBINDER_SHOT : projectileType).get().create(level());
            e.setOwner(this);
            e.setPos(getEyePosition());
            e.shoot(tx, ty, tz, 1.6F, 0);
            level().addFreshEntity(e);
            playSound(SoundRegistry.MAGE_FIRE.get());
        }
    }
    @Override protected float getDamageAfterMagicAbsorb(DamageSource source, float damage) {
        damage = super.getDamageAfterMagicAbsorb(source, damage);
        if(source.getEntity() == this) {
            damageContainers.peek().setReduction(INNATE_RESISTANCE, damage);
            damage = 0;
        } else if(source.is(MAGE_RESISTANT_TO)) {
            damageContainers.peek().setReduction(INNATE_RESISTANCE, damage * .85F);
            damage *= .15F;
        } return damage;
    }
    @Override public float getWalkTargetValue(BlockPos pos, LevelReader world) {return 0;}
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.INSECT.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.INSECT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.INSECT.get();}
}