package divinerpg.blocks.base;

import divinerpg.registries.*;
import divinerpg.util.teleport.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.particles.*;
import net.minecraft.state.*;
import net.minecraft.state.properties.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.shapes.*;
import net.minecraft.world.*;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.common.*;
import net.minecraftforge.event.world.*;
import net.minecraftforge.eventbus.api.*;

import javax.annotation.*;
import java.util.*;

public class BlockModPortal extends BlockMod {
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
    protected static final VoxelShape X_AXIS_AABB = Block.box(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
    protected static final VoxelShape Z_AXIS_AABB = Block.box(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);
    private static Block frame;

    public BlockModPortal(String name, Block frame) {
        super(name, AbstractBlock.Properties.of(Material.PORTAL)
                .strength(-1F)
                .noCollission()
                .lightLevel((state) -> 11)
                .noDrops()
        );
        this.frame=frame;
        this.registerDefaultState(this.stateDefinition.any().setValue(AXIS, Direction.Axis.X));
    }

    private Block getFrame(){
        return this.frame;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch(state.getValue(AXIS)) {
            case Z:
                return Z_AXIS_AABB;
            case X:
            default:
                return X_AXIS_AABB;
        }
    }

    @Override
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        Direction.Axis direction$axis = facing.getAxis();
        Direction.Axis direction$axis1 = stateIn.getValue(AXIS);
        boolean flag = direction$axis1 != direction$axis && direction$axis.isHorizontal();
        return !flag && facingState.getBlock() != this && !(new BlockModPortal.Size(worldIn, currentPos, direction$axis1, getBlock(), frame)).validatePortal() ? Blocks.AIR.defaultBlockState() : super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Override
    public void entityInside(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!entity.isPassenger() && !entity.isVehicle() && entity.canChangeDimensions() && !entity.level.isClientSide){
            if(entity.isOnPortalCooldown()) {
                entity.setPortalCooldown();
            }
                if(!entity.isOnPortalCooldown() && entity instanceof LivingEntity) {

                    entity.level.getProfiler().push(world.dimension().getRegistryName().getPath());
                    if (this == BlockRegistry.edenPortal) {
                        RegistryKey<World> key = world.dimension() == KeyRegistry.EDEN_WORLD ? World.OVERWORLD : KeyRegistry.EDEN_WORLD;
                        entity.changeDimension(world.getServer().getLevel(key), new DivineTeleporter(world.getServer().getLevel(key), BlockRegistry.edenPortal, BlockRegistry.divineRock, true, KeyRegistry.EDEN_PORTAL.get()));
                    } else if (this == BlockRegistry.wildwoodPortal) {
                        RegistryKey<World> key = world.dimension() == KeyRegistry.WILDWOOD_WORLD ? World.OVERWORLD : KeyRegistry.WILDWOOD_WORLD;
                        entity.changeDimension(world.getServer().getLevel(key), new DivineTeleporter(world.getServer().getLevel(key), BlockRegistry.wildwoodPortal, BlockRegistry.edenBlock, true, KeyRegistry.WILDWOOD_PORTAL.get()));
                    } else if (this == BlockRegistry.apalachiaPortal) {
                        RegistryKey<World> key = world.dimension() == KeyRegistry.APALACHIA_WORLD ? World.OVERWORLD : KeyRegistry.APALACHIA_WORLD;
                        entity.changeDimension(world.getServer().getLevel(key), new DivineTeleporter(world.getServer().getLevel(key), BlockRegistry.apalachiaPortal, BlockRegistry.wildwoodBlock, true, KeyRegistry.APALACHIA_PORTAL.get()));
                    } else if (this == BlockRegistry.skythernPortal) {
                        RegistryKey<World> key = world.dimension() == KeyRegistry.SKYTHERN_WORLD ? World.OVERWORLD : KeyRegistry.SKYTHERN_WORLD;
                        entity.changeDimension(world.getServer().getLevel(key), new DivineTeleporter(world.getServer().getLevel(key), BlockRegistry.skythernPortal, BlockRegistry.apalachiaBlock, true, KeyRegistry.SKYTHERN_PORTAL.get()));
                    } else if (this == BlockRegistry.mortumPortal) {
                        RegistryKey<World> key = world.dimension() == KeyRegistry.MORTUM_WORLD ? World.OVERWORLD : KeyRegistry.MORTUM_WORLD;
                        entity.changeDimension(world.getServer().getLevel(key), new DivineTeleporter(world.getServer().getLevel(key), BlockRegistry.mortumPortal, BlockRegistry.skythernBlock, true, KeyRegistry.MORTUM_PORTAL.get()));
                    } else if (this == BlockRegistry.iceikaPortal) {
                        RegistryKey<World> key = world.dimension() == KeyRegistry.ICEIKA_WORLD ? World.OVERWORLD : KeyRegistry.ICEIKA_WORLD;
                        entity.changeDimension(world.getServer().getLevel(key), new DivineTeleporter(world.getServer().getLevel(key), BlockRegistry.iceikaPortal, Blocks.SNOW_BLOCK, true, KeyRegistry.ICEIKA_PORTAL.get()));
                    } else if (this == BlockRegistry.vetheaPortal) {
                        RegistryKey<World> key = world.dimension() == KeyRegistry.VETHEA_WORLD ? World.OVERWORLD : KeyRegistry.VETHEA_WORLD;
                        entity.changeDimension(world.getServer().getLevel(key), new VetheaTeleporter(world.getServer().getLevel(key)));
                    }
                    entity.level.getProfiler().pop();
                }
        }

    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {

        for(int i = 0; i < 4; ++i) {
            double x = (double)pos.getX() + rand.nextDouble();
            double y = (double)pos.getY() + rand.nextDouble();
            double z = (double)pos.getZ() + rand.nextDouble();
            double xSpeed = ((double)rand.nextFloat() - 0.5D) * 0.5D;
            double ySpeed = ((double)rand.nextFloat() - 0.5D) * 0.5D;
            double zSpeed = ((double)rand.nextFloat() - 0.5D) * 0.5D;
            int j = rand.nextInt(2) * 2 - 1;
            if (!worldIn.getBlockState(pos.west()).is(this) && !worldIn.getBlockState(pos.east()).is(this)) {
                x = (double)pos.getX() + 0.5D + 0.25D * (double)j;
                xSpeed = rand.nextFloat() * 2.0F * (float)j;
            } else {
                z = (double)pos.getZ() + 0.5D + 0.25D * (double)j;
                zSpeed = rand.nextFloat() * 2.0F * (float)j;
            }

            worldIn.addParticle(ParticleTypes.PORTAL, x, y, z, xSpeed, ySpeed, zSpeed);
        }

    }

    @Override
    public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
        return ItemStack.EMPTY;
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        switch(rot) {
            case COUNTERCLOCKWISE_90:
            case CLOCKWISE_90:
                switch(state.getValue(AXIS)) {
                    case Z:
                        return state.setValue(AXIS, Direction.Axis.X);
                    case X:
                        return state.setValue(AXIS, Direction.Axis.Z);
                    default:
                        return state;
                }
            default:
                return state;
        }
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(AXIS);
    }

