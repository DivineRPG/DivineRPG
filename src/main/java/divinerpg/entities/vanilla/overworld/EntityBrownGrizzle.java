package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineTameable;
import divinerpg.registries.SoundRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;

public class EntityBrownGrizzle extends EntityDivineTameable {
    public EntityBrownGrizzle(EntityType<? extends TamableAnimal> type, Level worldIn) {
        super(type, worldIn, 1F);
    }
    @Override
    protected void registerGoals() {
    	super.registerGoals();
        this.targetSelector.addGoal(3, (new net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal(this)).setAlertOthers());
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.GRIZZLE.get();
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.GRIZZLE_HURT.get();
    }
    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.GRIZZLE_HURT.get();
    }
}
