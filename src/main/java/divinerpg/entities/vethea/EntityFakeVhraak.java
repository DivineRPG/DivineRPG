package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class EntityFakeVhraak extends EntityDivineMonster {
    private int lifeTick = 20;
    public EntityFakeVhraak(EntityType<? extends EntityFakeVhraak> type, Level worldIn) {super(type, worldIn);}
    @Override public void tick() {
        super.tick();
        lifeTick--;
        if(lifeTick <= 0) kill();
    }
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.VHRAAK.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.VHRAAK_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.VHRAAK_HURT.get();}
}