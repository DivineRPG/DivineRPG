package divinerpg.blocks.base;

import divinerpg.DivineRPG;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class BlockModLeaves extends LeavesBlock {

    public BlockModLeaves(String name, MaterialColor color, float hardness) {
        super(Block.Properties.of(Material.LEAVES, color).dynamicShape().requiresCorrectToolForDrops().strength(1, 3.0F).sound(SoundType.WET_GRASS).noOcclusion().isViewBlocking(BlockModLeaves::never));
        setRegistryName(DivineRPG.MODID, name);
    }
    private static boolean never(BlockState state, IBlockReader reader, BlockPos pos) {
        return false;
    }
}
