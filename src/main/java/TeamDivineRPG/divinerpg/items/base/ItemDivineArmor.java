package TeamDivineRPG.divinerpg.items.base;

import TeamDivineRPG.divinerpg.DivineRPG;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.*;

import javax.annotation.Nullable;
import java.util.List;

public class ItemDivineArmor extends ArmorItem {
    public IArmorMaterial mat;

    public ItemDivineArmor(String name, IArmorMaterial materialIn, EquipmentSlotType slot) {
        super(materialIn, slot, new Item.Properties().group(DivineRPG.tabs.armor));
        setRegistryName(DivineRPG.MODID, name);
        this.mat = materialIn;
    }

    public int getItemEnchantability() {
        return mat.getEnchantability();
    }


    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent(DivineRPG.MODID + ".armor"));
    }
}