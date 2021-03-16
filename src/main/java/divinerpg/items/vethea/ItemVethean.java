package divinerpg.items.vethea;

import divinerpg.DivineRPG;
import divinerpg.items.base.ItemMod;
import net.minecraft.item.Item;

public class ItemVethean extends ItemMod {
    public ItemVethean(String name) {
        super(name, new Item.Properties().tab(DivineRPG.tabs.vethea));
    }
}
