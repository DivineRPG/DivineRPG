package net.divinerpg.items.twilight;

import net.divinerpg.items.base.ItemModSeeds;
import net.divinerpg.utils.blocks.ArcanaBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.util.ForgeDirection;

public class ItemTwilightSeeds extends ItemModSeeds {
	private Block grass;
	public ItemTwilightSeeds(String name, Block block, Block grass) {
		super(name, block, grass);
		this.grass=grass;
	}
	
	@Override
    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
        return EnumPlantType.Plains;
    }
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        if (side != 1) return false;
        else if (player.canPlayerEdit(x, y, z, side, stack) && player.canPlayerEdit(x, y + 1, z, side, stack)) {
            if (world.getBlock(x, y, z) == grass && world.isAirBlock(x, y + 1, z)) {
                world.setBlock(x, y + 1, z, this.crop);
                --stack.stackSize;
                return true;
            }
        }
        return false;
	}

}
