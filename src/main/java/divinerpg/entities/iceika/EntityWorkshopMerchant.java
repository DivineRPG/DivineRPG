package divinerpg.entities.iceika;

import divinerpg.entities.goals.AvoidFactionGoal;
import divinerpg.entities.base.*;
import divinerpg.registries.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class EntityWorkshopMerchant extends EntityDivineMerchant implements FactionEntity {
    public EntityWorkshopMerchant(EntityType<? extends EntityDivineMerchant> type, Level worldIn) {
        super(type, worldIn, "workshop_merchant");
    }
    @Override
    public Faction getFaction() {
    	return Faction.ICEIKA_MERCHANT;
    }
    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
    	if(getFaction().reputation.get(player) > 5) return super.mobInteract(player, hand);
    	playSound(SoundEvents.VILLAGER_NO);
    	return InteractionResult.FAIL;
    }
    @Override
    protected void registerGoals() {
    	super.registerGoals();
		goalSelector.addGoal(4, new AvoidFactionGoal(this, getFaction(), (float)getAttributeValue(Attributes.FOLLOW_RANGE), 1.1, 1.1));
    }
    @Override
    public String[] getChatMessages() {
        return new String[] {
                "message.merchant.burr",
                "message.merchant.ho",
                "message.merchant.in",
                "message.merchant.out"
        };
    }
    @Override
    protected void updateTrades() {
        addOffersFromItemListings(getOffers(), RecipeRegistry.Trades.WORKSHOP_MERCHANT.get(level(), getRandom()), 5);
    }
    @Override
    public void die(DamageSource cause) {
        if(level() instanceof ServerLevel) modifyReputationOnDeath(cause);
        super.die(cause);
    }
    @Override
    public boolean hurt(DamageSource source, float amount) {
        if(level() instanceof ServerLevel) modifyReputationOnHurt(source, amount);
        return super.hurt(source, amount);
    }
}
