package divinerpg.objects.blocks;

import divinerpg.enums.EnumBlockType;

public class BlockModUnbreakable extends BlockMod {

    public BlockModUnbreakable(EnumBlockType blockType, String name) {
        super(blockType, name, -1F);
        this.setResistance(6000000F);
    }

    public BlockModUnbreakable(String name) {
        this(EnumBlockType.ROCK, name);
    }
}
