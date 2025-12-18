package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.neoforge.registries.DeferredBlock;

public class BlockModTrapdoor extends TrapDoorBlock {
	public BlockModTrapdoor(DeferredBlock<Block> base, BlockSetType type) {super(type, Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).mapColor(base.get().defaultMapColor()));}
}