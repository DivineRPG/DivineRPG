package naturix.divinerpg.objects.blocks;

import javax.annotation.Nullable;

import naturix.divinerpg.utils.material.EnumBlockType;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockStatue extends BlockMod implements ITileEntityProvider {
	public static final PropertyDirection FACING = BlockHorizontal.FACING;

	public BlockStatue(String name) {
		super(EnumBlockType.ROCK, name, 6.0F);
		this.hasTileEntity = true;
		setHarvestLevel("pickaxe", 0);
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		super.breakBlock(worldIn, pos, state);
		worldIn.removeTileEntity(pos);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return null;
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.INVISIBLE;
	}

	@Override
	public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state,
	        @Nullable TileEntity te, ItemStack stack) {
		super.harvestBlock(worldIn, player, pos, state, (TileEntity) null, stack);
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
	        ItemStack stack) {
		// FIXME
		// Set block to correct statue? This might be expanded to be
	}
}
