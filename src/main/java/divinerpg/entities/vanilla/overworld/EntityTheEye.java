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
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.*;

import static divinerpg.registries.SoundRegistry.*;

public class EntityTheEye extends EntityDivineMonster {
	public EntityTheEye(EntityType<? extends Monster> type, Level level) {super(type, level);}
	@Override protected float getStandingEyeHeight(Pose pose, EntityDimensions dimensions) {return 1.75F;}
	@Override protected SoundEvent getAmbientSound() {return THE_EYE.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return THE_EYE_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return THE_EYE_HURT.get();}
    @Override public boolean isAggressive() {return true;}
    @Override public boolean isSteppingCarefully() {return true;}
    @Override
    public void tick() {
        super.tick();
        LivingEntity entity = this.getTarget();
        if(entity != null) {
            if (entity instanceof ServerPlayer && entity.hasLineOfSight(this)) {
                entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 30, 0, false, true));
                TriggerRegistry.DIVINERPG_EYE.trigger((ServerPlayer) entity);
            }
        }
    }
    public static boolean theEyeSpawnRule(EntityType<? extends Monster> typeIn, ServerLevelAccessor worldIn, MobSpawnType reason, BlockPos pos, RandomSource randomIn) {
        return pos.getY() < 0 && checkMonsterSpawnRules(typeIn, worldIn, reason, pos, randomIn);
    }
}