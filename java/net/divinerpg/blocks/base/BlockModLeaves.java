package net.divinerpg.blocks.base;

import java.util.ArrayList;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.divinerpg.utils.blocks.VetheaBlocks;
import net.divinerpg.utils.material.EnumBlockType;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class BlockModLeaves extends BlockMod implements IShearable
{
    protected int[] adjacentTreeBlocks;
    private IIcon[] textures = new IIcon[2];
    private Block sapling;

    public BlockModLeaves(String name, float hardness) {
        super(EnumBlockType.LEAVES, name, hardness);
        this.setHardness(0.3F);
        this.setLightOpacity(1);
        this.setTickRandomly(true);
    }
    
    public BlockModLeaves(String name, float hardness, Block sapling) {
        this(name, hardness);
        this.sapling = sapling;
    }
    
    @Override
    public boolean isLeaves(IBlockAccess world, int x, int y, int z) {
        return true;
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
    public void harvestBlock(World w, EntityPlayer p, int x, int y, int z, int meta) {
        super.harvestBlock(w, p, x, y, z, meta);
        if(!w.isRemote && sapling != null && this.rand.nextInt(100) == 0 && (p.getHeldItem() == null || (p.getHeldItem() != null && !(p.getHeldItem().getItem() instanceof ItemShears)))) {
            this.dropBlockAsItem(w, x, y, z, new ItemStack(sapling, 1));
        }
    }

    @Override
    public IIcon getIcon(IBlockAccess world, int i, int j, int k, int par5) {
        if (isFancy(world, i, j, k)) return this.textures[0];
        return this.textures[1];
    }
    
    @Override
    public void registerBlockIcons(IIconRegister i) {
    	this.blockIcon = i.registerIcon(textureName);
    	this.textures[0] = i.registerIcon(textureName);
    	this.textures[1] = i.registerIcon(textureName + "_fast");
    }
    
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess w, int x, int y, int z, int meta) {
        Block block = w.getBlock(x, y, z);
        return !isFancy(w, x, y, z) && block == this ? false : super.shouldSideBeRendered(w, x, y, z, meta);
    }

    @Override
    public Item getItemDropped(int par1, Random rand, int par3) {
        return null;
    }

    @Override
    public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z) {
        return true;
    }

    @Override
    public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune) {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        ret.add(new ItemStack(this, 1, world.getBlockMetadata(x, y, z) & 3));
        return ret;
    }
    
    private boolean isFancy(IBlockAccess world, int x, int y, int z) {
    	if(Minecraft.getMinecraft().gameSettings.fancyGraphics || world.getBlock(x, y, z) == VetheaBlocks.firewoodLeaves || world.getBlock(x, y, z) == VetheaBlocks.hyrewoodLeaves || world.getBlock(x, y, z) == VetheaBlocks.dreamWoodLeaves || world.getBlock(x, y, z) == VetheaBlocks.mintwoodLeaves) return true;
		return false;
    }
}
