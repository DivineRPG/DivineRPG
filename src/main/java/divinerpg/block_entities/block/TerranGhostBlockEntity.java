package divinerpg.block_entities.block;

import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class TerranGhostBlockEntity extends BlockEntity {
    public int lifeTime = 300;
    public BlockState originalState;
    public TerranGhostBlockEntity(BlockPos pos, BlockState blockState) {
        super(BlockEntityRegistry.TERRAN_GHOST.get(), pos, blockState);
    }
    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.putInt("lifetime", lifeTime);
        if(originalState != null) tag.put("originalstate", NbtUtils.writeBlockState(originalState));
    }
    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        if(tag.contains("lifetime")) lifeTime = tag.getInt("lifetime");
        if(tag.contains("originalstate")) originalState = NbtUtils.readBlockState(registries.lookupOrThrow(Registries.BLOCK), tag.getCompound("originalstate"));
    }
    public static void serverTick(Level level, BlockPos pos, BlockState state, TerranGhostBlockEntity entity) {
        entity.lifeTime--;
        if(entity.lifeTime <= 0) level.setBlock(pos, entity.originalState == null ? Blocks.AIR.defaultBlockState() : entity.originalState, 3);
    }
    public static void clientTick(Level level, BlockPos pos, BlockState state, TerranGhostBlockEntity entity) {
        RandomSource random = level.getRandom();
        if(random.nextInt(10) == 0) level.addParticle(ParticleRegistry.GREEN_FLAME.get(), pos.getX() + random.nextDouble(), pos.getY() + random.nextDouble(), pos.getZ() + random.nextDouble(), .0, .0, .0);
    }
}