package naturix.divinerpg.objects.blocks;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.blocks.itemblock.IMetaName;
import naturix.divinerpg.objects.blocks.itemblock.ItemBlockVariants;
import naturix.divinerpg.objects.items.ItemBase;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.IHasModel;
import naturix.divinerpg.utils.handlers.EnumHandler;
import naturix.divinerpg.utils.handlers.EnumHandler.OreType;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class BlockOre extends Block implements IHasModel, IMetaName{
	protected String name;
	public static final PropertyEnum TYPE = PropertyEnum.create("type", OreType.class);

	public BlockOre(String name) {
		super(Material.ROCK);
		setUnlocalizedName(name);
		setRegistryName(name);
		this.name=name;
		setHardness(3f);
		setResistance(5f);
		setCreativeTab(DivineRPG.BlocksTab);
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, OreType.OVERWORLD));

		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));

	}

	public BlockOre(String name, ItemBase drop) {
		super(Material.ROCK);
		setUnlocalizedName(name);
		setRegistryName(name);
		setHardness(3f);
		setResistance(5f);
		setCreativeTab(DivineRPG.BlocksTab);
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, OreType.OVERWORLD));

		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));

	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { TYPE });
	}

	@Override
	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((EnumHandler.OreType)state.getValue(TYPE)).getMeta();
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {

		return new ItemStack(Item.getItemFromBlock(this), 1, getMetaFromState(world.getBlockState(pos)));
	}

	@Override
	public void registerModels() {
		for(int i = 0; i < OreType.values().length; i++)
		{
			DivineRPG.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i, this.name + "_" + OreType.values()[i].getName(), "inventory");
		}
	}

	@Override
	public String getSpecialName(ItemStack stack) {
		return OreType.values()[stack.getItemDamage()].getName();
	}

	/**
	 * Gets the correct {@link IBlockState} from the meta data
	 */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(TYPE, EnumHandler.OreType.byMetadata(meta));
	}

	/**
	 * All the different item variants for the block
	 */
	public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
		/*for(EnumHandler.OreType oreType$enumtype : EnumHandler.OreType.values()) {
			list.add(new ItemStack(this, 1, oreType$enumtype.getMeta()));  //Just in case if you wish to have these in here
		}*/
		list.add(new ItemStack(this, 1, 0));
	}

}