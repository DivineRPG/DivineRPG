package divinerpg.objects.blocks.vanilla;

import java.util.Random;

import divinerpg.objects.blocks.BlockModOre;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockNetheriteOre extends BlockModOre {

    public BlockNetheriteOre(String name, float hardness, float resistance, int harvest) {
        super(name, hardness, resistance, harvest, () -> null);
        setTickRandomly(true);
    }

    public void detectInBB(BlockPos pos, World world) {
        double x = pos.getX();
        double y = pos.getY();
        double z = pos.getZ();
        AxisAlignedBB extendBB = new AxisAlignedBB(x - 0.1, y - 0.1, z - 0.1, x + 1.1, y + 1.1, z + 1.1);
        world.getEntitiesWithinAABB(EntityLivingBase.class, extendBB);
        for (EntityLivingBase entity : world.getEntitiesWithinAABB(EntityLivingBase.class, extendBB)) {
            if (entity instanceof EntityLivingBase) {
                entity.attackEntityFrom(DamageSource.GENERIC, 1);
            }
        }
        world.getEntitiesWithinAABB(EntityItem.class, extendBB);
        for (EntityItem entityItem : world.getEntitiesWithinAABB(EntityItem.class, extendBB)) {
            entityItem.attackEntityFrom(DamageSource.ON_FIRE, 10);
        }
    }

    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
        world.scheduleUpdate(pos, this, 5);
    }

    @Override
    public int tickRate(World worldIn) {
        return 5;
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
        detectInBB(pos, world);
        world.scheduleUpdate(pos, this, 5);
    }
}