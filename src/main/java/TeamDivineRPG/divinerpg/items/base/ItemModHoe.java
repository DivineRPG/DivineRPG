package TeamDivineRPG.divinerpg.items.base;

import TeamDivineRPG.divinerpg.DivineRPG;
import net.minecraft.item.*;

public class ItemModHoe extends HoeItem {
    public ItemModHoe(IItemTier tier, String name) {
        super(tier, 0, -0.6F, new Item.Properties().group(DivineRPG.tabs.tools));
        setRegistryName(name);
    }

}