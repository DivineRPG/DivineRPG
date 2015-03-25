package net.divinerpg.items.base;

import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemModSeeds extends ItemSeeds {
	
	public Block crop;
	
	public ItemModSeeds(String name, Block block) {
		super(block, Blocks.farmland);
		this.crop=block;
		setUnlocalizedName(name);
		setTextureName(Reference.PREFIX + name);
		setCreativeTab(DivineRPGTabs.food);
		GameRegistry.registerItem(this, name);
		LangRegistry.addItem(this);
	}
	
	public ItemModSeeds(String name, Block block, Block placeOn) {
		super(block, placeOn);
		this.crop=block;
		setUnlocalizedName(name);
		setTextureName(Reference.PREFIX + name);
		setCreativeTab(DivineRPGTabs.food);
		GameRegistry.registerItem(this, name);
		LangRegistry.addItem(this);
	}
}