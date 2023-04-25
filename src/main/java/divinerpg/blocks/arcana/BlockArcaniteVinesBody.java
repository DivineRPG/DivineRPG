package divinerpg.blocks.arcana;

import divinerpg.DivineRPG;
import net.minecraft.core.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockArcaniteVinesBody extends WeepingVinesPlantBlock {
	public BlockArcaniteVinesBody(Properties properties) {super(properties);}
	@Override protected GrowingPlantHeadBlock getHeadBlock() {return (GrowingPlantHeadBlock) ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcanite_vines_head"));}

        @Override
        public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
            return 60;
        }

        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
            return 15;
    }
}
