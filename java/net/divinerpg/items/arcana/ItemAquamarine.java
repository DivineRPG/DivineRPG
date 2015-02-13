package net.divinerpg.items.arcana;

import net.divinerpg.items.base.ItemMod;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemAquamarine extends ItemMod{

	public ItemAquamarine(String name) {
		super(name, DivineRPGTabs.utility);
		setMaxDamage(10);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int i, int j, int k, int side, float par8, float par9, float par10)
    {
        Block block = world.getBlock(i, j, k);

        if (block == Blocks.snow_layer) side = 1;
        
        else {
            if(side == 0) --j;

            else if(side == 1) ++j;

            else if(side == 2) --k;

            else if(side == 3) ++k;

            else if(side == 4) --i;

            else if(side == 5) ++i;
        }

        if (!player.canPlayerEdit(i, j, k, side, stack) || stack.stackSize == 0) return false;

        if(!world.isRemote)world.setBlock(i, j, k, Blocks.flowing_water, 0, 3);
        if(!player.capabilities.isCreativeMode)stack.damageItem(1, player);
        return true;
    }
}
