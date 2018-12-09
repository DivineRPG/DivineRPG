package naturix.divinerpg.entities.entity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneDiode;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityEMP extends EntityThrowable
{
    public static final float explosionPower = 0.75F;
    public static final int empRadius = 4;
 
    public EntityEMP(World world)
    {
        super(world);
    }
 
    public EntityEMP(World world, EntityLivingBase entity)
    {
        super(world, entity);
    }
 
    private void explode()
    {
        int bx = (int)posX;
        int by = (int)posY;
        int bz = (int)posZ;
        world.createExplosion(this, posX, posY, posZ, 0.75F, true);
 
        for (int x = bx - empRadius; x <= empRadius; x++)
        {
            for (int y = by - empRadius; y <= by + empRadius; y++)
            {
                for (int z = bz - empRadius; z <= bz + empRadius; z++)
                {
                	BlockPos pos = new BlockPos(x, y, z);
                    Block block = world.getBlockState(pos).getBlock();
                    if (block == Blocks.REDSTONE_WIRE || block instanceof BlockRedstoneDiode)
                    {
                        block.dropBlockAsItem(world, pos, world.getBlockState(pos), 0);
                        world.setBlockToAir(pos);
                    }
                    if (block == Blocks.REDSTONE_BLOCK)
                    {
                        world.setBlockState(pos, Blocks.STONE.getDefaultState());
                    }
                }
            }
        }
        setDead();
    }
    @Override
    public void onUpdate()
    {
        super.onUpdate();
        if (ticksExisted > 20)
        {
            explode();
        }
 
        for (int i = 0; i < 10; i++)
        {
            double x = (double)(rand.nextInt(10) - 5) / 8.0D;
            double y = (double)(rand.nextInt(10) - 5) / 8.0D;
            double z = (double)(rand.nextInt(10) - 5) / 8.0D;
        }
    }
 
    @Override
    protected float getGravityVelocity()
    {
        return 0.005F;
    }

	@Override
	protected void onImpact(RayTraceResult result) {
		explode();
	}
}