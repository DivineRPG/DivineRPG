package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class EntityBiphron extends EntityDivineMonster {
    private boolean gravity;
    public EntityBiphron(EntityType<? extends EntityBiphron> type, Level worldIn) {super(type, worldIn);}
    @Override public void tick() {
        super.tick();
        if(random.nextInt(50) == 0) gravity = !gravity;
        if(gravity) setDeltaMovement(getDeltaMovement().x, getDeltaMovement().y + .4, getDeltaMovement().z);
    }
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.BIPHRON.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.BIPHRON_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.BIPHRON_HURT.get();}
}