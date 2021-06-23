package divinerpg.entities.iceika;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.world.*;

public class EntityWorkshopMerchant extends EntityDivineMerchant {

    public EntityWorkshopMerchant(EntityType<? extends EntityDivineMerchant> type, World worldIn) {
        super(type, worldIn);
    }

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
        MerchantOffers merchantoffers = this.getOffers();

        DivineTrades[] tradetrades = new DivineTrades[]{
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake, 6), new ItemStack(ItemRegistry.santaHelmet, 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake, 6), new ItemStack(ItemRegistry.santaChestplate, 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake, 6), new ItemStack(ItemRegistry.santaLeggings, 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake, 6), new ItemStack(ItemRegistry.santaBoots, 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(ItemRegistry.eggNog, 2), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(ItemRegistry.chocolateLog, 5), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(ItemRegistry.peppermints, 15), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(ItemRegistry.fruitCake, 3), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake, 20), new ItemStack(ItemRegistry.icicleBane, 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(BlockRegistry.greenChristmasLights, 16), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(BlockRegistry.redChristmasLights, 16), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(BlockRegistry.blueChristmasLights, 16), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(BlockRegistry.yellowChristmasLights, 16), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(BlockRegistry.purpleChristmasLights, 16), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.iceStone, 9), new ItemStack(BlockRegistry.presentBox, 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(BlockRegistry.blueCandyCane, 4), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(BlockRegistry.greenCandyCane, 4), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(BlockRegistry.pinkCandyCane, 4), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(BlockRegistry.redCandyCane, 4), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(BlockRegistry.yellowCandyCane, 4), random.nextInt(7), 5)
        };
        this.addOffersFromItemListings(merchantoffers, tradetrades, 5);
        super.updateTrades();
    }
}