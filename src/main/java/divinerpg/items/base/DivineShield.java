package divinerpg.items.base;

import divinerpg.*;
import divinerpg.client.renders.item.*;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.util.*;

public class DivineShield extends ShieldItem {
    public ResourceLocation resource = new ResourceLocation("");

    public DivineShield(String name, ItemGroup group, Item repairMaterial, int damage) {
        super(new Item.Properties().tab(group).defaultDurability(damage).setISTER(() -> new DivineShieldRenderer()));
        setRegistryName(name);
        this.isRepairable(new ItemStack(repairMaterial));
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);

        resource = new ResourceLocation(DivineRPG.MODID, "textures/shield/" + name + ".png");
    }

}
