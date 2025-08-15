package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineMerchant;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

import static divinerpg.registries.RecipeRegistry.Trades.KAZARI;

public class EntityKazari extends EntityDivineMerchant {
	public EntityKazari(EntityType<? extends EntityKazari> type, Level worldIn) {super(type, worldIn, "kazari");}
	@Override public String[] getChatMessages() {
		return new String[] {
			"message.kazari.1",
			"message.kazari.2",
			"message.kazari.3",
			"message.kazari.4",
			"message.kazari.5",
			"message.kazari.6",
			"message.kazari.7",
			"message.kazari.8"
		};
	}
	@Override protected void updateTrades() {addOffersFromItemListings(getOffers(), KAZARI.get(level(), getRandom()), 5);}
}