package TeamDivineRPG.divinerpg.blocks.arcana;

import TeamDivineRPG.divinerpg.blocks.base.BlockModUnbreakable;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.Entity;
import net.minecraft.state.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class BlockHeatTrap extends BlockModUnbreakable {
    public static final BooleanProperty ACTIVE = BooleanProperty.create("active");

    public BlockHeatTrap(String name) {
        super(name, Block.Properties.create(Material.ROCK, MaterialColor.LAPIS).tickRandomly().func_235861_h_().hardnessAndResistance(-1, 3600000.0F).sound(SoundType.STONE));
        this.setDefaultState(this.stateContainer.getBaseState().with(ACTIVE, Boolean.valueOf(false)));
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(ACTIVE);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        boolean i = state.get(ACTIVE);
        if (i == true && random.nextInt(5) == 0) {
            worldIn.setBlockState(pos, state.with(ACTIVE, Boolean.valueOf(false)), 2);
        }

    }

    @Override
    public void onEntityCollision(BlockState p_196262_1_, World p_196262_2_, BlockPos p_196262_3_, Entity entity) {
        System.out.println("colliding");

        super.onEntityCollision(p_196262_1_, p_196262_2_, p_196262_3_, entity);
    }
}
