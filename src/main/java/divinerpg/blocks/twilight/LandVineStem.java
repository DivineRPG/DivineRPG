package divinerpg.blocks.twilight;

import divinerpg.registries.BlockRegistry;
import net.minecraft.core.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.*;

import java.util.*;

import static net.minecraft.stats.Stats.ITEM_USED;
import static net.neoforged.neoforge.common.ItemAbilities.SHEARS_DIG;

public class LandVineStem extends Block implements BonemealableBlock {
    public LandVineStem() {super(Properties.ofFullCopy(Blocks.GRASS_BLOCK).mapColor(MapColor.PLANT).sound(SoundType.VINE).ignitedByLava());}
    //TODO: this is not affected by shears' efficiency enchantment level [to do for every plant that has this]
    @Override protected float getDestroyProgress(BlockState state, Player player, BlockGetter level, BlockPos pos) {
        float baseProgress = super.getDestroyProgress(state, player, level, pos);
        return player.getMainHandItem().canPerformAction(SHEARS_DIG) ? baseProgress * 5 : baseProgress;
    }
    @Override public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        if(player.getMainHandItem().getItem() instanceof ShearsItem) player.awardStat(ITEM_USED.get(player.getMainHandItem().getItem()));
        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }
    @Override protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if(level.getGameRules().getBoolean(GameRules.RULE_DO_VINES_SPREAD) && level.isAreaLoaded(pos, 4)) spread(level, pos, random);
    }
    void spread(ServerLevel level, BlockPos pos, RandomSource random) {
        Direction d = Direction.Plane.HORIZONTAL.getRandomDirection(random);
        if(level.getBlockState(pos.relative(d)).isAir()) level.setBlock(pos.relative(d), BlockRegistry.landVine.get().defaultBlockState().setValue(LandVine.byDirection(d.getOpposite()), true), 3);

        int dx = random.nextBoolean() ? 1 : -1, dy = random.nextBoolean() ? 1 : -1, dz = random.nextBoolean() ? 1 : -1;
        for(int x = 0, y, z; Math.abs(x) < 5; x += dx) for(y = 0; Math.abs(y) < 5; y += dy) for(z = Math.abs(x) < 2 && Math.abs(y) < 2 ? 2 * dz : 0; Math.abs(z) < 5; z += dz) if(level.getBlockState(pos.offset(x, y, z)).is(this)) {
            int dist = Math.abs(x) + Math.abs(y) + Math.abs(z);
            int[][] offsets = {{dx, 0, 0}, {0, dy, 0}, {0, 0, dz}, {dx, dy, 0}, {dx, 0, dz}, {0, dy, dz}, {dx, dy, dz}};
            BlockPos p;
            BlockState state;
            ArrayList<BlockPos> candidates = new ArrayList<>();
            for(int[] offset : offsets) if(Math.abs(x - offset[0]) + Math.abs(y - offset[1]) + Math.abs(z - offset[2]) < dist) {
                p = pos.offset(offset[0], offset[1], offset[2]);
                state = level.getBlockState(p);
                if(state.is(this)) return;
                if(state.isAir() || state.is(BlockRegistry.landVine)) candidates.add(p);
            } if(!candidates.isEmpty()) level.setBlock(candidates.get(random.nextInt(candidates.size())), defaultBlockState(), 3);
            return;
        }
    }
    @Override public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState) {return true;}
    @Override public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {return true;}
    @Override public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        spread(serverLevel, blockPos, randomSource);
    }
    @Override public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return 60;}
    @Override public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return 30;}
}