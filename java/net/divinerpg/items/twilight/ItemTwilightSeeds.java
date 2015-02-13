package net.divinerpg.items.twilight;

import net.divinerpg.items.base.ItemModSeeds;
import net.divinerpg.utils.blocks.ArcanaBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;

public class ItemTwilightSeeds extends ItemModSeeds{

	public ItemTwilightSeeds(String name, Block block, Block grass) {
		super(name, block, grass);
	}
	
	@Override
    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
        return EnumPlantType.Plains;
    }

}
