package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.*;

public class BlockModDirt extends BlockMod {
    public BlockModDirt(float hardness, MaterialColor color) {
        super(Block.Properties.of(Material.DIRT, color).strength(hardness, 3.0F).sound(SoundType.ROOTED_DIRT));
    }
}
