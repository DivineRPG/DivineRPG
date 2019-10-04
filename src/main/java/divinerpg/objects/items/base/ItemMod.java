package divinerpg.objects.items.base;

import divinerpg.api.Reference;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemMod extends Item  {

    public ItemMod(String name) {
        this(name, DivineRPGTabs.items);
    }

    public ItemMod(String name, CreativeTabs tab) {
        setUnlocalizedName(name);
        setRegistryName(Reference.MODID, name);
        this.setCreativeTab(tab);

        ModItems.ITEMS.add(this);
    }
}