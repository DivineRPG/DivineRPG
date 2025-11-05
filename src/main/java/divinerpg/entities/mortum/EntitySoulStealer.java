package divinerpg.entities.mortum;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.*;

public class EntitySoulStealer extends EntityDivineMonster {
    private int attackAnimationTick;
    public EntitySoulStealer(EntityType<? extends EntitySoulStealer> type, Level worldIn) {super(type, worldIn);}
    @Override public void aiStep() {
        super.aiStep();
        if(attackAnimationTick > 0) --attackAnimationTick;
    }
    @Override public boolean doHurtTarget(Entity target) {
        attackAnimationTick = 10;
        level().broadcastEntityEvent(this, (byte)4);
        boolean attack = super.doHurtTarget(target);
        if(attack) {
            ((LivingEntity)target).addEffect(new MobEffectInstance(MobEffects.CONFUSION, 12 * 20, 0, false, false));
            ((LivingEntity)target).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 12 * 20, 0, false, false));
        } return attack;
    }
    @Override public void handleEntityEvent(byte id) {
        if(id == 4) attackAnimationTick = 10;
        super.handleEntityEvent(id);
    }
    public int getAttackAnimationTick() {return this.attackAnimationTick;}
    @Override public float getWalkTargetValue(BlockPos pos, LevelReader world) {return 0;}
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.INSECT.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.INSECT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.INSECT.get();}
}