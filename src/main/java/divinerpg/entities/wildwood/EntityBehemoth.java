package divinerpg.entities.wildwood;

import divinerpg.entities.ai.EntityBehemothEatWood;
import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.*;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.*;

public class EntityBehemoth extends EntityDivineMonster {
    public EntityBehemoth(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }
    @Override public boolean isAggressive() {return true;}
    @Override
    protected void registerGoals() {
    	super.registerGoals();
        goalSelector.addGoal(1, new EntityBehemothEatWood(this));
    }
    @Override
    protected float getSoundVolume() {
        return 0.7F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.ENDIKU.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.ENDIKU_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.ENDIKU_HURT.get();
    }
}