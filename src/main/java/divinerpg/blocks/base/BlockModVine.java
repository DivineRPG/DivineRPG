package divinerpg.blocks.base;

import net.minecraft.block.*;
import net.minecraft.block.material.*;

public class BlockModVine extends VineBlock {
    public BlockModVine(String name) {
        super(Block.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_LIGHT_BLUE)
                .requiresCorrectToolForDrops()
                .dynamicShape()
                .randomTicks()
                .noCollission()
                .noOcclusion()
                .strength(2.0F, 3.0F)
                .sound(SoundType.WET_GRASS));
        setRegistryName(name);
    }
}
