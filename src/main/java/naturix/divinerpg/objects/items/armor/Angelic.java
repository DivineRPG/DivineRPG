package naturix.divinerpg.objects.items.armor;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.items.ArmorBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Angelic extends ArmorBase {

	
	private String textureName;
	public Angelic(ArmorMaterial material, EntityEquipmentSlot slot, String name) {
		super(material, slot, name);
		//this.setCreativeTab(DivineRPG.ArmorTab);
	}

	public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack stack)
    {
     player.fallDistance = 0;
     player.fall(1, 0f);
    }
}