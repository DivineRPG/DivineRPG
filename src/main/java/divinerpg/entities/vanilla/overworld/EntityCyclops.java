package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineNeutral;
import divinerpg.registries.SoundRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class EntityCyclops extends EntityDivineNeutral {
    public EntityCyclops(EntityType<? extends EntityCyclops> type, Level worldIn) {super(type, worldIn);}
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.CYCLOPS.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.CYCLOPS_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.CYCLOPS_HURT.get();}
}