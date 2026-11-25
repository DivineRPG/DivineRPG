package divinerpg.registries;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

import java.util.function.Function;

public interface ItemPropertyOverride extends Function<Item.Properties, Item.Properties> {
    default ItemPropertyOverride then(ItemPropertyOverride properties) {
        return p -> properties.apply(apply(p));
    }
    ItemPropertyOverride
        COMMON = p -> p.rarity(Rarity.COMMON),
        UNCOMMON = p -> p.rarity(Rarity.UNCOMMON),
        RARE = p -> p.rarity(Rarity.RARE),
        EPIC = p -> p.rarity(Rarity.EPIC);
    ItemPropertyOverride //Item Properties
        PrareFireResistant = p -> p.rarity(Rarity.RARE).fireResistant();
}