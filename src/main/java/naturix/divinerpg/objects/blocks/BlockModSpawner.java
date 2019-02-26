package naturix.divinerpg.objects.blocks;

import java.util.Random;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.IHasModel;
import naturix.divinerpg.utils.Reference;
import net.minecraft.block.BlockMobSpawner;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockModSpawner extends BlockMobSpawner implements IHasModel {

	protected String name;
	protected String mobName;

	public BlockModSpawner(String name, String mobName) {
		this.name = name;
		this.mobName = Reference.MODID + "." + mobName;
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(DivineRPG.BlocksTab);
		setHardness(5.0F);
		this.setTickRandomly(true);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}

	@Override
	public TileEntity createNewTileEntity(World world, int par1) {
		TileEntityMobSpawner spawner = new TileEntityMobSpawner();
		NBTTagCompound compound = new NBTTagCompound();
		NBTTagCompound compound2 = new NBTTagCompound();
		spawner.writeToNBT(compound);
		compound2.setString("id", Reference.MODID + ":" + mobName);
		compound.setTag("SpawnData", compound2);
		spawner.readFromNBT(compound);
		spawner.readFromNBT(compound2);
		spawner.markDirty();
		return spawner;
	}

	@Override
	public void dropBlockAsItemWithChance(World world, BlockPos pos, IBlockState state, float chance, int fortune) {
		super.dropBlockAsItemWithChance(world, pos, state, chance, fortune);
		int var8 = 15 + world.rand.nextInt(15) + world.rand.nextInt(15);
		this.dropXpOnBlockBreak(world, pos, var8);
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

	@Override
	public int quantityDropped(Random par1Random) {
		return 0;
	}

	@Override
	public void registerModels() {
		DivineRPG.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}