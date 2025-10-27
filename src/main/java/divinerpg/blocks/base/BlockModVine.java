package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.*;

import static net.minecraft.stats.Stats.ITEM_USED;
import static net.minecraft.world.level.block.Blocks.VINE;
import static net.neoforged.neoforge.common.ItemAbilities.SHEARS_DIG;

public class BlockModVine extends VineBlock {
    public BlockModVine(MapColor color) {super(Properties.ofFullCopy(VINE).mapColor(color));}
    @Override protected float getDestroyProgress(BlockState state, Player player, BlockGetter level, BlockPos pos) {
        float baseProgress = super.getDestroyProgress(state, player, level, pos);
        return player.getMainHandItem().canPerformAction(SHEARS_DIG) ? baseProgress * 2 : baseProgress;
    }
    @Override public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        if(player.getMainHandItem().canPerformAction(SHEARS_DIG)) player.awardStat(ITEM_USED.get(player.getMainHandItem().getItem()));
        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }
    @Override public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return 100;}
    @Override public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return 15;}
}