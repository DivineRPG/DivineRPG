package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.*;
import net.minecraft.world.phys.AABB;
import java.util.List;

public class EntityDatticon extends EntityDivineMerchant {
	public EntityDatticon(EntityType<? extends EntityDivineMerchant> type, Level worldIn) {super(type, worldIn, "datticon");}
	@Override public String[] getChatMessages() {
		return new String[] {
				"message.datticon.merik",
				"message.datticon.furnace",
				"message.datticon.science",
				"message.datticon.plugged",
				"message.datticon.redstone"
		};
	}
	@Override protected void updateTrades() {
		addOffersFromItemListings(getOffers(), RecipeRegistry.Trades.DATTICON.get(level(), getRandom()), 5);
	}
	public static boolean rules(EntityType<? extends Mob> type, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
		BlockPos blockpos = pos.below();
		List<EntityDatticon> entityList = level.getEntitiesOfClass(EntityDatticon.class, new AABB(pos).inflate(16));
		return spawnType == MobSpawnType.SPAWNER || level.getBlockState(blockpos).isValidSpawn(level, blockpos, type) && entityList.isEmpty();
	}
}