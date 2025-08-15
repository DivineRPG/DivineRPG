package divinerpg.entities.iceika.groglin;

import divinerpg.entities.goals.FollowLeaderGoal;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

import static divinerpg.registries.ItemRegistry.icicle_bane;
import static divinerpg.registries.RecipeRegistry.Trades.GROGLIN_WARRIOR;
import static net.minecraft.world.InteractionHand.MAIN_HAND;
import static net.minecraft.world.entity.ai.attributes.Attributes.FOLLOW_RANGE;

public class GroglinWarrior extends Groglin {
	public GroglinWarrior(EntityType<? extends GroglinWarrior> type, Level worldIn) {super(type, worldIn);}
	@Override protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {setItemInHand(MAIN_HAND, icicle_bane.toStack());}
	@Override protected void registerGoals() {
		super.registerGoals();
		goalSelector.addGoal(4, new FollowLeaderGoal(this, GroglinChieftain.class, 1, 4, (float)getAttributeValue(FOLLOW_RANGE)));
	}
	@Override protected void updateTrades() {addOffersFromItemListings(getOffers(), GROGLIN_WARRIOR.get(level(), getRandom()), 3);}
}