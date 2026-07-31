package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class EntityGalroid extends EntityDivineMonster {
    private int protectionTimer;
    public EntityGalroid(EntityType<? extends EntityGalroid> type, Level worldIn) {
		super(type, worldIn);
		protectionTimer = 200;
    }
    @Override public void tick() {
        super.tick();
        if(getProtectionTimer() <= 0 && !isInvulnerable()) {
            setProtectionTimer(200);
            setInvulnerable(true);
        } else if(isInvulnerable() && getProtectionTimer() <= 0) {
            setProtectionTimer(200);
            setInvulnerable(false);
        } setProtectionTimer(getProtectionTimer() - 1);
    }
    private int getProtectionTimer() {return protectionTimer;}
    private void setProtectionTimer(int value) {protectionTimer = value;}
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.GALROID.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.GALROID_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.GALROID_HURT.get();}
}