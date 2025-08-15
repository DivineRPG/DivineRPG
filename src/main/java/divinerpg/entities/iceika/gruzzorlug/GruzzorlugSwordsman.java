package divinerpg.entities.iceika.gruzzorlug;

import divinerpg.entities.goals.FollowLeaderGoal;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;

import static divinerpg.registries.ItemRegistry.frost_sword;
import static divinerpg.registries.RecipeRegistry.Trades.GRUZZORLUG_SWORDSMAN;
import static net.minecraft.world.InteractionHand.MAIN_HAND;

public class GruzzorlugSwordsman extends Gruzzorlug {
	public GruzzorlugSwordsman(EntityType<? extends GruzzorlugSwordsman> type, Level worldIn) {super(type, worldIn);}
	@Override protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {setItemInHand(MAIN_HAND, frost_sword.toStack());}
	@Override protected void registerGoals() {
		super.registerGoals();
		goalSelector.addGoal(4, new FollowLeaderGoal(this, GruzzorlugGeneral.class, 1, 4, (float)getAttributeValue(Attributes.FOLLOW_RANGE)));
	}
	@Override protected void updateTrades() {addOffersFromItemListings(getOffers(), GRUZZORLUG_SWORDSMAN.get(level(), getRandom()), 3);}
}