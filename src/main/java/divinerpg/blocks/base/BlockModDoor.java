package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;

import static divinerpg.util.BlockSetTypesList.STEEL;

public class BlockModDoor extends DoorBlock {
	public BlockModDoor(DeferredBlock<Block> base, BlockSetType type) {super(type, Properties.ofFullCopy(Blocks.OAK_DOOR).mapColor(base.get().defaultMapColor()));}
	public BlockModDoor(MapColor color) {super(STEEL, Properties.ofFullCopy(Blocks.IRON_DOOR).mapColor(color));}
}