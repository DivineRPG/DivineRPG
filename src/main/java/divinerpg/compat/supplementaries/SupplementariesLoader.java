package divinerpg.compat.supplementaries;

import net.mehvahdjukaar.supplementaries.configs.CommonConfigs;
import net.minecraft.core.*;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;

public class SupplementariesLoader {
    public static BlockState getConnectedState(BlockState blockstate, LevelAccessor world, BlockPos pos, Direction front) {return RakedFrozenGravel.getConnectedState(blockstate, world, pos, front);}
    public static boolean rakedGravelTillingEnabled() {return CommonConfigs.Tweaks.RAKED_GRAVEL.get();}
    public static boolean rakedGravelEnabled() {return CommonConfigs.Building.RAKED_GRAVEL_ENABLED.get();}
    public static boolean gravelBricksEnabled() {return CommonConfigs.Building.GRAVEL_BRICKS_ENABLED.get();}
}