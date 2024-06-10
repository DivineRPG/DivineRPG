package divinerpg.entities.iceika.gruzzorlug;

import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.registries.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.saveddata.maps.MapDecoration.Type;

public class GruzzorlugGeneral extends Gruzzorlug {
	public GruzzorlugGeneral(EntityType<? extends Gruzzorlug> type, Level worldIn) {
		super(type, worldIn);
		entityData.set(ITEM, 6);
		important = true;
	}
	@Override
	protected void updateTrades() {
		MerchantOffers merchantoffers = this.getOffers();
		DivineTrades[] tradetrades = new DivineTrades[]{
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 12), new ItemStack(BlockRegistry.workshopBookcase.get(), 3), random.nextInt(7), 3),
                new EntityDivineMerchant.DivineMapTrades(new ItemStack(ItemRegistry.olivine.get(), 20), new ItemStack(ItemRegistry.raw_wolpertinger_meat.get(), 5), "filled_map.gruzzorlug_raid_target", RAID_TARGETS, Type.TARGET_X, 15),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.oxdrite_ingot.get(), 8), new ItemStack(ItemRegistry.olivine.get(), 2), random.nextInt(7), 1),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.anthracite.get(), 16), new ItemStack(ItemRegistry.olivine.get(), 2), random.nextInt(7), 1),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 6), new ItemStack(ItemRegistry.ice_stone.get(), 12), random.nextInt(7), 1)
        };
        this.addOffersFromItemListings(merchantoffers, tradetrades, 3);
	}
}