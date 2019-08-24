package divinerpg.objects.blocks.iceika;

import divinerpg.objects.blocks.vanilla.VanillaBlock;
import divinerpg.utils.material.EnumBlockType;

public class BlockCandyCane extends VanillaBlock {
    protected String name;

    public BlockCandyCane(String name) {
        super(EnumBlockType.ROCK, name, 1.0F, 2);
        setResistance(1.0F);
    }
}
