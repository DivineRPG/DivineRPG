package divinerpg.blocks.vethea;

import com.mojang.serialization.MapCodec;
import divinerpg.registries.EntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.*;

import static net.minecraft.world.level.block.Blocks.AIR;

public class BlockHiveEgg extends FallingBlock {
    public static final MapCodec<BlockHiveEgg> CODEC = simpleCodec(BlockHiveEgg::new);
    protected static final VoxelShape SHAPE = box(1, 0, 1, 15, 16, 15);
    @Override public MapCodec<BlockHiveEgg> codec() {return CODEC;}
    public BlockHiveEgg(Properties properties) {super(properties);}
    @Override public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {return SHAPE;}
    @Override public boolean isPathfindable(BlockState state, PathComputationType type) {return false;}
    @Override public InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult result) {
        if(!world.isClientSide){
            EntityRegistry.HIVE_QUEEN.get().spawn((ServerLevel)world, null, player, pos, MobSpawnType.MOB_SUMMONED, true, false);
            world.setBlock(pos, AIR.defaultBlockState(), 0);
        } return InteractionResult.SUCCESS;
    }
}