package divinerpg.blocks.base;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.*;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockModCrop extends CropBlock {
    private final ResourceLocation seed;
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(0, 0, 0, 16, 3, 16),
            Block.box(0, 0, 0, 16, 6, 16),
            Block.box(0, 0, 0, 16, 9, 16),
            Block.box(0, 0, 0, 16, 11, 16),
            Block.box(0, 0, 0, 16, 11, 16),
            Block.box(0, 0, 0, 16, 11, 16),
            Block.box(0, 0, 0, 16, 11, 16),
            Block.box(0, 0, 0, 16, 11, 16)
    };
    public BlockModCrop(ResourceLocation seed) {
        super(Properties.copy(Blocks.WHEAT));
        this.seed = seed;
        registerDefaultState(stateDefinition.any().setValue(getAgeProperty(), 0));
    }
    @Override public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {return SHAPE_BY_AGE[state.getValue(getAgeProperty())];}
    @Override protected ItemLike getBaseSeedId() {return ForgeRegistries.ITEMS.getValue(seed);}
}