package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.registries.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.*;

public class EntityLordVatticus extends EntityDivineMerchant {
	public EntityLordVatticus(EntityType<? extends EntityDivineMerchant> type, Level worldIn) {
		super(type, worldIn, "lord_vatticus");
	}
	public String[] getChatMessages() {
		return new String[] {
				"message.vatticus.discover",
				"message.vatticus.feel",
				"message.vatticus.magic",
				"message.vatticus.noend",
				"message.vatticus.strength"
		};
	}
	@Override
	protected void updateTrades() {
		addOffersFromItemListings(getOffers(), RecipeRegistry.Trades.LORD_VATTICUS.get(level(), getRandom()), 5);
	}
}