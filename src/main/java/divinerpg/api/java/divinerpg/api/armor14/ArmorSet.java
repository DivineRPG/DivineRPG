package divinerpg.api.java.divinerpg.api.armor14;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArmorSet implements IArmorSet {
    private final ArrayList<Item> helmets = new ArrayList<>();
    private final ArrayList<Item> chests = new ArrayList<>();
    private final ArrayList<Item> legs = new ArrayList<>();
    private final ArrayList<Item> boots = new ArrayList<>();
    private final ArrayList<Item> shields = new ArrayList<>();

    @Override
    public IArmorSet withVariant(Item helmet, Item chest, Item legs, Item boots) {
        return withVariant(helmet, chest, legs, boots, null);
    }

    @Override
    public IArmorSet withVariant(Item helmet, Item chest, Item legs, Item boots, Item shield) {
        carefullyAdd(helmets, helmet);
        carefullyAdd(chests, chest);
        carefullyAdd(this.legs, legs);
        carefullyAdd(this.boots, boots);
        carefullyAdd(shields, shield);

        return this;
    }

    @Override
    public IArmorSet withVariants(Item[] helmet, Item[] chest, Item[] legs, Item[] boots, Item[] shields) {
        carefullyAdd(helmets, helmet);
        carefullyAdd(chests, chest);
        carefullyAdd(this.legs, legs);
        carefullyAdd(this.boots, boots);
        carefullyAdd(this.shields, shields);

        return this;
    }

    @Override
    public boolean isEquipped(EntityPlayer entity) {
        NonNullList<ItemStack> armorInventory = entity.inventory.armorInventory;
        if (armorInventory.isEmpty())
            return false;

        return isEmptyOrContains(helmets, armorInventory.get(3).getItem())
                && isEmptyOrContains(chests, armorInventory.get(2).getItem())
                && isEmptyOrContains(legs, armorInventory.get(1).getItem())
                && isEmptyOrContains(boots, armorInventory.get(0).getItem())
                && isEmptyOrContains(shields, entity.inventory.offHandInventory.get(0).getItem());
    }

    private boolean isEmptyOrContains(List<Item> list, Item item) {
        return list.isEmpty() || list.contains(item);
    }

    private void carefullyAdd(List<Item> list, Item... items) {
        if (items != null && list != null) {
            // Search for not null objects, not contains in list
            Arrays.stream(items).filter(x -> x != null && !list.contains(x))
                    .forEach(list::add);
        }
    }
}
