package naturix.divinerpg.objects.blocks;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.blocks.itemblock.IMetaName;
import naturix.divinerpg.objects.blocks.itemblock.ItemBlockVariants;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.IHasModel;
import net.minecraft.block.BlockLog;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;

public class LogBase extends BlockLog implements IHasModel, IMetaName {
	protected String name;

	public LogBase(String name) {
		super();
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		this.setCreativeTab(DRPGCreativeTabs.BlocksTab);
		this.setHardness(2);
		this.setSoundType(SoundType.WOOD);
		this.setDefaultState(this.getDefaultState().withProperty(LOG_AXIS, EnumAxis.Y));

		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, LOG_AXIS);
	}

	@Override
	@SuppressWarnings("incomplete-switch")
	public int getMetaFromState(IBlockState state) {
		int i = 0;

		switch (state.getValue(LOG_AXIS)) {
		case X:
			i |= 4;
			break;
		case Z:
			i |= 8;
			break;
		case NONE:
			i |= 12;
		}

		return i;
	}

	@Override
	public String getSpecialName(ItemStack stack) {
		return EnumFacing.Axis.values()[stack.getItemDamage()].getName();
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		IBlockState iblockstate = getDefaultState();

		switch (meta & 12) {
		case 0:
			iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.Y);
			break;
		case 4:
			iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.X);
			break;
		case 8:
			iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.Z);
			break;
		default:
			iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.NONE);
		}

		return iblockstate;
	}

	@Override
	public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
		/*
		 * for(EnumHandler.OreType oreType$enumtype : EnumHandler.OreType.values()) {
		 * list.add(new ItemStack(this, 1, oreType$enumtype.getMeta())); //Just in case
		 * if you wish to have these in here }
		 */
		list.add(new ItemStack(this, 1, 0));
	}

	@Override
	public void registerModels() {
		DivineRPG.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

}
