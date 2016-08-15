package net.divinerpg.blocks.arcana.container.tile_entity;

import net.divinerpg.blocks.arcana.BlockMoonlightFurnace;
import net.divinerpg.blocks.base.tileentity.TileEntityModFurnace;
import net.divinerpg.utils.items.ArcanaItems;
import net.minecraft.item.ItemStack;

public class TileEntityMoonlightFurnace extends TileEntityModFurnace {

	public TileEntityMoonlightFurnace() {
		super("Moonlight Furnace", 100);
	}

	@Override
	public void updateBlock() {
		BlockMoonlightFurnace.updateFurnaceBlockState(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
	}
	
	public int getItemBurnTime(ItemStack stack) {
        if (stack == null || stack.getItem() != ArcanaItems.firestock)
            return 0;
        return 1600;
    }
}