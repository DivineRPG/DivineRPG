package divinerpg.blocks.iceika;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.GlowLichenBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.Nullable;

import static net.minecraft.stats.Stats.ITEM_USED;
import static net.neoforged.neoforge.common.ItemAbilities.SHEARS_DIG;

public class SnowyMoss extends GlowLichenBlock {
    public SnowyMoss(Properties p) {super(p);}
    @Override protected float getDestroyProgress(BlockState state, Player player, BlockGetter level, BlockPos pos) {
        float baseProgress = super.getDestroyProgress(state, player, level, pos);
        return player.getMainHandItem().canPerformAction(SHEARS_DIG) ? baseProgress * 2 : baseProgress;
    }
    @Override
    public void playerDestroy(ServerLevel level, ServerPlayer player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack destroyedWith) {
        if(player.getMainHandItem().getItem() instanceof ShearsItem) player.awardStat(ITEM_USED.get(destroyedWith.getItem()));
        super.playerDestroy(level, player, pos, state, blockEntity, destroyedWith);
    }
}