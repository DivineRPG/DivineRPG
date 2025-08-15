package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.registries.SoundRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

import static divinerpg.registries.RecipeRegistry.Trades.LIVESTOCK_MERCHANT;

public class EntityLivestockMerchant extends EntityDivineMerchant {
    public EntityLivestockMerchant(EntityType<? extends EntityLivestockMerchant> type, Level worldIn) {super(type, worldIn, "livestock_merchant");}
    @Override public String[] getChatMessages() {
        return new String[] {
            "message.livestock.hi",
            "message.livestock.sell",
            "message.livestock.snapper",
            "message.livestock.travel"
        };
    }
    @Override protected void updateTrades() {addOffersFromItemListings(getOffers(), LIVESTOCK_MERCHANT.get(level(), getRandom()), 5);}
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.LIVESTOCK_MERCHANT.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.LIVESTOCK_MERCHANT_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.LIVESTOCK_MERCHANT_HURT.get();}
}