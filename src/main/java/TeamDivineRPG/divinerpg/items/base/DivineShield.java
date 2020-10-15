package TeamDivineRPG.divinerpg.items.base;

import net.minecraft.block.DispenserBlock;
import net.minecraft.item.*;

public class DivineShield extends ShieldItem {
    public DivineShield(String name, ItemGroup group, Item repairMaterial, int damage) {
        super(new Item.Properties().group(group).maxDamage(damage));
        setRegistryName(name);
        this.isRepairable(new ItemStack(repairMaterial));
        DispenserBlock.registerDispenseBehavior(this, ArmorItem.DISPENSER_BEHAVIOR);
    }

}
