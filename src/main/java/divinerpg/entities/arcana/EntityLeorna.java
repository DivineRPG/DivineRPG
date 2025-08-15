package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineMerchant;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

import static divinerpg.registries.RecipeRegistry.Trades.LEORNA;

public class EntityLeorna extends EntityDivineMerchant {
	public EntityLeorna(EntityType<? extends EntityLeorna> type, Level worldIn) {super(type, worldIn, "leorna");}
	@Override public String[] getChatMessages() {
		return new String[] {
			"message.leorna.hitchak",
			"message.leorna.lamona",
			"message.leorna.nature",
			"message.leorna.plants",
			"message.leorna.zelus"
		};
	}
	@Override protected void updateTrades() {addOffersFromItemListings(getOffers(), LEORNA.get(level(), getRandom()), 5);}
}