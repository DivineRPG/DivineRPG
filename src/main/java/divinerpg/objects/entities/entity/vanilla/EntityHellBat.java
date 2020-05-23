package divinerpg.objects.entities.entity.vanilla;

import divinerpg.registry.LootTableRegistry;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityHellBat extends EntityBat
{
	public EntityHellBat(World worldIn) {
		super(worldIn);
		this.setHealth(this.getMaxHealth());
	}

	@Override
	protected ResourceLocation getLootTable()
	{
		return LootTableRegistry.ENTITIES_HELL_BAT;
	}

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.27D);
    }
    @Override
    public boolean getCanSpawnHere()
    {
        BlockPos blockpos = new BlockPos(this.posX, this.getEntityBoundingBox().minY, this.posZ);

        if (blockpos.getY() >= this.world.getSeaLevel())
        {
            return false;
        }
        else
        {
            int i = this.world.getLightFromNeighbors(blockpos);
            int j = 4;

           if (this.rand.nextBoolean())
            {
                return false;
            }
        
            return i > this.rand.nextInt(j);
        }
    }
}