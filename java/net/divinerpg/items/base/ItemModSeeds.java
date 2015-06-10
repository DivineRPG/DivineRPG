package net.divinerpg.items.base;

import net.divinerpg.blocks.base.BlockModCrop;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemModSeeds extends ItemSeeds {
	
	public BlockModCrop crop;
	
	public ItemModSeeds(String name, BlockModCrop block) {
		super(block, Blocks.farmland);
		this.crop=block;
		setUnlocalizedName(name);
		setTextureName(Reference.PREFIX + name);
		setCreativeTab(DivineRPGTabs.food);
		GameRegistry.registerItem(this, name);
		LangRegistry.addItem(this);
	}
	
	public ItemModSeeds(String name, BlockModCrop block, Block placeOn) {
		super(block, placeOn);
		this.crop=block;
		setUnlocalizedName(name);
		setTextureName(Reference.PREFIX + name);
		setCreativeTab(DivineRPGTabs.food);
		GameRegistry.registerItem(this, name);
		LangRegistry.addItem(this);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        if (side != 1) return false;
        if (player.canPlayerEdit(x, y, z, side, stack) && player.canPlayerEdit(x, y + 1, z, side, stack)) {
            if (this.crop.canPlaceBlockOn(world.getBlock(x, y, z)) && this.crop.canPlaceBlockAt(world, x, y, z) && world.isAirBlock(x, y + 1, z)) {
                world.setBlock(x, y + 1, z, this.crop);
                --stack.stackSize;
                return true;
            }
            else
            {
                return false;
            }
        }
        return false;
    }
}