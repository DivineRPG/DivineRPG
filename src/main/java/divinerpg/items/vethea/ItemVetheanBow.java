package divinerpg.items.vethea;

import divinerpg.enums.ArrowType;
import divinerpg.items.base.ItemModBow;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class ItemVetheanBow extends ItemModBow {

    public ItemVetheanBow(ArrowType arrowType, int uses, ResourceLocation arrowSupplier) {
        super(arrowType, uses, arrowSupplier, new Item.Properties().durability(uses));
    }
}
