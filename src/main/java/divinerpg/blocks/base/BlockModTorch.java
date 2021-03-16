package divinerpg.blocks.base;

import net.minecraft.block.*;
import net.minecraft.particles.IParticleData;

import net.minecraft.block.AbstractBlock.Properties;

public class BlockModTorch extends TorchBlock {
    public BlockModTorch(String name, IParticleData particleData) {
        super(Properties.copy(Blocks.TORCH), particleData);
        setRegistryName(name);
    }
}
