package divinerpg.blocks.vethea;

import divinerpg.registries.EntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.*;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.*;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.*;

public class BlockHiveEgg extends FallingBlock {
    protected static final VoxelShape SHAPE = Block.box(1, 0, 1, 15, 16, 15);
    public BlockHiveEgg() {
        super(Properties.of().pushReaction(PushReaction.DESTROY).mapColor(MapColor.GRASS).strength(3, 9));
    }
    @Override public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
    @Override public boolean isPathfindable(BlockState state, BlockGetter getter, BlockPos pos, PathComputationType type) {
        return false;
    }
    @Override public InteractionResult use(BlockState state, Level world, BlockPos pos, Player playerEntity, InteractionHand hand, BlockHitResult result) {
        if(!world.isClientSide) {
            EntityRegistry.HIVE_QUEEN.get().spawn((ServerLevel) world, null, playerEntity, pos, MobSpawnType.MOB_SUMMONED, true, false);
            world.setBlock(pos, Blocks.AIR.defaultBlockState(), 0);
        } return InteractionResult.SUCCESS;
    }
}