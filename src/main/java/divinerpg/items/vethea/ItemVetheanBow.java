package divinerpg.items.vethea;

import divinerpg.*;
import divinerpg.enums.*;
import divinerpg.items.base.*;
import net.minecraft.item.*;

import java.util.function.*;

public class ItemVetheanBow extends ItemModBow {

    public ItemVetheanBow(String name, ArrowType arrowType, int uses, Supplier<Item> arrowSupplier) {
        super(name, arrowType, uses, arrowSupplier, new Item.Properties().tab(DivineRPG.tabs.vethea).durability(uses));
    }
}
