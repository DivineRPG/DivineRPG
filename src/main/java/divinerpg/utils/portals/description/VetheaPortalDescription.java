package divinerpg.utils.portals.description;

import com.google.common.collect.Iterables;
import divinerpg.objects.blocks.BlockModPortal;
import divinerpg.registry.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.state.BlockWorldState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.block.state.pattern.BlockStateMatcher;
import net.minecraft.block.state.pattern.FactoryBlockPattern;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class VetheaPortalDescription implements IPortalDescription {
    private final BlockPattern fullPattern;
    private final BlockPattern framePattern;

    public VetheaPortalDescription() {
        this.fullPattern = FactoryBlockPattern.start()
                .aisle("??x??")
                .aisle("?x.x?")
                .aisle("x...x")
                .aisle("?x.x?")
                .aisle("??x??")
                .where('?', BlockWorldState.hasState(BlockStateMatcher.ANY))
                .where('x', BlockWorldState.hasState(BlockStateMatcher.forBlock(getFrame())))
                .where('.', BlockWorldState.hasState(BlockStateMatcher.forBlock(getPortal())))
                .build();

        this.framePattern = FactoryBlockPattern.start()
                .aisle("??x??")
                .aisle("?x.x?")
                .aisle("x...x")
                .aisle("?x.x?")
                .aisle("??x??")
                .where('?', BlockWorldState.hasState(BlockStateMatcher.ANY))
                .where('.', BlockWorldState.hasState(BlockStateMatcher.ANY))
                .where('x', BlockWorldState.hasState(BlockStateMatcher.forBlock(getFrame())))
                .build();
    }

    @Override
    public Block getFrame() {
        return BlockRegistry.mortumBlock;
    }

    @Override
    public Block getPortal() {
        return BlockRegistry.vetheaPortal;
    }

    @Override
    public BlockPos getMaxSize() {
        return new BlockPos(5, 5, 5);
    }

    @Nonnull
    @Override
    public List<BlockPos> checkChunk(World world, BlockPos min, BlockPos max) {

        ArrayList<BlockPos> result = new ArrayList<>();

        BlockPos middle = min.add(2, 2, 2);

        Iterable<BlockPos> poses = Iterables.concat(
                BlockPos.getAllInBox(middle.add(-2, 0, 0), middle.add(2, 0, 0)),
                BlockPos.getAllInBox(middle.add(0, 0, -2), middle.add(0, 0, 2))
        );

        poses.forEach(x -> {
            Block block = world.getBlockState(x).getBlock();

            if (block == getFrame() || block == getPortal())
                result.add(x);
        });

        return result;
    }

    @Override
    public BlockPattern.PatternHelper createPortal(World world, BlockPos pos) {
        pos = pos.add(2, 2, 0);

        for (int x = -2; x <= 2; x++) {
            for (int y = -2; y <= 2; y++) {
                BlockPos current = pos.add(x, y, 0);
                int distance = Math.abs(x) + Math.abs(y);

                if (distance == 2) {
                    world.setBlockState(current, getFrame().getDefaultState());
                }
            }
        }

        lightPortal(world, pos, EnumFacing.EAST);

        return matchWorkingPortal(world, pos);
    }

    @Override
    public void lightPortal(World world, BlockPattern.PatternHelper frameMatch) {
        lightPortal(world, getMiddle(frameMatch), frameMatch.getUp().rotateYCCW());
    }

    private BlockPos getMiddle(BlockPattern.PatternHelper frameMatch) {
        BlockPos topLeft = frameMatch.getFrontTopLeft();

        EnumFacing up = frameMatch.getForwards();
        EnumFacing corner = frameMatch.getUp().rotateYCCW();
        if (up.getAxisDirection() == EnumFacing.AxisDirection.NEGATIVE) {
            corner = corner.getOpposite();
        }


        BlockPos middle = topLeft.offset(up, 2)
                .offset(corner, 2);

        return middle;
    }

    private void lightPortal(World world, BlockPos middle, EnumFacing horizontal) {

        IBlockState portal = getPortal().getDefaultState().withProperty(BlockModPortal.AXIS,
                horizontal.getAxis());

        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                BlockPos current = middle.add(0, y, 0).offset(horizontal, x);
                int distance = Math.abs(x) + Math.abs(y);

                if (distance <= 1) {
                    world.setBlockState(current, portal);
                }
            }
        }
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
}
