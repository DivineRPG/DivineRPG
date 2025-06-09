package divinerpg.entities.iceika.groglin;

import divinerpg.registries.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class GroglinChieftain extends Groglin {
	public GroglinChieftain(EntityType<? extends Groglin> type, Level worldIn) {
		super(type, worldIn);
		if(!worldIn.isClientSide()) setData(AttachmentRegistry.IMPORTANT.attachment, true);
	}
	@Override
	protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {
		setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(ItemRegistry.glacier_sword.get()));
	}
	@Override protected void updateTrades() {
        addOffersFromItemListings(getOffers(), RecipeRegistry.Trades.GROGLIN_CHIEFTAIN.get(level(), getRandom()), 3);
	}
}