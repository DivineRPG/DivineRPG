package divinerpg.compat.supplementaries;

import net.mehvahdjukaar.supplementaries.common.block.blocks.SusGravelBricksBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import static divinerpg.registries.BlockRegistry.frozenGravelBricks;

public class SuspiciousFrozenGravelBricks extends SusGravelBricksBlock {
    public SuspiciousFrozenGravelBricks() {super(Properties.ofFullCopy(frozenGravelBricks.get()));}
    @Override public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {return new SuspiciousFrozenGravelBricksTile(pos, state);}
}