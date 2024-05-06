package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.registries.ItemRegistry;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;

public class EntityWarGeneral extends EntityDivineMerchant {
	public EntityWarGeneral(EntityType<? extends EntityDivineMerchant> type, Level worldIn) {super(type, worldIn);}
	@Override public String[] getChatMessages() {
		return new String[] {
				"message.general.blade",
				"message.general.merik",
				"message.general.weapons"
		};
	}
	@Override protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {return 1.74F;}
	@Override protected void updateTrades() {
		MerchantOffers offers = this.getOffers();
		DivineTrades[] trades = new DivineTrades[]{
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 10), new ItemStack(ItemRegistry.vemos_chestplate.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 10), new ItemStack(ItemRegistry.vemos_leggings.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 18), new ItemStack(ItemRegistry.arcanite_blaster.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 18), new ItemStack(ItemRegistry.generals_staff.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 30), new ItemStack(ItemRegistry.arcanite_blade.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 4), new ItemStack(ItemRegistry.starlight.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 6), new ItemStack(ItemRegistry.divine_accumulator.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 6), new ItemStack(ItemRegistry.vemos_boots.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 6), new ItemStack(ItemRegistry.vemos_helmet.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 7), new ItemStack(ItemRegistry.arcanium_attractor.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 7), new ItemStack(ItemRegistry.arcanium_reflector.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dungeon_tokens.get(), 17), new ItemStack(ItemRegistry.meteor_mash.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dungeon_tokens.get(), 20), new ItemStack(ItemRegistry.staff_of_starlight.get(), 1), random.nextInt(7), 5)
		}; this.addOffersFromItemListings(offers, trades, 5);
	}
}