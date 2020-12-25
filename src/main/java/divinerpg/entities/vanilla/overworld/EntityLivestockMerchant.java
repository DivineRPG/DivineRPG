package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.registries.*;
import net.minecraft.block.Blocks;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraftforge.common.Tags;

public class EntityLivestockMerchant extends EntityDivineMerchant {


    public EntityLivestockMerchant(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void onVillagerTrade(MerchantOffer offer) {

    }

    @Override
    protected void populateTradeData() {

    }

    protected int getGuiId() {
        //TODO - Livestock Merchant GUID
        //        return GUIHandler.LIVESTOCK_MERCHANT_GUI_ID;
        return 0;
    }

    //TODO - Chat messages
    protected String[] getChatMessages() {
        return new String[] {
                "message.livestock.hi",
                "message.livestock.sell",
                "message.livestock.snapper",
                "message.livestock.travel"
        };
    }

    public MerchantOffers getRecipeList() {
        MerchantOffers list = new MerchantOffers();
        list.add(new MerchantOffer(new ItemStack(ItemTags.getCollection().get(ItemTags.LOGS.getName()).getAllElements().listIterator().next(), 32), new ItemStack(ItemRegistry.shadowCoins, 4), new ItemStack(ItemRegistry.ehuEgg, 2), ItemRegistry.ehuEgg.getMaxDamage(), 1, 1));
        list.add(new MerchantOffer(new ItemStack(ItemTags.getCollection().get(ItemTags.LOGS.getName()).getAllElements().listIterator().next(), 64), new ItemStack(ItemRegistry.shadowCoins, 7), new ItemStack(ItemRegistry.huskEgg, 2), ItemRegistry.huskEgg.getMaxDamage(), 1, 1));
        list.add(new MerchantOffer(new ItemStack(ItemTags.getCollection().get(ItemTags.STONE_CRAFTING_MATERIALS.getName()).getAllElements().listIterator().next(), 64), new ItemStack(ItemRegistry.shadowCoins, 3), new ItemStack(ItemRegistry.stoneGolemEgg, 1), ItemRegistry.stoneGolemEgg.getMaxDamage(), 1, 1));
        list.add(new MerchantOffer(new ItemStack(Blocks.NETHER_BRICKS, 32), new ItemStack(ItemRegistry.shadowCoins, 5), new ItemStack(ItemRegistry.smelterEgg, 1), ItemRegistry.smelterEgg.getMaxDamage(), 1, 1));
        list.add(new MerchantOffer(new ItemStack(ItemRegistry.jungleStone, 2), new ItemStack(ItemRegistry.shadowCoins, 4), new ItemStack(ItemRegistry.snapperEgg, 3), ItemRegistry.snapperEgg.getMaxDamage(), 1, 1));
        list.add(new MerchantOffer(new ItemStack(Items.LEATHER, 10), new ItemStack(ItemRegistry.shadowCoins, 8), new ItemStack(ItemRegistry.whiteGrizzleEgg, 2), ItemRegistry.whiteGrizzleEgg.getMaxDamage(), 1, 1));
        list.add(new MerchantOffer(new ItemStack(Items.LEATHER, 10), new ItemStack(ItemRegistry.shadowCoins, 8), new ItemStack(ItemRegistry.brownGrizzleEgg, 2), ItemRegistry.brownGrizzleEgg.getMaxDamage(), 1, 1));
        return list;
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
}