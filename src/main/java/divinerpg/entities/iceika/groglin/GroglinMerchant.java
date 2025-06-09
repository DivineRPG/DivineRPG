package divinerpg.entities.iceika.groglin;

import divinerpg.entities.goals.AvoidFactionGoal;
import divinerpg.registries.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class GroglinMerchant extends Groglin {
	public GroglinMerchant(EntityType<? extends Groglin> type, Level worldIn) {
		super(type, worldIn);
	}
	@Override
	protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {
		setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(ItemRegistry.blue_armor_pouch.get()));
	}
	@Override protected void registerGoals() {
		goalSelector.addGoal(0, new FloatGoal(this));
		goalSelector.addGoal(4, new AvoidFactionGoal(this, getFaction(), (float)getAttributeValue(Attributes.FOLLOW_RANGE), 1.1, 1.1));
        goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1));
        goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6));
        goalSelector.addGoal(8, new RandomLookAroundGoal(this));
	}
	@Override protected void updateTrades() {
        addOffersFromItemListings(getOffers(), RecipeRegistry.Trades.GROGLIN_MERCHANT.get(level(), getRandom()), 3);
	}
}