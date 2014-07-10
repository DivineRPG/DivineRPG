package net.divinerpg.api.blocks;

import java.util.ArrayList;
import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LangRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public abstract class BlockModCrop extends BlockBush implements IGrowable{

	@SideOnly(Side.CLIENT)
	private IIcon[] icons;
	private int amountOfStages;
	private String cropName;

	public BlockModCrop(String name, int stages, String crop) {
		this.setTickRandomly(true);
		float f = 0.5F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
		this.setCreativeTab((CreativeTabs)null);
		this.setHardness(0.0F);
		this.setStepSound(soundTypeGrass);
		this.disableStats();
		GameRegistry.registerBlock(this, name);
		LangRegistry.addBlock(this);
		amountOfStages = stages;
		cropName = crop;
	}


	@Override
	protected boolean canPlaceBlockOn(Block block) {
		return block == Blocks.farmland;
	}

	@Override
	public void updateTick(World w, int x, int y, int z, Random r) {
		super.updateTick(w, x, y, z, r);
		if(w.getBlockLightValue(x, y + 1, z) >= 9) {
			int l = w.getBlockMetadata(x, y, z);
			if(l < amountOfStages) {
				float f = this.grow(w, x, y, z);
				if(r.nextInt((int)(25.0F / f) + 1) == 0) {
					++l;
					w.setBlockMetadataWithNotify(x, y, z, l, 2);
				}
			}
		}
	}

	public void boneMeal(World w, int x, int y, int z) {
		int meta = w.getBlockMetadata(x, y, z) + MathHelper.getRandomIntegerInRange(w.rand, 2, 5);
		if(meta > amountOfStages) 
			meta = amountOfStages;
		w.setBlockMetadataWithNotify(x, y, z, meta, 2);
	}

	private float grow(World w, int x, int y, int z) {
		float f = 1.0F;
		Block block = w.getBlock(x, y, z - 1);
		Block block1 = w.getBlock(x, y, z + 1);
		Block block2 = w.getBlock(x - 1, y, z);
		Block block3 = w.getBlock(x + 1, y, z);
		Block block4 = w.getBlock(x - 1, y, z - 1);
		Block block5 = w.getBlock(x + 1, y, z - 1);
		Block block6 = w.getBlock(x + 1, y, z + 1);
		Block block7 = w.getBlock(x - 1, y, z + 1);
		boolean flag = block2 == this || block3 == this;
		boolean flag1 = block == this || block1 == this;
		boolean flag2 = block4 == this || block5 == this || block6 == this || block7 == this;
		for(int l = x - 1; l <= x + 1; ++l) {
			for(int i1 = z - 1; i1 <= z + 1; ++i1) {
				float f1 = 0.0F;
				if(w.getBlock(l, y - 1, i1).canSustainPlant(w, l, y - 1, i1, ForgeDirection.UP, this)) {
					f1 = 1.0F;
					if (w.getBlock(l, y - 1, i1).isFertile(w, l, y - 1, i1))
						f1 = 3.0F;
				}
				if(l != x || i1 != z)
					f1 /= 4.0F;
				f += f1;
			}
		}
		if(flag2 || flag && flag1)
			f /= 2.0F;		
		return f;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int p_149691_1_, int meta) {
		if (meta < 0 || meta > amountOfStages) meta = amountOfStages;
		return this.icons[meta];
	}

	@Override
	public boolean func_149851_a(World w, int x, int y, int z, boolean b) {
		return w.getBlockMetadata(x, y, z) != amountOfStages;
	}

	@Override
	public boolean func_149852_a(World w, Random r, int x, int y, int z) {
		return true;
	}

	@Override
	public void dropBlockAsItemWithChance(World w, int x, int y, int z, int m, float f, int i) {
		super.dropBlockAsItemWithChance(w, x, y, z, m, f, 0);
	}

	@Override
	public Item getItemDropped(int meta, Random r, int i) {
		return meta == amountOfStages ? this.getDropItem() : this.getSeeds();
	}

	@Override
	public int quantityDropped(Random r) {
		return r.nextInt(2) + 1;
	}

	public Item getDropItem(){
		return null;
	}

	public Item getSeeds(){
		return null;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getItem(World w, int x, int y, int z) {
		return this.getSeeds();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon) {
		this.icons = new IIcon[amountOfStages + 1];
		for(int i = 0; i < this.icons.length; ++i)
			this.icons[i] = icon.registerIcon(Reference.PREFIX + cropName + "_" + i);
	}

	@Override
	public void func_149853_b(World w, Random r, int x, int y, int z) {
		this.boneMeal(w, x, y, z);
	}

	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
		ArrayList<ItemStack> ret = super.getDrops(world, x, y, z, metadata, fortune);
		if(metadata >= amountOfStages) {
			for(int i = 0; i < 3 + fortune; i++) {
				if(world.rand.nextInt(15) <= metadata)
					ret.add(new ItemStack(this.getSeeds(), 1, 0));
			}
		}
		return ret;
	}
}