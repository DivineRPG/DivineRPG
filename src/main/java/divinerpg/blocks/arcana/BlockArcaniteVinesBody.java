package divinerpg.blocks.arcana;

import divinerpg.registries.BlockRegistry;
import net.minecraft.core.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;

public class BlockArcaniteVinesBody extends WeepingVinesPlantBlock {

	public BlockArcaniteVinesBody(Properties properties) {
        super(properties);
    }

	@Override
    protected GrowingPlantHeadBlock getHeadBlock() {
        return (GrowingPlantHeadBlock) BlockRegistry.arcaniteVinesHead.get();
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader p_255931_, BlockPos p_256046_, BlockState p_256550_, boolean p_256181_) {
        return false;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
        return 60;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
        return 15;
    }
}
