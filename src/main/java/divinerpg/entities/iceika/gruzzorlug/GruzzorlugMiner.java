package divinerpg.entities.iceika.gruzzorlug;

import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.registries.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;

public class GruzzorlugMiner extends Gruzzorlug {
	public GruzzorlugMiner(EntityType<? extends Gruzzorlug> type, Level worldIn) {
		super(type, worldIn);
		entityData.set(ITEM, 1);
	}
	@Override
	protected void updateTrades() {
		MerchantOffers merchantoffers = this.getOffers();
        DivineTrades[] tradetrades = new DivineTrades[]{
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.oxdrite_pickaxe.get(), 8), new ItemStack(ItemRegistry.olivine.get(), 2), random.nextInt(7), 2),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 7), new ItemStack(BlockRegistry.brittleMoss.get()), random.nextInt(7), 2),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 12), new ItemStack(BlockRegistry.cobaltite.get(), 10), random.nextInt(7), 2),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 8), new ItemStack(ItemRegistry.raw_oxdrite.get(), 2), random.nextInt(7), 1),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 4), new ItemStack(ItemRegistry.anthracite.get(), 2), random.nextInt(7), 1)
        };
        addOffersFromItemListings(merchantoffers, tradetrades, 3);
	}
}