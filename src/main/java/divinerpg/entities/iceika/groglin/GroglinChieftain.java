package divinerpg.entities.iceika.groglin;

import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.registries.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.saveddata.maps.MapDecorationTypes;

public class GroglinChieftain extends Groglin {
	public GroglinChieftain(EntityType<? extends Groglin> type, Level worldIn) {
		super(type, worldIn);
		entityData.set(ITEM, 9);
		important = true;
	}
	@Override protected void updateTrades() {
		MerchantOffers merchantoffers = getOffers();
		DivineTrades[] tradetrades = new DivineTrades[]{
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 5), new ItemStack(BlockRegistry.frostPumpkin.get()), random.nextInt(7), 3),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 25), new ItemStack(ItemRegistry.seng_fur.get()), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 7), PotionContents.createItemStack(Items.POTION, PotionRegistry.GROG), random.nextInt(7), 2),
                new EntityDivineMerchant.DivineMapTrades(new ItemStack(ItemRegistry.olivine.get(), 20), new ItemStack(ItemRegistry.raw_wolpertinger_meat.get(), 5), "filled_map.groglin_raid_target", RAID_TARGETS, MapDecorationTypes.TARGET_X.value(), 15),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 1), new ItemStack(ItemRegistry.ice_stone.get(), 2), random.nextInt(7), 1),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 10), new ItemStack(ItemRegistry.raw_wolpertinger_meat.get(), 2), new ItemStack(ItemRegistry.sabear_sabre.get()), random.nextInt(7), 8)
        };
        addOffersFromItemListings(merchantoffers, tradetrades, 3);
	}
}