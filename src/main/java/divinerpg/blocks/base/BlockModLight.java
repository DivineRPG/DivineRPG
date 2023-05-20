package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.*;

public class BlockModLight extends BlockModPowered {
    public BlockModLight() {
        super(Block.Properties.of(Material.GLASS, MaterialColor.COLOR_GRAY).strength(0.3F).sound(SoundType.GLASS));
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        return state.getValue(POWERED) ? 15 : 0;
    }
}
