package divinerpg.blocks.base;

import divinerpg.DivineRPG;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class BlockModLeaves extends LeavesBlock {

    public BlockModLeaves(String name, MaterialColor color, float hardness) {
        super(AbstractBlock.Properties.of(Material.LEAVES, color).strength(0.2F, hardness).randomTicks().sound(SoundType.GRASS).noOcclusion().isSuffocating(BlockModLeaves::never).isViewBlocking(BlockModLeaves::never));
        setRegistryName(DivineRPG.MODID, name);
        this.registerDefaultState(this.stateDefinition.any().setValue(DISTANCE, Integer.valueOf(7)).setValue(PERSISTENT, Boolean.valueOf(false)));
    }
    private static boolean never(BlockState state, IBlockReader reader, BlockPos pos) {
        return false;
    }

    //TODO - stop leave decay when attached to logs
}
