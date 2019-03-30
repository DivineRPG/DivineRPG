package naturix.divinerpg.objects.entities.entity.vanilla;

import naturix.divinerpg.utils.Reference;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HellBat extends EntityBat
{
	public HellBat(World worldIn) {
		super(worldIn);
		this.setHealth(this.getMaxHealth());
	}
	public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/vanilla/hell_bat");
	private ResourceLocation deathLootTable = LOOT;
	@Override
	protected ResourceLocation getLootTable()
	{
		return this.LOOT;

	}
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.27D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
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