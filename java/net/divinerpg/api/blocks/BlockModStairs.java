package net.divinerpg.api.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.divinerpg.helper.tabs.DivineRPGTabs;
import net.divinerpg.helper.utils.LangRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class BlockModStairs extends BlockStairs {

	public BlockModStairs(Block stair, String name) {
		super(stair, 0);
		this.setCreativeTab(DivineRPGTabs.blocks);
		LangRegistry.addBlock(this);
		setBlockName(name);
		GameRegistry.registerBlock(this, name);
	}
}