    public boolean makePortal(IWorld worldIn, BlockPos pos) {
        BlockModPortal.Size portal = this.isPortal(worldIn, pos);
        if (portal != null && !onTrySpawnPortal(worldIn, pos, portal)) {
            portal.createPortalBlocks();
            return true;
        } else {
            return false;
        }
    }

    public static boolean onTrySpawnPortal(IWorld world, BlockPos pos, BlockModPortal.Size size) {
        return MinecraftForge.EVENT_BUS.post(new PortalSpawnEvent(world, pos, world.getBlockState(pos), size));
    }

    @Cancelable
    public static class PortalSpawnEvent extends BlockEvent {
        private final BlockModPortal.Size size;

        public PortalSpawnEvent(IWorld world, BlockPos pos, BlockState state, BlockModPortal.Size size) {
            super(world, pos, state);
            this.size = size;
        }

        public BlockModPortal.Size getPortalSize()
        {
            return size;
        }
    }

    @Nullable
    public BlockModPortal.Size isPortal(IWorld worldIn, BlockPos pos) {
        BlockModPortal.Size portalX = new Size(worldIn, pos, Direction.Axis.X, this, worldIn.getBlockState(pos.below()).getBlock());
        if (portalX.isValid() && portalX.portalBlockCount == 0) {
            return portalX;
        } else {
            BlockModPortal.Size portalZ = new Size(worldIn, pos, Direction.Axis.Z, this, worldIn.getBlockState(pos.below()).getBlock());
            return portalZ.isValid() && portalZ.portalBlockCount == 0 ? portalZ : null;
        }
    }

