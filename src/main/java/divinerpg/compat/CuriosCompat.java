package divinerpg.compat;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.util.LazyOptional;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.capability.ICuriosItemHandler;

public class CuriosCompat {
	public static void loadInventory(CompoundTag from, Player player) {
		if(from.contains("curios")) CuriosApi.getCuriosInventory(player).ifPresent((curinv) -> {
			curinv.saveInventory(true);
			curinv.loadInventory(from.getList("curios", 0));
		});
	}
	public static void saveInventory(CompoundTag to, Player player) {
		CuriosApi.getCuriosInventory(player).ifPresent((curinv) -> to.put("curios", curinv.saveInventory(false)));
	}
	public static ListTag saveInventory(Player player) {
		LazyOptional<ICuriosItemHandler> l = CuriosApi.getCuriosInventory(player);
		if(l.isPresent()) return l.orElse(null).saveInventory(false);
		return new ListTag();
	}
	public static void loadInventory(ListTag from, Player player) {
		CuriosApi.getCuriosInventory(player).ifPresent((curinv) -> {
			curinv.saveInventory(true);
			curinv.loadInventory(from);
		});
	}
}