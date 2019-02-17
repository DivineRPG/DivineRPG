package naturix.divinerpg.objects.items.armor;

import naturix.divinerpg.DivineRPG;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class HelmetBase extends ItemArmor {

	private String name, textname;

	public HelmetBase(String name, ArmorMaterial material, String textname) {
		super(material, 0, EntityEquipmentSlot.HEAD);
		this.name = name;
		this.textname = textname;
		this.setRegistryName(name);
		this.setCreativeTab(DivineRPG.ArmorTab);
		this.setUnlocalizedName(name);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
		return "divinerpg:textures/models/armor/" + textname + ".png";
	}

	@Override
	public int getMaxDamage() {
		return 2010;
	}

	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}

	@Override
	public boolean isDamageable() {
		return true;
	}

	public void registerItemModel() {
		DivineRPG.proxy.registerItemRenderer(this, 0, name);
	}

}