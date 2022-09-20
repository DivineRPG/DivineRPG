package divinerpg.blocks.base;

import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.particles.IParticleData;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.*;

import java.util.Random;

public class BlockModTorch extends TorchBlock {

    public BlockModTorch(String name, IParticleData particleData) {
        super(Properties.copy(Blocks.TORCH), particleData);
        setRegistryName(name);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState state, World world, BlockPos pos, Random rand) {
        double d0 = (double) pos.getX() + rand.nextDouble() * 0.5D + 0.2D;
        double d1 = (double) pos.getY() + rand.nextDouble() * 0.7D + 0.2D;
        double d2 = (double) pos.getZ() + rand.nextDouble() * 0.5D + 0.2D;
        if (this == BlockRegistry.aquaTorch) {
            world.addParticle(ParticleRegistry.BLUE_FLAME.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        }
        else if (this == BlockRegistry.skeletonTorch) {
            world.addParticle(ParticleRegistry.BLACK_FLAME.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        }
        else if (this == BlockRegistry.arcaniumTorch) {
            world.addParticle(ParticleRegistry.GREEN_FLAME.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        }
        else if (this == BlockRegistry.edenTorch) {
            world.addParticle(ParticleRegistry.PURPLE_FLAME.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        } else {
            world.addParticle(flameParticle, d0, d1, d2, 0.0D, 0.0D, 0.0D);
        }
    }
}