package divinerpg.compat.supplementaries;

import net.mehvahdjukaar.supplementaries.common.block.blocks.GravelBricksBlock;

import static divinerpg.registries.BlockRegistry.frozenGravel;
import static net.minecraft.world.level.block.SoundType.STONE;

public class FrozenGravelBricks extends GravelBricksBlock {
    public FrozenGravelBricks() {super(Properties.ofFullCopy(frozenGravel.get()).sound(STONE));}
}