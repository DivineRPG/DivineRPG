package divinerpg.utils.portals.description;

import com.google.common.collect.Iterables;
import divinerpg.utils.PositionHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.state.BlockWorldState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.block.state.pattern.BlockStateMatcher;
import net.minecraft.block.state.pattern.FactoryBlockPattern;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class NetherLikePortalDescription implements IPortalDescription {
    private final BlockPattern fullPattern;
    private final BlockPattern framePattern;
    private final Block frame;
    private final Block portal;

    public NetherLikePortalDescription(Block frame, Block portal) {
        this.frame = frame;
        this.portal = portal;

        fullPattern = FactoryBlockPattern.start()
                .aisle("?xx?")
                .aisle("x..x")
                .aisle("x..x")
                .aisle("x..x")
                .aisle("?xx?")
                .where('?', BlockWorldState.hasState(BlockStateMatcher.ANY))
                .where('x', BlockWorldState.hasState(BlockStateMatcher.forBlock(getFrame())))
                .where('.', BlockWorldState.hasState(BlockStateMatcher.forBlock(getPortal())))
                .build();

        framePattern = FactoryBlockPattern.start()
                .aisle("?xx?")
                .aisle("x??x")
                .aisle("x??x")
                .aisle("x??x")
                .aisle("?xx?")
                .where('?', BlockWorldState.hasState(BlockStateMatcher.ANY))
                .where('x', BlockWorldState.hasState(BlockStateMatcher.forBlock(getFrame())))
                .build();
    }

    @Override
    public Block getFrame() {
        return frame;
    }

    @Override
    public Block getPortal() {
        return portal;
    }

    @Override
    public BlockPos getMaxSize() {
        return new BlockPos(4, 4, 4);
    }

    @Override
    public List<BlockPos> checkChunk(World world, BlockPos min, BlockPos max) {
        ArrayList<BlockPos> poses = new ArrayList<>();

        Iterable<BlockPos> zDirPoses = BlockPos.getAllInBox(min, new BlockPos(min.getX(), min.getY(), max.getZ()));
        Iterable<BlockPos> xDirPoses = BlockPos.getAllInBox(new BlockPos(min.getX(), max.getY(), min.getZ()), new BlockPos(max.getX(), max.getY(), min.getZ()));

        Iterables.concat(zDirPoses, xDirPoses).forEach(x -> {
            Block block = world.getBlockState(x).getBlock();
            if (block == getFrame() || block == getPortal())
                poses.add(x);
        });

        return poses;
    }

    @Override
    public BlockPattern.PatternHelper createPortal(World world, BlockPos pos) {
        // starting from botton right corener
        final BlockPos rightBottom = pos.east();
        final BlockPos leftTop = rightBottom.offset(EnumFacing.WEST, 3).offset(EnumFacing.UP, 4);

        for (int i = 0; i < 5; i++) {
            world.setBlockState(leftTop.down(i), frame.getDefaultState());
            world.setBlockState(rightBottom.up(i), frame.getDefaultState());
        }

        for (int i = 0; i < 4; i++) {
            world.setBlockState(leftTop.east(i), frame.getDefaultState());
            world.setBlockState(rightBottom.west(i), frame.getDefaultState());
        }

        // create platform is needed
        List<BlockPos> platformBlocks = Arrays.asList(
                rightBottom.west().north(),
                rightBottom.west().south(),

                rightBottom.west(2).north(),
                rightBottom.west(2).south()
        );

        if (platformBlocks.stream().flatMap(x -> Stream.of(x, x.down()))
                .anyMatch(world::isAirBlock)) {
            platformBlocks.forEach(x -> world.setBlockState(x, frame.getDefaultState()));
        }

        lightPortal(world, leftTop, EnumFacing.SOUTH, EnumFacing.DOWN);
        return matchFrame(world, pos);
    }

    @Override
    public void lightPortal(World world, BlockPattern.PatternHelper frameMatch) {
        EnumFacing right = frameMatch.getUp();
        EnumFacing down = frameMatch.getForwards();
        BlockPos topLeft = frameMatch.getFrontTopLeft();

        lightPortal(world, topLeft, right, down);
    }

    @Nullable
    @Override
    public BlockPattern.PatternHelper matchWorkingPortal(World world, BlockPos pos) {
        return fullPattern.match(world, pos);
    }

    @Nullable
    @Override
    public BlockPattern.PatternHelper matchFrame(World world, BlockPos pos) {
        return framePattern.match(world, pos);
    }

    @Override
    public BlockPos getPlayerPortalPosition(World world, Entity e, BlockPattern.PatternHelper fullMatch) {
        final BlockPos.MutableBlockPos topLeft = new BlockPos.MutableBlockPos(fullMatch.getFrontTopLeft());
        {
            BlockPos bottomBlock = topLeft.offset(fullMatch.getUp(), fullMatch.getHeight());
            if (topLeft.getY() > bottomBlock.getY()) {
                topLeft.setY(bottomBlock.getY());
            }

            bottomBlock = topLeft.offset(fullMatch.getForwards(), fullMatch.getWidth());
            if (topLeft.getY() > bottomBlock.getY()) {
                topLeft.setY(bottomBlock.getY());
            }
        }

        return PositionHelper.searchInRadius(world, topLeft, 3, x -> {
            if (x.getY() != topLeft.getY())
                return false;

            IBlockState state = world.getBlockState(x);
            if (!state.isSideSolid(world, x, EnumFacing.UP))
                return false;

            return !world.getBlockState(x.up()).causesSuffocation() && !world.getBlockState(x.up(2)).causesSuffocation();
        }).up();
    }

    private void lightPortal(World world, BlockPos topLeft, EnumFacing right, EnumFacing down) {
        right = right.rotateYCCW();
        topLeft = topLeft.offset(right, 1).offset(down, 1);

        IBlockState state = fillWithProps(portal.getDefaultState(), right);


        for (int i = 0; i < 3; i++) {
            world.setBlockState(topLeft.offset(down, i), state);
            world.setBlockState(topLeft.offset(down, i).offset(right), state);
        }
    }

    private IBlockState fillWithProps(IBlockState state, EnumFacing facing) {
        if (state.getPropertyKeys().contains(BlockPortal.AXIS)) {
            state = state.withProperty(BlockPortal.AXIS, facing.getAxis());
        }

        return state;
    }
}
