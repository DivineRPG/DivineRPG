package divinerpg.entities.iceika;

import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.registries.ItemRegistry;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.world.World;

import javax.annotation.*;

public class EntityWorkshopTinkerer extends EntityDivineMerchant {
    public EntityWorkshopTinkerer(EntityType<? extends CreatureEntity> type, World worldIn) {
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
//        return GUIHandler.WORKSHOP_TINKERER_GUI_ID;
        return 74;
    }


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
        list.add(new MerchantOffer(new ItemStack(ItemRegistry.snowflake, 1), new ItemStack(ItemRegistry.shuriken, 16), new ItemStack(ItemRegistry.snowflakeShuriken, 16), ItemRegistry.snowflakeShuriken.getMaxDamage(), 1, 1));
        list.add(new MerchantOffer(new ItemStack(ItemRegistry.snowflake, 4), new ItemStack(ItemRegistry.serenadeStriker, 1), new ItemStack(ItemRegistry.serenadeOfIce, 1), ItemRegistry.serenadeOfIce.getMaxDamage(), 1, 1));
        list.add(new MerchantOffer(new ItemStack(ItemRegistry.snowflake, 7), new ItemStack(ItemRegistry.slimeSword, 1), new ItemStack(ItemRegistry.glacierSword, 1), ItemRegistry.glacierSword.getMaxDamage(), 1, 1));
        list.add(new MerchantOffer(new ItemStack(ItemRegistry.snowflake, 12), new ItemStack(ItemRegistry.shadowBow, 1), new ItemStack(ItemRegistry.icicleBow, 1), ItemRegistry.icicleBow.getMaxDamage(), 1, 1));
        list.add(new MerchantOffer(new ItemStack(ItemRegistry.snowflake, 6), new ItemStack(ItemRegistry.massivence, 1), new ItemStack(ItemRegistry.frossivence, 1), ItemRegistry.frossivence.getMaxDamage(), 1, 1));
        list.add(new MerchantOffer(new ItemStack(ItemRegistry.snowflake, 12), new ItemStack(ItemRegistry.crabclawCannon, 1), new ItemStack(ItemRegistry.frostclawCannon, 1), ItemRegistry.frostclawCannon.getMaxDamage(), 1, 1));
        list.add(new MerchantOffer(new ItemStack(ItemRegistry.snowflake, 12), new ItemStack(ItemRegistry.frostCannon, 1), new ItemStack(ItemRegistry.fractiteCannon, 1), ItemRegistry.fractiteCannon.getMaxDamage(), 1, 1));
        list.add(new MerchantOffer(new ItemStack(ItemRegistry.snowflake, 15), new ItemStack(ItemRegistry.frostSword, 1), new ItemStack(ItemRegistry.frostkingSword, 1), ItemRegistry.frostkingSword.getMaxDamage(), 1, 1));
        list.add(new MerchantOffer(new ItemStack(ItemRegistry.snowflake, 18), new ItemStack(ItemRegistry.soundOfMusic, 1), new ItemStack(ItemRegistry.soundOfCarols, 1), ItemRegistry.soundOfCarols.getMaxDamage(), 1, 1));
        list.add(new MerchantOffer(new ItemStack(ItemRegistry.snowflake, 25), new ItemStack(ItemRegistry.enderSword, 1), new ItemStack(ItemRegistry.enderice, 1), ItemRegistry.enderice.getMaxDamage(), 1, 1));
        list.add(new MerchantOffer(new ItemStack(ItemRegistry.snowflake, 30), new ItemStack(ItemRegistry.bluefireBow, 1), new ItemStack(ItemRegistry.snowstormBow, 1), ItemRegistry.snowstormBow.getMaxDamage(), 1, 1));
        list.add(new MerchantOffer(new ItemStack(ItemRegistry.snowflake, 45), new ItemStack(ItemRegistry.bedrockMaul, 1), new ItemStack(ItemRegistry.frozenMaul, 1), ItemRegistry.frozenMaul.getMaxDamage(), 1, 1));
        list.add(new MerchantOffer(new ItemStack(ItemRegistry.snowflake, 40), new ItemStack(ItemRegistry.divineSword, 1), new ItemStack(ItemRegistry.icineSword, 1), ItemRegistry.icineSword.getMaxDamage(), 1, 1));
        list.add(new MerchantOffer(new ItemStack(ItemRegistry.snowflake, 15), new ItemStack(ItemRegistry.sandslash, 1), new ItemStack(ItemRegistry.snowslash, 1), ItemRegistry.snowslash.getMaxDamage(), 1, 1));
        return list;
    }

    @Override
    public void setTradingPlayer(@Nullable PlayerEntity player) {
    }

    @Override
    public World getLevel() {
        return level;
    }
}
