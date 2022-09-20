package divinerpg.blocks.base;

import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.particles.IParticleData;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.*;

import java.util.Random;

public class BlockModWallTorch extends WallTorchBlock {

    public BlockModWallTorch(String name, IParticleData particleData) {
        super(Properties.copy(Blocks.WALL_TORCH), particleData);
        setRegistryName(name);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState state, World world, BlockPos pos, Random rand) {
        Direction direction = state.getValue(FACING);
        double dx = (double)pos.getX() + 0.5D;
        double dy = (double)pos.getY() + 0.7D;
        double dz = (double)pos.getZ() + 0.5D;
        double d0 = 0.22D;
        double d1 = 0.27D;
        Direction opposite = direction.getOpposite();
        if (this == BlockRegistry.aquaWallTorch) {
            world.addParticle(ParticleRegistry.BLUE_FLAME.get(), dx + d1 * (double)opposite.getStepX(), dy + d0, dz + d1 * (double)opposite.getStepZ(), 0.0D, 0.0D, 0.0D);
        }
        else if (this == BlockRegistry.skeletonWallTorch) {
            world.addParticle(ParticleRegistry.BLACK_FLAME.get(), dx + d1 * (double)opposite.getStepX(), dy + d0, dz + d1 * (double)opposite.getStepZ(), 0.0D, 0.0D, 0.0D);
        }
        else if (this == BlockRegistry.arcaniumWallTorch) {
            world.addParticle(ParticleRegistry.GREEN_FLAME.get(), dx + d1 * (double)opposite.getStepX(), dy + d0, dz + d1 * (double)opposite.getStepZ(), 0.0D, 0.0D, 0.0D);
        }
        else if (this == BlockRegistry.edenWallTorch) {
            world.addParticle(ParticleRegistry.PURPLE_FLAME.get(), dx + d1 * (double)opposite.getStepX(), dy + d0, dz + d1 * (double)opposite.getStepZ(), 0.0D, 0.0D, 0.0D);
        } else {
            world.addParticle(flameParticle, dx + d1 * (double)opposite.getStepX(), dy + d0, dz + d1 * (double)opposite.getStepZ(), 0.0D, 0.0D, 0.0D);
        }
    }
}