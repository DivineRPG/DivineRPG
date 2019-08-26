package divinerpg.objects.blocks.iceika;

import divinerpg.enums.EnumBlockType;
import divinerpg.objects.blocks.vanilla.VanillaBlock;

public class BlockCandyCane extends VanillaBlock {
    protected String name;

    public BlockCandyCane(String name) {
        super(EnumBlockType.ROCK, name, 1.0F, 2);
        setResistance(1.0F);
    }
}
