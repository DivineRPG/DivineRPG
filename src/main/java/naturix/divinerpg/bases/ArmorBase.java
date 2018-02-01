package naturix.divinerpg.bases;

import naturix.divinerpg.Divine;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ArmorBase extends net.minecraft.item.ItemArmor {
	
	private String name;

	public ArmorBase(ArmorMaterial material, EntityEquipmentSlot slot, String name) {
		super(material, 0, slot);
		setRegistryName(name);
		setUnlocalizedName(name);
		this.name = name;
	}
	
	public void registerItemModel(Item item) {
		Divine.proxy.registerItemRenderer(this, 0, name);
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		return null;
	}

}