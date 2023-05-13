package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.Material;

public class BlockModTrapdoor extends TrapDoorBlock {

	public BlockModTrapdoor() {
		super(Block.Properties
                .of(Material.WOOD)
                .strength(3.0f, 3.0F)
                .noOcclusion()
                .sound(SoundType.WOOD), BlockSetType.OAK);
	}
}