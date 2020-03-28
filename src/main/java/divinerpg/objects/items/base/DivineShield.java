package divinerpg.objects.items.base;

import divinerpg.api.Reference;
import divinerpg.utils.Lazy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class DivineShield extends ItemShield {
    private Lazy<Item> repair;

    public DivineShield(String name, CreativeTabs tab, Supplier<Item> repairMaterial, int damage) {
        repair = new Lazy<>(repairMaterial);
        setCreativeTab(tab);
        setMaxDamage(damage);
        setUnlocalizedName(name);
        setRegistryName(Reference.MODID, name);
    }

    @Override
    public boolean isShield(ItemStack stack, @Nullable EntityLivingBase entity) {
        return true;
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == this.repair.getValue();
    }
}
