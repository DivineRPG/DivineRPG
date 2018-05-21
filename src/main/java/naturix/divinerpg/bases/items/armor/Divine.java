package naturix.divinerpg.bases.items.armor;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.bases.items.ArmorBase;
import naturix.divinerpg.registry.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Divine extends ArmorBase {

	
	private String textureName;
	public Divine(ArmorMaterial material, EntityEquipmentSlot slot, String name) {
		super(material, slot, name);
		this.setCreativeTab(DivineRPG.ArmorTab);
	}

}