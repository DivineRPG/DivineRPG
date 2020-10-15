package TeamDivineRPG.divinerpg.blocks.base;

import net.minecraft.block.Block;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockModPillar extends RotatedPillarBlock {
    public BlockModPillar(String name, Material material, float hardness, float resistance, SoundType sound) {
        super(Block.Properties.create(material, material.getColor()).func_235861_h_().hardnessAndResistance(hardness, resistance).sound(sound));
        setRegistryName(name);
    }
}
