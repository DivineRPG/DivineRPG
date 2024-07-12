package divinerpg.entities.wildwood;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.sounds.*;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.*;

public class EntityWildwoodGolem extends EntityDivineMonster {

    public EntityWildwoodGolem(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }
    @Override public boolean isAggressive() {return true;}
    @Override
    public int getArmorValue() {
        return 10;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.GROWL_HURT.get();
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