package divinerpg.blocks.base;

import net.minecraft.block.*;
import net.minecraft.particles.IParticleData;
public class BlockModWallTorch extends WallTorchBlock {

    public BlockModWallTorch(String name, IParticleData particleData) {
        super(AbstractBlock.Properties.copy(Blocks.WALL_TORCH), particleData);
        setRegistryName(name);
    }
}
