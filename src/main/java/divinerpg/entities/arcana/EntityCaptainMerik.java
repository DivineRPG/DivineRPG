package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineMerchant;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

import static divinerpg.registries.RecipeRegistry.Trades.CAPTAIN_MERIK;

public class EntityCaptainMerik extends EntityDivineMerchant {
	public EntityCaptainMerik(EntityType<? extends EntityCaptainMerik> type, Level worldIn) {super(type, worldIn, "captain_merik");}
	@Override public String[] getChatMessages() {
		return new String[] {
			"message.merik.battles",
			"message.merik.datticon",
			"message.merik.hurry",
			"message.merik.phoenix",
			"message.merik.sword"
		};
	}
	@Override protected void updateTrades() {addOffersFromItemListings(getOffers(), CAPTAIN_MERIK.get(level(), getRandom()), 5);}
}