package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.registries.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Blocks;

public class EntityLordVatticus extends EntityDivineMerchant {

	public EntityLordVatticus(EntityType<? extends EntityDivineMerchant> type, Level worldIn) {
		super(type, worldIn);
	}

	public String[] getChatMessages() {
		return new String[] {
				"message.vatticus.discover",
				"message.vatticus.feel",
				"message.vatticus.magic",
				"message.vatticus.noend",
				"message.vatticus.strength"
		};
	}
	@Override
	protected void updateTrades() {
		MerchantOffers merchantoffers = this.getOffers();

		DivineTrades[] tradetrades = new DivineTrades[]{
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector.get(), 1), new ItemStack(Items.BLUE_DYE, 8), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector.get(), 2), new ItemStack(Items.EXPERIENCE_BOTTLE, 12), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector.get(), 2), new ItemStack(BlockRegistry.soulSludgeBreakable.get(), 8), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector.get(), 2), new ItemStack(ItemRegistry.weak_arcana_potion.get(), 2), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector.get(), 4), new ItemStack(ItemRegistry.strong_arcana_potion.get(), 2), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector.get(), 1), new ItemStack(Items.BLAZE_ROD, 2), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 2), new ItemStack(BlockRegistry.arcaniteMoss.get(), 8), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 2), new ItemStack(ItemRegistry.wizards_book.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector.get(), 3), new ItemStack(Blocks.ENCHANTING_TABLE, 1), random.nextInt(7), 5)
		};
		this.addOffersFromItemListings(merchantoffers, tradetrades, 5);
	}
}