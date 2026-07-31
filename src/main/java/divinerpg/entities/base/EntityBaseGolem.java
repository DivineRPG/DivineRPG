package divinerpg.entities.base;

import divinerpg.registries.SoundRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;

public class EntityBaseGolem extends EntityDivineMonster {
    public EntityBaseGolem(EntityType<? extends EntityBaseGolem> type, Level worldIn) {super(type, worldIn);}
    @Override public float getWalkTargetValue(BlockPos pos, LevelReader world) {return 0;}
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.GROWL_HURT.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.GROWL_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.GROWL_HURT.get();}
}