package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.tags.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

import javax.annotation.*;

public class EntityLivestockMerchant extends EntityDivineMerchant {


    public EntityLivestockMerchant(EntityType<? extends EntityDivineMerchant> type, World worldIn) {
        super(type, worldIn);
    }

    public String[] getChatMessages() {
        return new String[] {
                "message.livestock.hi",
                "message.livestock.sell",
                "message.livestock.snapper",
                "message.livestock.travel"
        };
    }

    @Override
    protected void updateTrades() {
        MerchantOffers merchantoffers = this.getOffers();

        DivineTrades[] tradetrades = new DivineTrades[]{
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemTags.LOGS.getRandomElement(level.getRandom()), 32), new ItemStack(ItemRegistry.shadowCoins, 4), new ItemStack(ItemRegistry.ehuEgg, 2), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemTags.LOGS.getRandomElement(level.getRandom()), 64), new ItemStack(ItemRegistry.shadowCoins, 7), new ItemStack(ItemRegistry.huskEgg, 2), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemTags.STONE_CRAFTING_MATERIALS.getRandomElement(level.getRandom()), 64), new ItemStack(ItemRegistry.shadowCoins, 3), new ItemStack(ItemRegistry.stoneGolemEgg, 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(Blocks.NETHER_BRICKS, 32), new ItemStack(ItemRegistry.shadowCoins, 5), new ItemStack(ItemRegistry.smelterEgg, 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.jungleStone, 2), new ItemStack(ItemRegistry.shadowCoins, 4), new ItemStack(ItemRegistry.snapperEgg, 3), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(Items.LEATHER, 10), new ItemStack(ItemRegistry.shadowCoins, 8), new ItemStack(ItemRegistry.whiteGrizzleEgg, 2), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(Items.LEATHER, 10), new ItemStack(ItemRegistry.shadowCoins, 8), new ItemStack(ItemRegistry.brownGrizzleEgg, 2), random.nextInt(7), 5)
                };
        this.addOffersFromItemListings(merchantoffers, tradetrades, 5);
        super.updateTrades();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.LIVESTOCK_MERCHANT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.LIVESTOCK_MERCHANT_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.LIVESTOCK_MERCHANT_HURT;
    }

    @Override
    public void setTradingPlayer(@Nullable PlayerEntity player) {
        boolean flag = this.getTradingPlayer() != null && player == null;
        super.setTradingPlayer(player);
        if (flag) {
            this.stopTrading();
        }

    }

    @Nullable
    @Override
    public PlayerEntity getTradingPlayer() {
        return super.getTradingPlayer();
    }
}