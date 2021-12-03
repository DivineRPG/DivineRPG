package divinerpg.blocks.vethea;

import divinerpg.blocks.base.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class BlockLightCrystal extends BlockMod {
    public BlockLightCrystal(String name, float hardness) {
        super(name, AbstractBlock.Properties.of(Material.GLASS).strength(hardness));
    }

    @Override
    public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
        return 16;
    }
}
