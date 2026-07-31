package divinerpg.entities.boss;

import divinerpg.entities.base.EntityDivineBoss;
import divinerpg.registries.SoundRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class EntityVamacheron extends EntityDivineBoss {
    public EntityVamacheron(EntityType<? extends EntityVamacheron> type, Level worldIn) {super(type, worldIn);}
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.CADILLION.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.GROWL_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.GROWL_HURT.get();}
}