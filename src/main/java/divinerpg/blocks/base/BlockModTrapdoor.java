package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.*;

public class BlockModTrapdoor extends TrapDoorBlock {

	public BlockModTrapdoor() {
		super(Block.Properties
                .of(Material.WOOD)
                .strength(2.0f, 3.0F)
                .noOcclusion()
                .requiresCorrectToolForDrops()
                .sound(SoundType.WOOD));
	}
}