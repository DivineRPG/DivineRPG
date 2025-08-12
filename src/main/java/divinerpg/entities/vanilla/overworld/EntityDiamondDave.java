package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.registries.*;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.*;

public class EntityDiamondDave extends EntityDivineMerchant {
    public EntityDiamondDave(EntityType<? extends EntityDivineMerchant> type, Level worldIn) {
        super(type, worldIn, "diamond_dave");
    }
    @Override public String[] getChatMessages() {
        return new String[] {
                "message.diamond_dave.isolation",
                "message.diamond_dave.cruel",
                "message.diamond_dave.dream",
                "message.diamond_dave.creative",
                "message.diamond_dave.exploit",
                "message.diamond_dave.mysterious",
                "message.diamond_dave.asthenia"
        };
    }
    @Override protected void updateTrades() {
        addOffersFromItemListings(getOffers(), RecipeRegistry.Trades.DIAMOND_DAVE.get(level(), getRandom()), 5);
    }
    @Override protected SoundEvent getAmbientSound() {
        return SoundRegistry.LIVESTOCK_MERCHANT.get();
    }
    @Override protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.LIVESTOCK_MERCHANT_HURT.get();
    }
    @Override protected SoundEvent getDeathSound() {
        return SoundRegistry.LIVESTOCK_MERCHANT_HURT.get();
    }
}