package naturix.divinerpg.objects.items;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.IHasModel;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PickaxeBase extends ItemPickaxe implements IHasModel {

	public static String HARVEST = "tooltip.harvest";
	public String lvl = getHarvestString();
	private String name;

	public PickaxeBase(ToolMaterial material, String name, float damage, float speed) {
		super(material);
		setRegistryName(name);
		setUnlocalizedName(name);
		setCreativeTab(DivineRPG.ToolsTab);
		this.name = name;

		ModItems.ITEMS.add(this);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> infoList, ITooltipFlag flagIn) {
		infoList.add(TooltipLocalizer.efficiency(toolMaterial.getEfficiency()));
		infoList.add(harvestLevel());
		if (stack.getMaxDamage() != 0) {
			infoList.add(TooltipLocalizer.usesRemaining(stack.getMaxDamage() - stack.getItemDamage()));
		} else {
			infoList.add(TooltipLocalizer.infiniteUses());
		}

	}

	public String getHarvestString() {
		String harvest = null;
		if (toolMaterial.getHarvestLevel() == 0) {
			harvest = "Wood";
		}
		if (toolMaterial.getHarvestLevel() == 1) {
			harvest = "Stone";
		}
		if (toolMaterial.getHarvestLevel() == 2) {
			harvest = "Iron";
		}
		if (toolMaterial.getHarvestLevel() == 3) {
			harvest = "Diamond";
		}
		if (toolMaterial.getHarvestLevel() == 4) {
			harvest = "Cobalt";
		}
		if (toolMaterial.getHarvestLevel() == 100) {
			harvest = "Twilight";
		}
		if (toolMaterial.getHarvestLevel() > 4 && toolMaterial.getHarvestLevel() != 100) {
			harvest = "OP";
		}
		return harvest;
	}

	public String harvestLevel() {
		return I18n.translateToLocal(HARVEST).replace("+", lvl);
	}

	@Override
	public void registerModels() {
		DivineRPG.proxy.registerItemRenderer(this, 0, name);
	}
}