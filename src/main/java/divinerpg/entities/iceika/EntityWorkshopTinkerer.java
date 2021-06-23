package divinerpg.entities.iceika;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.world.*;

public class EntityWorkshopTinkerer extends EntityDivineMerchant {
    public EntityWorkshopTinkerer(EntityType<? extends EntityDivineMerchant> type, World worldIn) {
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

                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake, 1), new ItemStack(ItemRegistry.shuriken, 16), new ItemStack(ItemRegistry.snowflakeShuriken, 16), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake, 4), new ItemStack(ItemRegistry.serenadeStriker, 1), new ItemStack(ItemRegistry.serenadeOfIce, 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake, 7), new ItemStack(ItemRegistry.slimeSword, 1), new ItemStack(ItemRegistry.glacierSword, 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake, 12), new ItemStack(ItemRegistry.shadowBow, 1), new ItemStack(ItemRegistry.icicleBow, 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake, 6), new ItemStack(ItemRegistry.massivence, 1), new ItemStack(ItemRegistry.frossivence, 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake, 12), new ItemStack(ItemRegistry.crabclawCannon, 1), new ItemStack(ItemRegistry.frostclawCannon, 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake, 12), new ItemStack(ItemRegistry.frostCannon, 1), new ItemStack(ItemRegistry.fractiteCannon, 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake, 15), new ItemStack(ItemRegistry.frostSword, 1), new ItemStack(ItemRegistry.frostkingSword, 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake, 18), new ItemStack(ItemRegistry.soundOfMusic, 1), new ItemStack(ItemRegistry.soundOfCarols, 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake, 25), new ItemStack(ItemRegistry.enderSword, 1), new ItemStack(ItemRegistry.enderice, 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake, 30), new ItemStack(ItemRegistry.bluefireBow, 1), new ItemStack(ItemRegistry.snowstormBow, 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake, 45), new ItemStack(ItemRegistry.bedrockMaul, 1), new ItemStack(ItemRegistry.frozenMaul, 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake, 40), new ItemStack(ItemRegistry.divineSword, 1), new ItemStack(ItemRegistry.icineSword, 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake, 15), new ItemStack(ItemRegistry.sandslash, 1), new ItemStack(ItemRegistry.snowslash, 1), random.nextInt(7), 5)};
        this.addOffersFromItemListings(merchantoffers, tradetrades, 5);
        super.updateTrades();
    }

}
