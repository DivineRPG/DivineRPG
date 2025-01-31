package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;

public class EntityShadahier extends EntityDivineMonster {
    public EntityShadahier(EntityType<? extends EntityShadahier> type, Level worldIn) {super(type, worldIn);}
    @Override public boolean doHurtTarget(Entity target) {
        boolean attack = super.doHurtTarget(target);
        if(attack) ((LivingEntity)target).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 2 * 20, 1));
        return attack;
    }
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.SHADAHIER.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.SHADAHIER_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.SHADAHIER_HURT.get();}
}