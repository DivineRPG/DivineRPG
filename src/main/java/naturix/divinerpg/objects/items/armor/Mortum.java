package naturix.divinerpg.objects.items.armor;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.items.ArmorBase;
import net.minecraft.inventory.EntityEquipmentSlot;

public class Mortum extends ArmorBase {

	
	private String textureName;
	public Mortum(ArmorMaterial material, EntityEquipmentSlot slot, String name) {
		super(material, slot, name);
		//this.setCreativeTab(DivineRPG.ArmorTab);
	}

}