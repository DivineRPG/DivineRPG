package divinerpg.utils.portals.description;

import divinerpg.objects.blocks.arcana.BlockArcanaPortalFrame;
import divinerpg.registry.BlockRegistry;
import divinerpg.registry.DimensionRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.state.BlockWorldState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.block.state.pattern.BlockStateMatcher;
import net.minecraft.block.state.pattern.FactoryBlockPattern;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ArcanaPortalRoomDescription {
    private final DimensionType arcanaDimType;
    private final BlockPattern fullPattern;
    private final BlockPattern fullSizePattern;
    private final BlockPattern fullSizeFramePattern;
    private final BlockPattern framePattern;
    private final Block frame;
    private final Block portal;

    public ArcanaPortalRoomDescription(Block frame, Block portal) {
        this.frame = frame;
        this.portal = portal;
        this.arcanaDimType = DimensionRegistry.arcanaDimension;

        BlockStateMatcher southFrame = BlockStateMatcher.forBlock(getFrame())
                .where(BlockHorizontal.FACING, enumFacing -> Objects.equals(enumFacing, EnumFacing.SOUTH));
        BlockStateMatcher westFrame = BlockStateMatcher.forBlock(getFrame())
                .where(BlockHorizontal.FACING, enumFacing -> Objects.equals(enumFacing, EnumFacing.WEST));
        BlockStateMatcher northFrame = BlockStateMatcher.forBlock(getFrame())
                .where(BlockHorizontal.FACING, enumFacing -> Objects.equals(enumFacing, EnumFacing.NORTH));
        BlockStateMatcher eastFrame = BlockStateMatcher.forBlock(getFrame())
                .where(BlockHorizontal.FACING, enumFacing -> Objects.equals(enumFacing, EnumFacing.EAST));


        this.framePattern = FactoryBlockPattern.start()
                .aisle("?vvv?",
                        ">???<",
                        ">???<",
                        ">???<",
                        "?^^^?")
                .where('?', BlockWorldState.hasState(BlockStateMatcher.ANY))
                .where('^', BlockWorldState.hasState(southFrame))
                .where('>', BlockWorldState.hasState(westFrame))
                .where('v', BlockWorldState.hasState(northFrame))
                .where('<', BlockWorldState.hasState(eastFrame))
                .build();

        this.fullPattern = FactoryBlockPattern.start()
                .aisle("?vvv?",
                        ">ppp<",
                        ">ppp<",
                        ">ppp<",
                        "?^^^?")
                .where('?', BlockWorldState.hasState(BlockStateMatcher.ANY))
                .where('p', BlockWorldState.hasState(BlockStateMatcher.forBlock(getPortal())))
                .where('^', BlockWorldState.hasState(southFrame))
                .where('>', BlockWorldState.hasState(westFrame))
                .where('v', BlockWorldState.hasState(northFrame))
                .where('<', BlockWorldState.hasState(eastFrame))
                .build();

        // the same but bigger. Spawning inside portal room in arcana
        this.fullSizePattern = FactoryBlockPattern.start()
                .aisle("?vvvv?",
                        ">pppp<",
                        ">pppp<",
                        ">pppp<",
                        ">pppp<",
                        "?^^^^?")
                .where('?', BlockWorldState.hasState(BlockStateMatcher.ANY))
                .where('p', BlockWorldState.hasState(BlockStateMatcher.forBlock(getPortal())))
                .where('^', BlockWorldState.hasState(southFrame))
                .where('>', BlockWorldState.hasState(westFrame))
                .where('v', BlockWorldState.hasState(northFrame))
                .where('<', BlockWorldState.hasState(eastFrame))
                .build();

        this.fullSizeFramePattern = FactoryBlockPattern.start()
                .aisle("?vvvv?",
                        ">????<",
                        ">????<",
                        ">????<",
                        ">????<",
                        "?^^^^?")
                .where('?', BlockWorldState.hasState(BlockStateMatcher.ANY))
                .where('^', BlockWorldState.hasState(southFrame))
                .where('>', BlockWorldState.hasState(westFrame))
                .where('v', BlockWorldState.hasState(northFrame))
                .where('<', BlockWorldState.hasState(eastFrame))
                .build();
    }

    public Block getFrame() {
        return frame;
    }

    public Block getPortal() {
        return portal;
    }

    public BlockPos getMaxSize() {
        return new BlockPos(5, 1, 5);
    }

    public List<BlockPos> checkChunk(World world, BlockPos min, BlockPos max) {
        ArrayList<BlockPos> result = new ArrayList<>();

        // somewhere in the middle
        BlockPos pos = min.add(2, 0, 2);

        Block block = world.getBlockState(pos).getBlock();

        if (block == getFrame() || block == getPortal()) {
            result.add(pos);
        }

        return result;
    }

    public void lightPortal(World world, BlockPattern.PatternHelper frameMatch) {
        // small overworld portal
        int width = frameMatch.getWidth() - 2;
        EnumFacing forward = frameMatch.getUp().getOpposite();
        EnumFacing right = forward.rotateYCCW();
        BlockPos pos = frameMatch.getFrontTopLeft();
        IBlockState portalState = getPortal().getDefaultState();

        for (int x = 1; x <= width; x++) {
            for (int z = 1; z <= width; z++) {
                world.setBlockState(pos.offset(right, x).offset(forward, z), portalState);
            }
        }
    }

    public BlockPattern.PatternHelper matchWorkingPortal(World world, BlockPos pos) {
        if (world.provider.getDimensionType() == arcanaDimType)
            return fullSizePattern.match(world, pos);

        return fullPattern.match(world, pos);
    }

    public BlockPattern.PatternHelper matchFrame(World world, BlockPos pos) {
        if (world.provider.getDimensionType() == arcanaDimType)
            return fullSizeFramePattern.match(world, pos);

        return framePattern.match(world, pos);
    }

    public BlockPos getPlayerPortalPosition(World world, Entity e, BlockPattern.PatternHelper fullMatch) {
        return fullMatch.getFrontTopLeft()
                .offset(fullMatch.getUp())
                .offset(fullMatch.getUp().rotateYCCW())
                .up();
    }
}
