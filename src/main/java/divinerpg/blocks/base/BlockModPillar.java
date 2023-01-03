package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.*;

public class BlockModPillar extends RotatedPillarBlock {
    public BlockModPillar(Material material, float hardness, float resistance, SoundType sound) {
        super(Block.Properties.of(material, material.getColor()).requiresCorrectToolForDrops().strength(hardness, resistance).sound(sound));
    }
}
