package divinerpg.api.armor.registry;

import divinerpg.api.armor.IEquipped;
import divinerpg.api.armor.IFullSetInfo;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.registries.IForgeRegistryEntry;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Represents power set
 */
public interface IArmorDescription extends IForgeRegistryEntry<IArmorDescription> {

    /**
     * Get all possible event handlers. Unmodifiable!
     *
     * @return
     */
    List<IForgeEvent<?>> getHandlers();

    /**
     * Gets handler on wearing status change
     *
     * @return
     */
    @Nullable
    IEquipped getEquippedHandler();

    /**
     * Gets possible items from slot id.
     *
     * @param slot
     * @return
     */
    Set<Item> getPossibleItems(EntityEquipmentSlot slot);

    /**
     * Returns full set perks from possible items
     *
     * @return
     */
    default ITextComponent getFullSetPerks() {
        Set<ITextComponent> perks = Arrays.stream(EntityEquipmentSlot.values()).map(this::getPossibleItems)
                .filter(x -> x instanceof IFullSetInfo)
                .map(x -> ((IFullSetInfo) x).getFullSetPerks())
                .collect(Collectors.toSet());

        TextComponentString result = new TextComponentString("");

        perks.forEach(result::appendSibling);

        return result;
    }
}
