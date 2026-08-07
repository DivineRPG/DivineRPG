package divinerpg.block_entities.block;

import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BonfireBlockEntity extends BlockEntity {
    public int lifeTime;
    public BonfireBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.BONFIRE.get(), pos, state);
    }
    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.putInt("lifetime", lifeTime);
    }
    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        if(tag.contains("lifetime")) lifeTime = tag.getInt("lifetime");
    }
    public static void serverTick(Level level, BlockPos pos, BlockState state, BonfireBlockEntity entity) {
        if(entity.lifeTime > 0) {
            entity.lifeTime--;
            if(entity.lifeTime < 1) level.setBlock(pos, Blocks.FIRE.defaultBlockState(), 3);
        }
    }
    public static void particleTick(Level level, BlockPos pos, BlockState state, BonfireBlockEntity blockEntity) {
        if(level.random.nextFloat() < 0.11F) for(int i = 0; i < level.random.nextInt(2) + 2; ++i) CampfireBlock.makeParticles(level, pos, true, true);
    }
}