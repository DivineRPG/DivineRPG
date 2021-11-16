package divinerpg.blocks.base;

import divinerpg.DivineRPG;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.world.server.*;

import java.util.*;

public class BlockModLeaves extends LeavesBlock {

    public BlockModLeaves(String name, MaterialColor color, float hardness) {
        super(AbstractBlock.Properties.of(Material.LEAVES, color).strength(0.2F, hardness).randomTicks().sound(SoundType.GRASS).noOcclusion().isSuffocating(BlockModLeaves::never).isViewBlocking(BlockModLeaves::never));
        setRegistryName(DivineRPG.MODID, name);
        this.registerDefaultState(this.stateDefinition.any().setValue(DISTANCE, Integer.valueOf(7)).setValue(PERSISTENT, Boolean.valueOf(false)));
    }
    private static boolean never(BlockState state, IBlockReader reader, BlockPos pos) {
        return false;
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!state.getValue(PERSISTENT) && state.getValue(DISTANCE) >= 7) {
            dropResources(state, world, pos);
            world.removeBlock(pos, false);
        }

    }
}
