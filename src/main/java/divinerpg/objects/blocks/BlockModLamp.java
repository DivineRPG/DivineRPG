package divinerpg.objects.blocks;

import divinerpg.enums.EnumBlockType;

public class BlockModLamp extends BlockMod {

    public BlockModLamp(EnumBlockType blockType, String name, float hardness) {
        super(blockType, name, hardness);
        this.setLightLevel(1.0F);
    }
}
