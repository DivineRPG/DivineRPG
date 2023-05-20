package divinerpg.blocks.vethea;

import divinerpg.registries.EntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.*;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.*;

public class BlockHiveEgg extends FallingBlock {
    protected static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    public BlockHiveEgg()
    {
        super(BlockBehaviour.Properties.of(Material.EGG, MaterialColor.SNOW).strength(3F, 9F));
    }

    public VoxelShape getShape(BlockState p_220053_1_, BlockGetter p_220053_2_, BlockPos p_220053_3_, CollisionContext p_220053_4_) {
        return SHAPE;
    }

    public boolean isPathfindable(BlockState p_196266_1_, BlockGetter p_196266_2_, BlockPos p_196266_3_, PathComputationType p_196266_4_) {
        return false;
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player playerEntity, InteractionHand hand, BlockHitResult result) {
        if(!world.isClientSide){
            EntityRegistry.HIVE_QUEEN.get().spawn((ServerLevel) world, null, playerEntity, pos, MobSpawnType.MOB_SUMMONED, true, false);
            world.setBlock(pos, Blocks.AIR.defaultBlockState(), 0);
        }
        return InteractionResult.PASS;
    }
}
