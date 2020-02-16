package divinerpg.events.armor;

import divinerpg.DivineRPG;
import divinerpg.api.java.divinerpg.api.armor14.IEquipped;
import divinerpg.api.java.divinerpg.api.armor14.IPoweredArmorSet;
import divinerpg.api.java.divinerpg.api.events.IsEquippedEvent;
import divinerpg.networking.message.EquipmentChangeMessage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Event;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Observing armor changing. Works only with Item, not ItemStack
 */
public class ArmorObserver {
    private final List<IPoweredArmorSet> allPossible;

    // storing all in NBT tag
    private final NBTTagCompound stored = new NBTTagCompound();

    private final List<IPoweredArmorSet> current = new ArrayList<>();

    public ArmorObserver(EntityPlayer player, List<IPoweredArmorSet> allPossible) {
        this.allPossible = allPossible;

        Update(player);
    }

    /**
     * Should calls every tick to detect changes
     */
    public void Update(EntityPlayer e) {
        if (!checkAndStore(e.inventory))
            return;

        boolean wasChanged = false;

        for (IPoweredArmorSet armorSet : allPossible) {
            IsEquippedEvent event = new IsEquippedEvent(e, armorSet);
            MinecraftForge.EVENT_BUS.post(event);

            boolean isActive = current.contains(armorSet);

            // status wasn't changed
            if (isActive == event.isEquipped())
                continue;

            wasChanged = true;

            if (event.isEquipped()) {
                current.add(armorSet);
            } else {
                current.remove(armorSet);
            }

            // Should work on both sides
            IEquipped equippedHandler = armorSet.getEquippedHandler();

            if (equippedHandler != null)
                equippedHandler.onEquppedChanged(e, event.isEquipped());
        }

        // send message to server only if changes was detected
        // todo think about safety.
        // But most of player interactions is performed on server
        // so I don't think there is some hack problem
        if (e.getEntityWorld().isRemote && wasChanged)
            DivineRPG.network.sendToServer(new EquipmentChangeMessage());
    }

    /**
     * Detect and save player invertory changes
     *
     * @param inventory - player inventory
     * @return - was inventory changed
     */
    private boolean checkAndStore(InventoryPlayer inventory) {
        NonNullList<ItemStack> armor = load("armor", 4);
        NonNullList<ItemStack> off = load("off", 1);
        NonNullList<ItemStack> ring = load("ring", 1);

        boolean changed = false;

        if (!stacksEquals(armor, inventory.armorInventory)) {
            armor = inventory.armorInventory;
            changed = true;
        }

        if (!stacksEquals(off, inventory.offHandInventory)) {
            off = inventory.offHandInventory;
            changed = true;
        }

        if (changed) {
            stored.removeTag("armor");
            stored.removeTag("off");

            stored.setTag("armor", ItemStackHelper.saveAllItems(new NBTTagCompound(), armor));
            stored.setTag("off", ItemStackHelper.saveAllItems(new NBTTagCompound(), off));
        }

        return changed;
    }

    /**
     * Load items from tag name
     *
     * @param key - tag name
     * @return - loaded items or empty list
     */
    private NonNullList<ItemStack> load(String key, int size) {
        NBTTagCompound tag = stored.getCompoundTag(key);
        NonNullList<ItemStack> result = NonNullList.withSize(size, ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(tag, result);
        return result;
    }

    /**
     * Comparing items in stacks
     *
     * @param fromTag - first stacks collection
     * @param right   - second stacks collection
     * @return - equalituy status
     */
    private boolean stacksEquals(List<ItemStack> fromTag, List<ItemStack> right) {
        // hack ItemStackHelper.saveAllItems saves empty array as ITemStack[1] with AIR
        if (right.isEmpty()) {
            return fromTag.isEmpty() || fromTag.stream().allMatch(ItemStack::isEmpty);
        }

        if (fromTag.size() != right.size()) {
            return false;
        }

        for (int i = fromTag.size() - 1; i >= 0; i--) {
            ItemStack x = fromTag.get(i);
            ItemStack y = right.get(i);

            if (x.isEmpty() && y.isEmpty())
                continue;

            if (!x.isItemEqual(y))
                return false;
        }

        return true;
    }

    /**
     * Find stask with current item
     *
     * @param inventory - player inventory
     * @param stack     - searching item
     * @return matching stacks
     */
    private NonNullList<ItemStack> find(InventoryPlayer inventory, ItemStack stack) {
        NonNullList<ItemStack> result = NonNullList.create();

        Stream<ItemStack> finded = Stream.of(inventory.armorInventory, inventory.mainInventory, inventory.offHandInventory).flatMap(Collection::stream)
                .filter(x -> x.isItemEqual(stack));

        result.addAll(finded.collect(Collectors.toList()));

        return result;
    }

    public <T extends Event> void Handle(T event) {
        current.forEach(x -> x.handleAbility(event));
    }

    public boolean isOn(ResourceLocation armorSetID) {
        return current.stream().anyMatch(x -> armorSetID.equals(x.getRegistryName()));
    }
}
