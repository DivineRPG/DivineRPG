package divinerpg.objects.blocks;

import divinerpg.enums.EnumBlockType;
import divinerpg.enums.WoodType;
import divinerpg.registry.DivineRPGTabs;

public class BlockModPlank extends BlockMod {
    public WoodType type;
    public String name;
    public BlockModPlank(WoodType woodType) {
        super(EnumBlockType.WOOD, woodType.getName() + "_planks", woodType.getHardness(), DivineRPGTabs.BlocksTab);
        setResistance(5);
        this.type = woodType;
        this.name = woodType.getName() + "_planks";
    }

    public WoodType getWoodType() {
        return this.type;
    }
}
