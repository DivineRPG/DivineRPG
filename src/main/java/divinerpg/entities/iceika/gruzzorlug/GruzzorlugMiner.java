package divinerpg.entities.iceika.gruzzorlug;

import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static divinerpg.registries.ItemRegistry.oxdrite_pickaxe;
import static divinerpg.registries.RecipeRegistry.Trades.GRUZZORLUG_MINER;
import static net.minecraft.world.InteractionHand.MAIN_HAND;

public class GruzzorlugMiner extends Gruzzorlug {
	public GruzzorlugMiner(EntityType<? extends GruzzorlugMiner> type, Level worldIn) {super(type, worldIn);}
	@Override protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {setItemInHand(MAIN_HAND, new ItemStack(oxdrite_pickaxe.get()));}
	@Override protected void updateTrades() {addOffersFromItemListings(getOffers(), GRUZZORLUG_MINER.get(level(), getRandom()), 3);}
}