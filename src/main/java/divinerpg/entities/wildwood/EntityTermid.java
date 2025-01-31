package divinerpg.entities.wildwood;

import divinerpg.entities.base.EntityDivineMonster;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.*;

public class EntityTermid extends EntityDivineMonster {
    public EntityTermid(EntityType<? extends EntityTermid> type, Level worldIn) {super(type, worldIn);}
    @Override public float getWalkTargetValue(BlockPos pos, LevelReader world) {return 0;}
    @Override protected SoundEvent getAmbientSound() {return SoundEvents.WOOD_STEP;}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundEvents.WOOD_HIT;}
    @Override protected SoundEvent getDeathSound() {return SoundEvents.WOOD_BREAK;}
}