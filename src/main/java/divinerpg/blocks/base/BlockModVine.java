package divinerpg.blocks.base;

import net.minecraft.block.*;
import net.minecraft.block.material.*;

public class BlockModVine extends VineBlock {
    public BlockModVine(String name) {
        super(Block.Properties.create(Material.TALL_PLANTS, MaterialColor.LIGHT_BLUE)
                .setRequiresTool()
                .notSolid()
                .tickRandomly()
                .doesNotBlockMovement()
                .hardnessAndResistance(2.0F, 3.0F)
                .sound(SoundType.PLANT));
        setRegistryName(name);
    }
}
