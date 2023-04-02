package divinerpg.items.base;

import divinerpg.util.*;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.*;

import javax.annotation.Nullable;
import java.util.*;

public class ItemDivineArmor extends ArmorItem implements IFullSetInfo {
    public ArmorMaterial mat;
    public ArmorInfo armorInfo;
    public final MobEffect[] supportedEffects;
    public final int amplifier[];

    public ItemDivineArmor(Rarity rarity, ArmorMaterial materialIn, ArmorItem.Type slot) {
        super(materialIn, slot, new Item.Properties().rarity(rarity));
        this.mat = materialIn;
        supportedEffects = null;
        amplifier = null;
    }

    public ItemDivineArmor(Rarity rarity, ArmorMaterial materialIn, ArmorItem.Type slot, ArmorInfo armorInfo) {
        super(materialIn, slot, new Item.Properties().rarity(rarity));
        this.mat = materialIn;
        this.armorInfo = armorInfo;
        supportedEffects = null;
        amplifier = null;
    }

    public ItemDivineArmor(ArmorMaterial materialIn, ArmorItem.Type slot) {
        super(materialIn, slot, new Item.Properties());
        this.mat = materialIn;
        supportedEffects = null;
        amplifier = null;
    }
    public ItemDivineArmor(ArmorMaterial materialIn, ArmorItem.Type slot, MobEffect ... effects) {
        super(materialIn, slot, new Item.Properties());
        this.mat = materialIn;
        supportedEffects = effects;
        amplifier = null;
    }

    public ItemDivineArmor(ArmorMaterial materialIn, ArmorItem.Type slot, ArmorInfo armorInfo) {
        super(materialIn, slot, new Item.Properties());
        this.mat = materialIn;
        this.armorInfo = armorInfo;
        supportedEffects = null;
        amplifier = null;
    }
    public ItemDivineArmor(ArmorMaterial materialIn, ArmorItem.Type slot, ArmorInfo armorInfo, MobEffect ... effects) {
    	super(materialIn, slot, new Item.Properties());
        this.mat = materialIn;
        this.armorInfo = armorInfo;
        supportedEffects = effects;
        amplifier = null;
    }
    public ItemDivineArmor(ArmorMaterial materialIn, ArmorItem.Type slot, ArmorInfo armorInfo, int[] amplifier, MobEffect ... effects) {
    	super(materialIn, slot, new Item.Properties());
        this.mat = materialIn;
        this.armorInfo = armorInfo;
        supportedEffects = effects;
        this.amplifier = amplifier;
    }
    public ItemDivineArmor(ArmorMaterial materialIn, ArmorItem.Type slot, ArmorInfo armorInfo, Properties properties) {
        super(materialIn, slot, properties);
        this.mat = materialIn;
        this.armorInfo = armorInfo;
        supportedEffects = null;
        amplifier = null;
    }
    public ItemDivineArmor(ArmorMaterial materialIn, ArmorItem.Type slot, ArmorInfo armorInfo, Properties properties, MobEffect ... effects) {
    	super(materialIn, slot, properties);
        this.mat = materialIn;
        this.armorInfo = armorInfo;
        supportedEffects = effects;
        amplifier = null;
    }
    public ItemDivineArmor(ArmorMaterial materialIn, ArmorItem.Type slot, ArmorInfo armorInfo, Properties properties, int[] amplifier, MobEffect ... effects) {
    	super(materialIn, slot, properties);
        this.mat = materialIn;
        this.armorInfo = armorInfo;
        supportedEffects = effects;
        this.amplifier = amplifier;
    }

    public int getEnchantmentValue() {
        return mat.getEnchantmentValue();
    }
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if (armorInfo != null && getFullSetPerks() != null) {

            for (Iterator<String> iter = armorInfo.toString(stack, worldIn).iterator(); iter.hasNext(); ) {
                String element = iter.next();
                tooltip.add(LocalizeUtils.i18n(element));
            }
        }
    }
    @Override
    public Component getFullSetPerks() {
        if (armorInfo == null)
            return null;

        return armorInfo.FullSetPerks;
    }
}