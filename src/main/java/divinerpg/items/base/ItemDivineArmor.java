package divinerpg.items.base;

import divinerpg.registries.ItemRegistry;
import divinerpg.util.*;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Unbreakable;
import net.neoforged.api.distmarker.*;
import java.util.List;

public class ItemDivineArmor extends ArmorItem implements IFullSetInfo {
    public ArmorInfo armorInfo;
    public final MobEffect[] supportedEffects;
    public final int[] amplifier;
    public ItemDivineArmor(Holder<ArmorMaterial> materialIn, ArmorItem.Type slot) {
        super(materialIn, slot, new Properties());
        supportedEffects = null;
        amplifier = null;
    }
    public ItemDivineArmor(Holder<ArmorMaterial> materialIn, ArmorItem.Type slot, ArmorInfo armorInfo) {
        super(materialIn, slot, new Properties());
        this.armorInfo = armorInfo;
        supportedEffects = null;
        amplifier = null;
    }
    public ItemDivineArmor(Holder<ArmorMaterial> materialIn, ArmorItem.Type slot, ArmorInfo armorInfo, Properties properties) {
        super(materialIn, slot, properties);
        this.armorInfo = armorInfo;
        supportedEffects = null;
        amplifier = null;
    }
    public ItemDivineArmor(Holder<ArmorMaterial> materialIn, ArmorItem.Type slot, ArmorInfo armorInfo, Properties properties, MobEffect ... effects) {
        super(materialIn, slot, properties);
        this.armorInfo = armorInfo;
        supportedEffects = effects;
        amplifier = null;
    }
    public ItemDivineArmor(Holder<ArmorMaterial> materialIn, ArmorItem.Type slot, ArmorInfo armorInfo, MobEffect ... effects) {
        super(materialIn, slot, new Properties());
        this.armorInfo = armorInfo;
        supportedEffects = effects;
        amplifier = null;
    }
    public ItemDivineArmor(Rarity rarity, Holder<ArmorMaterial> materialIn, ArmorItem.Type slot, ArmorInfo armorInfo, MobEffect ... effects) {
        super(materialIn, slot, new Properties().rarity(rarity));
        this.armorInfo = armorInfo;
        supportedEffects = effects;
        amplifier = null;
    }
    public ItemDivineArmor(Holder<ArmorMaterial> materialIn, ArmorItem.Type slot, ArmorInfo armorInfo, int[] amplifier, MobEffect ... effects) {
        super(materialIn, slot, new Properties());
        this.armorInfo = armorInfo;
        supportedEffects = effects;
        this.amplifier = amplifier;
    }
    public ItemDivineArmor(Rarity rarity, Holder<ArmorMaterial> materialIn, ArmorItem.Type slot, ArmorInfo armorInfo, int[] amplifier, MobEffect ... effects) {
        super(materialIn, slot, new Properties().rarity(rarity));
        this.armorInfo = armorInfo;
        supportedEffects = effects;
        this.amplifier = amplifier;
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
        if(!stack.isDamageableItem()) stack.set(DataComponents.UNBREAKABLE, new Unbreakable(true));
    }
}