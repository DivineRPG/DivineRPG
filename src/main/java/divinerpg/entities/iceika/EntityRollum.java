package divinerpg.entities.iceika;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.*;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.*;

public class EntityRollum extends EntityDivineMonster {
    public EntityRollum(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }
    @Override public boolean isAggressive() {return true;}
    @Override
    public boolean doHurtTarget(Entity entity) {
        super.doHurtTarget(entity);
        entity.setDeltaMovement(this.stuckSpeedMultiplier.x * 3.0D, 0.3D, this.stuckSpeedMultiplier.z * 3.0D);
        return true;
    }
    @Override
    public boolean isMaxGroupSizeReached(int i) {
    	return i > 4;
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.ROLLUM.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.ROLLUM_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.ROLLUM_HURT.get();
    }

    @Override
    public float getWalkTargetValue(BlockPos pos, LevelReader reader) {
        return 0.0F;
    }
}
