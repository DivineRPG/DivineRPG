package divinerpg.blocks.base;

import net.minecraft.block.*;
import net.minecraft.particles.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraftforge.api.distmarker.*;

import java.util.*;

public class BlockModTorch extends TorchBlock {

    public BlockModTorch(String name, IParticleData particleData) {
        super(Properties.copy(Blocks.TORCH), particleData);
        setRegistryName(name);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState state, World world, BlockPos pos, Random rand) {
        double d0 = (double)pos.getX() + rand.nextDouble() * 0.5D + 0.2D;
        double d1 = (double)pos.getY() + rand.nextDouble() * 0.7D + 0.2D;
        double d2 = (double)pos.getZ() + rand.nextDouble() * 0.5D + 0.2D;

        world.addParticle(flameParticle, d0, d1, d2, 0.0D, 0.0D, 0.0D);
    }
}