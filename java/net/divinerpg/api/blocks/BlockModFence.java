package net.divinerpg.api.blocks;

import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LangRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

import cpw.mods.fml.common.registry.GameRegistry;

public class BlockModFence extends BlockFence {

    protected String name;

    public BlockModFence(String name) {
        super(name, Material.wood);
        this.name = name;
        setBlockName(name);
        setBlockTextureName(Reference.PREFIX + name);
        GameRegistry.registerBlock(this, name);
        LangRegistry.addBlock(this);
    }

    @Override
    public boolean canConnectFenceTo(IBlockAccess blockAccess, int x, int y, int z) {
        Block block = blockAccess.getBlock(x, y, z);

//        if (block != this ? block.getMaterial().isOpaque() && block.renderAsNormalBlock() ?  block.getMaterial()
//                != Material.gourd : false : true)
//        	return true;
        return block instanceof BlockFence || block instanceof BlockFenceGate;
    }

}
