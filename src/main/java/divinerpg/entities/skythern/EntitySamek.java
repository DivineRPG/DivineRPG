package divinerpg.entities.skythern;

import divinerpg.entities.base.EntityDivineNeutral;
import divinerpg.registries.SoundRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class EntitySamek extends EntityDivineNeutral {
    public EntitySamek(EntityType<? extends EntitySamek> type, Level worldIn) {super(type, worldIn);}
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.VEREK.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.VEREK_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.VEREK_HURT.get();}
}