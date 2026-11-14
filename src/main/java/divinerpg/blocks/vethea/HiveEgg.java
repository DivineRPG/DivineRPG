package divinerpg.blocks.vethea;

import divinerpg.registries.EntityRegistry;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.*;

import static net.minecraft.ChatFormatting.AQUA;
import static net.minecraft.world.Difficulty.PEACEFUL;
import static net.minecraft.world.level.block.Blocks.AIR;

public class HiveEgg extends FallingBlock {
    protected static final VoxelShape SHAPE = box(1, 0, 1, 15, 16, 15);
    public HiveEgg(Properties properties) {super(properties);}
    @Override public int getDustColor(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {return 0;}
    @Override public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {}
    @Override public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {return SHAPE;}
    @Override public boolean isPathfindable(BlockState state, PathComputationType type) {return false;}
    @Override public InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult result) {
        if(world.getDifficulty() == PEACEFUL) {
            player.sendOverlayMessage(LocalizeUtils.clientMessage(AQUA, "boss.peaceful"));
            return InteractionResult.CONSUME;
        } else if(!world.isClientSide()) {
            EntityRegistry.HIVE_QUEEN.get().spawn((ServerLevel)world, null, player, pos, EntitySpawnReason.MOB_SUMMONED, true, false);
            world.setBlock(pos, AIR.defaultBlockState(), 0);
        } return InteractionResult.SUCCESS;
    }
}