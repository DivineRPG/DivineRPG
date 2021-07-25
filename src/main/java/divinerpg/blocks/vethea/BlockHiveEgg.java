package divinerpg.blocks.vethea;

import divinerpg.entities.boss.*;
import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.player.*;
import net.minecraft.pathfinding.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.shapes.*;
import net.minecraft.world.*;

public class BlockHiveEgg extends FallingBlock {
    protected static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    public BlockHiveEgg(String name)
    {
        super(AbstractBlock.Properties.of(Material.EGG, MaterialColor.COLOR_BLACK).strength(5));
    setRegistryName(name);
    }

    public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
        return SHAPE;
    }

    public boolean isPathfindable(BlockState p_196266_1_, IBlockReader p_196266_2_, BlockPos p_196266_3_, PathType p_196266_4_) {
        return false;
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity playerEntity, Hand hand, BlockRayTraceResult result) {
        if(!world.isClientSide){
            EntityHiveQueen mob = new EntityHiveQueen(EntityRegistry.HIVE_QUEEN, world);
            mob.moveTo(pos, 0.0F, 0.0F);
            world.addFreshEntity(mob);
            world.setBlock(pos, Blocks.AIR.defaultBlockState(), 0);
        }
        return super.use(state, world, pos, playerEntity, hand, result);
    }
}
