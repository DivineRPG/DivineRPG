package divinerpg.block_entities.block;

import divinerpg.entities.vanilla.overworld.EntityKobblin;
import divinerpg.registries.*;
import divinerpg.util.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

public class KobblinBurrowBlockEntity extends BlockEntity {
    int tickCount = 0;
    public KobblinBurrowBlockEntity(BlockPos pos, BlockState blockState) {
        super(BlockEntityRegistry.KOBBLIN_BURROW.get(), pos, blockState);
    }
    public static void serverTick(Level level, BlockPos pos, BlockState state, KobblinBurrowBlockEntity entity) {
        entity.tickCount++;
        if((entity.tickCount & 3) == 0 && level.getDifficulty() != Difficulty.PEACEFUL && level instanceof ServerLevel s) {
            Player p = level.getNearestPlayer(pos.getX(), pos.getY(), pos.getZ(), 4, false);
            if(p != null && level.getEntitiesOfClass(EntityKobblin.class, new AABB(pos).inflate(16)).isEmpty()) {
                var type = EntityRegistry.KOBBLIN.get();
                Utils.summonEntityAt(s, type, pos.offset(3, 0, 0), null);
                Utils.summonEntityAt(s, type, pos.offset(1, 0, 2), null);
                Utils.summonEntityAt(s, type, pos.offset(-1, 0, 2), null);
                Utils.summonEntityAt(s, type, pos.offset(-3, 0, 0), null);
                Utils.summonEntityAt(s, type, pos.offset(1, 0, -2), null);
                Utils.summonEntityAt(s, type, pos.offset(-1, 0, -2), null);
            }
        }
    }
}