package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import static net.minecraft.core.Direction.Axis.Y;
import static net.minecraft.world.level.block.Blocks.OAK_LOG;

public class BlockModLog extends RotatedPillarBlock {
    //Wood (or logs with the same side/top color)
    public BlockModLog(MapColor mapColor, SoundType sound) {super(Properties.ofFullCopy(OAK_LOG).mapColor(mapColor).sound(sound));}
    //Wood with default sounds
    public BlockModLog(MapColor mapColor) {super(Properties.ofFullCopy(OAK_LOG).mapColor(mapColor));}
    //Logs
    public BlockModLog(MapColor topMapColor, MapColor sideMapColor, SoundType sound) {
        super(Properties.ofFullCopy(OAK_LOG).mapColor(state -> state.getValue(RotatedPillarBlock.AXIS) == Y ? topMapColor : sideMapColor).sound(sound));
    }
    //Logs with default sounds
    public BlockModLog(MapColor topMapColor, MapColor sideMapColor) {
        super(Properties.ofFullCopy(OAK_LOG).mapColor(state -> state.getValue(RotatedPillarBlock.AXIS) == Y ? topMapColor : sideMapColor));
    }
    @Override public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return 5;}
    @Override public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return 5;}
}