package divinerpg.objects.items.base;

import divinerpg.api.Reference;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.utils.LocalizeKeys;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemModShovel extends ItemSpade {

	public ItemModShovel(ToolMaterial material, String name) {
		super(material);
		setRegistryName(Reference.MODID, name);
		setUnlocalizedName(name);
		setCreativeTab(DivineRPGTabs.tools);


	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> infoList, ITooltipFlag flagIn) {
        infoList.add(LocalizeKeys.efficiency(toolMaterial.getEfficiency()));
        if (stack.getMaxDamage() > 0) {
            infoList.add(LocalizeKeys.usesRemaining(stack.getMaxDamage() - stack.getItemDamage()));
        } else {
            infoList.add(LocalizeKeys.infiniteUses());
        }
    }
}