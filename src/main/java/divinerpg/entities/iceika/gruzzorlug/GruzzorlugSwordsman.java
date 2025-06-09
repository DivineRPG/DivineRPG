package divinerpg.entities.iceika.gruzzorlug;

import divinerpg.entities.goals.FollowLeaderGoal;
import divinerpg.registries.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;

public class GruzzorlugSwordsman extends Gruzzorlug {
	public GruzzorlugSwordsman(EntityType<? extends Gruzzorlug> type, Level worldIn) {
		super(type, worldIn);
	}
	@Override
	protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {
		setItemInHand(InteractionHand.MAIN_HAND, ItemRegistry.frost_sword.toStack());
	}
	@Override protected void registerGoals() {
		super.registerGoals();
		goalSelector.addGoal(4, new FollowLeaderGoal(this, GruzzorlugGeneral.class, 1, 4, (float)getAttributeValue(Attributes.FOLLOW_RANGE)));
	}
	@Override protected void updateTrades() {
        addOffersFromItemListings(getOffers(), RecipeRegistry.Trades.GRUZZORLUG_SWORDSMAN.get(level(), getRandom()), 3);
	}
}