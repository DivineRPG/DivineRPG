package divinerpg.blocks.vethea;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class KarosHeatTile extends Block {
    public static final BooleanProperty ACTIVE = BooleanProperty.create("active");
    public KarosHeatTile(Properties properties) {
        super(properties);
        registerDefaultState(stateDefinition.any().setValue(ACTIVE, false));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {builder.add(ACTIVE);}
    @Override public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource random) {
        if(state.getValue(ACTIVE) && random.nextInt(5) == 0) worldIn.setBlock(pos, state.setValue(ACTIVE, false), 2);
    }
    @Override public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if(state.getValue(ACTIVE) && entity instanceof ServerPlayer) {
            entity.hurt(entity.damageSources().hotFloor(), 6);
            entity.igniteForSeconds(5);
        }
    }
}