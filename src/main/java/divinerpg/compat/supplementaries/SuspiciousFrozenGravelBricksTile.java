package divinerpg.compat.supplementaries;

import net.mehvahdjukaar.supplementaries.common.block.tiles.SusGravelBricksTile;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import static divinerpg.registries.BlockEntityRegistry.SUSPICIOUS_FROZEN_GRAVEL_BRICKS_TILE;

public class SuspiciousFrozenGravelBricksTile extends SusGravelBricksTile {
    public SuspiciousFrozenGravelBricksTile(BlockPos pos, BlockState blockState) {super(pos, blockState);}
    @Override public BlockEntityType<?> getType() {return SUSPICIOUS_FROZEN_GRAVEL_BRICKS_TILE.get();}
}