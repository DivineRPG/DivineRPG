package naturix.divinerpg.objects.items;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PickaxeBase extends ItemPickaxe {

	private String name;

	public PickaxeBase(ToolMaterial material, String name, float damage, float speed) {
		super(material);
		setRegistryName(name);
		setUnlocalizedName(name);
		setCreativeTab(DivineRPG.ToolsTab);
		this.name = name;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> infoList, ITooltipFlag flagIn) {
		infoList.add(TooltipLocalizer.efficiency(toolMaterial.getEfficiency()));
		if (stack.getMaxDamage() != 0) {
			infoList.add(TooltipLocalizer.usesRemaining(stack.getMaxDamage() - stack.getItemDamage()));
		} else {
			infoList.add(TooltipLocalizer.infiniteUses());
		}
	}

	public void registerItemModel() {
		DivineRPG.proxy.registerItemRenderer(this, 0, name);
	}
}