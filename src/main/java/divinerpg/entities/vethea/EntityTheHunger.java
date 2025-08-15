package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityDivineMerchant;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

import static divinerpg.registries.RecipeRegistry.Trades.THE_HUNGER;

public class EntityTheHunger extends EntityDivineMerchant {
    public EntityTheHunger(EntityType<? extends EntityTheHunger> type, Level worldIn) {super(type, worldIn, "the_hunger");}
    @Override public String[] getChatMessages() {
        return new String[] {
            "message.hunger.closer",
            "message.hunger.dinner",
            "message.hunger.fatten",
            "message.hunger.hungry"
        };
    }
    @Override protected void updateTrades() {addOffersFromItemListings(getOffers(), THE_HUNGER.get(level(), getRandom()), 7);}
}