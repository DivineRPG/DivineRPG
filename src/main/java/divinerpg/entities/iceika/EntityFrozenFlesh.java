package divinerpg.entities.iceika;

import divinerpg.entities.base.EntityDivineNeutral;
import divinerpg.registries.SoundRegistry;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;

public class EntityFrozenFlesh extends EntityDivineNeutral {
    public EntityFrozenFlesh(EntityType<? extends EntityFrozenFlesh> type, Level worldIn) {super(type, worldIn);}
    @Override protected float getKnockback(Entity attacker, DamageSource damageSource) {return 2;}
    @Override public boolean doHurtTarget(ServerLevel level, Entity target) {
        boolean attack = super.doHurtTarget(level, target);
        if(attack) ((LivingEntity)target).addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 5 * 20, 2, true, false));
        return attack;
    }
    @Override public boolean isMaxGroupSizeReached(int i) {return i > 5;}
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.FROZEN_FLESH.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.FROZEN_FLESH_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.FROZEN_FLESH_HURT.get();}
}