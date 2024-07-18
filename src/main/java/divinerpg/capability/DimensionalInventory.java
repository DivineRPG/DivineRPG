package divinerpg.capability;

import divinerpg.compat.CuriosCompat;
import divinerpg.events.VetheaInventorySwapEvent;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.entity.player.Player;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.common.util.INBTSerializable;

public class DimensionalInventory implements INBTSerializable<CompoundTag> {
	ListTag overworldInventory = new ListTag(), overworldCurios = new ListTag(), vetheaInventory = new ListTag(), vetheaCurios = new ListTag();
	public void transferTo(DimensionalInventory target) {
		target.overworldInventory = this.overworldInventory;
		target.overworldCurios = this.overworldCurios;
		target.vetheaInventory = this.vetheaInventory;
		target.vetheaCurios = this.vetheaCurios;
	}
	public void saveInventory(Player player, String inv) {
		if(inv == VetheaInventorySwapEvent.VETHEA_INVENTORY) {
			vetheaInventory = player.getInventory().save(new ListTag());
			if(ModList.get().isLoaded("curios")) vetheaCurios = CuriosCompat.saveInventory(player);
		} else {
			overworldInventory = player.getInventory().save(new ListTag());
			if(ModList.get().isLoaded("curios")) overworldCurios = CuriosCompat.saveInventory(player);
		}
	}
	public void loadInventory(Player player, String inv) {
		if(inv == VetheaInventorySwapEvent.VETHEA_INVENTORY) {
			if(ModList.get().isLoaded("curios")) CuriosCompat.loadInventory(vetheaCurios, player);
			player.getInventory().clearContent();
			player.getInventory().load(vetheaInventory);
		} else {
			if(ModList.get().isLoaded("curios")) CuriosCompat.loadInventory(overworldCurios, player);
			player.getInventory().clearContent();
			player.getInventory().load(overworldInventory);
		} player.inventoryMenu.broadcastChanges();
	}
	public void clearInventory(String inv) {
		if(inv == VetheaInventorySwapEvent.VETHEA_INVENTORY) {
			vetheaInventory = new ListTag();
			if(ModList.get().isLoaded("curios")) vetheaCurios = new ListTag();
		} else {
			overworldInventory = new ListTag();
			if(ModList.get().isLoaded("curios")) overworldCurios = new ListTag();
		}
	}
	public void stateVetheanInventory() {
		System.err.println("Current Vethea Inventory: " + vetheaInventory);
	}
	@Override public CompoundTag serializeNBT(HolderLookup.Provider provider) {
		CompoundTag tag = new CompoundTag();
		if(ModList.get().isLoaded("curios")) {
			tag.put("vethea_curios", vetheaCurios);
			tag.put("overworld_curios", overworldCurios);
		} tag.put("overworld_inventory", overworldInventory);
		tag.put("vethea_inventory", vetheaInventory);
		return tag;
	}
	@Override public void deserializeNBT(HolderLookup.Provider provider, CompoundTag tag) {
		if(ModList.get().isLoaded("curios") && tag.contains("vethea_curios")) {
			vetheaCurios = tag.getList("vethea_curios", 10);
			overworldCurios = tag.getList("overworld_curios", 10);
		} overworldInventory = tag.getList("overworld_inventory", 10);
		vetheaInventory = tag.getList("vethea_inventory", 10);
	}
}