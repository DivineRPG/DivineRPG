package naturix.divinerpg.objects.blocks;

import naturix.divinerpg.enums.WoodType;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.utils.material.EnumBlockType;

public class BlockModPlank extends BlockMod {

    public BlockModPlank(WoodType woodType) {
        super(EnumBlockType.WOOD, woodType.getMapColor(), woodType.getName() + "_planks", woodType.getHardness(),
                DRPGCreativeTabs.BlocksTab);
        setResistance(5);
    }
}
