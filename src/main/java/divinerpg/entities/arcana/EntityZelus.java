package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineMerchant;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

import static divinerpg.registries.RecipeRegistry.Trades.ZELUS;

public class EntityZelus extends EntityDivineMerchant {
	public EntityZelus(EntityType<? extends EntityZelus> type, Level worldIn) {super(type, worldIn, "zelus");}
	@Override public String[] getChatMessages() {
		return new String[] {
			"message.zelus.fine",
			"message.zelus.minions",
			"message.zelus.flower",
			"message.zelus.plants"
		};
	}
	@Override protected void updateTrades() {addOffersFromItemListings(getOffers(), ZELUS.get(level(), getRandom()), 5);}
}