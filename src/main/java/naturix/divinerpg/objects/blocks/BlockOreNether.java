package naturix.divinerpg.objects.blocks;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.blocks.itemblock.IMetaName;
import naturix.divinerpg.objects.blocks.itemblock.ItemBlockVariants;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.IHasModel;
import naturix.divinerpg.utils.handlers.EnumHandler.OreType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BlockOreNether extends BlockBase implements IHasModel, IMetaName {
	// public static final PropertyEnum TYPE = PropertyEnum.create("type",
	// OreType.class);

	public BlockOreNether(String name) {
		super(Material.ROCK, name);
		setHardness(3f);
		setResistance(5f);
		this.setCreativeTab(DRPGCreativeTabs.BlocksTab);
		// this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE,
		// OreType.NETHER)); // Default state

		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public String getSpecialName(ItemStack stack) {
		return OreType.values()[stack.getItemDamage()].getName();
	}

	/**
	 * @Override protected BlockStateContainer createBlockState() { return new
	 *           BlockStateContainer(this, new IProperty[] { TYPE }); }
	 * 
	 * @Override public int damageDropped(IBlockState state) { return
	 *           getMetaFromState(state); }
	 * 
	 * @Override public int getMetaFromState(IBlockState state) { OreType type =
	 *           (OreType) state.getValue(TYPE); return type.getID(); }
	 * 
	 * @Override public ItemStack getPickBlock(IBlockState state, RayTraceResult
	 *           target, World world, BlockPos pos, EntityPlayer player) { return
	 *           new ItemStack(Item.getItemFromBlock(this), 1,
	 *           getMetaFromState(state)); }
	 * 
	 * @Override public IBlockState getStateFromMeta(int meta) { return
	 *           this.getDefaultState().withProperty(TYPE, OreType.values()[meta]);
	 *           }
	 * 
	 *           public void getSubBlocks(Item itemIn, CreativeTabs tab,
	 *           NonNullList<ItemStack> list) { for (int i = 0; i <
	 *           OreType.values().length; i++) { list.add(new ItemStack(itemIn, 1,
	 *           i)); } }
	 */

	@Override
	public void registerModels() {
		for (int i = 0; i < OreType.values().length; i++) {
			DivineRPG.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i,
			        this.name + "_" + OreType.values()[i].getName(), "inventory");
		}
	}
}