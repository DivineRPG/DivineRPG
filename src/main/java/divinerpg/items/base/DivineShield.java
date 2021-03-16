package divinerpg.items.base;

import net.minecraft.block.DispenserBlock;
import net.minecraft.item.*;

public class DivineShield extends ShieldItem {
    public DivineShield(String name, ItemGroup group, Item repairMaterial, int damage) {
        super(new Item.Properties().tab(group).defaultDurability(damage));
        setRegistryName(name);
        this.isRepairable(new ItemStack(repairMaterial));
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);
    }

}
