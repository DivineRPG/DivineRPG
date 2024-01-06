package divinerpg.compat;

import divinerpg.events.VetheaInventorySwapEvent;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import top.theillusivec4.curios.api.CuriosApi;

public class CuriosCompat {
	public static void saveInventory(CompoundTag persisted, Player player, String inv) {
		CuriosApi.getCuriosInventory(player).ifPresent((curinv) -> persisted.put(VetheaInventorySwapEvent.MODID_SEPERATOR + player.getStringUUID() + "_Curio" + inv, player.inventory.save(curinv.saveInventory(false))));
	}
	public static void loadInventory(Player player, String inv) {
		CuriosApi.getCuriosInventory(player).ifPresent((curinv) -> curinv.loadInventory(player.getPersistentData().getCompound(Player.PERSISTED_NBT_TAG).getList(VetheaInventorySwapEvent.MODID_SEPERATOR + player.getStringUUID() + "_Curio" + inv, 10)));
	}
}