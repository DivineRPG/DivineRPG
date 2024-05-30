package divinerpg.entities.iceika.groglin;

import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class GroglinRanger extends Groglin {
	public GroglinRanger(EntityType<? extends Groglin> type, Level worldIn) {
		super(type, worldIn);
		entityData.set(ITEM, 11);
	}
	@Override protected TagKey<Item> getAcceptedItems() {return Groglin.WARRIOR_ACCEPTED;}
	@Override protected String getTradesLocation() {return "trades/groglin_hunter";}
}