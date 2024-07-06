package divinerpg.blocks.arcana;

import divinerpg.blocks.base.BlockMod;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.*;
import net.minecraft.world.phys.shapes.*;

public class BlockElevantium extends BlockMod {
    protected static final VoxelShape ELEVANTIUM = Shapes.or(box(1, 0, 1, 15, 1, 15),
                                                             box(4.5, 1, 4.5, 11.5, 2, 11.5));
    public BlockElevantium() {
        super(Properties.copy(Blocks.DIAMOND_BLOCK).mapColor(MapColor.COLOR_LIGHT_BLUE).pushReaction(PushReaction.DESTROY).jumpFactor(2));
    }
    @Override public void stepOn(Level world, BlockPos pos, BlockState state, Entity entity) {
        super.stepOn(world, pos, state, entity);
        entity.setDeltaMovement(entity.getDeltaMovement().x, 1, entity.getDeltaMovement().z);
    }
    @Override public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return ELEVANTIUM;
    }
    @Override public VoxelShape getCollisionShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return Shapes.create(ELEVANTIUM.bounds().inflate(.0625, .125, .0625));
    }
}