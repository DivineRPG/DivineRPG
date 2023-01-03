package divinerpg.items.base;

import net.minecraft.world.item.*;

public class ItemModHoe extends HoeItem {
    public ItemModHoe(Tier tier) {
        super(tier, 0, -0.6F, new Item.Properties());
    }
    public ItemModHoe(Tier tier, Properties properties) {
        super(tier, 0, -0.6F, properties);
    }

}