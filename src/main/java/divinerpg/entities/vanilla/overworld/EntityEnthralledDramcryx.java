package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.*;
import divinerpg.registries.*;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;
import net.minecraft.world.level.biome.Biomes;

public class EntityEnthralledDramcryx extends EntityDivineMonster {
    public EntityEnthralledDramcryx(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 1.25F;
    }
    @Override
    protected void registerGoals() {
        goalSelector.addGoal(0, new FloatGoal(this));
        goalSelector.addGoal(3, new PanicGoal(this, 1.25D));
        goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        targetSelector.addGoal(2, new HurtByTargetGoal(this));
        goalSelector.addGoal(0, new MeleeAttackGoal(this, 1, true){
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return (double)(this.mob.getBbWidth() * 2.0F * this.mob.getBbWidth() * 2.0F + entity.getBbWidth());
            }
        });
        targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.DRAMCRYX.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.DRAMCRYX_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.DRAMCRYX_HURT.get();
    }
    public static boolean enthralledDramcryxSpawnRule(EntityType<? extends Mob> typeIn, LevelAccessor worldIn, MobSpawnType reason, BlockPos pos, RandomSource randomIn) {
        return (pos.getY() < 0 && worldIn.getLightEmission(pos) < 8) || worldIn.getBiome(pos).is(Biomes.DRIPSTONE_CAVES);
    }

    @Override public boolean isSteppingCarefully() {return true;}
}