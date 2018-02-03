package naturix.divinerpg.utils;

import naturix.divinerpg.DivineRPG;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class DivineRPGMaterials {
	//second to last number is damage value - 4
	public static final Item.ToolMaterial arlemiteSwordMaterial = EnumHelper.addToolMaterial("ARLEMITE", 2, 250, 6.0F, 2.0F, 14);
	public static final Item.ToolMaterial amthrimisSwordMaterial = EnumHelper.addToolMaterial("AMTHRIMIS", 2, 250, 3.0F, 1.0F, 1);
	public static final Item.ToolMaterial aquatoothSwordMaterial = EnumHelper.addToolMaterial("AQUATOOTH", 2, 250, 10.0F, 6.0F, 10);
	public static final Item.ToolMaterial arksianeSwordMaterial = EnumHelper.addToolMaterial("ARKSIANE", 2, 250, 14.0F, 10.0F, 14);
	public static final Item.ToolMaterial bedrockSwordMaterial = EnumHelper.addToolMaterial("BEDROCK", 2, 250, 14.0F, 10.0F, 14);
	public static final Item.ToolMaterial blackEnderSwordMaterial = EnumHelper.addToolMaterial("BLACKENDER", 2, 250, 16.0F, 12.0F, 16);
	public static final Item.ToolMaterial bloodgemSwordMaterial = EnumHelper.addToolMaterial("BLOODGEM", 2, 250, 15.0F, 11.0F, 15);
	public static final Item.ToolMaterial blueDivineSwordMaterial = EnumHelper.addToolMaterial("BLUEDIVINE", 2, 250, 22.0F, 18.0F, 22);
	public static final Item.ToolMaterial stormSwordMaterial = EnumHelper.addToolMaterial("STORM", 2, 250, 5.0F, 1.0F, 5);

	
	public static final ItemArmor.ArmorMaterial angelicArmorMaterial = EnumHelper.addArmorMaterial("ANGELIC", DivineRPG.modId + ":angelic", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	
}
