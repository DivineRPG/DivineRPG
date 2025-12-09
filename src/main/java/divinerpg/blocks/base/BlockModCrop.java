package divinerpg.blocks.base;

import divinerpg.registries.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.*;

import static net.minecraft.world.level.block.Blocks.WHEAT;

public class BlockModCrop extends CropBlock {
    private final ItemLike seed;
    private static VoxelShape[] createHeightByAge(int[] heights) {
        VoxelShape[] shapes = new VoxelShape[heights.length];
        for(int i = 0; i < heights.length; i++) shapes[i] = box(0, 0, 0, 16, heights[i], 16);
        return shapes;
    }
    private static final VoxelShape[]
            DEFAULT = createHeightByAge(new int[]{3, 6, 9, 11, 11, 11, 11, 11}),
            EUCALYPTUS = createHeightByAge(new int[]{3, 5, 5, 7, 8, 10, 12, 14});
    public BlockModCrop(ItemLike seed) {
        super(Properties.ofFullCopy(WHEAT));
        this.seed = seed;
    }
    @Override public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        VoxelShape[] shapes;
        if(this == BlockRegistry.eucalyptusPlant.get()) shapes = EUCALYPTUS;
        else shapes = DEFAULT;
        return shapes[state.getValue(getAgeProperty())];
    }
    @Override protected ItemLike getBaseSeedId() {return seed;}
}