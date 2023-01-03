package divinerpg.blocks.base;

import divinerpg.DivineRPG;
import divinerpg.registries.ParticleRegistry;
import net.minecraft.core.*;
import net.minecraft.core.particles.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockModWallTorch extends WallTorchBlock {

    public BlockModWallTorch(ParticleOptions particleData) {
        super(Properties.copy(Blocks.WALL_TORCH), particleData);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource rand) {
        Direction direction = state.getValue(FACING);
        double dx = (double)pos.getX() + 0.5D;
        double dy = (double)pos.getY() + 0.7D;
        double dz = (double)pos.getZ() + 0.5D;
        double d0 = 0.22D;
        double d1 = 0.27D;
        Direction opposite = direction.getOpposite();
        if (this == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "aqua_wall_torch"))) {
            world.addParticle(ParticleRegistry.BLUE_FLAME.get(), dx + d1 * (double)opposite.getStepX(), dy + d0, dz + d1 * (double)opposite.getStepZ(), 0.0D, 0.0D, 0.0D);
        }
        else if (this == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "skeleton_wall_torch"))) {
            world.addParticle(ParticleRegistry.BLACK_FLAME.get(), dx + d1 * (double)opposite.getStepX(), dy + d0, dz + d1 * (double)opposite.getStepZ(), 0.0D, 0.0D, 0.0D);
        }
        else if (this == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcanium_wall_torch"))) {
            world.addParticle(ParticleRegistry.GREEN_FLAME.get(), dx + d1 * (double)opposite.getStepX(), dy + d0, dz + d1 * (double)opposite.getStepZ(), 0.0D, 0.0D, 0.0D);
        }
        else if (this == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_wall_torch"))) {
            world.addParticle(ParticleRegistry.PURPLE_FLAME.get(), dx + d1 * (double)opposite.getStepX(), dy + d0, dz + d1 * (double)opposite.getStepZ(), 0.0D, 0.0D, 0.0D);
        } else {
            world.addParticle(flameParticle, dx + d1 * (double)opposite.getStepX(), dy + d0, dz + d1 * (double)opposite.getStepZ(), 0.0D, 0.0D, 0.0D);
        }
    }
}