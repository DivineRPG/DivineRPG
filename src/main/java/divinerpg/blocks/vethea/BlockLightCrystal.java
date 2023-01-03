package divinerpg.blocks.vethea;

import divinerpg.blocks.base.*;
import net.minecraft.core.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.*;

public class BlockLightCrystal extends BlockMod {
    public BlockLightCrystal(float hardness) {
        super(BlockBehaviour.Properties.of(Material.GLASS).strength(hardness));
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        return 16;
    }
}
