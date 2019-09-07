package divinerpg.objects.blocks.vanilla;

import divinerpg.utils.Utils;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockHotSpike extends BlockSpike {

    public BlockHotSpike(String name) {
        super(name);
    }

    @Override
    public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {
        if (entity instanceof EntityLivingBase) {
            entity.attackEntityFrom(Utils.spikeSource, 8);
            entity.setFire(10);
        }
    }
}
