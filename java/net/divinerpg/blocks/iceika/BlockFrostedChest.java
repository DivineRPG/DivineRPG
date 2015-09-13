package net.divinerpg.blocks.iceika;

import java.util.ArrayList;
import java.util.Random;

import net.divinerpg.blocks.iceika.tileentity.TileEntityFrostedChest;
import net.divinerpg.libs.DivineRPGAchievements;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.blocks.IceikaBlocks;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.divinerpg.utils.items.IceikaItems;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockFrostedChest extends BlockContainer {

	private Random rand = new Random();
	private boolean dropsSnowflake;

	public BlockFrostedChest(String name, boolean dropsSnowflake) {
		super(Material.wood);
		setCreativeTab(DivineRPGTabs.blocks);
		setStepSound(soundTypeGlass);
		setTextureName("ice");
		setUnlocalizedName(name);
		GameRegistry.registerBlock(this, name);
		LangRegistry.addBlock(this);
		this.dropsSnowflake = dropsSnowflake;
	}
	
	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int meta, int fortune) {
		ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
		if(this.dropsSnowflake) {
			drops.add(new ItemStack(IceikaItems.snowflake, 1, 0));
			if(this.rand.nextInt(20) == 0) drops.add(new ItemStack(IceikaBlocks.decorativeFrostedChest, 1, 0));
		} else drops.add(new ItemStack(IceikaBlocks.decorativeFrostedChest, 1, 0));
		
		return drops;
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
	public boolean onBlockActivated(World w, int x, int y, int z, EntityPlayer p, int i, float f, float f1, float f2) {
		if (w.isRemote) {
			return true;
		} else {
			IInventory iinventory = getInventory(w, x, y, z);
			if (iinventory != null) {
				p.displayGUIChest(iinventory);
			}
			return true;
		}
	}

	@Override
	public void breakBlock(World w, int x, int y, int z, Block b, int i) {
		TileEntityFrostedChest items = (TileEntityFrostedChest)w.getTileEntity(x, y, z);
		if(items != null) {
			ItemStack itemstack = null;
			for(int i1 = 0; i1 < items.getSizeInventory(); i1++) {
				itemstack = items.getStackInSlot(i1);
				if(itemstack != null) {
					float f = rand.nextFloat() * 0.8F + 0.1F;
					float f1 = rand.nextFloat() * 0.8F + 0.1F;
					float f3 = 0.05F;
					EntityItem entityitem;

					for(float f2 = rand.nextFloat() * 0.8F + 0.1F; itemstack.stackSize > 0; w.spawnEntityInWorld(entityitem)) {
						int j1 = rand.nextInt(21) + 10;
						if(j1 > itemstack.stackSize)
							j1 = itemstack.stackSize;

						itemstack.stackSize -= j1;
						entityitem = new EntityItem(w, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(itemstack.getItem(), j1, itemstack.getMetadata()));
						entityitem.motionX = (double)((float)rand.nextGaussian() * f3);
						entityitem.motionY = (double)((float)rand.nextGaussian() * f3 + 0.2F);
						entityitem.motionZ = (double)((float)rand.nextGaussian() * f3);
					}
				}
			}
			w.updateNeighborsAboutBlockChange(x, y, z, b);
		}
		super.breakBlock(w, x, y, z, b, i);
	}
	
	@Override
	public void harvestBlock(World w, EntityPlayer player, int x, int y, int z, int meta) {
		super.harvestBlock(w, player, x, y, z, meta);
		if(this == IceikaBlocks.frostedChest)player.triggerAchievement(DivineRPGAchievements.frozenGoods);
    }
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess w, int x, int y, int z) {
		setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
	}

	private IInventory getInventory(World w, int x, int y, int z) {
		Object o = (TileEntityFrostedChest)w.getTileEntity(x, y, z);
		return (IInventory)o;
	}

	@Override
	public void onBlockPlacedBy(World w, int x, int y, int z, EntityLivingBase e, ItemStack i) {
		int l = MathHelper.floor_double((double)(e.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		int i1 = w.getBlockMetadata(x, y, z);
		++l;
		l %= 4;

		if (l == 0) 
			w.setBlockMetadataWithNotify(x, y, z, 4, 2);

		if (l == 1) 
			w.setBlockMetadataWithNotify(x, y, z, 2, 2);

		if (l == 2) 
			w.setBlockMetadataWithNotify(x, y, z, 5, 2);

		if (l == 3) 
			w.setBlockMetadataWithNotify(x, y, z, 0, 2);
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityFrostedChest();
	}
}