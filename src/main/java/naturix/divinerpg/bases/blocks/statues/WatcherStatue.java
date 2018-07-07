package naturix.divinerpg.bases.blocks.statues;

import javax.annotation.Nullable;

import naturix.divinerpg.bases.blocks.BaseStatue;
import naturix.divinerpg.bases.blocks.statues.tiles.TileWatcher;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class WatcherStatue extends BaseStatue {
	private static float x1;
	private static float y1;
	private static float z1;
	private static float x2;
	private static float y2;
	private static float z2;
	public WatcherStatue(String name, float x1, float y1, float z1, float x2, float y2, float z2) {
		super(Material.ROCK, name);
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.z1 = z1;
		this.z2 = z2;
	}
	public WatcherStatue(String name) {
		super(Material.ROCK, name);
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		return false;

	}
	public static final AxisAlignedBB BLOCK_AABB = new AxisAlignedBB(x1, y1, z1, x2, y2, z2);
	 @Override
	    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
	        return BLOCK_AABB;
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