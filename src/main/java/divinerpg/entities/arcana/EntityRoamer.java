package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class EntityRoamer extends EntityDivineMonster {
    public EntityRoamer(EntityType<? extends EntityRoamer> type, Level worldIn) {
        super(type, worldIn);
    }
    @Override protected float getSoundVolume() {return .3F;}
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.ROAMER.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.ROAMER_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.ROAMER_HURT.get();}
}