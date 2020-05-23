package divinerpg.objects.blocks;

import divinerpg.DivineRPG;
import divinerpg.registry.DivineRPGTabs;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import javax.annotation.Nonnull;

public class BlockModLog extends BlockLog {

	private MapColor mapColor;

	public BlockModLog(String name, @Nonnull MapColor mapColorIn) {
		super();
		setUnlocalizedName(name);
		setRegistryName(DivineRPG.MODID, name);
		setHardness(3.0F);
		setResistance(5);
		this.setCreativeTab(DivineRPGTabs.BlocksTab);
		this.setDefaultState(this.getDefaultState().withProperty(LOG_AXIS, EnumAxis.Y));
		this.setMapColor(mapColorIn);
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

	/**
	 * Defensive helper method used to intercept null map colors.
	 * Private access used to force the map color to be included in the constructor.
	 *
	 * @param mapColorIn the map color to set
	 */
	private void setMapColor(MapColor mapColorIn) {
		if(mapColorIn == null) {
			this.mapColor = Material.WOOD.getMaterialMapColor();
		}
		else {
			this.mapColor = mapColorIn;
		}
	}

	/**
	 * Tells maps to use the map color we set.
	 *
	 * @param state the blockstate
	 * @param worldIn the world
	 * @param pos the block position
	 * @return the map color
	 */
	@Override
	public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return this.mapColor;
	}
}
