package divinerpg.items.base;

import divinerpg.*;
import divinerpg.util.*;
import net.minecraft.client.util.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;
import net.minecraftforge.api.distmarker.*;

import javax.annotation.*;
import java.util.*;

public class ItemDivineArmor extends ArmorItem implements IFullSetInfo {
    public IArmorMaterial mat;
    public ArmorInfo armorInfo;

    public ItemDivineArmor(String name, IArmorMaterial materialIn, EquipmentSlotType slot) {
        super(materialIn, slot, new Item.Properties().tab(DivineRPG.tabs.armor));
        setRegistryName(DivineRPG.MODID, name);
        this.mat = materialIn;
    }

    public ItemDivineArmor(String name, IArmorMaterial materialIn, EquipmentSlotType slot, ArmorInfo armorInfo) {
        super(materialIn, slot, new Item.Properties().tab(DivineRPG.tabs.armor));
        setRegistryName(DivineRPG.MODID, name);
        this.mat = materialIn;
        this.armorInfo=armorInfo;
    }

    public int getEnchantmentValue() {
        return mat.getEnchantmentValue();
    }


    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if(armorInfo != null && getFullSetPerks() != null){

            for (Iterator<String> iter = armorInfo.toString(stack,worldIn).iterator(); iter.hasNext(); ) {
                String element = iter.next();
            tooltip.add(new TranslationTextComponent(element));
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