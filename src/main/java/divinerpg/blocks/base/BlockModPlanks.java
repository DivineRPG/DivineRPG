package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

import static net.minecraft.world.level.block.Blocks.OAK_PLANKS;

public class BlockModPlanks extends BlockMod {
    //Planks
    public BlockModPlanks(MapColor color, SoundType sound) {super(Properties.ofFullCopy(OAK_PLANKS).mapColor(color).sound(sound));}
    //Planks with default sounds
    public BlockModPlanks(MapColor color) {super(Properties.ofFullCopy(OAK_PLANKS).mapColor(color));}
    @Override public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return 20;}
    @Override public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return 5;}
}