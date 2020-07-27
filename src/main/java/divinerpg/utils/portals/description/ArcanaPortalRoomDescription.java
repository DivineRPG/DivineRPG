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

public class ArcanaPortalRoomDescription implements IPortalDescription {
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
        return new BlockPos(5, 1, 5);
    }

    @Nonnull
    @Override
    public List<BlockPos> checkChunk(World world, BlockPos min, BlockPos max) {
        ArrayList<BlockPos> result = new ArrayList<>();

        // somewhere in th middle
        BlockPos pos = min.add(2, 0, 2);

        Block block = world.getBlockState(pos).getBlock();

        if (block == getFrame() || block == getPortal()) {
            result.add(pos);
        }

        return result;
    }

    @Override
    public BlockPattern.PatternHelper createPortal(World world, BlockPos pos) {
        if (world.provider.getDimensionType() == arcanaDimType) {
            pos = generatePortalRoom(world, pos);
        } else {
            EnumFacing moveOrientation = EnumFacing.NORTH;
            EnumFacing blockOrientation = EnumFacing.WEST;
            BlockPos temp = pos.toImmutable();

            for (int i = 0; i < 4; i++) {
                IBlockState frame = getFrame().getDefaultState()
                        .withProperty(BlockHorizontal.FACING, blockOrientation);

                for (int j = 1; j < 4; j++) {
                    temp = temp.offset(moveOrientation);
                    world.setBlockState(temp, frame);
                }
                temp = temp.offset(moveOrientation);

                blockOrientation = blockOrientation.rotateYCCW();
                moveOrientation = moveOrientation.rotateYCCW();
            }

            BlockPattern.PatternHelper matchFrame = matchFrame(world, pos);

            if (matchFrame != null)
                lightPortal(world, matchFrame);
        }

        return matchWorkingPortal(world, pos);
    }

    @Override
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

    @Nullable
    @Override
    public BlockPattern.PatternHelper matchWorkingPortal(World world, BlockPos pos) {
        if (world.provider.getDimensionType() == arcanaDimType)
            return fullSizePattern.match(world, pos);

        return fullPattern.match(world, pos);
    }

    @Nullable
    @Override
    public BlockPattern.PatternHelper matchFrame(World world, BlockPos pos) {
        if (world.provider.getDimensionType() == arcanaDimType)
            return fullSizeFramePattern.match(world, pos);

        return framePattern.match(world, pos);
    }

    @Override
    public BlockPos getPlayerPortalPosition(World world, Entity e, BlockPattern.PatternHelper fullMatch) {
        return fullMatch.getFrontTopLeft()
                .offset(fullMatch.getUp())
                .offset(fullMatch.getUp().rotateYCCW())
                .up();
    }

    /**
     * Legacy
     *
     * @param world
     * @param pos
     * @return
     */
    private BlockPos generatePortalRoom(World world, BlockPos pos) {
        int x = pos.getX(), y = pos.getY(), z = pos.getZ();
        IBlockState arcanaPortal = getPortal().getDefaultState();

        IBlockState southPortalState = getFrame().getDefaultState()
                .withProperty(BlockArcanaPortalFrame.FACING, EnumFacing.SOUTH);
        IBlockState northPortalState = getFrame().getDefaultState()
                .withProperty(BlockArcanaPortalFrame.FACING, EnumFacing.NORTH);
        IBlockState westPortalState = getFrame().getDefaultState()
                .withProperty(BlockArcanaPortalFrame.FACING, EnumFacing.WEST);
        IBlockState eastPortalState = getFrame().getDefaultState()
                .withProperty(BlockArcanaPortalFrame.FACING, EnumFacing.EAST);

        IBlockState dungeonBricks = BlockRegistry.degradedBrick.getDefaultState();
        IBlockState ancientbricks = BlockRegistry.ancientBrick.getDefaultState();
        IBlockState ancientTile = BlockRegistry.ancientTile.getDefaultState();
        IBlockState arcanaPower = BlockRegistry.arcaniumPower.getDefaultState();

        for (int n = 0; n < 16; n++) {
            for (int m = 0; m < 16; m++) {
                for (int o = 1; o < 8; o++) {
                    world.setBlockState(new BlockPos(x + n, y + o, z + m), Blocks.AIR.getDefaultState());
                }
            }
        }

        world.setBlockState(new BlockPos(x + 0, y + 0, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 0, z + 1), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 0, z + 2), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 0, z + 3), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 0, z + 4), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 0, z + 5), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 0, z + 6), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 0, z + 7), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 0, z + 8), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 0, z + 9), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 0, z + 10), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 0, z + 11), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 0, z + 12), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 0, z + 13), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 0, z + 14), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 0, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 1, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 1, z + 1), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 1, z + 2), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 1, z + 3), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 1, z + 4), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 1, z + 5), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 1, z + 6), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 1, z + 9), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 1, z + 10), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 1, z + 11), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 1, z + 12), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 1, z + 13), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 1, z + 14), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 1, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 2, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 2, z + 1), ancientTile);
        world.setBlockState(new BlockPos(x + 0, y + 2, z + 2), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 2, z + 3), ancientTile);
        world.setBlockState(new BlockPos(x + 0, y + 2, z + 4), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 2, z + 5), ancientTile);
        world.setBlockState(new BlockPos(x + 0, y + 2, z + 6), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 2, z + 9), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 2, z + 10), ancientTile);
        world.setBlockState(new BlockPos(x + 0, y + 2, z + 11), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 2, z + 12), ancientTile);
        world.setBlockState(new BlockPos(x + 0, y + 2, z + 13), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 2, z + 14), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 2, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 3, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 3, z + 1), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 3, z + 2), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 3, z + 3), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 3, z + 4), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 3, z + 5), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 3, z + 6), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 3, z + 7), arcanaPower);
        world.setBlockState(new BlockPos(x + 0, y + 3, z + 8), arcanaPower);
        world.setBlockState(new BlockPos(x + 0, y + 3, z + 9), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 3, z + 10), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 3, z + 11), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 3, z + 12), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 3, z + 13), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 3, z + 14), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 3, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 4, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 4, z + 1), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 4, z + 2), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 4, z + 3), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 4, z + 4), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 4, z + 5), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 4, z + 6), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 4, z + 7), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 4, z + 8), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 4, z + 9), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 4, z + 10), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 4, z + 11), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 4, z + 12), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 4, z + 13), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 4, z + 14), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 4, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 5, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 5, z + 1), ancientTile);
        world.setBlockState(new BlockPos(x + 0, y + 5, z + 2), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 5, z + 3), ancientTile);
        world.setBlockState(new BlockPos(x + 0, y + 5, z + 4), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 5, z + 5), ancientTile);
        world.setBlockState(new BlockPos(x + 0, y + 5, z + 6), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 5, z + 7), ancientTile);
        world.setBlockState(new BlockPos(x + 0, y + 5, z + 8), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 5, z + 9), ancientTile);
        world.setBlockState(new BlockPos(x + 0, y + 5, z + 10), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 5, z + 11), ancientTile);
        world.setBlockState(new BlockPos(x + 0, y + 5, z + 12), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 5, z + 13), ancientTile);
        world.setBlockState(new BlockPos(x + 0, y + 5, z + 14), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 5, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 6, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 6, z + 1), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 6, z + 2), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 6, z + 3), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 6, z + 4), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 6, z + 5), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 6, z + 6), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 6, z + 7), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 6, z + 8), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 6, z + 9), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 6, z + 10), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 6, z + 11), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 6, z + 12), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 6, z + 13), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 6, z + 14), ancientbricks);
        world.setBlockState(new BlockPos(x + 0, y + 6, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 7, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 7, z + 1), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 7, z + 2), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 7, z + 3), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 7, z + 4), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 7, z + 5), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 7, z + 6), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 7, z + 7), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 7, z + 8), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 7, z + 9), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 7, z + 10), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 7, z + 11), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 7, z + 12), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 7, z + 13), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 7, z + 14), dungeonBricks);
        world.setBlockState(new BlockPos(x + 0, y + 7, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 1, y + 0, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 1, y + 0, z + 1), BlockRegistry.dungeonLamp.getDefaultState());
        world.setBlockState(new BlockPos(x + 1, y + 0, z + 2), dungeonBricks);
        world.setBlockState(new BlockPos(x + 1, y + 0, z + 3), dungeonBricks);
        world.setBlockState(new BlockPos(x + 1, y + 0, z + 4), dungeonBricks);
        world.setBlockState(new BlockPos(x + 1, y + 0, z + 5), dungeonBricks);
        world.setBlockState(new BlockPos(x + 1, y + 0, z + 6), dungeonBricks);
        world.setBlockState(new BlockPos(x + 1, y + 0, z + 7), ancientbricks);
        world.setBlockState(new BlockPos(x + 1, y + 0, z + 8), ancientbricks);
        world.setBlockState(new BlockPos(x + 1, y + 0, z + 9), dungeonBricks);
        world.setBlockState(new BlockPos(x + 1, y + 0, z + 10), dungeonBricks);
        world.setBlockState(new BlockPos(x + 1, y + 0, z + 11), dungeonBricks);
        world.setBlockState(new BlockPos(x + 1, y + 0, z + 12), dungeonBricks);
        world.setBlockState(new BlockPos(x + 1, y + 0, z + 13), dungeonBricks);
        world.setBlockState(new BlockPos(x + 1, y + 0, z + 14), BlockRegistry.dungeonLamp.getDefaultState());
        world.setBlockState(new BlockPos(x + 1, y + 0, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 1, y + 1, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 1, y + 1, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 1, y + 2, z + 0), ancientTile);
        world.setBlockState(new BlockPos(x + 1, y + 2, z + 15), ancientTile);
        world.setBlockState(new BlockPos(x + 1, y + 3, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 1, y + 3, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 1, y + 4, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 1, y + 4, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 1, y + 5, z + 0), ancientTile);
        world.setBlockState(new BlockPos(x + 1, y + 5, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 1, y + 6, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 1, y + 6, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 1, y + 7, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 1, y + 7, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 2, y + 0, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 2, y + 0, z + 1), dungeonBricks);
        world.setBlockState(new BlockPos(x + 2, y + 0, z + 2), dungeonBricks);
        world.setBlockState(new BlockPos(x + 2, y + 0, z + 3), dungeonBricks);
        world.setBlockState(new BlockPos(x + 2, y + 0, z + 4), dungeonBricks);
        world.setBlockState(new BlockPos(x + 2, y + 0, z + 5), dungeonBricks);
        world.setBlockState(new BlockPos(x + 2, y + 0, z + 6), dungeonBricks);
        world.setBlockState(new BlockPos(x + 2, y + 0, z + 7), ancientbricks);
        world.setBlockState(new BlockPos(x + 2, y + 0, z + 8), ancientbricks);
        world.setBlockState(new BlockPos(x + 2, y + 0, z + 9), dungeonBricks);
        world.setBlockState(new BlockPos(x + 2, y + 0, z + 10), dungeonBricks);
        world.setBlockState(new BlockPos(x + 2, y + 0, z + 11), dungeonBricks);
        world.setBlockState(new BlockPos(x + 2, y + 0, z + 12), dungeonBricks);
        world.setBlockState(new BlockPos(x + 2, y + 0, z + 13), dungeonBricks);
        world.setBlockState(new BlockPos(x + 2, y + 0, z + 14), dungeonBricks);
        world.setBlockState(new BlockPos(x + 2, y + 0, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 2, y + 1, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 2, y + 1, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 2, y + 2, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 2, y + 2, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 2, y + 3, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 2, y + 3, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 2, y + 4, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 2, y + 4, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 2, y + 5, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 2, y + 5, z + 15), ancientTile);
        world.setBlockState(new BlockPos(x + 2, y + 6, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 2, y + 6, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 2, y + 7, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 2, y + 7, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 3, y + 0, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 3, y + 0, z + 1), dungeonBricks);
        world.setBlockState(new BlockPos(x + 3, y + 0, z + 2), dungeonBricks);
        world.setBlockState(new BlockPos(x + 3, y + 0, z + 3), dungeonBricks);
        world.setBlockState(new BlockPos(x + 3, y + 0, z + 4), dungeonBricks);
        world.setBlockState(new BlockPos(x + 3, y + 0, z + 5), dungeonBricks);
        world.setBlockState(new BlockPos(x + 3, y + 0, z + 6), dungeonBricks);
        world.setBlockState(new BlockPos(x + 3, y + 0, z + 7), ancientbricks);
        world.setBlockState(new BlockPos(x + 3, y + 0, z + 8), ancientbricks);
        world.setBlockState(new BlockPos(x + 3, y + 0, z + 9), dungeonBricks);
        world.setBlockState(new BlockPos(x + 3, y + 0, z + 10), dungeonBricks);
        world.setBlockState(new BlockPos(x + 3, y + 0, z + 11), dungeonBricks);
        world.setBlockState(new BlockPos(x + 3, y + 0, z + 12), dungeonBricks);
        world.setBlockState(new BlockPos(x + 3, y + 0, z + 13), dungeonBricks);
        world.setBlockState(new BlockPos(x + 3, y + 0, z + 14), dungeonBricks);
        world.setBlockState(new BlockPos(x + 3, y + 0, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 3, y + 1, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 3, y + 1, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 3, y + 2, z + 0), ancientTile);
        world.setBlockState(new BlockPos(x + 3, y + 2, z + 15), ancientTile);
        world.setBlockState(new BlockPos(x + 3, y + 3, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 3, y + 3, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 3, y + 4, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 3, y + 4, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 3, y + 5, z + 0), ancientTile);
        world.setBlockState(new BlockPos(x + 3, y + 5, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 3, y + 6, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 3, y + 6, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 3, y + 7, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 3, y + 7, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 4, y + 0, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 4, y + 0, z + 1), dungeonBricks);
        world.setBlockState(new BlockPos(x + 4, y + 0, z + 2), dungeonBricks);
        world.setBlockState(new BlockPos(x + 4, y + 0, z + 3), dungeonBricks);
        world.setBlockState(new BlockPos(x + 4, y + 0, z + 4), dungeonBricks);
        world.setBlockState(new BlockPos(x + 4, y + 0, z + 5), dungeonBricks);
        world.setBlockState(new BlockPos(x + 4, y + 0, z + 6), ancientbricks);
        world.setBlockState(new BlockPos(x + 4, y + 0, z + 7), ancientbricks);
        world.setBlockState(new BlockPos(x + 4, y + 0, z + 8), ancientbricks);
        world.setBlockState(new BlockPos(x + 4, y + 0, z + 9), ancientbricks);
        world.setBlockState(new BlockPos(x + 4, y + 0, z + 10), dungeonBricks);
        world.setBlockState(new BlockPos(x + 4, y + 0, z + 11), dungeonBricks);
        world.setBlockState(new BlockPos(x + 4, y + 0, z + 12), dungeonBricks);
        world.setBlockState(new BlockPos(x + 4, y + 0, z + 13), dungeonBricks);
        world.setBlockState(new BlockPos(x + 4, y + 0, z + 14), dungeonBricks);
        world.setBlockState(new BlockPos(x + 4, y + 0, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 4, y + 1, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 4, y + 1, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 4, y + 2, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 4, y + 2, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 4, y + 3, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 4, y + 3, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 4, y + 4, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 4, y + 4, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 4, y + 5, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 4, y + 5, z + 15), ancientTile);
        world.setBlockState(new BlockPos(x + 4, y + 6, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 4, y + 6, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 4, y + 7, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 4, y + 7, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 5, y + 0, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 5, y + 0, z + 1), dungeonBricks);
        world.setBlockState(new BlockPos(x + 5, y + 0, z + 2), dungeonBricks);
        world.setBlockState(new BlockPos(x + 5, y + 0, z + 3), dungeonBricks);
        world.setBlockState(new BlockPos(x + 5, y + 0, z + 4), dungeonBricks);
        world.setBlockState(new BlockPos(x + 5, y + 0, z + 5), ancientbricks);
        world.setBlockState(new BlockPos(x + 5, y + 0, z + 6), ancientbricks);
        world.setBlockState(new BlockPos(x + 5, y + 0, z + 7), ancientbricks);
        world.setBlockState(new BlockPos(x + 5, y + 0, z + 8), ancientbricks);
        world.setBlockState(new BlockPos(x + 5, y + 0, z + 9), ancientbricks);
        world.setBlockState(new BlockPos(x + 5, y + 0, z + 10), ancientbricks);
        world.setBlockState(new BlockPos(x + 5, y + 0, z + 11), dungeonBricks);
        world.setBlockState(new BlockPos(x + 5, y + 0, z + 12), dungeonBricks);
        world.setBlockState(new BlockPos(x + 5, y + 0, z + 13), dungeonBricks);
        world.setBlockState(new BlockPos(x + 5, y + 0, z + 14), dungeonBricks);
        world.setBlockState(new BlockPos(x + 5, y + 0, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 5, y + 1, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 5, y + 1, z + 6), eastPortalState);
        world.setBlockState(new BlockPos(x + 5, y + 1, z + 7), eastPortalState);
        world.setBlockState(new BlockPos(x + 5, y + 1, z + 8), eastPortalState);
        world.setBlockState(new BlockPos(x + 5, y + 1, z + 9), eastPortalState);
        world.setBlockState(new BlockPos(x + 5, y + 1, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 5, y + 2, z + 0), ancientTile);
        world.setBlockState(new BlockPos(x + 5, y + 2, z + 15), ancientTile);
        world.setBlockState(new BlockPos(x + 5, y + 3, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 5, y + 3, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 5, y + 4, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 5, y + 4, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 5, y + 5, z + 0), ancientTile);
        world.setBlockState(new BlockPos(x + 5, y + 5, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 5, y + 6, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 5, y + 6, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 5, y + 7, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 5, y + 7, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 6, y + 0, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 6, y + 0, z + 1), dungeonBricks);
        world.setBlockState(new BlockPos(x + 6, y + 0, z + 2), dungeonBricks);
        world.setBlockState(new BlockPos(x + 6, y + 0, z + 3), dungeonBricks);
        world.setBlockState(new BlockPos(x + 6, y + 0, z + 4), ancientbricks);
        world.setBlockState(new BlockPos(x + 6, y + 0, z + 5), ancientbricks);
        world.setBlockState(new BlockPos(x + 6, y + 0, z + 6), ancientbricks);
        world.setBlockState(new BlockPos(x + 6, y + 0, z + 7), ancientbricks);
        world.setBlockState(new BlockPos(x + 6, y + 0, z + 8), ancientbricks);
        world.setBlockState(new BlockPos(x + 6, y + 0, z + 9), ancientbricks);
        world.setBlockState(new BlockPos(x + 6, y + 0, z + 10), ancientbricks);
        world.setBlockState(new BlockPos(x + 6, y + 0, z + 11), ancientbricks);
        world.setBlockState(new BlockPos(x + 6, y + 0, z + 12), dungeonBricks);
        world.setBlockState(new BlockPos(x + 6, y + 0, z + 13), dungeonBricks);
        world.setBlockState(new BlockPos(x + 6, y + 0, z + 14), dungeonBricks);
        world.setBlockState(new BlockPos(x + 6, y + 0, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 6, y + 1, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 6, y + 1, z + 5), southPortalState);
        world.setBlockState(new BlockPos(x + 6, y + 1, z + 6), arcanaPortal);
        world.setBlockState(new BlockPos(x + 6, y + 1, z + 7), arcanaPortal);
        world.setBlockState(new BlockPos(x + 6, y + 1, z + 8), arcanaPortal);
        world.setBlockState(new BlockPos(x + 6, y + 1, z + 9), arcanaPortal);
        world.setBlockState(new BlockPos(x + 6, y + 1, z + 10), northPortalState);
        world.setBlockState(new BlockPos(x + 6, y + 1, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 6, y + 2, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 6, y + 2, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 6, y + 3, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 6, y + 3, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 6, y + 4, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 6, y + 4, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 6, y + 5, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 6, y + 5, z + 15), ancientTile);
        world.setBlockState(new BlockPos(x + 6, y + 6, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 6, y + 6, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 6, y + 7, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 6, y + 7, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 7, y + 0, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 7, y + 0, z + 1), ancientbricks);
        world.setBlockState(new BlockPos(x + 7, y + 0, z + 2), ancientbricks);
        world.setBlockState(new BlockPos(x + 7, y + 0, z + 3), ancientbricks);
        world.setBlockState(new BlockPos(x + 7, y + 0, z + 4), ancientbricks);
        world.setBlockState(new BlockPos(x + 7, y + 0, z + 5), ancientbricks);
        world.setBlockState(new BlockPos(x + 7, y + 0, z + 6), ancientbricks);
        world.setBlockState(new BlockPos(x + 7, y + 0, z + 7), ancientbricks);
        world.setBlockState(new BlockPos(x + 7, y + 0, z + 8), ancientbricks);
        world.setBlockState(new BlockPos(x + 7, y + 0, z + 9), ancientbricks);
        world.setBlockState(new BlockPos(x + 7, y + 0, z + 10), ancientbricks);
        world.setBlockState(new BlockPos(x + 7, y + 0, z + 11), ancientbricks);
        world.setBlockState(new BlockPos(x + 7, y + 0, z + 12), ancientbricks);
        world.setBlockState(new BlockPos(x + 7, y + 0, z + 13), ancientbricks);
        world.setBlockState(new BlockPos(x + 7, y + 0, z + 14), ancientbricks);
        world.setBlockState(new BlockPos(x + 7, y + 0, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 7, y + 1, z + 5), southPortalState);
        world.setBlockState(new BlockPos(x + 7, y + 1, z + 6), arcanaPortal);
        world.setBlockState(new BlockPos(x + 7, y + 1, z + 7), arcanaPortal);
        world.setBlockState(new BlockPos(x + 7, y + 1, z + 8), arcanaPortal);
        world.setBlockState(new BlockPos(x + 7, y + 1, z + 9), arcanaPortal);
        world.setBlockState(new BlockPos(x + 7, y + 1, z + 10), northPortalState);
        world.setBlockState(new BlockPos(x + 7, y + 3, z + 0), arcanaPower);
        world.setBlockState(new BlockPos(x + 7, y + 3, z + 15), arcanaPower);
        world.setBlockState(new BlockPos(x + 7, y + 4, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 7, y + 4, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 7, y + 5, z + 0), ancientTile);
        world.setBlockState(new BlockPos(x + 7, y + 5, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 7, y + 6, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 7, y + 6, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 7, y + 7, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 7, y + 7, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 8, y + 0, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 8, y + 0, z + 1), ancientbricks);
        world.setBlockState(new BlockPos(x + 8, y + 0, z + 2), ancientbricks);
        world.setBlockState(new BlockPos(x + 8, y + 0, z + 3), ancientbricks);
        world.setBlockState(new BlockPos(x + 8, y + 0, z + 4), ancientbricks);
        world.setBlockState(new BlockPos(x + 8, y + 0, z + 5), ancientbricks);
        world.setBlockState(new BlockPos(x + 8, y + 0, z + 6), ancientbricks);
        world.setBlockState(new BlockPos(x + 8, y + 0, z + 7), ancientbricks);
        world.setBlockState(new BlockPos(x + 8, y + 0, z + 8), ancientbricks);
        world.setBlockState(new BlockPos(x + 8, y + 0, z + 9), ancientbricks);
        world.setBlockState(new BlockPos(x + 8, y + 0, z + 10), ancientbricks);
        world.setBlockState(new BlockPos(x + 8, y + 0, z + 11), ancientbricks);
        world.setBlockState(new BlockPos(x + 8, y + 0, z + 12), ancientbricks);
        world.setBlockState(new BlockPos(x + 8, y + 0, z + 13), ancientbricks);
        world.setBlockState(new BlockPos(x + 8, y + 0, z + 14), ancientbricks);
        world.setBlockState(new BlockPos(x + 8, y + 0, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 8, y + 1, z + 5), southPortalState);
        world.setBlockState(new BlockPos(x + 8, y + 1, z + 6), arcanaPortal);
        world.setBlockState(new BlockPos(x + 8, y + 1, z + 7), arcanaPortal);
        world.setBlockState(new BlockPos(x + 8, y + 1, z + 8), arcanaPortal);
        world.setBlockState(new BlockPos(x + 8, y + 1, z + 9), arcanaPortal);
        world.setBlockState(new BlockPos(x + 8, y + 1, z + 10), northPortalState);
        world.setBlockState(new BlockPos(x + 8, y + 3, z + 0), arcanaPower);
        world.setBlockState(new BlockPos(x + 8, y + 3, z + 15), arcanaPower);
        world.setBlockState(new BlockPos(x + 8, y + 4, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 8, y + 4, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 8, y + 5, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 8, y + 5, z + 15), ancientTile);
        world.setBlockState(new BlockPos(x + 8, y + 6, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 8, y + 6, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 8, y + 7, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 8, y + 7, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 9, y + 0, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 9, y + 0, z + 1), dungeonBricks);
        world.setBlockState(new BlockPos(x + 9, y + 0, z + 2), dungeonBricks);
        world.setBlockState(new BlockPos(x + 9, y + 0, z + 3), dungeonBricks);
        world.setBlockState(new BlockPos(x + 9, y + 0, z + 4), ancientbricks);
        world.setBlockState(new BlockPos(x + 9, y + 0, z + 5), ancientbricks);
        world.setBlockState(new BlockPos(x + 9, y + 0, z + 6), ancientbricks);
        world.setBlockState(new BlockPos(x + 9, y + 0, z + 7), ancientbricks);
        world.setBlockState(new BlockPos(x + 9, y + 0, z + 8), ancientbricks);
        world.setBlockState(new BlockPos(x + 9, y + 0, z + 9), ancientbricks);
        world.setBlockState(new BlockPos(x + 9, y + 0, z + 10), ancientbricks);
        world.setBlockState(new BlockPos(x + 9, y + 0, z + 11), ancientbricks);
        world.setBlockState(new BlockPos(x + 9, y + 0, z + 12), dungeonBricks);
        world.setBlockState(new BlockPos(x + 9, y + 0, z + 13), dungeonBricks);
        world.setBlockState(new BlockPos(x + 9, y + 0, z + 14), dungeonBricks);
        world.setBlockState(new BlockPos(x + 9, y + 0, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 9, y + 1, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 9, y + 1, z + 5), southPortalState);
        world.setBlockState(new BlockPos(x + 9, y + 1, z + 6), arcanaPortal);
        world.setBlockState(new BlockPos(x + 9, y + 1, z + 7), arcanaPortal);
        world.setBlockState(new BlockPos(x + 9, y + 1, z + 8), arcanaPortal);
        world.setBlockState(new BlockPos(x + 9, y + 1, z + 9), arcanaPortal);
        world.setBlockState(new BlockPos(x + 9, y + 1, z + 10), northPortalState);
        world.setBlockState(new BlockPos(x + 9, y + 1, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 9, y + 2, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 9, y + 2, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 9, y + 3, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 9, y + 3, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 9, y + 4, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 9, y + 4, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 9, y + 5, z + 0), ancientTile);
        world.setBlockState(new BlockPos(x + 9, y + 5, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 9, y + 6, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 9, y + 6, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 9, y + 7, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 9, y + 7, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 10, y + 0, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 10, y + 0, z + 1), dungeonBricks);
        world.setBlockState(new BlockPos(x + 10, y + 0, z + 2), dungeonBricks);
        world.setBlockState(new BlockPos(x + 10, y + 0, z + 3), dungeonBricks);
        world.setBlockState(new BlockPos(x + 10, y + 0, z + 4), dungeonBricks);
        world.setBlockState(new BlockPos(x + 10, y + 0, z + 5), ancientbricks);
        world.setBlockState(new BlockPos(x + 10, y + 0, z + 6), ancientbricks);
        world.setBlockState(new BlockPos(x + 10, y + 0, z + 7), ancientbricks);
        world.setBlockState(new BlockPos(x + 10, y + 0, z + 8), ancientbricks);
        world.setBlockState(new BlockPos(x + 10, y + 0, z + 9), ancientbricks);
        world.setBlockState(new BlockPos(x + 10, y + 0, z + 10), ancientbricks);
        world.setBlockState(new BlockPos(x + 10, y + 0, z + 11), dungeonBricks);
        world.setBlockState(new BlockPos(x + 10, y + 0, z + 12), dungeonBricks);
        world.setBlockState(new BlockPos(x + 10, y + 0, z + 13), dungeonBricks);
        world.setBlockState(new BlockPos(x + 10, y + 0, z + 14), dungeonBricks);
        world.setBlockState(new BlockPos(x + 10, y + 0, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 10, y + 1, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 10, y + 1, z + 6), westPortalState);
        world.setBlockState(new BlockPos(x + 10, y + 1, z + 7), westPortalState);
        world.setBlockState(new BlockPos(x + 10, y + 1, z + 8), westPortalState);
        world.setBlockState(new BlockPos(x + 10, y + 1, z + 9), westPortalState);
        world.setBlockState(new BlockPos(x + 10, y + 1, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 10, y + 2, z + 0), ancientTile);
        world.setBlockState(new BlockPos(x + 10, y + 2, z + 15), ancientTile);
        world.setBlockState(new BlockPos(x + 10, y + 3, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 10, y + 3, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 10, y + 4, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 10, y + 4, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 10, y + 5, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 10, y + 5, z + 15), ancientTile);
        world.setBlockState(new BlockPos(x + 10, y + 6, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 10, y + 6, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 10, y + 7, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 10, y + 7, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 11, y + 0, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 11, y + 0, z + 1), dungeonBricks);
        world.setBlockState(new BlockPos(x + 11, y + 0, z + 2), dungeonBricks);
        world.setBlockState(new BlockPos(x + 11, y + 0, z + 3), dungeonBricks);
        world.setBlockState(new BlockPos(x + 11, y + 0, z + 4), dungeonBricks);
        world.setBlockState(new BlockPos(x + 11, y + 0, z + 5), dungeonBricks);
        world.setBlockState(new BlockPos(x + 11, y + 0, z + 6), ancientbricks);
        world.setBlockState(new BlockPos(x + 11, y + 0, z + 7), ancientbricks);
        world.setBlockState(new BlockPos(x + 11, y + 0, z + 8), ancientbricks);
        world.setBlockState(new BlockPos(x + 11, y + 0, z + 9), ancientbricks);
        world.setBlockState(new BlockPos(x + 11, y + 0, z + 10), dungeonBricks);
        world.setBlockState(new BlockPos(x + 11, y + 0, z + 11), dungeonBricks);
        world.setBlockState(new BlockPos(x + 11, y + 0, z + 12), dungeonBricks);
        world.setBlockState(new BlockPos(x + 11, y + 0, z + 13), dungeonBricks);
        world.setBlockState(new BlockPos(x + 11, y + 0, z + 14), dungeonBricks);
        world.setBlockState(new BlockPos(x + 11, y + 0, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 11, y + 1, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 11, y + 1, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 11, y + 2, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 11, y + 2, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 11, y + 3, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 11, y + 3, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 11, y + 4, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 11, y + 4, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 11, y + 5, z + 0), ancientTile);
        world.setBlockState(new BlockPos(x + 11, y + 5, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 11, y + 6, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 11, y + 6, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 11, y + 7, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 11, y + 7, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 12, y + 0, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 12, y + 0, z + 1), dungeonBricks);
        world.setBlockState(new BlockPos(x + 12, y + 0, z + 2), dungeonBricks);
        world.setBlockState(new BlockPos(x + 12, y + 0, z + 3), dungeonBricks);
        world.setBlockState(new BlockPos(x + 12, y + 0, z + 4), dungeonBricks);
        world.setBlockState(new BlockPos(x + 12, y + 0, z + 5), dungeonBricks);
        world.setBlockState(new BlockPos(x + 12, y + 0, z + 6), dungeonBricks);
        world.setBlockState(new BlockPos(x + 12, y + 0, z + 7), ancientbricks);
        world.setBlockState(new BlockPos(x + 12, y + 0, z + 8), ancientbricks);
        world.setBlockState(new BlockPos(x + 12, y + 0, z + 9), dungeonBricks);
        world.setBlockState(new BlockPos(x + 12, y + 0, z + 10), dungeonBricks);
        world.setBlockState(new BlockPos(x + 12, y + 0, z + 11), dungeonBricks);
        world.setBlockState(new BlockPos(x + 12, y + 0, z + 12), dungeonBricks);
        world.setBlockState(new BlockPos(x + 12, y + 0, z + 13), dungeonBricks);
        world.setBlockState(new BlockPos(x + 12, y + 0, z + 14), dungeonBricks);
        world.setBlockState(new BlockPos(x + 12, y + 0, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 12, y + 1, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 12, y + 1, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 12, y + 2, z + 0), ancientTile);
        world.setBlockState(new BlockPos(x + 12, y + 2, z + 15), ancientTile);
        world.setBlockState(new BlockPos(x + 12, y + 3, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 12, y + 3, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 12, y + 4, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 12, y + 4, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 12, y + 5, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 12, y + 5, z + 15), ancientTile);
        world.setBlockState(new BlockPos(x + 12, y + 6, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 12, y + 6, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 12, y + 7, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 12, y + 7, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 13, y + 0, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 13, y + 0, z + 1), dungeonBricks);
        world.setBlockState(new BlockPos(x + 13, y + 0, z + 2), dungeonBricks);
        world.setBlockState(new BlockPos(x + 13, y + 0, z + 3), dungeonBricks);
        world.setBlockState(new BlockPos(x + 13, y + 0, z + 4), dungeonBricks);
        world.setBlockState(new BlockPos(x + 13, y + 0, z + 5), dungeonBricks);
        world.setBlockState(new BlockPos(x + 13, y + 0, z + 6), dungeonBricks);
        world.setBlockState(new BlockPos(x + 13, y + 0, z + 7), ancientbricks);
        world.setBlockState(new BlockPos(x + 13, y + 0, z + 8), ancientbricks);
        world.setBlockState(new BlockPos(x + 13, y + 0, z + 9), dungeonBricks);
        world.setBlockState(new BlockPos(x + 13, y + 0, z + 10), dungeonBricks);
        world.setBlockState(new BlockPos(x + 13, y + 0, z + 11), dungeonBricks);
        world.setBlockState(new BlockPos(x + 13, y + 0, z + 12), dungeonBricks);
        world.setBlockState(new BlockPos(x + 13, y + 0, z + 13), dungeonBricks);
        world.setBlockState(new BlockPos(x + 13, y + 0, z + 14), dungeonBricks);
        world.setBlockState(new BlockPos(x + 13, y + 0, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 13, y + 1, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 13, y + 1, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 13, y + 2, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 13, y + 2, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 13, y + 3, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 13, y + 3, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 13, y + 4, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 13, y + 4, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 13, y + 5, z + 0), ancientTile);
        world.setBlockState(new BlockPos(x + 13, y + 5, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 13, y + 6, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 13, y + 6, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 13, y + 7, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 13, y + 7, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 14, y + 0, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 14, y + 0, z + 1), BlockRegistry.dungeonLamp.getDefaultState());
        world.setBlockState(new BlockPos(x + 14, y + 0, z + 2), dungeonBricks);
        world.setBlockState(new BlockPos(x + 14, y + 0, z + 3), dungeonBricks);
        world.setBlockState(new BlockPos(x + 14, y + 0, z + 4), dungeonBricks);
        world.setBlockState(new BlockPos(x + 14, y + 0, z + 5), dungeonBricks);
        world.setBlockState(new BlockPos(x + 14, y + 0, z + 6), dungeonBricks);
        world.setBlockState(new BlockPos(x + 14, y + 0, z + 7), ancientbricks);
        world.setBlockState(new BlockPos(x + 14, y + 0, z + 8), ancientbricks);
        world.setBlockState(new BlockPos(x + 14, y + 0, z + 9), dungeonBricks);
        world.setBlockState(new BlockPos(x + 14, y + 0, z + 10), dungeonBricks);
        world.setBlockState(new BlockPos(x + 14, y + 0, z + 11), dungeonBricks);
        world.setBlockState(new BlockPos(x + 14, y + 0, z + 12), dungeonBricks);
        world.setBlockState(new BlockPos(x + 14, y + 0, z + 13), dungeonBricks);
        world.setBlockState(new BlockPos(x + 14, y + 0, z + 14), BlockRegistry.dungeonLamp.getDefaultState());
        world.setBlockState(new BlockPos(x + 14, y + 0, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 14, y + 1, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 14, y + 1, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 14, y + 2, z + 0), ancientTile);
        world.setBlockState(new BlockPos(x + 14, y + 2, z + 15), ancientTile);
        world.setBlockState(new BlockPos(x + 14, y + 3, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 14, y + 3, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 14, y + 4, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 14, y + 4, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 14, y + 5, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 14, y + 5, z + 15), ancientTile);
        world.setBlockState(new BlockPos(x + 14, y + 6, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 14, y + 6, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 14, y + 7, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 14, y + 7, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 0, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 0, z + 1), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 0, z + 2), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 0, z + 3), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 0, z + 4), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 0, z + 5), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 0, z + 6), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 0, z + 7), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 0, z + 8), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 0, z + 9), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 0, z + 10), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 0, z + 11), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 0, z + 12), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 0, z + 13), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 0, z + 14), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 0, z + 15), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 1, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 1, z + 1), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 1, z + 2), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 1, z + 3), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 1, z + 4), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 1, z + 5), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 1, z + 6), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 1, z + 9), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 1, z + 10), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 1, z + 11), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 1, z + 12), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 1, z + 13), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 1, z + 14), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 1, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 2, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 2, z + 1), ancientTile);
        world.setBlockState(new BlockPos(x + 15, y + 2, z + 2), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 2, z + 3), ancientTile);
        world.setBlockState(new BlockPos(x + 15, y + 2, z + 4), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 2, z + 5), ancientTile);
        world.setBlockState(new BlockPos(x + 15, y + 2, z + 6), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 2, z + 9), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 2, z + 10), ancientTile);
        world.setBlockState(new BlockPos(x + 15, y + 2, z + 11), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 2, z + 12), ancientTile);
        world.setBlockState(new BlockPos(x + 15, y + 2, z + 13), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 2, z + 14), ancientTile);
        world.setBlockState(new BlockPos(x + 15, y + 2, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 3, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 3, z + 1), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 3, z + 2), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 3, z + 3), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 3, z + 4), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 3, z + 5), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 3, z + 6), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 3, z + 7), arcanaPower);
        world.setBlockState(new BlockPos(x + 15, y + 3, z + 8), arcanaPower);
        world.setBlockState(new BlockPos(x + 15, y + 3, z + 9), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 3, z + 10), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 3, z + 11), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 3, z + 12), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 3, z + 13), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 3, z + 14), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 3, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 4, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 4, z + 1), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 4, z + 2), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 4, z + 3), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 4, z + 4), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 4, z + 5), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 4, z + 6), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 4, z + 7), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 4, z + 8), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 4, z + 9), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 4, z + 10), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 4, z + 11), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 4, z + 12), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 4, z + 13), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 4, z + 14), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 4, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 5, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 5, z + 1), ancientTile);
        world.setBlockState(new BlockPos(x + 15, y + 5, z + 2), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 5, z + 3), ancientTile);
        world.setBlockState(new BlockPos(x + 15, y + 5, z + 4), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 5, z + 5), ancientTile);
        world.setBlockState(new BlockPos(x + 15, y + 5, z + 6), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 5, z + 7), ancientTile);
        world.setBlockState(new BlockPos(x + 15, y + 5, z + 8), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 5, z + 9), ancientTile);
        world.setBlockState(new BlockPos(x + 15, y + 5, z + 10), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 5, z + 11), ancientTile);
        world.setBlockState(new BlockPos(x + 15, y + 5, z + 12), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 5, z + 13), ancientTile);
        world.setBlockState(new BlockPos(x + 15, y + 5, z + 14), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 5, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 6, z + 0), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 6, z + 1), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 6, z + 2), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 6, z + 3), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 6, z + 4), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 6, z + 5), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 6, z + 6), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 6, z + 7), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 6, z + 8), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 6, z + 9), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 6, z + 10), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 6, z + 11), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 6, z + 12), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 6, z + 13), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 6, z + 14), ancientbricks);
        world.setBlockState(new BlockPos(x + 15, y + 6, z + 15), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 7, z + 0), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 7, z + 1), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 7, z + 2), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 7, z + 3), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 7, z + 4), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 7, z + 5), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 7, z + 6), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 7, z + 7), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 7, z + 8), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 7, z + 9), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 7, z + 10), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 7, z + 11), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 7, z + 12), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 7, z + 13), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 7, z + 14), dungeonBricks);
        world.setBlockState(new BlockPos(x + 15, y + 7, z + 15), dungeonBricks);

        // return one of the portal poses
        return new BlockPos(x + 8, y + 1, z + 9);
    }
}
