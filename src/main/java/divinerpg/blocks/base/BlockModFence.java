package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

import static net.minecraft.world.level.block.Blocks.OAK_FENCE;

public class BlockModFence extends FenceBlock {
    //Fences
    public BlockModFence(MapColor color, SoundType sound) {super(Properties.ofFullCopy(OAK_FENCE).mapColor(color).sound(sound));}
    //Fences with default sounds
    public BlockModFence(MapColor color) {super(Properties.ofFullCopy(OAK_FENCE).mapColor(color));}
    @Override public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return 20;}
    @Override public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return 5;}
}