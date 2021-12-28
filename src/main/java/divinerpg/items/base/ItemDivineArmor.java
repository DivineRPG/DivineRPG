package divinerpg.items.base;

import divinerpg.DivineRPG;
import divinerpg.util.ArmorInfo;
import divinerpg.util.IFullSetInfo;
import divinerpg.util.LocalizeUtils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.List;

public class ItemDivineArmor extends ArmorItem implements IFullSetInfo {
    public IArmorMaterial mat;
    public ArmorInfo armorInfo;

    public ItemDivineArmor(String name, Rarity rarity, IArmorMaterial materialIn, EquipmentSlotType slot) {
        super(materialIn, slot, new Item.Properties().tab(DivineRPG.tabs.armor).rarity(rarity));
        setRegistryName(DivineRPG.MODID, name);
        this.mat = materialIn;
    }

    public ItemDivineArmor(String name, Rarity rarity, IArmorMaterial materialIn, EquipmentSlotType slot, ArmorInfo armorInfo) {
        super(materialIn, slot, new Item.Properties().tab(DivineRPG.tabs.armor).rarity(rarity));
        setRegistryName(DivineRPG.MODID, name);
        this.mat = materialIn;
        this.armorInfo=armorInfo;
    }

    public int getEnchantmentValue() {
        return mat.getEnchantmentValue();
    }


    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if(armorInfo != null && getFullSetPerks() != null){

            for (Iterator<String> iter = armorInfo.toString(stack,worldIn).iterator(); iter.hasNext(); ) {
                String element = iter.next();
                tooltip.add(LocalizeUtils.i18n(element));
            }
        }
    }

    @Override
    public TextComponent getFullSetPerks() {
        if (armorInfo == null)
            return null;

        return armorInfo.FullSetPerks;
    }
}