package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.MapColor;

public class BlockModPlanks extends BlockMod {
    public BlockModPlanks(MapColor color) {
        super(Block.Properties.of().mapColor(color).strength(2.0F, 3.0F).sound(SoundType.WOOD));
    }
}
