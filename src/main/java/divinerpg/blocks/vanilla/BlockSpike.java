package divinerpg.blocks.vanilla;

import divinerpg.blocks.base.BlockMod;
import divinerpg.util.DamageSources;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.shapes.*;
import net.minecraft.world.*;

public class BlockSpike extends BlockMod {
    private final boolean isHot;

    public BlockSpike(String name, boolean isHot) {
        super(name, 3);
        this.isHot = isHot;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState p_220071_1_, IBlockReader p_220071_2_, BlockPos p_220071_3_, ISelectionContext p_220071_4_) {
        return VoxelShapes.create(new AxisAlignedBB(1.1, 1.1, 1.1, -0.1, -0.1, -0.1));
    }

    @Override
    public void entityInside(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if (isHot) {
            if (entityIn instanceof LivingEntity) {
                entityIn.hurt(DamageSources.spikeSource, 8);
                entityIn.setSecondsOnFire(10);
            }
        } else {
            if (entityIn instanceof LivingEntity) {
                entityIn.hurt(DamageSources.spikeSource, 5);
            }
        }
    }
}
