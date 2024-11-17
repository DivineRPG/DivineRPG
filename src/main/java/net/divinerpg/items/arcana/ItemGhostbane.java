package net.divinerpg.items.arcana;

import java.util.List;

import net.divinerpg.entities.arcana.EntityWraith;
import net.divinerpg.items.base.ItemMod;
import net.divinerpg.libs.ChatFormats;
import net.divinerpg.utils.TooltipLocalizer;
import net.divinerpg.utils.events.ArcanaHelper;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGhostbane extends ItemMod {

	public ItemGhostbane() {
		super("ghostbane", DivineRPGTabs.spawner);
		setMaxStackSize(1);
	}

	@Override
	public boolean onItemUse(ItemStack i, EntityPlayer p, World w, int x, int y, int z, int i1, float j, float k, float l) {
		EntityWraith wraith = new EntityWraith(w, p);
		if(!w.isRemote){
			if(ArcanaHelper.getProperties(p).useBar(200)) {
				wraith.setLocationAndAngles(x, y + 1, z, 0.0F, 0.0F);
				w.spawnEntityInWorld(wraith);
				return true;
			}
		}
		return false;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		list.add(TooltipLocalizer.arcanaConsumed(200));
		list.add("Spawns a friendly Wraith");
		list.add("13 Damage");
		list.add("20 Health");
		list.add("Despawns after a short time");
	}
}