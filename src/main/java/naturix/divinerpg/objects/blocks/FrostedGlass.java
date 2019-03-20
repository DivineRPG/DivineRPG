package naturix.divinerpg.objects.blocks;

import naturix.divinerpg.registry.DRPGCreativeTabs;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;

/**
 * Created by LiteWolf101 on Jan /28/2019
 */
public class FrostedGlass extends BlockBase {
	protected String name;

	public FrostedGlass(String name) {
		super(Material.GLASS, name);
		setSoundType(SoundType.GLASS);
		this.setCreativeTab(DRPGCreativeTabs.BlocksTab);
		this.setHardness(1);
		this.lightOpacity = 0;
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}

	@Override
	@SuppressWarnings("deprecation")
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

	@Override
	@SuppressWarnings("deprecation")
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	@SuppressWarnings("deprecation")
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

}
