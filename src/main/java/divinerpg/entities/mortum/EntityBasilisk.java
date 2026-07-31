package divinerpg.entities.mortum;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.*;
import net.minecraft.world.level.pathfinder.PathType;

public class EntityBasilisk extends EntityDivineMonster {
    public EntityBasilisk(EntityType<? extends EntityBasilisk> type, Level worldIn) {
        super(type, worldIn);
        setPathfindingMalus(PathType.WATER, -1);
    }
    @Override public float getWalkTargetValue(BlockPos pos, LevelReader world) {return 0;}
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.MUCKY.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.GROWL_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.GROWL_HURT.get();}
}