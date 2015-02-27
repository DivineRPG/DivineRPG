package net.divinerpg.blocks.base;

import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.BlockLadder;

import cpw.mods.fml.common.registry.GameRegistry;

public class BlockModLadder extends BlockLadder { 

    protected String name;
    
	public BlockModLadder(String name) {
	    this.name = name;
	    setTextureName(Reference.PREFIX + name);
        setUnlocalizedName(name);
        setCreativeTab(DivineRPGTabs.blocks);
        GameRegistry.registerBlock(this, name);
		LangRegistry.addBlock(this);
		setHardness(0.4F);
		}

}