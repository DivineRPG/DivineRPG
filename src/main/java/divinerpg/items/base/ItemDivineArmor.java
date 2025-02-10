package divinerpg.items.base;

import divinerpg.registries.ItemRegistry;
import divinerpg.util.*;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Unbreakable;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.neoforged.api.distmarker.*;
import java.util.List;

public class ItemDivineArmor extends ArmorItem implements IFullSetInfo {
    public ArmorInfo armorInfo;
    public final Holder<MobEffect>[] supportedEffects;
    public final int[] amplifier;
    public Integer nameColor;
    public ItemDivineArmor(Holder<ArmorMaterial> materialIn, ArmorItem.Type slot, int durability) {
        super(materialIn, slot, (slot.getDurability(durability) == 0 ? new Properties().component(DataComponents.UNBREAKABLE, new Unbreakable(true)).stacksTo(1) : new Properties().durability(slot.getDurability(durability))));
        supportedEffects = null;
        amplifier = null;
    }
    public ItemDivineArmor(Holder<ArmorMaterial> materialIn, ArmorItem.Type slot, int durability, ArmorInfo armorInfo) {
        super(materialIn, slot, (slot.getDurability(durability) == 0 ? new Properties().component(DataComponents.UNBREAKABLE, new Unbreakable(true)).stacksTo(1) : new Properties().durability(slot.getDurability(durability))));
        this.armorInfo = armorInfo;
        supportedEffects = null;
        amplifier = null;
    }
    public ItemDivineArmor(Holder<ArmorMaterial> materialIn, ArmorItem.Type slot, int durability, ArmorInfo armorInfo, Properties properties) {
        super(materialIn, slot, (slot.getDurability(durability) == 0 ? properties.component(DataComponents.UNBREAKABLE, new Unbreakable(true)).stacksTo(1) : properties.durability(slot.getDurability(durability))));
        this.armorInfo = armorInfo;
        supportedEffects = null;
        amplifier = null;
    }
    @SafeVarargs
	public ItemDivineArmor(Holder<ArmorMaterial> materialIn, ArmorItem.Type slot, int durability, ArmorInfo armorInfo, Properties properties, Holder<MobEffect> ... effects) {
        super(materialIn, slot, (slot.getDurability(durability) == 0 ? properties.component(DataComponents.UNBREAKABLE, new Unbreakable(true)).stacksTo(1) : properties.durability(slot.getDurability(durability))));
        this.armorInfo = armorInfo;
        supportedEffects = effects;
        amplifier = null;
    }
    @SafeVarargs
	public ItemDivineArmor(Holder<ArmorMaterial> materialIn, ArmorItem.Type slot, int durability, ArmorInfo armorInfo, Holder<MobEffect> ... effects) {
        super(materialIn, slot, (slot.getDurability(durability) == 0 ? new Properties().component(DataComponents.UNBREAKABLE, new Unbreakable(true)).stacksTo(1) : new Properties().durability(slot.getDurability(durability))));
        this.armorInfo = armorInfo;
        supportedEffects = effects;
        amplifier = null;
    }
    @SafeVarargs
	public ItemDivineArmor(int rarity, Holder<ArmorMaterial> materialIn, ArmorItem.Type slot, int durability, ArmorInfo armorInfo, Holder<MobEffect> ... effects) {
        super(materialIn, slot, (slot.getDurability(durability) == 0 ? new Properties().component(DataComponents.UNBREAKABLE, new Unbreakable(true)).stacksTo(1) : new Properties().durability(slot.getDurability(durability))));
        this.armorInfo = armorInfo;
        supportedEffects = effects;
        amplifier = null;
        this.nameColor = rarity;
    }
    @SafeVarargs
	public ItemDivineArmor(Holder<ArmorMaterial> materialIn, ArmorItem.Type slot, int durability, ArmorInfo armorInfo, int[] amplifier, Holder<MobEffect> ... effects) {
        super(materialIn, slot, (slot.getDurability(durability) == 0 ? new Properties().component(DataComponents.UNBREAKABLE, new Unbreakable(true)).stacksTo(1) : new Properties().durability(slot.getDurability(durability))));
        this.armorInfo = armorInfo;
        supportedEffects = effects;
        this.amplifier = amplifier;
    }
    @SafeVarargs
	public ItemDivineArmor(int rarity, Holder<ArmorMaterial> materialIn, ArmorItem.Type slot, int durability, ArmorInfo armorInfo, int[] amplifier, Holder<MobEffect> ... effects) {
        super(materialIn, slot, (slot.getDurability(durability) == 0 ? new Properties().component(DataComponents.UNBREAKABLE, new Unbreakable(true)).stacksTo(1) : new Properties().durability(slot.getDurability(durability))));
        this.armorInfo = armorInfo;
        supportedEffects = effects;
        this.amplifier = amplifier;
        this.nameColor = rarity;
    }
    @Override public boolean canWalkOnPowderedSnow(ItemStack stack, LivingEntity wearer) {
        return stack.getItem() == ItemRegistry.seng_fur_boots.get() || stack.getItem() == ItemRegistry.santa_boots.get();
    }
    @Override public Component getFullSetPerks() {
        if(armorInfo == null) return null;
        return armorInfo.FullSetPerks;
    }
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        if(armorInfo != null) tooltip.addAll(armorInfo.asString());
    }
    @Override
    public Component getName(ItemStack pStack) {
    	return nameColor != null ? ((MutableComponent) super.getName(pStack)).withColor(nameColor) : super.getName(pStack);
    }
    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }
    @Override
    public boolean supportsEnchantment(ItemStack stack, Holder<Enchantment> enchantment) {
        return super.supportsEnchantment(stack, enchantment) && !(stack.has(DataComponents.UNBREAKABLE) && (enchantment.is(Enchantments.MENDING) || enchantment.is(Enchantments.UNBREAKING)));
    }
    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return !(stack.has(DataComponents.UNBREAKABLE) && (Utils.hasStoredEnchantment(Enchantments.MENDING, book) || Utils.hasStoredEnchantment(Enchantments.UNBREAKING, book)));
    }
}