package naturix.divinerpg.objects.items;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class HoeBase extends ItemHoe {

	private String name;

	public HoeBase(ToolMaterial material, String name) {
		super(material);
		setRegistryName(name);
		setUnlocalizedName(name);
		//setCreativeTab(DivineRPG.ToolsTab);
		this.name = name;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> infoList, ITooltipFlag flagIn) {
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