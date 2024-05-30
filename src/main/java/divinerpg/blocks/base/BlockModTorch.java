package divinerpg.blocks.base;

import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.*;

public class BlockModTorch extends TorchBlock {
    //TODO: I don't know why it refuses to work when I insert the needed particle into the constructor directly
    public BlockModTorch() {super(Properties.copy(Blocks.TORCH), ParticleTypes.FLAME);}
    @OnlyIn(Dist.CLIENT)
    @Override public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        double d0 = pos.getX() + .5;
        double d1 = pos.getY() + .7;
        double d2 = pos.getZ() + .5;
        level.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0, 0, 0);
        if(this == BlockRegistry.arcaniumTorch.get()) level.addParticle(ParticleRegistry.PURPLE_FLAME.get(), d0, d1, d2, 0, 0, 0);
        if(this == BlockRegistry.edenTorch.get()) level.addParticle(ParticleRegistry.GREEN_FLAME.get(), d0, d1, d2, 0, 0, 0);
    }
}