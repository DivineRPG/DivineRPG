package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.TriggerRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import static divinerpg.registries.SoundRegistry.*;

public class EntityTheEye extends EntityDivineMonster {
	public EntityTheEye(EntityType<? extends Monster> type, Level level) {super(type, level);}
	@Override protected float getStandingEyeHeight(Pose pose, EntityDimensions dimensions) {return 2.25F;}
	@Override protected SoundEvent getAmbientSound() {return THE_EYE.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return THE_EYE_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return THE_EYE_HURT.get();}
    @Override protected void playStepSound(BlockPos pos, BlockState state) {}
    @Override public boolean isAggressive() {return true;}
    @Override public boolean isSteppingCarefully() {return true;}

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 64.0F));
    }

    @Override
    public void tick() {
        super.tick();
        LivingEntity entity = this.getTarget();
        if(entity != null && entity instanceof ServerPlayer && (isLookingAt(this, entity) || isLookingAt(entity, this))) {
            entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 120, 0, false, true));
            TriggerRegistry.DIVINERPG_EYE.trigger((ServerPlayer) entity);
        }
    }
    public static boolean theEyeSpawnRule(EntityType<? extends Monster> typeIn, ServerLevelAccessor worldIn, MobSpawnType reason, BlockPos pos, RandomSource randomIn) {
        return pos.getY() < 0 && checkMonsterSpawnRules(typeIn, worldIn, reason, pos, randomIn);
    }

    boolean isLookingAt(LivingEntity target, LivingEntity looking) {
            Vec3 vec3 = looking.getViewVector(64.0F).normalize();
            Vec3 vec31 = new Vec3(target.getX() - looking.getX(), target.getEyeY() - looking.getEyeY(), target.getZ() - looking.getZ());
            double d0 = vec31.length();
            vec31 = vec31.normalize();
            double d1 = vec3.dot(vec31);
            return d1 > 1.0D - 0.025D / d0 ? looking.hasLineOfSight(target) : false;
    }
}
