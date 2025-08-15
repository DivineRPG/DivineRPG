package divinerpg.entities.iceika;

import divinerpg.entities.base.*;
import divinerpg.entities.goals.AvoidFactionGoal;
import divinerpg.registries.RecipeRegistry;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import static divinerpg.registries.RecipeRegistry.Trades.WORKSHOP_MERCHANT;

public class EntityWorkshopMerchant extends EntityDivineMerchant implements FactionEntity {
    public EntityWorkshopMerchant(EntityType<? extends EntityWorkshopMerchant> type, Level worldIn) {super(type, worldIn, "workshop_merchant");}
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
    @Override protected void updateTrades() {addOffersFromItemListings(getOffers(), WORKSHOP_MERCHANT.get(level(), getRandom()), 5);}
    @Override public void die(DamageSource cause) {
        if(level() instanceof ServerLevel) modifyReputationOnDeath(cause);
        super.die(cause);
    }
    @Override public boolean hurt(DamageSource source, float amount) {
        if(level() instanceof ServerLevel) modifyReputationOnHurt(source, amount);
        return super.hurt(source, amount);
    }
}