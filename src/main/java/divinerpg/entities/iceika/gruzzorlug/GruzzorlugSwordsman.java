package divinerpg.entities.iceika.gruzzorlug;

import divinerpg.entities.ai.FollowLeaderGoal;
import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.registries.ItemRegistry;
import divinerpg.registries.PotionRegistry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;

public class GruzzorlugSwordsman extends Gruzzorlug {
	public GruzzorlugSwordsman(EntityType<? extends Gruzzorlug> type, Level worldIn) {
		super(type, worldIn);
		entityData.set(ITEM, 5);
	}
	@Override protected void registerGoals() {
		super.registerGoals();
		goalSelector.addGoal(4, new FollowLeaderGoal(this, GruzzorlugGeneral.class, 1, 4, (float)getAttributeValue(Attributes.FOLLOW_RANGE)));
	}
	@Override
	protected void updateTrades() {
		MerchantOffers merchantoffers = this.getOffers();
        DivineTrades[] tradetrades = new DivineTrades[]{
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 16), new ItemStack(ItemRegistry.sabear_tooth.get()), random.nextInt(7), 10),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 18), new ItemStack(ItemRegistry.sabear_fur.get()), random.nextInt(7), 10),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 2), new ItemStack(ItemRegistry.raw_wolpertinger_meat.get(), 4), random.nextInt(7), 1),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 5), PotionUtils.setPotion(new ItemStack(Items.POTION), PotionRegistry.TEA.get()), random.nextInt(7), 1),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 1), new ItemStack(ItemRegistry.ice_stone.get(), 4), random.nextInt(7), 1)
        };
        addOffersFromItemListings(merchantoffers, tradetrades, 3);
	}
}