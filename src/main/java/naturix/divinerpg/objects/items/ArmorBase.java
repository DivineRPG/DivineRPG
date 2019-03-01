package naturix.divinerpg.objects.items;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.IHasModel;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ArmorBase extends net.minecraft.item.ItemArmor implements IHasModel {

	private String name;
	protected double damageReduction;
	protected boolean unbreakable;
	protected int fullReduction;
	// protected EnumArmor armorMaterial;
	protected Object[] armorInfo;
	protected StringBuilder infoBuilder;

	public ArmorBase(ArmorMaterial material, EntityEquipmentSlot slot, String name) {
		super(material, 0, slot);
		setRegistryName(name);
		setUnlocalizedName(name);
		this.name = name;
		this.setCreativeTab(DivineRPG.ArmorTab);
		ModItems.ITEMS.add(this);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack item, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
		double roundPH = Math.round(damageReduction * 1000);
		double roundedDamage = roundPH / 10;
		damageReduction = this.getArmorMaterial().getDamageReductionAmount(getEquipmentSlot());
		list.add(damageReduction == 0.0 ? TooltipLocalizer.noProtection()
		        : TooltipLocalizer.damageReduction(roundedDamage, fullReduction));
		if (item.getMaxDamage() != 0) {
			list.add(TooltipLocalizer.usesRemaining((item.getMaxDamage() - item.getItemDamage())));
		} else {
			list.add(TooltipLocalizer.infiniteUses());
		}
		// String perks = "";
		// for (int i = 0; i < ChatFormats.DIMENSIONS_LIST.length; i++) {
		// if (armorInfo[0].equals(ChatFormats.DIMENSIONS_LIST[i])) {
		// perks += "In " + armorInfo[0].toString() + ": ";
		// }
		// }
		// perks += infoBuilder.toString();
		// for (int c = 0; c < ChatFormats.DIMENSIONS_LIST.length; c++) {
		// perks = perks.replace(ChatFormats.DIMENSIONS_LIST[c] + ", ", "");
		// }
		// String[] perksArray = perks.split("\n");
		// if (armorInfo[0] != "null") {
		// list.add(TooltipLocalizer.fullsetPerks());
		// for (int j = 0; j < perksArray.length; j++) {
		// list.add(perksArray[j]);
		// }
		// }
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		return null;
	}

	@Override
	public void registerModels() {
		DivineRPG.proxy.registerItemRenderer(this, 0, name);
	}
}