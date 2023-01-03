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

public class EntityKazari extends EntityDivineMerchant {

	public EntityKazari(EntityType<? extends EntityDivineMerchant> type, Level worldIn) {
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
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector.get(), 3), new ItemStack(ItemRegistry.ancient_key.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector.get(), 3), new ItemStack(ItemRegistry.degraded_key.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector.get(), 3), new ItemStack(ItemRegistry.soul_key.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector.get(), 3), new ItemStack(ItemRegistry.sludge_key.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector.get(), 2), new ItemStack(BlockRegistry.ancientBricksBreakable.get(), 16), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector.get(), 2), new ItemStack(BlockRegistry.ancientStoneBreakable.get(), 16), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector.get(), 2), new ItemStack(BlockRegistry.ancientTileBreakable.get(), 16), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector.get(), 2), new ItemStack(BlockRegistry.arcaniumMetalBreakable.get(), 16), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector.get(), 2), new ItemStack(BlockRegistry.arcaniumPowerBreakable.get(), 4), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector.get(), 2), new ItemStack(BlockRegistry.degradedBricksBreakable.get(), 16), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector.get(), 2), new ItemStack(BlockRegistry.dungeonLampBreakable.get(), 4), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector.get(), 2), new ItemStack(BlockRegistry.soulSludgeBreakable.get(), 16), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector.get(), 2), new ItemStack(BlockRegistry.soulStoneBreakable.get(), 16), random.nextInt(7), 5)
		};
		this.addOffersFromItemListings(merchantoffers, tradetrades, 5);
	}

	public static boolean rules(EntityType<? extends Mob> type, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
		BlockPos blockpos = pos.below();
		List<EntityKazari> entityList = level.getEntitiesOfClass(EntityKazari.class, new AABB(pos).inflate(16));
		return spawnType == MobSpawnType.SPAWNER || level.getBlockState(blockpos).isValidSpawn(level, blockpos, type) && entityList.isEmpty();
	}
}
