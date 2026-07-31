package divinerpg.entities.boss;

import divinerpg.entities.base.EntityDivineBoss;
import divinerpg.registries.SoundRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class EntityDramix extends EntityDivineBoss {
    public EntityDramix(EntityType<? extends EntityDramix> type, Level worldIn) {
        super(type, worldIn);
    }
    @Override public void tick() {
        if (this.tickCount % 600 < 300) {
            addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 5, 0, true, false));
        } super.tick();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.DRAMIX.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource s) {
        return SoundRegistry.DRAMIX_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.DRAMIX_HURT.get();
    }

}