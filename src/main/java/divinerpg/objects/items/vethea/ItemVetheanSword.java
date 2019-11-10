package divinerpg.objects.items.vethea;

import divinerpg.api.java.divinerpg.api.Reference;
import divinerpg.objects.items.base.ItemModSword;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.ModItems;

public class ItemVetheanSword extends ItemModSword {

    public ItemVetheanSword(ToolMaterial material, String name) {
       super(material, name);
       this.setCreativeTab(DivineRPGTabs.vethea);
    }
}
