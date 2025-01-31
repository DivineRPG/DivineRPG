package divinerpg.entities.wildwood;

import divinerpg.entities.goals.EntityBehemothEatWood;
import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.*;

public class EntityBehemoth extends EntityDivineMonster {
    public EntityBehemoth(EntityType<? extends EntityBehemoth> type, Level worldIn) {super(type, worldIn);}
    @Override protected void registerGoals() {
        //TODO: this goal doesn't seem to work
        goalSelector.addGoal(4, new EntityBehemothEatWood(this));
    	super.registerGoals();
    }
    @Override protected float getSoundVolume() {return .7F;}
    @Override public float getWalkTargetValue(BlockPos pos, LevelReader world) {return 0;}
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.ENDIKU.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.ENDIKU_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.ENDIKU_HURT.get();}
}