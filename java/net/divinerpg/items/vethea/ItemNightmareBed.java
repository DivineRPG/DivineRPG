package net.divinerpg.items.vethea;

import net.divinerpg.api.items.ItemMod;
import net.divinerpg.blocks.vethea.BlockNightmareBed;
import net.divinerpg.utils.blocks.VetheaBlocks;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.BlockBed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemNightmareBed extends ItemMod {

	public ItemNightmareBed() {
		super("nightmareBed", "bed", DivineRPGTabs.vethea);
	}
	
	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int x, int y, int z, int par7, float par8, float par9, float par10) {
        if (par3World.isRemote)
            return true;
        else if (par7 != 1)
            return false;
        else {
            ++y;
            BlockNightmareBed bed = (BlockNightmareBed)VetheaBlocks.nightmareBedBlock;
            int i1 = MathHelper.floor_double((double)(par2EntityPlayer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
            byte b0 = 0;
            byte b1 = 0;

            if (i1 == 0)
                b1 = 1;

            if (i1 == 1)
                b0 = -1;

            if (i1 == 2)
                b1 = -1;

            if (i1 == 3)
                b0 = 1;

            if (par2EntityPlayer.canPlayerEdit(x, y, z, par7, par1ItemStack) && par2EntityPlayer.canPlayerEdit(x + b0, y, z + b1, par7, par1ItemStack)) {
                if (par3World.isAirBlock(x, y, z) && par3World.isAirBlock(x + b0, y, z + b1) && World.doesBlockHaveSolidTopSurface(par3World, x, y - 1, z) && World.doesBlockHaveSolidTopSurface(par3World, x + b0, y - 1, z + b1)) {
                    par3World.setBlock(x, y, z, bed, i1, 3);

                    if (par3World.getBlock(x, y, z) == bed){
                        par3World.setBlock(x + b0, y, z + b1, bed, i1 + 8, 3);
                    }

                    --par1ItemStack.stackSize;
                    return true;
                }
                else
                    return false;
            }
            else
                return false;
        }
    }
}
