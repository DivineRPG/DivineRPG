package naturix.divinerpg.objects.blocks;

import naturix.divinerpg.enums.WoodType;
import naturix.divinerpg.registry.DivineRPGTabs;
import naturix.divinerpg.utils.material.EnumBlockType;

public class BlockModPlank extends BlockMod {

    public BlockModPlank(WoodType woodType) {
        super(EnumBlockType.WOOD, woodType.getMapColor(), woodType.getName() + "_planks", woodType.getHardness(),
                DivineRPGTabs.BlocksTab);
        setResistance(5);
    }
}
