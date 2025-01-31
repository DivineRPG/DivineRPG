package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class EntityHiveSoldier extends EntityDivineMonster {
    public EntityHiveSoldier(EntityType<? extends EntityHiveSoldier> type, Level worldIn) {super(type, worldIn);}
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.HOVER_STINGER.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.HOVER_STINGER_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.HOVER_STINGER_HURT.get();}
}