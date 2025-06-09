package divinerpg.entities.iceika.groglin;

import divinerpg.entities.goals.FollowLeaderGoal;
import divinerpg.registries.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;

public class GroglinWarrior extends Groglin {
	public GroglinWarrior(EntityType<? extends Groglin> type, Level worldIn) {
		super(type, worldIn);
	}
	@Override
	protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {
		setItemInHand(InteractionHand.MAIN_HAND, ItemRegistry.icicle_bane.toStack());
	}
	@Override protected void registerGoals() {
		super.registerGoals();
		goalSelector.addGoal(4, new FollowLeaderGoal(this, GroglinChieftain.class, 1, 4, (float)getAttributeValue(Attributes.FOLLOW_RANGE)));
	}
	@Override
	protected void updateTrades() {
        addOffersFromItemListings(getOffers(), RecipeRegistry.Trades.GROGLIN_WARRIOR.get(level(), getRandom()), 3);
	}
}