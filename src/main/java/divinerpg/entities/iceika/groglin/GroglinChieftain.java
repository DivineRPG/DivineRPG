package divinerpg.entities.iceika.groglin;

import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static divinerpg.registries.AttachmentRegistry.IMPORTANT;
import static divinerpg.registries.ItemRegistry.glacier_sword;
import static divinerpg.registries.RecipeRegistry.Trades.GROGLIN_CHIEFTAIN;
import static net.minecraft.world.InteractionHand.MAIN_HAND;

public class GroglinChieftain extends Groglin {
	public GroglinChieftain(EntityType<? extends GroglinChieftain> type, Level worldIn) {
		super(type, worldIn);
		if(!worldIn.isClientSide()) setData(IMPORTANT.attachment, true);
	}
	@Override protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {setItemInHand(MAIN_HAND, new ItemStack(glacier_sword.get()));}
	@Override protected void updateTrades() {addOffersFromItemListings(getOffers(), GROGLIN_CHIEFTAIN.get(level(), getRandom()), 3);}
}