package divinerpg.entities.iceika;

import divinerpg.entities.ai.AvoidFactionGoal;
import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.entities.base.FactionEntity;
import divinerpg.registries.ItemRegistry;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.*;

public class EntityWorkshopTinkerer extends EntityDivineMerchant implements FactionEntity {
    public EntityWorkshopTinkerer(EntityType<? extends EntityDivineMerchant> type, Level worldIn) {
        super(type, worldIn);
    }
    @Override
    public Faction getFaction() {
    	return Faction.ICEIKA_MERCHANT;
    }
    @Override
    protected void registerGoals() {
    	super.registerGoals();
		goalSelector.addGoal(4, new AvoidFactionGoal(this, getFaction(), (float)getAttributeValue(Attributes.FOLLOW_RANGE), 1.1, 1.1));
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

                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake.get(), 1), new ItemStack(ItemRegistry.shuriken.get(), 16), new ItemStack(ItemRegistry.snowflake_shuriken.get(), 16), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake.get(), 4), new ItemStack(ItemRegistry.serenade_striker.get(), 1), new ItemStack(ItemRegistry.serenade_of_ice.get(), 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake.get(), 7), new ItemStack(ItemRegistry.slime_sword.get(), 1), new ItemStack(ItemRegistry.glacier_sword.get(), 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake.get(), 12), new ItemStack(ItemRegistry.shadow_bow.get(), 1), new ItemStack(ItemRegistry.icicle_bow.get(), 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake.get(), 6), new ItemStack(ItemRegistry.massivence.get(), 1), new ItemStack(ItemRegistry.frossivence.get(), 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake.get(), 12), new ItemStack(ItemRegistry.crabclaw_cannon.get(), 1), new ItemStack(ItemRegistry.frostclaw_cannon.get(), 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake.get(), 12), new ItemStack(ItemRegistry.frost_cannon.get(), 1), new ItemStack(ItemRegistry.fractite_cannon.get(), 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake.get(), 15), new ItemStack(ItemRegistry.frost_sword.get(), 1), new ItemStack(ItemRegistry.frostking_sword.get(), 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake.get(), 18), new ItemStack(ItemRegistry.sound_of_music.get(), 1), new ItemStack(ItemRegistry.sound_of_carols.get(), 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake.get(), 25), new ItemStack(ItemRegistry.ender_sword.get(), 1), new ItemStack(ItemRegistry.enderice.get(), 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake.get(), 30), new ItemStack(ItemRegistry.soulfire_bow.get(), 1), new ItemStack(ItemRegistry.snowstorm_bow.get(), 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake.get(), 45), new ItemStack(ItemRegistry.bedrock_maul.get(), 1), new ItemStack(ItemRegistry.frozen_maul.get(), 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake.get(), 40), new ItemStack(ItemRegistry.divine_sword.get(), 1), new ItemStack(ItemRegistry.icine_sword.get(), 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake.get(), 15), new ItemStack(ItemRegistry.sandslash.get(), 1), new ItemStack(ItemRegistry.snowslash.get(), 1), random.nextInt(7), 5)};
        this.addOffersFromItemListings(merchantoffers, tradetrades, 5);
    }
}