package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.registries.ItemRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.*;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class EntityCaptainMerik extends EntityDivineMerchant {

	public EntityCaptainMerik(EntityType<? extends EntityDivineMerchant> type, Level worldIn) {
		super(type, worldIn);
	}

	public String[] getChatMessages() {
		return new String[] {
				"message.merik.battles",
				"message.merik.datticon",
				"message.merik.hurry",
				"message.merik.phoenix",
				"message.merik.sword"
		};
	}

	@Override
	protected void updateTrades() {
		MerchantOffers merchantoffers = this.getOffers();

		DivineTrades[] tradetrades = new DivineTrades[]{
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 5), new ItemStack(ItemRegistry.storm_sword.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 20), new ItemStack(ItemRegistry.ghostbane.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 8), new ItemStack(ItemRegistry.shadow_saber.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 8), new ItemStack(ItemRegistry.arcanium_saber.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 20), new ItemStack(ItemRegistry.captains_sparkler.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 12), new ItemStack(ItemRegistry.firefly.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dungeon_tokens.get(), 15), new ItemStack(ItemRegistry.meriks_missile.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dungeon_tokens.get(), 30), new ItemStack(ItemRegistry.livicia_sword.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 6), new ItemStack(ItemRegistry.la_vekor.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 1), new ItemStack(ItemRegistry.grenade.get(), 10), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 8), new ItemStack(ItemRegistry.korma_helmet.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 8), new ItemStack(ItemRegistry.korma_chestplate.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 8), new ItemStack(ItemRegistry.korma_leggings.get(), 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium.get(), 8), new ItemStack(ItemRegistry.korma_boots.get(), 1), random.nextInt(7), 5)
		};
		this.addOffersFromItemListings(merchantoffers, tradetrades, 5);
	}

	public static boolean rules(EntityType<? extends Mob> type, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
		BlockPos blockpos = pos.below();
		List<EntityCaptainMerik> entityList = level.getEntitiesOfClass(EntityCaptainMerik.class, new AABB(pos).inflate(16));
		return spawnType == MobSpawnType.SPAWNER || level.getBlockState(blockpos).isValidSpawn(level, blockpos, type) && entityList.isEmpty();
	}
}
