package divinerpg.entities.mortum;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.*;

public class EntityAngryGlinthop extends EntityDivineMonster {
    public EntityAngryGlinthop(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }
    @Override
    public boolean fireImmune() {
        return true;
    }

    @Override public boolean isAggressive() {
        return true;
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        return entity.hurt(entity.level().damageSources().mobAttack(this), 12);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.HISS.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.GROWL_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.GROWL_HURT.get();
    }

    @Override
    public float getWalkTargetValue(BlockPos pos, LevelReader world) {
        return 0.0F;
    }
}
