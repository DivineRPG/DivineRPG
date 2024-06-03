package divinerpg.items.base;

import divinerpg.registries.ItemRegistry;
import divinerpg.util.*;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.*;
import javax.annotation.Nullable;
import java.util.List;

public class ItemDivineArmor extends ArmorItem implements IFullSetInfo {
    public ArmorMaterial mat;
    public ArmorInfo armorInfo;
    public final MobEffect[] supportedEffects;
    public final int[] amplifier;
    public ItemDivineArmor(ArmorMaterial materialIn, ArmorItem.Type slot) {
        super(materialIn, slot, new Properties());
        mat = materialIn;
        supportedEffects = null;
        amplifier = null;
    }
    public ItemDivineArmor(ArmorMaterial materialIn, ArmorItem.Type slot, ArmorInfo armorInfo) {
        super(materialIn, slot, new Properties());
        mat = materialIn;
        this.armorInfo = armorInfo;
        supportedEffects = null;
        amplifier = null;
    }
    public ItemDivineArmor(ArmorMaterial materialIn, ArmorItem.Type slot, ArmorInfo armorInfo, Properties properties) {
        super(materialIn, slot, properties);
        mat = materialIn;
        this.armorInfo = armorInfo;
        supportedEffects = null;
        amplifier = null;
    }
    public ItemDivineArmor(ArmorMaterial materialIn, ArmorItem.Type slot, ArmorInfo armorInfo, Properties properties, MobEffect ... effects) {
        super(materialIn, slot, properties);
        mat = materialIn;
        this.armorInfo = armorInfo;
        supportedEffects = effects;
        amplifier = null;
    }
    public ItemDivineArmor(ArmorMaterial materialIn, ArmorItem.Type slot, ArmorInfo armorInfo, MobEffect ... effects) {
        super(materialIn, slot, new Properties());
        mat = materialIn;
        this.armorInfo = armorInfo;
        supportedEffects = effects;
        amplifier = null;
    }
    public ItemDivineArmor(Rarity rarity, ArmorMaterial materialIn, ArmorItem.Type slot, ArmorInfo armorInfo, MobEffect ... effects) {
        super(materialIn, slot, new Properties().rarity(rarity));
        mat = materialIn;
        this.armorInfo = armorInfo;
        supportedEffects = effects;
        amplifier = null;
    }
    public ItemDivineArmor(ArmorMaterial materialIn, ArmorItem.Type slot, ArmorInfo armorInfo, int[] amplifier, MobEffect ... effects) {
        super(materialIn, slot, new Properties());
        mat = materialIn;
        this.armorInfo = armorInfo;
        supportedEffects = effects;
        this.amplifier = amplifier;
    }
    public ItemDivineArmor(Rarity rarity, ArmorMaterial materialIn, ArmorItem.Type slot, ArmorInfo armorInfo, int[] amplifier, MobEffect ... effects) {
        super(materialIn, slot, new Properties().rarity(rarity));
        mat = materialIn;
        this.armorInfo = armorInfo;
        supportedEffects = effects;
        this.amplifier = amplifier;
    }
    @Override public boolean canWalkOnPowderedSnow(ItemStack stack, LivingEntity wearer) {return stack.getItem() == ItemRegistry.seng_fur_boots.get() || stack.getItem() == ItemRegistry.santa_boots.get();}
    @Override public int getEnchantmentValue() {return mat.getEnchantmentValue();}
    @Override public Component getFullSetPerks() {
        if(armorInfo == null) return null;
        return armorInfo.FullSetPerks;
    }
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if(armorInfo != null) tooltip.addAll(armorInfo.asString());
        if(!canBeDepleted()) stack.getOrCreateTag().putBoolean("Unbreakable", true);
    }
}