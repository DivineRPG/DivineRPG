package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.registries.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.*;

public class EntityLeorna extends EntityDivineMerchant {

	public EntityLeorna(EntityType<? extends EntityDivineMerchant> type, Level worldIn) {
		super(type, worldIn, ProfessionRegistry.LEORNA.get());
	}

	public String[] getChatMessages() {
		return new String[] {
				"message.leorna.hitchak",
				"message.leorna.lamona",
				"message.leorna.nature",
				"message.leorna.plants",
				"message.leorna.zelus"
		};
	}

	@Override
	protected void updateTrades() {
		MerchantOffers merchantoffers = this.getOffers();

		DivineTrades[] tradetrades = new DivineTrades[]{
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 1), new ItemStack(ItemRegistry.eucalyptus_root_seeds.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 2), new ItemStack(ItemRegistry.marsine_seeds.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 2), new ItemStack(ItemRegistry.firestock_seeds.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 3), new ItemStack(ItemRegistry.pinfly_seeds.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 4), new ItemStack(ItemRegistry.aquamarine_seeds.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 5), new ItemStack(ItemRegistry.hitchak_seeds.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 7), new ItemStack(ItemRegistry.veilo_seeds.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 9), new ItemStack(ItemRegistry.lamona_seeds.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector.get(), 2), new ItemStack(BlockRegistry.arcaniteDirt.get(), 16), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector.get(), 2), new ItemStack(BlockRegistry.arcaniteGrass.get(), 16), random.nextInt(7), 5)
		};
		this.addOffersFromItemListings(merchantoffers, tradetrades, 5);
	}
}