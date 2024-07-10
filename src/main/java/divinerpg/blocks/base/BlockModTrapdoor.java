package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;

public class BlockModTrapdoor extends TrapDoorBlock {
	public BlockModTrapdoor(MapColor color, BlockSetType type) {super(type, Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).mapColor(color));}
}