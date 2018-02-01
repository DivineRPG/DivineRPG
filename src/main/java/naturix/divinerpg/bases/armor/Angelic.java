package naturix.divinerpg.bases.armor;

import naturix.divinerpg.Divine;
import naturix.divinerpg.ModItems;
import naturix.divinerpg.bases.ArmorBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Angelic extends ArmorBase {

	
	private String textureName;
	public Angelic(ArmorMaterial material, EntityEquipmentSlot slot, String name) {
		super(material, slot, name);
		this.setCreativeTab(Divine.ArmorTab);
	}

	public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack stack)
    {
     player.fallDistance = 0;
     player.fall(1, 0f);
    }
}