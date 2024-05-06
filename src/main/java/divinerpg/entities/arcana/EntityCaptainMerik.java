package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.registries.ItemRegistry;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;

public class EntityCaptainMerik extends EntityDivineMerchant {
	public EntityCaptainMerik(EntityType<? extends EntityDivineMerchant> type, Level worldIn) {super(type, worldIn);}
	@Override public String[] getChatMessages() {
		return new String[] {
				"message.merik.battles",
				"message.merik.datticon",
				"message.merik.hurry",
				"message.merik.phoenix",
				"message.merik.sword"
		};
	}
	@Override protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {return 1.75F;}
	@Override protected void updateTrades() {
		MerchantOffers offers = this.getOffers();
		DivineTrades[] trades = new DivineTrades[]{
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 1), new ItemStack(ItemRegistry.grenade.get(), 10), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 10), new ItemStack(ItemRegistry.korma_chestplate.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 10), new ItemStack(ItemRegistry.korma_leggings.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 12), new ItemStack(ItemRegistry.ender_scepter.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 12), new ItemStack(ItemRegistry.firefly.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 20), new ItemStack(ItemRegistry.captains_sparkler.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 20), new ItemStack(ItemRegistry.ghostbane.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 5), new ItemStack(ItemRegistry.storm_sword.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 6), new ItemStack(ItemRegistry.korma_boots.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 6), new ItemStack(ItemRegistry.korma_helmet.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 6), new ItemStack(ItemRegistry.la_vekor.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 8), new ItemStack(ItemRegistry.arcanium_saber.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 8), new ItemStack(ItemRegistry.shadow_saber.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dungeon_tokens.get(), 15), new ItemStack(ItemRegistry.meriks_missile.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dungeon_tokens.get(), 30), new ItemStack(ItemRegistry.livicia_sword.get(), 1), random.nextInt(7), 5)
		}; this.addOffersFromItemListings(offers, trades, 5);
	}
}