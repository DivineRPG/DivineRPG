package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineMerchant;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

import static divinerpg.registries.RecipeRegistry.Trades.WAR_GENERAL;

public class EntityWarGeneral extends EntityDivineMerchant {
    public EntityWarGeneral(EntityType<? extends EntityWarGeneral> type, Level worldIn) {super(type, worldIn, "war_general");}
    @Override public String[] getChatMessages() {
        return new String[] {
                "message.general.blade",
                "message.general.merik",
                "message.general.weapons"
        };
    }
    @Override protected void updateTrades(ServerLevel level) {addOffersFromTradeSet(getOffers(), WAR_GENERAL.get(level(), getRandom()), 5);}
}