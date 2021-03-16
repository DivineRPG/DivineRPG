package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.registries.*;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.*;

public class EntityJackOMan extends EntityDivineMerchant {
    public EntityJackOMan(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    protected int getGuiId() {
        //TODO - Jack O Man GUI
//        return GUIHandler.JACK_O_MAN_GUI_ID;
        return 0;
    }
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.25F;
    }

    @Override
    protected void onVillagerTrade(MerchantOffer offer) {

    }

    @Override
    protected void populateTradeData() {

    }

    //TODO - right click chat messages
//    @Override
//    protected String[] getChatMessages() {
//        return new String[] {
//                "message.jackoman.boo",
//                "message.jackoman.lost",
//                "message.jackoman.hurah",
//                "message.jackoman.seen"
//        };
//    }

    @Override
    public MerchantOffers getRecipeList() {
        MerchantOffers offers = new MerchantOffers();
        offers.add(new MerchantOffer(new ItemStack(Items.BONE, 60), new ItemStack(Items.SPIDER_EYE, 60), new ItemStack(ItemRegistry.skelemanHelmet, 1), ItemRegistry.skelemanHelmet.getMaxDamage(), 1, 1));
        offers.add(new MerchantOffer(new ItemStack(Items.BONE, 60), new ItemStack(Items.SPIDER_EYE, 60), new ItemStack(ItemRegistry.skelemanChestplate, 1), ItemRegistry.skelemanChestplate.getMaxDamage(), 1, 1));
        offers.add(new MerchantOffer(new ItemStack(Items.BONE, 60), new ItemStack(Items.SPIDER_EYE, 60), new ItemStack(ItemRegistry.skelemanLeggings, 1), ItemRegistry.skelemanLeggings.getMaxDamage(), 1, 1));
        offers.add(new MerchantOffer(new ItemStack(Items.BONE, 40), new ItemStack(Items.SPIDER_EYE, 60), new ItemStack(ItemRegistry.skelemanBoots, 1), ItemRegistry.skelemanBoots.getMaxDamage(), 1, 1));
        offers.add(new MerchantOffer(new ItemStack(Blocks.PUMPKIN, 50), new ItemStack(Items.ENDER_EYE, 10), new ItemStack(ItemRegistry.jackOManHelmet), ItemRegistry.jackOManHelmet.getMaxDamage(), 1, 1));
        offers.add(new MerchantOffer(new ItemStack(Blocks.PUMPKIN, 50), new ItemStack(Items.ENDER_EYE, 10), new ItemStack(ItemRegistry.jackOManChestplate), ItemRegistry.jackOManChestplate.getMaxDamage(), 1, 1));
        offers.add(new MerchantOffer(new ItemStack(Blocks.PUMPKIN, 50), new ItemStack(Items.ENDER_EYE, 10), new ItemStack(ItemRegistry.jackOManLeggings), ItemRegistry.jackOManLeggings.getMaxDamage(), 1, 1));
        offers.add(new MerchantOffer(new ItemStack(Blocks.PUMPKIN, 50), new ItemStack(Items.ENDER_EYE, 10), new ItemStack(ItemRegistry.jackOManBoots), ItemRegistry.jackOManBoots.getMaxDamage(), 1, 1));
        offers.add(new MerchantOffer(new ItemStack(Blocks.WITHER_SKELETON_SKULL, 3), new ItemStack(ItemRegistry.witherReaperHelmet), ItemRegistry.witherReaperHelmet.getMaxDamage(), 1, 1));
        offers.add(new MerchantOffer(new ItemStack(Blocks.WITHER_SKELETON_SKULL, 5), new ItemStack(ItemRegistry.witherReaperChestplate), ItemRegistry.witherReaperChestplate.getMaxDamage(), 1, 1));
        offers.add(new MerchantOffer(new ItemStack(Blocks.WITHER_SKELETON_SKULL, 4), new ItemStack(ItemRegistry.witherReaperLeggings), ItemRegistry.witherReaperLeggings.getMaxDamage(), 1, 1));
        offers.add(new MerchantOffer(new ItemStack(Blocks.WITHER_SKELETON_SKULL, 2), new ItemStack(ItemRegistry.witherReaperBoots), ItemRegistry.witherReaperBoots.getMaxDamage(), 1, 1));
        offers.add(new MerchantOffer(new ItemStack(Blocks.WITHER_SKELETON_SKULL, 6), new ItemStack(Items.ENDER_EYE, 60), new ItemStack(ItemRegistry.scythe), ItemRegistry.scythe.getMaxDamage(), 1, 1));


        return offers;
    }

    @Override
    public boolean canRestock() {return true;
    }

    @Override
    public void openTradingScreen(PlayerEntity player, ITextComponent displayName, int level) {
        if (getGuiId() != 0) {
            super.openTradingScreen(player, displayName, level);
        }
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

    @Override
    public void setTradingPlayer(@Nullable PlayerEntity p_70932_1_) {

    }

    @Override
    public World getLevel() {
        return level;
    }
}
