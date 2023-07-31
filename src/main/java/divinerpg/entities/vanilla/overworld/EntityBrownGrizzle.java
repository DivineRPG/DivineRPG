package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.*;
import divinerpg.registries.*;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class EntityBrownGrizzle extends EntityDivineTameable {
    public EntityBrownGrizzle(EntityType<? extends TamableAnimal> type, Level worldIn) {
        super(type, worldIn, 1F);
    }
    protected EntityBrownGrizzle(EntityType<? extends TamableAnimal> type, Level worldIn, Player player) {
        super(type, worldIn, 1F);
        tame(player);
    }
    @Override
    protected void registerGoals() {
    	super.registerGoals();
        this.targetSelector.addGoal(3, (new net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal(this)).setAlertOthers());
    }
    @Override protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 1.22F;
    }
    @Override
    protected boolean isTamingFood(ItemStack item) {
    	return isMeat(item);
    }
    @Override
    public boolean isFood(ItemStack item) {
    	return isMeat(item);
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