package naturix.divinerpg.objects.blocks;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.enums.StatueType;
import naturix.divinerpg.objects.blocks.tile.entity.TileEntityStatue;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.utils.material.EnumBlockType;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockStatue extends BlockMod implements ITileEntityProvider {
    public static final PropertyDirection FACING = BlockHorizontal.FACING;
    public StatueType statueType;

    public BlockStatue(String name, StatueType statueType) {
        super(EnumBlockType.ROCK, name, 6.0F);
        this.statueType = statueType;
        this.hasTileEntity = true;
        setHarvestLevel("pickaxe", 0);
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TileEntityStatue(this.statueType);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] { FACING });
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getIndex();
    }

    @Override
    @SuppressWarnings("deprecation")
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.INVISIBLE;
    }

    @Override
    @SuppressWarnings("deprecation")
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY,
            float hitZ, int meta, EntityLivingBase placer) {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    @Override
    @SuppressWarnings("deprecation")
    public IBlockState getStateFromMeta(int meta) {
        EnumFacing enumfacing = EnumFacing.getFront(meta);

        if (enumfacing.getAxis() == EnumFacing.Axis.Y) {
            enumfacing = EnumFacing.NORTH;
        }

        return this.getDefaultState().withProperty(FACING, enumfacing);
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        this.setDefaultFacing(worldIn, pos, state);
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
            ItemStack stack) {
        worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
    }

    @Override
    public void registerModels() {
        DivineRPG.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

    private void setDefaultFacing(World worldIn, BlockPos pos, IBlockState state) {
        if (!worldIn.isRemote) {
            IBlockState iblockstate = worldIn.getBlockState(pos.north());
            IBlockState iblockstate1 = worldIn.getBlockState(pos.south());
            IBlockState iblockstate2 = worldIn.getBlockState(pos.west());
            IBlockState iblockstate3 = worldIn.getBlockState(pos.east());
            EnumFacing enumfacing = state.getValue(FACING);

            if (enumfacing == EnumFacing.NORTH && iblockstate.isFullBlock() && !iblockstate1.isFullBlock()) {
                enumfacing = EnumFacing.SOUTH;
            } else if (enumfacing == EnumFacing.SOUTH && iblockstate1.isFullBlock() && !iblockstate.isFullBlock()) {
                enumfacing = EnumFacing.NORTH;
            } else if (enumfacing == EnumFacing.WEST && iblockstate2.isFullBlock() && !iblockstate3.isFullBlock()) {
                enumfacing = EnumFacing.EAST;
            } else if (enumfacing == EnumFacing.EAST && iblockstate3.isFullBlock() && !iblockstate2.isFullBlock()) {
                enumfacing = EnumFacing.WEST;
            }

            worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
        return state.withRotation(mirrorIn.toRotation(state.getValue(FACING)));
    }

    @Override
    @SuppressWarnings("deprecation")
    public IBlockState withRotation(IBlockState state, Rotation rot) {
        return state.withProperty(FACING, rot.rotate(state.getValue(FACING)));
    }
    
    

	public static final AxisAlignedBB WATCHER_AABB = new AxisAlignedBB(0.3F, 0.0F, 0.3F, 0.7F, 0.5F, 0.7F);
	public static final AxisAlignedBB AYERACO_AABB = new AxisAlignedBB(0.2F, 0.0F, 0.20F, 0.8F, 0.4F, 0.8F);
	public static final AxisAlignedBB TWILIGHT_DEMON_AABB = new AxisAlignedBB(0.2F, 0.0F, 0.20F, 0.8F, 1.0F, 0.8F);
	public static final AxisAlignedBB VAMACHERON_AABB = new AxisAlignedBB(0.2F, 0.0F, 0.20F, 0.8F, 0.7F, 0.8F);
	public static final AxisAlignedBB PARASECTA_AABB = new AxisAlignedBB(0.2F, 0.2F, 0.20F, 0.8F, 1.0F, 0.8F);
	public static final AxisAlignedBB SOUL_FIEND_AABB = new AxisAlignedBB(0.2F, 0.0F, 0.20F, 0.8F, 1.0F, 0.8F);
	@Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		if(this == ModBlocks.theWatcherStatue) {
			return WATCHER_AABB;
		}else if(this == ModBlocks.ayeracoStatue) {
			return AYERACO_AABB;
		}else if(this == ModBlocks.twilightDemonStatue) {
			return TWILIGHT_DEMON_AABB;
		}else if(this == ModBlocks.vamacheronStatue) {
			return VAMACHERON_AABB;
		}else if(this == ModBlocks.parasectaStatue) {
			return PARASECTA_AABB;
		}else if(this == ModBlocks.soulFiendStatue) {
			return SOUL_FIEND_AABB;
		}else {
		return FULL_BLOCK_AABB;
    }
	}
}
