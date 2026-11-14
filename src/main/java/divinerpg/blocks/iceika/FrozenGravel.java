package divinerpg.blocks.iceika;

import net.minecraft.util.ColorRGBA;
import net.minecraft.world.level.block.ColoredFallingBlock;
import net.neoforged.neoforge.common.extensions.IBlockExtension;

public class FrozenGravel extends ColoredFallingBlock implements IBlockExtension {
    public FrozenGravel(Properties p) {super(new ColorRGBA(13561077), p);}
    //TODO: Supplementaries compat
//    @Override public BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
//        if(ModList.get().isLoaded("supplementaries") && SupplementariesLoader.rakedGravelEnabled() && SupplementariesLoader.rakedGravelTillingEnabled() && HOE_TILL == itemAbility) {
//            BlockState raked = NewBlockRegistry.rakedFrozenGravel.get().defaultBlockState();
//            LevelAccessor level = context.getLevel();
//            BlockPos pos = context.getClickedPos();
//            if(raked.canSurvive(level, pos)) return SupplementariesLoader.getConnectedState(raked, level, pos, context.getHorizontalDirection());
//        } return super.getToolModifiedState(state, context, itemAbility, simulate);
//    }
}