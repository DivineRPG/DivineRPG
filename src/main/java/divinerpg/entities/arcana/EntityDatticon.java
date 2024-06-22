package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.*;
import net.minecraft.world.phys.AABB;
import java.util.List;

public class EntityDatticon extends EntityDivineMerchant {
	public EntityDatticon(EntityType<? extends EntityDivineMerchant> type, Level worldIn) {super(type, worldIn);}
	@Override public String[] getChatMessages() {
		return new String[] {
				"message.datticon.merik",
				"message.datticon.furnace",
				"message.datticon.science",
				"message.datticon.plugged",
				"message.datticon.redstone"
		};
	}
	@Override protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {return 1.875F;}
	@Override protected void updateTrades() {
		MerchantOffers merchantoffers = getOffers();
		DivineTrades[] trades = new DivineTrades[]{
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 8), new ItemStack(BlockRegistry.starBridge.get(), 16), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 8), new ItemStack(BlockRegistry.slimeLight.get(), 16), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector.get(), 2), new ItemStack(BlockRegistry.arcaniteTubes.get(), 16), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector.get(), 2), new ItemStack(BlockRegistry.arcaniteLadder.get(), 16), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 2), new ItemStack(BlockRegistry.moltenFurnace.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 3), new ItemStack(BlockRegistry.greenlightFurnace.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 4), new ItemStack(BlockRegistry.oceanfireFurnace.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 5), new ItemStack(BlockRegistry.moonlightFurnace.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 7), new ItemStack(BlockRegistry.whitefireFurnace.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 9), new ItemStack(BlockRegistry.demonFurnace.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 3), new ItemStack(BlockRegistry.elevantium.get(), 9), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 3), new ItemStack(BlockRegistry.acceleron.get(), 3), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 1), new ItemStack(BlockRegistry.arcaniteLadder.get(), 8), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 6), new ItemStack(ItemRegistry.korma_helmet.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 10), new ItemStack(ItemRegistry.korma_chestplate.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 10), new ItemStack(ItemRegistry.korma_leggings.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 6), new ItemStack(ItemRegistry.korma_boots.get(), 1), random.nextInt(7), 5)
		};
		addOffersFromItemListings(merchantoffers, trades, 5);
	}
	public static boolean rules(EntityType<? extends Mob> type, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
		BlockPos blockpos = pos.below();
		List<EntityDatticon> entityList = level.getEntitiesOfClass(EntityDatticon.class, new AABB(pos).inflate(16));
		return spawnType == MobSpawnType.SPAWNER || level.getBlockState(blockpos).isValidSpawn(level, blockpos, type) && entityList.isEmpty();
	}
}