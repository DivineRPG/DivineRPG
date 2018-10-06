package naturix.divinerpg.bases.items.armor;

import naturix.divinerpg.DivineRPG;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ChestplateBase  extends ItemArmor 
{
	
	public ChestplateBase(String name, ArmorMaterial material, String textname)
	{
		super(material, 0, EntityEquipmentSlot.CHEST);
		this.textname = textname;
		this.name = name;
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
	}

	@Override
	public EnumRarity getRarity(ItemStack stack)
	{
		return EnumRarity.RARE;
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
	{
		return "divinerpg:textures/models/armor/"+ textname + ".png";
	}

	private String name, textname;
	private EntityPlayer player;
	public void registerItemModel() {
		DivineRPG.proxy.registerItemRenderer(this, 0, name);
		
	}
	@Override
	public int getMaxDamage()
	{
		return 2010;
	}


	@Override
	public boolean isDamageable()
	{
		return true;
	}

}