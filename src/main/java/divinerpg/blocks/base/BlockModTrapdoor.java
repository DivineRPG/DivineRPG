package divinerpg.blocks.base;

import divinerpg.DivineRPG;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BlockModTrapdoor extends TrapDoorBlock {

	public BlockModTrapdoor(String name) {
		super(Block.Properties
                .of(Material.WOOD)
                .strength(2.0f, 3.0F)
                .harvestTool(ToolType.AXE)
                .noOcclusion()
                .requiresCorrectToolForDrops()
                .sound(SoundType.WOOD));
        setRegistryName(DivineRPG.MODID, name);
	}
}