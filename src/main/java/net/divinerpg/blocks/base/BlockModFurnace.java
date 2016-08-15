package net.divinerpg.blocks.base;

import java.util.Random;

import net.divinerpg.DivineRPG;
import net.divinerpg.blocks.base.tileentity.TileEntityInfiniteFurnace;
import net.divinerpg.blocks.base.tileentity.TileEntityModFurnace;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.blocks.IceikaBlocks;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
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
		setUnlocalizedName(name);
		GameRegistry.registerBlock(this, name);
		LangRegistry.addBlock(this);
        setHardness(3.5F);
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
			if(block.isFullBlock() && !block1.isFullBlock()) meta = 3;
			if(block1.isFullBlock() && !block.isFullBlock()) meta = 2;
			if(block2.isFullBlock() && !block3.isFullBlock()) meta = 5;
			if(block3.isFullBlock() && !block2.isFullBlock()) meta = 4;
			w.setBlockMetadataWithNotify(x, y, z, meta, 2);
		}
	}

	@Override
	public boolean onBlockActivated(World w, int x, int y, int z, EntityPlayer p, int i, float j, float k, float f) {
		TileEntity furnace  = w.getTileEntity(x, y, z);
		if(furnace != null){
			if(!p.isSneaking()){
				if(!w.isRemote) p.openGui(DivineRPG.instance, guiID, w, x, y, z);
				return true;
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
		if(item.hasDisplayName()) ((TileEntityModFurnace)w.getTileEntity(x, y, z)).setCustomInventoryName(item.getDisplayName());
	}

	@Override
	public void breakBlock(World w, int x, int y, int z, Block b, int meta) {
		if(!keepInventory) {
			if(w.getTileEntity(x, y, z) instanceof TileEntityModFurnace) {
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
							EntityItem entityitem = new EntityItem(w, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(itemstack.getItem(), j1, itemstack.getMetadata()));
							if(itemstack.hasTagCompound()) entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
							float f3 = 0.05F;
							entityitem.motionX = (double)((float)this.rand.nextGaussian() * f3);
							entityitem.motionY = (double)((float)this.rand.nextGaussian() * f3 + 0.2F);
							entityitem.motionZ = (double)((float)this.rand.nextGaussian() * f3);
							w.spawnEntityInWorld(entityitem);
						}
					}
				}
				w.updateNeighborsAboutBlockChange(x, y, z, b);
			}
		}else if(w.getTileEntity(x, y, z) instanceof TileEntityInfiniteFurnace) {
			TileEntityInfiniteFurnace entity = (TileEntityInfiniteFurnace)w.getTileEntity(x, y, z);

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
							EntityItem entityitem = new EntityItem(w, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(itemstack.getItem(), j1, itemstack.getMetadata()));
							if(itemstack.hasTagCompound()) entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
							float f3 = 0.05F;
							entityitem.motionX = (double)((float)this.rand.nextGaussian() * f3);
							entityitem.motionY = (double)((float)this.rand.nextGaussian() * f3 + 0.2F);
							entityitem.motionZ = (double)((float)this.rand.nextGaussian() * f3);
							w.spawnEntityInWorld(entityitem);
						}
					}
				}
				w.updateNeighborsAboutBlockChange(x, y, z, b);
			}
		}
		}
		super.breakBlock(w, x, y, z, b, meta);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World w, int x, int y, int z, Random r) {
		int meta = w.getBlockMetadata(x, y, z);
		if(active || meta >= 8) {
			float f = (float)x + 0.5F;
			float f1 = (float)y + 0.0F + r.nextFloat() * 6.0F / 16.0F;
			float f2 = (float)z + 0.5F;
			float f3 = 0.52F;
			float f4 = r.nextFloat() * 0.6F - 0.3F;

			if(meta == 4 || meta == 9) {
				w.spawnParticle("smoke", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
				w.spawnParticle("flame", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
			}
			else if(meta == 5 || meta == 11) {
				w.spawnParticle("smoke", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
				w.spawnParticle("flame", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
			}
			else if(meta == 2 || meta == 8) {
				w.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
				w.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
			}
			else if(meta == 3 || meta == 10) {
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