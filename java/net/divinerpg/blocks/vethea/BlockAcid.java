package net.divinerpg.blocks.vethea;

import java.util.Random;

import net.divinerpg.api.blocks.BlockMod;
import net.divinerpg.utils.material.EnumBlockType;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockAcid extends BlockMod {
	
    public BlockAcid(String name) {
        super(EnumBlockType.SNOW, name, 0.1F, DivineRPGTabs.vethea);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
        this.setTickRandomly(true);
    }
 
    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
        int var5 = par1World.getBlockMetadata(par2, par3, par4) & 7;
        return var5 >= 3 ? AxisAlignedBB.getBoundingBox(par2 + this.minX, par3 + this.minY, par4 + this.minZ, par2 + this.maxX, par3 + 0.5F, par4 + this.maxZ) : null;
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
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
        int var5 = par1IBlockAccess.getBlockMetadata(par2, par3, par4) & 7;
        float var6 = 2 * (1 + var5) / 16.0F;
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, var6, 1.0F);
    }
 
    @Override
    public boolean canPlaceBlockAt(World world, int par2, int par3, int par4) {
        Block block = world.getBlock(par2, par3 - 1, par4);
        return block != Blocks.ice && block != Blocks.packed_ice ? (block.isLeaves(world, par2, par3 - 1, par4) ? true : (block == this && (world.getBlockMetadata(par2, par2 - 1, par3) & 7) == 7 ? true : block.isOpaqueCube() && block.getMaterial().blocksMovement())) : false;
    }
 
    @Override
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, Block par5) {
        this.canSnowStay(par1World, par2, par3, par4);
    }
 
    private boolean canSnowStay(World par1World, int par2, int par3, int par4) {
        if (!this.canPlaceBlockAt(par1World, par2, par3, par4)) {
            par1World.setBlockToAir(par2, par3, par4);
            return false;
        } else
            return true;
    }
 
    @Override
    public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6) {
        super.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
        par1World.setBlockToAir(par3, par4, par5);
    }
 
    @Override
    public int tickRate(World par1World) {
        return 160;
    }
 
    @Override
    public int quantityDropped(Random par1Random) {
        return 0;
    }
 
    @Override
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        par1World.setBlockToAir(par2, par3, par4);
    }
 
    @Override
    public void onEntityCollidedWithBlock(World var1, int var2, int var3, int var4, Entity var5) {
        if (var5 instanceof EntityPlayer)
            var5.attackEntityFrom(DamageSource.cactus, 3);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
        return par5 == 1 ? true : super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5);
    }
}