package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityJackOMan extends EntityDivineMerchant {
    public EntityJackOMan(EntityType<? extends EntityDivineMerchant> type, World worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.25F;
    }

    @Override
    public String[] getChatMessages() {
        return new String[] {
                "message.jackoman.boo",
                "message.jackoman.lost",
                "message.jackoman.hurah",
                "message.jackoman.seen"
        };
    }

    @Override
    protected void updateTrades() {
        MerchantOffers merchantoffers = this.getOffers();

        DivineTrades[] tradetrades = new DivineTrades[]{
                new EntityDivineMerchant.DivineTrades(new ItemStack(Items.BONE, 60), new ItemStack(Items.SPIDER_EYE, 60), new ItemStack(ItemRegistry.skelemanHelmet), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(Items.BONE, 60), new ItemStack(Items.SPIDER_EYE, 60), new ItemStack(ItemRegistry.skelemanChestplate), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(Items.BONE, 60), new ItemStack(Items.SPIDER_EYE, 60), new ItemStack(ItemRegistry.skelemanLeggings), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(Items.BONE, 60), new ItemStack(Items.SPIDER_EYE, 40), new ItemStack(ItemRegistry.skelemanBoots), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(Blocks.PUMPKIN, 50), new ItemStack(Items.ENDER_EYE, 10), new ItemStack(ItemRegistry.jackOManHelmet), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(Blocks.PUMPKIN, 50), new ItemStack(Items.ENDER_EYE, 10), new ItemStack(ItemRegistry.jackOManChestplate), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(Blocks.PUMPKIN, 50), new ItemStack(Items.ENDER_EYE, 10), new ItemStack(ItemRegistry.jackOManLeggings), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(Blocks.PUMPKIN, 50), new ItemStack(Items.ENDER_EYE, 10), new ItemStack(ItemRegistry.jackOManBoots), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(Items.SKELETON_SKULL, 3), new ItemStack(ItemRegistry.witherReaperHelmet), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(Items.SKELETON_SKULL, 5), new ItemStack(ItemRegistry.witherReaperChestplate), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(Items.SKELETON_SKULL, 4), new ItemStack(ItemRegistry.witherReaperLeggings), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(Items.SKELETON_SKULL, 2), new ItemStack(ItemRegistry.witherReaperBoots), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(Items.SKELETON_SKULL, 6), new ItemStack(Items.ENDER_EYE, 60), new ItemStack(ItemRegistry.scythe), random.nextInt(7), 5)
        };
        this.addOffersFromItemListings(merchantoffers, tradetrades, 5);
        super.updateTrades();
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return true;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.JACKOMAN;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.JACKOMAN;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.JACKOMAN;
    }


}
