package divinerpg.entities.iceika.groglin;

import divinerpg.entities.ai.FollowLeaderGoal;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class GroglinWarrior extends Groglin {
	public GroglinWarrior(EntityType<? extends Groglin> type, Level worldIn) {
		super(type, worldIn);
		entityData.set(ITEM, 2);
	}
	@Override protected TagKey<Item> getAcceptedItems() {return Groglin.WARRIOR_ACCEPTED;}
	@Override protected String getTradesLocation() {return "trades/groglin_warrior";}
	@Override protected void registerGoals() {
		super.registerGoals();
		goalSelector.addGoal(4, new FollowLeaderGoal(this, GroglinChieftain.class, 1, 4, (float)getAttributeValue(Attributes.FOLLOW_RANGE)));
	}
}