    public static class Size {
        private final IWorld world;
        private final Direction.Axis axis;
        private final Direction rightDir;
        private final Direction leftDir;
        private int portalBlockCount;
        @Nullable
        private BlockPos bottomLeft;
        private int height;
        private int width;
        private Block portal, frame;

        public Size(IWorld worldIn, BlockPos pos, Direction.Axis axisIn, Block portal, Block frame) {
            this.world = worldIn;
            this.axis = axisIn;
            this.portal=portal;
            this.frame=frame;
            if (axisIn == Direction.Axis.X) {
                this.leftDir = Direction.EAST;
                this.rightDir = Direction.WEST;
            } else {
                this.leftDir = Direction.NORTH;
                this.rightDir = Direction.SOUTH;
            }

            for(BlockPos blockpos = pos; pos.getY() > blockpos.getY() - 21 && pos.getY() > 0 && this.canConnect(worldIn.getBlockState(pos.below())); pos = pos.below()) {
                ;
            }

            int i = this.getDistanceUntilEdge(pos, this.leftDir) - 1;
            if (i >= 0) {
                this.bottomLeft = pos.relative(this.leftDir, i);
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

        protected int getDistanceUntilEdge(BlockPos pos, Direction directionIn) {
            int i;
            for(i = 0; i < 22; ++i) {
                BlockPos blockpos = pos.relative(directionIn, i);
                if (!this.canConnect(this.world.getBlockState(blockpos)) || !(this.world.getBlockState(blockpos.below()).getBlock().is(this.world.getBlockState(pos.below()).getBlock()))) {
                    break;
                }
            }

            BlockPos framePos = pos.relative(directionIn, i);
            return this.world.getBlockState(framePos).getBlock().is(this.world.getBlockState(pos.below()).getBlock()) ? i : 0;
        }

        public int getHeight() {
            return this.height;
        }

        public int getWidth() {
            return this.width;
        }

        protected int calculatePortalHeight() {
            label56:
            for(this.height = 0; this.height < 21; ++this.height) {
                for(int i = 0; i < this.width; ++i) {
                    BlockPos blockpos = this.bottomLeft.relative(this.rightDir, i).above(this.height);
                    BlockState blockstate = this.world.getBlockState(blockpos);
                    if (!this.canConnect(blockstate)) {
                        break label56;
                    }

                    Block block = blockstate.getBlock();
                    if (block == this.portal) {
                        ++this.portalBlockCount;
                    }

                    if (i == 0) {
                        BlockPos framePos = blockpos.relative(this.leftDir);
                        if (!(this.world.getBlockState(framePos).getBlock().is(this.world.getBlockState(framePos).getBlock()))) {
                            break label56;
                        }
                    } else if (i == this.width - 1) {
                        BlockPos framePos = blockpos.relative(this.rightDir);
                        if (!(this.world.getBlockState(framePos).getBlock().is(this.world.getBlockState(framePos).getBlock()))) {
                            break label56;
                        }
                    }
                }
            }

            for(int j = 0; j < this.width; ++j) {
                BlockPos framePos = this.bottomLeft.relative(this.rightDir, j).above(this.height);
                if (!(this.world.getBlockState(framePos).getBlock().is(this.world.getBlockState(framePos).getBlock()))) {
                    this.height = 0;
                    break;
                }
            }

            if (this.height <= 21 && this.height >= 3) {
                return this.height;
            } else {
                this.bottomLeft = null;
                this.width = 0;
                this.height = 0;
                return 0;
            }
        }

        protected boolean canConnect(BlockState pos) {
            Block block = pos.getBlock();
            return pos.isAir() || block == this.portal;
        }

        public boolean isValid() {
            return this.bottomLeft != null && this.width >= 2 && this.width <= 21 && this.height >= 3 && this.height <= 21;
        }

        public void createPortalBlocks() {
            BlockState blockstate = this.portal.defaultBlockState().setValue(BlockModPortal.AXIS, this.axis);
            BlockPos.betweenClosed(this.bottomLeft, this.bottomLeft.relative(Direction.UP, this.height - 1).relative(this.rightDir, this.width - 1)).forEach((pos) -> {
                this.world.setBlock(pos, blockstate, 18);
            });
        }

        private boolean isPortalCountValidForSize() {
            return this.portalBlockCount >= this.width * this.height;
        }

        public boolean validatePortal() {
            return this.isValid() && this.isPortalCountValidForSize();
        }
    }
}