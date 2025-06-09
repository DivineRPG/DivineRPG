package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.registries.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.*;

public class EntityKazari extends EntityDivineMerchant {
	public EntityKazari(EntityType<? extends EntityDivineMerchant> type, Level worldIn) {
		super(type, worldIn, "kazari");
	}
	public String[] getChatMessages() {
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
	@Override
	protected void updateTrades() {
		this.addOffersFromItemListings(getOffers(), RecipeRegistry.Trades.KAZARI.get(level(), getRandom()), 5);
	}
}
