package divinerpg.entities.boss;

import divinerpg.entities.base.*;
import divinerpg.registries.*;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.BossEvent.BossBarColor;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class EntityDramix extends EntityDivineBoss {
    public EntityDramix(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }
    @Override
    public boolean fireImmune() {
        return true;
    }

    @Override
    public void tick() {
        if (this.tickCount % 600 < 300) {
            this.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 5, 0, true, false));
        }
        super.tick();
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

    @Override
    public BossBarColor getBarColor() {
        return BossBarColor.BLUE;
    }
}
