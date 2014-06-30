package net.divinerpg.api.blocks;

import net.divinerpg.Reference;
import net.divinerpg.helper.blocks.IceikaBlocks;
import net.divinerpg.helper.tabs.DivineRPGTabs;
import net.divinerpg.helper.utils.LangRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBookshelf;
import net.minecraft.util.IIcon;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModBook extends BlockBookshelf {

    protected String name;

    public BlockModBook(String name) {
        this.name = name;
        setBlockTextureName(Reference.PREFIX + name);
        setBlockName(name);
        setCreativeTab(DivineRPGTabs.blocks);
        setStepSound(Block.soundTypeWood);
        GameRegistry.registerBlock(this, name);
        LangRegistry.addBlock(this);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return side != 1 && side != 0 ? super.getIcon(side, meta) : IceikaBlocks.coalstone.getBlockTextureFromSide(side);
    }

}
