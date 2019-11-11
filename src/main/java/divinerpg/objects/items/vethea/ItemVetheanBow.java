package divinerpg.objects.items.vethea;

import divinerpg.enums.ArrowType;
import divinerpg.objects.items.base.ItemModBow;
import divinerpg.registry.DivineRPGTabs;
import net.minecraft.item.Item;

public class ItemVetheanBow extends ItemModBow {

    public ItemVetheanBow(String name, ArrowType arrowType, int uses, Item arrow) {
        super(name, arrowType, uses, arrow);
        this.setCreativeTab(DivineRPGTabs.vethea);
    }
}
