package net.divinerpg.blocks.vethea;

import java.util.Random;

import net.divinerpg.libs.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IRegistry;
import net.minecraft.util.RegistryDefaulted;
import net.minecraft.world.World;

import cpw.mods.fml.common.registry.GameRegistry;

public class BlockKarosCannon extends BlockContainer {

	public static final IRegistry dispenseBehaviorRegistry = new RegistryDefaulted(new BehaviorDefaultDispenseItem());
	private Random random = new Random();

	public BlockKarosCannon(Material par3) {
		super(par3);
		setBlockUnbreakable();
	}

	public int tickRate(World w) {
		return 4;
	}

	public Item dropItem(int par1, Random par2Random, int par3) {
		return Item.getItemFromBlock(this);
	}

	public void onBlockAdded(World par1World, int par2, int par3, int par4) {
		super.onBlockAdded(par1World, par2, par3, par4);
		this.setDispenserDefaultDirection(par1World, par2, par3, par4);
	}

	private void setDispenserDefaultDirection(World par1World, int par2, int par3, int par4) {
		if (!par1World.isRemote)
		{
			Block block = par1World.getBlock(par2, par3, par4 - 1);
			Block block1 = par1World.getBlock(par2, par3, par4 + 1);
			Block block2 = par1World.getBlock(par2 - 1, par3, par4);
			Block block3 = par1World.getBlock(par2 + 1, par3, par4);
			byte b0 = 3;

			if (block.func_149730_j() && !block1.func_149730_j())
			{
				b0 = 3;
			}

			if (block1.func_149730_j() && !block.func_149730_j())
			{
				b0 = 2;
			}

			if (block2.func_149730_j() && !block3.func_149730_j())
			{
				b0 = 5;
			}

			if (block3.func_149730_j() && !block2.func_149730_j())
			{
				b0 = 4;
			}

			par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 3);
		}
	}

	public void dispense(World par1World, int par2, int par3, int par4) {
		this.setDispenserDefaultDirection(par1World, par2, par3, par4);
		this.func_82486_a(par1World, 0, EnumFacing.getFront(par1World.getBlockMetadata(par2, par3, par4)), par2, par3, par4);
	}

	public void func_82486_a(World par0World, int par2, EnumFacing par3EnumFacing, int par3, int par4, int par5) {
		double var5 = par3;
		double var7 = par4;
		double var9 = par5;
		/*EntityKarosCannonShot var11 = new EntityKarosCannonShot(par0World, var5 + 0.5D + par3EnumFacing.getFrontOffsetX(), var7 + 0.5D, var9 + 0.5D + par3EnumFacing.getFrontOffsetZ());
        double var12 = par0World.rand.nextDouble() * 0.1D + 0.9D;
        var11.motionX = (double)par3EnumFacing.getFrontOffsetX() * var12;
        var11.motionY = 0D;
        var11.motionZ = (double)par3EnumFacing.getFrontOffsetZ() * var12;
        var11.motionX += par0World.rand.nextGaussian() * 0.007499999832361937D * (double)par2;
        var11.motionY += 0;
        var11.motionZ += par0World.rand.nextGaussian() * 0.007499999832361937D * (double)par2;
        par0World.spawnEntityInWorld(var11);*/
	}

	public Block setTextureName(String name) {
		return setBlockTextureName(Reference.PREFIX + name);
	}

	public Block setName(String name) {
		setTextureName(name);
		setBlockName(name);
		GameRegistry.registerBlock(this, name);
		return this;
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityDispenser();
	}
}