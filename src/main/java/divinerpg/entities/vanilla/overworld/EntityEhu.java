package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineTameable;
import divinerpg.registries.SoundRegistry;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;

public class EntityEhu extends EntityDivineTameable {
    public EntityEhu(EntityType<? extends TamableAnimal> type, Level worldIn) {super(type, worldIn, 1);}
    @Override protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {return .6F;}
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.GROWL.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.GROWL_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.GROWL_HURT.get();}
}