package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.*;
import net.neoforged.neoforge.common.IShearable;

public class ModGrass extends BushBlock implements IShearable {
    private final boolean canGrowOnSand;

    public ModGrass(Properties p) {this(p, false);}
    public ModGrass(Properties p, boolean canGrowOnSand) {
        super(p);
        this.canGrowOnSand = canGrowOnSand;
    }
    @Override protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return super.mayPlaceOn(state, level, pos) || (canGrowOnSand && state.is(BlockTags.SUPPORTS_DRY_VEGETATION));
    }
    @Override protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return box(2, 0, 2, 14, 13, 14);
    }
    @Override public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return 100;}
    @Override public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return 60;}
}