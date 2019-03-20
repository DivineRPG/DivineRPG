package naturix.divinerpg.objects.blocks;

import java.util.Random;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class LeavesBase extends BlockLeaves implements IHasModel {
	public static final PropertyBool DECAYABLE = PropertyBool.create("decayable");
	public static final PropertyBool CHECK_DECAY = PropertyBool.create("check_decay");
	int[] surroundings;
	private Block sapling;

	public LeavesBase(String name) {
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setDefaultState(blockState.getBaseState().withProperty(CHECK_DECAY, true).withProperty(DECAYABLE, true));
		this.setCreativeTab(DRPGCreativeTabs.BlocksTab);

		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	public LeavesBase(String name, Block sapling) {
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(DRPGCreativeTabs.BlocksTab);
		this.sapling = sapling;
		this.setDefaultState(blockState.getBaseState().withProperty(CHECK_DECAY, true).withProperty(DECAYABLE, true));

		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { CHECK_DECAY, DECAYABLE });
	}

	/**
	 * Gets the metadata of the item this Block can drop. This method is called when
	 * the block gets destroyed. It returns the metadata of the dropped item based
	 * on the old metadata of the block.
	 */
	@Override
	public int damageDropped(IBlockState state) {
		return 0;
	}

	@Override
	protected void dropApple(World worldIn, BlockPos pos, IBlockState state, int chance) {
		if (worldIn.rand.nextInt(chance) == 0) {
			spawnAsEntity(worldIn, pos, new ItemStack(Items.APPLE));
		}
	}

	@Nonnull
	@SideOnly(Side.CLIENT)
	@Override
	public BlockRenderLayer getBlockLayer() {
		return Blocks.LEAVES.getBlockLayer();
	}

	/**
	 * Get the Item that this Block should drop when harvested.
	 */
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(sapling);
	}

	/**
	 * Convert the given metadata into a BlockState for this Block
	 */
	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0;

		if (!state.getValue(DECAYABLE)) {
			i |= 4;
		}

		if (state.getValue(CHECK_DECAY)) {
			i |= 8;
		}
		return i;
	}

	@Override
	protected ItemStack getSilkTouchDrop(IBlockState state) {
		return new ItemStack(Item.getItemFromBlock(this));
	}

	@Deprecated
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(DECAYABLE, (meta & 4) == 0).withProperty(CHECK_DECAY,
		        (meta & 8) > 0);
	}

	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		items.add(new ItemStack(this));
	}

	@Override
	public EnumType getWoodType(int meta) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Spawns the block's drops in the worldgen. By the time this is called the
	 * Block has possibly been set to air via Block.removedByPlayer
	 */
	@Override
	public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state,
	        @Nullable TileEntity te, ItemStack stack) {
		if (!worldIn.isRemote && stack.getItem() == Items.SHEARS) {
			player.addStat(StatList.getBlockStats(this));
		} else {
			super.harvestBlock(worldIn, player, pos, state, te, stack);
		}
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return Blocks.LEAVES.isOpaqueCube(state);
	}

	@Override
	public NonNullList<ItemStack> onSheared(ItemStack item, net.minecraft.world.IBlockAccess world, BlockPos pos,
	        int fortune) {
		return NonNullList.withSize(1, new ItemStack(this));
	}

	@Override
	public void registerModels() {
		DivineRPG.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}