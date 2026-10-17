package divinerpg.blocks.base;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

import static net.minecraft.world.level.block.Blocks.ROSE_BUSH;

public class BlockModDoubleFlower extends TallFlowerBlock {
    public BlockModDoubleFlower(Properties properties) {super(properties);}
    public BlockModDoubleFlower(MapColor color) {super(Properties.ofFullCopy(ROSE_BUSH).mapColor(color));}
    @Override public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return 100;}
    @Override public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return 60;}
}