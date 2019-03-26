package naturix.divinerpg.objects.blocks.vanilla;

import naturix.divinerpg.objects.blocks.BlockMod;
import naturix.divinerpg.utils.Utils;
import naturix.divinerpg.utils.material.EnumBlockType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockHotSpike extends BlockMod {
    public BlockHotSpike(String name) {
        super(EnumBlockType.ROCK, name, 3);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        float f = 0.0625F;
        return new AxisAlignedBB(x + f, y, z + f, x + 1 - f, y + 1 - f, z + 1 - f);
    }

    @Override
    public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {
        if (entity instanceof EntityLivingBase) {
            entity.attackEntityFrom(Utils.spikeSource, 8);
            entity.setFire(10);
        }
    }
}
