package divinerpg.objects.items.vethea;

import divinerpg.enums.ArrowType;
import divinerpg.objects.items.base.ItemModBow;
import divinerpg.registry.DivineRPGTabs;
import net.minecraft.item.Item;

import java.util.function.Supplier;

public class ItemVetheanBow extends ItemModBow {

    public ItemVetheanBow(String name, ArrowType arrowType, int uses, Supplier<Item> arrowSupplier) {
        super(name, arrowType, uses, arrowSupplier);
        this.setCreativeTab(DivineRPGTabs.VETHEA);
    }
}
