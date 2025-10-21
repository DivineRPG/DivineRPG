package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

public class BlockModLeaves extends LeavesBlock {
    //Leaves
    public BlockModLeaves(MapColor color, SoundType sound) {super(Properties.ofFullCopy(Blocks.AZALEA_LEAVES).mapColor(color).sound(sound));}
    //Leaves with default sounds
    public BlockModLeaves(MapColor color) {super(Properties.ofFullCopy(Blocks.AZALEA_LEAVES).mapColor(color));}
    @Override public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return 60;}
    @Override public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return 30;}
}