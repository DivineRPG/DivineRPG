package divinerpg.entities.iceika.gruzzorlug;

import divinerpg.registries.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class GruzzorlugMiner extends Gruzzorlug {
	public GruzzorlugMiner(EntityType<? extends Gruzzorlug> type, Level worldIn) {
		super(type, worldIn);
	}
	@Override
	protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {
		setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(ItemRegistry.oxdrite_pickaxe.get()));
	}
	@Override
	protected void updateTrades() {
        addOffersFromItemListings(getOffers(), RecipeRegistry.Trades.GRUZZORLUG_MINER.get(level(), getRandom()), 3);
	}
}