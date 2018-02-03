package naturix.divinerpg.bases.armor;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.ModItems;
import naturix.divinerpg.bases.ArmorBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Donator extends ArmorBase {

	
	private String textureName;
	public Donator(ArmorMaterial material, EntityEquipmentSlot slot, String name) {
		super(material, slot, name);
		this.setCreativeTab(DivineRPG.ArmorTab);
	}

}