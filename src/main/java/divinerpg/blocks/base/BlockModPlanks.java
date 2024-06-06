package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.MapColor;

public class BlockModPlanks extends BlockMod {
    public BlockModPlanks(MapColor color, SoundType sound) {
        super(Properties.copy(Blocks.OAK_PLANKS).mapColor(color).sound(sound));
        flammability = 20;
        fireSpread = 5;
    }
}