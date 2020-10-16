package divinerpg.objects.items.vethea;

import divinerpg.objects.items.base.ItemModSword;
import divinerpg.registry.DivineRPGTabs;

public class ItemVetheanSword extends ItemModSword {

    public ItemVetheanSword(ToolMaterial material, String name) {
       super(material, name);
       this.setCreativeTab(DivineRPGTabs.VETHEA);
    }
}
