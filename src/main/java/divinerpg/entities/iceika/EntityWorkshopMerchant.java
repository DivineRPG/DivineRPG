package divinerpg.entities.iceika;

import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.registries.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.world.World;

public class EntityWorkshopMerchant extends EntityDivineMerchant {

    public EntityWorkshopMerchant(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void onVillagerTrade(MerchantOffer offer) {

    }

    @Override
    protected void populateTradeData() {

    }

    @Override
    protected int getGuiId() {
        //TODO - GUI ID workshop merchant
        return 5;
    }

//    protected int getGuiId() {
//        return GUIHandler.WORKSHOP_MERCHANT_GUI_ID;
//    }

    protected String[] getChatMessages() {
        return new String[] {
                "message.merchant.burr",
                "message.merchant.ho",
                "message.merchant.in",
                "message.merchant.out"
        };
    }

    @Override
    public MerchantOffers getRecipeList() {
        MerchantOffers list = new MerchantOffers();
        //TODO - workshop merchant trades
        list.add(new MerchantOffer(new ItemStack(ItemRegistry.snowflake, 6), new ItemStack(ItemRegistry.santaHelmet, 1), ItemRegistry.santaHelmet.getMaxDamage(), 1, 1));
        list.add(new MerchantOffer(new ItemStack(ItemRegistry.snowflake, 6), new ItemStack(ItemRegistry.santaChestplate, 1), ItemRegistry.santaChestplate.getMaxDamage(), 1, 1));
        list.add(new MerchantOffer(new ItemStack(ItemRegistry.snowflake, 6), new ItemStack(ItemRegistry.santaLeggings, 1), ItemRegistry.santaLeggings.getMaxDamage(), 1, 1));
        list.add(new MerchantOffer(new ItemStack(ItemRegistry.snowflake, 6), new ItemStack(ItemRegistry.santaBoots, 1), ItemRegistry.santaBoots.getMaxDamage(), 1, 1));
        list.add(new MerchantOffer(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(ItemRegistry.eggNog, 2), ItemRegistry.eggNog.getMaxDamage(), 1, 1));
        list.add(new MerchantOffer(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(ItemRegistry.chocolateLog, 5), ItemRegistry.chocolateLog.getMaxDamage(), 1, 1));
        list.add(new MerchantOffer(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(ItemRegistry.peppermints, 15), ItemRegistry.peppermints.getMaxDamage(), 1, 1));
        list.add(new MerchantOffer(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(ItemRegistry.fruitCake, 3), ItemRegistry.fruitCake.getMaxDamage(), 1, 1));
        list.add(new MerchantOffer(new ItemStack(ItemRegistry.snowflake, 20), new ItemStack(ItemRegistry.icicleBane, 1), ItemRegistry.icicleBane.getMaxDamage(), 1, 1));
        list.add(new MerchantOffer(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(BlockRegistry.greenChristmasLights, 16), BlockRegistry.greenChristmasLights.asItem().getMaxDamage(), 1, 1));
        list.add(new MerchantOffer(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(BlockRegistry.redChristmasLights, 16), BlockRegistry.redChristmasLights.asItem().getMaxDamage(), 1, 1));
        list.add(new MerchantOffer(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(BlockRegistry.blueChristmasLights, 16), BlockRegistry.blueChristmasLights.asItem().getMaxDamage(), 1, 1));
        list.add(new MerchantOffer(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(BlockRegistry.yellowChristmasLights, 16), BlockRegistry.yellowChristmasLights.asItem().getMaxDamage(), 1, 1));
        list.add(new MerchantOffer(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(BlockRegistry.purpleChristmasLights, 16), BlockRegistry.purpleChristmasLights.asItem().getMaxDamage(), 1, 1));
//        list.add(new MerchantOffer(new ItemStack(ItemRegistry.iceStone, 9), new ItemStack(BlockRegistry.presentBox, 1), BlockRegistry.presentBox.asItem().getMaxDamage(), 1, 1));
//        list.add(new MerchantOffer(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(BlockRegistry.blueCandyCane, 4), ItemRegistry.skelemanHelmet.getMaxDamage(), 1, 1));
//        list.add(new MerchantOffer(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(BlockRegistry.greenCandyCane, 4), ItemRegistry.skelemanHelmet.getMaxDamage(), 1, 1));
//        list.add(new MerchantOffer(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(BlockRegistry.pinkCandyCane, 4), ItemRegistry.skelemanHelmet.getMaxDamage(), 1, 1));
//        list.add(new MerchantOffer(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(BlockRegistry.redCandyCane, 4), ItemRegistry.skelemanHelmet.getMaxDamage(), 1, 1));
//        list.add(new MerchantOffer(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(BlockRegistry.yellowCandyCane, 4), ItemRegistry.skelemanHelmet.getMaxDamage(), 1, 1));
        return list;
    }
}