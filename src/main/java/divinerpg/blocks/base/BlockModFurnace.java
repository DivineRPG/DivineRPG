package divinerpg.blocks.base;

import divinerpg.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.particles.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraftforge.api.distmarker.*;

import java.util.*;

public abstract class BlockModFurnace extends AbstractFurnaceBlock {

    public BlockModFurnace(String name) {
        super(Block.Properties.of(Material.STONE, MaterialColor.STONE));
        setRegistryName(DivineRPG.MODID, name);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(LIT, Boolean.valueOf(false)));
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState p_180655_1_, World p_180655_2_, BlockPos p_180655_3_, Random p_180655_4_) {
        if (p_180655_1_.getValue(LIT)) {
            double d0 = (double)p_180655_3_.getX() + 0.5D;
            double d1 = (double)p_180655_3_.getY();
            double d2 = (double)p_180655_3_.getZ() + 0.5D;
            if (p_180655_4_.nextDouble() < 0.1D) {
                p_180655_2_.playLocalSound(d0, d1, d2, SoundEvents.FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
            }

            Direction direction = p_180655_1_.getValue(FACING);
            Direction.Axis direction$axis = direction.getAxis();
            double d3 = 0.52D;
            double d4 = p_180655_4_.nextDouble() * 0.6D - 0.3D;
            double d5 = direction$axis == Direction.Axis.X ? (double)direction.getStepX() * 0.52D : d4;
            double d6 = p_180655_4_.nextDouble() * 6.0D / 16.0D;
            double d7 = direction$axis == Direction.Axis.Z ? (double)direction.getStepZ() * 0.52D : d4;
            p_180655_2_.addParticle(ParticleTypes.SMOKE, d0 + d5, d1 + d6, d2 + d7, 0.0D, 0.0D, 0.0D);
            p_180655_2_.addParticle(ParticleTypes.FLAME, d0 + d5, d1 + d6, d2 + d7, 0.0D, 0.0D, 0.0D);
        }
    }

}