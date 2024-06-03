package divinerpg.blocks.base;

import divinerpg.config.CommonConfig;
import divinerpg.registries.*;
import divinerpg.util.LocalizeUtils;
import divinerpg.util.teleport.*;
import net.minecraft.ChatFormatting;
import net.minecraft.core.*;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.shapes.*;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.Cancelable;

import javax.annotation.Nullable;

public class BlockModPortal extends BlockMod {
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
    protected static final VoxelShape X_AXIS_AABB = Block.box(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
    protected static final VoxelShape Z_AXIS_AABB = Block.box(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);
    private static Block frame;

    public BlockModPortal(Block frame) {
        super(BlockBehaviour.Properties.of()
                .strength(-1F, 0F)
                .noCollission()
                .lightLevel((state) -> 11)
                .sound(SoundType.GLASS)
        );
//        this.frame=frame;
        this.registerDefaultState(this.stateDefinition.any().setValue(AXIS, Direction.Axis.X));
    }

//    private Block getFrame(){
//        return this.frame;
//    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        switch(state.getValue(AXIS)) {
            case Z:
                return Z_AXIS_AABB;
            case X:
            default:
                return X_AXIS_AABB;
        }
    }

    @Override
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
        Direction.Axis direction$axis = facing.getAxis();
        Direction.Axis direction$axis1 = stateIn.getValue(AXIS);
        boolean flag = direction$axis1 != direction$axis && direction$axis.isHorizontal();
        return !flag && facingState.getBlock() != this && !(new BlockModPortal.Size(worldIn, currentPos, direction$axis1, this, frame)).validatePortal() ? Blocks.AIR.defaultBlockState() : stateIn;
    }

    @Override
    public void entityInside(BlockState state, Level world, BlockPos pos, Entity entity) {
        if (!entity.isPassenger() && !entity.isVehicle() && entity.canChangeDimensions() && !entity.level().isClientSide && world != null && world.dimension() != null){
            if(entity.isOnPortalCooldown()) {
                entity.setPortalCooldown();
            }
                if(!entity.isOnPortalCooldown() && entity instanceof LivingEntity) {
                    entity.level().getProfiler().push(world.dimension().location().getPath());
                    if (this == BlockRegistry.edenPortal.get()) {
                        ResourceKey<Level> key = world.dimension() == LevelRegistry.EDEN ? Level.OVERWORLD : LevelRegistry.EDEN;
                        if(world.getServer().getLevel(key) != null) {
                            entity.changeDimension(world.getServer().getLevel(key), new DivineTeleporter(world.getServer().getLevel(key), BlockRegistry.edenPortal.get(), BlockRegistry.divineRock.get(), true, PointOfInterestRegistry.EDEN_PORTAL.getKey()));
                        }
                        } else if (this == BlockRegistry.wildwoodPortal.get()) {
                        ResourceKey<Level> key = world.dimension() == LevelRegistry.WILDWOOD ? Level.OVERWORLD : LevelRegistry.WILDWOOD;
                        if(world.getServer().getLevel(key) != null) {
                            entity.changeDimension(world.getServer().getLevel(key), new DivineTeleporter(world.getServer().getLevel(key), BlockRegistry.wildwoodPortal.get(), BlockRegistry.edenBlock.get(), true, PointOfInterestRegistry.WILDWOOD_PORTAL.getKey()));
                        }
                        } else if (this == BlockRegistry.apalachiaPortal.get()) {
                        ResourceKey<Level> key = world.dimension() == LevelRegistry.APALACHIA ? Level.OVERWORLD : LevelRegistry.APALACHIA;
                        if(world.getServer().getLevel(key) != null) {
                            entity.changeDimension(world.getServer().getLevel(key), new DivineTeleporter(world.getServer().getLevel(key), BlockRegistry.apalachiaPortal.get(), BlockRegistry.wildwoodBlock.get(), true, PointOfInterestRegistry.APALACHIA_PORTAL.getKey()));
                        }
                        } else if (this == BlockRegistry.skythernPortal.get()) {
                        ResourceKey<Level> key = world.dimension() == LevelRegistry.SKYTHERN ? Level.OVERWORLD : LevelRegistry.SKYTHERN;
                        if(world.getServer().getLevel(key) != null) {
                            entity.changeDimension(world.getServer().getLevel(key), new DivineTeleporter(world.getServer().getLevel(key), BlockRegistry.skythernPortal.get(), BlockRegistry.apalachiaBlock.get(), true, PointOfInterestRegistry.SKYTHERN_PORTAL.getKey()));
                        }
                        } else if (this == BlockRegistry.mortumPortal.get()) {
                        ResourceKey<Level> key = world.dimension() == LevelRegistry.MORTUM ? Level.OVERWORLD : LevelRegistry.MORTUM;
                        if(world.getServer().getLevel(key) != null) {
                            entity.changeDimension(world.getServer().getLevel(key), new DivineTeleporter(world.getServer().getLevel(key), BlockRegistry.mortumPortal.get(), BlockRegistry.skythernBlock.get(), true, PointOfInterestRegistry.MORTUM_PORTAL.getKey()));
                        }
                        } else if (this == BlockRegistry.iceikaPortal.get()) {
                        ResourceKey<Level> key = world.dimension() == LevelRegistry.ICEIKA ? Level.OVERWORLD : LevelRegistry.ICEIKA;
                        if(world.getServer().getLevel(key) != null) {
                            entity.changeDimension(world.getServer().getLevel(key), new DivineTeleporter(world.getServer().getLevel(key), BlockRegistry.iceikaPortal.get(), Blocks.SNOW_BLOCK, true, PointOfInterestRegistry.ICEIKA_PORTAL.getKey()));
                        }
                        } else if (this == BlockRegistry.vetheaPortal.get()) {
                        ResourceKey<Level> key = world.dimension() == LevelRegistry.VETHEA ? Level.OVERWORLD : LevelRegistry.VETHEA;
                        if (CommonConfig.saferVetheanInventory.get()) {
                            if (world.getServer().getLevel(key) != null) {
                                if (entity instanceof Player player) {
                                    if (player.inventory.isEmpty()) {
                                        entity.changeDimension(world.getServer().getLevel(key), new VetheaTeleporter(true));
                                    } else {
                                        Component message = LocalizeUtils.clientMessage(ChatFormatting.RED, "vethea_portal.inventory_full", player.getDisplayName());
                                        player.displayClientMessage(message, true);
                                    }
                                }
                            }
                        }else{
                            if (world.getServer().getLevel(key) != null) {
                                entity.changeDimension(world.getServer().getLevel(key), new VetheaTeleporter(true));
                            }
                        }
                    }
                    entity.level().getProfiler().pop();
                }
        }

    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, RandomSource rand) {

        for(int i = 0; i < 4; ++i) {
            double x = (double) pos.getX() + rand.nextDouble();
            double y = (double) pos.getY() + rand.nextDouble();
            double z = (double) pos.getZ() + rand.nextDouble();
            double xSpeed = ((double) rand.nextFloat() - 0.5D) * 0.5D;
            double ySpeed = ((double) rand.nextFloat() - 0.5D) * 0.5D;
            double zSpeed = ((double) rand.nextFloat() - 0.5D) * 0.5D;
            int j = rand.nextInt(2) * 2 - 1;
            if (!worldIn.getBlockState(pos.west()).is(this) && !worldIn.getBlockState(pos.east()).is(this)) {
                x = (double) pos.getX() + 0.5D + 0.25D * (double) j;
                xSpeed = rand.nextFloat() * 2.0F * (float) j;
            } else {
                z = (double) pos.getZ() + 0.5D + 0.25D * (double) j;
                zSpeed = rand.nextFloat() * 2.0F * (float) j;
            }

            if (this == BlockRegistry.edenPortal.get()) {
                worldIn.addParticle(ParticleRegistry.EDEN_PORTAL.get(), x, y, z, xSpeed, ySpeed, zSpeed);
            } else if (this == BlockRegistry.wildwoodPortal.get()) {
                worldIn.addParticle(ParticleRegistry.WILDWOOD_PORTAL.get(), x, y, z, xSpeed, ySpeed, zSpeed);
            } else if (this == BlockRegistry.apalachiaPortal.get()) {
                worldIn.addParticle(ParticleRegistry.APALACHIA_PORTAL.get(), x, y, z, xSpeed, ySpeed, zSpeed);
            } else if (this == BlockRegistry.skythernPortal.get()) {
                worldIn.addParticle(ParticleRegistry.SKYTHERN_PORTAL.get(), x, y, z, xSpeed, ySpeed, zSpeed);
            } else if (this == BlockRegistry.mortumPortal.get()) {
                worldIn.addParticle(ParticleRegistry.MORTUM_PORTAL.get(), x, y, z, xSpeed, ySpeed, zSpeed);
            } else if (this == BlockRegistry.iceikaPortal.get()) {
                worldIn.addParticle(ParticleRegistry.FROST.get(), x, y, z, xSpeed, ySpeed, zSpeed);
            } else if (this == BlockRegistry.vetheaPortal.get()) {
                worldIn.addParticle(ParticleRegistry.MORTUM_PORTAL.get(), x, y, z, xSpeed, ySpeed, zSpeed);
            } else {
                worldIn.addParticle(ParticleTypes.PORTAL, x, y, z, xSpeed, ySpeed, zSpeed);
            }
        }

    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
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
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AXIS);
    }

    public boolean makePortal(LevelAccessor worldIn, BlockPos pos) {
        BlockModPortal.Size portal = this.isPortal(worldIn, pos);
        if(worldIn.getBlockState(pos.below()) == Blocks.BEDROCK.defaultBlockState()){
            pos = pos.below(10);
        }
        if (portal != null && !onTrySpawnPortal(worldIn, pos, portal)) {
            portal.createPortalBlocks();
            return true;
        } else {
            return false;
        }
    }

    public static boolean onTrySpawnPortal(LevelAccessor world, BlockPos pos, BlockModPortal.Size size) {
        return MinecraftForge.EVENT_BUS.post(new PortalSpawnEvent(world, pos, world.getBlockState(pos), size));
    }

    @Cancelable
    public static class PortalSpawnEvent extends BlockEvent {
        private final BlockModPortal.Size size;

        public PortalSpawnEvent(LevelAccessor world, BlockPos pos, BlockState state, BlockModPortal.Size size) {
            super(world, pos, state);
            this.size = size;
        }

        public BlockModPortal.Size getPortalSize()
        {
            return size;
        }
    }

    @Nullable
    public BlockModPortal.Size isPortal(LevelAccessor worldIn, BlockPos pos) {
        BlockModPortal.Size portalX = new Size(worldIn, pos, Direction.Axis.X, this, worldIn.getBlockState(pos.below()).getBlock());
        if (portalX.isValid() && portalX.portalBlockCount == 0) {
            return portalX;
        } else {
            BlockModPortal.Size portalZ = new Size(worldIn, pos, Direction.Axis.Z, this, worldIn.getBlockState(pos.below()).getBlock());
            return portalZ.isValid() && portalZ.portalBlockCount == 0 ? portalZ : null;
        }
    }

    public static class Size {
        private final LevelAccessor world;
        private final Direction.Axis axis;
        private final Direction rightDir;
        private final Direction leftDir;
        private int portalBlockCount;
        @Nullable
        private BlockPos bottomLeft;
        private int height;
        private int width;
        private Block portal, frame;

        public Size(LevelAccessor worldIn, BlockPos pos, Direction.Axis axisIn, Block portal, Block frame) {
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
                if (!this.canConnect(this.world.getBlockState(blockpos)) || !(this.world.getBlockState(blockpos.below()).getBlock().equals(this.world.getBlockState(pos.below()).getBlock()))) {
                    break;
                }
            }

            BlockPos framePos = pos.relative(directionIn, i);
            return this.world.getBlockState(framePos).getBlock().equals(this.world.getBlockState(pos.below()).getBlock()) ? i : 0;
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
                    BlockState blockstate = world.getBlockState(blockpos);
                    if (!this.canConnect(blockstate)) {
                        break label56;
                    }

                    Block block = blockstate.getBlock();
                    if (block == portal) {
                        ++this.portalBlockCount;
                    }

                    if (i == 0) {
                        BlockPos framePos = blockpos.relative(this.leftDir);
                        if (!(world.getBlockState(framePos).getBlock().equals(frame))) {
                            break label56;
                        }
                        if (!(world.getBlockState(framePos).getBlock() == frame)) {
                            break label56;
                        }
                    } else if (i == this.width - 1) {
                        BlockPos framePos = blockpos.relative(this.rightDir);
                        if (!(world.getBlockState(framePos).getBlock().equals(frame))) {
                            break label56;
                        }
                        if (!(world.getBlockState(framePos).getBlock() == frame)) {
                            break label56;
                        }
                    }
                }
            }

            for(int j = 0; j < this.width; ++j) {
                BlockPos framePos = this.bottomLeft.relative(this.rightDir, j).above(this.height);
                if (!(world.getBlockState(framePos).getBlock().equals(frame))) {
                    this.height = 0;
                    break;
                }
                if (!(world.getBlockState(framePos).getBlock() == frame)) {
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