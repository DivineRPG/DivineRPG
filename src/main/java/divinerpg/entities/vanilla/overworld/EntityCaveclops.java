package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.*;
import net.neoforged.neoforge.common.Tags.Biomes;

public class EntityCaveclops extends EntityDivineMonster implements RangedAttackMob {
    public EntityCaveclops(EntityType<? extends EntityCaveclops> type, Level worldIn) {
        super(type, worldIn);
    }
    @Override
    protected void registerGoals() {
    	super.registerGoals();
        goalSelector.addGoal(0, new FleeSunGoal(this, .27));
        goalSelector.addGoal(1, new RangedAttackGoal(this, .27, 30, 10));
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.CYCLOPS.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.CYCLOPS_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.CYCLOPS_HURT.get();
    }

    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        if (isAlive() && getTarget() != null && !level().isClientSide) {
            ThrowableProjectile projectile = EntityRegistry.CAVE_ROCK.get().create(level());
            projectile.setOwner(this);
            projectile.setPos(getEyePosition());
            double d0 = getTarget().getX() - this.getX();
            double d1 = getTarget().getY(0.3333333333333333D) - projectile.getY();
            double d2 = getTarget().getZ() - this.getZ();
            double d3 = Mth.sqrt((float) (d0 * d0 + d2 * d2));
            projectile.shoot(d0, d1 + d3 * .2, d2, 1.6F, 0.8F);
            level().addFreshEntity(projectile);
        }
    }

    public static boolean caveClopsSpawnRule(ServerLevelAccessor worldIn, BlockPos pos) {
        return pos.getY() < 32 || (worldIn.getBiome(pos).is(Biomes.IS_LUSH) && pos.getY() < 60);
    }
}