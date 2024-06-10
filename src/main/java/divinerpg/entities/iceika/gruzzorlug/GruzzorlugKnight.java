package divinerpg.entities.iceika.gruzzorlug;

import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.registries.ItemRegistry;
import divinerpg.registries.PotionRegistry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;

public class GruzzorlugKnight extends Gruzzorlug {
	public GruzzorlugKnight(EntityType<? extends Gruzzorlug> type, Level worldIn) {
		super(type, worldIn);
		entityData.set(ITEM, 4);
	}
	@Override
	protected void updateTrades() {
		MerchantOffers merchantoffers = this.getOffers();
        DivineTrades[] tradetrades = new DivineTrades[]{
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 8), new ItemStack(ItemRegistry.winterberry.get()), random.nextInt(7), 1),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 4), PotionUtils.setPotion(new ItemStack(Items.POTION), PotionRegistry.TEA.get()), random.nextInt(7), 1),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 14), new ItemStack(ItemRegistry.raw_wolpertinger_meat.get()), new ItemStack(ItemRegistry.sabear_tooth.get()), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 10), new ItemStack(ItemRegistry.raw_wolpertinger_meat.get()), new ItemStack(ItemRegistry.sabear_fur.get()), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 1), new ItemStack(ItemRegistry.ice_stone.get(), 3), random.nextInt(7), 1)
        };
        addOffersFromItemListings(merchantoffers, tradetrades, 3);
	}
}