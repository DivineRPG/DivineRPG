package divinerpg.blocks.base;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.*;

public class BlockModTrapdoor extends TrapDoorBlock {

	public BlockModTrapdoor() {
		super(Block.Properties
                .of(Material.WOOD)
                .strength(2.0f, 3.0F)
                .noOcclusion()
                .requiresCorrectToolForDrops()
                .sound(SoundType.WOOD), SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN);
	}
}