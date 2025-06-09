package divinerpg.entities.iceika.groglin;

import divinerpg.registries.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class GroglinRanger extends Groglin {
	public GroglinRanger(EntityType<? extends Groglin> type, Level worldIn) {
		super(type, worldIn);
	}
	@Override
	protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {
		setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(ItemRegistry.sabear_sabre.get()));
	}
	@Override protected void updateTrades() {
        addOffersFromItemListings(getOffers(), RecipeRegistry.Trades.GROGLIN_RANGER.get(level(), getRandom()), 3);
	}
}