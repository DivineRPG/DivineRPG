package naturix.divinerpg.objects.items.arcana;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.client.ArcanaHelper;
import naturix.divinerpg.objects.items.base.ItemModSword;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemArcaniumSaber extends ItemModSword {

	public ItemArcaniumSaber(String name, ToolMaterial var2) {
		super(var2, name);
		this.maxStackSize = 1;
		this.setMaxDamage(-1);
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		//FIXME - Needs to consume arcana
		//		if (ArcanaHelper.getProperties(player).useBar(12)) {
		player.playSound(ModSounds.ARCANIUM_SABER, 1, 1);
//			return false;
//		}
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {	tooltip.add(TooltipLocalizer.arcanaConsumed(12));
		tooltip.add(TooltipLocalizer.meleeDam(22));
	}
}