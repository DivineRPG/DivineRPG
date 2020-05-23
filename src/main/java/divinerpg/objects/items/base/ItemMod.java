package divinerpg.objects.items.base;

import divinerpg.DivineRPG;
import divinerpg.registry.DivineRPGTabs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemMod extends Item {
    private boolean isEnchanted;

    public ItemMod(String name, boolean isEnchanted) {
        this(name);
        this.isEnchanted = isEnchanted;
    }

    public ItemMod(String name) {
        this(name, DivineRPGTabs.items);
    }

    public ItemMod(String name, CreativeTabs tab) {
        setUnlocalizedName(name);
        setRegistryName(DivineRPG.MODID, name);
        this.setCreativeTab(tab);
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return isEnchanted || super.hasEffect(stack);
    }
}