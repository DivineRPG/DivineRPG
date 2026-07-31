package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class EntityAcidHag extends EntityDivineMonster {
    public EntityAcidHag(EntityType<? extends EntityAcidHag> type, Level world) {super(type, world);}
    @Override public void tick() {
        super.tick();
        BlockPos current = new BlockPos((int)getX() - 1, (int)getY(), (int)getZ() - 1);
        BlockPos below = new BlockPos((int)getX(), (int)getY() - 1, (int)getZ() - 1);
        BlockState belowState = this.level().getBlockState(below);
        //TODO - acid hag
        if(level().getBlockState(current).getBlock() == Blocks.AIR && belowState.isValidSpawn(level(), below, EntityRegistry./*ACID_HAG*/ADVANCED_CORI.get()) && belowState.canOcclude())
            level().setBlockAndUpdate(current, BlockRegistry.bacterialAcid.get().defaultBlockState());
    }
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.ACID_HAG.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.ACID_HAG_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.ACID_HAG_HURT.get();}
}