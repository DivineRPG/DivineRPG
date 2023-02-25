package divinerpg.items.base;

import divinerpg.*;
import net.minecraft.world.item.*;

public class ItemModHoe extends HoeItem {
    public ItemModHoe(Tier tier) {
        super(tier, 0, -0.6F, new Item.Properties().tab(DivineRPG.tabs.tools));
    }
    public ItemModHoe(Tier tier, Properties properties) {
        super(tier, 0, -0.6F, properties.tab(DivineRPG.tabs.tools));
    }

}