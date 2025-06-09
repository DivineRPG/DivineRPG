package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.registries.RecipeRegistry;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.*;

public class EntityZelus extends EntityDivineMerchant {
	public EntityZelus(EntityType<? extends EntityDivineMerchant> type, Level worldIn) {
		super(type, worldIn, "zelus");
	}
	public String[] getChatMessages() {
		return new String[] {
				"message.zelus.fine",
				"message.zelus.minions",
				"message.zelus.flower",
				"message.zelus.plants"
		};
	}
	@Override
	protected void updateTrades() {
		addOffersFromItemListings(getOffers(), RecipeRegistry.Trades.ZELUS.get(level(), getRandom()), 5);
	}
}