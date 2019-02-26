package naturix.divinerpg.objects.items.armor;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.items.ArmorBase;
import net.minecraft.inventory.EntityEquipmentSlot;

public class Divine extends ArmorBase {

	
	private String textureName;
	public Divine(ArmorMaterial material, EntityEquipmentSlot slot, String name) {
		super(material, slot, name);
		//this.setCreativeTab(DivineRPG.ArmorTab);
	}

}