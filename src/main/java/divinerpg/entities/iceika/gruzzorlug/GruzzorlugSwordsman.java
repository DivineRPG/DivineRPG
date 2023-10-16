package divinerpg.entities.iceika.gruzzorlug;

import divinerpg.entities.ai.FollowLeaderGoal;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class GruzzorlugSwordsman extends Gruzzorlug {
	public GruzzorlugSwordsman(EntityType<? extends Monster> type, Level worldIn) {
		super(type, worldIn);
		entityData.set(ITEM, 5);
	}
	@Override
	protected TagKey<Item> getAcceptedItems() {
		return Gruzzorlug.KNIGHT_ACCEPTED;
	}
	@Override
	protected String getTradesLocation() {
		return "trades/gruzzorlug_knight";
	}
	@Override
	protected void registerGoals() {
		super.registerGoals();
		goalSelector.addGoal(4, new FollowLeaderGoal(this, GruzzorlugGeneral.class, 1D, 4F, (float)getAttributeValue(Attributes.FOLLOW_RANGE)));
	}
}