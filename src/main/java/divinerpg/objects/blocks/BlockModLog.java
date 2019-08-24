package divinerpg.objects.blocks;

import divinerpg.DivineRPG;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.ModBlocks;
import divinerpg.registry.ModItems;
import divinerpg.utils.IHasModel;
import net.minecraft.block.BlockLog;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockModLog extends BlockLog implements IHasModel {

	public BlockModLog(String name) {
		super();
		setUnlocalizedName(name);
		setRegistryName(name);
		setHardness(3.0F);
		setResistance(5);
		this.setCreativeTab(DivineRPGTabs.BlocksTab);
		this.setDefaultState(this.getDefaultState().withProperty(LOG_AXIS, EnumAxis.Y));

		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, LOG_AXIS);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		switch (state.getValue(LOG_AXIS)) {
		case X:
			return 4;
		case Y:
			return 0;
		case Z:
			return 8;
		case NONE:
		default:
			return 12;
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		switch (meta) {
		case 0:
			return getDefaultState().withProperty(LOG_AXIS, EnumAxis.Y);
		case 4:
			return getDefaultState().withProperty(LOG_AXIS, EnumAxis.X);
		case 8:
			return getDefaultState().withProperty(LOG_AXIS, EnumAxis.Z);
		case 12:
		default:
			return getDefaultState().withProperty(LOG_AXIS, EnumAxis.NONE);
		}
	}

	@Override
	public void registerModels() {
		DivineRPG.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
