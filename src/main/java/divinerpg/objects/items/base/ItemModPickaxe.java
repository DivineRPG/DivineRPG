package divinerpg.objects.items.base;

import divinerpg.DivineRPG;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemModPickaxe extends ItemPickaxe {

	public ItemModPickaxe(ToolMaterial material, String name) {
		super(material);
		setRegistryName(DivineRPG.MODID, name);
		setUnlocalizedName(name);
		setCreativeTab(DivineRPGTabs.TOOLS);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack item, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
		if(item.getMaxDamage() < 0) {
			list.add(LocalizeUtils.infiniteUses());
		}
	}

	@Override
	public boolean isEnchantable(ItemStack stack) {
		return this.getItemStackLimit(stack) == 1
				&& (stack.getMaxDamage() < 0 || this.getItemStackLimit(stack) == 1);
	}
}