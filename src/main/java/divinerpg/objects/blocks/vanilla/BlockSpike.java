package divinerpg.objects.blocks.vanilla;

import divinerpg.objects.blocks.BlockMod;
import divinerpg.utils.Utils;
import divinerpg.utils.material.EnumBlockType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockSpike extends BlockMod {
    public BlockSpike(String name) {
        super(EnumBlockType.ROCK, name, 3);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        float f = 0.0625F;
        return new AxisAlignedBB(x + f, y, z + f, x + 1 - f, y + 1 - f, z + 1 - f);
    }

    @Override
    public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {
        if (entity instanceof EntityLivingBase)
            entity.attackEntityFrom(Utils.spikeSource, 5);
    }
}