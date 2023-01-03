package divinerpg.entities.wildwood;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.*;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.*;

public class EntityVerek extends EntityDivineMonster {

    public EntityVerek(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 1.8F;
    }
    @Override public boolean isAggressive() {return true;}
    @Override
    public int getArmorValue() {
        return 6;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.VEREK.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.VEREK_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.VEREK_HURT.get();
    }

    @Override
    public float getWalkTargetValue(BlockPos pos, LevelReader world) {
        return 0.0F;
    }
}