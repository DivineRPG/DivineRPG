package divinerpg.entities.skythern;


import divinerpg.entities.base.EntityBaseGolem;
import divinerpg.registries.SoundRegistry;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;

public class EntityMegalith extends EntityBaseGolem {
    public EntityMegalith(EntityType<? extends EntityMegalith> type, Level worldIn) {super(type, worldIn);}
    @Override protected float getKnockback(Entity attacker, DamageSource damageSource) {return 3;}
    @Override public boolean doHurtTarget(ServerLevel level, Entity entity) {
        boolean attack = super.doHurtTarget(level, entity);
        if(attack & entity instanceof LivingEntity) ((LivingEntity)entity).addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 5 * 20, 2, false, false));
        return attack;
    }
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.MEGALITH.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.MEGALITH_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.MEGALITH_HURT.get();}
}