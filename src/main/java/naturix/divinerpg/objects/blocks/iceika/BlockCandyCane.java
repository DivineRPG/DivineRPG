package naturix.divinerpg.objects.blocks.iceika;

import naturix.divinerpg.objects.blocks.vanilla.VanillaBlock;
import naturix.divinerpg.utils.material.EnumBlockType;

public class BlockCandyCane extends VanillaBlock {
    protected String name;

    public BlockCandyCane(String name) {
        super(EnumBlockType.ROCK, name, 1.0F, 2);
        setResistance(1.0F);
    }
}
