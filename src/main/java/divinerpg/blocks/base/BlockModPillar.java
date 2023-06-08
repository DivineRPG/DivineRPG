package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.*;

public class BlockModPillar extends RotatedPillarBlock {
    public BlockModPillar(MapColor color, float hardness, float resistance, SoundType sound) {
        super(Block.Properties.of().mapColor(color).requiresCorrectToolForDrops().strength(hardness, resistance).sound(sound));
    }
}