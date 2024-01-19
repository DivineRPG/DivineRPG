package divinerpg.blocks.base;

import divinerpg.DivineRPG;
import divinerpg.registries.ParticleRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.*;

public class BlockModTorch extends TorchBlock {

    public BlockModTorch(SimpleParticleType particleData) {
        super(particleData, Properties.ofFullCopy(Blocks.TORCH));
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource rand) {
        double d0 = (double) pos.getX() + rand.nextDouble() * 0.5D + 0.2D;
        double d1 = (double) pos.getY() + rand.nextDouble() * 0.7D + 0.2D;
        double d2 = (double) pos.getZ() + rand.nextDouble() * 0.5D + 0.2D;
        if (this == BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "aqua_torch"))) {
            world.addParticle(ParticleRegistry.BLUE_FLAME.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        }
        else if (this == BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "skeleton_torch"))) {
            world.addParticle(ParticleRegistry.BLACK_FLAME.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        }
        else if (this == BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "arcanium_torch"))) {
            world.addParticle(ParticleRegistry.GREEN_FLAME.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        }
        else if (this == BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "eden_torch"))) {
            world.addParticle(ParticleRegistry.PURPLE_FLAME.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        } else {
            world.addParticle(flameParticle, d0, d1, d2, 0.0D, 0.0D, 0.0D);
        }
    }
}