package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.registries.RecipeRegistry;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;

public class EntityWarGeneral extends EntityDivineMerchant {
	public EntityWarGeneral(EntityType<? extends EntityDivineMerchant> type, Level worldIn) {super(type, worldIn, "war_general");}
	@Override public String[] getChatMessages() {
		return new String[] {
				"message.general.blade",
				"message.general.merik",
				"message.general.weapons"
		};
	}
	@Override protected void updateTrades() {
		addOffersFromItemListings(offers, RecipeRegistry.Trades.WAR_GENERAL.get(level(), getRandom()), 5);
	}
}