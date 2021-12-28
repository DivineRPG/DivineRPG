package divinerpg.items.vethea;

import divinerpg.DivineRPG;
import divinerpg.items.base.ItemModSword;
import divinerpg.util.RarityList;
import net.minecraft.item.IItemTier;

public class ItemVetheanSword extends ItemModSword {

    public ItemVetheanSword(IItemTier material, String name) {
        super(name, RarityList.COMMON, material, DivineRPG.tabs.vethea);
    }
}
