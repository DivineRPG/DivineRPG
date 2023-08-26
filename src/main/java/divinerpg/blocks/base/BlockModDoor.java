package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;

public class BlockModDoor extends DoorBlock {

	public BlockModDoor(MapColor color, BlockSetType type) {
		super(Properties.copy(Blocks.OAK_DOOR).mapColor(color), type);
	}

	public BlockModDoor(MapColor color) {
		super(Properties.copy(Blocks.IRON_DOOR).mapColor(color), BlockSetType.STONE);
	}
}
