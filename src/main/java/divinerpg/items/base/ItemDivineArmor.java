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
import net.neoforged.api.distmarker.*;
import java.util.List;

import com.google.common.base.Optional;

public class ItemDivineArmor extends ArmorItem implements IFullSetInfo {
    public ArmorInfo armorInfo;
    public final Holder<MobEffect>[] supportedEffects;
    public final int[] amplifier;
    public Optional<Integer> nameColor;
    public ItemDivineArmor(Holder<ArmorMaterial> materialIn, ArmorItem.Type slot, int durability) {
        super(materialIn, slot, new Properties().durability(slot.getDurability(durability)));
        supportedEffects = null;
        amplifier = null;
    }
    public ItemDivineArmor(Holder<ArmorMaterial> materialIn, ArmorItem.Type slot, int durability, ArmorInfo armorInfo) {
        super(materialIn, slot, new Properties().durability(slot.getDurability(durability)));
        this.armorInfo = armorInfo;
        supportedEffects = null;
        amplifier = null;
    }
    public ItemDivineArmor(Holder<ArmorMaterial> materialIn, ArmorItem.Type slot, int durability, ArmorInfo armorInfo, Properties properties) {
        super(materialIn, slot, properties.durability(slot.getDurability(durability)));
        this.armorInfo = armorInfo;
        supportedEffects = null;
        amplifier = null;
    }
    @SafeVarargs
	public ItemDivineArmor(Holder<ArmorMaterial> materialIn, ArmorItem.Type slot, int durability, ArmorInfo armorInfo, Properties properties, Holder<MobEffect> ... effects) {
        super(materialIn, slot, properties.durability(slot.getDurability(durability)));
        this.armorInfo = armorInfo;
        supportedEffects = effects;
        amplifier = null;
    }
    @SafeVarargs
	public ItemDivineArmor(Holder<ArmorMaterial> materialIn, ArmorItem.Type slot, int durability, ArmorInfo armorInfo, Holder<MobEffect> ... effects) {
        super(materialIn, slot, new Properties().durability(slot.getDurability(durability)));
        this.armorInfo = armorInfo;
        supportedEffects = effects;
        amplifier = null;
    }
    @SafeVarargs
	public ItemDivineArmor(int rarity, Holder<ArmorMaterial> materialIn, ArmorItem.Type slot, int durability, ArmorInfo armorInfo, Holder<MobEffect> ... effects) {
        super(materialIn, slot, new Properties().durability(slot.getDurability(durability)));
        this.armorInfo = armorInfo;
        supportedEffects = effects;
        amplifier = null;
        this.nameColor = Optional.of(rarity);
    }
    @SafeVarargs
	public ItemDivineArmor(Holder<ArmorMaterial> materialIn, ArmorItem.Type slot, int durability, ArmorInfo armorInfo, int[] amplifier, Holder<MobEffect> ... effects) {
        super(materialIn, slot, new Properties().durability(slot.getDurability(durability)));
        this.armorInfo = armorInfo;
        supportedEffects = effects;
        this.amplifier = amplifier;
    }
    @SafeVarargs
	public ItemDivineArmor(int rarity, Holder<ArmorMaterial> materialIn, ArmorItem.Type slot, int durability, ArmorInfo armorInfo, int[] amplifier, Holder<MobEffect> ... effects) {
        super(materialIn, slot, new Properties().durability(slot.getDurability(durability)));
        this.armorInfo = armorInfo;
        supportedEffects = effects;
        this.amplifier = amplifier;
        this.nameColor = Optional.of(rarity);
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
        if(stack.getMaxDamage() == 0) stack.set(DataComponents.UNBREAKABLE, new Unbreakable(true));
    }
    @Override
    public Component getName(ItemStack pStack) {
    	return nameColor != null && nameColor.isPresent() ? ((MutableComponent) super.getName(pStack)).withColor(nameColor.get()) : super.getName(pStack);
    }
}