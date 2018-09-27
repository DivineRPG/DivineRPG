package naturix.divinerpg.bases.blocks.portal;

import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.cache.LoadingCache;

import naturix.divinerpg.Config;
import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.dimensions.ModTeleporter;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModDimensions;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.BlockWorldState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerList;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PortalBase extends Block {
	protected String name;
	public static final PropertyEnum<EnumFacing.Axis> AXIS = PropertyEnum.create("axis", EnumFacing.Axis.class, EnumFacing.Axis.X, EnumFacing.Axis.Z);

    protected static final AxisAlignedBB X_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.375D, 1.0D, 1.0D, 0.625D);

    protected static final AxisAlignedBB Z_AABB = new AxisAlignedBB(0.375D, 0.0D, 0.0D, 0.625D, 1.0D, 1.0D);

    protected static final AxisAlignedBB Y_AABB = new AxisAlignedBB(0.375D, 0.0D, 0.375D, 0.625D, 1.0D, 0.625D);

	public PortalBase(String name) {
		super(Material.PORTAL);
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		this.setHardness(2);
		this.setTickRandomly(true);
        this.setResistance(10000000f);
        this.setHardness(1000f);
        this.setLightLevel(0.5f);
	}
	public void registerItemModel(Item itemBlock) {
		DivineRPG.proxy.registerItemRenderer(itemBlock, 0, name);
	}
	
	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}
    public boolean trySpawnPortal(World worldIn, BlockPos pos) {

        Size blockportal$size = new Size(worldIn, pos, EnumFacing.Axis.X);



        if (blockportal$size.isValid() && blockportal$size.portalBlockCount == 0) {

            blockportal$size.placePortalBlocks();

            return true;

        }

        Size blockportal$size1 = new Size(worldIn, pos, EnumFacing.Axis.Z);



        if (blockportal$size1.isValid() && blockportal$size1.portalBlockCount == 0) {

            blockportal$size1.placePortalBlocks();

            return true;

        }

        return false;

    }



    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos,

                                        EnumFacing side) {

        pos = pos.offset(side);

        EnumFacing.Axis enumfacing$axis = null;



        if (blockState.getBlock() == this) {

            enumfacing$axis = blockState.getValue(AXIS);



            if (enumfacing$axis == null) {

                return false;

            }



            if (enumfacing$axis == EnumFacing.Axis.Z && side != EnumFacing.EAST && side != EnumFacing.WEST) {

                return false;

            }



            if (enumfacing$axis == EnumFacing.Axis.X && side != EnumFacing.SOUTH && side != EnumFacing.NORTH) {

                return false;

            }

        }



        boolean flag = blockAccess.getBlockState(pos.west()).getBlock() == this &&

                blockAccess.getBlockState(pos.west(2)).getBlock() != this;

        boolean flag1 = blockAccess.getBlockState(pos.east()).getBlock() == this &&

                blockAccess.getBlockState(pos.east(2)).getBlock() != this;

        boolean flag2 = blockAccess.getBlockState(pos.north()).getBlock() == this &&

                blockAccess.getBlockState(pos.north(2)).getBlock() != this;

        boolean flag3 = blockAccess.getBlockState(pos.south()).getBlock() == this &&

                blockAccess.getBlockState(pos.south(2)).getBlock() != this;

        boolean flag4 = flag || flag1 || enumfacing$axis == EnumFacing.Axis.X;

        boolean flag5 = flag2 || flag3 || enumfacing$axis == EnumFacing.Axis.Z;



        return flag4 && side == EnumFacing.WEST || flag4 && side == EnumFacing.EAST ||

                flag5 && side == EnumFacing.NORTH || flag5 && side == EnumFacing.SOUTH;

    }



    @Override

    public IBlockState getStateFromMeta(int meta) {

        return this.getDefaultState().withProperty(AXIS, (meta & 3) == 2 ? EnumFacing.Axis.Z : EnumFacing.Axis.X);

    }



    @Override

    public int getMetaFromState(IBlockState state) {

        return getMetaForAxis(state.getValue(AXIS));

    }



    public static int getMetaForAxis(EnumFacing.Axis axis) {

        if (axis == EnumFacing.Axis.X) {

            return 1;

        }

        return axis == EnumFacing.Axis.Z ? 2 : 0;

    }



    /**
     * Returns the blockstate with the given rotation from the passed blockstate. If inapplicable, returns the passed
     * blockstate.
     */

    @Override
    public IBlockState withRotation(IBlockState state, Rotation rot) {

        switch (rot) {

            case COUNTERCLOCKWISE_90:

            case CLOCKWISE_90:



                switch (state.getValue(AXIS)) {

                    case X:

                        return state.withProperty(AXIS, EnumFacing.Axis.Z);

                    case Z:

                        return state.withProperty(AXIS, EnumFacing.Axis.X);

                    default:

                        return state;

                }



            default:

                return state;

        }

    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {

        return false;

    }



    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

        switch (state.getValue(AXIS)) {

            case X:

                return X_AABB;

            case Z:

                return Z_AABB;

            default:

                return Y_AABB;

        }

    }



    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess p_193383_1_, IBlockState p_193383_2_, BlockPos p_193383_3_,

                                            EnumFacing p_193383_4_) {

        return BlockFaceShape.UNDEFINED;

    }



    @Override
    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {

        return NULL_AABB;

    }


    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {

        if (rand.nextInt(100) == 0) {

            worldIn.playSound((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D,

                    SoundEvents.BLOCK_PORTAL_AMBIENT, SoundCategory.BLOCKS, 0.5F, rand.nextFloat() * 0.4F + 0.8F,

                    false);

        }

        for (int i = 0; i < 16; ++i) {
            double d0 = (double) ((float) pos.getX() + rand.nextFloat());

            double d1 = (double) ((float) pos.getY() + rand.nextFloat());

            double d2 = (double) ((float) pos.getZ() + rand.nextFloat());

            double d3 = ((double) rand.nextFloat() - 0.5D) * 0.5D;

            double d4 = ((double) rand.nextFloat() - 0.5D) * 0.5D;

            double d5 = ((double) rand.nextFloat() - 0.5D) * 0.5D;

            int j = rand.nextInt(2) * 2 - 1;

            if (worldIn.getBlockState(pos.west()).getBlock() != this &&

                    worldIn.getBlockState(pos.east()).getBlock() != this) {

                d0 = (double) pos.getX() + 0.5D + 0.25D * (double) j;

                d3 = (double) (rand.nextFloat() * 2.0F * (float) j);

            } else {

                d2 = (double) pos.getZ() + 0.5D + 0.25D * (double) j;

                d5 = (double) (rand.nextFloat() * 2.0F * (float) j);
            }
            //Minecraft.getMinecraft().effectRenderer.addEffect(new ParticleIceCloud(worldIn, d0, d1, d2, d3, d4, d5));
        }

    }



    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {

        EnumFacing.Axis enumfacing$axis = state.getValue(AXIS);



        if (enumfacing$axis == EnumFacing.Axis.X) {

            Size blockportal$size = new Size(worldIn, pos, EnumFacing.Axis.X);



            if (!blockportal$size.isValid() ||

                    blockportal$size.portalBlockCount < blockportal$size.width * blockportal$size.height) {

                worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());

            }

        } else if (enumfacing$axis == EnumFacing.Axis.Z) {

            Size blockportal$size1 = new Size(worldIn, pos, EnumFacing.Axis.Z);



            if (!blockportal$size1.isValid() ||

                    blockportal$size1.portalBlockCount < blockportal$size1.width * blockportal$size1.height) {

                worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());

            }

        }

    }



    /**
     * Returns the quantity of items to drop on block destruction.
     */

    @Override
    public int quantityDropped(Random random) {

        return 0;

    }



    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {

        return BlockRenderLayer.TRANSLUCENT;

    }



    /**
     * Called When an Entity Collided with the Block
     */

    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {

        if (!entityIn.isRiding() && !entityIn.isBeingRidden() && entityIn.isNonBoss()) {

            MinecraftServer server = worldIn.getMinecraftServer();

            if (server != null && entityIn.timeUntilPortal <= 0) {

                PlayerList playerList = server.getPlayerList();

                int i = entityIn.dimension == DimensionType.OVERWORLD.getId() ? ModDimensions.edenDimension.getId() : DimensionType.OVERWORLD.getId();

                ModTeleporter teleporter = new ModTeleporter(server.getWorld(i), Config.edenDimensionId, ModBlocks.rockDivine, ModBlocks.portalEden);

                entityIn.timeUntilPortal = entityIn.getPortalCooldown() * 2;

                teleporter.placeInPortal(entityIn,1);

                if (entityIn instanceof EntityPlayerMP) {

                    playerList.transferPlayerToDimension((EntityPlayerMP) entityIn, i, teleporter);

                } else {

                    int origin = entityIn.dimension;

                    entityIn.dimension = i;

                    worldIn.removeEntityDangerously(entityIn);


                    entityIn.isDead = false;


                    playerList.transferEntityToWorld(entityIn, origin, server.getWorld(origin), server.getWorld(i),
                            teleporter);

                }


            }else {
                entityIn.timeUntilPortal = Math.max(entityIn.getPortalCooldown(), 100);
            }

        }

    }



    @Override
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {

        return ItemStack.EMPTY;

    }



    @Override
    protected BlockStateContainer createBlockState() {

        return new BlockStateContainer(this, AXIS);

    }



    public BlockPattern.PatternHelper createPatternHelper(World worldIn, BlockPos p_181089_2_) {

        EnumFacing.Axis enumfacing$axis = EnumFacing.Axis.Z;

        Size blockportal$size = new Size(worldIn, p_181089_2_, EnumFacing.Axis.X);

        LoadingCache<BlockPos, BlockWorldState> loadingcache = BlockPattern.createLoadingCache(worldIn, true);



        if (!blockportal$size.isValid()) {

            enumfacing$axis = EnumFacing.Axis.X;

            blockportal$size = new Size(worldIn, p_181089_2_, EnumFacing.Axis.Z);

        }

        if (!blockportal$size.isValid()) {

            return new BlockPattern.PatternHelper(p_181089_2_, EnumFacing.NORTH, EnumFacing.UP, loadingcache, 1, 1, 1);

        }

        int[] aint = new int[EnumFacing.AxisDirection.values().length];

        EnumFacing enumfacing = blockportal$size.rightDir.rotateYCCW();

        BlockPos blockpos = blockportal$size.bottomLeft.up(blockportal$size.getHeight() - 1);



        for (EnumFacing.AxisDirection enumfacing$axisdirection : EnumFacing.AxisDirection.values()) {

            BlockPattern.PatternHelper blockpattern$patternhelper = new BlockPattern.PatternHelper(

                    enumfacing.getAxisDirection() == enumfacing$axisdirection ? blockpos :

                            blockpos.offset(blockportal$size.rightDir, blockportal$size.getWidth() - 1),

                    EnumFacing.getFacingFromAxis(enumfacing$axisdirection, enumfacing$axis), EnumFacing.UP,

                    loadingcache, blockportal$size.getWidth(), blockportal$size.getHeight(), 1);



            for (int i = 0; i < blockportal$size.getWidth(); ++i) {

                for (int j = 0; j < blockportal$size.getHeight(); ++j) {

                    BlockWorldState blockworldstate = blockpattern$patternhelper.translateOffset(i, j, 1);



                    if (blockworldstate.getBlockState() != null &&

                            blockworldstate.getBlockState().getMaterial() != Material.AIR) {

                        ++aint[enumfacing$axisdirection.ordinal()];

                    }

                }

            }

        }



        EnumFacing.AxisDirection enumfacing$axisdirection1 = EnumFacing.AxisDirection.POSITIVE;



        for (EnumFacing.AxisDirection enumfacing$axisdirection2 : EnumFacing.AxisDirection.values()) {

            if (aint[enumfacing$axisdirection2.ordinal()] < aint[enumfacing$axisdirection1.ordinal()]) {

                enumfacing$axisdirection1 = enumfacing$axisdirection2;

            }

        }



        return new BlockPattern.PatternHelper(enumfacing.getAxisDirection() == enumfacing$axisdirection1 ? blockpos :

                blockpos.offset(blockportal$size.rightDir, blockportal$size.getWidth() - 1),

                EnumFacing.getFacingFromAxis(enumfacing$axisdirection1, enumfacing$axis), EnumFacing.UP, loadingcache,

                blockportal$size.getWidth(), blockportal$size.getHeight(), 1);

    }



    public static class Size {



        private final World world;

        private final EnumFacing.Axis axis;

        private final EnumFacing rightDir;

        private final EnumFacing leftDir;

        private int portalBlockCount;

        private BlockPos bottomLeft;

        private int height;

        private int width;



        public Size(World worldIn, BlockPos p_i45694_2_, EnumFacing.Axis p_i45694_3_) {

            this.world = worldIn;

            this.axis = p_i45694_3_;



            if (p_i45694_3_ == EnumFacing.Axis.X) {

                this.leftDir = EnumFacing.EAST;

                this.rightDir = EnumFacing.WEST;

            } else {

                this.leftDir = EnumFacing.NORTH;

                this.rightDir = EnumFacing.SOUTH;

            }



            for (BlockPos blockpos = p_i45694_2_; p_i45694_2_.getY() > blockpos.getY() - 21 && p_i45694_2_.getY() > 0 &&

                    this.isEmptyBlock(worldIn.getBlockState(p_i45694_2_.down())); p_i45694_2_ = p_i45694_2_.down()) {

            }



            int i = this.getDistanceUntilEdge(p_i45694_2_, this.leftDir) - 1;



            if (i >= 0) {

                this.bottomLeft = p_i45694_2_.offset(this.leftDir, i);

                this.width = this.getDistanceUntilEdge(this.bottomLeft, this.rightDir);



                if (this.width < 2 || this.width > 21) {

                    this.bottomLeft = null;

                    this.width = 0;

                }

            }



            if (this.bottomLeft != null) {

                this.height = this.calculatePortalHeight();

            }

        }



        protected boolean isEmptyBlock(IBlockState state) {

            Block blockIn = state.getBlock();

            return state.getMaterial() == Material.AIR || blockIn == Blocks.FIRE ||

                    blockIn == ModBlocks.portalEden;

        }



        protected int getDistanceUntilEdge(BlockPos p_180120_1_, EnumFacing p_180120_2_) {

            int i;



            for (i = 0; i < 22; ++i) {

                BlockPos blockpos = p_180120_1_.offset(p_180120_2_, i);



                if (!this.isEmptyBlock(this.world.getBlockState(blockpos)) ||

                        this.world.getBlockState(blockpos.down()).getBlock() != ModBlocks.rockDivine) {

                    break;

                }

            }



            Block block = this.world.getBlockState(p_180120_1_.offset(p_180120_2_, i)).getBlock();

            return block == ModBlocks.rockDivine ? i : 0;

        }



        protected int calculatePortalHeight() {

            label56:



            for (this.height = 0; this.height < 21; ++this.height) {

                for (int i = 0; i < this.width; ++i) {

                    BlockPos blockpos = this.bottomLeft.offset(this.rightDir, i).up(this.height);

                    IBlockState state = this.world.getBlockState(blockpos);

                    Block block = state.getBlock();



                    if (!this.isEmptyBlock(state)) {

                        break label56;

                    }


                    if (block == ModBlocks.portalEden) {

                        ++this.portalBlockCount;

                    }



                    if (i == 0) {

                        block = this.world.getBlockState(blockpos.offset(this.leftDir)).getBlock();



                        if (block != ModBlocks.rockDivine) {

                            break label56;

                        }

                    } else if (i == this.width - 1) {

                        block = this.world.getBlockState(blockpos.offset(this.rightDir)).getBlock();



                        if (block != ModBlocks.rockDivine) {

                            break label56;

                        }

                    }

                }

            }



            for (int j = 0; j < this.width; ++j) {

                if (this.world.getBlockState(this.bottomLeft.offset(this.rightDir, j).up(this.height)).getBlock() !=

                        ModBlocks.rockDivine) {

                    this.height = 0;

                    break;

                }

            }



            if (this.height <= 21 && this.height >= 3) {

                return this.height;

            }

            this.bottomLeft = null;

            this.width = 0;

            this.height = 0;

            return 0;

        }



        public int getHeight() {

            return this.height;

        }



        public int getWidth() {

            return this.width;

        }



        public boolean isValid() {

            return this.bottomLeft != null && this.width >= 2 && this.width <= 21 && this.height >= 3 &&

                    this.height <= 21;

        }



        public void placePortalBlocks() {

            for (int i = 0; i < this.width; ++i) {

                BlockPos blockpos = this.bottomLeft.offset(this.rightDir, i);



                for (int j = 0; j < this.height; ++j) {

                    this.world.setBlockState(blockpos.up(j),

                            ModBlocks.portalEden.getDefaultState().withProperty(AXIS, this.axis), 2);

                }

            }

        }

    }

    private boolean changeDim(EntityPlayer playerIn) {

        MinecraftServer server = playerIn.world.getMinecraftServer();

        if (server != null) {

            PlayerList playerList = server.getPlayerList();

            int i = playerIn.dimension == DimensionType.OVERWORLD.getId() ? ModDimensions.edenDimension.getId() :

                    DimensionType.OVERWORLD.getId();


            Teleporter teleporter = new ModTeleporter(server.getWorld(i), Config.edenDimensionId, ModBlocks.rockDivine, ModBlocks.portalEden);



            if (playerIn instanceof EntityPlayerMP) {

                playerList.transferPlayerToDimension((EntityPlayerMP) playerIn, i, teleporter);

            } else {

                int origin = playerIn.dimension;

                playerIn.dimension = i;

                playerIn.world.removeEntityDangerously(playerIn);

                playerIn.isDead = false;

                playerList.transferEntityToWorld(playerIn, origin, server.getWorld(origin), server.getWorld(i),

                        teleporter);

            }

        }

        return true;

    }

}