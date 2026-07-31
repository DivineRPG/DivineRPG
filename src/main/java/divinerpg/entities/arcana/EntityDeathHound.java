package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

import static net.minecraft.world.effect.MobEffects.BLINDNESS;

public class EntityDeathHound extends EntityDivineMonster {
    public EntityDeathHound(EntityType<? extends EntityDeathHound> type, Level worldIn) {super(type, worldIn);}
    @Override public boolean doHurtTarget(ServerLevel level, Entity entity) {
        if(entity instanceof LivingEntity livingEntity) livingEntity.addEffect(new MobEffectInstance(BLINDNESS, 4 * 20, 0, false, false));
        return super.doHurtTarget(level, entity);
    }
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.DEATH_HOUND.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.DEATH_HOUND_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.DEATH_HOUND_HURT.get();}
}