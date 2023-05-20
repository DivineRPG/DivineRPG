package divinerpg.blocks.arcana;

import com.google.common.base.Predicates;
import divinerpg.DivineRPG;
import divinerpg.blocks.base.BlockMod;
import net.minecraft.core.*;
import net.minecraft.network.protocol.game.DebugPackets;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.pattern.*;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.*;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockArcanaPortalFrame extends BlockMod {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    protected static final VoxelShape BASE_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 13.0D, 16.0D);
    private static BlockPattern portalShape;

    public BlockArcanaPortalFrame(float hardness, float resistance) {
        super(Properties.of(Material.HEAVY_METAL, MaterialColor.COLOR_BLUE).requiresCorrectToolForDrops().strength(hardness, resistance).sound(SoundType.METAL));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    public boolean useShapeForLightOcclusion(BlockState p_220074_1_) {
        return true;
    }

    public VoxelShape getShape(BlockState p_220053_1_, BlockGetter p_220053_2_, BlockPos p_220053_3_, CollisionContext p_220053_4_) {
        return BASE_SHAPE;
    }

    public BlockState getStateForPlacement(BlockPlaceContext p_196258_1_) {
        return this.defaultBlockState().setValue(FACING, p_196258_1_.getHorizontalDirection().getOpposite());
    }


    public BlockState rotate(BlockState p_185499_1_, Rotation p_185499_2_) {
        return p_185499_1_.setValue(FACING, p_185499_2_.rotate(p_185499_1_.getValue(FACING)));
    }

    @SuppressWarnings("deprecation")
	public BlockState mirror(BlockState p_185471_1_, Mirror p_185471_2_) {
        return p_185471_1_.rotate(p_185471_2_.getRotation(p_185471_1_.getValue(FACING)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(FACING);
    }

    public static BlockPattern getOrCreatePortalShape() {
        if (portalShape == null) {
            portalShape = BlockPatternBuilder.start().aisle("?vvv?", ">???<", ">???<", ">???<", "?^^^?").where('?', BlockInWorld.hasState(BlockStatePredicate.ANY)).where('^', BlockInWorld.hasState(BlockStatePredicate.forBlock(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcana_portal_frame"))).where(FACING, Predicates.equalTo(Direction.SOUTH)))).where('>', BlockInWorld.hasState(BlockStatePredicate.forBlock(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcana_portal_frame"))).where(FACING, Predicates.equalTo(Direction.WEST)))).where('v', BlockInWorld.hasState(BlockStatePredicate.forBlock(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcana_portal_frame"))).where(FACING, Predicates.equalTo(Direction.NORTH)))).where('<', BlockInWorld.hasState(BlockStatePredicate.forBlock(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcana_portal_frame"))).where(FACING, Predicates.equalTo(Direction.EAST)))).build();
        }

        return portalShape;
    }

    public boolean isPathfindable(BlockState p_196266_1_, BlockGetter p_196266_2_, BlockPos p_196266_3_, PathComputationType p_196266_4_) {
        return false;
    }

    @Override
    public void neighborChanged(BlockState state, Level world, BlockPos pos, Block block, BlockPos pos2, boolean unknown) {
    	DebugPackets.sendNeighborsUpdatePacket(world, pos);
        if (world.getBlockState(pos2).getBlock().defaultBlockState() == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcana_portal")).defaultBlockState() || world.getBlockState(pos2).getBlock().defaultBlockState() == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcana_portal_frame")).defaultBlockState()) {
            BlockPattern.BlockPatternMatch frame = getOrCreatePortalShape().find(world, pos);
            if (frame != null) {
                BlockPos blockpos1 = frame.getFrontTopLeft().offset(-3, 0, -3);

                for (int i = 0; i < 3; ++i) {
                    for (int j = 0; j < 3; ++j) {
                        world.setBlock(blockpos1.offset(i, 0, j), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcana_portal")).defaultBlockState(), 2);
                    }
                }

                world.globalLevelEvent(1038, blockpos1.offset(1, 0, 1), 0);
            }
        }
    }

}
