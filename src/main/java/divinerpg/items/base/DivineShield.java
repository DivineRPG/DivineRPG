package divinerpg.items.base;

import divinerpg.DivineRPG;
import divinerpg.client.renders.item.DivineShieldRenderer;
import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;

public class DivineShield extends ShieldItem {
    public ResourceLocation resource = new ResourceLocation("");

    public DivineShield(String name, Rarity rarity, ItemGroup group, Item repairMaterial, int damage) {
        super(new Item.Properties().tab(group).durability(damage).setISTER(() -> new DivineShieldRenderer()).rarity(rarity));
        setRegistryName(name);
        this.isRepairable(new ItemStack(repairMaterial));
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);

        resource = new ResourceLocation(DivineRPG.MODID, "textures/shield/" + name + ".png");
    }

    @Override
    public boolean isShield(ItemStack stack, LivingEntity entity) {
        return true;
    }

}
