package divinerpg.blocks.base;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.*;

import static net.minecraft.world.level.block.Blocks.WHEAT;

public class BlockModCrop extends CropBlock {
    private final ItemLike seed;
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            box(0, 0, 0, 16, 3, 16),
            box(0, 0, 0, 16, 6, 16),
            box(0, 0, 0, 16, 9, 16),
            box(0, 0, 0, 16, 11, 16),
            box(0, 0, 0, 16, 11, 16),
            box(0, 0, 0, 16, 11, 16),
            box(0, 0, 0, 16, 11, 16),
            box(0, 0, 0, 16, 11, 16)
    };
    public BlockModCrop(ItemLike seed) {
        super(Properties.ofFullCopy(WHEAT));
        this.seed = seed;
    }
    @Override public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {return SHAPE_BY_AGE[state.getValue(getAgeProperty())];}
    @Override protected ItemLike getBaseSeedId() {return seed;}
}