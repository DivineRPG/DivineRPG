package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;

public class BlockModDoor extends DoorBlock {

	public BlockModDoor(MapColor color, BlockSetType type) {
		super(type, Properties.ofFullCopy(Blocks.OAK_DOOR).mapColor(color));
	}

	public BlockModDoor(MapColor color) {
		super(BlockSetType.STONE, Properties.ofFullCopy(Blocks.IRON_DOOR).mapColor(color));
	}
}
