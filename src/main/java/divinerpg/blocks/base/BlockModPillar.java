package divinerpg.blocks.base;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;

public class BlockModPillar extends RotatedPillarBlock {
    public BlockModPillar(String name, Material material, float hardness, float resistance, SoundType sound) {
        super(Block.Properties.of(material, material.getColor()).requiresCorrectToolForDrops().strength(hardness, resistance).sound(sound));
        setRegistryName(name);
    }
}
