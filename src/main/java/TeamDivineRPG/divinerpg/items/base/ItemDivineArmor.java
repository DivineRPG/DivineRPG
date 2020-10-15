package TeamDivineRPG.divinerpg.items.base;

import TeamDivineRPG.divinerpg.DivineRPG;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

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