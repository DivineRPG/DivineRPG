package net.divinerpg.api.blocks;

import net.divinerpg.utils.material.EnumBlockType;
import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModGlass extends BlockMod {
		
	public BlockModGlass(String name, float hardness) {
		super(EnumBlockType.GLASS, name, hardness);
	}
	
    public int getRenderBlockPass() {
        return 1;
    }
    
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    @Override
    public boolean isOpaqueCube() {
    	return false;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side){
        Block i1 = blockAccess.getBlock(x, y, z);
        return i1 == this ? false : super.shouldSideBeRendered(blockAccess, x, y, z, side);
    }
}