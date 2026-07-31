package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineMerchant;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

import static divinerpg.registries.RecipeRegistry.Trades.LORD_VATTICUS;

public class EntityLordVatticus extends EntityDivineMerchant {
    public EntityLordVatticus(EntityType<? extends EntityLordVatticus> type, Level worldIn) {super(type, worldIn, "lord_vatticus");}
    public String[] getChatMessages() {
        return new String[] {
                "message.vatticus.discover",
                "message.vatticus.feel",
                "message.vatticus.magic",
                "message.vatticus.noend",
                "message.vatticus.strength"
        };
    }
    @Override protected void updateTrades(ServerLevel level) {addOffersFromTradeSet(getOffers(), LORD_VATTICUS.get(level(), getRandom()), 5);}
}