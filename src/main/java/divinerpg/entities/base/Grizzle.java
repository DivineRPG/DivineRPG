package divinerpg.entities.base;

import divinerpg.registries.SoundRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class Grizzle extends EntityDivineTameable {
    public Grizzle(EntityType<? extends Grizzle> type, Level worldIn) {super(type, worldIn, 1);}
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.GRIZZLE.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.GRIZZLE_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.GRIZZLE_HURT.get();}
}