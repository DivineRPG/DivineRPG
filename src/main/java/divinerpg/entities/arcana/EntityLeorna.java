package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.registries.RecipeRegistry;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.*;

public class EntityLeorna extends EntityDivineMerchant {
	public EntityLeorna(EntityType<? extends EntityDivineMerchant> type, Level worldIn) {
		super(type, worldIn, "leorna");
	}
	public String[] getChatMessages() {
		return new String[] {
				"message.leorna.hitchak",
				"message.leorna.lamona",
				"message.leorna.nature",
				"message.leorna.plants",
				"message.leorna.zelus"
		};
	}
	@Override
	protected void updateTrades() {
		addOffersFromItemListings(getOffers(), RecipeRegistry.Trades.LEORNA.get(level(), getRandom()), 5);
	}
}