package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.*;

public class BlockModDirt extends BlockMod {
    public BlockModDirt(MapColor color) {
        super(Block.Properties.of().mapColor(color).strength(0.5F).sound(SoundType.ROOTED_DIRT));
    }
}
