package divinerpg.entities.arcana;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.world.*;

public class EntityKazari extends EntityDivineMerchant {

	public EntityKazari(EntityType<? extends EntityDivineMerchant> type, World worldIn) {
        super(type, worldIn);
    }

	public String[] getChatMessages() {
        return new String[] {
        		"message.kazari.1",
                "message.kazari.2",
                "message.kazari.3",
                "message.kazari.4",
                "message.kazari.5",
                "message.kazari.6",
                "message.kazari.7",
                "message.kazari.8"
        };
    }

	@Override
	protected void updateTrades() {
		MerchantOffers merchantoffers = this.getOffers();

		DivineTrades[] tradetrades = new DivineTrades[]{
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector, 3), new ItemStack(ItemRegistry.ancientKey, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector, 3), new ItemStack(ItemRegistry.degradedKey, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector, 3), new ItemStack(ItemRegistry.soulKey, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector, 3), new ItemStack(ItemRegistry.sludgeKey, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector, 2), new ItemStack(BlockRegistry.ancientBricksBreakable, 16), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector, 2), new ItemStack(BlockRegistry.ancientStoneBreakable, 16), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector, 2), new ItemStack(BlockRegistry.ancientTileBreakable, 16), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector, 2), new ItemStack(BlockRegistry.arcaniumMetalBreakable, 16), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector, 2), new ItemStack(BlockRegistry.arcaniumPowerBreakable, 4), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector, 2), new ItemStack(BlockRegistry.degradedBricksBreakable, 16), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector, 2), new ItemStack(BlockRegistry.dungeonLampBreakable, 4), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector, 2), new ItemStack(BlockRegistry.soulSludgeBreakable, 16), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector, 2), new ItemStack(BlockRegistry.soulStoneBreakable, 16), random.nextInt(7), 5)
		};
		this.addOffersFromItemListings(merchantoffers, tradetrades, 5);
		super.updateTrades();
	}
}
