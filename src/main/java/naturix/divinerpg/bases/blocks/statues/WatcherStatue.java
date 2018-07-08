package naturix.divinerpg.bases.blocks.statues;

import java.util.Random;

import javax.annotation.Nullable;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.bases.blocks.BaseStatue;
import naturix.divinerpg.bases.blocks.statues.tiles.TileWatcher;
import naturix.divinerpg.utils.models.DivineModel;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import scala.reflect.internal.Trees.This;

public class WatcherStatue extends BaseStatue {
	
	public WatcherStatue(String name) {
		super(Material.ROCK, name);
		}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		return false;
	}
	@Override
	public Class<TileWatcher> getTileEntityClass() {
		return TileWatcher.class;
	}
	
	@Nullable
	@Override
	public TileWatcher createTileEntity(World world, IBlockState state) {
		return new TileWatcher();
	}
}