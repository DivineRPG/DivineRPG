package divinerpg.blocks.arcana;

import divinerpg.DivineRPG;
import net.minecraft.core.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;

public class BlockArcaniteVinesBody extends WeepingVinesPlantBlock {

	public BlockArcaniteVinesBody(Properties properties) {
        super(properties);
    }

	@Override
    protected GrowingPlantHeadBlock getHeadBlock() {
        return (GrowingPlantHeadBlock) BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "arcanite_vines_head"));
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader p_255931_, BlockPos p_256046_, BlockState p_256550_) {
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
