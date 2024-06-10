package divinerpg.entities.iceika;

import divinerpg.entities.ai.AvoidFactionGoal;
import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.entities.base.FactionEntity;
import divinerpg.registries.*;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;

public class EntityWorkshopMerchant extends EntityDivineMerchant implements FactionEntity {
    public EntityWorkshopMerchant(EntityType<? extends EntityDivineMerchant> type, Level worldIn) {
        super(type, worldIn);
    }
    @Override
    public Faction getFaction() {
    	return Faction.ICEIKA_MERCHANT;
    }
    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
    	if(getFaction().getReputation(player) > 5) {
        	return super.mobInteract(player, hand);
    	} playSound(SoundEvents.VILLAGER_NO);
    	return InteractionResult.FAIL;
    }
    @Override
    protected void registerGoals() {
    	super.registerGoals();
		goalSelector.addGoal(4, new AvoidFactionGoal(this, getFaction(), (float)getAttributeValue(Attributes.FOLLOW_RANGE), 1.1, 1.1));
    }
    @Override
    public String[] getChatMessages() {
        return new String[] {
                "message.merchant.burr",
                "message.merchant.ho",
                "message.merchant.in",
                "message.merchant.out"
        };
    }
    @Override protected float getStandingEyeHeight(Pose p_35297_, EntityDimensions p_35298_) {
        return 1.65125F;
    }
    @Override
    protected void updateTrades() {
        MerchantOffers merchantoffers = this.getOffers();

        DivineTrades[] tradetrades = new DivineTrades[]{
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake.get(), 6), new ItemStack(ItemRegistry.seng_fur_helmet.get(), 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake.get(), 6), new ItemStack(ItemRegistry.seng_fur_chestplate.get(), 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake.get(), 6), new ItemStack(ItemRegistry.seng_fur_leggings.get(), 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake.get(), 6), new ItemStack(ItemRegistry.seng_fur_boots.get(), 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.ice_stone.get(), 3), new ItemStack(ItemRegistry.egg_nog.get(), 2), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.ice_stone.get(), 3), new ItemStack(ItemRegistry.chocolate_log.get(), 5), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.ice_stone.get(), 3), new ItemStack(ItemRegistry.peppermints.get(), 15), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.ice_stone.get(), 3), new ItemStack(ItemRegistry.fruit_cake.get(), 3), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake.get(), 20), new ItemStack(ItemRegistry.icicle_bane.get(), 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.ice_stone.get(), 3), new ItemStack(BlockRegistry.greenFairyLights.get(), 16), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.ice_stone.get(), 3), new ItemStack(BlockRegistry.redFairyLights.get(), 16), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.ice_stone.get(), 3), new ItemStack(BlockRegistry.blueFairyLights.get(), 16), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.ice_stone.get(), 3), new ItemStack(BlockRegistry.yellowFairyLights.get(), 16), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.ice_stone.get(), 3), new ItemStack(BlockRegistry.purpleFairyLights.get(), 16), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.ice_stone.get(), 9), new ItemStack(BlockRegistry.presentBox.get(), 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.ice_stone.get(), 3), new ItemStack(BlockRegistry.blueCandyCane.get(), 4), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.ice_stone.get(), 3), new ItemStack(BlockRegistry.greenCandyCane.get(), 4), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.ice_stone.get(), 3), new ItemStack(BlockRegistry.pinkCandyCane.get(), 4), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.ice_stone.get(), 3), new ItemStack(BlockRegistry.redCandyCane.get(), 4), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.ice_stone.get(), 3), new ItemStack(BlockRegistry.yellowCandyCane.get(), 4), random.nextInt(7), 5)
        };
        this.addOffersFromItemListings(merchantoffers, tradetrades, 5);
    }
}
