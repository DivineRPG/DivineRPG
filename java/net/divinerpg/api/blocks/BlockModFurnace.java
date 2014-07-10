package net.divinerpg.api.blocks;

import java.util.Random;

import net.divinerpg.DivineRPG;
import net.divinerpg.api.entity.tileentity.TileEntityModFurnace;
import net.divinerpg.client.GuiHandler;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.blocks.IceikaBlocks;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class BlockModFurnace extends BlockContainer {

	protected boolean active;
	protected static boolean keepInventory;
	protected Random rand = new Random();
	private int guiID;

	public BlockModFurnace(String name, boolean act, int GuiID) {
		super(Material.rock);
		setStepSound(Block.soundTypeStone);
		if(!act) setCreativeTab(DivineRPGTabs.blocks);
		setBlockName(name);
		GameRegistry.registerBlock(this, name);
		LangRegistry.addBlock(this);
		active = act;
		guiID = GuiID;
		if(act) setLightLevel(0.875F);
	}
	
	@Override
	public Item getItemDropped(int i, Random r, int j) {
		return Util.toItem(this);
	}

	@Override
	public void onBlockAdded(World w, int x, int y, int z) {
		super.onBlockAdded(w, x, y, z);
		if(!w.isRemote) {
			int meta = 3;
			Block block = w.getBlock(x, y, z - 1), block1 = w.getBlock(x, y, z + 1), block2 = w.getBlock(x - 1, y, z), block3 = w.getBlock(x + 1, y, z);
			if(block.func_149730_j() && !block1.func_149730_j()) meta = 3;
			if(block1.func_149730_j() && !block.func_149730_j()) meta = 2;
			if(block2.func_149730_j() && !block3.func_149730_j()) meta = 5;
			if(block3.func_149730_j() && !block2.func_149730_j()) meta = 4;
			w.setBlockMetadataWithNotify(x, y, z, meta, 2);
		}
	}

	@Override
	public boolean onBlockActivated(World w, int x, int y, int z, EntityPlayer p, int i, float j, float k, float f) {
		TileEntityModFurnace furnace  = (TileEntityModFurnace)w.getTileEntity(x, y, z);
		if(!w.isRemote && furnace != null){
			if(!p.isSneaking()){
				p.openGui(DivineRPG.instance, guiID, w, x, y, z);
			}
		}
		return false;
	}
	
	public static void updateActiveStates(boolean active, World w, int x, int y, int z) {
		int meta = w.getBlockMetadata(x, y, z);
		TileEntity tileentity = w.getTileEntity(x, y, z);
		keepInventory = true;
		if(active) w.setBlock(x, y, z, IceikaBlocks.coalstoneFurnaceOn);
		else w.setBlock(x, y, z, IceikaBlocks.coalstoneFurnace);
		keepInventory = false;
		w.setBlockMetadataWithNotify(x, y, z, meta, 2);
		if(tileentity != null) {
			tileentity.validate();
			w.setTileEntity(x, y, z, tileentity);
		}
	}

	@Override
	public void onBlockPlacedBy(World w, int x, int y, int z, EntityLivingBase living, ItemStack item) {
		int meta = MathHelper.floor_double((double)(living.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		if(meta == 0) w.setBlockMetadataWithNotify(x, y, z, 2, 2);
		if(meta == 1) w.setBlockMetadataWithNotify(x, y, z, 5, 2);
		if(meta == 2) w.setBlockMetadataWithNotify(x, y, z, 3, 2);
		if(meta == 3) w.setBlockMetadataWithNotify(x, y, z, 4, 2);
		if(item.hasDisplayName()) ((TileEntityModFurnace)w.getTileEntity(x, y, z)).setCustomName(item.getDisplayName());
	}

	@Override
	public void breakBlock(World w, int x, int y, int z, Block b, int meta) {
		if(!keepInventory) {
			TileEntityModFurnace entity = (TileEntityModFurnace)w.getTileEntity(x, y, z);

			if(entity != null) {
				for(int i1 = 0; i1 < entity.getSizeInventory(); ++i1) {
					ItemStack itemstack = entity.getStackInSlot(i1);
					if(itemstack != null) {
						float f = this.rand.nextFloat() * 0.8F + 0.1F;
						float f1 = this.rand.nextFloat() * 0.8F + 0.1F;
						float f2 = this.rand.nextFloat() * 0.8F + 0.1F;

						while(itemstack.stackSize > 0) {
							int j1 = this.rand.nextInt(21) + 10;
							if(j1 > itemstack.stackSize) j1 = itemstack.stackSize;
							itemstack.stackSize -= j1;
							EntityItem entityitem = new EntityItem(w, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));
							if(itemstack.hasTagCompound()) entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
							float f3 = 0.05F;
							entityitem.motionX = (double)((float)this.rand.nextGaussian() * f3);
							entityitem.motionY = (double)((float)this.rand.nextGaussian() * f3 + 0.2F);
							entityitem.motionZ = (double)((float)this.rand.nextGaussian() * f3);
							w.spawnEntityInWorld(entityitem);
						}
					}
				}
				w.func_147453_f(x, y, z, b);
			}
		}
		super.breakBlock(w, x, y, z, b, meta);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World w, int x, int y, int z, Random r) {
		if(active) {
			int meta = w.getBlockMetadata(x, y, z);
			float f = (float)x + 0.5F;
			float f1 = (float)y + 0.0F + r.nextFloat() * 6.0F / 16.0F;
			float f2 = (float)z + 0.5F;
			float f3 = 0.52F;
			float f4 = r.nextFloat() * 0.6F - 0.3F;

			if(meta == 4) {
				w.spawnParticle("smoke", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
				w.spawnParticle("flame", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
			}
			else if(meta == 5) {
				w.spawnParticle("smoke", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
				w.spawnParticle("flame", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
			}
			else if(meta == 2) {
				w.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
				w.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
			}
			else if(meta == 3) {
				w.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
				w.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
			}
		}
	}

	@Override
	public Item getItem(World w, int x, int y, int z) {
		return Util.toItem(this);
	}
}