package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;

public class BlockModTrapdoor extends TrapDoorBlock {

	public BlockModTrapdoor(MapColor color) {
		super(Block.Properties
                .of()
				.mapColor(color)
                .strength(3.0F)
                .noOcclusion()
                .sound(SoundType.WOOD), BlockSetType.OAK);
	}
}