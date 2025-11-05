package divinerpg.entities.boss;

import divinerpg.entities.base.*;
import divinerpg.registries.*;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;

public class EntityDensos extends EntityDivineBoss {
    public EntityDensos(EntityType<? extends EntityDensos> type, Level worldIn) {
        super(type, worldIn);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.DENSOS.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.DENSOS_HURT.get();
    }

}
