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

	
	public Angelic(ArmorMaterial material, EntityEquipmentSlot slot, String name) {
		super(material, slot, name);
		this.setCreativeTab(Divine.ArmorTab);
	}

	public void onTick(World world, EntityPlayer player, ItemStack item)
	{
			  if(player.inventory.armorItemInSlot(0).getItem() == ModItems.angelicHelmet &&
				player.inventory.armorItemInSlot(1).getItem() == ModItems.angelicChestplate && 
				player.inventory.armorItemInSlot(2).getItem() == ModItems.angelicLeggings &&
				player.inventory.armorItemInSlot(3).getItem() == ModItems.angelicBoots)
			
			{
		         player.fallDistance = 0;
		        }
			}
	@Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
        return Divine.modId+":textures/items/armor/angelic_1.png";
    }
		}