package divinerpg.entities.iceika;

import divinerpg.entities.base.*;
import divinerpg.entities.goals.AvoidFactionGoal;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import static divinerpg.registries.RecipeRegistry.Trades.WORKSHOP_TINKERER;

public class EntityWorkshopTinkerer extends EntityDivineMerchant implements FactionEntity {
    public EntityWorkshopTinkerer(EntityType<? extends EntityWorkshopTinkerer> type, Level worldIn) {super(type, worldIn, "workshop_tinkerer");}
    @Override public Faction getFaction() {return Faction.ICEIKA_MERCHANT;}
    @Override public InteractionResult mobInteract(Player player, InteractionHand hand) {
    	if(getFaction().reputation.get(player) > 5) return super.mobInteract(player, hand);
    	playSound(SoundEvents.VILLAGER_NO);
    	return InteractionResult.FAIL;
    }
    @Override protected void registerGoals() {
    	super.registerGoals();
		goalSelector.addGoal(1, new AvoidFactionGoal(this, getFaction(), 15, .5, .5));
    }
    @Override public String[] getChatMessages() {
        return new String[] {
            "message.merchant.burr",
            "message.merchant.ho",
            "message.merchant.in",
            "message.merchant.out"
        };
    }
    @Override protected void updateTrades() {addOffersFromItemListings(getOffers(), WORKSHOP_TINKERER.get(level(), getRandom()), 5);}
}