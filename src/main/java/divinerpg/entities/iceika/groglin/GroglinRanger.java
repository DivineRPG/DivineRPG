package divinerpg.entities.iceika.groglin;

import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.registries.BlockRegistry;
import divinerpg.registries.ItemRegistry;
import divinerpg.registries.PotionRegistry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;

public class GroglinRanger extends Groglin {
	public GroglinRanger(EntityType<? extends Groglin> type, Level worldIn) {
		super(type, worldIn);
		entityData.set(ITEM, 11);
	}
	@Override
	protected void updateTrades() {
		MerchantOffers merchantoffers = this.getOffers();
        DivineTrades[] tradetrades = new DivineTrades[]{
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 3), new ItemStack(BlockRegistry.glaconPumpkin.get(), 2), random.nextInt(7), 1),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 5), new ItemStack(ItemRegistry.robbin_egg.get()), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(PotionUtils.setPotion(new ItemStack(Items.POTION), PotionRegistry.GROG.get()), new ItemStack(ItemRegistry.olivine.get()), random.nextInt(7), 1),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.raw_wolpertinger_meat.get(), 10), new ItemStack(ItemRegistry.olivine.get()), random.nextInt(7), 1),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 1), new ItemStack(ItemRegistry.ice_stone.get(), 2), random.nextInt(7), 1)
        };
        this.addOffersFromItemListings(merchantoffers, tradetrades, 3);
	}
}