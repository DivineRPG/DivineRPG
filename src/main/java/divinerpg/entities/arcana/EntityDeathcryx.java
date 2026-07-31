package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class EntityDeathcryx extends EntityDivineMonster {
    public EntityDeathcryx(EntityType<? extends EntityDeathcryx> type, Level worldIn) {super(type, worldIn);}
    @Override
    public boolean doHurtTarget(ServerLevel level, Entity entity) {
        if (super.doHurtTarget(level, entity)) {
            if (entity instanceof LivingEntity) {
                ((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 12 * 20, 0, false, false));
            }
            return true;
        } else {
            return false;
        }
    }
    @Override protected float getSoundVolume() {return .7F;}
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.DEATHCRYX.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.DEATHCRYX_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.DEATHCRYX_HURT.get();}

}