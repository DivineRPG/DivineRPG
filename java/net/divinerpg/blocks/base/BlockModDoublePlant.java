package net.divinerpg.blocks.base;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.material.EnumBlockType;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockModDoublePlant extends BlockMod {

	private Block grass;
	private IIcon bottomIcon;
	
	public BlockModDoublePlant(String name, Block grass) {
		super(EnumBlockType.PLANT, name, 0.0F);
		this.setBlockBounds(0.1f, 0, 0.1f, 0.9f, 1, 0.9f);
		this.grass = grass;
	}

	@Override
	public boolean canPlaceBlockAt(World w, int x, int y, int z) {
		return w.getBlock(x, y-1, z) == grass && w.getBlock(x, y+1, z) == Blocks.air;
	}
	
	@Override
    public boolean canBlockStay(World w, int x, int y, int z) {
        return (w.getBlock(x, y - 1, z) == grass && w.getBlockMetadata(x, y, z) == 0) || (w.getBlock(x, y - 1, z) == this && w.getBlockMetadata(x, y, z) == 1);
    }
	
	@Override
	public void onNeighborBlockChange(World w, int x, int y, int z, Block b) {
		if(!this.canBlockStay(w, x, y, z)){
			w.setBlockToAir(x, y, z);
			if(w.getBlockMetadata(x, y, z) == 0) w.setBlockToAir(x, y+1, z);
			else if(w.getBlockMetadata(x, y, z) == 1) w.setBlockToAir(x, y-1, z);
			this.dropBlockAsItem(w, x, y, z, new ItemStack(this));
		}
	}
	
	@Override
    public void breakBlock(World w, int x, int y, int z, Block b, int meta) {
		super.breakBlock(w, x, y, z, b, meta);
		if(meta == 0) w.setBlockToAir(x, y+1, z);
		else if(meta == 1) w.setBlockToAir(x, y-1, z);
    }
	
	@Override
	public void onBlockAdded(World w, int x, int y, int z) {
		if(w.getBlockMetadata(x, y, z) == 0)w.setBlock(x, y+1, z, this, 1, 2);
	}
	
	@Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World w, int x, int y, int z) {
        return null;
    }
    
    @Override
    public int getRenderType() {
    	return 1;
    }
    
    @Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister i) {
		this.blockIcon = i.registerIcon(Reference.PREFIX + name + "_bottom");
		this.bottomIcon = i.registerIcon(Reference.PREFIX + name + "_top");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return meta == 0 ? this.blockIcon : this.bottomIcon;
    }
}