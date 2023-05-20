package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class BlockModTrapdoor extends TrapDoorBlock {

	public BlockModTrapdoor(MaterialColor color) {
		super(Block.Properties
                .of(Material.WOOD, color)
                .strength(3.0F)
                .noOcclusion()
                .sound(SoundType.WOOD), BlockSetType.OAK);
	}
}