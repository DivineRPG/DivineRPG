package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class EntityBohemite extends EntityDivineMonster {
    public EntityBohemite(EntityType<? extends EntityBohemite> type, Level worldIn) {super(type, worldIn);}
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.BOHEMITE.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.BOHEMITE_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.BOHEMITE_HURT.get();}
}