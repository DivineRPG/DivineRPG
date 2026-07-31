package divinerpg.entities.wildwood;

import divinerpg.entities.goals.EntityBehemothEatWood;
import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;

public class EntityBehemoth extends EntityDivineMonster {
    public EntityBehemoth(EntityType<? extends EntityBehemoth> type, Level worldIn) {super(type, worldIn);}
    @Override protected void registerGoals() {
        goalSelector.addGoal(0, new FloatGoal(this));
        goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Player.class, 12F, 1.1F, 1.2F) {
            @Override public boolean canUse() {return mob.getHealth() < mob.getMaxHealth() / 3F && super.canUse();}
            @Override public boolean canContinueToUse() {return mob.getHealth() < mob.getMaxHealth() / 2F && super.canContinueToUse();}
        });
        goalSelector.addGoal(2, new EntityBehemothEatWood(this));
        goalSelector.addGoal(2, new MeleeAttackGoal(this, 1, followingTarget) {
            @Override public boolean canContinueToUse() {return mob.getHealth() >= mob.getMaxHealth() / 3 && super.canContinueToUse();}
        });
        goalSelector.addGoal(3, new PanicGoal(this, 1.2F));
        goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1));
        goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 6));
        goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        targetSelector.addGoal(0, new HurtByTargetGoal(this));
        targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }
    @Override protected float getSoundVolume() {return .7F;}
    @Override public float getWalkTargetValue(BlockPos pos, LevelReader world) {return 0;}
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.ENDIKU.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.ENDIKU_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.ENDIKU_DEATH.get();}
}