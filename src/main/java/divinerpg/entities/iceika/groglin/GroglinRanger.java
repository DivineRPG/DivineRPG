package divinerpg.entities.iceika.groglin;

import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static divinerpg.registries.ItemRegistry.sabear_sabre;
import static divinerpg.registries.RecipeRegistry.Trades.GROGLIN_RANGER;
import static net.minecraft.world.InteractionHand.MAIN_HAND;

public class GroglinRanger extends Groglin {
	public GroglinRanger(EntityType<? extends GroglinRanger> type, Level worldIn) {super(type, worldIn);}
	@Override protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {setItemInHand(MAIN_HAND, new ItemStack(sabear_sabre.get()));}
	@Override protected void updateTrades() {addOffersFromItemListings(getOffers(), GROGLIN_RANGER.get(level(), getRandom()), 3);
	}
}