package divinerpg.objects.blocks.iceika;

import divinerpg.enums.EnumBlockType;
import divinerpg.objects.blocks.BlockMod;

public class BlockCandyCane extends BlockMod {

    public BlockCandyCane(String name) {
        super(EnumBlockType.ROCK, name, 1.0F);
        this.setResistance(1.0F);
    }
}
