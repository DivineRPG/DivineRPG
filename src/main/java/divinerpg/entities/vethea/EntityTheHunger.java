package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.registries.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.*;

public class EntityTheHunger extends EntityDivineMerchant {
    public EntityTheHunger(EntityType<? extends EntityDivineMerchant> type, Level worldIn) {
        super(type, worldIn, "the_hunger");
    }
    public String[] getChatMessages() {
        return new String[] {
                "message.hunger.closer",
                "message.hunger.dinner",
                "message.hunger.fatten",
                "message.hunger.hungry"
        };
    }
    @Override
	protected void updateTrades() {
		addOffersFromItemListings(getOffers(), RecipeRegistry.Trades.THE_HUNGER.get(level(), getRandom()), 7);
	}
}