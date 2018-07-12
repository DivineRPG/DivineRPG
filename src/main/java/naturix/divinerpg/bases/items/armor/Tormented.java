package naturix.divinerpg.bases.items.armor;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.bases.items.ArmorBase;
import net.minecraft.inventory.EntityEquipmentSlot;

public class Tormented extends ArmorBase {

	
	private String textureName;
	public Tormented(ArmorMaterial material, EntityEquipmentSlot slot, String name) {
		super(material, slot, name);
		this.setCreativeTab(DivineRPG.ArmorTab);
	}

}