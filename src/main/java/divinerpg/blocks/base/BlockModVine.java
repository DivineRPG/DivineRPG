package divinerpg.blocks.base;

import net.minecraft.block.*;
import net.minecraft.block.material.*;

public class BlockModVine extends VineBlock {
    public BlockModVine(String name) {
        super(Block.Properties.create(Material.TALL_PLANTS, MaterialColor.LIGHT_BLUE)
                .func_235861_h_()
                .notSolid()
                .tickRandomly()
                .doesNotBlockMovement()
                .hardnessAndResistance(2.0F, 3.0F)
                .sound(SoundType.field_235601_w_));
        setRegistryName(name);
    }
}
