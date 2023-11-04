package divinerpg.entities.iceika.groglin;

import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class GroglinChieftain extends Groglin {
	public GroglinChieftain(EntityType<? extends Monster> type, Level worldIn) {
		super(type, worldIn);
		entityData.set(ITEM, 9);
		entityData.set(IMPORTANT, true);
	}
	@Override
	protected TagKey<Item> getAcceptedItems() {
		return Groglin.WARRIOR_ACCEPTED;
	}
	@Override
	protected String getTradesLocation() {
		return "trades/groglin_chieftain";
	}
}