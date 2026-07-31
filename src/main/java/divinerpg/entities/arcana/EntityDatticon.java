package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineMerchant;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.AABB;

import java.util.List;

import static divinerpg.registries.RecipeRegistry.Trades.DATTICON;
import static net.minecraft.world.entity.EntitySpawnReason.SPAWNER;

public class EntityDatticon extends EntityDivineMerchant {
    public EntityDatticon(EntityType<? extends EntityDatticon> type, Level worldIn) {super(type, worldIn, "datticon");}
    @Override public String[] getChatMessages() {
        return new String[] {
                "message.datticon.merik",
                "message.datticon.furnace",
                "message.datticon.science",
                "message.datticon.plugged",
                "message.datticon.redstone"
        };
    }
    @Override protected void updateTrades(ServerLevel level) {addOffersFromTradeSet(getOffers(), DATTICON.get(level(), getRandom()), 5);}
    public static boolean rules(EntityType<? extends EntityDatticon> type, ServerLevelAccessor level, EntitySpawnReason spawnType, BlockPos pos, RandomSource random) {
        BlockPos blockpos = pos.below();
        List<EntityDatticon> entityList = level.getEntitiesOfClass(EntityDatticon.class, new AABB(pos).inflate(16));
        return spawnType == SPAWNER || level.getBlockState(blockpos).isValidSpawn(level, blockpos, type) && entityList.isEmpty();
    }
}