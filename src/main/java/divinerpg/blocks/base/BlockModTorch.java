package divinerpg.blocks.base;

import net.minecraft.block.*;
import net.minecraft.particles.IParticleData;

public class BlockModTorch extends TorchBlock {
    public BlockModTorch(String name, IParticleData particleData) {
        super(Properties.from(Blocks.TORCH), particleData);
        setRegistryName(name);
    }
}
