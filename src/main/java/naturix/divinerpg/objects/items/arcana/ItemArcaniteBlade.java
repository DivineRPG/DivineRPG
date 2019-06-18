package naturix.divinerpg.objects.items.arcana;

import java.util.List;

import naturix.divinerpg.client.ArcanaHelper;
import naturix.divinerpg.objects.items.base.ItemModSword;
import naturix.divinerpg.utils.TooltipLocalizer;
import naturix.divinerpg.utils.material.ToolMaterialMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemArcaniteBlade extends ItemModSword {

	public ItemArcaniteBlade() {
		super(ToolMaterialMod.ArcaniteBlade, "arcanite_blade");
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		//FIXME - needs to consume arcana
		//		if(!player.world.isRemote && !ArcanaHelper.getProperties(player).useBar(12)) return true;
        return false;
    }
	
	@Override
	public void addAdditionalInformation(List list) {
		list.add(TooltipLocalizer.arcanaConsumed(12));
	}

}