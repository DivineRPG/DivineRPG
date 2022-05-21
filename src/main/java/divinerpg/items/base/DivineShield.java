package divinerpg.items.base;

import divinerpg.DivineRPG;
import divinerpg.client.renders.item.DivineShieldRenderer;
import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.ResourceLocation;

public class DivineShield extends ShieldItem {
    public ResourceLocation resource;
    private LazyValue<Ingredient> repairMaterial;

    public DivineShield(String name, Rarity rarity, Item repairMaterial, int damage) {
        super(new Item.Properties().tab(DivineRPG.tabs.armor).durability(damage).setISTER(() -> new DivineShieldRenderer()).rarity(rarity));
        setRegistryName(name);
        this.repairMaterial = new LazyValue<>(() -> Ingredient.of(repairMaterial));
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);

        resource = new ResourceLocation(DivineRPG.MODID, "textures/shield/" + name + ".png");
    }

    @Override
    public boolean isValidRepairItem(ItemStack shield, ItemStack repairItem) {
        return repairMaterial.get().test(repairItem) || super.isValidRepairItem(shield, repairItem);
    }

    @Override
    public boolean isShield(ItemStack stack, LivingEntity entity) {
        return true;
    }

}
