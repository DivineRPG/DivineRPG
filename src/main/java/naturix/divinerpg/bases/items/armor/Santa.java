package naturix.divinerpg.bases.items.armor;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.bases.items.ArmorBase;
import net.minecraft.inventory.EntityEquipmentSlot;

public class Santa extends ArmorBase {

	
	private String textureName;
	public Santa(ArmorMaterial material, EntityEquipmentSlot slot, String name) {
		super(material, slot, name);
		this.setCreativeTab(DivineRPG.ArmorTab);
	}

}