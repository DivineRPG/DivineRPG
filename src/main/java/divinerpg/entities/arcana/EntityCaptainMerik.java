package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.registries.RecipeRegistry;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;

public class EntityCaptainMerik extends EntityDivineMerchant {
	public EntityCaptainMerik(EntityType<? extends EntityDivineMerchant> type, Level worldIn) {super(type, worldIn, "captain_merik");}
	@Override public String[] getChatMessages() {
		return new String[] {
				"message.merik.battles",
				"message.merik.datticon",
				"message.merik.hurry",
				"message.merik.phoenix",
				"message.merik.sword"
		};
	}
	@Override protected void updateTrades() {
		addOffersFromItemListings(getOffers(), RecipeRegistry.Trades.CAPTAIN_MERIK.get(level(), getRandom()), 5);
	}
}