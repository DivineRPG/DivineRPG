package divinerpg.items.base;

import divinerpg.*;
import divinerpg.util.*;
import net.minecraft.network.chat.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraftforge.api.distmarker.*;

import javax.annotation.*;
import java.util.*;

public class ItemDivineArmor extends ArmorItem implements IFullSetInfo {
    public ArmorMaterial mat;
    public ArmorInfo armorInfo;

    public ItemDivineArmor(Rarity rarity, ArmorMaterial materialIn, EquipmentSlot slot) {
        super(materialIn, slot, new Item.Properties().tab(DivineRPG.tabs.armor).rarity(rarity));
        this.mat = materialIn;
    }

    public ItemDivineArmor(Rarity rarity, ArmorMaterial materialIn, EquipmentSlot slot, ArmorInfo armorInfo) {
        super(materialIn, slot, new Item.Properties().tab(DivineRPG.tabs.armor).rarity(rarity));
        this.mat = materialIn;
        this.armorInfo = armorInfo;
    }

    public ItemDivineArmor(ArmorMaterial materialIn, EquipmentSlot slot) {
        super(materialIn, slot, new Item.Properties().tab(DivineRPG.tabs.armor));
        this.mat = materialIn;
    }

    public ItemDivineArmor(ArmorMaterial materialIn, EquipmentSlot slot, ArmorInfo armorInfo) {
        super(materialIn, slot, new Item.Properties().tab(DivineRPG.tabs.armor));
        this.mat = materialIn;
        this.armorInfo = armorInfo;
    }
    public ItemDivineArmor(ArmorMaterial materialIn, EquipmentSlot slot, ArmorInfo armorInfo, Properties properties) {
        super(materialIn, slot, properties.tab(DivineRPG.tabs.armor));
        this.mat = materialIn;
        this.armorInfo = armorInfo;
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