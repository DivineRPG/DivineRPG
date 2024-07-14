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
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
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
