package divinerpg.items.base;

import divinerpg.client.renders.item.DivineShieldRenderer;
import divinerpg.util.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Unbreakable;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.*;
import net.minecraft.world.level.block.DispenserBlock;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

import java.util.function.Consumer;

import static divinerpg.DivineRPG.MODID;
import static net.minecraft.core.component.DataComponents.UNBREAKABLE;
import static net.minecraft.world.item.ArmorItem.DISPENSE_ITEM_BEHAVIOR;

public class ItemDivineShield extends ShieldItem {
    public ResourceLocation resource;
    public Integer nameColor;
    private final Ingredient repairMaterial;
    public ItemDivineShield(int nameColor, TagKey<Item> repairMaterial, int durability, String name) {
        super((durability == 0 ? new Properties().component(UNBREAKABLE, new Unbreakable(true)) : new Properties().durability(durability)));
        this.repairMaterial = Ingredient.of(repairMaterial);
        DispenserBlock.registerBehavior(this, DISPENSE_ITEM_BEHAVIOR);
        resource = ResourceLocation.fromNamespaceAndPath(MODID, "entity/shield/" + name + "_shield");
        this.nameColor = nameColor;
    }
    public ItemDivineShield(TagKey<Item> repairMaterial, int durability, String name) {
        super((durability == 0 ? new Properties().component(UNBREAKABLE, new Unbreakable(true)) : new Properties().durability(durability)));
        this.repairMaterial = Ingredient.of(repairMaterial);
        DispenserBlock.registerBehavior(this, DISPENSE_ITEM_BEHAVIOR);
        resource = ResourceLocation.fromNamespaceAndPath(MODID, "entity/shield/" + name + "_shield");
    }
    @Override public boolean isValidRepairItem(ItemStack shield, ItemStack repairItem) {
        if(repairMaterial != null) return repairMaterial.test(repairItem);
        else return super.isValidRepairItem(shield, repairItem);
    }
    @SuppressWarnings("removal")
    @Override public void initializeClient(Consumer<IClientItemExtensions> consumer) {consumer.accept(RenderProps.INSTANCE);}
    static class RenderProps implements IClientItemExtensions {
        public static RenderProps INSTANCE = new RenderProps();
        @Override public BlockEntityWithoutLevelRenderer getCustomRenderer() {return new DivineShieldRenderer(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());}
    }
    @Override public boolean isEnchantable(ItemStack stack) {return true;}
    @Override public boolean supportsEnchantment(ItemStack stack, Holder<Enchantment> enchantment) {
        return super.supportsEnchantment(stack, enchantment) && !(stack.has(UNBREAKABLE) && (enchantment.is(Enchantments.MENDING) || enchantment.is(Enchantments.UNBREAKING)));
    }
    @Override public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return !(stack.has(UNBREAKABLE) && (Utils.hasStoredEnchantment(Enchantments.MENDING, book) || Utils.hasStoredEnchantment(Enchantments.UNBREAKING, book)));
    }
    @Override public Component getName(ItemStack pStack) {
        return nameColor != null ? ((MutableComponent) super.getName(pStack)).withColor(nameColor) : super.getName(pStack);
    }
}