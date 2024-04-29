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
import net.minecraft.world.level.material.*;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.*;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockArcanaPortalFrame extends BlockMod {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    protected static final VoxelShape BASE_SHAPE = Block.box(0, 0, 0, 16, 13, 16);
    private static BlockPattern portalShape;
    public BlockArcanaPortalFrame(float hardness, float resistance) {
        super(Properties.of().mapColor(MapColor.COLOR_BLUE).requiresCorrectToolForDrops().pushReaction(PushReaction.BLOCK).strength(hardness, resistance).sound(SoundType.METAL));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }
    @Override public boolean useShapeForLightOcclusion(BlockState state) {return true;}
    @Override public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {return BASE_SHAPE;}
    @Override public BlockState getStateForPlacement(BlockPlaceContext context) {return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());}
    @Override public BlockState rotate(BlockState state, Rotation rot) {return state.setValue(FACING, rot.rotate(state.getValue(FACING)));}
    @SuppressWarnings("deprecation")
	@Override public BlockState mirror(BlockState state, Mirror mirror) {return state.rotate(mirror.getRotation(state.getValue(FACING)));}
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> state) {state.add(FACING);}
    public static BlockPattern getOrCreatePortalShape() {
        if(portalShape == null) portalShape = BlockPatternBuilder.start().aisle("?vvv?", ">???<", ">???<", ">???<", "?^^^?").where('?', BlockInWorld.hasState(BlockStatePredicate.ANY)).where('^', BlockInWorld.hasState(BlockStatePredicate.forBlock(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcana_portal_frame"))).where(FACING, Predicates.equalTo(Direction.SOUTH)))).where('>', BlockInWorld.hasState(BlockStatePredicate.forBlock(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcana_portal_frame"))).where(FACING, Predicates.equalTo(Direction.WEST)))).where('v', BlockInWorld.hasState(BlockStatePredicate.forBlock(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcana_portal_frame"))).where(FACING, Predicates.equalTo(Direction.NORTH)))).where('<', BlockInWorld.hasState(BlockStatePredicate.forBlock(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcana_portal_frame"))).where(FACING, Predicates.equalTo(Direction.EAST)))).build();
        return portalShape;
    }
    @Override public boolean isPathfindable(BlockState state, BlockGetter getter, BlockPos pos, PathComputationType type) {return false;}
    @Override public void neighborChanged(BlockState state, Level world, BlockPos pos, Block block, BlockPos pos2, boolean unknown) {
    	DebugPackets.sendNeighborsUpdatePacket(world, pos);
        if(world.getBlockState(pos2).getBlock().defaultBlockState() == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcana_portal")).defaultBlockState() || world.getBlockState(pos2).getBlock().defaultBlockState() == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcana_portal_frame")).defaultBlockState()) {
            BlockPattern.BlockPatternMatch frame = getOrCreatePortalShape().find(world, pos);
            if(frame != null) {
                BlockPos blockpos1 = frame.getFrontTopLeft().offset(-3, 0, -3);
                for(int i = 0; i < 3; ++i) {
                    for(int j = 0; j < 3; ++j) world.setBlock(blockpos1.offset(i, 0, j), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcana_portal")).defaultBlockState(), 2);
                }
                world.globalLevelEvent(1038, blockpos1.offset(1, 0, 1), 0);
            }
        }
    }
}