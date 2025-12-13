package divinerpg.blocks.iceika;

import divinerpg.compat.supplementaries.SupplementariesLoader;
import net.minecraft.core.BlockPos;
import net.minecraft.util.ColorRGBA;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.ColoredFallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.common.ItemAbility;
import net.neoforged.neoforge.common.extensions.IBlockExtension;

import static divinerpg.registries.BlockRegistry.rakedFrozenGravel;
import static net.minecraft.world.level.block.Blocks.GRAVEL;
import static net.minecraft.world.level.material.MapColor.GLOW_LICHEN;
import static net.neoforged.neoforge.common.ItemAbilities.HOE_TILL;

public class FrozenGravel extends ColoredFallingBlock implements IBlockExtension {
    public FrozenGravel() {super(new ColorRGBA(13561077), Properties.ofFullCopy(GRAVEL).mapColor(GLOW_LICHEN));}
    //Supplementaries compat
    @Override public BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
        if(ModList.get().isLoaded("supplementaries") && SupplementariesLoader.rakedGravelEnabled() && SupplementariesLoader.rakedGravelTillingEnabled() && HOE_TILL == itemAbility) {
            BlockState raked = rakedFrozenGravel.get().defaultBlockState();
            LevelAccessor level = context.getLevel();
            BlockPos pos = context.getClickedPos();
            if(raked.canSurvive(level, pos)) return SupplementariesLoader.getConnectedState(raked, level, pos, context.getHorizontalDirection());
        } return super.getToolModifiedState(state, context, itemAbility, simulate);
    }
}