package naturix.divinerpg.objects.blocks;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.items.ItemBase;
import naturix.divinerpg.utils.EnumHandler.OreType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class BlockOre extends BlockBase {
	public static final PropertyEnum TYPE = PropertyEnum.create("type", OreType.class);

	public BlockOre(String name) {
		super(Material.ROCK, name);
		setHardness(3f);
		setResistance(5f);
		setCreativeTab(DivineRPG.BlocksTab);
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, OreType.OVERWORLD)); // Default state

	}

	public BlockOre(String name, ItemBase drop) {
		super(Material.ROCK, name);

		setHardness(3f);
		setResistance(5f);
		setCreativeTab(DivineRPG.BlocksTab);
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, OreType.OVERWORLD)); // Default state
	}

	/**
	 * Adds the properties to the block
	 */
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { TYPE });
	}

	/**
	 * Makes sure the block drops the correct version of itself
	 */
	@Override
	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
	}

	/**
	 * Gets the right meta data from the {@link IBlockState}
	 */
	@Override
	public int getMetaFromState(IBlockState state) {
		OreType type = (OreType) state.getValue(TYPE);
		return type.getID();
	}

	/**
	 * Makes sure when you pick block it will work correctly
	 */
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos,
	        EntityPlayer player) {
		return new ItemStack(Item.getItemFromBlock(this), 1, getMetaFromState(state));
	}

	/**
	 * Inherited from the {@link IMetaBlockName}
	 */
	public String getSpecialName(ItemStack stack) {
		return OreType.values()[stack.getItemDamage()].getName();
	}

	/**
	 * Gets the correct {@link IBlockState} from the meta data
	 */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(TYPE, OreType.values()[meta]);
	}

	/**
	 * All the different item variants for the block
	 */
	public void getSubBlocks(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> list) {
		for (int i = 0; i < OreType.values().length; i++) {
			list.add(new ItemStack(itemIn, 1, i));
		}
	}

}