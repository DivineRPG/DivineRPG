package net.divinerpg.blocks.base;

import java.util.Random;

import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.blocks.IceikaBlocks;
import net.divinerpg.utils.material.EnumBlockType;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBookshelf;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModBook extends BlockMod {

    protected String name;

    public BlockModBook(EnumBlockType type, String name) {
    	super(type, name, DivineRPGTabs.blocks);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return side != 1 && side != 0 ? super.getIcon(side, meta) : IceikaBlocks.coalstone.getBlockTextureFromSide(side);
    }
    
    public int quantityDropped(Random rand) {
        return 3;
    }

    public Item getItemDropped(int par1, Random rand, int par3) {
        return Items.book;
    }

}
